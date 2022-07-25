package com.basicrestapi.springbootrestcontrollerlearning.service;

import com.basicrestapi.springbootrestcontrollerlearning.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarService implements ICarService {

    private List<Car> cars = new ArrayList<>(
            Arrays.asList(
                    new Car(1L, "Astra", "Opel", 100, 18000d),
                    new Car(2L, "Insgnia", "Opel", 120, 22000d),
                    new Car(3L, "GOlf", "VM", 90, 17000d)
            )
    );

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getCarWithPriceFilter(Double min, Double max) {
        return cars.stream()
                .filter(car -> car.getPrices() >= min && car.getPrices() <= max)
                .toList();
    }

    @Override
    public Car getById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findAny()
                .orElseThrow();
    }

    @Override
    public Car update(Long id, Car carRequest) {
        Car carTobeUpdated = getById(id);
        carTobeUpdated.setBrand(carRequest.getBrand());
        carTobeUpdated.setHorses(carRequest.getHorses());
        carTobeUpdated.setModel(carRequest.getModel());
        carTobeUpdated.setPrices(carRequest.getPrices());
        return carTobeUpdated;
    }

    @Override
    public Car create(Car car) {
        Long newId = cars.stream().mapToLong(car_ -> Long.valueOf(car_.getId())).max().orElse(0L) + 1L;
        car.setId(newId);
        cars.add(car);
        return getById(car.getId());
    }

    @Override
    public void delete(Long id) {
        boolean successfulDeletion = cars.removeIf(car -> car.getId().equals(id));
        if(!successfulDeletion) {
            throw new NoSuchElementException();
        }
    }
}
