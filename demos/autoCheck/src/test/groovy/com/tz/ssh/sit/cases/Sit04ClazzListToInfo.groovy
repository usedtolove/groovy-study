//package com.tz.ssh.sit.cases
//
//import com.tz.ssh.sit.pages.ClazzAddPage
//import com.tz.ssh.sit.pages.ClazzListPage
//import geb.spock.GebReportingSpec
//import spock.lang.Stepwise
//
///**
// * 测试用例：
// * 模拟用户从班级列表页面，
// * 进入查看班级页面
// * Created by hjl on 15-8-20.
// */
//@Stepwise
//class Sit04ClazzListToInfo extends GebReportingSpec{
//
//    def "测试用例-查看班级"(){
//        when: "班级列表页面"
//        to ClazzListPage
//
//        if(infoBtn){
//            when: "点击查看按钮"
//            deleteBtn.click()
//
//            then: "看到错误信息"
//            at ClazzAddPage
//
//            then: "等待弹出确认对话框"
//            waitFor{ deleteConfirmModal.css("display") == "block"}
//
//            and: "点击确定删除按钮"
//            deleteConfirmBtn.click()
//
//            then: "等待删除记录"
//            //println "等待删除记录:$btnId"
//            waitFor{ deleteBtn.attr("id") != btnId}
//        }
//    }
//
//}
