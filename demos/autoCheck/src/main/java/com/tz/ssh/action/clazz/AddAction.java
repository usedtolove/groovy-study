package com.tz.ssh.action.clazz;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;
import com.tz.ssh.dao.ClazzDao;
import com.tz.ssh.entity.Clazz;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hjl on 2015/8/16.
 */
@Result(type = "redirectAction", location = "list")
public class AddAction extends ActionSupport {

    @Autowired
    private ClazzDao clazzDao;

    private Clazz clazz;

    @Override
    public void validate() {
        if(StringUtils.isNotBlank(clazz.getName())){
            Clazz c = clazzDao.findByName(clazz.getName());
            if(c != null){
                addFieldError("clazz.name", "已存在同样班级名");
            }
        }
    }

    @Validations(
        requiredFields = {
                @RequiredFieldValidator(type = ValidatorType.SIMPLE,
                        fieldName = "clazz.openDate",
                        message = "开班日期不能为空")
        },
        requiredStrings = {
                @RequiredStringValidator(type = ValidatorType.SIMPLE,
                        fieldName = "clazz.name",
                        message = "班级名不能为空"),
                @RequiredStringValidator(type = ValidatorType.SIMPLE,
                        fieldName = "clazz.room",
                        message = "所在教室不能为空")
        },
        stringLengthFields = {
                @StringLengthFieldValidator(type = ValidatorType.SIMPLE,
                        trim = true, minLength = "6", maxLength = "20",
                        fieldName = "clazz.name",
                        message = "班级名长度必须在6~20之间"),
                @StringLengthFieldValidator(type = ValidatorType.SIMPLE,
                        trim = true, minLength = "1", maxLength = "10",
                        fieldName = "clazz.room",
                        message = "所在教室长度必须在1~10之间")
        }
    )
    @Override
    public String execute() throws Exception {
        clazzDao.save(clazz);
        return SUCCESS;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
