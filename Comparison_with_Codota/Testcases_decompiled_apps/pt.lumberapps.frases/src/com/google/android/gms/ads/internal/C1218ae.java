package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzkd;

/* renamed from: com.google.android.gms.ads.internal.ae */
class C1218ae implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ zzt f3440a;

    C1218ae(zzt zzt) {
        this.f3440a = zzt;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f3440a.f4078h == null) {
            return false;
        }
        try {
            this.f3440a.f4078h.zza(motionEvent);
            return false;
        } catch (RemoteException e) {
            zzkd.zzd("Unable to process ad data", e);
            return false;
        }
    }
}
