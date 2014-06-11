package dk.topdanmark.cdi_examples;

/**
 * Created by CJY on 10-06-2014.
 */
public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
}
