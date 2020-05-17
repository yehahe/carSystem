package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.CarRequestVO;
import com.jkxy.car.api.utils.JSONResult;

import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String carName);

    List<Car> findByCarNameWithPage(String carName,Integer pageNum,Integer pageSize);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    JSONResult buyCar(CarRequestVO carRequestVO);
}
