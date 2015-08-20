package com.tz.ssh.sit.pages

import geb.Page

/**
 * 新增班级页面
 * Created by hjl on 2015/8/19.
 */
class ClazzAddPage extends Page{

    //页面路径
    static url = "clazz/input.action"

    //定义页面组件
    static content = {
        pageHearder {$(".page-header")}
        submitBtn {$("#submit_btn")}
        form {$("form")}

        className {$("#class_name")}
        openDate {$("#open_date")}
        classRoom {$("#class_room")}

        classNameErr {$("#class_name_err span").text()}
        openDateErr {$("#open_date_err span").text()}
        classRoomErr {$("#class_room_err span").text()}
    }

    //页面检查点
    static at = {
        title == "新增班级"
        pageHearder.text() == "新增班级"
        submitBtn.text() == "保存";
        form != null
    }

}
