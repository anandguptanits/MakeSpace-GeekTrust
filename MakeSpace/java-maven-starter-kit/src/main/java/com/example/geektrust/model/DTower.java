package com.example.geektrust.model;

import com.example.geektrust.enums.RoomType;

public class DTower extends MeetingRoom{
    private String roomId;
    public DTower() {
        super(RoomType.D_TOWER);
        roomId=RoomType.D_TOWER.getDisplayName();
    }
}
