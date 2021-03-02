package com.google.android.gms.internal;

import android.content.DialogInterface;

/* renamed from: com.google.android.gms.internal.jl */
class C1663jl implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ zzgz f5177a;

    C1663jl(zzgz zzgz) {
        this.f5177a = zzgz;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5177a.zzbt("Operation denied by user.");
    }
}
