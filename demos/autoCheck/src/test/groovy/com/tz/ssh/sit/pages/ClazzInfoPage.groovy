package com.tz.ssh.sit.pages

import geb.Page

/**
 * Created by hjl on 2015/8/20.
 */
class ClazzInfoPage extends Page{

    //页面路径
    static url = "clazz/info.action"

    //定义页面组件
    static content = {
        pageHearder {$(".page-header")}
        classListBtn {$("#class_list_btn")}
        studentAddBtn {$("#student_add_btn")}
//        form {$("form")}
//
//        className {$("#class_name")}
//        openDate {$("#open_date")}
//        classRoom {$("#class_room")}
//
//        classNameErr {$("#class_name_err span").text()}
//        openDateErr {$("#open_date_err span").text()}
//        classRoomErr {$("#class_room_err span").text()}
    }

    //页面检查点
    static at = {
        title == "查看班级"
        pageHearder.text() == "查看班级"

        classListBtn.find("span").text().contains("班级列表");
        studentAddBtn.find("span").text().contains("添加学员");
    }

}
