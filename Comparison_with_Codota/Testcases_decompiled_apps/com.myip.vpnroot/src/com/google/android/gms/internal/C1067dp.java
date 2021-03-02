package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

@C1130ez
/* renamed from: com.google.android.gms.internal.dp */
public final class C1067dp extends FrameLayout implements View.OnClickListener {

    /* renamed from: nr */
    private final Activity f3200nr;

    /* renamed from: sg */
    private final ImageButton f3201sg;

    public C1067dp(Activity activity, int i) {
        super(activity);
        this.f3200nr = activity;
        setOnClickListener(this);
        this.f3201sg = new ImageButton(activity);
        this.f3201sg.setImageResource(17301527);
        this.f3201sg.setBackgroundColor(0);
        this.f3201sg.setOnClickListener(this);
        this.f3201sg.setPadding(0, 0, 0, 0);
        this.f3201sg.setContentDescription("Interstitial close button");
        int a = C1228gr.m4667a((Context) activity, i);
        addView(this.f3201sg, new FrameLayout.LayoutParams(a, a, 17));
    }

    /* renamed from: o */
    public void mo8359o(boolean z) {
        this.f3201sg.setVisibility(z ? 4 : 0);
    }

    public void onClick(View view) {
        this.f3200nr.finish();
    }
}
