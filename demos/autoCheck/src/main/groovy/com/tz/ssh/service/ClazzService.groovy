package com.tz.ssh.service

import com.tz.ssh.dao.ClazzDao
import com.tz.ssh.dao.StudentDao
import com.tz.ssh.entity.Student
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by hjl on 2015/8/18.
 */
trait ClazzService {

    @Autowired
    private ClazzDao clazzDao;
    @Autowired
    private StudentDao studentDao;

    def deleteClazzByIdCasStudents(int clazzId){
        def studentList = studentDao.findByClazzId(clazzId);
        if(studentList != null && studentList.size() > 0){
            for(Student stu : studentList){
                studentDao.delete(stu);
            }
        }
        def clazz = clazzDao.findOne(clazzId);
        if(clazz != null){
            clazzDao.delete(clazz);
        }
    }

}