package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import models.User;
import org.testng.Assert;


public class UsersApi {

    public RequestSpecification setupSpec (String basePath) {
        RequestSpecification specification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.github.com/users/")
                .setBasePath(basePath)
                .build();

        return specification;
    }

    public User getUser(String username) {
        Response response = given()
                .spec(setupSpec(username))
                .when()
                .get();
        assert response.getStatusCode() == 200;

        return response.getBody().as(User.class);
    }

    public User getUser(String username, int statusCode) {
        Response response = given()
                .spec(setupSpec(username))
                .when()
                .get();
        Assert.assertEquals(response.getStatusCode(), statusCode, "Error \n\n" + response.getBody().prettyPrint());

        return response.getBody().as(User.class);
    }
}
