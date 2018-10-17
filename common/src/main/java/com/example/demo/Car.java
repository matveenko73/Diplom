package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String pictures;
    private String urles;
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


    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getUrles() {
        return urles;
    }

    public void setUrles(String urles) {
        this.urles = urles;
    }

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

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
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
