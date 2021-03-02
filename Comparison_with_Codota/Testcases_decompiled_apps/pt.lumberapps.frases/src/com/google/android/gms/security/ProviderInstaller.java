package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final zzc f7402a = zzc.zzang();

    /* renamed from: b */
    private static final Object f7403b = new Object();

    /* renamed from: c */
    private static Method f7404c = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    /* renamed from: a */
    private static void m8023a(Context context) {
        f7404c = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }

    public static void installIfNeeded(Context context) {
        zzab.zzb((Object) context, (Object) "Context must not be null");
        f7402a.zzbo(context);
        Context remoteContext = zze.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (f7403b) {
            try {
                if (f7404c == null) {
                    m8023a(remoteContext);
                }
                f7404c.invoke((Object) null, new Object[]{remoteContext});
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("ProviderInstaller", valueOf.length() != 0 ? "Failed to install provider: ".concat(valueOf) : new String("Failed to install provider: "));
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        zzab.zzb((Object) context, (Object) "Context must not be null");
        zzab.zzb((Object) providerInstallListener, (Object) "Listener must not be null");
        zzab.zzhi("Must be called on the UI thread");
        new C1947a(context, providerInstallListener).execute(new Void[0]);
    }
}
