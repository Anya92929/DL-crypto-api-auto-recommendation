package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.C0667k;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.fitness.request.a */
public class C0642a extends C0667k.C0668a {

    /* renamed from: TU */
    private final BleScanCallback f1510TU;

    /* renamed from: com.google.android.gms.fitness.request.a$a */
    public static class C0644a {

        /* renamed from: TV */
        private static final C0644a f1511TV = new C0644a();

        /* renamed from: TW */
        private final Map<BleScanCallback, C0642a> f1512TW = new HashMap();

        private C0644a() {
        }

        /* renamed from: iV */
        public static C0644a m1972iV() {
            return f1511TV;
        }

        /* renamed from: a */
        public C0642a mo6023a(BleScanCallback bleScanCallback) {
            C0642a aVar;
            synchronized (this.f1512TW) {
                aVar = this.f1512TW.get(bleScanCallback);
                if (aVar == null) {
                    aVar = new C0642a(bleScanCallback);
                    this.f1512TW.put(bleScanCallback, aVar);
                }
            }
            return aVar;
        }

        /* renamed from: b */
        public C0642a mo6024b(BleScanCallback bleScanCallback) {
            C0642a aVar;
            synchronized (this.f1512TW) {
                aVar = this.f1512TW.get(bleScanCallback);
                if (aVar == null) {
                    aVar = new C0642a(bleScanCallback);
                }
            }
            return aVar;
        }
    }

    private C0642a(BleScanCallback bleScanCallback) {
        this.f1510TU = (BleScanCallback) C0348n.m861i(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.f1510TU.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.f1510TU.onScanStopped();
    }
}
