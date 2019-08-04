package com.sping.boot.demo.controller;

import com.sping.boot.demo.bean.Student;
import com.sping.boot.demo.service.ITransactionSomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionSomeController {

    @Autowired
    ITransactionSomeService transactionSomeService;


    /**
     * 支持事物测试
     * @param model
     * @param student
     * @return
     */
    @PostMapping(value = "/addStudentExcetion")
    public String addStudentExcetion(Model model,Student student){
        boolean result = transactionSomeService.addStudentExcetion(student);
        model.addAttribute("student",student);
        return "welcome";
    }

    /**
     * 当发生受检查异常,不支持事物
     * @param model
     * @param student
     * @return
     */
    @PostMapping(value = "/addStudentRuntimeException")
    public String addStudentRuntimeException(Model model,Student student){
        boolean result = transactionSomeService.addStudentRuntimeException(student);
        model.addAttribute("student",student);
        return "welcome";
    }

    /**
     * 支持事物（发生受检查异常事物）
     * @param model
     * @param student
     * @return
     */
    @PostMapping(value = "/addStudentPrecentRuntimeException")
    public String addStudentPrecentRuntimeException(Model model,Student student){
        boolean result = transactionSomeService.addStudentPrecentRuntimeException(student);
        model.addAttribute("student",student);
        return "welcome";
    }
}
