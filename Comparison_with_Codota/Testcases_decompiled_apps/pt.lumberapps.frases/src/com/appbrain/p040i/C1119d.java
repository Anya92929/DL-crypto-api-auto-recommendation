package com.appbrain.p040i;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.appbrain.i.d */
final class C1119d extends Animation {

    /* renamed from: a */
    final /* synthetic */ View f3148a;

    /* renamed from: b */
    final /* synthetic */ int f3149b;

    /* renamed from: c */
    final /* synthetic */ C1116a f3150c;

    C1119d(C1116a aVar, View view, int i) {
        this.f3150c = aVar;
        this.f3148a = view;
        this.f3149b = i;
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        int i;
        if (f >= 1.0f || (i = (int) (((float) this.f3149b) * (1.0f - f))) == 0) {
            this.f3148a.getLayoutParams().width = -2;
            this.f3148a.setVisibility(8);
            return;
        }
        this.f3148a.getLayoutParams().width = i;
        this.f3148a.requestLayout();
    }

    public final boolean willChangeBounds() {
        return true;
    }
}
