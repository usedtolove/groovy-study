package com.tz.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("simpleCRUD.fxml"));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/icon.jpg")));
        stage.setTitle("Hello javaFx");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
