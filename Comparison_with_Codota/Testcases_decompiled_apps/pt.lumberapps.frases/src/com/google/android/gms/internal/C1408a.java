package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;

/* renamed from: com.google.android.gms.internal.a */
final class C1408a extends Thread {

    /* renamed from: a */
    final /* synthetic */ ContentResolver f4816a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1408a(String str, ContentResolver contentResolver) {
        super(str);
        this.f4816a = contentResolver;
    }

    public void run() {
        Looper.prepare();
        this.f4816a.registerContentObserver(zzaeo.CONTENT_URI, true, new C1435b(this, new Handler(Looper.myLooper())));
        Looper.loop();
    }
}
