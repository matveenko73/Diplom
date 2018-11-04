package com.example.demo.repositories;

import com.example.demo.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByOrderByIdDesc();

    List<Car> findByProductionYearLessThanEqualOrderByIdDesc(Integer productionYear);
    List<Car> findByProductionYearGreaterThanEqualOrderByIdDesc(Integer productionYear);
    List<Car> findByProductionYearGreaterThanEqualAndProductionYearLessThanEqualOrderByIdDesc(Integer filterYearAfter,
                                                                                 Integer filterYearBefore);
    List<Car> findByBrandLikeOrderByIdDesc(String brand);
    List<Car> findByModelLikeOrderByIdDesc(String model);
    List<Car> findByBrandLikeAndModelLikeOrderByIdDesc(String brand, String model);

    List<Car> findByRegionLikeOrderByIdDesc(String region);
}
