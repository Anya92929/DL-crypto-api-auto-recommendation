package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;

@zzin
/* renamed from: com.google.android.gms.internal.mx */
class C1756mx extends C1758mz implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private final WeakReference f5374a;

    public C1756mx(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f5374a = new WeakReference(onGlobalLayoutListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7502a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7503b(ViewTreeObserver viewTreeObserver) {
        zzu.zzfs().zza(viewTreeObserver, (ViewTreeObserver.OnGlobalLayoutListener) this);
    }

    public void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener) this.f5374a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            mo7507b();
        }
    }
}
