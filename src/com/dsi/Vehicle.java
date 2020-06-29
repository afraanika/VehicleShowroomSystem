package com.dsi;

public class Vehicle {
    String modelNumber;
    String engineType;
    String enginePower;
    String tireSize;
    int expectedVisitors;

    public Vehicle(){}
    public Vehicle(String modelNumber, String engineType, String enginePower, String tireSize, int expectedVisitors){
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.expectedVisitors = expectedVisitors;
    }

    public String getModelNumber(){ return  modelNumber; }

    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }

    public String getEngineType(){ return engineType; }

    public void setEngineType(String engineType) { this.engineType = engineType; }

    public String getEnginePower(){ return enginePower; }

    public void setEnginePower(String enginePower) { this.enginePower = enginePower; }

    public String getTireSize(){ return tireSize; }

    public void setTireSize(String tireSize) { this.tireSize = tireSize; }

    public int getExpectedVisitors(){return expectedVisitors; }

    public void setExpectedVisitors(int expectedVisitors) { this.expectedVisitors = expectedVisitors; }
}
