package com.sping.boot.demo.service;

import com.sping.boot.demo.bean.Student;

public interface IRedisService {

    boolean saveStudent(Student student);

    Student findStudentById(int id);

    Integer findStudentsCount();


}
