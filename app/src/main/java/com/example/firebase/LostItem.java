package com.example.firebase;
//initializing the lost item class
public class LostItem {
    private String itemname;
    private String description;

    private String location;
    private String contact;
    private String status;

    public LostItem(){
        //needed for firestore

    }
    //paramitirized
    public LostItem(String itemname,String description,String location,String contact,String status){
        this.itemname=itemname;
        this.description=description;
        this.location=location;
        this.contact=contact;
        this.status=status;
    }

    public String getItemname() {
        return itemname;
    }
    public String getDescription() {
        return description;
    }
    public String getLocation() {
        return location;
    }
    public String getContact() {
        return contact;
    }
    public String getStatus() {
        return status;
    }
}
