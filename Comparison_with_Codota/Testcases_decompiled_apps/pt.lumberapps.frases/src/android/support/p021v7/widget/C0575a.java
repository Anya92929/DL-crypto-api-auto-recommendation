package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.p009v4.view.C0223ba;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0314ek;
import android.support.p009v4.view.C0332fb;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.widget.a */
abstract class C0575a extends ViewGroup {

    /* renamed from: a */
    protected final C0602b f1348a;

    /* renamed from: b */
    protected final Context f1349b;

    /* renamed from: c */
    protected ActionMenuView f1350c;

    /* renamed from: d */
    protected C0689k f1351d;

    /* renamed from: e */
    protected int f1352e;

    /* renamed from: f */
    protected C0314ek f1353f;

    /* renamed from: g */
    private boolean f1354g;

    /* renamed from: h */
    private boolean f1355h;

    C0575a(Context context) {
        this(context, (AttributeSet) null);
    }

    C0575a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0575a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1348a = new C0602b(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0506b.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1349b = context;
        } else {
            this.f1349b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* renamed from: a */
    protected static int m2685a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2910a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2911a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* renamed from: a */
    public C0314ek mo2639a(int i, long j) {
        if (this.f1353f != null) {
            this.f1353f.mo1559b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                C0247by.m903b((View) this, 0.0f);
            }
            C0314ek a = C0247by.m917j(this).mo1552a(1.0f);
            a.mo1553a(j);
            a.mo1554a((C0332fb) this.f1348a.mo3010a(a, i));
            return a;
        }
        C0314ek a2 = C0247by.m917j(this).mo1552a(0.0f);
        a2.mo1553a(j);
        a2.mo1554a((C0332fb) this.f1348a.mo3010a(a2, i));
        return a2;
    }

    /* renamed from: a */
    public boolean mo2641a() {
        if (this.f1351d != null) {
            return this.f1351d.mo3358d();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.f1353f != null ? this.f1348a.f1423a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1352e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, C0515k.ActionBar, C0506b.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0515k.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1351d != null) {
            this.f1351d.mo3352a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0223ba.m828a(motionEvent);
        if (a == 9) {
            this.f1355h = false;
        }
        if (!this.f1355h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1355h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1355h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0223ba.m828a(motionEvent);
        if (a == 0) {
            this.f1354g = false;
        }
        if (!this.f1354g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1354g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1354g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1352e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1353f != null) {
                this.f1353f.mo1559b();
            }
            super.setVisibility(i);
        }
    }
}
