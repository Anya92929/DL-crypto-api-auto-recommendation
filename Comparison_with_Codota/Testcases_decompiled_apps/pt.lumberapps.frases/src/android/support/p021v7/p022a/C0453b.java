package android.support.p021v7.p022a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: android.support.v7.a.b */
public class C0453b extends ViewGroup.MarginLayoutParams {

    /* renamed from: a */
    public int f643a;

    public C0453b(int i, int i2) {
        super(i, i2);
        this.f643a = 0;
        this.f643a = 8388627;
    }

    public C0453b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f643a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0515k.ActionBarLayout);
        this.f643a = obtainStyledAttributes.getInt(C0515k.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
    }

    public C0453b(C0453b bVar) {
        super(bVar);
        this.f643a = 0;
        this.f643a = bVar.f643a;
    }

    public C0453b(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f643a = 0;
    }
}
