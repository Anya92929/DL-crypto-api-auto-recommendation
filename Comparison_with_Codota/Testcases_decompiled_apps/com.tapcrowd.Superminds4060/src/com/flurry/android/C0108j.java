package com.flurry.android;

import java.util.List;

/* renamed from: com.flurry.android.j */
final class C0108j implements Runnable {

    /* renamed from: a */
    private /* synthetic */ List f205a;

    C0108j(List list) {
        this.f205a = list;
    }

    public final void run() {
        for (C0113o a : this.f205a) {
            a.mo3323a();
        }
    }
}
