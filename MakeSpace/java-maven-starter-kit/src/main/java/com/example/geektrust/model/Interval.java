package com.example.geektrust.model;
import lombok.Data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
public class Interval {
    private LocalTime startTime;
    private LocalTime endTime;

    public Interval(String startTime,String endTime)
    {
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm");
        this.startTime=LocalTime.parse(startTime,dateTimeFormatter);
        this.endTime=LocalTime.parse(endTime,dateTimeFormatter);
    }
}
