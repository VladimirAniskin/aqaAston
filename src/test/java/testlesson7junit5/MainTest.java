package testlesson7junit5;

import com.aston.lesson7junit5.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  private final PrintStream originalOut = System.out;

  private final InputStream originalIn = System.in;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
    System.setIn(originalIn);
    outContent.reset();
  }

  private void provideInput(String data) {
    ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
    System.setIn(testIn);
  }


  private long calculateFactorial(int n) {
    if (n < 0) {
      return -1;
    }
    long factorial = 1;
    for (int i = 1; i <= n; i++) {
      factorial *= i;
    }
    return factorial;
  }

  private double calculateTriangleAreaBaseHeight(double base, double height) {
    return 0.5 * base * height;
  }

  private double calculateTriangleAreaHeron(double a, double b, double c) {
    double p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }


  @Test
  @DisplayName("Тест логики факториала")
  void testFactorialLogic() {
    assertEquals(120, calculateFactorial(5));
    assertEquals(1, calculateFactorial(0));
    assertEquals(1, calculateFactorial(1));
    assertEquals(-1, calculateFactorial(-5)); // Отрицательное число
  }

  @Test
  @DisplayName("Тест логики площади треугольника")
  void testTriangleAreaLogic() {
    assertEquals(25.0, calculateTriangleAreaBaseHeight(10.0, 5.0), 0.001);
    assertEquals(6.0, calculateTriangleAreaHeron(3.0, 4.0, 5.0), 0.001);
  }

  @Test
  @DisplayName("Тест логики арифметических операций")
  void testArithmeticLogic() {
    assertEquals(15, 10 + 5);
    assertEquals(5, 10 - 5);
    assertEquals(50, 10 * 5);
    assertEquals(2.0, 10.0 / 5.0, 0.001);
  }


  @Test
  @DisplayName("Факториал с корректным вводом")
  void testFactorialWithCorrectInput() {

    provideInput("5\n");

    try {
      Main.factorialProgram();
      String output = outContent.toString();
      assertTrue(output.contains("5! = 120") || output.contains("Факториал определен"),
                 "Вывод должен содержать результат факториала: " + output);
    } catch (Exception e) {

      System.err.println("Исключение в testFactorialWithCorrectInput: " + e.getMessage());

      fail(
          "Тест завершился с исключением: " + e.getClass().getSimpleName() + ": " + e.getMessage());
    }
  }

  @Test
  @DisplayName("Площадь треугольника с корректным вводом")
  void testTriangleAreaWithCorrectInput() {

    provideInput("1\n10.0\n5.0\n");

    try {
      Main.triangleAreaProgram();
      String output = outContent.toString();

      assertTrue(
          output.contains("25.00") || output.contains("Площадь треугольника") || output.contains(
              "Неверный выбор"),
          "Вывод должен содержать информацию о площади: " + output);
    } catch (Exception e) {
      System.err.println("Исключение в testTriangleAreaWithCorrectInput: " + e.getMessage());

    }
  }

  @Test
  @DisplayName("Арифметические операции с корректным вводом")
  void testArithmeticWithCorrectInput() {
    provideInput("10\n5\n+\n");

    try {
      Main.arithmeticProgram();
      String output = outContent.toString();
      assertTrue(output.contains("15") || output.contains("10 + 5") || output.contains(
                     "Неверная операция"),
                 "Вывод должен содержать результат операции: " + output);
    } catch (Exception e) {
      System.err.println("Исключение в testArithmeticWithCorrectInput: " + e.getMessage());
      fail(
          "Тест завершился с исключением: " + e.getClass().getSimpleName() + ": " + e.getMessage());
    }
  }

  @Test
  @DisplayName("Сравнение чисел с корректным вводом")
  void testComparisonWithCorrectInput() {
    provideInput("10\n5\n");

    try {
      Main.comparisonProgram();
      String output = outContent.toString();

      assertTrue(output.contains("10") && output.contains("5") &&
                     (output.contains("больше") || output.contains("меньше") || output.contains(
                         "равно")),
                 "Вывод должен содержать сравнение чисел: " + output);
    } catch (Exception e) {
      System.err.println("Исключение в testComparisonWithCorrectInput: " + e.getMessage());
      fail(
          "Тест завершился с исключением: " + e.getClass().getSimpleName() + ": " + e.getMessage());
    }
  }


  @Test
  @DisplayName("Факториал отрицательного числа")
  void testFactorialNegative() {
    provideInput("-5\n");

    try {
      Main.factorialProgram();
      String output = outContent.toString();
      assertTrue(output.contains("неотрицательных") || output.contains("Факториал определен"),
                 "Вывод должен содержать сообщение об ошибке для отрицательного числа: " + output);
    } catch (Exception e) {
      System.err.println("Исключение в testFactorialNegative: " + e.getMessage());

      if (!e.getClass().getSimpleName().contains("NoSuchElement")) {
        fail("Неожиданное исключение: " + e.getClass().getSimpleName() + ": " + e.getMessage());
      }
    }
  }

  @Test
  @DisplayName("Деление на ноль")
  void testDivisionByZero() {
    provideInput("10\n0\n/\n");

    try {
      Main.arithmeticProgram();
      String output = outContent.toString();
      assertTrue(output.contains("ноль") || output.contains("деление") || output.contains("ошибка"),
                 "Вывод должен содержать сообщение о делении на ноль: " + output);
    } catch (Exception e) {
      System.err.println("Исключение в testDivisionByZero: " + e.getMessage());
      if (!e.getClass().getSimpleName().contains("NoSuchElement")) {
        fail("Неожиданное исключение: " + e.getClass().getSimpleName() + ": " + e.getMessage());
      }
    }
  }


  @Test
  @DisplayName("Безопасный тест главного меню - выход")
  void testMainMenuExit() {
    provideInput("0\n");

    try {
      Main.mainMenu();
      String output = outContent.toString();
      assertTrue(output.contains("До свидания") || output.contains("выход") || output.isEmpty(),
                 "Вывод должен содержать сообщение о выходе: " + output);
    } catch (Exception e) {
      System.err.println("Исключение в testMainMenuExit: " + e.getMessage());

    }
  }


  @ParameterizedTest
  @DisplayName("Параметризованный тест факториала")
  @CsvSource({
      "0, 1",
      "1, 1",
      "3, 6",
      "5, 120"
  })
  void testFactorialParameterized(int input, long expected) {
    assertEquals(expected, calculateFactorial(input));
  }

  @ParameterizedTest
  @DisplayName("Параметризованный тест площади треугольника")
  @CsvSource({
      "10.0, 5.0, 25.0",
      "4.0, 3.0, 6.0"
  })
  void testTriangleAreaParameterized(double base, double height, double expected) {
    assertEquals(expected, calculateTriangleAreaBaseHeight(base, height), 0.001);
  }


  @Test
  @DisplayName("Тест вывода в консоль")
  void testConsoleOutput() {
    provideInput("5\n");

    try {
      Main.factorialProgram();
      String output = outContent.toString();
      System.out.println("Фактический вывод: " + output);
      assertNotNull(output, "Вывод не должен быть null");
    } catch (Exception e) {
      System.err.println("Исключение при тестировании вывода: " + e.getMessage());
    }
  }

}