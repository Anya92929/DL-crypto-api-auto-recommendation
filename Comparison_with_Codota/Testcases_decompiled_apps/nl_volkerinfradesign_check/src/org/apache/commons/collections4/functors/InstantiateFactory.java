package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

public class InstantiateFactory<T> implements Serializable, Factory<T> {
    private static final long serialVersionUID = -7732226881069447957L;

    /* renamed from: a */
    private final Class<T> f6432a;

    /* renamed from: b */
    private final Class<?>[] f6433b;

    /* renamed from: c */
    private final Object[] f6434c;

    /* renamed from: d */
    private transient Constructor<T> f6435d = null;

    public static <T> Factory<T> instantiateFactory(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        if (cls == null) {
            throw new IllegalArgumentException("Class to instantiate must not be null");
        } else if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("Parameter types must match the arguments");
        } else if (clsArr == null || clsArr.length == 0) {
            return new InstantiateFactory(cls);
        } else {
            return new InstantiateFactory(cls, clsArr, objArr);
        }
    }

    public InstantiateFactory(Class<T> cls) {
        this.f6432a = cls;
        this.f6433b = null;
        this.f6434c = null;
        m7049a();
    }

    public InstantiateFactory(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        this.f6432a = cls;
        this.f6433b = (Class[]) clsArr.clone();
        this.f6434c = (Object[]) objArr.clone();
        m7049a();
    }

    /* renamed from: a */
    private void m7049a() {
        try {
            this.f6435d = this.f6432a.getConstructor(this.f6433b);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("InstantiateFactory: The constructor must exist and be public ");
        }
    }

    public T create() {
        if (this.f6435d == null) {
            m7049a();
        }
        try {
            return this.f6435d.newInstance(this.f6434c);
        } catch (InstantiationException e) {
            throw new FunctorException("InstantiateFactory: InstantiationException", e);
        } catch (IllegalAccessException e2) {
            throw new FunctorException("InstantiateFactory: Constructor must be public", e2);
        } catch (InvocationTargetException e3) {
            throw new FunctorException("InstantiateFactory: Constructor threw an exception", e3);
        }
    }
}
