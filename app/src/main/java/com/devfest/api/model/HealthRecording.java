package com.devfest.api.model;

import com.google.gson.annotations.SerializedName;

public class HealthRecording {
    private String status;
    private Location location;
    private Float temperature;
    private BloodPressure blodPressure;
    private Float glycemie;
    private Float heartbeat;
    private Boolean fast;
    private Patient patient;

}
