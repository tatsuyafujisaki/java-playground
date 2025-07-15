package com.tatsuyafujisaki.example.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class RootJsonArrayExample {
    public static void main(String[] args) {
        var jsonString = """
                [
                  {
                    "myArray": [],
                    "myBool": true,
                    "myDouble": 1.1,
                    "myInt": 1,
                    "myString": "🍎"
                  },
                  {
                    "myArray": null,
                    "myBool": null,
                    "myDouble": null,
                    "myInt": null,
                    "myString": null
                  },
                  {}
                ]
                """;

        var gson = new Gson();
        List<MyData> dataList = gson.fromJson(jsonString, new TypeToken<List<MyData>>() {
        }.getType());

        for (var data : dataList) {
            System.out.println(data);
            System.out.println("--");
        }
    }
}

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
