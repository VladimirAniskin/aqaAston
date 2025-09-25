package com.aston.lesson5;

import static com.aston.lesson5.ArrayProcessor.demonstrateArrayIndexOutOfBounds;
import static com.aston.lesson5.ArrayProcessor.processArray;

import com.aston.lesson5.exeption.MyArrayDataException;
import com.aston.lesson5.exeption.MyArraySizeException;

public class Main {

  public static void main(String[] args) {

    String[][] correctArray = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", "16"}
    };

    String[][] wrongSizeArray = {
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"}
    };

    String[][] wrongDataArray = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "abc", "12"},
        {"13", "14", "15", "16"}
    };

    String[][] anotherWrongDataArray = {
        {"1", "2", "3", "4"},
        {"5", "6", "7.5", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", "16"}
    };

    // Обработка правильного массива
    System.out.println("=== Обработка правильного массива ===");
    try {
      int result = processArray(correctArray);
      System.out.println("Сумма элементов: " + result);
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println("Ошибка: " + e.getMessage());
    }

    // Обработка массива с неверным размером
    System.out.println("\n=== Обработка массива с неверным размером ===");
    try {
      int result = processArray(wrongSizeArray);
      System.out.println("Сумма элементов: " + result);
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println("Ошибка: " + e.getMessage());
    }

    // Обработка массива с неверными данными
    System.out.println("\n=== Обработка массива с неверными данными ===");
    try {
      int result = processArray(wrongDataArray);
      System.out.println("Сумма элементов: " + result);
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println("Ошибка: " + e.getMessage());
    }

    // Обработка другого массива с неверными данными
    System.out.println("\n=== Обработка другого массива с неверными данными ===");
    try {
      int result = processArray(anotherWrongDataArray);
      System.out.println("Сумма элементов: " + result);
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println("Ошибка: " + e.getMessage());
    }

    // Демонстрация ArrayIndexOutOfBoundsException
    demonstrateArrayIndexOutOfBounds();

    // Дополнительный тест с граничными случаями
    System.out.println("\n=== Дополнительные тесты ===");
    String[][] edgeCaseArray = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", "9999999999"}
    };

    try {
      int result = processArray(edgeCaseArray);
      System.out.println("Сумма элементов: " + result);
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println("Ошибка: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("NumberFormatException: " + e.getMessage());
    }
  }

}
