package com.aston.lesson4.geometricShapes;

public interface GeometricShape {

  String getFillColor();

  String getBorderColor();

  String getRussianName();

  default double calculatePerimeter() {
    System.out.println("Периметр не определен для данной фигуры по умолчанию");
    return 0;
  }

  default double calculateArea() {
    System.out.println("Площадь не определена для данной фигуры по умолчанию");
    return 0;
  }


  default void displayInfo() {
    System.out.println("Фигура: " + getRussianName());
    System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()));
    System.out.println("Площадь: " + String.format("%.2f", calculateArea()));
    System.out.println("Цвет заливки: " + getFillColor());
    System.out.println("Цвет границ: " + getBorderColor());
    System.out.println("***************************");
  }

}
