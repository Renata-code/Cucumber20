package day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {

    @Test
    public void calculatorTest(){

        System.out.println("Hello world");
        //assert 4+5 =9
        assertEquals(9,4+5);

        //how do we add error msg if assrtion fails

       // assertEquals(10,5+4,"Hey wrong result");

    }
    @DisplayName(("I am testing the name"))
    @Test
    public void nameTest(){

     String firstname ="Renata";
      String lastName= "Saidjanova";

     assertEquals("Renata Saidjanova",firstname+" "+lastName);




    }

}
