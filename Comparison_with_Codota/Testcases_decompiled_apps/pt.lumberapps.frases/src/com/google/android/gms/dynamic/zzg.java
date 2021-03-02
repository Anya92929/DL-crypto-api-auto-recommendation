package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zze;

public abstract class zzg {

    /* renamed from: a */
    private final String f4783a;

    /* renamed from: b */
    private Object f4784b;

    public class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    protected zzg(String str) {
        this.f4783a = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo6997a(Context context) {
        if (this.f4784b == null) {
            zzab.zzy(context);
            Context remoteContext = zze.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.f4784b = zzc((IBinder) remoteContext.getClassLoader().loadClass(this.f4783a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zza("Could not load creator class.", e);
            } catch (InstantiationException e2) {
                throw new zza("Could not instantiate creator.", e2);
            } catch (IllegalAccessException e3) {
                throw new zza("Could not access creator.", e3);
            }
        }
        return this.f4784b;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzc(IBinder iBinder);
}
