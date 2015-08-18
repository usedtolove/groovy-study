package com.tz;

import com.tz.ssh.AppConfig;
import com.tz.ssh.dao.ClazzDao;
import com.tz.ssh.entity.Clazz;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by hjl on 15-8-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpring  {

    @Autowired
    private ClazzDao clazzDao;

    @Test
    public void test1FindAll(){
        Assert.assertNotNull(clazzDao);
        System.out.println(clazzDao.findAll());
    }

    @Test
    public void test2Save(){
        Clazz clazz = new Clazz();
        clazz.setName("testClazz");
        clazz.setOpenDate(new Date());
        clazz.setRoom("A");
        clazzDao.save(clazz);
    }

}
