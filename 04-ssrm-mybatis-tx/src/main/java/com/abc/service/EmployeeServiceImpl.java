package com.abc.service;

import com.abc.bean.Employee;
import com.abc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao dao;

    //发生运行时异常回滚
    //此时没有入库一条数据
    @Transactional
    @Override
    public void addEmployee(Employee employee) throws Exception {
        dao.insertEmployee(employee);
         int i = 1/0;//运行时异常
        dao.insertEmployee(employee);
    }

    //springMVC发生运行时异常回滚，发生受检查异常提交
    //此时会入库一条数据
    //严重性  运行时异常 > 受检查异常
    //自己处理的异常为受检查异常（try处理、或者throw处理）
    //继承RuntimeException未自己处理，运行时异常
    @Transactional
    @Override
    public void addEmployee1(Employee employee) throws Exception {
        dao.insertEmployee(employee);
        if (true) {
            throw new Exception("发生受查异常");//受查异常提交
        }
        dao.insertEmployee(employee);
    }

    //发生受查异常事物
    //此时没有入库一条数据
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addEmployee2(Employee employee) throws Exception {
        dao.insertEmployee(employee);
        if (true) {
            throw new Exception("发生受查异常");
        }
        dao.insertEmployee(employee);
    }
}
