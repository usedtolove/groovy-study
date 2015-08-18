package com.tz.ssh.action.student;

import com.opensymphony.xwork2.ActionSupport;
import com.tz.ssh.entity.Clazz;

/**
 * Created by hjl on 2015/8/17.
 */
public class InputAction extends ActionSupport {

    private Clazz clazz;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
