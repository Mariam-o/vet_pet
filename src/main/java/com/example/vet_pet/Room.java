package com.example.vet_pet;

import java.util.ArrayList;
import java.util.List;

public class Room
{
    public static final int SLOTS = 15;
    public static ArrayList<Room> rooms = new ArrayList<>();
    public Room[] room = new Room[SLOTS];

    //test
    enum roomType{
        examination, operation
    }
    static roomType roomType;
    private int roomNumber;
    private List<Integer> availableSlots;
    public Room(roomType roomType, int roomNumber)
    {
        this.roomType = roomType;
        this.roomNumber = roomNumber;

        this.availableSlots= new ArrayList<>();
        for (int i= 0 ; i< 15 ;i++){
            this.availableSlots.add(i);
        }
    }



    private Pet[] petInRoom;
   // public static Room[] rooms = new Room[4];
    public Room(){
        this.petInRoom= new Pet[SLOTS];
    }
    public void assignPetToSlot(int slotNumber, Pet pet){
        // need to assign condition to gui assign && if (beds[i] != null)
        petInRoom[slotNumber]= pet;
    }
    public boolean canAssign(){
        for(int i=0; i<SLOTS; i++){
            if(petInRoom[i] == null)
                return true;
        }
        return false;
    }

    public void setData() {
        room[0]= new Room(Room.roomType.examination, 0);
        room[1] = new Room(Room.roomType.operation,1);
        room[2] = new Room(Room.roomType.operation,2);
        room[3] = new Room(Room.roomType.operation,3);
    }
}
