package RestAssuredPakage;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class Test01_GET {
    @Test
    void test_01() {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody());
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_02() {

                given()
                        .get("https://reqres.in/api/users?page=2")
                .then()
                        .statusCode(200)
                         .body("data.id[0]",equalTo(7))
                        .body("data.id[1]",equalTo(8));
    }
    @Test
    public void test_03(){
           given()
                   .get("https://reqres.in/api/users?page=2")
           .then()
                   .log()
                   .all();

    }


}
