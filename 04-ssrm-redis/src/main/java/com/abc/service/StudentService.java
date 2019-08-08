package com.abc.service;

import com.abc.bean.Student;

public interface StudentService {

    void saveStudent(Student student) throws Exception;

    Student findStudentById(int id);

    Integer findStudentsCount();

}
