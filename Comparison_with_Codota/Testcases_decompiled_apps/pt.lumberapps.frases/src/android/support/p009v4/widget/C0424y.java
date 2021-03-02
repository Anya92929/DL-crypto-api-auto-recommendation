package android.support.p009v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.y */
public class C0424y extends ViewGroup.MarginLayoutParams {

    /* renamed from: a */
    public int f573a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float f574b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f575c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f576d;

    public C0424y(int i, int i2) {
        super(i, i2);
    }

    public C0424y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f412b);
        this.f573a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public C0424y(C0424y yVar) {
        super(yVar);
        this.f573a = yVar.f573a;
    }

    public C0424y(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0424y(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
