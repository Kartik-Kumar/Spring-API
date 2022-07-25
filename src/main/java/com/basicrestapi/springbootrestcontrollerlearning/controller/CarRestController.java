package com.basicrestapi.springbootrestcontrollerlearning.controller;

import com.basicrestapi.springbootrestcontrollerlearning.model.Car;
import com.basicrestapi.springbootrestcontrollerlearning.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAllCars();
    }

//    http:localhost:8080/cars
//    http:localhost:8080/cars?minPrice=10000
//    http:localhost:8080/cars?minPrice=12000&maxPrice=20000
//    http:localhost:8080/cars?maxPrice=20000
    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllCarsWithPriceFilter(@RequestParam(required = false) @Positive Double minPrice, @RequestParam(required = false) @Positive Double maxPrice) {
        return carService.getCarWithPriceFilter(minPrice, maxPrice);
    }

//    http:localhost:8080/cars/1
//    http:localhost:8080/cars/2
//    http:localhost:8080/cars/hello
    @GetMapping("/{id}")
    public Car getById(@PathVariable @Positive Long id) {
        return carService.getById(id);
    }

    @PostMapping
    public Car create(@Valid @RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping("/{id}")
    public Car update(@RequestBody Car car, @PathVariable @Positive Long id) {
        return carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    public void delete(@Positive @PathVariable Long id) {
        carService.delete(id);
    }
}
