package com.google.android.gms.p017b;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.C0853e;

/* renamed from: com.google.android.gms.b.g */
final class C0602g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3968a;

    /* renamed from: b */
    final /* synthetic */ int f3969b;

    C0602g(Context context, int i) {
        this.f3968a = context;
        this.f3969b = i;
    }

    public void onClick(View view) {
        this.f3968a.startActivity(C0853e.m4239a(this.f3969b));
    }
}
