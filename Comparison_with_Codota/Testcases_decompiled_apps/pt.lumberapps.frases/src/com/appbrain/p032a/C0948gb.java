package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

/* renamed from: com.appbrain.a.gb */
final class C0948gb extends ImageView {

    /* renamed from: a */
    private float f2504a;

    /* renamed from: b */
    private int f2505b;

    public C0948gb(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void mo3868a() {
        this.f2504a = 2.05f;
    }

    /* renamed from: b */
    public final void mo3869b() {
        this.f2505b = 20;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        if (this.f2504a == 0.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int i3 = (int) (((float) size) / this.f2504a);
        setMeasuredDimension(size, i3);
        int i4 = (size * this.f2505b) / 100;
        int i5 = (i3 * this.f2505b) / 100;
        setPadding(i4, i5, i4, i5);
    }
}
