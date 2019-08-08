package com.abc.controller;

import com.abc.bean.Student;
import com.abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public String registerHandle(Student student) throws Exception {
        service.saveStudent(student);
        return "/jsp/welcome";
    }

    @GetMapping("/find")
    @ResponseBody
    public Student findHandle(int id) {
        return service.findStudentById(id);
    }

    @GetMapping("/count")
    @ResponseBody
    public Integer countHandle() {
        return service.findStudentsCount();
    }


}
