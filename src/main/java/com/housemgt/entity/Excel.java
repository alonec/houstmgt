package com.housemgt.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;



@Data
public class Excel implements Serializable {

//    @Id
//    private Integer id;

    @ExcelProperty(value ="buildingNumber",index = 0)
    private String buildingNumber;

    @ExcelProperty(value ="elementNumber",index = 1)
    private String elementNumber;

    @ExcelProperty(value ="floorNumber",index = 2)
    private Integer floorNumber;

    @ExcelProperty(value ="households",index = 3)
    private Integer households;

    @ExcelProperty(value ="elevatorstatus",index = 4)
    private Integer elevatorstatus;

    @ExcelProperty(value ="elementPicture",index = 5)
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

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getHouseholds() {
        return households;
    }

    public void setHouseholds(Integer households) {
        this.households = households;
    }

    public Integer getElevatorstatus() {
        return elevatorstatus;
    }

    public void setElevatorstatus(Integer elevatorstatus) {
        this.elevatorstatus = elevatorstatus;
    }

    public String getElementPicture() {
        return elementPicture;
    }

    public void setElementPicture(String elementPicture) {
        this.elementPicture = elementPicture;
    }
}
