package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.lang.reflect.Proxy;

/* renamed from: org.apache.commons.io.input.ClassLoaderObjectInputStream */
public class ClassLoaderObjectInputStream extends ObjectInputStream {

    /* renamed from: a */
    private final ClassLoader f6902a;

    public ClassLoaderObjectInputStream(ClassLoader classLoader, InputStream inputStream) throws IOException, StreamCorruptedException {
        super(inputStream);
        this.f6902a = classLoader;
    }

    /* access modifiers changed from: protected */
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        Class<?> cls = Class.forName(objectStreamClass.getName(), false, this.f6902a);
        return cls != null ? cls : super.resolveClass(objectStreamClass);
    }

    /* access modifiers changed from: protected */
    public Class<?> resolveProxyClass(String[] strArr) throws IOException, ClassNotFoundException {
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i], false, this.f6902a);
        }
        try {
            return Proxy.getProxyClass(this.f6902a, clsArr);
        } catch (IllegalArgumentException e) {
            return super.resolveProxyClass(strArr);
        }
    }
}
