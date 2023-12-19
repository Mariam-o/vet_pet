package com.example.vet_pet;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.valueOf;
import static java.lang.String.*;

public class ExaminationApplyController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField searchField;
    static Pet pet;
    @FXML
    private ChoiceBox<String> selectRoom;
    @FXML
    private ChoiceBox<Integer> selectSlot;
    @FXML
    private Label alert;

    //test room
    Integer roomNumber;


    Integer choiceSlot0;
    private List<Integer>slots=new ArrayList<>();
    private List<Integer>choosedslots=new ArrayList<>();
    //    private List<Integer> setdataAh()
//    {
//        for (int i = 1; i <= 15; i++) {
//            slots.add(i);
//        }
//        return slots;
//    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Room.setData();
        Pet.setData();

        if(bookRoom.page == 2){
            //operation
            //vet booking operation after
            selectRoom.getItems().addAll("room 2", "room 3", "room 4");
            selectRoom.setOnAction(this::choiceRoom);
            selectSlot.getItems().addAll(slots);
            selectSlot.setOnAction(this::choiceSlot);
        }
        else {
            //examination
            //there is pet
            selectRoom.getItems().addAll("room 1");
            selectRoom.setOnAction(this::choiceRoom);
            selectSlot.getItems().addAll(slots);
            selectSlot.setOnAction(this::choiceSlot);
        }
    }
    @FXML
    public void searchAction2 (){
        selectRoom.setValue("");
        selectSlot.setVisible(false);
        String input = searchField.getText();
        int id = Integer.parseInt(input);
         alert.setText("! NO ANIMAL AVAILABLE !");
        if(input != null){
            int roomNumber = -1;
            for(Pet pet: Pet.Pets){
                if(pet.getId() == id) {
                    this.pet = pet;
                    this.pet.setId(id);
                    System.out.println(id);
                    System.out.println("===========================================");
                    if(pet.slot != -1)
                        roomNumber = Room.FindPetInRoom(pet);
                    selectRoom.setDisable(false);
                    alert.setText("");
                }
            }
            if (Integer.parseInt(input) != pet.getId()) {
                restart();
                System.out.println("id ot found ------");
                alert.setText("! NO ANIMAL AVAILABLE !");
            }
            //vet in operation 2 3 4
            if(bookRoom.page == 2){
                if(roomNumber != -1){
                    //in examination
                    if(roomNumber > 1) {
                        System.out.println("in operation");
                        selectSlot.setVisible(false);
                        selectRoom.setValue("room" + roomNumber);
                        selectRoom.setDisable(true);
                        //alert.setText("Pet Already in Operation"); // could be wrong mess
                        alert.setText("Pet in System");
                    }
                }
            }
            //vet in exmination
            //pet in  operation
            else if(bookRoom.page == 1) {
                if(roomNumber != -1){
                    selectSlot.setVisible(false);
               //     selectSlot.setDisable(false);
                    selectRoom.setValue("room" + roomNumber);
                    selectRoom.setDisable(true);
                    alert.setText("Pet in System");
                }
            }
        }
    }

    public void choiceSlot(ActionEvent event){
        System.out.println("in choice slot");
        choiceSlot0 =  selectSlot.getValue();
//        Room.rooms.get(roomNumber).setPet(choiceSlot0,pet);
        System.out.println(choiceSlot0);
        System.out.println(choiceSlot0);
        //selectSlot.setValue(Integer.valueOf(String.valueOf(selectSlot.getValue())));
        // selectSlot.setValue(selectSlot.getValue());
    }
    @FXML
    public void choiceRoom(ActionEvent event){
        //operation
        if(bookRoom.page == 2){
            String choiceStatus = selectRoom.getValue();
            selectSlot.getItems().clear();
            if(choiceStatus.equals("room 2")){
                selectRoom.setValue("room_2");
                for (int i = 0; i < Room.rooms.get(1).getPets().length; i++) {
                    System.out.println(i);
                    System.out.println(Room.rooms.get(1).getPet(i) );
                    System.out.println(Room.rooms.get(1).getRoomType());
                    if(Room.rooms.get(1).getPet(i) == null){
                        selectSlot.getItems().add(i+1);
                    }
                }
                selectSlot.setVisible(true);
                choiceSlot(event);
                roomNumber = 1; // new
            }
            if (choiceStatus.equals("room 3")){
                selectRoom.setValue("room_3");
                System.out.println("yes2");
                for (int i = 0; i < Room.rooms.get(2).getPets().length; i++) {
                    System.out.println(i);
                    System.out.println(Room.rooms.get(2).getPet(i) );
                    if(Room.rooms.get(2).getPet(i) == null) {
                        selectSlot.getItems().add(i + 1);

                    }
                }
                selectSlot.setVisible(true);
                choiceSlot(event);
                roomNumber = 2; // new
            }
            if (choiceStatus.equals("room 4")){
                selectRoom.setValue("room_4");
                System.out.println("yes3");
                for (int i = 0; i < Room.rooms.get(3).getPets().length; i++) {
                    System.out.println(i);
                    System.out.println(Room.rooms.get(3).getPet(i) );
                    if(Room.rooms.get(3).getPet(i) == null)
                        selectSlot.getItems().add(i+1);
                }
                selectSlot.setVisible(true);
                choiceSlot(event);
                roomNumber = 3; // new
            }
        }
        //examination
        else {
            String choiceStatus = selectRoom.getValue();
            selectSlot.getItems().clear();

            if(choiceStatus != null){
                selectSlot.setVisible(true);
                selectSlot.setDisable(false);
                for (int i = 0; i < Room.rooms.get(0).getPets().length; i++) {
                    System.out.println(Room.rooms.get(0).getPet(i) );
                    if(Room.rooms.get(2).getPet(i) == null) {
                        selectSlot.getItems().add(i + 1);
                    }
                }
                roomNumber = 1;
               // selectSlot.setVisible(true);
                // choiceSlot(event);
            }
        }
    }
    @FXML
    public void updateData(Event event){
        if(choiceSlot0!=null)
        {
            Room.rooms.get(roomNumber).setPet(choiceSlot0-1,pet);
            Room.rooms.get(roomNumber).getPet(choiceSlot0-1).setSlot(choiceSlot0-1);
            restart();
        }
    }

    private void restart(){
        pet= null;
        selectSlot.setVisible(false);

        //selectRoom.setValue("");
        searchField.clear();
        selectRoom.setValue("");
        selectRoom.setDisable(true);
        selectSlot.setDisable(true);
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