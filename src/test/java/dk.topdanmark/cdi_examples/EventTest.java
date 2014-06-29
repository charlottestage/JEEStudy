package dk.topdanmark.cdi_examples;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by cjy on 22-06-2014.
 */
@RunWith(Arquillian.class)
public class EventTest {


    @Inject @Any Event<MyPOJO> event;


    @Test
    public void testPublishEvent() {
        MyPOJO state = new MyPOJO();
        state.setName("Jakob");
        event.fire(state);
    }

    public void testObserveEvent( @Observes MyPOJO event) {

        Assert.assertNotNull(event);
        Assert.assertEquals("Jakob", event.getName());

        System.out.println("Observer 1: " + event.getName());
    }

    public void testAnotherObserverOnSameEvent( @Observes MyPOJO event) {

        Assert.assertNotNull(event);
        Assert.assertEquals("Jakob", event.getName());

        System.out.println("Observer 2: " + event.getName());
    }



    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(
                        MyPOJO.class

                ).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }



}
