package com.example.vet_pet;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class bookRoom {
   private Stage stage;
   private Scene scene;
   private Parent root;
   public static int page = 0;
   public void setStage (Stage stage){

   }
   @FXML
   private void goBack (ActionEvent event) throws IOException {
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
   private void bookExamination(ActionEvent event) throws IOException {
      page = 1;
      FXMLLoader loader=new FXMLLoader(getClass().getResource("examination-apply.fxml"));
      root = loader.load();
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      ExaminationApplyController controller=loader.getController();
      controller.setStage(stage);
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
   }
   @FXML
   private void bookOpreation(ActionEvent event) throws IOException {
      page = 2;
      FXMLLoader loader=new FXMLLoader(getClass().getResource("examination-apply.fxml"));
      root = loader.load();
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      ExaminationApplyController controller=loader.getController();
      controller.setStage(stage);
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
   }
}