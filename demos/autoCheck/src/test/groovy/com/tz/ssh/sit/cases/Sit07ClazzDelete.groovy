package com.tz.ssh.sit.cases

import com.tz.ssh.sit.pages.ClazzListPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

/**
 * 测试用例：
 * 模拟用户在班级列表页面，
 * 点击删除按钮 以删除班级
 * Created by hjl on 15-8-20.
 */
@Stepwise
class Sit07ClazzDelete extends GebReportingSpec{

    def "测试用例-删除班级"(){
        given: "进入班级列表页面"
        to ClazzListPage

        while(deleteBtn){
            when: "点击删除按钮"
            def btnId = deleteBtn.attr("id")
            deleteBtn.click()

            then: "等待弹出确认对话框"
            waitFor{ deleteConfirmModal.css("display") == "block"}

            and: "点击确定删除按钮"
            deleteConfirmBtn.click()

            then: "等待删除记录"
            //println "等待删除记录:$btnId"
            waitFor{ deleteBtn.attr("id") != btnId}
        }
    }

}
