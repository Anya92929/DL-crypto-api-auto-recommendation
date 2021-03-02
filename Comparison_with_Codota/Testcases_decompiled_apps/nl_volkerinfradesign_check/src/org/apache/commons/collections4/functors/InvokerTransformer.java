package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

public class InvokerTransformer<I, O> implements Serializable, Transformer<I, O> {
    private static final long serialVersionUID = -8653385846894047688L;

    /* renamed from: a */
    private final String f6439a;

    /* renamed from: b */
    private final Class<?>[] f6440b;

    /* renamed from: c */
    private final Object[] f6441c;

    public static <I, O> Transformer<I, O> invokerTransformer(String str) {
        if (str != null) {
            return new InvokerTransformer(str);
        }
        throw new IllegalArgumentException("The method to invoke must not be null");
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("The method to invoke must not be null");
        } else if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("The parameter types must match the arguments");
        } else if (clsArr == null || clsArr.length == 0) {
            return new InvokerTransformer(str);
        } else {
            return new InvokerTransformer(str, clsArr, objArr);
        }
    }

    private InvokerTransformer(String str) {
        this.f6439a = str;
        this.f6440b = null;
        this.f6441c = null;
    }

    public InvokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?>[] clsArr2;
        Object[] objArr2;
        this.f6439a = str;
        if (clsArr != null) {
            clsArr2 = (Class[]) clsArr.clone();
        } else {
            clsArr2 = null;
        }
        this.f6440b = clsArr2;
        if (objArr != null) {
            objArr2 = (Object[]) objArr.clone();
        } else {
            objArr2 = null;
        }
        this.f6441c = objArr2;
    }

    public O transform(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.getClass().getMethod(this.f6439a, this.f6440b).invoke(obj, this.f6441c);
        } catch (NoSuchMethodException e) {
            throw new FunctorException("InvokerTransformer: The method '" + this.f6439a + "' on '" + obj.getClass() + "' does not exist");
        } catch (IllegalAccessException e2) {
            throw new FunctorException("InvokerTransformer: The method '" + this.f6439a + "' on '" + obj.getClass() + "' cannot be accessed");
        } catch (InvocationTargetException e3) {
            throw new FunctorException("InvokerTransformer: The method '" + this.f6439a + "' on '" + obj.getClass() + "' threw an exception", e3);
        }
    }
}
