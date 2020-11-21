import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Create_post {

    @Test()
    public void Post_Request() {

        String bo=" '   {  '  + \r\n" +
                " '       \"title\": \"foo\",  '  + \r\n" +
                " '       \"body\": \"bar\"  '  + \r\n" +
                " '       \"userId\": \"1\"  '  + \r\n" +
                " '  }  ' ; ";




        String Resp=  given().
                body(bo)
                .when().
                post("https://jsonplaceholder.typicode.com/posts").
                then().statusCode(201).and().
                header("Content-Type","application/json; charset=utf-8").
                extract().response().asString();

        System.out.println("Response is\t"+Resp);

    }
}
