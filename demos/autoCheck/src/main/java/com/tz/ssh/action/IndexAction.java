package com.tz.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by hjl on 15-8-13.
 */
@Namespace("/")
public class IndexAction extends ActionSupport{

    @Action(value = "", results = {
            @Result(type = "redirectAction",
                    params = {"namespace","clazz","actionName","list"})
    })
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
