package com.dsi;

public class HeavyVehicle extends Vehicle {
    String weight;

    public HeavyVehicle(String modelNumber, String enginePower, String tireSize, String weight, int expectedVisitors) {
        this.modelNumber = modelNumber;
        this.engineType = "Diesel";
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.weight = weight;
        this.expectedVisitors = expectedVisitors;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getWeight(){ return weight; }

    @Override
    public void setEngineType(String engineType) {
        super.setEngineType("Diesel");
    }
}
