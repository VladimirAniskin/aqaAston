package com.aston.lesson4.geometricShapes;

public class Circle implements GeometricShape {

  private double radius;

  private String fillColor;

  private String borderColor;

  public Circle(double radius, String fillColor, String borderColor) {
    this.radius = radius;
    this.fillColor = fillColor;
    this.borderColor = borderColor;
  }

  @Override
  public double calculatePerimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String getFillColor() {
    return fillColor;
  }

  @Override
  public String getBorderColor() {
    return borderColor;
  }

  @Override
  public String getRussianName() {
    return "Круг";
  }

}
