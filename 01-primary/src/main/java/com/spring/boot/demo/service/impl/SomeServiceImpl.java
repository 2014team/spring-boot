package com.sping.boot.demo.service.impl;


import com.sping.boot.demo.bean.Student;
import com.sping.boot.demo.dao.ISomeStudentDao;
import com.sping.boot.demo.service.ISomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements ISomeService {

    @Autowired
    protected ISomeStudentDao someStudentDao;

    @Override
    public boolean addStudent(Student student){
        int count = someStudentDao.addStudent(student);
        if(count > 0){
            return true;
        }
        return false;
    }
}
