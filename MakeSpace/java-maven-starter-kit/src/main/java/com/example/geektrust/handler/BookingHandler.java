package com.example.geektrust.handler;
import com.example.geektrust.database.MeetingRoomManager;
import com.example.geektrust.enums.RoomType;
import com.example.geektrust.model.Interval;
import com.example.geektrust.model.MeetingRoom;

import java.util.List;
import java.util.Optional;


public abstract class BookingHandler{

    private BookingHandler next;
    private final MeetingRoomManager meetingRoomManager;

    protected BookingHandler(MeetingRoomManager meetingRoomManager) {
        this.meetingRoomManager = meetingRoomManager;
    }

    public BookingHandler setNextBookingHandler(BookingHandler bookingHandler)
    {
        this.next=bookingHandler;
        return next;
    }

    public abstract MeetingRoom bookHandler(Interval interval,int capacity);

    protected MeetingRoom handleNext(Interval interval,int capacity)
    {
        if(next==null)
            return null;

        return next.bookHandler(interval,capacity);
    }

    protected Optional<MeetingRoom> getAvailableRoomWithType(RoomType roomType,Interval interval,int capacity)
    {
        if (capacity > roomType.getCapacity()) {
            return Optional.empty();
        }
        List<MeetingRoom> CCaveMeetingRooms=meetingRoomManager.getAllMeetingRoomByType(roomType);
        return CCaveMeetingRooms.stream().filter(mR -> mR.isRoomAvailable(interval)).findFirst();
    }

}
