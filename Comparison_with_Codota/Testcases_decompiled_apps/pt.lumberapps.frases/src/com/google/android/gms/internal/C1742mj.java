package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzu;

/* renamed from: com.google.android.gms.internal.mj */
class C1742mj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f5345a;

    /* renamed from: b */
    final /* synthetic */ zzkk f5346b;

    C1742mj(zzkk zzkk, String str) {
        this.f5346b = zzkk;
        this.f5345a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        zzu.zzfq().zzb(this.f5346b.f6617a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.f5345a), "Share via"));
    }
}
