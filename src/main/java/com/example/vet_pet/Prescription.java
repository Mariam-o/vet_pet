package com.example.vet_pet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Prescription {
    private Stage stage;
    @FXML
    private TextField searchField;
    @FXML
    private TextArea prescription;
    @FXML
    private CheckBox adoptCheck;
    Pet pet;
    private Scene scene;
    private Parent root;
    @FXML
    private Label alert;

    // (choise room)
    @FXML
    private ChoiceBox<String> selectStatus;
    //  must be @Override
    @FXML
    public void initialize(){
        Pet.setData();
        selectStatus.getItems().addAll("no", "on progress", "totally treated");
        selectStatus.setOnAction(this::choiceStatus);
    }

    @FXML
    public void choiceStatus(ActionEvent event){
        String choiceStatus = selectStatus.getValue();
        if(choiceStatus.equals("no")){
            adoptCheck.setVisible(false);
            adoptCheck.setSelected(false);
        }
        if (choiceStatus.equals("on progress")){
            adoptCheck.setVisible(false);
            adoptCheck.setSelected(false);
        }
        if (choiceStatus.equals("totally treated")){
            adoptCheck.setVisible(true);
            adoptCheck.setSelected(false);
        }


    }


    @FXML
    public void searchAction (){
        String input = searchField.getText();
        alert.setText("! NO ANIMAL AVAILABLE !");
        if(input != null){
            for(Pet pet: Pet.pets){
                if(pet.getId() == Integer.parseInt(input)){
                    alert.setText("");
                    selectStatus.setDisable(false);
                    prescription.setDisable(false);
                    this.pet = pet;
                    if(pet.getReadyForAdopt() == true){
                        adoptCheck.setVisible(true);
                        adoptCheck.setSelected(true);
                    }
                    else {
                        adoptCheck.setVisible(false);
                        adoptCheck.setSelected(false);
                    }
                    prescription.setText(pet.getPrescription());
                    selectStatus.setValue(String.valueOf(pet.getStatus()));


                }
            }
            if (Integer.parseInt(input) != pet.getId()) {

                restart();
                alert.setText("! NO ANIMAL AVAILABLE !");
            }
        }

    }
    @FXML
    private void updateData(){
        String newPre = prescription.getText();
        pet.setPrescription(newPre);
        String newStatus = selectStatus.getValue();

        if(newStatus.equals("no")){
            pet.setStatus(Pet.PetStatus.no);
        }
        if (newStatus.equals("on progress")){
            pet.setStatus(Pet.PetStatus.on_progress);
        }
        if (newStatus.equals("totally treated")){
            pet.setStatus(Pet.PetStatus.totally_treated);
        }

        if (adoptCheck.isSelected()){
            pet.setReadyForAdopt(true);
        }

       restart();


    }

    private void restart(){
        pet= null;
        adoptCheck.setVisible(false);
        adoptCheck.setSelected(false);
        selectStatus.setValue(" ");
        searchField.clear();
        prescription.clear();
        selectStatus.setDisable(true);
        prescription.setDisable(true);

    }

    @FXML
    private void goBack2(ActionEvent event) throws IOException {

        FXMLLoader loader=new FXMLLoader(getClass().getResource("goRoom.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GoRoom controller=loader.getController();
        controller.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    @FXML
//    public void setAdoptCheck(ActionEvent event){
//
//
//    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
}
