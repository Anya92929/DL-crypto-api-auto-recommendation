package com.google.ads.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.ads.util.i */
public abstract class C0304i {

    /* renamed from: a */
    private static final Object f739a = new Object();

    /* renamed from: b */
    private static int f740b = 0;

    /* renamed from: c */
    private static HashMap<Class<?>, Integer> f741c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C0306a<?>> f742d = new ArrayList<>();

    /* renamed from: u */
    public final int f743u;

    public C0304i() {
        synchronized (f739a) {
            int i = f740b;
            f740b = i + 1;
            this.f743u = i;
            Integer num = f741c.get(getClass());
            if (num == null) {
                f741c.put(getClass(), 1);
            } else {
                f741c.put(getClass(), Integer.valueOf(num.intValue() + 1));
            }
        }
        C0284b.m488d("State created: " + toString());
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        synchronized (f739a) {
            f741c.put(getClass(), Integer.valueOf(f741c.get(getClass()).intValue() - 1));
        }
        super.finalize();
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.f743u + "]";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m511a(C0306a<?> aVar) {
        this.f742d.add(aVar);
    }

    /* renamed from: com.google.ads.util.i$a */
    public abstract class C0306a<T> {

        /* renamed from: a */
        protected T f744a;

        /* renamed from: b */
        protected final String f745b;

        private C0306a(C0304i iVar, String str) {
            this(str, (Object) null);
        }

        private C0306a(String str, T t) {
            this.f745b = str;
            C0304i.this.m511a(this);
            this.f744a = t;
        }

        public String toString() {
            return C0304i.this.toString() + "." + this.f745b + " = " + this.f744a;
        }
    }

    /* renamed from: com.google.ads.util.i$c */
    public final class C0308c<T> extends C0306a<T> {

        /* renamed from: e */
        private boolean f749e;

        public C0308c(String str) {
            super(str);
            this.f749e = false;
            this.f749e = false;
        }

        public C0308c(String str, T t) {
            super(str, t);
            this.f749e = false;
            this.f749e = false;
        }

        /* renamed from: a */
        public synchronized T mo3726a() {
            return this.f744a;
        }

        /* renamed from: a */
        public synchronized void mo3727a(T t) {
            C0284b.m488d("State changed - " + C0304i.this.toString() + "." + this.f745b + ": '" + t + "' <-- '" + this.f744a + "'.");
            this.f744a = t;
            this.f749e = true;
        }

        public String toString() {
            return super.toString() + (this.f749e ? " (*)" : "");
        }
    }

    /* renamed from: com.google.ads.util.i$b */
    public final class C0307b<T> extends C0306a<T> {
        public C0307b(String str, T t) {
            super(str, t);
        }

        /* renamed from: a */
        public T mo3725a() {
            return this.f744a;
        }

        public String toString() {
            return super.toString() + " (!)";
        }
    }

    /* renamed from: com.google.ads.util.i$d */
    public final class C0309d<T> extends C0306a<WeakReference<T>> {
        public C0309d(String str, T t) {
            super(str, new WeakReference(t));
        }

        /* renamed from: a */
        public T mo3728a() {
            return ((WeakReference) this.f744a).get();
        }

        public String toString() {
            return C0304i.this.toString() + "." + this.f745b + " = " + mo3728a() + " (?)";
        }
    }
}
