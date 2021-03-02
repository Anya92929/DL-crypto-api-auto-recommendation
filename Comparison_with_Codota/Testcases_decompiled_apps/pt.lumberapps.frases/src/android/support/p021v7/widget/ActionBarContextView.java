package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.view.C0314ek;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.menu.C0538ae;
import android.support.p021v7.view.menu.C0562o;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.ActionBarContextView */
public class ActionBarContextView extends C0575a {

    /* renamed from: g */
    private CharSequence f1177g;

    /* renamed from: h */
    private CharSequence f1178h;

    /* renamed from: i */
    private View f1179i;

    /* renamed from: j */
    private View f1180j;

    /* renamed from: k */
    private LinearLayout f1181k;

    /* renamed from: l */
    private TextView f1182l;

    /* renamed from: m */
    private TextView f1183m;

    /* renamed from: n */
    private int f1184n;

    /* renamed from: o */
    private int f1185o;

    /* renamed from: p */
    private boolean f1186p;

    /* renamed from: q */
    private int f1187q;

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0670dn a = C0670dn.m3014a(context, attributeSet, C0515k.ActionMode, i, 0);
        setBackgroundDrawable(a.mo3318a(C0515k.ActionMode_background));
        this.f1184n = a.mo3331g(C0515k.ActionMode_titleTextStyle, 0);
        this.f1185o = a.mo3331g(C0515k.ActionMode_subtitleTextStyle, 0);
        this.f1352e = a.mo3329f(C0515k.ActionMode_height, 0);
        this.f1187q = a.mo3331g(C0515k.ActionMode_closeItemLayout, C0512h.abc_action_mode_close_item_material);
        a.mo3319a();
    }

    /* renamed from: e */
    private void m2543e() {
        int i = 8;
        boolean z = true;
        if (this.f1181k == null) {
            LayoutInflater.from(getContext()).inflate(C0512h.abc_action_bar_title_item, this);
            this.f1181k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1182l = (TextView) this.f1181k.findViewById(C0511g.action_bar_title);
            this.f1183m = (TextView) this.f1181k.findViewById(C0511g.action_bar_subtitle);
            if (this.f1184n != 0) {
                this.f1182l.setTextAppearance(getContext(), this.f1184n);
            }
            if (this.f1185o != 0) {
                this.f1183m.setTextAppearance(getContext(), this.f1185o);
            }
        }
        this.f1182l.setText(this.f1177g);
        this.f1183m.setText(this.f1178h);
        boolean z2 = !TextUtils.isEmpty(this.f1177g);
        if (TextUtils.isEmpty(this.f1178h)) {
            z = false;
        }
        this.f1183m.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = this.f1181k;
        if (z2 || z) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f1181k.getParent() == null) {
            addView(this.f1181k);
        }
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C0314ek mo2639a(int i, long j) {
        return super.mo2639a(i, j);
    }

    /* renamed from: a */
    public void mo2640a(C0521b bVar) {
        if (this.f1179i == null) {
            this.f1179i = LayoutInflater.from(getContext()).inflate(this.f1187q, this, false);
            addView(this.f1179i);
        } else if (this.f1179i.getParent() == null) {
            addView(this.f1179i);
        }
        this.f1179i.findViewById(C0511g.action_mode_close_button).setOnClickListener(new C0683e(this, bVar));
        C0562o oVar = (C0562o) bVar.mo2093b();
        if (this.f1351d != null) {
            this.f1351d.mo3360f();
        }
        this.f1351d = new C0689k(getContext());
        this.f1351d.mo3356c(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        oVar.mo2450a((C0538ae) this.f1351d, this.f1349b);
        this.f1350c = (ActionMenuView) this.f1351d.mo2401a((ViewGroup) this);
        this.f1350c.setBackgroundDrawable((Drawable) null);
        addView(this.f1350c, layoutParams);
    }

    /* renamed from: a */
    public boolean mo2641a() {
        if (this.f1351d != null) {
            return this.f1351d.mo3358d();
        }
        return false;
    }

    /* renamed from: b */
    public void mo2642b() {
        if (this.f1179i == null) {
            mo2643c();
        }
    }

    /* renamed from: c */
    public void mo2643c() {
        removeAllViews();
        this.f1180j = null;
        this.f1350c = null;
    }

    /* renamed from: d */
    public boolean mo2644d() {
        return this.f1186p;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1178h;
    }

    public CharSequence getTitle() {
        return this.f1177g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1351d != null) {
            this.f1351d.mo3359e();
            this.f1351d.mo3361g();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1177g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = C0682dz.m3095a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1179i == null || this.f1179i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1179i.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a2 = m2685a(paddingRight, i6, a);
            i5 = m2685a(mo2911a(this.f1179i, a2, paddingTop, paddingTop2, a) + a2, i7, a);
        }
        if (!(this.f1181k == null || this.f1180j != null || this.f1181k.getVisibility() == 8)) {
            i5 += mo2911a(this.f1181k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1180j != null) {
            int a3 = mo2911a(this.f1180j, i5, paddingTop, paddingTop2, a) + i5;
        }
        int paddingLeft = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f1350c != null) {
            int a4 = mo2911a(this.f1350c, paddingLeft, paddingTop, paddingTop2, !a) + paddingLeft;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int size = View.MeasureSpec.getSize(i);
            int size2 = this.f1352e > 0 ? this.f1352e : View.MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f1179i != null) {
                int a = mo2910a(this.f1179i, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1179i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.f1350c != null && this.f1350c.getParent() == this) {
                paddingLeft = mo2910a(this.f1350c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1181k != null && this.f1180j == null) {
                if (this.f1186p) {
                    this.f1181k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f1181k.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f1181k.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = mo2910a(this.f1181k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1180j != null) {
                ViewGroup.LayoutParams layoutParams = this.f1180j.getLayoutParams();
                int i6 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.f1180j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.f1352e <= 0) {
                int childCount = getChildCount();
                int i7 = 0;
                while (i4 < childCount) {
                    int measuredHeight = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (measuredHeight <= i7) {
                        measuredHeight = i7;
                    }
                    i4++;
                    i7 = measuredHeight;
                }
                setMeasuredDimension(size, i7);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.f1352e = i;
    }

    public void setCustomView(View view) {
        if (this.f1180j != null) {
            removeView(this.f1180j);
        }
        this.f1180j = view;
        if (!(view == null || this.f1181k == null)) {
            removeView(this.f1181k);
            this.f1181k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1178h = charSequence;
        m2543e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1177g = charSequence;
        m2543e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1186p) {
            requestLayout();
        }
        this.f1186p = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
