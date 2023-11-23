package com.example.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene sceneLogin;
    private static Scene sceneTasks;

    @Override
    public void start(Stage initialStage) throws IOException {
        stage = initialStage;
        FXMLLoader fxmlLoaderLogin = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        FXMLLoader fxmlLoaderTasks = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        sceneLogin = new Scene(fxmlLoaderLogin.load());
        sceneTasks = new Scene(fxmlLoaderTasks.load());
        stage.setTitle("Todo List");
        stage.setScene(sceneLogin);
        stage.show();
        System.out.println();
    }

    public static void changeScreen(String screenName){
        switch (screenName){
            case "tasks":
                stage.setScene(sceneTasks);
        }

    }

    public static void main(String[] args) {
        launch();
    }
}