package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.zzdq;
import java.util.List;

/* renamed from: com.google.android.gms.internal.md */
class C1736md implements zzdq.zza {

    /* renamed from: a */
    final /* synthetic */ List f5332a;

    /* renamed from: b */
    final /* synthetic */ zzdq f5333b;

    /* renamed from: c */
    final /* synthetic */ Context f5334c;

    /* renamed from: d */
    final /* synthetic */ zzkh f5335d;

    C1736md(zzkh zzkh, List list, zzdq zzdq, Context context) {
        this.f5335d = zzkh;
        this.f5332a = list;
        this.f5333b = zzdq;
        this.f5334c = context;
    }

    public void zzkn() {
        for (String str : this.f5332a) {
            String valueOf = String.valueOf(str);
            zzkd.zzcw(valueOf.length() != 0 ? "Pinging url: ".concat(valueOf) : new String("Pinging url: "));
            this.f5333b.mayLaunchUrl(Uri.parse(str), (Bundle) null, (List) null);
        }
        this.f5333b.zzd((Activity) this.f5334c);
    }

    public void zzko() {
    }
}
