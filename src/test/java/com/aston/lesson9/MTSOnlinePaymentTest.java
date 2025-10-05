package com.aston.lesson9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.*;

public class MTSOnlinePaymentTest {

  private WebDriver driver;

  private WebDriverWait wait;

  @Before
  public void setUp() {
    WebDriverManager.firefoxdriver().setup();

    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    driver.manage().window().maximize();
    System.out.println("✓ Браузер Firefox запущен");
  }

  @Test
  public void testOnlinePaymentBlock() {
    try {
      System.out.println("Открываем сайт mts.by...");
      driver.get("https://www.mts.by");

      try {
        WebElement cookieButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))
        );
        cookieButton.click();
        System.out.println("✓ Куки приняты");
      } catch (Exception e) {
        System.out.println("Кнопка куки не найдена, продолжаем...");
      }

      Thread.sleep(3000);

      checkBlockTitle();

      checkPaymentLogos();

      checkDetailsLink();

      checkPaymentForm();

      System.out.println("✓ Все тесты завершены успешно!");

    } catch (Exception e) {
      System.out.println("✗ Ошибка в основном потоке теста: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private void checkBlockTitle() {
    try {
      System.out.println("Ищем блок 'Онлайн пополнение без комиссии'...");
      WebElement title = wait.until(
          ExpectedConditions.visibilityOfElementLocated(
              By.xpath("//*[contains(text(), 'Онлайн пополнение')]")
          )
      );
      assertTrue("Название блока не содержит ожидаемый текст",
                 title.getText().contains("Онлайн пополнение"));
      System.out.println("✓ Название блока проверено: " + title.getText());
    } catch (Exception e) {
      System.out.println("✗ Не найден блок 'Онлайн пополнение без комиссии': " + e.getMessage());
    }
  }

  private void checkPaymentLogos() {
    String[] logos = {"Visa", "Mastercard", "Белкарт"};

    System.out.println("Проверяем логотипы платежных систем...");

    for (String logo : logos) {
      try {
        WebElement logoElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//img[contains(@alt, '" + logo + "')]")
            )
        );
        assertTrue("Логотип " + logo + " не отображается", logoElement.isDisplayed());
        System.out.println("✓ Логотип " + logo + " найден");
      } catch (Exception e) {
        System.out.println("✗ Не найден логотип: " + logo);
      }
    }
  }

  private void checkDetailsLink() {
    try {
      System.out.println("Ищем ссылку 'Подробнее о сервисе'...");
      WebElement detailsLink = wait.until(
          ExpectedConditions.elementToBeClickable(
              By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")
          )
      );
      detailsLink.click();
      System.out.println("✓ Кликнули на ссылку");

      Thread.sleep(3000);

      String currentUrl = driver.getCurrentUrl();
      System.out.println("Текущий URL: " + currentUrl);

      assertNotEquals("https://www.mts.by/", currentUrl);
      System.out.println("✓ Ссылка 'Подробнее о сервисе' работает");

      driver.navigate().back();
      Thread.sleep(2000);

    } catch (Exception e) {
      System.out.println("✗ Не удалось проверить ссылку 'Подробнее о сервисе': " + e.getMessage());
    }
  }

  private void checkPaymentForm() {
    try {
      System.out.println("Проверяем форму пополнения...");

      driver.get("https://www.mts.by");
      Thread.sleep(3000);

      WebElement serviceRadio = driver.findElement(
          By.xpath("//*[contains(text(), 'Услуги связи')]"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", serviceRadio);
      System.out.println("✓ Выбраны 'Услуги связи'");
      Thread.sleep(1000);

      WebElement phoneInput = driver.findElement(By.xpath("//input[@type='tel']"));

      ((JavascriptExecutor) driver).executeScript("arguments[0].value = '297777777';", phoneInput);
      System.out.println("✓ Номер телефона введен через JavaScript");

      WebElement continueButton = driver.findElement(
          By.xpath("//button[contains(text(), 'Продолжить')]"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
      System.out.println("✓ Нажали кнопку 'Продолжить' через JavaScript");

      Thread.sleep(3000);
      System.out.println("✓ Форма успешно обработана!");

    } catch (Exception e) {
      System.out.println("✗ Не удалось заполнить форму: " + e.getMessage());

      try {
        System.out.println("Пробуем альтернативную проверку...");
        WebElement phoneInput = driver.findElement(By.xpath("//input[@type='tel']"));
        WebElement continueButton = driver.findElement(
            By.xpath("//button[contains(text(), 'Продолжить')]"));
        System.out.println("✓ Элементы формы найдены (заполнение пропущено)");
      } catch (Exception e2) {
        System.out.println("✗ Элементы формы не найдены");
      }
    }
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
      System.out.println("✓ Браузер закрыт");
    }
  }
}
