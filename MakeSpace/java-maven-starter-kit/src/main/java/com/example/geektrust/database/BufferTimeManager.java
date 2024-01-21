package com.example.geektrust.database;
import com.example.geektrust.model.Interval;
import java.util.ArrayList;
import java.util.List;

public class BufferTimeManager {

    private final List<Interval> bufferTimeCache;

    public BufferTimeManager() {
        this.bufferTimeCache = new ArrayList<>();
    }

    public void addInterval(Interval interval)
    {
        bufferTimeCache.add(interval);
    }

    public void removeInterval(Interval interval)
    {
        bufferTimeCache.remove(interval);
    }

    public List<Interval> getBufferTimeCache() {
        return List.copyOf(bufferTimeCache);
    }
}
