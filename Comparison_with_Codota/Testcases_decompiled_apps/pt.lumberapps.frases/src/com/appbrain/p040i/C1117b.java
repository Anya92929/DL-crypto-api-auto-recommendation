package com.appbrain.p040i;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

/* renamed from: com.appbrain.i.b */
final class C1117b extends Animation {

    /* renamed from: a */
    final /* synthetic */ View f3139a;

    /* renamed from: b */
    final /* synthetic */ int f3140b;

    /* renamed from: c */
    final /* synthetic */ int f3141c;

    /* renamed from: d */
    final /* synthetic */ int f3142d;

    /* renamed from: e */
    final /* synthetic */ int f3143e;

    /* renamed from: f */
    final /* synthetic */ C1116a f3144f;

    C1117b(C1116a aVar, View view, int i, int i2, int i3, int i4) {
        this.f3144f = aVar;
        this.f3139a = view;
        this.f3140b = i;
        this.f3141c = i2;
        this.f3142d = i3;
        this.f3143e = i4;
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3139a.getLayoutParams();
        if (f >= 1.0f) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.leftMargin = (int) (((float) this.f3140b) * (1.0f - f));
            layoutParams.rightMargin = (int) (((float) this.f3141c) * (1.0f - f));
            layoutParams.topMargin = (int) (((float) this.f3142d) * (1.0f - f));
            layoutParams.bottomMargin = (int) (((float) this.f3143e) * (1.0f - f));
        }
        this.f3139a.requestLayout();
    }

    public final boolean willChangeBounds() {
        return true;
    }
}
