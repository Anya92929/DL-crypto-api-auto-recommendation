package com.jackhenry.godough.core.rda.registration;

import android.view.View;
import android.widget.CheckedTextView;

/* renamed from: com.jackhenry.godough.core.rda.registration.j */
class C1859j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckedTextView f6748a;

    /* renamed from: b */
    final /* synthetic */ int f6749b;

    /* renamed from: c */
    final /* synthetic */ C1858i f6750c;

    C1859j(C1858i iVar, CheckedTextView checkedTextView, int i) {
        this.f6750c = iVar;
        this.f6748a = checkedTextView;
        this.f6749b = i;
    }

    public void onClick(View view) {
        this.f6748a.toggle();
        this.f6750c.f6745b.set(this.f6749b, Boolean.valueOf(this.f6748a.isChecked()));
        this.f6750c.f6746c.m6773n();
    }
}
