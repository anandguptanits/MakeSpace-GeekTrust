package com.example.geektrust.model;
import com.example.geektrust.enums.RoomType;
import com.example.geektrust.utility.BookingValidator;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class MeetingRoom {

    private RoomType roomType;
    private List<Interval> bookedInterval;

    public MeetingRoom(RoomType roomType)
    {
        this.roomType=roomType;
        bookedInterval=new ArrayList<>();
    }

    public boolean isRoomAvailable(Interval interval)
    {
        if(BookingValidator.intervalNotOverlapBufferTime(interval,bookedInterval))
            return true;
        return false;
    }

    public boolean bookRoomForInterval(Interval interval)
    {
        if(!isRoomAvailable(interval))
        {
            return false;
        }
        bookedInterval.add(interval);
        return true;
    }
}
