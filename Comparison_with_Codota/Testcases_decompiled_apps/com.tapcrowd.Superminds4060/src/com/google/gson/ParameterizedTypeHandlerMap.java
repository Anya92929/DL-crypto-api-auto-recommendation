package com.google.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ParameterizedTypeHandlerMap<T> {
    private static final Logger logger = Logger.getLogger(ParameterizedTypeHandlerMap.class.getName());
    private final Map<Type, T> map = new HashMap();
    private boolean modifiable = true;
    private final List<Pair<Class<?>, T>> typeHierarchyList = new ArrayList();

    ParameterizedTypeHandlerMap() {
    }

    public synchronized void registerForTypeHierarchy(Class<?> typeOfT, T value) {
        registerForTypeHierarchy(new Pair<>(typeOfT, value));
    }

    public synchronized void registerForTypeHierarchy(Pair<Class<?>, T> pair) {
        if (!this.modifiable) {
            throw new IllegalStateException("Attempted to modify an unmodifiable map.");
        }
        int index = getIndexOfSpecificHandlerForTypeHierarchy((Class) pair.first);
        if (index >= 0) {
            logger.log(Level.WARNING, "Overriding the existing type handler for {0}", pair.first);
            this.typeHierarchyList.remove(index);
        }
        int index2 = getIndexOfAnOverriddenHandler((Class) pair.first);
        if (index2 >= 0) {
            throw new IllegalArgumentException("The specified type handler for type " + pair.first + " hides the previously registered type hierarchy handler for " + this.typeHierarchyList.get(index2).first + ". Gson does not allow this.");
        }
        this.typeHierarchyList.add(0, pair);
    }

    private int getIndexOfAnOverriddenHandler(Class<?> type) {
        for (int i = this.typeHierarchyList.size() - 1; i >= 0; i--) {
            if (type.isAssignableFrom((Class) this.typeHierarchyList.get(i).first)) {
                return i;
            }
        }
        return -1;
    }

    public synchronized void register(Type typeOfT, T value) {
        if (!this.modifiable) {
            throw new IllegalStateException("Attempted to modify an unmodifiable map.");
        }
        if (hasSpecificHandlerFor(typeOfT)) {
            logger.log(Level.WARNING, "Overriding the existing type handler for {0}", typeOfT);
        }
        this.map.put(typeOfT, value);
    }

    public synchronized void registerIfAbsent(ParameterizedTypeHandlerMap<T> other) {
        if (!this.modifiable) {
            throw new IllegalStateException("Attempted to modify an unmodifiable map.");
        }
        for (Map.Entry<Type, T> entry : other.map.entrySet()) {
            if (!this.map.containsKey(entry.getKey())) {
                register(entry.getKey(), entry.getValue());
            }
        }
        for (int i = other.typeHierarchyList.size() - 1; i >= 0; i--) {
            Pair<Class<?>, T> entry2 = other.typeHierarchyList.get(i);
            if (getIndexOfSpecificHandlerForTypeHierarchy((Class) entry2.first) < 0) {
                registerForTypeHierarchy(entry2);
            }
        }
    }

    public synchronized void registerIfAbsent(Type typeOfT, T value) {
        if (!this.modifiable) {
            throw new IllegalStateException("Attempted to modify an unmodifiable map.");
        } else if (!this.map.containsKey(typeOfT)) {
            register(typeOfT, value);
        }
    }

    public synchronized void makeUnmodifiable() {
        this.modifiable = false;
    }

    public synchronized T getHandlerFor(Type type) {
        T handler;
        handler = this.map.get(type);
        if (handler == null) {
            Class<?> rawClass = TypeUtils.toRawClass(type);
            if (rawClass != type) {
                handler = getHandlerFor(rawClass);
            }
            if (handler == null) {
                handler = getHandlerForTypeHierarchy(rawClass);
            }
        }
        return handler;
    }

    private T getHandlerForTypeHierarchy(Class<?> type) {
        for (Pair<Class<?>, T> entry : this.typeHierarchyList) {
            if (((Class) entry.first).isAssignableFrom(type)) {
                return entry.second;
            }
        }
        return null;
    }

    public synchronized boolean hasSpecificHandlerFor(Type type) {
        return this.map.containsKey(type);
    }

    private synchronized int getIndexOfSpecificHandlerForTypeHierarchy(Class<?> type) {
        int i;
        i = this.typeHierarchyList.size() - 1;
        while (true) {
            if (i < 0) {
                i = -1;
                break;
            } else if (type.equals(this.typeHierarchyList.get(i).first)) {
                break;
            } else {
                i--;
            }
        }
        return i;
    }

    public synchronized ParameterizedTypeHandlerMap<T> copyOf() {
        ParameterizedTypeHandlerMap<T> copy;
        copy = new ParameterizedTypeHandlerMap<>();
        for (Map.Entry<Type, T> entry : this.map.entrySet()) {
            copy.register(entry.getKey(), entry.getValue());
        }
        for (Pair<Class<?>, T> entry2 : this.typeHierarchyList) {
            copy.registerForTypeHierarchy(entry2);
        }
        return copy;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{mapForTypeHierarchy:{");
        boolean first = true;
        for (Pair<Class<?>, T> entry : this.typeHierarchyList) {
            if (first) {
                first = false;
            } else {
                sb.append(',');
            }
            sb.append(typeToString((Type) entry.first)).append(':');
            sb.append(entry.second);
        }
        sb.append("},map:{");
        boolean first2 = true;
        for (Map.Entry<Type, T> entry2 : this.map.entrySet()) {
            if (first2) {
                first2 = false;
            } else {
                sb.append(',');
            }
            sb.append(typeToString(entry2.getKey())).append(':');
            sb.append(entry2.getValue());
        }
        sb.append("}");
        return sb.toString();
    }

    private String typeToString(Type type) {
        return TypeUtils.toRawClass(type).getSimpleName();
    }
}
