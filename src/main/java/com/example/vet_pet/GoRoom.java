package com.example.vet_pet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GoRoom {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static int page2=0;

    //3 operation , 1 examination << room

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("welcomeScreen.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        WelcomeScreen controller=loader.getController();
        controller.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToExamination(ActionEvent event) throws IOException {

        page2=1;
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Prescription.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Prescription controller=loader.getController();
        controller.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToOperation(ActionEvent event) throws IOException {
        page2=2;
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Prescription.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Prescription controller=loader.getController();
        controller.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
}
