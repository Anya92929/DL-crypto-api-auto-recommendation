package com.jackhenry.godough.core.alerts;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.alerts.c */
class C1500c implements C1593j {

    /* renamed from: a */
    final /* synthetic */ AlertDetailFragment f5982a;

    C1500c(AlertDetailFragment alertDetailFragment) {
        this.f5982a = alertDetailFragment;
    }

    public void run() {
        new Handler().post(new C1501d(this));
    }
}
