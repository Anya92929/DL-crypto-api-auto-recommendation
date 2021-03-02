package com.google.android.gms.internal;

import android.content.DialogInterface;

/* renamed from: com.google.android.gms.internal.jo */
class C1666jo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ zzhc f5182a;

    C1666jo(zzhc zzhc) {
        this.f5182a = zzhc;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5182a.zzbt("User canceled the download.");
    }
}
