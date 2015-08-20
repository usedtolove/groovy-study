package com.tz.ssh.sit.cases

import com.tz.ssh.sit.pages.ClazzAddPage
import com.tz.ssh.sit.pages.ClazzListPage
import geb.spock.GebReportingSpec

/**
 * Created by hjl on 2015/8/19.
 */
class SitClazzAddFaild extends GebReportingSpec{

    def "测试用例-新增班级-非空验证"() {
        given: "进入新增班级页面"
        to ClazzAddPage

        when: "没有输入，直接提交表单"
        submitBtn.click();

        then: "看到错误信息"
        at ClazzAddPage
        classNameErr == "班级名不能为空"
        openDateErr == "开班日期不能为空"
        classRoomErr == "所在教室不能为空"
    }

    def "新增班级-测试用例-长度验证"() {
        given: "进入新增班级页面"
        to ClazzAddPage

        when: "输入无效数据"
        className.value("JSD123456712345678901")
        openDate.value("2010-6-30")
        classRoom.value("room1234567")
        and: "提交表单"
        submitBtn.click();

        then: "看到错误信息"
        at ClazzAddPage
        classNameErr == "班级名长度必须在6~20之间"
        classRoomErr == "所在教室长度必须在1~10之间"
    }

}
