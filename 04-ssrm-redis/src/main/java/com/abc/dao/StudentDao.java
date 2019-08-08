package com.abc.dao;

import com.abc.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao {
    int insertStudent(Student student);

    Student selectStudentById(int id);

    Integer selectStudentsCount();

}
