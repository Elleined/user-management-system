 package com.example.loginfx.model;

 import javafx.beans.property.SimpleIntegerProperty;
 import javafx.beans.property.SimpleLongProperty;
 import javafx.beans.property.SimpleStringProperty;

 import java.time.LocalDate;

 public class User {
    private final SimpleIntegerProperty id;
    private final FullName fullName;
    private final SimpleStringProperty email;

    private final SimpleStringProperty sex;
    private final LocalDate birthDay;
    private final SimpleStringProperty phoneNumber;

    private final Address address;

    public User(int id, FullName fullName, String email, String sex, LocalDate birthDay, String phoneNumber, Address address) {
        this.id = new SimpleIntegerProperty(id);
        this.fullName = fullName;
        this.email = new SimpleStringProperty(email);
        this.sex = new SimpleStringProperty(sex);
        this.birthDay = birthDay;
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.address = address;
    }

    public int getId() {
        return id.get();
    }
    public String getFirstName() {
        return this.fullName.getFirstName();
    }
    public String getMiddleName() {
        return this.fullName.getMiddleName();
    }

    public String getLastName() {
        return this.fullName.getLastName();
    }
    public String getSex() {
        return sex.get();
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }

     public String getEmail() {
         return email.get();
     }
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    public int getHouseNumber() {
        return this.address.getHouseNumber();
    }
    public int getPurokNumber() {
        return this.address.getPurokNumber();
    }
    public String getBaranggayName() {
        return this.address.getBaranggayName();
    }
    public String getCityName() {
        return this.address.getCityName();
    }
    public String getProvinceName() {
        return this.address.getProvinceName();
    }


    public void setId(int id) {
        this.id.set(id);
    }

    public void setFirstName(String firstName) {
        this.fullName.setFirstName(firstName);
    }
    public void setMiddleName(String middleName) {
        this.fullName.setMiddleName(middleName);
    }
    public void setLastName(String lastName) {
        this.fullName.setLastName(lastName);
    }
    public void setSex(String sex) {
        this.sex.set(sex);
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public void setHouseNumber(int houseNumber) {
        this.address.setHouseNumber(houseNumber);
    }

    public void setPurokNumber(int purokNumber) {
        this.address.setPurokNumber(purokNumber);
    }

    public void setBaranggayName(String baranggayName) {
        this.address.setBaranggayName(baranggayName);
    }

    public void setCityName(String cityName) {
        this.address.setCityName(cityName);
    }

    public void setProvinceName(String provinceName) {
        this.address.setProvinceName(provinceName);
    }

     public void setEmail(String email) {
         this.email.set(email);
     }

 }
