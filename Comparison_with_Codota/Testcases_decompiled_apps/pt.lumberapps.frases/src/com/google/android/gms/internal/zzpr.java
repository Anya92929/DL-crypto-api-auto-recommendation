package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.zzc;
import java.util.Iterator;

public class zzpr extends zzpn {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8900a() {
        zzqc zzqc = null;
        zzqc.zzaoo();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8901a(ConnectionResult connectionResult, int i) {
        zzqc zzqc = null;
        zzqc.zza(connectionResult, i);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.zzqc, com.google.android.gms.common.util.zza] */
    public void onStop() {
        ? r2 = 0;
        super.onStop();
        Iterator it = r2.iterator();
        while (it.hasNext()) {
            ((zzc) it.next()).release();
        }
        r2.clear();
        r2.zza(this);
    }
}
