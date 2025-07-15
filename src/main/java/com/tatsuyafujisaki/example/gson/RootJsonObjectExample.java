package com.tatsuyafujisaki.example.gson;

import com.google.gson.GsonBuilder;

import java.util.List;

class MyRootObject {
    private List<MyData> myRoot;

    public List<MyData> getMyRoot() {
        return myRoot;
    }

    public void setMyRoot(List<MyData> myRoot) {
        this.myRoot = myRoot;
    }

    @Override
    public String toString() {
        return "RootObject{myRoot=" + myRoot + "}";
    }
}

public class RootJsonObjectExample {
    public static void main(String[] args) {
        var jsonString = """
                {
                    "myRoot": [
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
                }
                """;

        var gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            var rootObject = gson.fromJson(jsonString, MyRootObject.class);
            System.out.println(rootObject);
            System.out.println("--");
            for (var data : rootObject.getMyRoot()) {
                System.out.println(data);
                System.out.println("--");
            }
            System.out.println(gson.toJson(rootObject));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
