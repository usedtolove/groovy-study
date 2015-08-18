package com.tz.ssh.action.clazz;

import com.opensymphony.xwork2.ActionSupport;
import com.tz.ssh.dao.ClazzDao;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hjl on 2015/8/16.
 */
//URL: ~/clazz/delete.action
@ParentPackage("json-default")
@Result(type = "json", params = {"root", "result"})
public class DeleteAction extends ActionSupport {

    @Autowired
    private ClazzDao clazzDao;

    private int id;

    private boolean result;

    @Override
    public String execute() throws Exception {
        clazzDao.delete(id);
        result = true;
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
