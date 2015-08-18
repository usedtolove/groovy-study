package com.tz.ssh.action

import com.opensymphony.xwork2.ActionProxy
import org.apache.struts2.StrutsSpringTestCase
import org.junit.Test

/**
 * Created by hjl on 2015/8/15.
 */
class TestClazzActions extends StrutsSpringTestCase{

    @Override
    void initServletMockObjects() {
        resourceLoader = new MyResourceLoader();
        super.initServletMockObjects();
    }

    @Test
    void test1AddClazz(){
        request.setParameter("clazz.name", "jsd1232")
        def proxy = getActionProxy("/clazz/add.action")
        def result = proxy.execute()
        println result
    }

}
