package com.tz.ssh.sit.pages

import geb.Page

/**
 * 班级列表页面
 * Created by hjl on 2015/8/19
 */
class ClazzListPage extends Page {

    //页面路径
    static url = "clazz/list.action"

    //定义页面组件
    static content = {
        pageHearder {$(".page-header")}
        clazzAddBtn {$("#class_add_btn")}
        table {$(".table")}

        highLightBtn {$("#highLightBtn")}

        lastRowName {$("tr:last-child .td_name").text()}
        lastRowOpenDate {$("tr:last-child .td_open_date").text()}
        lastRowRoom {$("tr:last-child .td_room").text()}

        //删除按钮不一定存在，设置required:false
        deleteBtn (required: false) {$(".deleteBtn", 0)}
        deleteConfirmModal {$("#deleteConfirmModal")}
        deleteConfirmBtn {$("#deleteConfirmBtn")}
    }

    //页面检查点
    static at = {
        title == "班级列表"
        pageHearder.text() == "班级列表"
        clazzAddBtn.find("span").text().contains("添加班级");
        table != null
    }
}
