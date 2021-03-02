package android.support.p009v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.dv */
public class C0298dv extends ViewGroup.LayoutParams {

    /* renamed from: a */
    public boolean f374a;

    /* renamed from: b */
    public int f375b;

    /* renamed from: c */
    float f376c = 0.0f;

    /* renamed from: d */
    boolean f377d;

    /* renamed from: e */
    int f378e;

    /* renamed from: f */
    int f379f;

    public C0298dv() {
        super(-1, -1);
    }

    public C0298dv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f235a);
        this.f375b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
