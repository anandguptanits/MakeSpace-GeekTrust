package com.example.geektrust;

import com.example.geektrust.database.BufferTimeManager;
import com.example.geektrust.database.MeetingRoomManager;
import com.example.geektrust.handler.BookingHandler;
import com.example.geektrust.handler.CCaveBookingHandler;
import com.example.geektrust.handler.DTowerBookingHandler;
import com.example.geektrust.handler.GMansionBookingHandler;
import com.example.geektrust.service.MeetingRoomBookingService;
import com.example.geektrust.utility.CommandExecutor;
import com.example.geektrust.utility.Printer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            // the file to be opened for reading
            CommandExecutor commandExecutor=new CommandExecutor();
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               commandExecutor.executeCommand(sc.nextLine().split(" "));
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

    }
}
