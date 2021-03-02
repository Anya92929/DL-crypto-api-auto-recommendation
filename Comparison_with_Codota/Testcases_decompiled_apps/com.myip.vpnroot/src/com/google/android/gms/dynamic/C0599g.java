package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0348n;

/* renamed from: com.google.android.gms.dynamic.g */
public abstract class C0599g<T> {

    /* renamed from: Sd */
    private final String f1269Sd;

    /* renamed from: Se */
    private T f1270Se;

    /* renamed from: com.google.android.gms.dynamic.g$a */
    public static class C0600a extends Exception {
        public C0600a(String str) {
            super(str);
        }

        public C0600a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0599g(String str) {
        this.f1269Sd = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: L */
    public final T mo5547L(Context context) throws C0600a {
        if (this.f1270Se == null) {
            C0348n.m861i(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0600a("Could not get remote context.");
            }
            try {
                this.f1270Se = mo4552d((IBinder) remoteContext.getClassLoader().loadClass(this.f1269Sd).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0600a("Could not load creator class.", e);
            } catch (InstantiationException e2) {
                throw new C0600a("Could not instantiate creator.", e2);
            } catch (IllegalAccessException e3) {
                throw new C0600a("Could not access creator.", e3);
            }
        }
        return this.f1270Se;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract T mo4552d(IBinder iBinder);
}
