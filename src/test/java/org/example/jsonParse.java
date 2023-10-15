package org.example;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class jsonParse {

    public static void main(String[] args) {
        JsonPath js = new JsonPath(payload.CoursePrice());
        int count = js.getInt("courses.size()");
        System.out.println(count);
        int totalPurchasedAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("totalPurchasedAmount is: "+totalPurchasedAmount);
        int sumOfAllCoursePrices =0;
        for (int i = 0; i < count; i++) {
            String titleNames = js.get("courses[" + i + "].title");
            int coursePrice = js.get("courses[" + i + "].price");
            sumOfAllCoursePrices =sumOfAllCoursePrices +coursePrice;
            System.out.print(titleNames + " -->> " +coursePrice);
            System.out.println();
        }
        System.out.println("sum of all the course price is: "+ sumOfAllCoursePrices);
        for (int i=0;i<count;i++){
          String courseTitle = js.get("courses["+i+"].title");
          if (courseTitle.equalsIgnoreCase("RPA")){
             int RPACopies = js.get("courses["+i+"].copies");
              System.out.println("Total Number of Copies sold by RPA course: " +RPACopies);
              break;
          }

        }
        Assert.assertEquals(sumOfAllCoursePrices, totalPurchasedAmount);


    }
}
