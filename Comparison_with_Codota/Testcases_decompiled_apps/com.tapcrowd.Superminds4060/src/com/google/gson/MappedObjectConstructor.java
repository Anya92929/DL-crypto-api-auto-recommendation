package com.google.gson;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

final class MappedObjectConstructor implements ObjectConstructor {
    private static final Logger log = Logger.getLogger(MappedObjectConstructor.class.getName());
    private final ParameterizedTypeHandlerMap<InstanceCreator<?>> instanceCreatorMap;

    public MappedObjectConstructor(ParameterizedTypeHandlerMap<InstanceCreator<?>> instanceCreators) {
        this.instanceCreatorMap = instanceCreators;
    }

    public <T> T construct(Type typeOfT) {
        InstanceCreator<T> creator = this.instanceCreatorMap.getHandlerFor(typeOfT);
        if (creator != null) {
            return creator.createInstance(typeOfT);
        }
        return constructWithNoArgConstructor(typeOfT);
    }

    public Object constructArray(Type type, int length) {
        return Array.newInstance(TypeUtils.toRawClass(type), length);
    }

    private <T> T constructWithNoArgConstructor(Type typeOfT) {
        try {
            Constructor<T> constructor = getNoArgsConstructor(typeOfT);
            if (constructor != null) {
                return constructor.newInstance(new Object[0]);
            }
            throw new RuntimeException("No-args constructor for " + typeOfT + " does not exist. " + "Register an InstanceCreator with Gson for this type to fix this problem.");
        } catch (InstantiationException e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + typeOfT + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + typeOfT + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + typeOfT + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e3);
        }
    }

    private <T> Constructor<T> getNoArgsConstructor(Type typeOfT) {
        Constructor<T>[] declaredConstructors = new TypeInfo(typeOfT).getRawClass().getDeclaredConstructors();
        AccessibleObject.setAccessible(declaredConstructors, true);
        for (Constructor<T> constructor : declaredConstructors) {
            if (constructor.getParameterTypes().length == 0) {
                return constructor;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public <T> void register(Type typeOfT, InstanceCreator<? extends T> creator) {
        if (this.instanceCreatorMap.hasSpecificHandlerFor(typeOfT)) {
            log.log(Level.WARNING, "Overriding the existing InstanceCreator for {0}", typeOfT);
        }
        this.instanceCreatorMap.register(typeOfT, creator);
    }

    public String toString() {
        return this.instanceCreatorMap.toString();
    }
}
