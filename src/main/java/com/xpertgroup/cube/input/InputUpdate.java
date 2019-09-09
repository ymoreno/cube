package com.xpertgroup.cube.input;

public class InputUpdate {

    Integer xCoordinate;
    Integer yCoordinate;
    Integer zCoordinate;
    Integer value;

    public InputUpdate(Integer xCoordinate, Integer yCoordinate, Integer zCoordinate, Integer value) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
        this.value = value;
    }

    public Integer getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Integer getzCoordinate() {
        return zCoordinate;
    }

    public void setzCoordinate(Integer zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
