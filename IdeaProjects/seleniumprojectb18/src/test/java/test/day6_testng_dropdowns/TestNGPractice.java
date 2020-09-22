package test.day6_testng_dropdowns;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {

    @BeforeClass
    public void before_class(){
        System.out.println("Before class is running!-------------");
    }
    @AfterClass
    public void after_class(){
        System.out.println("After class running--------------");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method running");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method running");
    }

    @Test
    public void test1(){
        System.out.println("Test1 running");


        String actualTitle ="Homepage";
        String expectedTitle = "Homepage";

        Assert.assertEquals(actualTitle,expectedTitle);

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }

    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test2 is running");

        Assert.assertEquals("string1","string1","String verification on test2 failed");
    }
    @Test
    public void test3(){
        System.out.println("Test3 running");

        String actualTitle ="Amazon prime";
        String expectedTitle = "prime";
        String testString = "abibi";

        Assert.assertTrue(actualTitle.contains(expectedTitle));//if true if it will pass
        Assert.assertFalse(actualTitle.contains(testString));// if it false it will pass


    }


}
