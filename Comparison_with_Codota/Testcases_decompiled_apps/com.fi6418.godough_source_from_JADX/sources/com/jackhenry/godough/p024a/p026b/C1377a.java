package com.jackhenry.godough.p024a.p026b;

import android.view.View;
import com.jackhenry.godough.p024a.C1373a;

/* renamed from: com.jackhenry.godough.a.b.a */
public class C1377a implements View.OnClickListener {

    /* renamed from: a */
    private View.OnClickListener f5728a;

    /* renamed from: b */
    private String f5729b;

    public C1377a(View.OnClickListener onClickListener, String str) {
        this.f5728a = onClickListener;
        this.f5729b = str;
        if (this.f5729b != null) {
        }
    }

    public void onClick(View view) {
        C1373a.m5617a(this.f5729b, "ButtonPushed", this.f5729b);
        this.f5728a.onClick(view);
    }
}
