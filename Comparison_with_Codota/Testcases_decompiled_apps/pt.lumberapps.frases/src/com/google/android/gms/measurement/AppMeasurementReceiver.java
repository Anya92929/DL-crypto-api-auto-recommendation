package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzu;

public final class AppMeasurementReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private zzu f7062a;

    /* renamed from: a */
    private zzu m7611a() {
        if (this.f7062a == null) {
            this.f7062a = new zzu();
        }
        return this.f7062a;
    }

    public void onReceive(Context context, Intent intent) {
        m7611a().onReceive(context, intent);
    }
}
