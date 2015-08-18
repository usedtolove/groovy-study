package com.tz.ssh.action.clazz;

import com.opensymphony.xwork2.ActionSupport;
import com.tz.ssh.dao.ClazzDao;
import com.tz.ssh.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hjl on 2015/8/16.
 */
public class ListAction extends ActionSupport {

    @Autowired
    private ClazzDao clazzDao;

    private List<Clazz> clazzList;

    @Override
    public String execute() throws Exception {
        clazzList = (List<Clazz>) clazzDao.findAll();
        return SUCCESS;
    }

    public List<Clazz> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<Clazz> clazzList) {
        this.clazzList = clazzList;
    }
}
