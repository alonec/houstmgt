package com.housemgt.model;

import java.util.List;

public class Community {
    private String name;
    private String doorNumber;
    private String mailingAddress;
    private String postcode;
    private String linkman;
    private String phoneNumber;
    private String policeStation;
    private String policeman;
    private String policePhonenum;
    private String buildingPicture;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public String getPoliceman() {
        return policeman;
    }

    public void setPoliceman(String policeman) {
        this.policeman = policeman;
    }

    public String getPolicePhonenum() {
        return policePhonenum;
    }

    public void setPolicePhonenum(String policePhonenum) {
        this.policePhonenum = policePhonenum;
    }

    public String getBuildingPicture() {
        return buildingPicture;
    }

    public void setBuildingPicture(String buildingPicture) {
        this.buildingPicture = buildingPicture;
    }
}
