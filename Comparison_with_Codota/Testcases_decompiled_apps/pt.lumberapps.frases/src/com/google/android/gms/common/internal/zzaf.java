package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

public final class zzaf extends zzg {

    /* renamed from: a */
    private static final zzaf f4517a = new zzaf();

    private zzaf() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: a */
    private View m6070a(Context context, int i, int i2, Scope[] scopeArr) {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, scopeArr);
            return (View) zze.zzad(((zzx) mo6997a(context)).zza(zze.zzac(context), signInButtonConfig));
        } catch (Exception e) {
            throw new zzg.zza(new StringBuilder(64).append("Could not get button with size ").append(i).append(" and color ").append(i2).toString(), e);
        }
    }

    public static View zzb(Context context, int i, int i2, Scope[] scopeArr) {
        return f4517a.m6070a(context, i, i2, scopeArr);
    }

    /* renamed from: zzdx */
    public zzx zzc(IBinder iBinder) {
        return zzx.zza.zzdw(iBinder);
    }
}
