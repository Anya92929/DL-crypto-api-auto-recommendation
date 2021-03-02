package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter {

    public class zza {

        /* renamed from: a */
        private int f4138a;

        public zza zzbb(int i) {
            this.f4138a = i;
            return this;
        }

        public Bundle zzvp() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f4138a);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
