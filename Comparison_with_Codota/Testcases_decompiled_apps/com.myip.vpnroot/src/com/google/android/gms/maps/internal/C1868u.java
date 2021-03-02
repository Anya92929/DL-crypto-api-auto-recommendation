package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.maps.internal.C1816c;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.internal.u */
public class C1868u {
    private static Context ajm;
    private static C1816c ajn;

    /* renamed from: R */
    public static C1816c m6388R(Context context) throws GooglePlayServicesNotAvailableException {
        C0348n.m861i(context);
        if (ajn != null) {
            return ajn;
        }
        m6389S(context);
        ajn = m6390T(context);
        try {
            ajn.mo10665a(C0597e.m1743k(getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return ajn;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: S */
    private static void m6389S(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    /* renamed from: T */
    private static C1816c m6390T(Context context) {
        if (m6393mI()) {
            Log.i(C1868u.class.getSimpleName(), "Making Creator statically");
            return (C1816c) m6392c(m6394mJ());
        }
        Log.i(C1868u.class.getSimpleName(), "Making Creator dynamically");
        return C1816c.C1817a.m6340aP((IBinder) m6391a(getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    /* renamed from: a */
    private static <T> T m6391a(ClassLoader classLoader, String str) {
        try {
            return m6392c(((ClassLoader) C0348n.m861i(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    /* renamed from: c */
    private static <T> T m6392c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (ajm == null) {
            if (m6393mI()) {
                ajm = context.getApplicationContext();
            } else {
                ajm = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return ajm;
    }

    /* renamed from: mI */
    private static boolean m6393mI() {
        return false;
    }

    /* renamed from: mJ */
    private static Class<?> m6394mJ() {
        try {
            return Build.VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
