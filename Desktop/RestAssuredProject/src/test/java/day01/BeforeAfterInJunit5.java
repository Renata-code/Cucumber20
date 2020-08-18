package day01;

import org.junit.jupiter.api.*;

public class BeforeAfterInJunit5 {
    //juntit5
    @BeforeAll
    public static void SetUp(){
        System.out.println("This run before all");
    }
    @BeforeEach
    public void beforeEachTest(){
        System.out.println("Running before the test");
    }

    @Test
    public void test1(){
        System.out.println("Test is running");
    }

    @Test
    public void test2(){
        System.out.println("Test is running");

    }
    @AfterEach
    public void afterEachTest(){
        System.out.println("Running after the test");
    }
    //runs only once
    @AfterAll
    public static void tearDown(){

        System.out.println("This run all the way at the end");


    }
}
