package com.aston.lesson2;


public class Product {

  private Long id;

  private String name;

  private String productionDate;

  private String manufacturer;

  private String countryOfOrigin;

  private Double price;

  private Integer quantity;

  private Boolean bookingStatus;

  public Product(Long id, String name, String productionDate, String manufacturer,
                 String countryOfOrigin, Double price, Integer quantity, Boolean bookingStatus) {
    this.id = id;
    this.name = name;
    this.productionDate = productionDate;
    this.manufacturer = manufacturer;
    this.countryOfOrigin = countryOfOrigin;
    this.price = price;
    this.quantity = quantity;
    this.bookingStatus = bookingStatus;
  }

  public void info() {
    System.out.println(
        "Порядковый номер: " + id + "\nName: " + name + "\nProduction Date: " + productionDate
            + "\nManufacturer: " + manufacturer + "\nCountry of Origin: " + countryOfOrigin
            + "\nPrice: " + price + "\nQuantity: " + quantity + "\nBooking Status: "
            + bookingStatus);
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

  public String getProductionDate() {
    return productionDate;
  }

  public void setProductionDate(String productionDate) {
    this.productionDate = productionDate;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getCountryOfOrigin() {
    return countryOfOrigin;
  }

  public void setCountryOfOrigin(String countryOfOrigin) {
    this.countryOfOrigin = countryOfOrigin;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Boolean getBookingStatus() {
    return bookingStatus;
  }

  public void setBookingStatus(Boolean bookingStatus) {
    this.bookingStatus = bookingStatus;
  }
}
