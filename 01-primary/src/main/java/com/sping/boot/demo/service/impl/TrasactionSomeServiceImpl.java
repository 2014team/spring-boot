package com.sping.boot.demo.service.impl;


import com.sping.boot.demo.bean.Student;
import com.sping.boot.demo.dao.ISomeStudentDao;
import com.sping.boot.demo.service.ITransactionSomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrasactionSomeServiceImpl implements ITransactionSomeService {

    @Autowired
    protected ISomeStudentDao someStudentDao;


    @Transactional
    @Override
    public boolean addStudentExcetion(Student student){
        int count = someStudentDao.addStudent(student);
        int i = 1/0;
        if(count > 0){
            return true;
        }
        return false;
    }


    @Transactional
    @Override
    public boolean addStudentRuntimeException(Student student){
        int count = someStudentDao.addStudent(student);
        try {
            if(true){
                throw new Exception("发生受检查异常");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count > 0){
            return true;
        }
        return false;
    }

    //采用spring默认的事物提交方式,发生运行时异常回滚,发生受检查异常提交
    @Transactional(rollbackFor=Exception.class)
    @Override
    public boolean addStudentPrecentRuntimeException(Student student){
        int count = someStudentDao.addStudent(student);
        try {
            if(true){
                throw new Exception("发生受检查异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count > 0){
            return true;
        }
        return false;
    }


}
