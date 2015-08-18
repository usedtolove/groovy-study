package com.tz.ssh.util

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener

/**
 * Created by hjl on 2015/8/15.
 */
@WebListener
class MyPathListener implements ServletContextListener {

    @Override
    void contextInitialized(ServletContextEvent servletContextEvent) {
        def path = servletContextEvent.servletContext.contextPath
        servletContextEvent.servletContext.setAttribute('path', path);
    }

    @Override
    void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
