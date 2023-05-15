package ru.spring.mvc.servic;

import org.springframework.stereotype.Service;
import ru.spring.mvc.dao.CarDAO;
import ru.spring.mvc.model.Car;
import ru.spring.mvc.dao.CarDAO;
import ru.spring.mvc.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarServic{

    private CarDAO carDAO;

    public CarServiceImp(CarDAO carDAO){
        this.carDAO=carDAO;
    }


    @Override
    public List<Car> index() {
        return carDAO.index();
    }

    @Override
    public Car show(int id) {
        return carDAO.show(id);
    }

    @Override
    public List<Car> list_cars() {
        return carDAO.list_cars();
    }

    @Override
    public void save(Car car) {
        carDAO.save(car);
    }

    @Override
    public List<Car> getCountCars(int count) {
        return carDAO.getCountCars(count);
    }
}
