package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0371c;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.maps.internal.C0670c;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.internal.p */
public class C0707p {

    /* renamed from: gN */
    private static Context f1557gN;

    /* renamed from: gO */
    private static C0670c f1558gO;

    /* renamed from: a */
    private static <T> T m2018a(ClassLoader classLoader, String str) {
        try {
            return m2020c(((ClassLoader) C0621s.m1890d(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    /* renamed from: bm */
    private static Class<?> m2019bm() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: c */
    private static <T> T m2020c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (f1557gN == null) {
            if (m2019bm() != null) {
                f1557gN = context;
            } else {
                f1557gN = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return f1557gN;
    }

    /* renamed from: i */
    public static C0670c m2021i(Context context) throws GooglePlayServicesNotAvailableException {
        C0621s.m1890d(context);
        m2023k(context);
        if (f1558gO == null) {
            m2024l(context);
        }
        if (f1558gO != null) {
            return f1558gO;
        }
        f1558gO = C0670c.C0671a.m1981v((IBinder) m2018a(getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        m2022j(context);
        return f1558gO;
    }

    /* renamed from: j */
    private static void m2022j(Context context) {
        try {
            f1558gO.mo5847a(C0371c.m702f(getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: k */
    public static void m2023k(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    /* renamed from: l */
    private static void m2024l(Context context) {
        Class<?> bm = m2019bm();
        if (bm != null) {
            Log.i(C0707p.class.getSimpleName(), "Making Creator statically");
            f1558gO = (C0670c) m2020c(bm);
            m2022j(context);
        }
    }
}
