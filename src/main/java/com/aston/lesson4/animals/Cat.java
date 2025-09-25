package com.aston.lesson4.animals;

public class Cat extends Animals {

  private static int catCount = 0;

  private boolean isFull;

  public Cat(String name) {
    super(name, 200, 0, false);
    this.isFull = false;
    catCount++;
  }

  public void eat(FoodBowl bowl, int amount) {
    if (bowl.eatFromBowl(amount)) {
      isFull = true;
      System.out.println(getName() + " поел(а) и теперь сыт(а)!");
    } else {
      System.out.println(getName() + " не смог(ла) поесть. Остался голодным.");
    }
  }

  public boolean isFull() {
    return isFull;
  }

  public static int getCatCount() {
    return catCount;
  }

}
