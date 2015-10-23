package com.tz.javafx.form;

import com.tz.javafx.validator.IsAge;
import com.tz.javafx.validator.StepA;
import com.tz.javafx.validator.StepB;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

/**
 * Created by hjl on 2015/9/23.
 */
public class UserForm {

//    /**
//     * 校验排序 标记接口 Add
//     */
//    @GroupSequence({Default.class})
//    public interface Add {}
//
//    /**
//     * 校验排序 标记接口 Update
//     */
//    @GroupSequence({Default.class, StepA.class})
//    public interface Update {}

    @NotNull(groups = StepA.class)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @IsAge
    private String age;

    public UserForm() {
    }

    public UserForm(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public UserForm(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
