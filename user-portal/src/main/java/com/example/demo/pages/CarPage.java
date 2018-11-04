package com.example.demo.pages;

import com.example.demo.*;
import com.example.demo.repositories.CarRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class CarPage {

    @Inject
    private CarRepository carRepository;

    private String filterBrand;
    private String filterModel;
    private String filterYearBefore;
    private String filterYearAfter;
    private Long id;
    private String info;
    private String pictures;
    private String urles;
    private String brand;
    private String model;
    private String engineSize;
    private String body;
    private String region;
    private String price;
    private Integer productionYear;
    private String fuel;
    private String state;
    private String driveUnit;
    private String transmission;
    private Integer mileage;

    private List<Car> cars;

    @PostConstruct
    public void carInit() {
        cars = carRepository.findAllByOrderByIdDesc();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(String driveUnit) {
        this.driveUnit = driveUnit;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getFilterYearBefore() {
        return filterYearBefore;
    }

    public void setFilterYearBefore(String filterYearBefore) {
        this.filterYearBefore = filterYearBefore;
    }

    public String getFilterYearAfter() {
        return filterYearAfter;
    }

    public void setFilterYearAfter(String filterYearAfter) {
        this.filterYearAfter = filterYearAfter;
    }

    public String getFilterBrand() {
        return filterBrand;
    }

    public void setFilterBrand(String filterBrand) {
        this.filterBrand = filterBrand;
    }

    public String getFilterModel() {
        return filterModel;
    }

    public void setFilterModel(String filterModel) {
        this.filterModel = filterModel;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void applyFilter() {
        if (filterBrand != null && filterBrand.trim().length() > 0 &&
                filterModel != null && filterModel.trim().length() > 0) {
            cars = carRepository.findByBrandLikeAndModelLikeOrderByIdDesc(
                    "%" + filterBrand.toLowerCase() + "%",
                    "%" + filterModel.toLowerCase() + "%");
            return;
        }

        if (filterBrand != null && filterBrand.trim().length() > 0) {
            cars = carRepository.findByBrandLikeOrderByIdDesc("%" + filterBrand.toLowerCase() + "%");
            return;
        }

        if (filterModel != null && filterModel.trim().length() > 0) {
            cars = carRepository.findByModelLikeOrderByIdDesc("%" + filterModel.toLowerCase() + "%");
            return;
        }

        if (filterYearBefore != null && filterYearBefore.trim().length() > 0 &&
                filterYearAfter != null && filterYearAfter.trim().length() > 0) {
            cars = carRepository.findByProductionYearGreaterThanEqualAndProductionYearLessThanEqualOrderByIdDesc(
                    Integer.parseInt(filterYearAfter), Integer.parseInt(filterYearBefore));
                    return;
        }
        if (filterYearBefore != null && filterYearBefore.trim().length() > 0) {
            cars = carRepository.findByProductionYearLessThanEqualOrderByIdDesc(Integer.parseInt(filterYearBefore));
            return;
        }

        if (filterYearAfter != null && filterYearAfter.trim().length() > 0) {
            cars = carRepository.findByProductionYearGreaterThanEqualOrderByIdDesc(Integer.parseInt(filterYearAfter));
            return;
        }
    }
}


