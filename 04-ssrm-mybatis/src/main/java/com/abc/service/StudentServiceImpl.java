package com.abc.service;

import com.abc.bean.Student;
import com.abc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;

    @Override
    // Spring对于事务的默认提交方式是：发生运行时异常回滚，发生受查异常提交
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(Student student) throws Exception {
        dao.insertStudent(student);
        // int i = 5 / 0;   // 运行时异常
        // if(true) {
        //     // 受查异常
        //     throw new Exception("这是我自定义的异常");
        // }
        // dao.insertStudent(student);
    }
}
