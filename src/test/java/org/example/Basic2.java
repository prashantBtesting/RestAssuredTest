package org.example;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Basic2 {
    public static void main(String[] args) {
        RestAssured.baseURI= "https://rahulshettyacademy.com";
      String response  =  given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(payload.AddPlace())
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope" ,equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String place_id = js.getString("place_id");
        System.out.println(place_id);

        //Update Place
        String newAddress = "A.p. shevgoan, dist. Ahemdnagar, Shivchatra Niwas";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+ place_id + "\",\n" +
                        "\"address\":\""+ newAddress +"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

        // Get Place API

       String getResponse =given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
               .when().get("/maps/api/place/get/json")
               .then().assertThat().log().all().statusCode(200).extract().response().asString();
        System.out.println(getResponse);

       JsonPath js1 = ReusableMethods.rawToJson(getResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, newAddress);

    }



}
