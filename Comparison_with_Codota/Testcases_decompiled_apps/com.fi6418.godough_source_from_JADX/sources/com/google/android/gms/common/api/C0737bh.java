package com.google.android.gms.common.api;

import android.content.IntentSender;
import com.google.android.gms.common.C0853e;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.bh */
class C0737bh implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0733bd f4506a;

    /* renamed from: b */
    private final int f4507b;

    /* renamed from: c */
    private final ConnectionResult f4508c;

    public C0737bh(C0733bd bdVar, int i, ConnectionResult connectionResult) {
        this.f4506a = bdVar;
        this.f4507b = i;
        this.f4508c = connectionResult;
    }

    public void run() {
        if (this.f4508c.mo7322a()) {
            try {
                this.f4508c.mo7321a(this.f4506a.getActivity(), ((this.f4506a.getActivity().getSupportFragmentManager().getFragments().indexOf(this.f4506a) + 1) << 16) + 1);
            } catch (IntentSender.SendIntentException e) {
                this.f4506a.m4064l();
            }
        } else if (C0853e.m4250b(this.f4508c.mo7324c())) {
            C0853e.m4241a(this.f4508c.mo7324c(), this.f4506a.getActivity(), this.f4506a, 2, this.f4506a);
        } else {
            this.f4506a.m4063b(this.f4507b, this.f4508c);
        }
    }
}
