package com.tz.ssh.dao

import com.tz.ssh.AppConfig
import com.tz.ssh.entity.Clazz
import com.tz.ssh.util.DataPool
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.transaction.Transactional

/**
 * Created by hjl on 2015/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Transactional
class TestClazzDao {

    @Autowired
    ClazzDao clazzDao;

    @Test
    void test1FindAllClazz(){
        Assert.assertNotNull(clazzDao);
        System.out.println(clazzDao.findAllByCreationTime());
    }

    @Test
    void test2SaveClazz(){
        Clazz clazz = new Clazz();
        clazz.setName("testClazz");
        clazz.setOpenDate(new Date());
        clazz.setRoom("A");
        clazzDao.save(clazz);
    }

    @Test
    void test3SaveBatch(){
        DataPool.dataPool.each {clazz->
            clazzDao.save(clazz)
        }
    }

}
