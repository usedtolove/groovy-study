package com.tz.javafx;

/**
 * Sample Skeleton for 'FXMLDocument.fxml' Controller Class
 */
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML // fx:id="button"
    private Button button; // Value injected by FXMLLoader

    @FXML // fx:id="myLabel1"
    private Label myLabel1; // Value injected by FXMLLoader
    @FXML
    private Label myLabel2; // Value injected by FXMLLoader

    private IntegerProperty clickCount;

    public HelloController() {
        System.out.println("HelloController empty constructor...");
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        myLabel1.setText("HelloWorld on " + new Date());
        clickCount.setValue(clickCount.getValue() + 1);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("HelloController initialize...");
        clickCount = new SimpleIntegerProperty(1);
//        Bindings.add(clickCount, myLabel2.textProperty());
        Bindings.bindBidirectional(myLabel2.textProperty(),
                                clickCount,
                                new NumberStringConverter());
//        clickCount.bindBidirectional(IntegerProperty.valueOf(myLabel2.textProperty()));
    }
}
