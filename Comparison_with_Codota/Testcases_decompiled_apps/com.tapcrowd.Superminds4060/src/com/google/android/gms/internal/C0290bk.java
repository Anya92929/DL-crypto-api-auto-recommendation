package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/* renamed from: com.google.android.gms.internal.bk */
public final class C0290bk extends FrameLayout implements View.OnClickListener {

    /* renamed from: fD */
    private final Activity f883fD;

    /* renamed from: gk */
    private final ImageButton f884gk;

    public C0290bk(Activity activity, int i) {
        super(activity);
        this.f883fD = activity;
        setOnClickListener(this);
        this.f884gk = new ImageButton(activity);
        this.f884gk.setImageResource(17301527);
        this.f884gk.setBackgroundColor(0);
        this.f884gk.setOnClickListener(this);
        this.f884gk.setPadding(0, 0, 0, 0);
        int a = C0343cm.m721a((Context) activity, i);
        addView(this.f884gk, new FrameLayout.LayoutParams(a, a, 17));
    }

    /* renamed from: d */
    public void mo4143d(boolean z) {
        this.f884gk.setVisibility(z ? 4 : 0);
    }

    public void onClick(View view) {
        this.f883fD.finish();
    }
}
