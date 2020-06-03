package com.housemgt.model;

public class Element {
    private String buildingNumber;
    private String elementNumber;
    private int floorNumber;
    private int  households;
    private int  elevatorstatus;
    private String elementPicture;

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getElementNumber() {
        return elementNumber;
    }

    public void setElementNumber(String elementNumber) {
        this.elementNumber = elementNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getHouseholds() {
        return households;
    }

    public void setHouseholds(int households) {
        this.households = households;
    }

    public int  getElevatorstatus() {
        return elevatorstatus;
    }

    public void setElevatorstatus(int  elevatorstatus) {
        this.elevatorstatus = elevatorstatus;
    }

    public String getElementPicture() {
        return elementPicture;
    }

    public void setElementPicture(String elementPicture) {
        this.elementPicture = elementPicture;
    }
}
