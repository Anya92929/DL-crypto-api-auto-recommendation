package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.C1151q;

/* renamed from: com.google.android.gms.location.internal.q */
class C1137q extends C1151q {

    /* renamed from: a */
    private Handler f4980a;

    /* renamed from: a */
    public void mo7890a(Location location) {
        if (this.f4980a == null) {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = location;
        this.f4980a.sendMessage(obtain);
    }
}
