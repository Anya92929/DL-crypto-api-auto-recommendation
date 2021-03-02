package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.VersionUtils;
import android.support.p003v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.internal.widget.ActionBarContainer */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    Drawable f2203a;

    /* renamed from: b */
    Drawable f2204b;

    /* renamed from: c */
    Drawable f2205c;

    /* renamed from: d */
    boolean f2206d;

    /* renamed from: e */
    boolean f2207e;

    /* renamed from: f */
    private boolean f2208f;

    /* renamed from: g */
    private View f2209g;

    /* renamed from: h */
    private View f2210h;

    /* renamed from: i */
    private View f2211i;

    /* renamed from: j */
    private int f2212j;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(VersionUtils.isAtLeastL() ? new ActionBarBackgroundDrawableV21(this) : new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0235R.styleable.ActionBar);
        this.f2203a = obtainStyledAttributes.getDrawable(C0235R.styleable.ActionBar_background);
        this.f2204b = obtainStyledAttributes.getDrawable(C0235R.styleable.ActionBar_backgroundStacked);
        this.f2212j = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.ActionBar_height, -1);
        if (getId() == C0235R.C0237id.split_action_bar) {
            this.f2206d = true;
            this.f2205c = obtainStyledAttributes.getDrawable(C0235R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        setWillNotDraw(this.f2206d ? this.f2205c == null : this.f2203a == null && this.f2204b == null);
    }

    /* renamed from: a */
    private boolean m1452a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: b */
    private int m1453b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2203a != null && this.f2203a.isStateful()) {
            this.f2203a.setState(getDrawableState());
        }
        if (this.f2204b != null && this.f2204b.isStateful()) {
            this.f2204b.setState(getDrawableState());
        }
        if (this.f2205c != null && this.f2205c.isStateful()) {
            this.f2205c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f2209g;
    }

    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f2203a != null) {
                this.f2203a.jumpToCurrentState();
            }
            if (this.f2204b != null) {
                this.f2204b.jumpToCurrentState();
            }
            if (this.f2205c != null) {
                this.f2205c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2210h = findViewById(C0235R.C0237id.action_bar);
        this.f2211i = findViewById(C0235R.C0237id.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2208f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f2209g;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f2206d) {
            if (this.f2203a != null) {
                if (this.f2210h.getVisibility() == 0) {
                    this.f2203a.setBounds(this.f2210h.getLeft(), this.f2210h.getTop(), this.f2210h.getRight(), this.f2210h.getBottom());
                } else if (this.f2211i == null || this.f2211i.getVisibility() != 0) {
                    this.f2203a.setBounds(0, 0, 0, 0);
                } else {
                    this.f2203a.setBounds(this.f2211i.getLeft(), this.f2211i.getTop(), this.f2211i.getRight(), this.f2211i.getBottom());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.f2207e = z4;
            if (!z4 || this.f2204b == null) {
                z3 = z2;
            } else {
                this.f2204b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f2205c != null) {
            this.f2205c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z3 = false;
        }
        if (z3) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f2210h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f2212j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.f2212j, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f2210h != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.f2209g != null && this.f2209g.getVisibility() != 8 && mode != 1073741824) {
                setMeasuredDimension(getMeasuredWidth(), Math.min((!m1452a(this.f2210h) ? m1453b(this.f2210h) : !m1452a(this.f2211i) ? m1453b(this.f2211i) : 0) + m1453b(this.f2209g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f2203a != null) {
            this.f2203a.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f2203a);
        }
        this.f2203a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2210h != null) {
                this.f2203a.setBounds(this.f2210h.getLeft(), this.f2210h.getTop(), this.f2210h.getRight(), this.f2210h.getBottom());
            }
        }
        if (this.f2206d) {
            if (this.f2205c != null) {
                z = false;
            }
        } else if (!(this.f2203a == null && this.f2204b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f2205c != null) {
            this.f2205c.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f2205c);
        }
        this.f2205c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2206d && this.f2205c != null) {
                this.f2205c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f2206d) {
            if (this.f2205c != null) {
                z = false;
            }
        } else if (!(this.f2203a == null && this.f2204b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f2204b != null) {
            this.f2204b.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f2204b);
        }
        this.f2204b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2207e && this.f2204b != null) {
                this.f2204b.setBounds(this.f2209g.getLeft(), this.f2209g.getTop(), this.f2209g.getRight(), this.f2209g.getBottom());
            }
        }
        if (this.f2206d) {
            if (this.f2205c != null) {
                z = false;
            }
        } else if (!(this.f2203a == null && this.f2204b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f2209g != null) {
            removeView(this.f2209g);
        }
        this.f2209g = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f2208f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f2203a != null) {
            this.f2203a.setVisible(z, false);
        }
        if (this.f2204b != null) {
            this.f2204b.setVisible(z, false);
        }
        if (this.f2205c != null) {
            this.f2205c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public android.view.ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2203a && !this.f2206d) || (drawable == this.f2204b && this.f2207e) || ((drawable == this.f2205c && this.f2206d) || super.verifyDrawable(drawable));
    }
}
