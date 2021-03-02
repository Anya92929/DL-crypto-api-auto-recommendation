package com.appbrain.p032a;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/* renamed from: com.appbrain.a.bc */
final class C0814bc implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ TextView f2147a;

    /* renamed from: b */
    final /* synthetic */ C0809ay f2148b;

    C0814bc(C0809ay ayVar, TextView textView) {
        this.f2148b = ayVar;
        this.f2147a = textView;
    }

    public final void onGlobalLayout() {
        Rect rect = new Rect();
        if (this.f2147a.getGlobalVisibleRect(rect, new Point())) {
            C0809ay.m3634a(this.f2148b, rect.centerX(), rect.centerY());
        }
    }
}
