package com.appbrain.p032a;

import android.content.Context;

/* renamed from: com.appbrain.a.do */
final class C0880do implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f2342a;

    C0880do(Context context) {
        this.f2342a = context;
    }

    public final void run() {
        try {
            C0879dn.m3815b(this.f2342a);
        } finally {
            C0879dn.f2340c.set(false);
        }
    }
}
