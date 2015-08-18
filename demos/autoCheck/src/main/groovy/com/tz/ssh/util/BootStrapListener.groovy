package com.tz.ssh.util

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener
import java.sql.Driver
import java.sql.DriverManager
import java.sql.SQLException

/**
 * 项目 BootStrap 监听器
 * 启动时初始化 path 变量，
 * 关闭时释放数据库驱动
 * Created by hjl on 2015/8/15.
 */
@WebListener
class BootStrapListener implements ServletContextListener {

    @Override
    void contextInitialized(ServletContextEvent servletContextEvent) {
        def path = servletContextEvent.servletContext.contextPath
        servletContextEvent.servletContext.setAttribute('path', path);
    }

    @Override
    void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            for(driver in DriverManager.drivers){
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
