package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzae;

public final class AppMeasurementService extends Service implements zzae.zza {

    /* renamed from: a */
    private zzae f7063a;

    /* renamed from: a */
    private zzae m7612a() {
        if (this.f7063a == null) {
            this.f7063a = new zzae(this);
        }
        return this.f7063a;
    }

    public boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    public Context getContext() {
        return this;
    }

    public IBinder onBind(Intent intent) {
        return m7612a().onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        m7612a().onCreate();
    }

    public void onDestroy() {
        m7612a().onDestroy();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        m7612a().onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return m7612a().onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return m7612a().onUnbind(intent);
    }
}
