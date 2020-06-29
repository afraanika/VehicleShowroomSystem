package com.dsi;

public class NormalVehicle extends Vehicle {
    public NormalVehicle(String mn, String et, String ep, String ts, int expectedVisitors) {
        this.modelNumber = mn;
        this.engineType = et;
        this.enginePower = ep;
        this.tireSize = ts;
        this.expectedVisitors = expectedVisitors;
    }
}
