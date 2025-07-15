package com.tatsuyafujisaki.example.gson;

import com.google.gson.GsonBuilder;
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

        var gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        List<MyData> dataList = gson.fromJson(jsonString, new TypeToken<List<MyData>>() {
        }.getType());

        for (var data : dataList) {
            System.out.println(data);
            System.out.println("--");
        }
        System.out.println(gson.toJson(dataList));
    }
}
