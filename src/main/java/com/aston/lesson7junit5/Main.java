package com.aston.lesson7junit5;

import java.util.Scanner;

public class Main {

  public static void factorialProgram() {
    System.out.println("=== ВЫЧИСЛЕНИЕ ФАКТОРИАЛА ===");
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите целое неотрицательное число: ");
    int number = scanner.nextInt();

    if (number < 0) {
      System.out.println("Факториал определен только для неотрицательных чисел!");
      return;
    }

    long factorial = 1;
    for (int i = 1; i <= number; i++) {
      factorial *= i;
    }

    System.out.println(number + "! = " + factorial);
  }


  public static void triangleAreaProgram() {
    System.out.println("\n=== ВЫЧИСЛЕНИЕ ПЛОЩАДИ ТРЕУГОЛЬНИКА ===");
    Scanner scanner = new Scanner(System.in);

    System.out.println("Выберите способ расчета:");
    System.out.println("1 - По основанию и высоте");
    System.out.println("2 - По трем сторонам (формула Герона)");
    System.out.print("Ваш выбор: ");

    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        System.out.print("Введите основание треугольника: ");
        double base = scanner.nextDouble();
        System.out.print("Введите высоту треугольника: ");
        double height = scanner.nextDouble();

        if (base <= 0 || height <= 0) {
          System.out.println("Основание и высота должны быть положительными числами!");
          return;
        }

        double area1 = 0.5 * base * height;
        System.out.printf("Площадь треугольника: %.2f\n", area1);
        break;

      case 2:
        System.out.print("Введите сторону a: ");
        double a = scanner.nextDouble();
        System.out.print("Введите сторону b: ");
        double b = scanner.nextDouble();
        System.out.print("Введите сторону c: ");
        double c = scanner.nextDouble();

        if (a <= 0 || b <= 0 || c <= 0) {
          System.out.println("Стороны должны быть положительными числами!");
          return;
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
          System.out.println("Треугольник с такими сторонами не существует!");
          return;
        }

        double p = (a + b + c) / 2;
        double area2 = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.printf("Площадь треугольника: %.2f\n", area2);
        break;

      default:
        System.out.println("Неверный выбор!");
    }
  }


  public static void arithmeticProgram() {
    System.out.println("\n=== АРИФМЕТИЧЕСКИЕ ДЕЙСТВИЯ ===");
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите первое число: ");
    int num1 = scanner.nextInt();
    System.out.print("Введите второе число: ");
    int num2 = scanner.nextInt();

    System.out.println("Выберите операцию:");
    System.out.println("+ - Сложение");
    System.out.println("- - Вычитание");
    System.out.println("* - Умножение");
    System.out.println("/ - Деление");
    System.out.print("Ваш выбор: ");

    String operation = scanner.next();

    switch (operation) {
      case "+":
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        break;
      case "-":
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        break;
      case "*":
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        break;
      case "/":
        if (num2 == 0) {
          System.out.println("Ошибка: деление на ноль!");
        } else {
          System.out.println(num1 + " / " + num2 + " = " + ((double) num1 / num2));
        }
        break;
      default:
        System.out.println("Неверная операция!");
    }
  }


  public static void comparisonProgram() {
    System.out.println("\n=== СРАВНЕНИЕ ДВУХ ЧИСЕЛ ===");
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите первое число: ");
    int num1 = scanner.nextInt();
    System.out.print("Введите второе число: ");
    int num2 = scanner.nextInt();

    System.out.println("Результаты сравнения:");

    if (num1 == num2) {
      System.out.println(num1 + " равно " + num2);
    } else {
      System.out.println(num1 + " не равно " + num2);
    }

    if (num1 > num2) {
      System.out.println(num1 + " больше " + num2);
    } else if (num1 < num2) {
      System.out.println(num1 + " меньше " + num2);
    }

    System.out.println(num1 + " >= " + num2 + ": " + (num1 >= num2));
    System.out.println(num1 + " <= " + num2 + ": " + (num1 <= num2));
    System.out.println(num1 + " > " + num2 + ": " + (num1 > num2));
    System.out.println(num1 + " < " + num2 + ": " + (num1 < num2));
  }


  public static void mainMenu() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
      System.out.println("1 - Вычисление факториала");
      System.out.println("2 - Площадь треугольника");
      System.out.println("3 - Арифметические действия");
      System.out.println("4 - Сравнение чисел");
      System.out.println("0 - Выход");
      System.out.print("Выберите программу: ");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          factorialProgram();
          break;
        case 2:
          triangleAreaProgram();
          break;
        case 3:
          arithmeticProgram();
          break;
        case 4:
          comparisonProgram();
          break;
        case 0:
          System.out.println("До свидания!");
          return;
        default:
          System.out.println("Неверный выбор!");
      }

      System.out.print("\nНажмите Enter для продолжения...");
      scanner.nextLine();
      scanner.nextLine();
    }
  }


  public static void main(String[] args) {
    mainMenu();
  }
}
