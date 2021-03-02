package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;

public abstract class zzg<T> {

    /* renamed from: a */
    private final String f3143a;

    /* renamed from: b */
    private T f3144b;

    public static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    public zzg(String str) {
        this.f3143a = str;
    }

    public final T zzaB(Context context) throws zza {
        if (this.f3144b == null) {
            zzx.zzz(context);
            Context remoteContext = zze.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.f3144b = zzd((IBinder) remoteContext.getClassLoader().loadClass(this.f3143a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zza("Could not load creator class.", e);
            } catch (InstantiationException e2) {
                throw new zza("Could not instantiate creator.", e2);
            } catch (IllegalAccessException e3) {
                throw new zza("Could not access creator.", e3);
            }
        }
        return this.f3144b;
    }

    public abstract T zzd(IBinder iBinder);
}
