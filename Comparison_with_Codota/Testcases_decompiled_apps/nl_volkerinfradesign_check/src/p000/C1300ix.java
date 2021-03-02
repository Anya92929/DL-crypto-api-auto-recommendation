package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: ix */
public class C1300ix<T> {

    /* renamed from: a */
    private final Class<?> f4526a;

    /* renamed from: b */
    private final String f4527b;

    /* renamed from: c */
    private final Class[] f4528c;

    public C1300ix(Class<?> cls, String str, Class... clsArr) {
        this.f4526a = cls;
        this.f4527b = str;
        this.f4528c = clsArr;
    }

    /* renamed from: a */
    public boolean mo8707a(T t) {
        return m5631a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo8706a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m5631a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /* renamed from: b */
    public Object mo8708b(T t, Object... objArr) {
        try {
            return mo8706a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: c */
    public Object mo8709c(T t, Object... objArr) throws InvocationTargetException {
        Method a = m5631a(t.getClass());
        if (a == null) {
            throw new AssertionError("Method " + this.f4527b + " not supported for object " + t);
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object mo8710d(T t, Object... objArr) {
        try {
            return mo8709c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private Method m5631a(Class<?> cls) {
        if (this.f4527b == null) {
            return null;
        }
        Method a = m5632a(cls, this.f4527b, this.f4528c);
        if (a == null || this.f4526a == null || this.f4526a.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m5632a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }
}
