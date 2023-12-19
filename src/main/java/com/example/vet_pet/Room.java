package com.example.vet_pet;

import java.util.ArrayList;
import java.util.List;

public class Room
{

    static final int SLOTS = 15;
    static ArrayList<Room> rooms = new ArrayList<>();
    private Pet[] pets;

    //NEW TEST
    enum roomType{
        examination, operation
    }

    public Pet[] getPets() {
        return pets;
    }

    public void setPets(Pet[] pets) {
        this.pets = pets;
    }

    //0 >> operation , 1-3 examination

    static void setData(){
        Pet pet = new Pet("momo", 2022170999, Pet.PetStatus.Pendnding, Pet.Pet_type.Cat);
        Pet pet1 = new Pet("momo", 2022170998, Pet.PetStatus.Pendnding, Pet.Pet_type.Cat);
        Pet pet2 = new Pet("momo", 2022170997, Pet.PetStatus.Pendnding, Pet.Pet_type.Cat);
        Pet pet3 = new Pet("momo", 2022170996, Pet.PetStatus.Pendnding, Pet.Pet_type.Cat);
        Room room1 = new Room(Room.roomType.examination);
        Room room2 = new Room(Room.roomType.operation);
        Room room3 = new Room(Room.roomType.operation);
        Room room4 = new Room(Room.roomType.operation);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.get(0).assignPetToSlot(3,pet);
        rooms.get(1).assignPetToSlot(6,pet1);
        rooms.get(2).assignPetToSlot(7,pet2);
        rooms.get(3).assignPetToSlot(12,pet3);




//        Pet pet = new Pet("lolo", Pet.Pet_type.Dog);
//
//        Room room = new Room(Room.roomType.examination);
//        Room room2 = new Room(Room.roomType.operation);
//
//        rooms.add(0,room);
//        rooms.add(1,room2);
//        rooms.add(2,room2);
//        rooms.add(3,room2);
//        Pet []pets1 = new Pet[SLOTS];
//        Pet []pets2 = new Pet[SLOTS];
//        Pet []pets3 = new Pet[SLOTS];
//        Pet []pets4 = new Pet[SLOTS];
//        pets1[2] = pet;
//        pets2[5] = pet;
//        pets3[6] = pet;
//        pets4[11] = pet;
//        rooms.get(0).setPets(pets1);
//        rooms.get(1).setPets(pets2);
//        rooms.get(2).setPets(pets3);
//        rooms.get(3).setPets(pets4);

    }
    private static roomType roomType;


    public Room(roomType roomType){
        this.roomType = roomType;
        this.pets = new  Pet[SLOTS];
//;        this.slots = new ArrayList<>();
//        for (int i= 1; i<= 15; i++){
//            slots.add(null);
//        }
    }
    public boolean hasEmptySlots(){
        for (Pet pet : pets){
            if(pet == null){
                return true;
            }
        }
        return false;
    }
    public int getAvailableSlots(){
        for (int i= 0; i< pets.length; i++ ){
            if (pets[i]== null){
                return i +1;
            }
        }
        return -1; // no available slots
    }
    public void assignPetToSlot(int slot, Pet pet){
        pets[slot-1] = pet;
    }
    public roomType getRoomType() {
        return roomType;
    }

    public Pet getPet(int index){
        return pets[index];
    }
    public void setPet(int index, Pet pet){
        pets[index] = pet;
    }
//

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
//    public static final int SLOTS = 15;
//    public static ArrayList<Room> rooms = new ArrayList<>();
//    public Room[] room = new Room[SLOTS];
//
//    //test
//    enum roomType{
//        examination, operation
//    }
//    static roomType roomType;
//    private int roomNumber;
//    private List<Integer> availableSlots;
//    public Room(roomType roomType, int roomNumber)
//    {
//        this.roomType = roomType;
//        this.roomNumber = roomNumber;
//
//        this.availableSlots= new ArrayList<>();
//        for (int i= 0 ; i< 15 ;i++){
//            this.availableSlots.add(i);
//        }
//    }
//
//
//
//    private Pet[] petInRoom;
//   // public static Room[] rooms = new Room[4];
//    public Room(){
//        this.petInRoom= new Pet[SLOTS];
//    }
//    public void assignPetToSlot(int slotNumber, Pet pet){
//        // need to assign condition to gui assign && if (beds[i] != null)
//        petInRoom[slotNumber]= pet;
//    }
//    public boolean canAssign(){
//        for(int i=0; i<SLOTS; i++){
//            if(petInRoom[i] == null)
//                return true;
//        }
//        return false;
//    }
//
//    public void setData() {
//        room[0]= new Room(Room.roomType.examination, 0);
//        room[1] = new Room(Room.roomType.operation,1);
//        room[2] = new Room(Room.roomType.operation,2);
//        room[3] = new Room(Room.roomType.operation,3);
//    }
}
