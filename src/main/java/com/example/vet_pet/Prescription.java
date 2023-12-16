package com.example.vet_pet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Prescription {
    private Stage stage;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField searchField;
    @FXML
    private TextArea prescription;
    Pet pet;
    private Scene scene;
    private Parent root;

    // (choise room)
    @FXML
    private ChoiceBox<String> selectStatus;
    @FXML
    private ChoiceBox<Integer> selectSlot;

    //  must be @Override
    @FXML
    public void initialize(){
        Pet.setData();
        selectStatus.getItems().addAll("no", "on progress", "totally treated");
        selectSlot.getItems().addAll(1, 2, 3, 4,5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }

    @FXML
    public void choiceStatus(MouseEvent event) throws IOException{
        String choiceStatus = selectStatus.getSelectionModel().getSelectedItem();

        if(choiceStatus.equals("no")){
            pet.setStatus(choiceStatus);
        }
        if (choiceStatus.equals("on progress")){
            pet.setStatus(choiceStatus);
        }
        if (choiceStatus.equals("totally treated")){
            pet.setStatus(choiceStatus);
        }


    }
    @FXML
    public void choiceSlot(MouseEvent event) throws IOException{
        int choiceSlot = selectSlot.getSelectionModel().getSelectedItem();
        for(int i=0; i<15;i++){
            if (choiceSlot== i){
                System.out.println(i);

            }

        }

    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
    @FXML
    public void searchAction (){
        String input = searchField.getText();
        if(input != null){
            for(Pet pet: Pet.pets){
                if(pet.getId() == Integer.parseInt(input)){
                    this.pet = pet;

                    prescription.setText(pet.getPrescription());
                }
            }
        }
    }
    @FXML
    private void updateData(){
        String newPre = prescription.getText();
        pet.setPrescription(newPre);

    }
    @FXML
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("goRoom.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GoRoom controller=loader.getController();
        controller.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
