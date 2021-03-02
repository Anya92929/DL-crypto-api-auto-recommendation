package p006nl.volkerinfradesign.checkandroid.p007ui.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.p001v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.FixedViewPager */
public class FixedViewPager extends ViewPager {

    /* renamed from: a */
    private boolean f5630a = false;

    public FixedViewPager(Context context) {
        super(context);
    }

    public FixedViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isFixed() {
        return this.f5630a;
    }

    @SuppressLint({"NewApi"})
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 14 || this.f5630a) {
            return false;
        }
        return super.onHoverEvent(motionEvent);
    }

    @SuppressLint({"NewApi"})
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 14 || this.f5630a) {
            return false;
        }
        return super.onInterceptHoverEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f5630a) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5630a) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setFixed(boolean z) {
        this.f5630a = z;
    }
}
