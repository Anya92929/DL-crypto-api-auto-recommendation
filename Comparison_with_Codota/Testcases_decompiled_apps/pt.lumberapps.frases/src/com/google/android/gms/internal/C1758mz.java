package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzin
/* renamed from: com.google.android.gms.internal.mz */
abstract class C1758mz {

    /* renamed from: a */
    private final WeakReference f5376a;

    public C1758mz(View view) {
        this.f5376a = new WeakReference(view);
    }

    /* renamed from: a */
    public final void mo7506a() {
        ViewTreeObserver c = mo7508c();
        if (c != null) {
            mo7502a(c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7502a(ViewTreeObserver viewTreeObserver);

    /* renamed from: b */
    public final void mo7507b() {
        ViewTreeObserver c = mo7508c();
        if (c != null) {
            mo7503b(c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo7503b(ViewTreeObserver viewTreeObserver);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ViewTreeObserver mo7508c() {
        View view = (View) this.f5376a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }
}
