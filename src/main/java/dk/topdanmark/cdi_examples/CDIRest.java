package dk.topdanmark.cdi_examples;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by CJY on 10-06-2014.
 */
@Path("cdi")
public class CDIRest {

    @Inject Greeting greeting;

    @GET
    @Path("hello")
    @Produces("text/html")
    public String helloRest() {

        System.out.println("REST service hit");

        return "Hello Rest";

    }

    @GET
    @Path("simpleGreeting/{name}/")
    @Produces("application/json")
    public String simpleGreeting(@PathParam("name") String name) {

        System.out.println("REST service hit");
        return greeting.greet(name);

    }


}
