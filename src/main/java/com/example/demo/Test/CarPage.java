package com.example.demo.Test;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CarPage {
    @Inject
    private CarRepository carRepository;

    private String model;
    private String productionYer;
    private String brand;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductionYer() {
        return productionYer;
    }

    public void setProductionYer(String productionYer) {
        this.productionYer = productionYer;
    }


    public void save() {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setProductionYer(productionYer);
        car.setColor(color);
        carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
