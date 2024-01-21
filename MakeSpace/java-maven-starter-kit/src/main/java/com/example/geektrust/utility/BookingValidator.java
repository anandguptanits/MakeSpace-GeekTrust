package com.example.geektrust.utility;
import com.example.geektrust.model.Interval;
import java.time.LocalTime;
import java.util.List;

public class BookingValidator {

    public static boolean validateInputInterval(Interval interval)
    {
         LocalTime start=interval.getStartTime();
         LocalTime end=interval.getEndTime();

         if (start.isAfter(end) || start.getMinute()%15!=0) {
            return false;
         }
        return true;
    }

    public static boolean intervalNotOverlapBufferTime(Interval interval,List<Interval> bufferTimeCache)
    {

        for(Interval bInterval:bufferTimeCache)
        {
            LocalTime bIntervalStart=bInterval.getStartTime();
            LocalTime bIntervalEnd=bInterval.getEndTime();

            LocalTime start=interval.getStartTime();
            LocalTime end=interval.getEndTime();

            // Check if Interval 1 is completely before or equal Interval 2 or vice versa
            if (!(end.isBefore(bIntervalStart) || end.equals(bIntervalStart) || bIntervalEnd.isBefore(start) || bIntervalEnd.equals(start))) {
                return false;
            }
        }
        return true;
    }

}
