package com.housemgt.model;
//房屋信息
import java.io.Serializable;

public class Home implements Serializable {

    private String elementNumber;
    private String houseNumber;
    private String houseType;
    private String housePicture;
    private double houseArea;
    private int status;
    private String householderId;
    private String residentsToChange;
    private String infrastructureChanges;
    private String structuremodify;

    public String getElementNumber() {
        return elementNumber;
    }

    public void setElementNumber(String elementNumber) {
        this.elementNumber = elementNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(String housePicture) {
        this.housePicture = housePicture;
    }

    public double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(double houseArea) {
        this.houseArea = houseArea;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHouseholderId() {
        return householderId;
    }

    public void setHouseholderId(String householderId) {
        this.householderId = householderId;
    }

    public String getResidentsToChange() {
        return residentsToChange;
    }

    public void setResidentsToChange(String residentsToChange) {
        this.residentsToChange = residentsToChange;
    }

    public String getInfrastructureChanges() {
        return infrastructureChanges;
    }

    public void setInfrastructureChanges(String infrastructureChanges) {
        this.infrastructureChanges = infrastructureChanges;
    }

    public String getStructuremodify() {
        return structuremodify;
    }

    public void setStructuremodify(String structuremodify) {
        this.structuremodify = structuremodify;
    }
}

