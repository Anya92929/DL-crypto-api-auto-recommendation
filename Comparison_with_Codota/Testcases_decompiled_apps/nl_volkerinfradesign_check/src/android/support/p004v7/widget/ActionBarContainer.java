package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.widget.ActionBarContainer */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    public Drawable f1839a;

    /* renamed from: b */
    public Drawable f1840b;

    /* renamed from: c */
    public Drawable f1841c;

    /* renamed from: d */
    public boolean f1842d;

    /* renamed from: e */
    public boolean f1843e;

    /* renamed from: f */
    private boolean f1844f;

    /* renamed from: g */
    private View f1845g;

    /* renamed from: h */
    private View f1846h;

    /* renamed from: i */
    private View f1847i;

    /* renamed from: j */
    private int f1848j;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Drawable gnVar;
        if (Build.VERSION.SDK_INT >= 21) {
            gnVar = new C1171go(this);
        } else {
            gnVar = new C1170gn(this);
        }
        setBackgroundDrawable(gnVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.ActionBar);
        this.f1839a = obtainStyledAttributes.getDrawable(C0505R.styleable.ActionBar_background);
        this.f1840b = obtainStyledAttributes.getDrawable(C0505R.styleable.ActionBar_backgroundStacked);
        this.f1848j = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.ActionBar_height, -1);
        if (getId() == C0505R.C0507id.split_action_bar) {
            this.f1842d = true;
            this.f1841c = obtainStyledAttributes.getDrawable(C0505R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        setWillNotDraw(this.f1842d ? this.f1841c == null : this.f1839a == null && this.f1840b == null);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1846h = findViewById(C0505R.C0507id.action_bar);
        this.f1847i = findViewById(C0505R.C0507id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1839a != null) {
            this.f1839a.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1839a);
        }
        this.f1839a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1846h != null) {
                this.f1839a.setBounds(this.f1846h.getLeft(), this.f1846h.getTop(), this.f1846h.getRight(), this.f1846h.getBottom());
            }
        }
        if (this.f1842d) {
            if (this.f1841c != null) {
                z = false;
            }
        } else if (!(this.f1839a == null && this.f1840b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1840b != null) {
            this.f1840b.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1840b);
        }
        this.f1840b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1843e && this.f1840b != null) {
                this.f1840b.setBounds(this.f1845g.getLeft(), this.f1845g.getTop(), this.f1845g.getRight(), this.f1845g.getBottom());
            }
        }
        if (this.f1842d) {
            if (this.f1841c != null) {
                z = false;
            }
        } else if (!(this.f1839a == null && this.f1840b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1841c != null) {
            this.f1841c.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1841c);
        }
        this.f1841c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1842d && this.f1841c != null) {
                this.f1841c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1842d) {
            if (this.f1841c != null) {
                z = false;
            }
        } else if (!(this.f1839a == null && this.f1840b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1839a != null) {
            this.f1839a.setVisible(z, false);
        }
        if (this.f1840b != null) {
            this.f1840b.setVisible(z, false);
        }
        if (this.f1841c != null) {
            this.f1841c.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1839a && !this.f1842d) || (drawable == this.f1840b && this.f1843e) || ((drawable == this.f1841c && this.f1842d) || super.verifyDrawable(drawable));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1839a != null && this.f1839a.isStateful()) {
            this.f1839a.setState(getDrawableState());
        }
        if (this.f1840b != null && this.f1840b.isStateful()) {
            this.f1840b.setState(getDrawableState());
        }
        if (this.f1841c != null && this.f1841c.isStateful()) {
            this.f1841c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1839a != null) {
                this.f1839a.jumpToCurrentState();
            }
            if (this.f1840b != null) {
                this.f1840b.jumpToCurrentState();
            }
            if (this.f1841c != null) {
                this.f1841c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f1844f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1844f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f1845g != null) {
            removeView(this.f1845g);
        }
        this.f1845g = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1845g;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public android.view.ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    /* renamed from: a */
    private boolean m3068a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: b */
    private int m3069b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        if (this.f1846h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1848j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.f1848j, View.MeasureSpec.getSize(i2)), ExploreByTouchHelper.INVALID_ID);
        }
        super.onMeasure(i, i2);
        if (this.f1846h != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.f1845g != null && this.f1845g.getVisibility() != 8 && mode != 1073741824) {
                if (!m3068a(this.f1846h)) {
                    i3 = m3069b(this.f1846h);
                } else if (!m3068a(this.f1847i)) {
                    i3 = m3069b(this.f1847i);
                } else {
                    i3 = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + m3069b(this.f1845g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1845g;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1842d) {
            if (this.f1839a != null) {
                if (this.f1846h.getVisibility() == 0) {
                    this.f1839a.setBounds(this.f1846h.getLeft(), this.f1846h.getTop(), this.f1846h.getRight(), this.f1846h.getBottom());
                } else if (this.f1847i == null || this.f1847i.getVisibility() != 0) {
                    this.f1839a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1839a.setBounds(this.f1847i.getLeft(), this.f1847i.getTop(), this.f1847i.getRight(), this.f1847i.getBottom());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.f1843e = z4;
            if (!z4 || this.f1840b == null) {
                z3 = z2;
            } else {
                this.f1840b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1841c != null) {
            this.f1841c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z3 = false;
        }
        if (z3) {
            invalidate();
        }
    }
}
