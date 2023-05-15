package ru.spring.MVC.dao;

import ru.spring.MVC.model.Car;

import java.util.List;

public interface CarDAO {
    public List<Car> index();
    public Car show(int id);
    public List<Car> list_cars();
    public void save(Car car);
    public List<Car> getCountCars(int count);
}
