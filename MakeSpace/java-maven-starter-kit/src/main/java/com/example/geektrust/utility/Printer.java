package com.example.geektrust.utility;

import com.example.geektrust.enums.RoomType;
import com.example.geektrust.model.MeetingRoom;

public class Printer {

    public void printBookRoom(MeetingRoom meetingRoom){
        System.out.println(meetingRoom.getRoomType().getDisplayName());
    }

    public void printIncorrectInput()
    {
        System.out.println("INCORRECT_INPUT");
    }

    public void printNoVacantRoom()
    {
        System.out.println("NO_VACANT_ROOM");
    }

    public void printAvailableTypeMeetingRoom(Boolean cCave, Boolean dTower, Boolean gMansion) {
        printIfTrue(cCave, RoomType.C_CAVE);
        printIfTrue(dTower, RoomType.D_TOWER);
        printIfTrue(gMansion, RoomType.G_MANSION);
        System.out.println(); // Move to the next line after printing the available rooms
    }

    private void printIfTrue(boolean condition, RoomType roomType) {
        if (condition) {
            System.out.print(roomType.getDisplayName() + " ");
        }
    }
}
