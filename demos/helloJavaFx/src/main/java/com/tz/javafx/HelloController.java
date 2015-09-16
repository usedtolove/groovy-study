package com.tz.javafx;

/**
 * Sample Skeleton for 'FXMLDocument.fxml' Controller Class
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Date;

public class HelloController {

    @FXML // fx:id="button"
    private Button button; // Value injected by FXMLLoader

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML
    void handleButtonAction(ActionEvent event) {
        label.setText("HelloWorld on " + new Date());
    }

}
