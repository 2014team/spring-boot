package com.abc.controller;

import com.abc.bean.Student;
import com.abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/register")
    public String registerHandle(Student student) throws Exception {
        service.saveStudent(student);
        return "/jsp/welcome";
    }
}
