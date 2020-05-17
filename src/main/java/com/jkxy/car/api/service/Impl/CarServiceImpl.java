package com.jkxy.car.api.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.CarRequestVO;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.Constant;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public List<Car> findByCarNameWithPage(String carName,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Car> carList = carDao.findByCarName(carName);
        if (carList instanceof Page) {
            Page<Car> page = (Page<Car>) carList;
            page.getTotal();
            page.close();
        }

        return carList;
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public JSONResult buyCar(CarRequestVO carRequestVO) {
        Car car = carDao.findById(carRequestVO.getId());
        if (car == null){
            return JSONResult.errorMsg(Constant.NO_CAR_ERROR);
        }
        Integer updateFlag = carDao.buyCarById(carRequestVO);
        if (updateFlag.intValue() == Constant.UPDATE_FAIL){
            return JSONResult.errorMsg(Constant.CAR_STOCKQUANTITY_NOT_ENOUGH);
        }
            return JSONResult.ok();
    }
}
