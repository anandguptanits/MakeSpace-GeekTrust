package com.example.geektrust.model;

import com.example.geektrust.enums.RoomType;

public class CCave extends MeetingRoom{

    private String roomId;

    public CCave() {
        super(RoomType.C_CAVE);
        this.roomId=RoomType.C_CAVE.getDisplayName();
    }
}
