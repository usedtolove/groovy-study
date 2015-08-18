package com.tz.ssh.action

import com.opensymphony.xwork2.ActionProxy
import org.apache.struts2.StrutsSpringTestCase
import org.junit.Test

/**
 * Created by hjl on 2015/8/15.
 */
class TestClazzActions extends StrutsSpringTestCase{

    @Override
    protected void initServletMockObjects() {
        resourceLoader = new MyResourceLoader();
        super.initServletMockObjects();
    }

    @Test
    void test1Add(){
//        request.parameters = ["clazz.name":"JSD1504",
//                              "clazz.openDate":"2015-01-01",
//                              "clazz.room":"A"]
//        request.setParameter("name", "JSD1504")
//        request.setParameter("openDate", "2015-01-01")
//        request.setParameter("room", "A")
//        request.setParameter("c['name']", "jsd1231")
        request.setParameter("clazz.name", "jsd1232")
        def proxy = getActionProxy("/clazz/add.action")
        def result = proxy.execute()
        println result
    }

}
