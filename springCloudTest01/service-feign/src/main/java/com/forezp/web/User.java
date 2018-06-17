package com.forezp.web;

public class User {
    private String UserID;
    private String Name;
    private String Tel;


    public void printUser(){
        System.out.println("UserID: "+UserID);
        System.out.println("Name: "+Name);
        System.out.println("Tel: "+Tel);

    }

    public User() {
    }

    public User(String userID, String name, String tel) {

        UserID = userID;
        Name = name;
        Tel = tel;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }
}
