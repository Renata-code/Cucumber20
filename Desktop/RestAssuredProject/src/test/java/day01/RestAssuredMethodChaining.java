package day01;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestAssuredMethodChaining {

    @DisplayName("First Attempt for chaining")
    @Test
    public void chainingMethodsTest1() {

        //http://54.174.216.245:8000/api/hello

        when().get("//http://54.174.216.245:8000/api/hello").then().statusCode(200).header("Content-Length", "17");


        //when().get("//http://54.174.216.245:8000/api/hello").then().statusCode(is(200)).header("Content-Length",equalTo("17"));

    }

    @DisplayName("Using Hamcrest matcher for assertion")
    @Test
    public void testingWithMatcher() {
        when().
                get("http://54.174.216.245:8000/api/hello").prettyPeek().   // sending a request to this url
                then().                         // asssrtions start here
                statusCode(is(200)).        // asserting status code is 200
                header("Content-Length", equalTo("17")).header("Content-Type",is("text/plain;charset=UTF-8")).
                body(is("Hello from Sparta"));
    // asserting header is "17"

        when().get("http://100.26.225.192:8000/api/spartans").prettyPeek().then().statusCode(200);

    }

}