package ru.spring.mvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.mvc.model.Car;
import ru.spring.mvc.servic.CarServic;
import ru.spring.mvc.model.Car;
import ru.spring.mvc.servic.CarServic;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private CarServic carServic;
    @Autowired
    public CarsController(CarServic carService){
        this.carServic = carService;
    }

    @GetMapping()
    public String index(Model model){
        //Список всех машин
        model.addAttribute("carsList", carServic.list_cars());
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //Получим машину по ее id
        model.addAttribute("car",carServic.show(id));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("car_model") Car car) {
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car_model") Car car) {
        carServic.save(car);
        return "redirect:cars/table";
    }

    @GetMapping("/table")
    public String taib_cars(Model model){
        //Список всех машин
        model.addAttribute("cars", carServic.list_cars());
        return "cars/table";
    }

    @GetMapping("/list/{count}")
    public String listCount(@PathVariable("count") int count, Model model){
        //Список всех машин
        model.addAttribute("cars", carServic.getCountCars(count));
        return "cars/listCount";
    }

}
