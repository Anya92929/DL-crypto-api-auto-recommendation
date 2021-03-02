package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

/* renamed from: com.google.android.gms.internal.qe */
final class C1845qe extends Drawable.ConstantState {

    /* renamed from: a */
    int f5515a;

    /* renamed from: b */
    int f5516b;

    C1845qe(C1845qe qeVar) {
        if (qeVar != null) {
            this.f5515a = qeVar.f5515a;
            this.f5516b = qeVar.f5516b;
        }
    }

    public int getChangingConfigurations() {
        return this.f5515a;
    }

    public Drawable newDrawable() {
        return new zzra(this);
    }
}
