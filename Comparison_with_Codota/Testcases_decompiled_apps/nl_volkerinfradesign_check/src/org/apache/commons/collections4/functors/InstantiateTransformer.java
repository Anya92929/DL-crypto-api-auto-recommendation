package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

public class InstantiateTransformer<T> implements Serializable, Transformer<Class<? extends T>, T> {

    /* renamed from: a */
    private static final Transformer f6436a = new InstantiateTransformer();
    private static final long serialVersionUID = 3786388740793356347L;

    /* renamed from: b */
    private final Class<?>[] f6437b;

    /* renamed from: c */
    private final Object[] f6438c;

    public static <T> Transformer<Class<? extends T>, T> instantiateTransformer() {
        return f6436a;
    }

    public static <T> Transformer<Class<? extends T>, T> instantiateTransformer(Class<?>[] clsArr, Object[] objArr) {
        if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("Parameter types must match the arguments");
        } else if (clsArr == null || clsArr.length == 0) {
            return new InstantiateTransformer();
        } else {
            return new InstantiateTransformer(clsArr, objArr);
        }
    }

    private InstantiateTransformer() {
        this.f6437b = null;
        this.f6438c = null;
    }

    public InstantiateTransformer(Class<?>[] clsArr, Object[] objArr) {
        Class<?>[] clsArr2;
        Object[] objArr2;
        if (clsArr != null) {
            clsArr2 = (Class[]) clsArr.clone();
        } else {
            clsArr2 = null;
        }
        this.f6437b = clsArr2;
        if (objArr != null) {
            objArr2 = (Object[]) objArr.clone();
        } else {
            objArr2 = null;
        }
        this.f6438c = objArr2;
    }

    public T transform(Class<? extends T> cls) {
        if (cls != null) {
            return cls.getConstructor(this.f6437b).newInstance(this.f6438c);
        }
        try {
            throw new FunctorException("InstantiateTransformer: Input object was not an instanceof Class, it was a null object");
        } catch (NoSuchMethodException e) {
            throw new FunctorException("InstantiateTransformer: The constructor must exist and be public ");
        } catch (InstantiationException e2) {
            throw new FunctorException("InstantiateTransformer: InstantiationException", e2);
        } catch (IllegalAccessException e3) {
            throw new FunctorException("InstantiateTransformer: Constructor must be public", e3);
        } catch (InvocationTargetException e4) {
            throw new FunctorException("InstantiateTransformer: Constructor threw an exception", e4);
        }
    }
}
