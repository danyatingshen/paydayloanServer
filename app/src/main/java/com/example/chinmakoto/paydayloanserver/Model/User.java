package com.example.chinmakoto.paydayloanserver.Model;

public class User {
    private String Name;
    private String Password;
    private String Phone;
    private String IsStaff;
    private String StoreId;
    private String Deploy;

    public User(){

    }

    public User(String name, String password,String storeId,String deploy) {
        Name = name;
        Password = password;
        StoreId=storeId;
        Deploy=deploy;
    }

    public String getDeploy() {
        return Deploy;
    }

    public void setDeploy(String deploy) {
        Deploy = deploy;
    }

    public String getStoreId() {
        return StoreId;
    }

    public void setStoreId(String storeId) {
        StoreId = storeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }
}
