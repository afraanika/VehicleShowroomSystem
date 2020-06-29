package com.dsi;

public class SportsVehicle extends Vehicle{

    boolean turbo;

    public SportsVehicle(String modelNumber, String enginePower, String tireSize, boolean turbo, int expectedVisitors) {
        this.modelNumber = modelNumber;
        this.engineType = "Oil";
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.turbo = turbo;
        this.expectedVisitors = expectedVisitors;
    }
    public boolean getTurbo(){ return  turbo;}

    public void setTurbo(boolean turbo) { this.turbo = turbo; }

    @Override
    public void setEngineType(String engineType) {
        super.setEngineType("Oil");
    }
}
