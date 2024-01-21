package com.example.geektrust.database;

import com.example.geektrust.enums.RoomType;
import com.example.geektrust.model.MeetingRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingRoomManager {

    private final List<MeetingRoom> roomsDatabase;

    public MeetingRoomManager()
    {
        roomsDatabase=new ArrayList<>();
    }

    public void addMeetingRoom(MeetingRoom meetingRoom)
    {
        roomsDatabase.add(meetingRoom);
    }

    public List<MeetingRoom> getAllMeetingRoomByType(RoomType roomType)
    {
        return roomsDatabase.stream()
                        .filter(mR->mR.getRoomType().equals(roomType))
                        .collect(Collectors.toList());
    }

    public List<MeetingRoom> getAllMeetingRoom()
    {
        return List.copyOf(roomsDatabase);
    }
}
