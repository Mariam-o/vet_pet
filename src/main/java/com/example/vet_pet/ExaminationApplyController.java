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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ExaminationApplyController implements Initializable {

    //test room
    private Room[] rooms;

//    public void setData(){
//        rooms= new Room[]{
//                new Room(Room.roomType.examination),
//                new Room(Room.roomType.operation),
//
//        };
//    }

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

    //test room
    Integer roomNumber;


    Integer choiceSlot0;
    private List<Integer>slots=new ArrayList<>();
    private List<Integer>choosedslots=new ArrayList<>();
    private List<Integer> setdataAh()
    {
        for (int i = 1; i <= 15; i++) {
            slots.add(i);
        }
        return slots;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Room.setData();
        setdataAh();
        if(bookRoom.page == 2){
            selectRoom.getItems().addAll("room 2", "room 3", "room 4");
            selectRoom.setOnAction(this::choiceRoom);
            selectSlot.getItems().addAll(slots);
            selectSlot.setOnAction(this::choiceSlot);

        }
        else {
            selectSlot.setVisible(true);
            selectRoom.getItems().addAll("room 1");
            selectRoom.setOnAction(this::choiceRoom);
            selectSlot.getItems().addAll(slots);
            selectSlot.setOnAction(this::choiceSlot);
        }


    }
    @FXML
    public void searchAction (){
        String input = searchField.getText();
        if(input != null){
            for(int i=0; i< pet.Pets.size(); i++){
                Pet petA= new Pet();
                petA= pet.Pets.get(i);
                if(petA.getId() == Integer.parseInt(input)){
                    this.pet = petA;
                    break;
                }
            }
//            for(Pet pet: Pet.pets){
//                if(pet.getId() == Integer.parseInt(input)){
//                    this.pet = pet;
//                    break;
//                }
//            }
        }
    }
    public void choiceSlot(ActionEvent event){
        System.out.println("in choice slot");
        choiceSlot0 =  selectSlot.getValue();
        Room.rooms.get(roomNumber).setPet(choiceSlot0,pet);
        System.out.println(choiceSlot0);
        System.out.println(choiceSlot0);
    }
    @FXML
    public void choiceRoom(ActionEvent event){
        if(bookRoom.page == 2){
            String choiceStatus = selectRoom.getValue();
            if(choiceStatus.equals("room 2")){
                for (int i = 0; i < Room.rooms.get(1).getPets().length; i++) {
                    System.out.println("worked");
                    if(pet == null){
                        slots.add(i+1);
                        System.out.println(i+1);
                    }
                }
                selectSlot.setVisible(true);
                choiceSlot(event);
                roomNumber = 2; // new
            }
            if (choiceStatus.equals("room 3")){
                System.out.println("yes2");
                for (int i = 0; i < Room.rooms.get(2).getPets().length; i++) {
                    if(pet == null)
                        slots.add(i+1);
                }
                selectSlot.setVisible(true);
                choiceSlot(event);
                roomNumber = 3; // new
            }
            if (choiceStatus.equals("room 4")){
                System.out.println("yes3");
                for (int i = 0; i < Room.rooms.get(3).getPets().length; i++) {
                    if(pet == null)
                        slots.add(i+1);
                }
                selectSlot.setVisible(true);
                choiceSlot(event);
                roomNumber = 4; // new
            }
        }//else{

        //}

//        String choiceStatus = selectRoom.getSelectionModel().getSelectedItem();



        // test room
//        if(roomNumber!= null && rooms.hasEmptySlots()){
//
//        }
    }
    public void update(Event event){
        if(choiceSlot0!=null)
        {
            selectSlot.getItems().remove(choiceSlot0);
            slots.remove(choiceSlot0);
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