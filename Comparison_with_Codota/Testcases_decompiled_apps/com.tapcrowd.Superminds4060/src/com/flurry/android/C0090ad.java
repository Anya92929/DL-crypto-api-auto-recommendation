package com.flurry.android;

import android.view.View;
import android.widget.TextView;

/* renamed from: com.flurry.android.ad */
final class C0090ad implements View.OnFocusChangeListener {

    /* renamed from: a */
    private /* synthetic */ TextView f103a;

    /* renamed from: b */
    private /* synthetic */ C0089ac f104b;

    C0090ad(C0089ac acVar, TextView textView) {
        this.f104b = acVar;
        this.f103a = textView;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f103a.setText(z ? this.f104b.f102b : this.f104b.f101a);
    }
}
