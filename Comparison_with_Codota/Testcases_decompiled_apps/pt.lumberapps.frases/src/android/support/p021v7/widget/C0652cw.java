package android.support.p021v7.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p021v7.p022a.C0482d;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.view.C0520a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;

/* renamed from: android.support.v7.widget.cw */
public class C0652cw extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j */
    private static final Interpolator f1589j = new DecelerateInterpolator();

    /* renamed from: a */
    Runnable f1590a;

    /* renamed from: b */
    int f1591b;

    /* renamed from: c */
    int f1592c;

    /* renamed from: d */
    private C0655cz f1593d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0634ce f1594e;

    /* renamed from: f */
    private Spinner f1595f;

    /* renamed from: g */
    private boolean f1596g;

    /* renamed from: h */
    private int f1597h;

    /* renamed from: i */
    private int f1598i;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0657da m2963a(C0482d dVar, boolean z) {
        C0657da daVar = new C0657da(this, getContext(), dVar, z);
        if (z) {
            daVar.setBackgroundDrawable((Drawable) null);
            daVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1597h));
        } else {
            daVar.setFocusable(true);
            if (this.f1593d == null) {
                this.f1593d = new C0655cz(this, (C0653cx) null);
            }
            daVar.setOnClickListener(this.f1593d);
        }
        return daVar;
    }

    /* renamed from: a */
    private boolean m2965a() {
        return this.f1595f != null && this.f1595f.getParent() == this;
    }

    /* renamed from: b */
    private void m2966b() {
        if (!m2965a()) {
            if (this.f1595f == null) {
                this.f1595f = m2968d();
            }
            removeView(this.f1594e);
            addView(this.f1595f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1595f.getAdapter() == null) {
                this.f1595f.setAdapter(new C0654cy(this, (C0653cx) null));
            }
            if (this.f1590a != null) {
                removeCallbacks(this.f1590a);
                this.f1590a = null;
            }
            this.f1595f.setSelection(this.f1598i);
        }
    }

    /* renamed from: c */
    private boolean m2967c() {
        if (m2965a()) {
            removeView(this.f1595f);
            addView(this.f1594e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f1595f.getSelectedItemPosition());
        }
        return false;
    }

    /* renamed from: d */
    private Spinner m2968d() {
        C0610bh bhVar = new C0610bh(getContext(), (AttributeSet) null, C0506b.actionDropDownStyle);
        bhVar.setLayoutParams(new C0635cf(-2, -1));
        bhVar.setOnItemSelectedListener(this);
        return bhVar;
    }

    /* renamed from: a */
    public void mo3275a(int i) {
        View childAt = this.f1594e.getChildAt(i);
        if (this.f1590a != null) {
            removeCallbacks(this.f1590a);
        }
        this.f1590a = new C0653cx(this, childAt);
        post(this.f1590a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1590a != null) {
            post(this.f1590a);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        C0520a a = C0520a.m2179a(getContext());
        setContentHeight(a.mo2191e());
        this.f1592c = a.mo2193g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1590a != null) {
            removeCallbacks(this.f1590a);
        }
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        ((C0657da) view).mo3294b().mo2107d();
    }

    public void onMeasure(int i, int i2) {
        boolean z = true;
        int mode = View.MeasureSpec.getMode(i);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f1594e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1591b = -1;
        } else {
            if (childCount > 2) {
                this.f1591b = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f1591b = View.MeasureSpec.getSize(i) / 2;
            }
            this.f1591b = Math.min(this.f1591b, this.f1592c);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1597h, 1073741824);
        if (z2 || !this.f1596g) {
            z = false;
        }
        if (z) {
            this.f1594e.measure(0, makeMeasureSpec);
            if (this.f1594e.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m2966b();
            } else {
                m2967c();
            }
        } else {
            m2967c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1598i);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f1596g = z;
    }

    public void setContentHeight(int i) {
        this.f1597h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f1598i = i;
        int childCount = this.f1594e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1594e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                mo3275a(i);
            }
            i2++;
        }
        if (this.f1595f != null && i >= 0) {
            this.f1595f.setSelection(i);
        }
    }
}
