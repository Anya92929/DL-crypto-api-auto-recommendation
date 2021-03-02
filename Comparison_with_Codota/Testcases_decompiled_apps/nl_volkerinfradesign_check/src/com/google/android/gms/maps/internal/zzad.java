package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class zzad {

    /* renamed from: a */
    private static Context f3443a;

    /* renamed from: b */
    private static zzc f3444b;

    /* renamed from: a */
    private static Class<?> m4175a() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static <T> T m4176a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    /* renamed from: a */
    private static <T> T m4177a(ClassLoader classLoader, String str) {
        try {
            return m4176a(((ClassLoader) zzx.zzz(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    /* renamed from: a */
    private static void m4178a(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    /* renamed from: b */
    private static zzc m4179b(Context context) {
        if (zzAg()) {
            Log.i(zzad.class.getSimpleName(), "Making Creator statically");
            return (zzc) m4176a(m4175a());
        }
        Log.i(zzad.class.getSimpleName(), "Making Creator dynamically");
        return zzc.zza.zzcu((IBinder) m4177a(m4180c(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    /* renamed from: c */
    private static Context m4180c(Context context) {
        if (f3443a == null) {
            if (zzAg()) {
                f3443a = context.getApplicationContext();
            } else {
                f3443a = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return f3443a;
    }

    public static boolean zzAg() {
        return false;
    }

    public static zzc zzaO(Context context) throws GooglePlayServicesNotAvailableException {
        zzx.zzz(context);
        if (f3444b != null) {
            return f3444b;
        }
        m4178a(context);
        f3444b = m4179b(context);
        try {
            f3444b.zzd(zze.zzC(m4180c(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return f3444b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
