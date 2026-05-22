package com.example.autocareapplication;

public class Booking {
    private String id;
    private String serviceType;
    private String date;
    private String status;

    public Booking(String id, String serviceType, String date, String status) {
        this.id = id;
        this.serviceType = serviceType;
        this.date = date;
        this.status = status;
    }

    public String getId() { return id; }
    public String getServiceType() { return serviceType; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}