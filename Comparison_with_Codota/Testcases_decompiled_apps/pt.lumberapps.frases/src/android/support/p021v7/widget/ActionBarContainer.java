package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.widget.ActionBarContainer */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    Drawable f1167a;

    /* renamed from: b */
    Drawable f1168b;

    /* renamed from: c */
    Drawable f1169c;

    /* renamed from: d */
    boolean f1170d;

    /* renamed from: e */
    boolean f1171e;

    /* renamed from: f */
    private boolean f1172f;

    /* renamed from: g */
    private View f1173g;

    /* renamed from: h */
    private View f1174h;

    /* renamed from: i */
    private View f1175i;

    /* renamed from: j */
    private int f1176j;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(Build.VERSION.SDK_INT >= 21 ? new C0656d(this) : new C0629c(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0515k.ActionBar);
        this.f1167a = obtainStyledAttributes.getDrawable(C0515k.ActionBar_background);
        this.f1168b = obtainStyledAttributes.getDrawable(C0515k.ActionBar_backgroundStacked);
        this.f1176j = obtainStyledAttributes.getDimensionPixelSize(C0515k.ActionBar_height, -1);
        if (getId() == C0511g.split_action_bar) {
            this.f1170d = true;
            this.f1169c = obtainStyledAttributes.getDrawable(C0515k.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        setWillNotDraw(this.f1170d ? this.f1169c == null : this.f1167a == null && this.f1168b == null);
    }

    /* renamed from: a */
    private boolean m2541a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: b */
    private int m2542b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1167a != null && this.f1167a.isStateful()) {
            this.f1167a.setState(getDrawableState());
        }
        if (this.f1168b != null && this.f1168b.isStateful()) {
            this.f1168b.setState(getDrawableState());
        }
        if (this.f1169c != null && this.f1169c.isStateful()) {
            this.f1169c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1173g;
    }

    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1167a != null) {
                this.f1167a.jumpToCurrentState();
            }
            if (this.f1168b != null) {
                this.f1168b.jumpToCurrentState();
            }
            if (this.f1169c != null) {
                this.f1169c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1174h = findViewById(C0511g.action_bar);
        this.f1175i = findViewById(C0511g.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1172f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1173g;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1170d) {
            if (this.f1167a != null) {
                if (this.f1174h.getVisibility() == 0) {
                    this.f1167a.setBounds(this.f1174h.getLeft(), this.f1174h.getTop(), this.f1174h.getRight(), this.f1174h.getBottom());
                } else if (this.f1175i == null || this.f1175i.getVisibility() != 0) {
                    this.f1167a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1167a.setBounds(this.f1175i.getLeft(), this.f1175i.getTop(), this.f1175i.getRight(), this.f1175i.getBottom());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.f1171e = z4;
            if (!z4 || this.f1168b == null) {
                z3 = z2;
            } else {
                this.f1168b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1169c != null) {
            this.f1169c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z3 = false;
        }
        if (z3) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f1174h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1176j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.f1176j, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1174h != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.f1173g != null && this.f1173g.getVisibility() != 8 && mode != 1073741824) {
                setMeasuredDimension(getMeasuredWidth(), Math.min((!m2541a(this.f1174h) ? m2542b(this.f1174h) : !m2541a(this.f1175i) ? m2542b(this.f1175i) : 0) + m2542b(this.f1173g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1167a != null) {
            this.f1167a.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1167a);
        }
        this.f1167a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1174h != null) {
                this.f1167a.setBounds(this.f1174h.getLeft(), this.f1174h.getTop(), this.f1174h.getRight(), this.f1174h.getBottom());
            }
        }
        if (this.f1170d) {
            if (this.f1169c != null) {
                z = false;
            }
        } else if (!(this.f1167a == null && this.f1168b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1169c != null) {
            this.f1169c.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1169c);
        }
        this.f1169c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1170d && this.f1169c != null) {
                this.f1169c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1170d) {
            if (this.f1169c != null) {
                z = false;
            }
        } else if (!(this.f1167a == null && this.f1168b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1168b != null) {
            this.f1168b.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1168b);
        }
        this.f1168b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1171e && this.f1168b != null) {
                this.f1168b.setBounds(this.f1173g.getLeft(), this.f1173g.getTop(), this.f1173g.getRight(), this.f1173g.getBottom());
            }
        }
        if (this.f1170d) {
            if (this.f1169c != null) {
                z = false;
            }
        } else if (!(this.f1167a == null && this.f1168b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(C0652cw cwVar) {
        if (this.f1173g != null) {
            removeView(this.f1173g);
        }
        this.f1173g = cwVar;
        if (cwVar != null) {
            addView(cwVar);
            ViewGroup.LayoutParams layoutParams = cwVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            cwVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1172f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1167a != null) {
            this.f1167a.setVisible(z, false);
        }
        if (this.f1168b != null) {
            this.f1168b.setVisible(z, false);
        }
        if (this.f1169c != null) {
            this.f1169c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1167a && !this.f1170d) || (drawable == this.f1168b && this.f1171e) || ((drawable == this.f1169c && this.f1170d) || super.verifyDrawable(drawable));
    }
}
