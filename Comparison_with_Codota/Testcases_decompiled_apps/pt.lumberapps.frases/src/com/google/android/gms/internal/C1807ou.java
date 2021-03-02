package com.google.android.gms.internal;

import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ou */
class C1807ou extends zzb {

    /* renamed from: a */
    private final WeakReference f5456a;

    C1807ou(zzpw zzpw) {
        this.f5456a = new WeakReference(zzpw);
    }

    public void zzb(SignInResponse signInResponse) {
        zzpw zzpw = (zzpw) this.f5456a.get();
        if (zzpw != null) {
            zzpw.f6815a.mo8958a((C1818pe) new C1808ov(this, zzpw, zzpw, signInResponse));
        }
    }
}
