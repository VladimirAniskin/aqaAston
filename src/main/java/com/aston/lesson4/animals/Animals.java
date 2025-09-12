package com.aston.lesson4.animals;

public class Animals {

  private static int animalCount = 0;

  private String name;

  private int maxRunDistance;

  private int maxSwimDistance;

  protected boolean canSwim;

  public Animals(String name, int maxRunDistance, int maxSwimDistance, boolean canSwim) {
    this.name = name;
    this.maxRunDistance = maxRunDistance;
    this.maxSwimDistance = maxSwimDistance;
    this.canSwim = canSwim;
    animalCount++;
  }

  public void run(int distance) {
    if (distance <= maxRunDistance) {
      System.out.println(name + " пробежал(а) " + distance + " м.");
    } else {
      System.out.println(
          name + " не может пробежать " + distance + " м. Максимум: " + maxRunDistance + " м.");
    }
  }

  public void swim(int distance) {
    if (!canSwim) {
      System.out.println(name + " не умеет плавать!");
      return;
    }
    if (distance <= maxSwimDistance) {
      System.out.println(name + " проплыл(а) " + distance + " м.");
    } else {
      System.out.println(
          name + " не может проплыть " + distance + " м. Максимум: " + maxSwimDistance + " м.");
    }
  }

  public static int getAnimalCount() {
    return animalCount;
  }

  public String getName() {
    return name;
  }
}


