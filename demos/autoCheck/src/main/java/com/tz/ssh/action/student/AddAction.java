package com.tz.ssh.action.student;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;
import com.tz.ssh.dao.ClazzDao;
import com.tz.ssh.dao.StudentDao;
import com.tz.ssh.entity.Clazz;
import com.tz.ssh.entity.Student;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hjl on 15-8-12.
 */
@Result(type = "redirect", location = "/clazz/info.action?clazz.id=${clazz.id}")
public class AddAction extends ActionSupport{

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClazzDao clazzDao;

    private Clazz clazz;
    private Student student;


    @Validations(
        requiredStrings = {
            @RequiredStringValidator(type = ValidatorType.SIMPLE,
                fieldName = "student.name",
                message = "name can not be blank!"),
            @RequiredStringValidator(type = ValidatorType.SIMPLE,
                fieldName = "student.gender",
                message = "gender can not be blank!"),
            @RequiredStringValidator(type = ValidatorType.SIMPLE,
                fieldName = "student.degree",
                message = "degree can not be blank!")
        },
        stringLengthFields = {
            @StringLengthFieldValidator(type = ValidatorType.SIMPLE,
                trim = true, minLength = "1", maxLength = "10",
                fieldName = "student.name",
                message = "name must 1~10"),
            @StringLengthFieldValidator(type = ValidatorType.SIMPLE,
                trim = true, minLength = "1", maxLength = "1",
                fieldName = "student.gender",
                message = "gender must 1"),
            @StringLengthFieldValidator(type = ValidatorType.SIMPLE,
                trim = true, minLength = "1", maxLength = "10",
                fieldName = "student.degree",
                message = "degree must 1~10")
        }
    )
    @Override
    public String execute() throws Exception {
        clazz = clazzDao.findOne(clazz.getId());
        student.setClazz(clazz);

        studentDao.save(student);
        return SUCCESS;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
