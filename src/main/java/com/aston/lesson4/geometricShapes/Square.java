package com.aston.lesson4.geometricShapes;

public class Square extends Rectangle {

  public Square(double side, String fillColor, String borderColor) {
    super(side, side, fillColor, borderColor);
  }

  @Override
  public String getRussianName() {
    return "Квадрат";
  }
}
