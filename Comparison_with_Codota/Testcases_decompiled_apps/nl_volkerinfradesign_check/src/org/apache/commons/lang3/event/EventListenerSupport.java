package org.apache.commons.lang3.event;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.Validate;

public class EventListenerSupport<L> implements Serializable {
    private static final long serialVersionUID = 3593265990380473632L;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<L> f7127a;

    /* renamed from: b */
    private transient L f7128b;

    /* renamed from: c */
    private transient L[] f7129c;

    public static <T> EventListenerSupport<T> create(Class<T> cls) {
        return new EventListenerSupport<>(cls);
    }

    public EventListenerSupport(Class<L> cls) {
        this(cls, Thread.currentThread().getContextClassLoader());
    }

    public EventListenerSupport(Class<L> cls, ClassLoader classLoader) {
        this();
        Validate.notNull(cls, "Listener interface cannot be null.", new Object[0]);
        Validate.notNull(classLoader, "ClassLoader cannot be null.", new Object[0]);
        Validate.isTrue(cls.isInterface(), "Class {0} is not an interface", cls.getName());
        m7408a(cls, classLoader);
    }

    private EventListenerSupport() {
        this.f7127a = new CopyOnWriteArrayList();
    }

    public L fire() {
        return this.f7128b;
    }

    public void addListener(L l) {
        Validate.notNull(l, "Listener object cannot be null.", new Object[0]);
        this.f7127a.add(l);
    }

    public void removeListener(L l) {
        Validate.notNull(l, "Listener object cannot be null.", new Object[0]);
        this.f7127a.remove(l);
    }

    public L[] getListeners() {
        return this.f7127a.toArray(this.f7129c);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
        for (L next : this.f7127a) {
            try {
                objectOutputStream2.writeObject(next);
                arrayList.add(next);
            } catch (IOException e) {
                objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
            }
        }
        objectOutputStream.writeObject(arrayList.toArray(this.f7129c));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object[] objArr = (Object[]) objectInputStream.readObject();
        this.f7127a = new CopyOnWriteArrayList(objArr);
        m7408a(objArr.getClass().getComponentType(), Thread.currentThread().getContextClassLoader());
    }

    /* renamed from: a */
    private void m7408a(Class<L> cls, ClassLoader classLoader) {
        this.f7129c = (Object[]) Array.newInstance(cls, 0);
        m7409b(cls, classLoader);
    }

    /* renamed from: b */
    private void m7409b(Class<L> cls, ClassLoader classLoader) {
        this.f7128b = cls.cast(Proxy.newProxyInstance(classLoader, new Class[]{cls}, createInvocationHandler()));
    }

    /* access modifiers changed from: protected */
    public InvocationHandler createInvocationHandler() {
        return new ProxyInvocationHandler();
    }

    public class ProxyInvocationHandler implements InvocationHandler {
        protected ProxyInvocationHandler() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            for (Object invoke : EventListenerSupport.this.f7127a) {
                method.invoke(invoke, objArr);
            }
            return null;
        }
    }
}
