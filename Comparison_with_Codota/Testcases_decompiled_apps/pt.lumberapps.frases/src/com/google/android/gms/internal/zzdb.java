package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.zze;

@zzin
public class zzdb {

    /* renamed from: a */
    private final Object f6097a = new Object();

    /* renamed from: b */
    private boolean f6098b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SharedPreferences f6099c = null;

    public void initialize(Context context) {
        synchronized (this.f6097a) {
            if (!this.f6098b) {
                Context remoteContext = zze.getRemoteContext(context);
                if (remoteContext != null) {
                    this.f6099c = zzu.zzfx().zzn(remoteContext);
                    this.f6098b = true;
                }
            }
        }
    }

    public Object zzd(zzcy zzcy) {
        synchronized (this.f6097a) {
            if (this.f6098b) {
                return zzkt.zzb(new C1530en(this, zzcy));
            }
            Object zzjw = zzcy.zzjw();
            return zzjw;
        }
    }
}
