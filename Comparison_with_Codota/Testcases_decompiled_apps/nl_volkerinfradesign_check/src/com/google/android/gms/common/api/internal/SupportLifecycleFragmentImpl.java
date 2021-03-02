package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class SupportLifecycleFragmentImpl extends zzw {
    /* access modifiers changed from: protected */
    public void zzb(int i, ConnectionResult connectionResult) {
        GooglePlayServicesUtil.showErrorDialogFragment(connectionResult.getErrorCode(), getActivity(), this, 2, this);
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, ConnectionResult connectionResult) {
        final Dialog zza = zzpQ().zza(getActivity(), this);
        this.zzaiD = C1192hd.m5260a(getActivity().getApplicationContext(), new C1192hd() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo5134a() {
                SupportLifecycleFragmentImpl.this.zzpP();
                zza.dismiss();
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzpS */
    public GoogleApiAvailability zzpQ() {
        return GoogleApiAvailability.getInstance();
    }
}
