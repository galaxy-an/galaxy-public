package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dell
 * @version v 1.0
 * @date 2019/7/25
 * CREATE TABLE `tab_car` (
 *   `id` INT(11) NOT NULL AUTO_INCREMENT,
 *   `car_name` VARCHAR(20) DEFAULT NULL,
 *   `min_price` DOUBLE DEFAULT NULL,
 *   `max_price` DOUBLE DEFAULT NULL,
 *   `production_place` VARCHAR(20) DEFAULT NULL,
 *   `introduce` VARCHAR(500) DEFAULT NULL,
 *   `img` VARCHAR(50) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
 */
@Table(name = "tab_car")
public class Car {
    @Id
    private Integer id;
    private String carName;
    private Double minPrice;
    private Double maxPrice;
    private String productionPlace;
    private String introduce;
    private String img;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", minPrice='" + minPrice + '\'' +
                ", maxPrice='" + maxPrice + '\'' +
                ", productionPlace='" + productionPlace + '\'' +
                ", introduce='" + introduce + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getProductionPlace() {
        return productionPlace;
    }

    public void setProductionPlace(String productionPlace) {
        this.productionPlace = productionPlace;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Car(Integer id, String carName, Double minPrice, Double maxPrice, String productionPlace, String introduce, String img) {
        this.id = id;
        this.carName = carName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.productionPlace = productionPlace;
        this.introduce = introduce;
        this.img = img;
    }

    public Car() {
    }
}
