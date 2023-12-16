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

    Integer choiceSlot0;
    private List<Integer>slots=new ArrayList<>();
    private List<Integer>choosedslots=new ArrayList<>();
    private List<Integer> setdataAh()
    {
        for (int i = 1; i <= 20; i++) {
            slots.add(i);
        }
        return slots;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setdataAh();

        selectSlot.getItems().addAll(slots);
        selectRoom.getItems().addAll("room 1", "room 2", "room 3");

        selectRoom.setOnAction(this::choiceRoom);
        selectSlot.setOnAction(this::choiceSlot);
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
    public void choiceSlot(ActionEvent event){
        choiceSlot0 =  selectSlot.getValue();
        System.out.println(choiceSlot0);
    }

    @FXML
    public void choiceRoom(ActionEvent event){
//        String choiceStatus = selectRoom.getSelectionModel().getSelectedItem();
        String choiceStatus = selectRoom.getValue();
        System.out.println(choiceStatus);
        if(choiceStatus.equals("room 1")){
            System.out.println("yes1");
            selectSlot.setVisible(true);
        }
        if (choiceStatus.equals("room 2")){
            System.out.println("yes2");
            selectSlot.setVisible(true);
        }
        if (choiceStatus.equals("room 3")){
            System.out.println("yes3");
            selectSlot.setVisible(true);
        }
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