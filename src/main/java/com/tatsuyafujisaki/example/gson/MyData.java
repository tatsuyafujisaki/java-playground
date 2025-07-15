package com.tatsuyafujisaki.example.gson;

import java.util.List;

class MyData {
    private List<Object> myArray;
    private Boolean myBool;
    private Double myDouble;
    private Integer myInt;
    private String myString;

    public List<Object> getMyArray() {
        return myArray;
    }

    public void setMyArray(List<Object> myArray) {
        this.myArray = myArray;
    }

    public Boolean getMyBool() {
        return myBool;
    }

    public void setMyBool(Boolean myBool) {
        this.myBool = myBool;
    }

    public Double getMyDouble() {
        return myDouble;
    }

    public void setMyDouble(Double myDouble) {
        this.myDouble = myDouble;
    }

    public Integer getMyInt() {
        return myInt;
    }

    public void setMyInt(Integer myInt) {
        this.myInt = myInt;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "myArray=" + myArray +
                ", myBool=" + myBool +
                ", myDouble=" + myDouble +
                ", myInt=" + myInt +
                ", myString='" + myString + '\'' +
                '}';
    }
}
