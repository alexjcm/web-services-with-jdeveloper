package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("")
public class ApplicationConfig extends Application {
    
    public ApplicationConfig() {
        super();
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        // Register root resources.
        classes.add(ProductImpl.class);
        classes.add(OrderrDetailImpl.class);
        classes.add(OrderrImpl.class);
        classes.add(CustomerImpl.class);

        // Register provider classes.

        return classes;
    }
}
