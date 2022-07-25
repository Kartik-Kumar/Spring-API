package com.basicrestapi.springbootrestcontrollerlearning.model;

import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class Car {

    private Long id;
    private String model;
    private String brand;
    private Integer horses;
    private Double prices;

     public Car() {
     }

     public Car(Long id, String model, String brand, Integer horses, Double price) {
         this.id = id;
         this.model = model;
         this.brand = brand;
         this.horses = horses;
         this.prices = price;
     }

    public Long getId() {
        return id;
    }

    @NotNull(message = " Model must not be null")
    @NotEmpty(message = "Model must have value")
    public String getModel() {
        return model;
    }

    @NotNull(message = "Brand must not be null")
    @NotEmpty(message = "Brand must have value")
    public String getBrand() {
        return brand;
    }

    @NotNull(message = "Horses must not be null")
    @Positive
    public Integer getHorses() {
        return horses;
    }

    @NotNull(message = "Prices must not be null")
    @Positive
    public Double getPrices() {
        return prices;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHorses(Integer horses) {
        this.horses = horses;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(model, car.model) && Objects.equals(brand, car.brand) && Objects.equals(horses, car.horses) && Objects.equals(prices, car.prices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, horses, prices);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", horses=" + horses +
                ", prices=" + prices +
                '}';
    }
}
