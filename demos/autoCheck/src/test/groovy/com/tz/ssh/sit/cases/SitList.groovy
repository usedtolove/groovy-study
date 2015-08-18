package com.tz.ssh.sit.cases

import com.tz.ssh.sit.pages.ListPage
import geb.spock.GebReportingSpec

/**
 * Created by hjl on 2015/8/19.
 */
class SitList extends GebReportingSpec{

    def "班级列表-测试用例"() {
        given: "访问班级列表"
        to ListPage

//        when: "点击登录按钮"
//        loginButton.click();
//
//        then: "看到错误信息1"
//        nameErrMsg == "用户名不能为空!"
//        passwordErrMsg == "密码不能为空!"
//
//        when: "输入无效的用户名和密码"
//        nameInput.value("InvalidUsername");
//        passwrodInput.value("InvalidPassword");
//        and: "点击登录按钮"
//        loginButton.click();
//
//        then: "看到错误信息2"
//        passwordErrMsg == "用户名或密码错误!"
//
//        when: "输入有效的用户名和密码"
//        nameInput.value("EMP_001");
//        passwrodInput.value("123");
//        and: "点击登录按钮"
//        loginButton.click();
//
//        then: "看到欢迎页面"
//        at IndexPage
    }

}
