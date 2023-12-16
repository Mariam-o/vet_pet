package com.example.vet_pet;
import java.util.ArrayList;

public class Pet {
    public static ArrayList<Pet> Pets = new ArrayList<>();
    public static final int PETSNUMBER = 20;
    public static Pet[] pets = new Pet[PETSNUMBER];

    private String name;
    private boolean assignedToRoom;
    private int id;
    private String prescription;

    public Pet() {

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    private int roomNumber;

    private enum Pet_type {
        Cat, Dog
    }

    public enum PetStatus {
        Pendnding, no, on_progress, totally_treated
    }
    public enum Room {
        room1, room2, room3, room4
    }

    PetStatus status;
    Pet_type type;
    Room whichRoom;
    public Pet(String name,int id, PetStatus status, Pet_type type){
        this.name = name;
        this.type = type;
        this.status = status;
        this.id = id;
    } public Pet(String name,int id, PetStatus status, Pet_type type, String prescription){
        this.prescription = prescription;
        this.name = name;
        this.type = type;
        this.status = status;
        this.id = id;
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


    public String getPrescription() {
        return prescription;
    }


    Pet(String name, Pet_type type) {
        this.id = Pets.size() + 1;
        this.name = name;
        this.type = type;
        this.status = PetStatus.Pendnding;
    }

    //returning null if there's no such pet
    public static Pet getPet(int id) {
        for (Pet pet : Pets) {
            if (pet.getId() == id)
                return pet;
        }
        return null;
    }
    // status
    public void updateStatus(PetStatus status) {
        this.status = status;

    }
    public void setStatus(String status) {
        this.status = PetStatus.valueOf(status);
    }
    public PetStatus getStatus() {
        return status;
    }

    public static void setData() {
        pets[0] = new Pet("momo", 2022170999, PetStatus.Pendnding, Pet_type.Cat);
        // pets[0].setPrescription("test sick");
        pets[1] = new Pet("bobo", 2022170998,  PetStatus.Pendnding, Pet_type.Dog);
        pets[2] = new Pet("nono", 2022170997, PetStatus.Pendnding, Pet_type.Cat);
        pets[3] = new Pet("lolo", 2022170996, PetStatus.Pendnding, Pet_type.Cat);
        pets[4] = new Pet("soso", 2022170995, PetStatus.Pendnding, Pet_type.Dog);
        pets[5] = new Pet("bobo", 2022170998,  PetStatus.Pendnding, Pet_type.Dog);
        pets[6] = new Pet("nono", 2022170997, PetStatus.Pendnding, Pet_type.Cat);
        pets[7] = new Pet("lolo", 2022170996, PetStatus.Pendnding, Pet_type.Cat);
        pets[8] = new Pet("soso", 2022170995, PetStatus.Pendnding, Pet_type.Dog);
        pets[9] = new Pet("soso", 2022170995, PetStatus.Pendnding, Pet_type.Dog);
        pets[10] = new Pet("soso", 2022170995, PetStatus.Pendnding, Pet_type.Dog);
        pets[11] = new Pet("soso", 2022170995, PetStatus.Pendnding, Pet_type.Dog);
        pets[12] = new Pet("soso", 2022170995, PetStatus.Pendnding, Pet_type.Dog);
        pets[13] = new Pet("soso", 2022170995, PetStatus.Pendnding, Pet_type.Dog);
        pets[14] = new Pet("soso", 2022170995, PetStatus.Pendnding, Pet_type.Dog);
        pets[15] = new Pet("momo", 2022170989, PetStatus.Pendnding, Pet_type.Cat);
        pets[16] = new Pet("momo", 2022170979, PetStatus.Pendnding, Pet_type.Cat);
        pets[17] = new Pet("momo", 2022170969, PetStatus.Pendnding, Pet_type.Cat);
        pets[18] = new Pet("momo", 2022170969, PetStatus.Pendnding, Pet_type.Cat);
        pets[19] = new Pet("momo", 2022170959, PetStatus.Pendnding, Pet_type.Cat);

        // pets[19] = new Pet( "", 2022170980, "", "");
    }
}