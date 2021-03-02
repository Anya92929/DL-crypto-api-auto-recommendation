package android.support.p021v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.p009v4.view.C0223ba;
import android.support.p009v4.view.C0314ek;
import android.support.p009v4.widget.C0370am;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: android.support.v7.widget.bw */
class C0625bw extends C0645cp {

    /* renamed from: g */
    private boolean f1487g;

    /* renamed from: h */
    private boolean f1488h;

    /* renamed from: i */
    private boolean f1489i;

    /* renamed from: j */
    private C0314ek f1490j;

    /* renamed from: k */
    private C0370am f1491k;

    public C0625bw(Context context, boolean z) {
        super(context, (AttributeSet) null, C0506b.dropDownListViewStyle);
        this.f1488h = z;
        setCacheColorHint(0);
    }

    /* renamed from: a */
    private void m2857a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* renamed from: a */
    private void m2858a(View view, int i, float f, float f2) {
        View childAt;
        this.f1489i = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (!(this.f1570f == -1 || (childAt = getChildAt(this.f1570f - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1570f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        mo3206a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* renamed from: d */
    private void m2859d() {
        this.f1489i = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1570f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f1490j != null) {
            this.f1490j.mo1559b();
            this.f1490j = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo3114a() {
        return this.f1489i || super.mo3114a();
    }

    /* renamed from: a */
    public boolean mo3115a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        int a = C0223ba.m828a(motionEvent);
        switch (a) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z3 = false;
                z2 = false;
                break;
            default:
                z3 = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z3 = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            int y = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, y);
            if (pointToPosition == -1) {
                z2 = z;
                z3 = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m2858a(childAt, pointToPosition, (float) x, (float) y);
                if (a == 1) {
                    m2857a(childAt, pointToPosition);
                }
                z3 = false;
                z2 = true;
            }
        }
        if (!z2 || z3) {
            m2859d();
        }
        if (z2) {
            if (this.f1491k == null) {
                this.f1491k = new C0370am(this);
            }
            this.f1491k.mo1753a(true);
            this.f1491k.onTouch(this, motionEvent);
        } else if (this.f1491k != null) {
            this.f1491k.mo1753a(false);
        }
        return z2;
    }

    public boolean hasFocus() {
        return this.f1488h || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f1488h || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1488h || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f1488h && this.f1487g) || super.isInTouchMode();
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.f1487g = z;
    }
}
