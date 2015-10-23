package com.tz.dao;

import com.tz.model.AppBootConfig;
import com.tz.model.dao.UserDao;
import com.tz.model.entity.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hjl on 2015/9/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppBootConfig.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserDao {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1Save(){
        User user = new User();
        user.setName("jack");
        user.setAge(25);
        userDao.save(user);
    }

    @Test
    public void test2FindAll(){
        List<User> userList = (List<User>) userDao.findAll();
        Assert.assertEquals(0, userList.size());
    }

    @Test
    public void test3Delete(){
        User user = new User();
        user.setName("jack");
        user.setAge(25);
        userDao.save(user);

        int id = user.getId();

        userDao.delete(id);
        User temp = userDao.findOne(id);
        Assert.assertNull(temp);
    }

    @Test
    public void test4Update(){
        User user = new User();
        user.setName("jack");
        user.setAge(25);
        userDao.save(user);

        int id = user.getId();

        user.setAge(user.getAge() + 1);
        userDao.save(user);

        User user2 = userDao.findOne(id);
        Assert.assertEquals(26, user2.getAge());
    }

}
