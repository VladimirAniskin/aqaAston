package com.aston.lesson2;

public class Park {

  static class Attraction {

    private Long id;

    private String name;

    private String operatingMode;

    private Double price;

    public Attraction(Long id, String name, String operatingMode, Double price) {
      this.id = id;
      this.name = name;
      this.operatingMode = operatingMode;
      this.price = price;
    }


    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getOperatingMode() {
      return operatingMode;
    }

    public void setOperatingMode(String operatingMode) {
      this.operatingMode = operatingMode;
    }

    public Double getPrice() {
      return price;
    }

    public void setPrice(Double price) {
      this.price = price;
    }

    public void info() {
      System.out.println(
          "Порядковый номер: " + id + "\nName: " + name + "\nOperating Mode: " + operatingMode
              + "\nPrice: " + price);
    }

  }

}
