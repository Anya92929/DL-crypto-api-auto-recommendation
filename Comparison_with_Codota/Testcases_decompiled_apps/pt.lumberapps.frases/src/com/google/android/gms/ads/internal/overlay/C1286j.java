package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkk;

@zzin
/* renamed from: com.google.android.gms.ads.internal.overlay.j */
class C1286j extends RelativeLayout {

    /* renamed from: a */
    zzkk f3741a;

    /* renamed from: b */
    boolean f3742b;

    public C1286j(Context context, String str) {
        super(context);
        this.f3741a = new zzkk(context, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5409a() {
        this.f3742b = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f3742b) {
            return false;
        }
        this.f3741a.zze(motionEvent);
        return false;
    }
}
