package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

public class PrototypeFactory {
    public static <T> Factory<T> prototypeFactory(T t) {
        if (t == null) {
            return ConstantFactory.constantFactory(null);
        }
        try {
            return new C1863a(t, t.getClass().getMethod("clone", (Class[]) null));
        } catch (NoSuchMethodException e) {
            try {
                t.getClass().getConstructor(new Class[]{t.getClass()});
                return new InstantiateFactory(t.getClass(), new Class[]{t.getClass()}, new Object[]{t});
            } catch (NoSuchMethodException e2) {
                if (t instanceof Serializable) {
                    return new C1864b((Serializable) t);
                }
                throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
            }
        }
    }

    private PrototypeFactory() {
    }

    /* renamed from: org.apache.commons.collections4.functors.PrototypeFactory$a */
    static class C1863a<T> implements Serializable, Factory<T> {
        private static final long serialVersionUID = 5604271422565175555L;

        /* renamed from: a */
        private final T f6450a;

        /* renamed from: b */
        private transient Method f6451b;

        private C1863a(T t, Method method) {
            this.f6450a = t;
            this.f6451b = method;
        }

        /* renamed from: a */
        private void m7050a() {
            try {
                this.f6451b = this.f6450a.getClass().getMethod("clone", (Class[]) null);
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
            }
        }

        public T create() {
            if (this.f6451b == null) {
                m7050a();
            }
            try {
                return this.f6451b.invoke(this.f6450a, (Object[]) null);
            } catch (IllegalAccessException e) {
                throw new FunctorException("PrototypeCloneFactory: Clone method must be public", e);
            } catch (InvocationTargetException e2) {
                throw new FunctorException("PrototypeCloneFactory: Clone method threw an exception", e2);
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.functors.PrototypeFactory$b */
    static class C1864b<T extends Serializable> implements Serializable, Factory<T> {
        private static final long serialVersionUID = -8704966966139178833L;

        /* renamed from: a */
        private final T f6452a;

        private C1864b(T t) {
            this.f6452a = t;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A[SYNTHETIC, Splitter:B:19:0x003b] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T create() {
            /*
                r4 = this;
                java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
                r0 = 512(0x200, float:7.175E-43)
                r3.<init>(r0)
                r2 = 0
                java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ ClassNotFoundException -> 0x002f, IOException -> 0x0042 }
                r0.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x002f, IOException -> 0x0042 }
                T r1 = r4.f6452a     // Catch:{ ClassNotFoundException -> 0x002f, IOException -> 0x0042 }
                r0.writeObject(r1)     // Catch:{ ClassNotFoundException -> 0x002f, IOException -> 0x0042 }
                java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ ClassNotFoundException -> 0x002f, IOException -> 0x0042 }
                byte[] r0 = r3.toByteArray()     // Catch:{ ClassNotFoundException -> 0x002f, IOException -> 0x0042 }
                r1.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x002f, IOException -> 0x0042 }
                java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ ClassNotFoundException -> 0x0056, IOException -> 0x0053 }
                r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x0056, IOException -> 0x0053 }
                java.lang.Object r0 = r0.readObject()     // Catch:{ ClassNotFoundException -> 0x0056, IOException -> 0x0053 }
                java.io.Serializable r0 = (java.io.Serializable) r0     // Catch:{ ClassNotFoundException -> 0x0056, IOException -> 0x0053 }
                if (r1 == 0) goto L_0x002b
                r1.close()     // Catch:{ IOException -> 0x004b }
            L_0x002b:
                r3.close()     // Catch:{ IOException -> 0x004d }
            L_0x002e:
                return r0
            L_0x002f:
                r0 = move-exception
                r1 = r2
            L_0x0031:
                org.apache.commons.collections4.FunctorException r2 = new org.apache.commons.collections4.FunctorException     // Catch:{ all -> 0x0037 }
                r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x0037 }
                throw r2     // Catch:{ all -> 0x0037 }
            L_0x0037:
                r0 = move-exception
                r2 = r1
            L_0x0039:
                if (r2 == 0) goto L_0x003e
                r2.close()     // Catch:{ IOException -> 0x004f }
            L_0x003e:
                r3.close()     // Catch:{ IOException -> 0x0051 }
            L_0x0041:
                throw r0
            L_0x0042:
                r0 = move-exception
            L_0x0043:
                org.apache.commons.collections4.FunctorException r1 = new org.apache.commons.collections4.FunctorException     // Catch:{ all -> 0x0049 }
                r1.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x0049 }
                throw r1     // Catch:{ all -> 0x0049 }
            L_0x0049:
                r0 = move-exception
                goto L_0x0039
            L_0x004b:
                r1 = move-exception
                goto L_0x002b
            L_0x004d:
                r1 = move-exception
                goto L_0x002e
            L_0x004f:
                r1 = move-exception
                goto L_0x003e
            L_0x0051:
                r1 = move-exception
                goto L_0x0041
            L_0x0053:
                r0 = move-exception
                r2 = r1
                goto L_0x0043
            L_0x0056:
                r0 = move-exception
                goto L_0x0031
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.functors.PrototypeFactory.C1864b.create():java.io.Serializable");
        }
    }
}
