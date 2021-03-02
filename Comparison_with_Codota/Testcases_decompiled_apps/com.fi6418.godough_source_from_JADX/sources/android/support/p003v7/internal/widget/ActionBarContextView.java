package android.support.p003v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.view.ActionMode;
import android.support.p003v7.widget.ActionMenuPresenter;
import android.support.p003v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: android.support.v7.internal.widget.ActionBarContextView */
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: g */
    private CharSequence f2213g;

    /* renamed from: h */
    private CharSequence f2214h;

    /* renamed from: i */
    private View f2215i;

    /* renamed from: j */
    private View f2216j;

    /* renamed from: k */
    private LinearLayout f2217k;

    /* renamed from: l */
    private TextView f2218l;

    /* renamed from: m */
    private TextView f2219m;

    /* renamed from: n */
    private int f2220n;

    /* renamed from: o */
    private int f2221o;

    /* renamed from: p */
    private boolean f2222p;

    /* renamed from: q */
    private int f2223q;

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0235R.styleable.ActionMode, i, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.ActionMode_background));
        this.f2220n = obtainStyledAttributes.getResourceId(C0235R.styleable.ActionMode_titleTextStyle, 0);
        this.f2221o = obtainStyledAttributes.getResourceId(C0235R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f2194e = obtainStyledAttributes.getLayoutDimension(C0235R.styleable.ActionMode_height, 0);
        this.f2223q = obtainStyledAttributes.getResourceId(C0235R.styleable.ActionMode_closeItemLayout, C0235R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m1454a() {
        int i = 8;
        boolean z = true;
        if (this.f2217k == null) {
            LayoutInflater.from(getContext()).inflate(C0235R.layout.abc_action_bar_title_item, this);
            this.f2217k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2218l = (TextView) this.f2217k.findViewById(C0235R.C0237id.action_bar_title);
            this.f2219m = (TextView) this.f2217k.findViewById(C0235R.C0237id.action_bar_subtitle);
            if (this.f2220n != 0) {
                this.f2218l.setTextAppearance(getContext(), this.f2220n);
            }
            if (this.f2221o != 0) {
                this.f2219m.setTextAppearance(getContext(), this.f2221o);
            }
        }
        this.f2218l.setText(this.f2213g);
        this.f2219m.setText(this.f2214h);
        boolean z2 = !TextUtils.isEmpty(this.f2213g);
        if (TextUtils.isEmpty(this.f2214h)) {
            z = false;
        }
        this.f2219m.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = this.f2217k;
        if (z2 || z) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f2217k.getParent() == null) {
            addView(this.f2217k);
        }
    }

    public /* bridge */ /* synthetic */ void animateToVisibility(int i) {
        super.animateToVisibility(i);
    }

    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.f2215i == null) {
            killMode();
        }
    }

    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
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
        return this.f2214h;
    }

    public CharSequence getTitle() {
        return this.f2213g;
    }

    public boolean hideOverflowMenu() {
        if (this.f2193d != null) {
            return this.f2193d.hideOverflowMenu();
        }
        return false;
    }

    public void initForMode(final ActionMode actionMode) {
        if (this.f2215i == null) {
            this.f2215i = LayoutInflater.from(getContext()).inflate(this.f2223q, this, false);
            addView(this.f2215i);
        } else if (this.f2215i.getParent() == null) {
            addView(this.f2215i);
        }
        this.f2215i.findViewById(C0235R.C0237id.action_mode_close_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actionMode.finish();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        if (this.f2193d != null) {
            this.f2193d.dismissPopupMenus();
        }
        this.f2193d = new ActionMenuPresenter(getContext());
        this.f2193d.setReserveOverflow(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.f2193d, this.f2191b);
        this.f2192c = (ActionMenuView) this.f2193d.getMenuView(this);
        this.f2192c.setBackgroundDrawable((Drawable) null);
        addView(this.f2192c, layoutParams);
    }

    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        if (this.f2193d != null) {
            return this.f2193d.isOverflowMenuShowing();
        }
        return false;
    }

    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.f2222p;
    }

    public void killMode() {
        removeAllViews();
        this.f2216j = null;
        this.f2192c = null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2193d != null) {
            this.f2193d.hideOverflowMenu();
            this.f2193d.hideSubMenus();
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
            accessibilityEvent.setContentDescription(this.f2213g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingRight = isLayoutRtl ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f2215i == null || this.f2215i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2215i.getLayoutParams();
            int i6 = isLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = isLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a = m1447a(paddingRight, i6, isLayoutRtl);
            i5 = m1447a(mo4326a(this.f2215i, a, paddingTop, paddingTop2, isLayoutRtl) + a, i7, isLayoutRtl);
        }
        if (!(this.f2217k == null || this.f2216j != null || this.f2217k.getVisibility() == 8)) {
            i5 += mo4326a(this.f2217k, i5, paddingTop, paddingTop2, isLayoutRtl);
        }
        if (this.f2216j != null) {
            int a2 = mo4326a(this.f2216j, i5, paddingTop, paddingTop2, isLayoutRtl) + i5;
        }
        int paddingLeft = isLayoutRtl ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f2192c != null) {
            int a3 = mo4326a(this.f2192c, paddingLeft, paddingTop, paddingTop2, !isLayoutRtl) + paddingLeft;
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
            int size2 = this.f2194e > 0 ? this.f2194e : View.MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f2215i != null) {
                int a = mo4325a(this.f2215i, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2215i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.f2192c != null && this.f2192c.getParent() == this) {
                paddingLeft = mo4325a(this.f2192c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f2217k != null && this.f2216j == null) {
                if (this.f2222p) {
                    this.f2217k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f2217k.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f2217k.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = mo4325a(this.f2217k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f2216j != null) {
                ViewGroup.LayoutParams layoutParams = this.f2216j.getLayoutParams();
                int i6 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.f2216j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.f2194e <= 0) {
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

    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    public void setContentHeight(int i) {
        this.f2194e = i;
    }

    public void setCustomView(View view) {
        if (this.f2216j != null) {
            removeView(this.f2216j);
        }
        this.f2216j = view;
        if (!(view == null || this.f2217k == null)) {
            removeView(this.f2217k);
            this.f2217k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2214h = charSequence;
        m1454a();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2213g = charSequence;
        m1454a();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f2222p) {
            requestLayout();
        }
        this.f2222p = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        return super.setupAnimatorToVisibility(i, j);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        if (this.f2193d != null) {
            return this.f2193d.showOverflowMenu();
        }
        return false;
    }
}
