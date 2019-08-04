package com.abc.dao;

import com.abc.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao {
    void insertEmployee(Employee employee);


}
