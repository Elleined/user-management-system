package com.example.loginfx.model;

import javafx.beans.property.SimpleStringProperty;
import lombok.Builder;
import lombok.Value;

@Value
public class FullName {
    SimpleStringProperty firstName;
    SimpleStringProperty middleName;
    SimpleStringProperty lastName;

    public FullName(String firstName, String middleName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
}
