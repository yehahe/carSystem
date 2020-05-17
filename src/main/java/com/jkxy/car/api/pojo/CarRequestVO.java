package com.jkxy.car.api.pojo;


import java.io.Serializable;

/**
 * @author skryy9
 */
public class CarRequestVO extends PageBean implements Serializable {
    private Integer id;
    private String carName;
    private String carType;
    private String carSeries;
    //购买数量
    private Integer quantity;
    //操作人
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }


    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    @Override
    public String toString() {
        return "CarRequestVO{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carType='" + carType + '\'' +
                ", carSeries='" + carSeries + '\'' +
                ", quantity=" + quantity +
                ", userName='" + userName + '\'' +
                '}';
    }
}
