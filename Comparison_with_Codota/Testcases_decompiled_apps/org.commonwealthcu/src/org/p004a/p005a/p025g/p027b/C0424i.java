package org.p004a.p005a.p025g.p027b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0258e;

/* renamed from: org.a.a.g.b.i */
class C0424i implements InvocationHandler {

    /* renamed from: a */
    private final C0570s f369a;

    private C0424i(C0570s sVar) {
        this.f369a = sVar;
    }

    /* renamed from: a */
    public static C0258e m679a(C0570s sVar) {
        return (C0258e) Proxy.newProxyInstance(C0424i.class.getClassLoader(), new Class[]{C0258e.class}, new C0424i(sVar));
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getName().equals("close")) {
            C0250b.m94a(this.f369a.mo5347b());
            return null;
        }
        try {
            return method.invoke(this.f369a, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                throw cause;
            }
            throw e;
        }
    }
}
