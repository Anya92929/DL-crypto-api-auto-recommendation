package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: android.support.v7.widget.cf */
public class C0635cf extends ViewGroup.MarginLayoutParams {

    /* renamed from: g */
    public float f1520g;

    /* renamed from: h */
    public int f1521h;

    public C0635cf(int i, int i2) {
        super(i, i2);
        this.f1521h = -1;
        this.f1520g = 0.0f;
    }

    public C0635cf(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1521h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0515k.LinearLayoutCompat_Layout);
        this.f1520g = obtainStyledAttributes.getFloat(C0515k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
        this.f1521h = obtainStyledAttributes.getInt(C0515k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    public C0635cf(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f1521h = -1;
    }
}
