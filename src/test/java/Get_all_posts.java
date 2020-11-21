import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

import static io.restassured.RestAssured.given;

public class Get_all_posts {

    @Test
    public void Scenrio_one() {
        Response extractedresp = given().log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then().log().all().assertThat().statusCode(200)
                .assertThat().statusCode(HttpStatus.SC_OK)
               .assertThat().contentType(ContentType.JSON)
                .body("list.size()", is(100))
                .extract().response();


        ResponseBody body =  extractedresp.getBody();
        String bodyStringValue = body.asString();
        Assert.assertTrue(bodyStringValue.contains("userId"));
        Assert.assertTrue(bodyStringValue.contains("id"));
        Assert.assertTrue(bodyStringValue.contains("title"));
        Assert.assertTrue(bodyStringValue.contains("body"));
    }
}
