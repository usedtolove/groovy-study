package com.tz.ssh.sit.pages

import geb.Page

/**
 * Created by hjl on 2015/8/19
 */
class ListPage extends Page {

    static url = "clazz/list.action"
    static content = {
//        menuLogout { $("div#mynav a:last") }
//        menuLogout (wait:true){ $("div#mynav a:last") }
    }
    static at = {
        title == "班级列表"
//        menuLogout.text() == "安全退出"
    }
}
