package com.example.geektrust.model;

import com.example.geektrust.enums.RoomType;

public class GMansion extends MeetingRoom{
    private String roomId;
    public GMansion() {
        super(RoomType.G_MANSION);
        roomId=RoomType.G_MANSION.getDisplayName();
    }
}
