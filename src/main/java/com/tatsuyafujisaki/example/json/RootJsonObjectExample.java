package com.tatsuyafujisaki.example.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RootJsonObjectExample {
    public static void main(String[] args) {
        String jsonString = """
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

        try {
            JSONObject rootJsonObject = createJsonObjectOrNull(jsonString);
            if (rootJsonObject == null) {
                return;
            }

            JSONArray jsonArray = rootJsonObject.optJSONArray("myRoot");
            if (jsonArray == null) {
                return;
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                if (jsonObject == null) {
                    continue;
                }

                JSONArray myArray = jsonObject.optJSONArray("myArray");
                Boolean myBool = jsonObject.optBooleanObject("myBool", null);
                Double myDouble = jsonObject.optDoubleObject("myDouble", null);
                Integer myInt = jsonObject.optIntegerObject("myInt", null);
                String myString = jsonObject.optString("myString", null);

                System.out.println("myArray: " + myArray);
                System.out.println("myBool: " + myBool);
                System.out.println("myDouble: " + myDouble);
                System.out.println("myInt: " + myInt);
                System.out.println("myString: " + myString);
                System.out.println("----------");
            }

        } catch (JSONException e) {
            System.err.println(e.getMessage());
        }
    }

    private static JSONObject createJsonObjectOrNull(String jsonString) {
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
