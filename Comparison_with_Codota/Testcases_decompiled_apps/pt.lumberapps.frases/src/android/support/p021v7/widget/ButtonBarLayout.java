package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.p009v4.p010a.p011a.C0026a;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* renamed from: android.support.v7.widget.ButtonBarLayout */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a */
    private boolean f1245a;

    /* renamed from: b */
    private int f1246b = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = C0026a.m123a(getResources()) >= 320;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0515k.ButtonBarLayout);
        this.f1245a = obtainStyledAttributes.getBoolean(C0515k.ButtonBarLayout_allowStacking, z);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private boolean m2612a() {
        return getOrientation() == 1;
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(C0511g.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        boolean z2 = false;
        int size = View.MeasureSpec.getSize(i);
        if (this.f1245a) {
            if (size > this.f1246b && m2612a()) {
                setStacked(false);
            }
            this.f1246b = size;
        }
        if (m2612a() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f1245a && !m2612a()) {
            if (Build.VERSION.SDK_INT < 11) {
                int childCount = getChildCount();
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    i4 += getChildAt(i5).getMeasuredWidth();
                }
                if (getPaddingLeft() + i4 + getPaddingRight() > size) {
                    z2 = true;
                }
            } else if ((C0247by.m913f(this) & -16777216) == 16777216) {
                z2 = true;
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f1245a != z) {
            this.f1245a = z;
            if (!this.f1245a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
