package models;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestApi {

    String getUrl = "https://api.github.com";
    String basePath = "/users/doomiley";

    @Test
    public void testUserInfoResponse() {
        given()
                .baseUri(getUrl)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("login", equalTo("Doomiley"));
    }

    @Test
    public void testUserInfoResponseType() {
        given()
                .baseUri(getUrl)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("type", equalTo("User"));
    }
}
