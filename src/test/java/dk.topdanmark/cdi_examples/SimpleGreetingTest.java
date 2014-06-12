package dk.topdanmark.cdi_examples;

import org.junit.Assert;
import org.junit.Test;

public class SimpleGreetingTest {


    @Test
    public void testGreet() {

        Greeting greeting = new SimpleGreeting();

        String name = "Jakob";
        String greet = greeting.greet(name);

        Assert.assertEquals(greet, "Hello " + name);

    }
}
