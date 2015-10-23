package com.tz.javafx.wrapper;

import com.tz.model.entity.User;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by hjl on 2015/9/21.
 */
public class UserWrapper {

    private IntegerProperty id;
    private StringProperty name;
    private IntegerProperty age;

    public UserWrapper() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.age = new SimpleIntegerProperty();
    }

    public void setUser(User user){
        this.setId(user.getId());
        this.setName(user.getName());
        this.setAge(user.getAge());
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }
}
