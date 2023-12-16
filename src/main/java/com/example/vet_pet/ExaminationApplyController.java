package com.example.vet_pet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ExaminationApplyController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField searchField;
    private Pet pet;
    @FXML
    private ChoiceBox<String> selectRoom;
    @FXML
    private ChoiceBox<Integer> selectSlot;
    @FXML
    public void initialize(){
        Pet.setData();
        selectSlot.getItems().addAll(1, 2, 3, 4,5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        selectRoom.getItems().addAll("room 1", "room 2", "room 3");
    }

    @FXML
    public void searchAction (){
        String input = searchField.getText();
        if(input != null){
            for(Pet pet: Pet.pets){
                if(pet.getId() == Integer.parseInt(input)){
                    this.pet = pet;
                    break;
                }
            }
        }
    }
    @FXML
    public void choiceSlot(MouseEvent event) throws IOException{
        int choiceSlot =  selectSlot.getSelectionModel().getSelectedItem();
        for(int i=0; i<15;i++){
            if (choiceSlot== i){
                System.out.println(i);
            }
        }
    }

    @FXML
    public void choiceRoom(MouseEvent event) throws IOException{
        String choiceStatus = selectRoom.getSelectionModel().getSelectedItem();
        System.out.println(choiceStatus);
        if(choiceStatus.equals("room 1")){
            //   pet.setStatus(choiceStatus);
            //pet.whichRoom
            // pet.setRoomNumber(2);
            for (int i=0; i<Room.SLOTS; i++){
//                if(Room.rooms[2].pets[i]== null){
//                    System.out.println("yes");
//                    selectSlot.getItems().addAll(i+1);
//                }
                System.out.println(i);
            }
            System.out.println("yes1");
            selectSlot.setVisible(true);
        }
         if (choiceStatus.equals("room 2")){
            //  pet.setStatus(choiceStatus);
            // pet.setRoomNumber(3);
            for (int i=0; i<Room.SLOTS; i++){
                if(Room.rooms[3].pets[i]== null){
                    System.out.println("yes");
                    selectSlot.getItems().addAll(i+1);
                }
            }
            selectSlot.setVisible(true);
        }
         if (choiceStatus.equals("room 3")){
            //  pet.setStatus(choiceStatus);
            // pet.setRoomNumber(4);
            for (int i=0; i<Room.SLOTS; i++){
                if(Room.rooms[4].pets[i]== null){
                    System.out.println("yes");
                    selectSlot.getItems().addAll(i+1);
                }
            }
            selectSlot.setVisible(true);
        }
    }
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("bookRoom.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        bookRoom controller=loader.getController();
        controller.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
}