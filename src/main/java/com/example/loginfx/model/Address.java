package com.example.loginfx.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Value;

@Value
public class Address {

    SimpleIntegerProperty houseNumber;
    SimpleIntegerProperty purokNumber;

    SimpleStringProperty baranggayName;
    SimpleStringProperty cityName;
    SimpleStringProperty provinceName;

    public Address(int houseNumber, int purokNumber, String baranggayName, String cityName, String provinceName) {
        this.houseNumber = new SimpleIntegerProperty(houseNumber);
        this.purokNumber = new SimpleIntegerProperty(purokNumber);
        this.baranggayName = new SimpleStringProperty(baranggayName);
        this.cityName = new SimpleStringProperty(cityName);
        this.provinceName = new SimpleStringProperty(provinceName);
    }
    public int getHouseNumber() {
        return houseNumber.get();
    }

    public int getPurokNumber() {
        return purokNumber.get();
    }

    public String getBaranggayName() {
        return baranggayName.get();
    }

    public String getCityName() {
        return cityName.get();
    }

    public String getProvinceName() {
        return provinceName.get();
    }


    public void setHouseNumber(int houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public void setPurokNumber(int purokNumber) {
        this.purokNumber.set(purokNumber);
    }

    public void setBaranggayName(String baranggayName) {
        this.baranggayName.set(baranggayName);
    }

    public void setCityName(String cityName) {
        this.cityName.set(cityName);
    }

    public void setProvinceName(String provinceName) {
        this.provinceName.set(provinceName);
    }
}
