package com.sping.boot.demo.dao;
        import com.sping.boot.demo.bean.Student;
        import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISomeStudentDao {
    Integer addStudent(Student student);

//    Student selectStudentById(int id);
//
//    Integer selectStudentsCount();
}
