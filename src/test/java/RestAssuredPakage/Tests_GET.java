package RestAssuredPakage;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Tests_GET {


    @Test
    public void test_1_get() {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.id[2]", equalTo(9))
                .body("data.id[3]",equalTo(10))
                .body("data.first_name",hasItems("Michael","Lindsay"))
                .log()//daje ceo response
                .all();// daje ceo response

    }


}
