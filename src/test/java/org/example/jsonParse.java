package org.example;

import files.payload;
import io.restassured.path.json.JsonPath;

public class jsonParse {

    public static void main(String[] args) {
        JsonPath js =new JsonPath(payload.CoursePrice());
      int count =   js.getInt("courses.size()");
        System.out.println(count);
       int totalAmount =  js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
    }
}
