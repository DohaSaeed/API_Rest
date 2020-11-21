import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get_By_Id {

    @DataProvider(name="TestData")
    public static Object[][] Testdata()
    {
        return  new Object[][]{

                {"sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"}
        };
    }
    @Test(dataProvider = "TestData")
    public void Scenrio_two( String tittlee , String Bodyy)
    {
           given()
               .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .log().all().assertThat().statusCode(200)
                   .assertThat().statusCode(HttpStatus.SC_OK)
                   .assertThat().contentType(ContentType.JSON)
                   .assertThat()
                   .body("userId",equalTo(1))

               .and()
                .body("id",equalTo(1))
                .and()
               .body("title",equalTo(tittlee))
               .and()
               .body("body",equalTo(Bodyy));


    }




    }

