package com.sping.boot.demo.controller;

import com.sping.boot.demo.bean.Student;
import com.sping.boot.demo.service.ISomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class SomeController {

    @Autowired
    ISomeService someService;

    @PostMapping(value = "/register")
    public String helloWorld(Model model,Student student){
        boolean result = someService.addStudent(student);
        model.addAttribute("student",student);
        return "welcome";
    }
}
