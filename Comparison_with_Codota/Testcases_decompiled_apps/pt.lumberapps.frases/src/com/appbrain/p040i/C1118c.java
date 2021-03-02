package com.appbrain.p040i;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.appbrain.i.c */
final class C1118c extends Animation {

    /* renamed from: a */
    final /* synthetic */ View f3145a;

    /* renamed from: b */
    final /* synthetic */ int f3146b;

    /* renamed from: c */
    final /* synthetic */ C1116a f3147c;

    C1118c(C1116a aVar, View view, int i) {
        this.f3147c = aVar;
        this.f3145a = view;
        this.f3146b = i;
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        this.f3145a.setVisibility(0);
        if (f >= 1.0f) {
            this.f3145a.getLayoutParams().width = -2;
        } else {
            this.f3145a.getLayoutParams().width = Math.max(1, (int) (((float) this.f3146b) * f));
        }
        this.f3145a.requestLayout();
    }

    public final boolean willChangeBounds() {
        return true;
    }
}
