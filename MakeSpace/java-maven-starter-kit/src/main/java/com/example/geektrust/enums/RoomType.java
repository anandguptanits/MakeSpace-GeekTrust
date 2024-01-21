package com.example.geektrust.enums;

public enum RoomType {
    C_CAVE("C-Cave", 3),
    D_TOWER("D-Tower", 7),
    G_MANSION("G-Mansion", 20);

    private final String displayName;
    private final int capacity;

    // Constructor to associate a display name and capacity with each enum constant
    RoomType(String displayName, int capacity) {
        this.displayName = displayName;
        this.capacity = capacity;
    }

    // Getter method to retrieve the display name
    public String getDisplayName() {
        return displayName;
    }

    // Getter method to retrieve the capacity
    public int getCapacity() {
        return capacity;
    }
}

