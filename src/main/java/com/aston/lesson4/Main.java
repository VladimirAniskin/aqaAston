package com.aston.lesson4;

import com.aston.lesson4.animals.Animals;
import com.aston.lesson4.animals.Cat;
import com.aston.lesson4.animals.Dog;
import com.aston.lesson4.animals.FoodBowl;
import com.aston.lesson4.geometricShapes.Circle;
import com.aston.lesson4.geometricShapes.GeometricShape;
import com.aston.lesson4.geometricShapes.Rectangle;
import com.aston.lesson4.geometricShapes.Square;
import com.aston.lesson4.geometricShapes.Triangle;

public class Main {

  public static void main(String[] args) {

    System.out.println("=== Животные ===\n");
    // Создаем животных
    Cat cat1 = new Cat("Барсик");
    Cat cat2 = new Cat("Мурка");
    Cat cat3 = new Cat("Васька");

    Dog dog1 = new Dog("Бобик");
    Dog dog2 = new Dog("Шарик");

    // бег и плавание
    System.out.println("=== бег и плавание ===");
    cat1.run(150);
    cat1.run(250);
    cat1.swim(5);

    dog1.run(400);
    dog1.swim(8);
    dog1.swim(15);

    // Создаем миску с едой и массив котов
    System.out.println("\n===  Кормление котов ===");
    FoodBowl bowl = new FoodBowl(20);
    Cat[] cats = {cat1, cat2, cat3};

    // Кормим котов
    for (Cat cat : cats) {
      cat.eat(bowl, 8);
    }

    // Проверяем сытость котов
    System.out.println("\n=== Состояние сытости котов ===");
    for (Cat cat : cats) {
      System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
    }

    // Добавляем еду в миску и кормим снова
    System.out.println("\n=== Добавляем еду и кормим снова ===");
    bowl.addFood(15);

    for (Cat cat : cats) {
      if (!cat.isFull()) {
        cat.eat(bowl, 8);
      }
    }

    // Выводим статистику
    System.out.println("\n=== Статистика животных ===");
    System.out.println("Всего животных: " + Animals.getAnimalCount());
    System.out.println("Котов: " + Cat.getCatCount());
    System.out.println("Собак: " + Dog.getDogCount());
    System.out.println("Еды в миске осталось: " + bowl.getFoodAmount());

    System.out.println("=== КАЛЬКУЛЯТОР ГЕОМЕТРИЧЕСКИХ ФИГУР ===\n");

    // Создаем различные фигуры
    GeometricShape circle = new Circle(5.0, "Красный", "Черный");
    GeometricShape rectangle = new Rectangle(4.0, 6.0,
                                             "Синий", "Белый");
    GeometricShape triangle = new Triangle(3.0, 4.0, 5.0,
                                           "Зеленый", "Желтый");
    GeometricShape square = new Square(5.0, "Розовый", "Фиолетовый");

    // Выводим информацию о фигурах
    circle.displayInfo();
    rectangle.displayInfo();
    triangle.displayInfo();
    square.displayInfo();

    // Дополнительные примеры
    System.out.println("=== ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ ===\n");

    GeometricShape bigCircle = new Circle(10.0, "Оранжевый", "Коричневый");
    GeometricShape equilateralTriangle = new Triangle(6.0, 6.0,
                                                      6.0, "Голубой",
                                                      "Серый");

    bigCircle.displayInfo();
    equilateralTriangle.displayInfo();
  }
}
