import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanRequestMethodsTest {
    private ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://postman-echo.com";

        responseSpecification = expect()
                .statusCode(200)
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.20)"));
    }

    @Test
    public void getRequestTest() {
        given()
                .expect()
                .spec(responseSpecification)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void postRawTextRequestTest() {
        given()
                .body("")
                .expect()
                .spec(responseSpecification)
                .when()
                .post("/post")
                .then()
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.content-length", equalTo("0"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("json", equalTo(null));
    }

    @Test
    public void putRequestTest() {
        given()
                .contentType("application/json")
                .expect()
                .spec(responseSpecification)
                .when()
                .put("/put")
                .then()
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.content-length", equalTo("0"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("json", equalTo(null));
    }

    @Test
    public void patchRequestTest() {
        given()
                .contentType("application/json")
                .expect()
                .spec(responseSpecification)
                .when()
                .patch("/patch")
                .then()
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.content-length", equalTo("0"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .body("json", equalTo(null));
    }

    @Test
    public void deleteRequestTest() {
        given()
                .contentType("application/json")
                .expect()
                .spec(responseSpecification)
                .when()
                .delete("/delete")
                .then()
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("json", equalTo(null));
    }
}
