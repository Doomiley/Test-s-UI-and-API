package models;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;


public class TestApi {

    private static RequestSpecification spec;


    @BeforeClass
    public static void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://reqres.in/api")
                .setBasePath("/users")
                .build();
    }

        @Test
        public void testUserInfoResponseType() {
         List<User> users = given()
                 .spec(spec)
                 .when()
                 .get()
                 .then()
                 .statusCode(200)
                 .extract().jsonPath().getList("data", User.class);

         assertThat(users).extracting(User::getEmail).contains("george.bluth@reqres.in");
        }

}



