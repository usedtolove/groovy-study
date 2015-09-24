package com.tz.dao;

import com.alibaba.fastjson.JSON;
import com.tz.javafx.form.UserForm;
import com.tz.javafx.validator.StepA;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * Created by hjl on 2015/9/23.
 */
public class TestUserForm {

    private static Validator validator;

    @BeforeClass
    public static void setup(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void test1(){
        UserForm form = new UserForm();
        Set<ConstraintViolation<UserForm>> violations = validator.validate(form, Default.class, StepA.class);
//        Set<ConstraintViolation<UserForm>> violations2 = validator.validate(form, Default.class);
        Set<ConstraintViolation<UserForm>> violations2 = validator.validate(form);
        Assert.assertEquals(3, violations.size()); //for update
        Assert.assertEquals(2, violations2.size()); //for add
    }

    @Test
    public void test2(){
        UserForm form = new UserForm();
        form.setId(1);
        form.setName("1");
        form.setAge("asd");

        Set<ConstraintViolation<UserForm>> violations = validator.validate(form);
        Assert.assertEquals(1, violations.size());
        assert "无效的年龄".equals(violations.iterator().next().getMessage());
    }

    @Test
    public void test3(){
        UserForm form = new UserForm();
        form.setId(1);
        form.setName("1");
        form.setAge("123");

        Set<ConstraintViolation<UserForm>> violations = validator.validate(form);
        Assert.assertEquals(0, violations.size());
    }

}
