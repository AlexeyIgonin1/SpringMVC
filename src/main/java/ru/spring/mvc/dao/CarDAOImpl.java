package ru.spring.mvc.dao;

import org.springframework.stereotype.Repository;
import ru.spring.mvc.model.Car;
import ru.spring.mvc.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDAOImpl implements CarDAO{

    private List<Car> cars_2;
    private static int CARS_COUNT;

    {
        cars_2=new ArrayList<>();
        cars_2.add(new Car(++CARS_COUNT, "BMV", "black", 3000));
        cars_2.add(new Car(++CARS_COUNT, "OPEL", "red", 2000));
        cars_2.add(new Car(++CARS_COUNT, "KIA", "white", 1500));
        cars_2.add(new Car(++CARS_COUNT, "LADA", "green", 1200));
        cars_2.add(new Car(++CARS_COUNT, "MERCEDES", "black", 50000));
    }


    @Override
    public List<Car> index(){
        return cars_2;
    }
    @Override
    public Car show(int id){
        return cars_2.stream().filter(car -> car.getId()==id).findAny().orElse(null);
    }
    @Override
    public void save(Car car){
        car.setId(++CARS_COUNT);
        cars_2.add(car);

    }

    @Override
    public List<Car> list_cars(){
        return cars_2;
    }


    @Override
    public List<Car> getCountCars(int count) {
        if (count == 0) {
            return cars_2;
        }
        return cars_2.stream().limit(count).collect(Collectors.toList());
    }



}
