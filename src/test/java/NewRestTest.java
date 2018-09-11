import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class NewRestTest {

    @BeforeClass
    public void configure(){
        RestAssured.baseURI = "https://www.googleapis.com";
        RestAssured.basePath = "/books";
    }

    @Test
    public void googleAPITest() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParam("q", "turing");
        new RestAssuredConfiguration().getResponse(requestSpecification, "/v1/volumes", HttpStatus.SC_OK)
                .then()
                .assertThat()
                .body("items[0].id", equalTo("VlC5MkVIwqkC"),
                        "items[0].volumeInfo.title", equalTo("The Essential Turing"));
    }



}
