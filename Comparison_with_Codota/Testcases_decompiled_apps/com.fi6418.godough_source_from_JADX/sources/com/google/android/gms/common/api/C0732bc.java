package com.google.android.gms.common.api;

import android.content.IntentSender;
import com.google.android.gms.common.C0853e;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.bc */
class C0732bc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0730ba f4493a;

    /* renamed from: b */
    private final int f4494b;

    /* renamed from: c */
    private final ConnectionResult f4495c;

    public C0732bc(C0730ba baVar, int i, ConnectionResult connectionResult) {
        this.f4493a = baVar;
        this.f4494b = i;
        this.f4495c = connectionResult;
    }

    public void run() {
        if (this.f4493a.f4483a && !this.f4493a.f4484b) {
            boolean unused = this.f4493a.f4484b = true;
            int unused2 = this.f4493a.f4485c = this.f4494b;
            ConnectionResult unused3 = this.f4493a.f4486d = this.f4495c;
            if (this.f4495c.mo7322a()) {
                try {
                    this.f4495c.mo7321a(this.f4493a.getActivity(), ((this.f4493a.getActivity().getSupportFragmentManager().getFragments().indexOf(this.f4493a) + 1) << 16) + 1);
                } catch (IntentSender.SendIntentException e) {
                    this.f4493a.m4054l();
                }
            } else if (C0853e.m4250b(this.f4495c.mo7324c())) {
                C0853e.m4241a(this.f4495c.mo7324c(), this.f4493a.getActivity(), this.f4493a, 2, this.f4493a);
            } else {
                this.f4493a.m4046a(this.f4494b, this.f4495c);
            }
        }
    }
}
