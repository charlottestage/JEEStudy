package dk.topdanmark.beans;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@ManagedBean("myBean")
public class PojoBean {

    @PostConstruct
    public void setupResources() {
        System.out.println("Setup resources");
    }

    @PreDestroy
    public void cleanupResources() {
        System.out.println("cleanup resources");
    }

    public String sayHallo() {
        return "Hallo from managed pojo bean";
    }

}
