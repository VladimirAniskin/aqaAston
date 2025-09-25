package com.aston.lesson2;

import com.aston.lesson2.Park.Attraction;

public class MainLessonTwo {

  public static void main(String[] args) {
    Product[] productsArray = new Product[5];
    productsArray[0] = new Product(1L, "Lada 2109", "12.12.1990", "Avtovaz", "Russia", 1336584.44,
                                   2, true);
    productsArray[1] = new Product(2L, "Ranger 200", "01.02.2025", "Minsk", "Belarus", 136000.14,
                                   20, true);
    productsArray[2] = new Product(3L, "Lada Granta", "24.01.2025", "Avtovaz", "Russia", 630453.78,
                                   12, false);
    productsArray[3] = new Product(4L, "Maz 6312B9", "23.03.2024", "Maz", "Belarus", 4336587.98, 2,
                                   true);
    productsArray[4] = new Product(5L, "Lada Niva", "23.12.1991", "Avtovaz", "Russia", 1446584.44,
                                   2, true);

    System.out.println("=== ИНФОРМАЦИЯ О  Продуктах ===");
    for (Product product : productsArray) {
      System.out.println("***************************");
      product.info();
    }
    Attraction[] attractionsArray = new Attraction[3];
    attractionsArray[0] = new Attraction(1L, "Американские горки",
                                         "10.00 - 20.00",
                                         350.0);

    attractionsArray[1] = new Attraction(2L, "Колесо обозрения",
                                         "10.00 - 20.00",
                                         250.0);

    attractionsArray[2] = new Attraction(3L, "Детские качели",
                                         "10.00 - 20.00",
                                         150.0);

    System.out.println("=== ИНФОРМАЦИЯ ОБ АТТРАКЦИОНАХ ПАРКА ===");
    for (Park.Attraction attraction : attractionsArray) {
      attraction.info();
    }


  }
}
