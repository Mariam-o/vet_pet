package com.example.vet_pet;

import java.util.ArrayList;

public class Room
{
    static final int SLOTS = 15;
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<String> rooms_string = new ArrayList<>();
    private Pet[] pets;
    //NEW TEST
    enum roomType{
        examination, operation
    }
    roomType type;
    public Room(roomType roomType){
        this.roomType = roomType;
        this.pets = new  Pet[SLOTS];
    }
    public Room (){}
    public Pet[] getPets() {
        return pets;
    }
    public void setPets(Pet[] pets) {
        this.pets = pets;
    }
    private static roomType roomType;
    public roomType getRoomType() {
        return type;
    }
    public Pet getPet(int index){
        return pets[index];
    }
    public void setPet(int index, Pet pet){
        pets[index] = pet;
    }
    public void setRoomType(Room.roomType roomType) {
        this.type = roomType;
    }
    public static int FindPetInRoom(Pet pet){
        int index = 0;
        for (Room room: rooms){
            for (int i=0; i<15; i++){
                if(room.getPet(i) != null) {
                    if (pet.getId() == room.getPet(i).getId()) {
                        pet = room.getPet(i);
                        pet.setSlot(i);
                        return ++index;
                    }
                }
            }
            index ++;
        }
        pet.setSlot(-1);
        return -1;
    }
    @Override
    public String toString(){
        String data="";
        String type;
        if(getRoomType() == Room.roomType.examination)
            type = "examination";
        else
            type = "operation";
        data = data.concat(type);
        for(Pet pet: pets){
            if(pet != null)
                data = data.concat(",").concat(String.valueOf(pet.getId()));
        }
        return data;
    }
}
