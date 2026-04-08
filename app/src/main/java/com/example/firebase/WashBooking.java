package com.example.firebase;

public class WashBooking {
    private String fullName;
    private String phoneNumber;
    private String location;
    private String pickUpTime;
    private String instructions;
    private String status;

    public WashBooking() {
        // Needed for Firestore
    }

    public WashBooking(String fullName, String phoneNumber, String location, String pickUpTime, String instructions,String status) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.pickUpTime = pickUpTime;
        this.instructions= instructions;
        this.status = status;
    }

    public String getFullName() { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getLocation() { return location; }
    public String getPickUpTime() { return pickUpTime; }
    public String getInstructions() { return instructions; }
    public String getStatus() { return status; }
}
