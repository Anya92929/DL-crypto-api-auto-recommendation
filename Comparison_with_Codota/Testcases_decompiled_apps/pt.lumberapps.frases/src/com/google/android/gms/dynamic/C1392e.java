package com.google.android.gms.dynamic;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* renamed from: com.google.android.gms.dynamic.e */
final class C1392e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f4771a;

    /* renamed from: b */
    final /* synthetic */ int f4772b;

    C1392e(Context context, int i) {
        this.f4771a = context;
        this.f4772b = i;
    }

    public void onClick(View view) {
        this.f4771a.startActivity(GooglePlayServicesUtil.zzfd(this.f4772b));
    }
}
