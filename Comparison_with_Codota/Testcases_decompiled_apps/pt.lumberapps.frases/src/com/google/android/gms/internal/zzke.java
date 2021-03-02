package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzu;

@zzin
public class zzke extends Handler {
    public zzke(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzu.zzft().zzb((Throwable) e, false);
            throw e;
        }
    }
}
