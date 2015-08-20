package com.tz.ssh.sit.cases

import com.tz.ssh.sit.pages.ClazzAddPage
import com.tz.ssh.sit.pages.ClazzListPage
import com.tz.ssh.util.DataPool
import geb.spock.GebReportingSpec

import java.text.SimpleDateFormat

/**
 * 班级列表 数据池批量保存
 * Created by hjl on 2015/8/19.
 */
class SitClazzAddBatch extends GebReportingSpec{

    def "测试用例-新增班级-数据池批量保存"() {
        def dateFormat = new SimpleDateFormat('yyyy-MM-dd')
        given: "进入新增班级页面"
        to ClazzAddPage

        DataPool.dataPool.each {clazz->
            when: "输入有效数据"
            def name = clazz.name
            def sOpenDate = dateFormat.format(clazz.openDate)
            def room = clazz.room

            className.value(name)
            openDate.value(sOpenDate)
            classRoom.value(room)

            and: "提交表单"
            submitBtn.click();

            then: "保存成功，跳转到列表页面"
            at ClazzListPage

            and: "存在之前输入的数据"
            highLightBtn.click();

            lastRowName == name
            lastRowOpenDate == sOpenDate
            lastRowRoom == room

            given: "返回新增班级页面"
            to ClazzAddPage
        }

    }

}
