package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0007h;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/* renamed from: android.support.design.widget.e */
public class C0057e extends LinearLayout.LayoutParams {

    /* renamed from: a */
    int f198a = 1;

    /* renamed from: b */
    Interpolator f199b;

    public C0057e(int i, int i2) {
        super(i, i2);
    }

    public C0057e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0007h.AppBarLayout_LayoutParams);
        this.f198a = obtainStyledAttributes.getInt(C0007h.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
        if (obtainStyledAttributes.hasValue(C0007h.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
            this.f199b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0007h.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public C0057e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0057e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public C0057e(LinearLayout.LayoutParams layoutParams) {
        super(layoutParams);
    }

    /* renamed from: a */
    public int mo265a() {
        return this.f198a;
    }

    /* renamed from: b */
    public Interpolator mo266b() {
        return this.f199b;
    }
}
