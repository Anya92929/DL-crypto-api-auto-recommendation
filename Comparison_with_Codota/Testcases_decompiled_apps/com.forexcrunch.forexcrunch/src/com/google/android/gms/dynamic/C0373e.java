package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0621s;

/* renamed from: com.google.android.gms.dynamic.e */
public abstract class C0373e<T> {

    /* renamed from: dd */
    private final String f872dd;

    /* renamed from: de */
    private T f873de;

    /* renamed from: com.google.android.gms.dynamic.e$a */
    public static class C0374a extends Exception {
        public C0374a(String str) {
            super(str);
        }

        public C0374a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0373e(String str) {
        this.f872dd = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final T mo4132h(Context context) throws C0374a {
        if (this.f873de == null) {
            C0621s.m1890d(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0374a("Could not get remote context.");
            }
            try {
                this.f873de = mo4133k((IBinder) remoteContext.getClassLoader().loadClass(this.f872dd).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0374a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0374a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0374a("Could not access creator.");
            }
        }
        return this.f873de;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public abstract T mo4133k(IBinder iBinder);
}
