package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.C1148n;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* renamed from: com.google.android.gms.location.internal.p */
class C1136p extends C1148n {

    /* renamed from: a */
    private Handler f4979a;

    /* renamed from: a */
    private void m4951a(int i, Object obj) {
        if (this.f4979a == null) {
            Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        this.f4979a.sendMessage(obtain);
    }

    /* renamed from: a */
    public void mo7888a(LocationAvailability locationAvailability) {
        m4951a(1, locationAvailability);
    }

    /* renamed from: a */
    public void mo7889a(LocationResult locationResult) {
        m4951a(0, locationResult);
    }
}
