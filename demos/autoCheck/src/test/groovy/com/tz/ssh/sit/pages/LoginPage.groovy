package com.tz.ssh.sit.pages

import geb.Page

/**
 * @author Hu Jing Ling
 * @since 2015/4/13 20:09
 */
class LoginPage extends Page {
    //路径
    static url = "login.jsp"
    //初步断言
    static at = {
        title == "登录页面"
    }
    //定义页面元素
    static content = {
        loginButton { $("button", type: "submit")}
        nameErrMsg { $("#labelUserName").text() }
        passwordErrMsg { $("#labelPassword").text() }
        nameInput { $("input#inputUserName", type: "text")}
        passwrodInput { $("input#inputPassword", type: "password")}
    }
}
