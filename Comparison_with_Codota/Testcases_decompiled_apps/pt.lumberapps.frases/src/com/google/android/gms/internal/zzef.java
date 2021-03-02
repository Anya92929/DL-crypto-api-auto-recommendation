package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzdu;

@zzin
public class zzef extends zzg {
    public zzef() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzdu zzc(IBinder iBinder) {
        return zzdu.zza.zzaa(iBinder);
    }

    public zzdt zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            return zzdt.zza.zzz(((zzdu) mo6997a(context)).zza(zze.zzac(context), zze.zzac(frameLayout), zze.zzac(frameLayout2), com.google.android.gms.common.internal.zze.f4556xM));
        } catch (RemoteException | zzg.zza e) {
            zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }
}
