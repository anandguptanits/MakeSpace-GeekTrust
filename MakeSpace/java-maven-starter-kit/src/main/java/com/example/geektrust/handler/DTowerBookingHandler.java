package com.example.geektrust.handler;
import com.example.geektrust.database.MeetingRoomManager;
import com.example.geektrust.enums.RoomType;
import com.example.geektrust.model.Interval;
import com.example.geektrust.model.MeetingRoom;
import java.util.List;
import java.util.Optional;

public class DTowerBookingHandler extends BookingHandler{

    public DTowerBookingHandler(MeetingRoomManager meetingRoomManager) {
        super(meetingRoomManager);
    }


    @Override
    public MeetingRoom bookHandler(Interval interval, int capacity) {
        Optional<MeetingRoom> meetingRoomOptional=getAvailableRoomWithType(RoomType.D_TOWER,interval,capacity);

        if(meetingRoomOptional.isPresent())
            return meetingRoomOptional.get();

        return this.handleNext(interval,capacity);
    }
}
