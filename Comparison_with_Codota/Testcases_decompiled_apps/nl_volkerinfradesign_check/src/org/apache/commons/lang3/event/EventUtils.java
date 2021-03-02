package org.apache.commons.lang3.event;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.reflect.MethodUtils;

public class EventUtils {
    public static <L> void addEventListener(Object obj, Class<L> cls, L l) {
        try {
            MethodUtils.invokeMethod(obj, "add" + cls.getSimpleName(), l);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + obj.getClass().getName() + " does not have a public add" + cls.getSimpleName() + " method which takes a parameter of type " + cls.getName() + ".");
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Class " + obj.getClass().getName() + " does not have an accessible add" + cls.getSimpleName() + " method which takes a parameter of type " + cls.getName() + ".");
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Unable to add listener.", e3.getCause());
        }
    }

    public static <L> void bindEventsToMethod(Object obj, String str, Object obj2, Class<L> cls, String... strArr) {
        addEventListener(obj2, cls, cls.cast(Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, new C1964a(obj, str, strArr))));
    }

    /* renamed from: org.apache.commons.lang3.event.EventUtils$a */
    static class C1964a implements InvocationHandler {

        /* renamed from: a */
        private final Object f7131a;

        /* renamed from: b */
        private final String f7132b;

        /* renamed from: c */
        private final Set<String> f7133c;

        C1964a(Object obj, String str, String[] strArr) {
            this.f7131a = obj;
            this.f7132b = str;
            this.f7133c = new HashSet(Arrays.asList(strArr));
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!this.f7133c.isEmpty() && !this.f7133c.contains(method.getName())) {
                return null;
            }
            if (m7410a(method)) {
                return MethodUtils.invokeMethod(this.f7131a, this.f7132b, objArr);
            }
            return MethodUtils.invokeMethod(this.f7131a, this.f7132b, new Object[0]);
        }

        /* renamed from: a */
        private boolean m7410a(Method method) {
            return MethodUtils.getAccessibleMethod(this.f7131a.getClass(), this.f7132b, method.getParameterTypes()) != null;
        }
    }
}
