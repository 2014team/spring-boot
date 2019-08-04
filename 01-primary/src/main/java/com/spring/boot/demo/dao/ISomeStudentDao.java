package com.sping.boot.demo.dao;

import com.sping.boot.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISomeStudentDao {
    Integer addStudent(Student student);

    Integer selectStudentsCount();

    Student selectStudentById(int id);
}
