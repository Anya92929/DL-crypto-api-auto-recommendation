package com.google.android.gms.ads.internal.client;

/* renamed from: com.google.android.gms.ads.internal.client.d */
class C1231d extends zzo {

    /* renamed from: a */
    final /* synthetic */ zzae f3457a;

    C1231d(zzae zzae) {
        this.f3457a = zzae;
    }

    public void onAdFailedToLoad(int i) {
        this.f3457a.f3536e.zza(this.f3457a.zzjk());
        super.onAdFailedToLoad(i);
    }

    public void onAdLoaded() {
        this.f3457a.f3536e.zza(this.f3457a.zzjk());
        super.onAdLoaded();
    }
}
