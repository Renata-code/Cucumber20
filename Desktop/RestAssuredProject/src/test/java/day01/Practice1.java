package day01;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.matcher.ResponseAwareMatcher;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Practice1 {//spartan app

    //http://54.236.52.149:8000/api/hello

    @Test
    public void test(){

        //RestAssured.get("URL HERE")
        // SINCE WE DID THE STATIC IMPORT
        // we can directly call the get method
        // after we send the request
        // we can save the result in to a type called Response
        // need this  import io.restassured.response.Response;

        Response response = get("http://54.236.52.149:8000/api/hello");
        // response object store all the information about the response we got
        // like status  , statusline , body , headers and so on
        System.out.println("status code of this response: "+response.statusCode());
        // this is another way of getting status code starts with HTTP/1.1
        System.out.println("getting status line of this response "+response.statusLine());

        System.out.println("Getting the value of the Date header "+ response.header("Date"));

        System.out.println("This is a content_type header "+response.contentType());

        System.out.println("This is a content-length header "+response.getHeader("Content-Length"));

        assertEquals(200,response.statusCode());

    }
    @DisplayName("Testing/hello endpoint")
    @Test
    public void testHello(){

        Response response = get("http://54.236.52.149:8000/api/hello");
        assertEquals(200,response.statusCode());
        //testing the content-type header value is  : text/plain;charset=UTF-8
        assertEquals("text/plain;charset=UTF-8",response.header("Content-Type"));//can use getHeader
        assertEquals("text/plain;charset=UTF-8",response.contentType());
        assertEquals("17",response.header("Content-length"));
    }
    @DisplayName("Testing /hello endpoint body")
    @Test
    public void testHelloResponseBody(){

        //get the body and assert the body equal to Hello from Sparta
        Response response = get("http://54.236.52.149:8000/api/hello");
        System.out.println("response.body() = " + response.asString());

         //geting the body by calling  body method
        System.out.println("response.body() = " + response.body().asString());//or this method same with previous

        //assert the body is heloo from sparta length is 17
        String helloBody = response.asString();

        assertEquals("Hello from Sparta",helloBody);
        //asserting the length
        assertEquals(17,helloBody.length());
    }
    @DisplayName("Printing the response body using method")
    @Test
    public void printingBody(){
        Response response = get("http://54.236.52.149:8000/api/hello");

        //response.prettyPrint();//prints body message

        System.out.println("=============================");
        //response.prettyPeek();//prints out the entire response return type is different

        System.out.println("=============================");

        int statusCode = response.prettyPeek().statusCode();
        System.out.println("Printing only status code "+statusCode);



    }





}
