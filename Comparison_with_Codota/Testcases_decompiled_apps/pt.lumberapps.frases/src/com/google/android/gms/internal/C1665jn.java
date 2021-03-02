package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.DialogInterface;

/* renamed from: com.google.android.gms.internal.jn */
class C1665jn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f5179a;

    /* renamed from: b */
    final /* synthetic */ String f5180b;

    /* renamed from: c */
    final /* synthetic */ zzhc f5181c;

    C1665jn(zzhc zzhc, String str, String str2) {
        this.f5181c = zzhc;
        this.f5179a = str;
        this.f5180b = str2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            ((DownloadManager) this.f5181c.f6322b.getSystemService("download")).enqueue(this.f5181c.mo8442a(this.f5179a, this.f5180b));
        } catch (IllegalStateException e) {
            this.f5181c.zzbt("Could not store picture.");
        }
    }
}
