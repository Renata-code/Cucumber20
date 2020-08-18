package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

//hamcrest library is an assertion library more human readable
public class Practice2 {

    @Test
    public void test1(){

        //assert 5=4 is 9

        int num1=5;
        int num2 =4;
        //hamcrest library use the assertThat method or all assrtions
        //hamcrest use built in matchers to do assertion

        assertThat(num1+num2,is(9));
        assertThat(num1+num2,equalTo(9));
        assertThat(num1+num2, is(equalTo(9)));

        //not(value)
        assertThat(num1 + num2 ,not(11));
        assertThat(num1 + num2 ,is(not(11)));
        assertThat(num1 + num2 ,is(not(equalTo(11))));


        String firstname = "Renata";
        String lastName = "Saidjanova";

        assertThat(firstname+" "+lastName,is("Renata Saidjanova"));
        assertThat(firstname+" "+lastName,equalTo("Renata Saidjanova"));
        assertThat(firstname+" "+lastName,is(equalTo("Renata Saidjanova")));

        assertThat(firstname+" "+lastName,is("Renata Saidjanova"));

        assertThat(firstname,equalToIgnoringCase("renata"));
        assertThat(firstname,equalToCompressingWhiteSpace("Renata"));
    }
    @DisplayName("Support for collection")
    @Test
    public void test2(){

        List<Integer >numList = Arrays.asList(11,44,3,55,88,5);

        assertThat(numList,hasSize(6));//or
        assertThat(numList.size(),is(6));

        assertThat(numList,hasItem(11));
        assertThat(numList,hasItems(11,3,5));
        assertThat(numList,containsInAnyOrder(11,44,3,55,88,5));
        assertThat(numList,contains(11,44,3,55,88,5));

    }


}
