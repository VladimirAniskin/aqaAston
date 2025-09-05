package com.aston.lesson1;


import java.util.Random;

public class MainLessonOne {

  static Random random = new Random();

  static int s = random.nextInt(201) - 100;

  public static void main(String[] args) {
    System.out.println("*************1**********");
    printThreeWords();
    System.out.println("************2***********");
    checkSumSign();
    System.out.println("************3***********");
    printColor();
    System.out.println("************4***********");
    compareNumbers();
    System.out.println("*************5**********");
    boolean b = sumInRange(s, s);
    System.out.println(b);
    System.out.println("************6**********");
    checkNumberSign(s);
    System.out.println("*************7**********");
    boolean c = isNeg(s);
    System.out.println(c);
    System.out.println("************8***********");
    repeatPrint("Евгения", s);
    System.out.println("************9***********");
    int randomYear = generateRandomYear(1900, 2024);
    System.out.println("Случайный год: " + randomYear);
    System.out.println(isLeapYearShort(randomYear));
    System.out.println("**************10*********");
    int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    System.out.println("Исходный массив:");
    for (int j : array) {
      System.out.print(j);
    }
    invertBinaryValues(array);
    System.out.println("\n");
    System.out.println("Инвертированный массив:");
    for (int j : array) {
      System.out.print(j);
    }
    System.out.println("\n");
    System.out.println("*************11**********");
    int[] hundredArray = new int[100];
    fillArrayTo(hundredArray);
    System.out.println("Массив от 1 до 100: ");
    for (int j : hundredArray) {
      System.out.print(" " + j);
    }
    System.out.println("\n");
    System.out.println("*************12**********");
    int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    System.out.println("Исходный массив: ");
    for (int j : numbers) {
      System.out.print(" " + j);}
      System.out.println("\n");
    multiplyLessThan6(numbers);
    System.out.println("После умножения чисел < 6 на 2: ");
    for (int j : numbers) {
      System.out.print(" " + j);}
      System.out.println("\n");

    System.out.println("*************13**********");
    System.out.println("\nМатрица 5x5 с главной диагональю:");
    int[][] matrix5x5 = createBothDiagonalsMatrix(5);
    printMatrix(matrix5x5);
    System.out.println("************14***********");
    if (s > 0) {
      int[] arrayNew = createArray(s, s);
      for (int j : arrayNew) {
        System.out.print(" " + j);
      }
      System.out.println("\n");
    } else {
      int[] arrayNew = createArray(5, s);
      for (int j : arrayNew) {
        System.out.print(" " + j);
      }
    }


  }

  public static void printThreeWords() {
    System.out.println("Orange\n" + "Banana\n" + "Apple\n");
  }

  public static void checkSumSign() {
    int a, b, c;
    a = s;
    b = s;
    c = a + b;
    if (c >= 0) {
      System.out.println("Сумма положительная: " + c);
    } else {
      System.out.println("Сумма отрицательная: " + c);
    }
  }

  public static void printColor() {
    int value = s;
    if (value <= 0) {
      System.out.println("Красный");
    }
    if (0 < value && value <= 100) {
      System.out.println("Желтый");
    }
    if (value > 100) {
      System.out.println("Зеленый");
    }
  }

  public static void compareNumbers() {
    int a = s;
    int b = s;
    if (a >= b) {
      System.out.println("a >= b");
    } else {
      System.out.println("a < b");
    }
  }

  public static boolean sumInRange(int numOn, int numTwo) {
    int sum = numOn + numTwo;
    return sum >= 10 && sum <= 20;
  }

  public static void checkNumberSign(int num) {
    if (num >= 0) {
      System.out.println("Передано положительное число");
    } else {
      System.out.println("Передано отрицательное число");
    }
  }

  public static boolean isNeg(int number) {
    return number < 0;
  }

  public static void repeatPrint(String text, int count) {
    if (count > 0) {
      for (int i = 0; i < count; i++) {
        System.out.println(text);
      }
    } else {
      for (int i = 0; i < 5; i++) {
        System.out.println(text);
      }
    }
  }

  public static int generateRandomYear(int minYear, int maxYear) {

    return random.nextInt(maxYear - minYear + 1) + minYear;
  }

  public static boolean isLeapYearShort(int year) {
    return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
  }

  public static void invertBinaryValues(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) {
        array[i] = 1;
      } else {
        array[i] = 0;
      }
    }
  }

  public static void fillArrayTo(int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = i + 1;
    }
  }


  public static int[][] createBothDiagonalsMatrix(int size) {
    int[][] matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == j || i + j == size - 1) {
          matrix[i][j] = 1;
        } else {
          matrix[i][j] = 0;
        }
      }
    }
    return matrix;
  }

  public static void multiplyLessThan6(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] < 6) {
        array[i] *= 2;
      }
    }
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[] createArray(int len, int initialValue) {
    int[] array = new int[len];
    for (int i = 0; i < len; i++) {
      array[i] = initialValue;
    }
    return array;
  }

}
