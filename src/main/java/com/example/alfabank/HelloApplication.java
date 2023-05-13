package com.example.alfabank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        openWindow("register-view.fxml");
    }
    public static void openWindow(String fxml){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        try{
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("||ALFA-BANK||");
            stage.setScene(scene);
            stage.show();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}