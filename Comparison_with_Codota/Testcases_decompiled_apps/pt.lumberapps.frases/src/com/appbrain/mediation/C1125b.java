package com.appbrain.mediation;

import com.appbrain.C0982ac;

/* renamed from: com.appbrain.mediation.b */
final class C1125b implements C0982ac {

    /* renamed from: a */
    final /* synthetic */ AdmobAdapter f3160a;

    C1125b(AdmobAdapter admobAdapter) {
        this.f3160a = admobAdapter;
    }

    /* renamed from: a */
    public final void mo3911a() {
        this.f3160a.f3155c.onAdOpened();
    }

    /* renamed from: a */
    public final void mo3912a(boolean z) {
        this.f3160a.f3155c.onAdClosed();
    }

    public final void onClick() {
        this.f3160a.f3155c.onAdClicked();
    }
}
