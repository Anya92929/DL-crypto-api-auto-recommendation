package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.internal.zzsb;
import com.google.android.gms.internal.zzty;

public class zztx {

    /* renamed from: a */
    private boolean f7000a = false;

    /* renamed from: b */
    private zzty f7001b = null;

    public void initialize(Context context) {
        synchronized (this) {
            if (!this.f7000a) {
                try {
                    this.f7001b = zzty.zza.asInterface(zzsb.zza(context, zzsb.f6978KI, ModuleDescriptor.MODULE_ID).zziu("com.google.android.gms.flags.impl.FlagProviderImpl"));
                    this.f7001b.init(zze.zzac(context));
                    this.f7000a = true;
                } catch (RemoteException | zzsb.zza e) {
                    Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
                }
                return;
            }
            return;
        }
    }

    public Object zzb(zztv zztv) {
        synchronized (this) {
            if (this.f7000a) {
                return zztv.zza(this.f7001b);
            }
            Object zzjw = zztv.zzjw();
            return zzjw;
        }
    }
}
