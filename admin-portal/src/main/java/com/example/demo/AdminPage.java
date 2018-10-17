package com.example.demo;


import com.example.demo.repositories.CarRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AdminPage {

    @Inject
    private CarRepository carRepository;

    public void run() {
        new RstTask((cars) -> {
            carRepository.saveAll(cars);
            System.out.println("Cars saved");
        }).run();
    }
}
