package com.sping.boot.demo.controller;

import com.sping.boot.demo.bean.Student;
import com.sping.boot.demo.service.IRedisService;
import com.sping.boot.demo.service.ISomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    IRedisService redisService;

    @ResponseBody
    @PostMapping(value = "/save")
    public Object save(Model model, Student student) {
        boolean result = redisService.saveStudent(student);
        return result;
    }


    @GetMapping("/find")
    @ResponseBody
    public Student findHandle(int id) {
        return redisService.findStudentById(id);
    }

    @GetMapping("/count")
    @ResponseBody
    public Integer countHandle() {
        return redisService.findStudentsCount();
    }
}