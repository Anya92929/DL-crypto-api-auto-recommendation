package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzin
/* renamed from: com.google.android.gms.internal.my */
class C1757my extends C1758mz implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a */
    private final WeakReference f5375a;

    public C1757my(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f5375a = new WeakReference(onScrollChangedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7502a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7503b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    public void onScrollChanged() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener) this.f5375a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            mo7507b();
        }
    }
}
