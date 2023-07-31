package org.example;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basic {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String  response= given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(payload.AddPlace())
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
        System.out.println(response);
        JsonPath js= new JsonPath(response);
        String place_ID= js.getString("place_id");
        System.out.println(place_ID);
        given().log().all().queryParam("key", "qaclick123").header(("Content-Type", "application/json")
    }
}
