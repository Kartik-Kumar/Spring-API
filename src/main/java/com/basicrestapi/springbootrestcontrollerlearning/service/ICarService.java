package com.basicrestapi.springbootrestcontrollerlearning.service;

import com.basicrestapi.springbootrestcontrollerlearning.model.Car;

import java.util.List;

public interface ICarService {

    List<Car> getAllCars();
    List<Car> getCarWithPriceFilter(Double min, Double max);
    Car getById(Long id);
    Car update(Long id, Car carRequest);
    Car create(Car car);
    void delete(Long id);
}
