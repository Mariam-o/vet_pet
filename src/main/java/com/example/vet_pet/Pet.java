package com.example.vet_pet;
import java.util.ArrayList;

public class Pet {
    public static ArrayList<Pet> Pets = new ArrayList<>();
    public static ArrayList<String> Pets_string = new ArrayList<>();

    private String name;
    private int id;
    private String prescription;
    private String describe;
    private boolean readyForAdopt = false;
    private String gender;
    private String imgSrc;
    private String color;
    public int slot = -1;

    public Pet() {

    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    private int roomNumber;

    public enum Pet_type {
        Cat, Dog
    }

    public enum PetStatus {
        Pendnding, no, on_progress, totally_treated
    }

    public PetStatus status;
    public Pet_type type;
    public Pet(String name, int id, PetStatus status, Pet_type type){
        this.name = name;
        this.type = type;
        this.status = status;
        this.id = id;
    } public Pet(String name, int id, PetStatus status, Pet_type type, String prescription, boolean readyForAdopt){
        this.prescription = prescription;
        this.name = name;
        this.type = type;
        this.status = status;
        this.id = id;
        this.readyForAdopt= readyForAdopt;
    }
    public Pet(String name, Pet_type type) {
        this.id = Pets.size() + 1;
        this.name = name;
        this.type = type;
        this.status = PetStatus.Pendnding;
    }
    public void setReadyForAdopt(boolean readyForAdopt) {
        this.readyForAdopt = readyForAdopt;
    }
    public boolean getReadyForAdopt(){
        return readyForAdopt;
    }
    public int getSlot() {
        return slot;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    public String getImgSrc() {
        return imgSrc;
    }
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getPrescription() {
        return prescription;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    //returning null if there's no such pet
    public static Pet getPet(int id) {
        for (Pet pet : Pets) {
            if (pet.getId() == id)
                return pet;
        }
        return null;
    }
    public void updateStatus(PetStatus status) {
        this.status = status;

    }
    public void setStatus(PetStatus status) {
        this.status = status;
    }
    public PetStatus getStatus() {
        return status;
    }
    public void setSlot(int slot) {
        this.slot = slot;
    }
    public Pet_type getType() {
        return type;
    }
    public void setType(Pet_type type) {
        this.type = type;
    }
    @Override
    public String toString(){
        String data = "";
        String type;
        if(getType() == Pet_type.Cat)
            type = "cat";
        else
            type = "dog";
        String status;
        if(getStatus() == PetStatus.no)
            status = "no";
        else if (getStatus() == PetStatus.Pendnding)
            status = "pending";
        else if (getStatus() == PetStatus.totally_treated)
            status = "treated";
        else
            status = "on";

        data = data.concat(String.valueOf(getId()));
        data = data.concat(",").concat(getName()).concat(",");
        data = data.concat(getGender()).concat(",");
        data = data.concat(type).concat(",");
        data = data.concat(getImgSrc()).concat(",");
        data = data.concat(status).concat(",");
        data = data.concat(getDescribe()).concat(",");
        data = data.concat(String.valueOf(getRoomNumber()));
        data = data.concat(",").concat(String.valueOf(getSlot())).concat(",");
        data = data.concat(getColor()).concat(",");
        data = data.concat(getPrescription());

        return data;
    }
}
