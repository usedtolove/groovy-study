package com.tz.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by hjl on 2015/9/17.
 */
public class MuAcUtil {

    private static ApplicationContext instance = init();

    private static ApplicationContext init() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppBootConfig.class);
        return ac;
    }

    public static ApplicationContext getInstance(){
        return instance;
    }

}
