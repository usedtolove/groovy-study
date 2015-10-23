package com.tz.dao;

import com.tz.javafx.form.UserForm;
import com.tz.model.AppBootConfig;
import com.tz.model.entity.User;
import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hjl on 2015/9/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppBootConfig.class)
public class TestDozer {

    @Autowired
    private Mapper mapper;

    @Test
    public void test1(){
        Assert.assertNotNull(mapper);
    }

    @Test
    public void test2(){
        UserForm userForm = new UserForm(1, "jack", "25");
        User user = mapper.map(userForm, User.class);
        assert  user != null;
        assert  user.getId() == 1;
        assert  user.getName().equals("jack");
        assert  user.getAge() == 25;
    }

}


