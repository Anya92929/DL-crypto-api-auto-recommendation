package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

public final class zzab extends zzg<zzu> {

    /* renamed from: a */
    private static final zzab f2938a = new zzab();

    private zzab() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: a */
    private View m3902a(Context context, int i, int i2, Scope[] scopeArr) throws zzg.zza {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, scopeArr);
            return (View) zze.zzp(((zzu) zzaB(context)).zza(zze.zzC(context), signInButtonConfig));
        } catch (Exception e) {
            throw new zzg.zza("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public static View zzb(Context context, int i, int i2, Scope[] scopeArr) throws zzg.zza {
        return f2938a.m3902a(context, i, i2, scopeArr);
    }

    /* renamed from: zzaV */
    public zzu zzd(IBinder iBinder) {
        return zzu.zza.zzaU(iBinder);
    }
}
