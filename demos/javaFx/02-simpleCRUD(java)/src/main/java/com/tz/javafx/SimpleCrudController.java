package com.tz.javafx;

import com.tz.javafx.form.UserForm;
import com.tz.javafx.validator.StepA;
import com.tz.javafx.wrapper.UserWrapper;
import com.tz.model.MuAcUtil;
import com.tz.model.dao.UserDao;
import com.tz.model.entity.User;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Set;

/**
 * Created by hjl on 2015/9/17.
 * thanks to : http://docs.oracle.com/javafx/2/ui_controls/jfxpub-ui_controls.htm
 */
public class SimpleCrudController {

    private static final Logger LOGGER = Logger.getLogger(SimpleCrudController.class);

    @FXML // fx:id="nameTextField"
    private TextField nameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="ageTextField"
    private TextField ageTextField; // Value injected by FXMLLoader

    @FXML
    private TableView tableView;

    @FXML
    private Label errMsgName;

    @FXML
    private Label errMsgAge;

    //model
    private UserWrapper currentUser = new UserWrapper();
    private ObservableList userList = FXCollections.observableArrayList();
    private UserDao userDao = MuAcUtil.getInstance().getBean(UserDao.class);
    private Validator validator = MuAcUtil.getInstance().getBean(Validator.class);
    private Mapper mapper = MuAcUtil.getInstance().getBean(Mapper.class);

    @FXML
    void onSaveAction(ActionEvent event) {
        LOGGER.debug("onSaveAction");
        String name = nameTextField.getText();
        String age = ageTextField.getText();
        LOGGER.debug("currentUser name:"+name);
        LOGGER.debug("currentUser age:"+age);
        UserForm form = new UserForm(name, age);
        Set<ConstraintViolation<UserForm>> violations = validator.validate(form);
        if(violations.size() == 0){
            User user = mapper.map(form, User.class);
            userDao.save(user);
            loadData();
        }
    }

    @FXML
    void onUpdateAction(ActionEvent event) {
        LOGGER.debug("onUpdateAction");
        //remove previous error messages
        errMsgName.setText("");
        errMsgAge.setText("");

        int id = currentUser.getId();
        String name = nameTextField.getText();
        String age = ageTextField.getText();
        LOGGER.debug("currentUser id:" + id);
        LOGGER.debug("currentUser name:"+name);
        LOGGER.debug("currentUser age:"+age);
        UserForm form = new UserForm(id, name, age);
        Set<ConstraintViolation<UserForm>> violations = validator.validate(form, Default.class, StepA.class);
        if(violations.size() == 0){
            User user = mapper.map(form, User.class);
            userDao.save(user);
            //getAll
            loadData();
        }else{
            for(ConstraintViolation<UserForm> v : violations){
                System.out.println(v);
                String path = v.getPropertyPath().toString();
                String message = v.getMessage();
                switch (path){
                    case "name":errMsgName.setText(message);
                        break;
                    case "age":errMsgAge.setText(message);
                        break;
                }
            }
        }
    }

    @FXML
    void onDeleteAction(ActionEvent event) {
        int id = currentUser.getId();
        if(id != 0){
            LOGGER.debug("onDeleteAction,id:" + id);
            userDao.delete(id);
//            currentUser.setName("");
//            currentUser.setAge(0);
            nameTextField.setText("");
            ageTextField.setText("");
            loadData();
        }
    }

    /**
     * FXMLLoader will automatically call any suitably annotated
     * no-arg initialize() method defined by the controller
     */
    public void initialize() {
        LOGGER.debug("initialize");
        userDao.save(new User("jack", 25));
        userDao.save(new User("tom", 26));
        userDao.save(new User("mike", 27));

        TableColumn firstNameCol = new TableColumn("Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("name"));

        TableColumn lastNameCol = new TableColumn("Age");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("age"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //load data from DB
        loadData();
        //bind name
        nameTextField.textProperty().bindBidirectional(currentUser.nameProperty());
        //bind age
        ageTextField.textProperty().bindBidirectional(currentUser.ageProperty(), new NumberStringConverter());

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    User temp = (User) newValue;
                    LOGGER.debug("changed to:" + temp);
                    currentUser.setUser(temp);
                }
            }
        });

    }

    /**
     * load data from DB
     */
    private void loadData() {
        //remove all records
        userList.clear();
        //fetch records
        List<User> users = (List<User>) userDao.findAll();
        for(User user : users){
            userList.add(user);
        }
        tableView.setItems(userList);
        if(userList.size()>0){
            tableView.getSelectionModel().select(0);
        }
    }
}
