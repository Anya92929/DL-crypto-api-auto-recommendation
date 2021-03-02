package com.google.android.gms.tagmanager;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.tagmanager.ba */
final class C1295ba implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences.Editor f5363a;

    C1295ba(SharedPreferences.Editor editor) {
        this.f5363a = editor;
    }

    public void run() {
        this.f5363a.commit();
    }
}
