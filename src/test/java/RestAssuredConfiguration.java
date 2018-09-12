import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RestAssuredConfiguration {



    public RequestSpecification getRequestSpecification(){
        return RestAssured.given().contentType(ContentType.JSON);
    }

    public Response getResponse(RequestSpecification requestSpecification, String endPoint, int status){
        Response response = requestSpecification.get(endPoint);
        Assert.assertEquals(response.getStatusCode(), status);
        //response.then().log().all();
        return response;
    }
}
