package com.tz.ssh.sit.cases

import com.tz.ssh.sit.pages.ClazzAddPage
import com.tz.ssh.sit.pages.ClazzInfoPage
import com.tz.ssh.sit.pages.ClazzListPage
import geb.spock.GebReportingSpec

/**
 * Created by hjl on 15-8-20.
 */
class Sit04ClazzInfo extends GebReportingSpec{

    def "测试用例-班级列表to查看班级"(){
        when: "进入班级列表页面"
        to ClazzListPage

        and: "点击查看按钮"
        infoBtn.click()

        then: "查看班级页面"
        at ClazzInfoPage
    }

}
