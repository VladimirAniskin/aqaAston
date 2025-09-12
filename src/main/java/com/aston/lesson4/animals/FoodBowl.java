package com.aston.lesson4.animals;

public class FoodBowl {

  private int foodAmount;

  public FoodBowl(int initialFood) {
    this.foodAmount = Math.max(initialFood, 0);
  }

  public boolean eatFromBowl(int amount) {
    if (amount <= 0) {
      System.out.println("Нельзя взять отрицательное количество еды!");
      return false;
    }
    if (foodAmount >= amount) {
      foodAmount -= amount;
      System.out.println("Взято " + amount + " еды из миски. Осталось: " + foodAmount);
      return true;
    } else {
      System.out.println(
          "Недостаточно еды в миске! Нужно: " + amount + ", доступно: " + foodAmount);
      return false;
    }
  }

  public void addFood(int amount) {
    if (amount > 0) {
      foodAmount += amount;
      System.out.println("Добавлено " + amount + " еды в миску. Теперь: " + foodAmount);
    } else {
      System.out.println("Нельзя добавить отрицательное количество еды!");
    }
  }

  public int getFoodAmount() {
    return foodAmount;
  }

}
