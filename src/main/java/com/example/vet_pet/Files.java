package com.example.vet_pet;

import java.io.*;
import java.util.ArrayList;

public class Files {
    public static ArrayList<String>  readFile(File file) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String line = "";
            BufferedReader b = new BufferedReader(new FileReader(file));
            while ((line = b.readLine()) != null) {
                arrayList.add(line);
            }
            b.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
    public static void writePetsOnFile (File file){
        try {
            BufferedWriter b = new BufferedWriter(new FileWriter(file));
            for (Pet data: Pet.Pets){
                b.write(data.toString());
                b.newLine();
            }
            b.close();
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeRoomOnFile (File file){
        try {
            BufferedWriter b = new BufferedWriter(new FileWriter(file));
            for (Room data: Room.rooms){
                b.write(data.toString());
                b.newLine();
            }
            b.close();
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Pet> getAllPets(ArrayList<String> allData){
        ArrayList<Pet> allPets = new ArrayList<>();
        for(String onePet: allData){
            String[] data = onePet.split(",");
            Pet pet = new Pet();
            pet.setId(Integer.parseInt(data[0]));
            pet.setName(data[1]);
            pet.setGender(data[2]);
            Pet.Pet_type type;
            if(data[3].equals("cat"))
                type = Pet.Pet_type.Cat;
            else
                type = Pet.Pet_type.Dog;
            pet.setType(type);
            pet.setImgSrc(data[4]);
            String stat = data[5];
            Pet.PetStatus status;
            if(stat.equals("treated"))
                status = Pet.PetStatus.totally_treated;
            else if(stat.equals("pending"))
                status = Pet.PetStatus.Pendnding;
            else if (stat.equals("no"))
                status = Pet.PetStatus.no;
            else
                status = Pet.PetStatus.on_progress;
            pet.setStatus(status);
            pet.setDescribe(data[6]);
            pet.setRoomNumber(Integer.parseInt(data[7]));
            pet.setSlot(Integer.parseInt(data[8]));
            pet.setColor(data[9]);
            pet.setPrescription(data[10]);
            allPets.add(pet);
        }
        return allPets;
    }
    public static ArrayList<Room> getAllRooms(ArrayList<String> allData){
        ArrayList<Room> rooms = new ArrayList<>();
        for (String oneRoom: allData){
            System.out.println(oneRoom);
            String[] data = oneRoom.split(",");
            Room room = new Room();
            String type = data[0];
            Room.roomType roomType;
            if(type.equals("operation"))
                roomType = Room.roomType.operation;

            else
                roomType = Room.roomType.examination;

            room.setRoomType(roomType);
            Pet[] pets = new Pet[15];
            for (int i =data.length - 1; i>0; i--){
                for(Pet pet: Pet.Pets){
                    if(pet.getId() == Integer.parseInt(data[i])) {
                        pets[pet.getSlot()] = pet;
                    }
                }
            }
            room.setPets(pets);
            rooms.add(room);
        }
        return rooms;
    }

}
