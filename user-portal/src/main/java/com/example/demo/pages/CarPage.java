package com.example.demo.pages;

import com.example.demo.*;
import com.example.demo.repositories.CarRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CarPage {

    @Inject
    private CarRepository carRepository;

    private String brand;
    private String model;
    private Integer engineSize;
    private Body body;
    private Region region;
    private Integer price;
    private Integer productionYear;
    private Fuel fuel;

    private State state;
    private DriveUnit driveUnit;
    private Transmission transmission;


    @PostConstruct
    public void carInit() {
        Car car1 = new Car();
        car1.setBrand("Acura");
        car1.setModel("RSX");
        car1.setEngineSize(2000);
        car1.setBody(Body.Седан);
        car1.setRegion(Region.Винницкая);
        car1.setPrice(10000);
        car1.setProductionYear(2007);
        car1.setFuel(Fuel.Бензин);
        car1.setState(State.Нормальное);
        car1.setDriveUnit(DriveUnit.Передний);
        car1.setTransmission(Transmission.Ручная);

        Car car2 = new Car();
        car2.setBrand("Skoda");
        car2.setModel("Octavia");
        car2.setEngineSize(1600);
        car2.setBody(Body.Хетчбэк);
        car2.setRegion(Region.Киевская);
        car2.setPrice(20000);
        car2.setProductionYear(2013);
        car2.setFuel(Fuel.ГазБензин);
        car2.setState(State.Хорошее);
        car2.setDriveUnit(DriveUnit.Полный);
        car2.setTransmission(Transmission.Ручная);

        Car car3 = new Car();
        car3.setBrand("Toyota");
        car3.setModel("Camry");
        car3.setEngineSize(3600);
        car3.setBody(Body.Седан);
        car3.setRegion(Region.Запорожская);
        car3.setPrice(13000);
        car3.setProductionYear(2008);
        car3.setFuel(Fuel.ГазБензин);
        car3.setState(State.Нормальное);
        car3.setDriveUnit(DriveUnit.Передний);
        car3.setTransmission(Transmission.Автоматическая);

        Car car4 = new Car();
        car4.setBrand("BMW");
        car4.setModel("M5");
        car4.setEngineSize(3000);
        car4.setBody(Body.Кабриолет);
        car4.setRegion(Region.Житомирская);
        car4.setPrice(3000);
        car4.setProductionYear(2005);
        car4.setFuel(Fuel.Бензин);
        car4.setState(State.НеРастоможеное);
        car4.setDriveUnit(DriveUnit.Задний);
        car4.setTransmission(Transmission.Ручная);

        Car car5 = new Car();
        car5.setBrand("Ford");
        car5.setModel("Mondeo");
        car5.setEngineSize(1800);
        car5.setBody(Body.Универсал);
        car5.setRegion(Region.Киевская);
        car5.setPrice(7000);
        car5.setProductionYear(2002);
        car5.setFuel(Fuel.Бензин);
        car5.setState(State.Хорошее);
        car5.setDriveUnit(DriveUnit.Передний);
        car5.setTransmission(Transmission.Автоматическая);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
        carRepository.save(car5);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Integer engineSize) {
        this.engineSize = engineSize;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPriductionYear() {
        return productionYear;
    }

    public void setPriductionYear(Integer priductionYear) {
        this.productionYear = priductionYear;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public DriveUnit getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(DriveUnit driveUnit) {
        this.driveUnit = driveUnit;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
