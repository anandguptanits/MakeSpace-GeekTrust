package com.example.geektrust.service;
import com.example.geektrust.database.BufferTimeManager;
import com.example.geektrust.database.MeetingRoomManager;
import com.example.geektrust.enums.RoomType;
import com.example.geektrust.exception.IncorrectInputException;
import com.example.geektrust.exception.NoVacantRoomException;
import com.example.geektrust.handler.BookingHandler;
import com.example.geektrust.model.Interval;
import com.example.geektrust.model.MeetingRoom;
import com.example.geektrust.utility.BookingValidator;
import com.example.geektrust.utility.Printer;

public class MeetingRoomBookingService {

    private final MeetingRoomManager meetingRoomManager;
    private final BufferTimeManager bufferTimeManager;
    private final BookingHandler bookingHandler;
    private final Printer printer;

    public MeetingRoomBookingService(MeetingRoomManager meetingRoomManager, BookingHandler bookingHandler, BufferTimeManager bufferTimeManager, Printer printer) {
        this.meetingRoomManager = meetingRoomManager;
        this.bookingHandler = bookingHandler;
        this.bufferTimeManager = bufferTimeManager;
        this.printer = printer;
    }

    public void getVacancy(Interval interval) {
        try {
            handleInputAndAvailabilityCheck(interval);
            checkAndPrintAvailability(interval);
        } catch (IncorrectInputException | NoVacantRoomException e) {
            handleException(e);
        }
    }

    public void bookMeetingRoom(Interval interval, int capacity) {
        try {
            handleInputAndAvailabilityCheck(interval);

            MeetingRoom availableRoom = bookingHandler.bookHandler(interval, capacity);
            if (availableRoom == null || !availableRoom.bookRoomForInterval(interval)) {
                throw new NoVacantRoomException();
            }
            printer.printBookRoom(availableRoom);
        } catch (IncorrectInputException | NoVacantRoomException e) {
            handleException(e);
        }
    }

    private void handleInputAndAvailabilityCheck(Interval interval) throws IncorrectInputException, NoVacantRoomException {
        if (!BookingValidator.validateInputInterval(interval)) {
            throw new IncorrectInputException();
        }else if(!BookingValidator.intervalNotOverlapBufferTime(interval, bufferTimeManager.getBufferTimeCache()))
        {
            throw new NoVacantRoomException();
        }
    }

    private void checkAndPrintAvailability(Interval interval) {
        boolean isCCaveAvailable = isRoomTypeAvailable(RoomType.C_CAVE, interval);
        boolean isDTowerAvailable = isRoomTypeAvailable(RoomType.D_TOWER, interval);
        boolean isGMansionAvailable = isRoomTypeAvailable(RoomType.G_MANSION, interval);

        if (!isCCaveAvailable && !isDTowerAvailable && !isGMansionAvailable) {
            printer.printNoVacantRoom();
        } else {
            printer.printAvailableTypeMeetingRoom(isCCaveAvailable, isDTowerAvailable, isGMansionAvailable);
        }
    }

    private boolean isRoomTypeAvailable(RoomType roomType, Interval interval) {
        return meetingRoomManager.getAllMeetingRoom()
                .stream()
                .filter(room -> room.getRoomType().equals(roomType))
                .anyMatch(room -> room.isRoomAvailable(interval));
    }


    private void handleException(Exception exception) {
        if (exception instanceof IncorrectInputException) {
            printer.printIncorrectInput();
        } else if (exception instanceof NoVacantRoomException) {
            printer.printNoVacantRoom();
        }
    }
}
