package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0411dm;

/* renamed from: com.google.android.gms.dynamic.e */
public abstract class C0169e<T> {

    /* renamed from: mi */
    private final String f446mi;

    /* renamed from: mj */
    private T f447mj;

    /* renamed from: com.google.android.gms.dynamic.e$a */
    public static class C0170a extends Exception {
        public C0170a(String str) {
            super(str);
        }

        public C0170a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0169e(String str) {
        this.f446mi = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract T mo3682d(IBinder iBinder);

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public final T mo3683t(Context context) throws C0170a {
        if (this.f447mj == null) {
            C0411dm.m944e(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0170a("Could not get remote context.");
            }
            try {
                this.f447mj = mo3682d((IBinder) remoteContext.getClassLoader().loadClass(this.f446mi).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0170a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0170a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0170a("Could not access creator.");
            }
        }
        return this.f447mj;
    }
}
