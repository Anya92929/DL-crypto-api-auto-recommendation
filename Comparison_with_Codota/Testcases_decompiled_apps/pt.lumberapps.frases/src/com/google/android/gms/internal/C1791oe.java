package com.google.android.gms.internal;

import android.content.DialogInterface;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzqe;

/* renamed from: com.google.android.gms.internal.oe */
class C1791oe implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzpn f5421a;

    private C1791oe(zzpn zzpn) {
        this.f5421a = zzpn;
    }

    public void run() {
        if (this.f5421a.f6785a) {
            if (this.f5421a.f6788e.hasResolution()) {
                this.f5421a.f6908d.startActivityForResult(GoogleApiActivity.zzb(this.f5421a.getActivity(), this.f5421a.f6788e.getResolution(), this.f5421a.f6789f, false), 1);
            } else if (this.f5421a.f6787c.isUserResolvableError(this.f5421a.f6788e.getErrorCode())) {
                this.f5421a.f6787c.zza(this.f5421a.getActivity(), this.f5421a.f6908d, this.f5421a.f6788e.getErrorCode(), 2, this.f5421a);
            } else if (this.f5421a.f6788e.getErrorCode() == 18) {
                this.f5421a.f6787c.zza(this.f5421a.getActivity().getApplicationContext(), (zzqe.zza) new C1792of(this, this.f5421a.f6787c.zza(this.f5421a.getActivity(), (DialogInterface.OnCancelListener) this.f5421a)));
            } else {
                this.f5421a.mo8901a(this.f5421a.f6788e, this.f5421a.f6789f);
            }
        }
    }
}
