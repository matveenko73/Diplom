package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String brand;
    private String model;
    private Integer engineSize;
    private Enum body;
    private String region;
    private Integer price;
    private Integer priductionYear;
    private Enum fuel;
    private Enum state;
    private Enum driveUnit;
    private Enum transmission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Enum getBody() {
        return body;
    }

    public void setBody(Enum body) {
        this.body = body;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPriductionYear() {
        return priductionYear;
    }

    public void setPriductionYear(Integer priductionYear) {
        this.priductionYear = priductionYear;
    }

    public Enum getFuel() {
        return fuel;
    }

    public void setFuel(Enum fuel) {
        this.fuel = fuel;
    }

    public Enum getState() {
        return state;
    }

    public void setState(Enum state) {
        this.state = state;
    }

    public Enum getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(Enum driveUnit) {
        this.driveUnit = driveUnit;
    }

    public Enum getTransmission() {
        return transmission;
    }

    public void setTransmission(Enum transmission) {
        this.transmission = transmission;
    }
}
