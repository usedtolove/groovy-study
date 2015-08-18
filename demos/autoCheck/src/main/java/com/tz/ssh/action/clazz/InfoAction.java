package com.tz.ssh.action.clazz;

import com.opensymphony.xwork2.ActionSupport;
import com.tz.ssh.dao.ClazzDao;
import com.tz.ssh.dao.StudentDao;
import com.tz.ssh.entity.Clazz;
import com.tz.ssh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hjl on 2015/8/16.
 */
public class InfoAction extends ActionSupport {

    @Autowired
    private ClazzDao clazzDao;
    @Autowired
    private StudentDao studentDao;

    private Clazz clazz;

    private List<Student> studentList;

    @Override
    public String execute() throws Exception {
        clazz = clazzDao.findOne(clazz.getId());
        studentList = studentDao.findByClazzId(clazz.getId());
        return SUCCESS;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

}
