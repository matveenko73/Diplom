package com.example.demo;


import com.example.demo.repositories.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class AdminPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminPage.class);

    @Inject
    private CarRepository carRepository;

    public void runRST() {
        new RstTask((cars) -> {
            List<Car> newCars = updateExistingCarsInDataBase(cars);
            carRepository.saveAll(newCars);
            LOGGER.info("saved " + newCars.size() + " cars");
        }).run();
    }

    public void runAutoRia() {
        new AutoRiaTask((cars) -> {
            carRepository.saveAll(cars);
            LOGGER.info("Cars saved");
        }).run();
    }

    private List<Car> updateExistingCarsInDataBase(List<Car> cars) {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            List<Car> alreadyExist = carRepository.findByMileageAndProductionYearAndEngineSizeAndFuelAndPriceAndRegion
                    (car.getMileage(), car.getProductionYear(), car.getEngineSize(),
                            car.getFuel(), car.getPrice(), car.getRegion());
            if (!alreadyExist.isEmpty()) {
                for (Car carExist : alreadyExist) {
                    carExist.setInfo(car.getInfo());
                    carExist.setTransmission(car.getTransmission());
                    carExist.setState(car.getState() != null && car.getState().trim().length() > 0
                            ? car.getState()
                            : carExist.getState());

                    carExist.setUrles(car.getUrles());
                    carExist.setPictures(car.getPictures());
                    carExist.setBrand(car.getBrand());
                    carExist.setModel(car.getModel());
                    carExist.setBody(car.getBody());
                    carExist.setDriveUnit(car.getDriveUnit());
                    carRepository.save(carExist);
                    LOGGER.info("car was updated " + carExist.getMileage()
                            + " " + carExist.getProductionYear() + " " + carExist.getEngineSize() +
                            " " + carExist.getFuel() + " " + car.getPrice() + " " + car.getRegion());
                }
            } else {
                newCars.add(car);
            }
        }
        return newCars;
    }

}
