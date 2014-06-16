package dk.topdanmark.cdi_examples;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by CJY on 11-06-2014.
 * http://arquillian.org/guides/getting_started/
 *
 */
@RunWith(Arquillian.class)
public class CDITest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClasses(
                        Greeting.class,
                        SimpleGreeting.class
                ).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }


    @Inject
    Greeting greeter;

    @Test
    public void should_create_greeting() {
        Assert.assertEquals("Hello Jakob", greeter.greet("Jakob"));

    }
}
