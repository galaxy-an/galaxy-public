package com.czxy.service;

import com.czxy.dao.CarMapper;
import com.czxy.domain.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dell
 * @version v 1.0
 * @date 2019/7/25
 */
@Service
@Transactional
public class CarService {

    @Resource
    private CarMapper carMapper;

    public List<Car> findAll() {
        return carMapper.selectAll();
    }

    public Car findById(String id) {
       return carMapper.selectByPrimaryKey(Integer.parseInt(id));
    }
}
