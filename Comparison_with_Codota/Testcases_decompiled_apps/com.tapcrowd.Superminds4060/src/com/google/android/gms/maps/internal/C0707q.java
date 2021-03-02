package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.maps.internal.C0667c;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.internal.q */
public class C0707q {

    /* renamed from: pW */
    private static Context f1697pW;

    /* renamed from: pX */
    private static C0667c f1698pX;

    /* renamed from: a */
    private static <T> T m2067a(ClassLoader classLoader, String str) {
        try {
            return m2068c(((ClassLoader) C0411dm.m944e(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    /* renamed from: c */
    private static <T> T m2068c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    /* renamed from: cI */
    private static boolean m2069cI() {
        return m2070cJ() != null;
    }

    /* renamed from: cJ */
    private static Class<?> m2070cJ() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static Context getRemoteContext(Context context) {
        if (f1697pW == null) {
            if (m2069cI()) {
                f1697pW = context;
            } else {
                f1697pW = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return f1697pW;
    }

    /* renamed from: u */
    public static C0667c m2071u(Context context) throws GooglePlayServicesNotAvailableException {
        C0411dm.m944e(context);
        if (f1698pX != null) {
            return f1698pX;
        }
        m2072v(context);
        f1698pX = m2073w(context);
        try {
            f1698pX.mo5677a(C0167c.m379g(getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return f1698pX;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: v */
    private static void m2072v(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    /* renamed from: w */
    private static C0667c m2073w(Context context) {
        if (!m2069cI()) {
            return C0667c.C0668a.m2027J((IBinder) m2067a(getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
        Log.i(C0707q.class.getSimpleName(), "Making Creator statically");
        return (C0667c) m2068c(m2070cJ());
    }
}
