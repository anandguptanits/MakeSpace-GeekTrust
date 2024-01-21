package com.example.geektrust.utility;

import com.example.geektrust.database.BufferTimeManager;
import com.example.geektrust.database.MeetingRoomManager;
import com.example.geektrust.handler.BookingHandler;
import com.example.geektrust.handler.CCaveBookingHandler;
import com.example.geektrust.handler.DTowerBookingHandler;
import com.example.geektrust.handler.GMansionBookingHandler;
import com.example.geektrust.model.CCave;
import com.example.geektrust.model.DTower;
import com.example.geektrust.model.GMansion;
import com.example.geektrust.model.Interval;
import com.example.geektrust.service.MeetingRoomBookingService;

public class CommandExecutor {

    Printer printer=new Printer();

    private final MeetingRoomManager meetingRoomManager=new MeetingRoomManager();

    BookingHandler bookingHandler=new CCaveBookingHandler(meetingRoomManager);

    BufferTimeManager bufferTimeManager=new BufferTimeManager();

    MeetingRoomBookingService meetingRoomBookingService
            =new MeetingRoomBookingService(meetingRoomManager,bookingHandler,bufferTimeManager,printer);

    public CommandExecutor(){
        addMeetingRooms();
        addBufferTime();
        setBookingHandler();
    }

    private void setBookingHandler() {
        bookingHandler.setNextBookingHandler(new DTowerBookingHandler(meetingRoomManager))
                .setNextBookingHandler(new GMansionBookingHandler(meetingRoomManager));
    }

    private void addBufferTime() {

        bufferTimeManager.addInterval(new Interval("09:00","09:15"));
        bufferTimeManager.addInterval(new Interval("13:15","13:45"));
        bufferTimeManager.addInterval(new Interval("18:45","19:00"));

    }

    private void addMeetingRooms() {
        meetingRoomManager.addMeetingRoom(new CCave());
        meetingRoomManager.addMeetingRoom(new DTower());
        meetingRoomManager.addMeetingRoom(new GMansion());
    }

    public void executeCommand(String[] command)
    {
        if(command[0].equals("VACANCY"))
        {
            meetingRoomBookingService.getVacancy(new Interval(command[1],command[2]));
        }else if(command[0].equals("BOOK"))
        {
            meetingRoomBookingService.bookMeetingRoom(new Interval(command[1],command[2]),Integer.parseInt(command[3]));
        }
    }

}
