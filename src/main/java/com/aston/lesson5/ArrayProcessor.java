package com.aston.lesson5;

import com.aston.lesson5.exeption.MyArrayDataException;
import com.aston.lesson5.exeption.MyArraySizeException;

public class ArrayProcessor {

  public static int processArray(String[][] array)
      throws MyArraySizeException, MyArrayDataException {
    if (array.length != 4) {
      throw new MyArraySizeException(
          "Неверное количество строк. Ожидается: 4, получено: " + array.length);
    }

    for (int i = 0; i < array.length; i++) {
      if (array[i].length != 4) {
        throw new MyArraySizeException("Неверное количество столбцов в строке " + i +
                                           ". Ожидается: 4, получено: " + array[i].length);
      }
    }

    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        try {
          sum += Integer.parseInt(array[i][j]);
        } catch (NumberFormatException e) {
          throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" +
                                             array[i][j] + "' не является числом");
        }
      }
    }

    return sum;
  }


  public static void demonstrateArrayIndexOutOfBounds() {
    System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");

    int[] array = {1, 2, 3, 4, 5};

    try {
      System.out.println("Попытка доступа к array[10]: " + array[10]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
      System.out.println("Размер массива: " + array.length);
      System.out.println("Максимальный допустимый индекс: " + (array.length - 1));
    }

    try {
      System.out.println("Попытка доступа к array[-1]: " + array[-1]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
      System.out.println("Отрицательные индексы недопустимы!");
    }

  }
}