package com.tz;

import com.tz.ssh.AppConfig;
import com.tz.ssh.service.ClazzService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created by hjl on 2015/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClazzService {

    @Autowired
    private ClazzService clazzService;

    @Test
    public void test1(){
        Assert.notNull(clazzService);
        clazzService.deleteClazzByIdCasStudents(35);
    }

}
