package com.abc.controller;

import com.abc.bean.Employee;
import com.abc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class SomeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public String someHandle(Employee employee) throws Exception {
        employeeService.addEmployee(employee);
        return "/jsp/welcome";
    }

    @PostMapping("/register1")
    public String someHandle1(Employee employee) throws Exception {
        employeeService.addEmployee1(employee);
        return "/jsp/welcome";
    }

    @PostMapping("/register2")
    public String someHandle2(Employee employee) throws Exception {
        employeeService.addEmployee2(employee);
        return "/jsp/welcome";
    }

}
