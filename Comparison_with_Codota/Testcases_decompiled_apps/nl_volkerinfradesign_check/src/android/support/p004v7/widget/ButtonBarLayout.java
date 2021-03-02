package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.support.p004v7.appcompat.C0505R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* renamed from: android.support.v7.widget.ButtonBarLayout */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a */
    private boolean f2064a;

    /* renamed from: b */
    private int f2065b = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.ButtonBarLayout);
        this.f2064a = obtainStyledAttributes.getBoolean(C0505R.styleable.ButtonBarLayout_allowStacking, false);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f2064a != z) {
            this.f2064a = z;
            if (!this.f2064a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int size = View.MeasureSpec.getSize(i);
        if (this.f2064a) {
            if (size > this.f2065b && m3200a()) {
                setStacked(false);
            }
            this.f2065b = size;
        }
        if (m3200a() || View.MeasureSpec.getMode(i) != 1073741824) {
            z = false;
            i3 = i;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f2064a && !m3200a() && (getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) == 16777216) {
            setStacked(true);
            z = true;
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(C0505R.C0507id.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* renamed from: a */
    private boolean m3200a() {
        return getOrientation() == 1;
    }
}
