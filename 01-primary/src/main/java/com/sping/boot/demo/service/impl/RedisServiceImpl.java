package com.sping.boot.demo.service.impl;



import com.sping.boot.demo.bean.Student;
import com.sping.boot.demo.dao.ISomeStudentDao;
import com.sping.boot.demo.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    protected ISomeStudentDao someStudentDao;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @CacheEvict(value = "realTimeCache", allEntries = true)
    @Override
    public boolean saveStudent(Student student){
        int count = someStudentDao.addStudent(student);
        if(count > 0){
            return true;
        }
        return false;
    }


    @Override
    @Cacheable(value = "realTimeCache", key = "'student_'+#id")
    public Student findStudentById(int id) {
        System.out.println("从DB中查询指定id的Student");
        return someStudentDao.selectStudentById(id);
    }

    // 使用双重检测锁
    // 不存在线程安全问题
    @Override
    public Integer findStudentsCount() {
        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps("count");
        Object count = ops.get();
        if (count == null) {
            synchronized (this) {
                count = ops.get();
                if(count == null) {
                    count = someStudentDao.selectStudentsCount();
                    // 以下语句的底层由以下步骤完成：
                    // 1. 申请一个内核缓存空间m
                    // 2. 将用户空间中的count值读取到内核空间m
                    // 3. 将内核空间m中的数据传递给set()方法中的形参(内核空间 -> 用户空间)
                    // 4. set()方法会将数据传递到协议引擎ProtocolEngine(用户空间 -> 内核空间)
                    // 5. 协议引擎将数据通过网络传递到Redis
                    ops.set(count, 100, TimeUnit.SECONDS);
                }
            }
        }
        return (Integer) count;
    }
}
