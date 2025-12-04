package org.emp;

import java.util.HashMap;
import java.util.Map;

public class Lookup {

    private static  Lookup instance = null;
    private final Map<Class<?>, Object> services = new HashMap<>();

    private Lookup() {
    }

    public static Lookup getInstance() {
        if (instance == null) {
            instance = new Lookup();
        }
        return instance;
    }

    public <T> void subscribeService(Class<T> serviceClass , T instance) {
        this.services.put(serviceClass, instance);
    }

    @SuppressWarnings("unchecked")
    public <T> T getService(Class<T> serviceClass) {
        return (T) services.get(serviceClass);
    }
}
