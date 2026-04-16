package com.example.firebase;

public class MamafuaRequest {
    private String name;
    private String contact;
    private String status;
    private String id;

    public MamafuaRequest() {
        // Required for Firestore
    }

    public MamafuaRequest(String name, String contact, String status, String id) {
        this.name = name;
        this.contact = contact;
        this.status = status;
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
