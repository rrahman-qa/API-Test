import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class AuthTest {

    @Test
    public void basic_auth() {
        RestAssured.baseURI = "http://192.168.99.100";
        RestAssured.port = 32769;
        RestAssured.given().log().all().
                auth().preemptive().basic("rahi", "password").
                when().
                get("/login").
                then().
                assertThat().
                statusCode(200);
    }
}
