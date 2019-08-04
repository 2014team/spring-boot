package com.sping.boot.demo.service;


import com.sping.boot.demo.bean.Student;

public interface ITransactionSomeService {
    //支持事物
    boolean addStudentExcetion(Student student);

    //当发生受检查异常,不支持事物
    boolean addStudentRuntimeException(Student student);

    //支持事物（发生受检查异常事物）
    boolean addStudentPrecentRuntimeException(Student student);
}
