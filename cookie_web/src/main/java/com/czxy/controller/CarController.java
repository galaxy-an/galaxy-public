package com.czxy.controller;

import com.czxy.domain.Car;
import com.czxy.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author dell
 * @version v 1.0
 * @date 2019/7/25
 */
@RestController
@RequestMapping("car")
public class CarController {

    @Resource
    private CarService carService;

//    2.近期浏览
    @GetMapping("/{id}")
    public ResponseEntity<Void> findById(@PathVariable String id, HttpServletResponse response, HttpServletRequest request){
//        1.创建cookie保存数据--判断是否是上次保存的cookie对象
        try {
            Car car= carService.findById(id);
            int count=1;
            Cookie[] cookies = request.getCookies();
            if(cookies!=null){
            for (Cookie c : cookies) {
                    if("car".equals(c.getName())){
//                    判断id是否相同
                        if(id.equals(c.getValue().split("@")[0])){
//                        把原来存放在cookie中的数量++之后赋值给他
                            count=Integer.parseInt(c.getValue().split("@")[1]);
                            count++;
                        }
                    }
                }

            }
//       判断id是否相同如果相同count++
            Cookie ck=new Cookie(id,id+"@"+count);
            ck.setPath("/");
            ck.setMaxAge(60*60*24*7);
            response.addCookie(ck);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    1.查询所有
    @GetMapping
    public ResponseEntity<List<Car>> findAll(){
        try {
            List<Car> cars= carService.findAll();
            return ResponseEntity.ok(cars);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
