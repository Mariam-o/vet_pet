package com.example.vet_pet;

public class Room
{
    public static final int SLOTS = 15;
    public Pet[] pets = new Pet[SLOTS];
    private Pet[] petInRoom;
    public static Room[] rooms = new Room[4];
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


}
