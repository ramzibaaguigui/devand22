package com.devfest.api.model;

import java.util.Date;

public class Doctor {
    private String _id; // to be decided later
    private String firstname, lastname, email, password, phone, address;
    private Date birthdate;
    private String specialities;
    private boolean isConfirmed;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getSpecialities() {
        return specialities;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public String get_id() {
        return this._id;
    }

}
