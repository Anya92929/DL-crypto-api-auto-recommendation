package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.common.C0853e;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0608m;

public class zzy {

    /* renamed from: a */
    private static Context f5112a;

    /* renamed from: b */
    private static zzc f5113b;

    /* renamed from: a */
    private static Class<?> m5078a() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static <T> T m5079a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    /* renamed from: a */
    private static <T> T m5080a(ClassLoader classLoader, String str) {
        try {
            return m5079a(((ClassLoader) C1009bf.m4528a(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    /* renamed from: a */
    private static void m5081a(Context context) {
        int a = C0853e.m4237a(context);
        switch (a) {
            case 0:
                return;
            default:
                throw new C0799c(a);
        }
    }

    /* renamed from: b */
    private static zzc m5082b(Context context) {
        if (zzwZ()) {
            Log.i(zzy.class.getSimpleName(), "Making Creator statically");
            return (zzc) m5079a(m5078a());
        }
        Log.i(zzy.class.getSimpleName(), "Making Creator dynamically");
        return zzc.zza.zzck((IBinder) m5080a(m5083c(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    /* renamed from: c */
    private static Context m5083c(Context context) {
        if (f5112a == null) {
            if (zzwZ()) {
                f5112a = context.getApplicationContext();
            } else {
                f5112a = C0853e.m4255e(context);
            }
        }
        return f5112a;
    }

    public static zzc zzaF(Context context) {
        C1009bf.m4528a(context);
        if (f5113b != null) {
            return f5113b;
        }
        m5081a(context);
        f5113b = m5082b(context);
        try {
            f5113b.zzd(C0608m.m3536a(m5083c(context).getResources()), C0853e.f4594a);
            return f5113b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static boolean zzwZ() {
        return false;
    }
}
