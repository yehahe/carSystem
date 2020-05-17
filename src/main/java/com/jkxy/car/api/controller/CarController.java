package com.jkxy.car.api.controller;

import com.jkxy.car.api.annotation.CacheLock;
import com.jkxy.car.api.annotation.CacheParam;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.CarRequestVO;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }

    /**
     *  通过汽车品牌分页模糊查询
     * @param carName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("selectByCarBrand")
    public JSONResult selectByCarBrand(@RequestParam("carName") String carName,@RequestParam("pageNum") Integer pageNum,
    @RequestParam("pageSize") Integer pageSize) {
        List<Car> carList = carService.findByCarNameWithPage(carName, pageNum, pageSize);
        return JSONResult.ok(carList);
    }

    @PostMapping("buyCar")
    @CacheLock(prefix = "buyCar")
    public JSONResult buyCar(@RequestBody CarRequestVO carRequestVO, HttpServletRequest request) {
        String userName = request.getHeader("userName");
        carRequestVO.setUserName(userName);
        JSONResult jsonResult;
        try {
            jsonResult = carService.buyCar(carRequestVO);
        }catch (RuntimeException e){
            return JSONResult.errorMsg(e.getMessage());
        }

        return jsonResult;
    }
}
