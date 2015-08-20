package com.tz.ssh.service

import com.tz.ssh.AppConfig
import com.tz.ssh.TestConfig
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.util.Assert

/**
 * Created by hjl on 2015/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestClazzService {

    @Autowired
    ClazzService clazzService;

    @Test
    void test1DeleteClazz(){
        Assert.notNull(clazzService);
        clazzService.deleteClazzByIdCasStudents(35);
    }

}
