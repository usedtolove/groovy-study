package com.tz.ssh.sit.cases

import com.tz.ssh.sit.pages.ClazzAddPage
import com.tz.ssh.sit.pages.ClazzListPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

/**
 * 测试用例：
 * 模拟用户从班级列表页面，
 * 跳转到新增班级页面
 * Created by hjl on 2015/8/19.
 */
@Stepwise
class Sit01ClazzList extends GebReportingSpec{

    def "测试用例-班级列表"() {
        given: "访问班级列表"
        to ClazzListPage

        when: "点击新增按钮"
        clazzAddBtn.click();

        then: "看到错误信息"
        at ClazzAddPage

    }

}
