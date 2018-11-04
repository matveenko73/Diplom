package com.example.demo.repositories;

import com.example.demo.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car>  findByMileageAndProductionYearAndEngineSizeAndFuelAndPriceAndRegion(Integer mileage, Integer productionYear, String engineSize,
                                                           String fuel, String price, String region);
}
