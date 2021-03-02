package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.fitness.data.C0618k;
import com.google.android.gms.fitness.data.DataPoint;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.service.b */
class C0701b implements SensorEventDispatcher {

    /* renamed from: Up */
    private final C0618k f1589Up;

    C0701b(C0618k kVar) {
        this.f1589Up = (C0618k) C0348n.m861i(kVar);
    }

    public void publish(DataPoint dataPoint) throws RemoteException {
        this.f1589Up.onEvent(dataPoint);
    }

    public void publish(List<DataPoint> dataPoints) throws RemoteException {
        for (DataPoint publish : dataPoints) {
            publish(publish);
        }
    }
}
