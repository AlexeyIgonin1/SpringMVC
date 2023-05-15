package ru.spring.mvc.dao;

import ru.spring.mvc.model.Car;
import ru.spring.mvc.model.Car;

import java.util.List;

public interface CarDAO {
    public List<Car> index();
    public Car show(int id);
    public List<Car> list_cars();
    public void save(Car car);
    public List<Car> getCountCars(int count);
}
