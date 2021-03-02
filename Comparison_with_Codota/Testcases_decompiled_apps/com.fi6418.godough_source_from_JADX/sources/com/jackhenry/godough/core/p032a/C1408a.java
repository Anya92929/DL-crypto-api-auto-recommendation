package com.jackhenry.godough.core.p032a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.jackhenry.godough.core.a.a */
public class C1408a extends Animation {

    /* renamed from: a */
    int f5790a = this.f5794e.height;

    /* renamed from: b */
    int f5791b;

    /* renamed from: c */
    boolean f5792c;

    /* renamed from: d */
    private View f5793d;

    /* renamed from: e */
    private ViewGroup.MarginLayoutParams f5794e;

    public C1408a(View view, int i, int i2) {
        setDuration((long) i);
        this.f5793d = view;
        this.f5794e = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f5791b = i2;
        view.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            this.f5794e.height = this.f5790a + ((int) (((float) (this.f5791b - this.f5790a)) * f));
            this.f5793d.requestLayout();
        } else if (!this.f5792c) {
            this.f5794e.height = this.f5791b;
            this.f5793d.requestLayout();
            this.f5792c = true;
        }
    }
}
