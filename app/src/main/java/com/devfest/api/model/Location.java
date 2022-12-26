package com.devfest.api.model;

import java.util.List;

public class Location {
    private String type = "Point";
    Float[] coordinates = new Float[2];

    public void setX(Float x) {
        this.coordinates[0] = x;
    }

    public void setY(Float y) {
        this.coordinates[1] = y;
    }

    public Float getX() {
        return this.coordinates[0];
    }

    public Float getY() {
        return this.coordinates[1];
    }

}
