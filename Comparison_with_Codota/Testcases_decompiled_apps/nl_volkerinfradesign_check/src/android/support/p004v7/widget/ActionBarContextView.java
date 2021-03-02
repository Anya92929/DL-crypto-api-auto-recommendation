package android.support.p004v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.view.ViewPropertyAnimatorCompat;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.ActionMode;
import android.support.p004v7.view.menu.MenuBuilder;
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
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: a */
    private CharSequence f1849a;

    /* renamed from: b */
    private CharSequence f1850b;

    /* renamed from: c */
    private View f1851c;

    /* renamed from: d */
    private View f1852d;

    /* renamed from: e */
    private LinearLayout f1853e;

    /* renamed from: f */
    private TextView f1854f;

    /* renamed from: g */
    private TextView f1855g;

    /* renamed from: h */
    private int f1856h;

    /* renamed from: i */
    private int f1857i;

    /* renamed from: j */
    private boolean f1858j;

    /* renamed from: k */
    private int f1859k;

    public /* bridge */ /* synthetic */ void animateToVisibility(int i) {
        super.animateToVisibility(i);
    }

    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        return super.setupAnimatorToVisibility(i, j);
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0505R.styleable.ActionMode, i, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.ActionMode_background));
        this.f1856h = obtainStyledAttributes.getResourceId(C0505R.styleable.ActionMode_titleTextStyle, 0);
        this.f1857i = obtainStyledAttributes.getResourceId(C0505R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(C0505R.styleable.ActionMode_height, 0);
        this.f1859k = obtainStyledAttributes.getResourceId(C0505R.styleable.ActionMode_closeItemLayout, C0505R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.mo3976c();
            this.mActionMenuPresenter.mo3978e();
        }
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setCustomView(View view) {
        if (this.f1852d != null) {
            removeView(this.f1852d);
        }
        this.f1852d = view;
        if (!(view == null || this.f1853e == null)) {
            removeView(this.f1853e);
            this.f1853e = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1849a = charSequence;
        m3070a();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1850b = charSequence;
        m3070a();
    }

    public CharSequence getTitle() {
        return this.f1849a;
    }

    public CharSequence getSubtitle() {
        return this.f1850b;
    }

    /* renamed from: a */
    private void m3070a() {
        int i;
        int i2 = 8;
        boolean z = true;
        if (this.f1853e == null) {
            LayoutInflater.from(getContext()).inflate(C0505R.layout.abc_action_bar_title_item, this);
            this.f1853e = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1854f = (TextView) this.f1853e.findViewById(C0505R.C0507id.action_bar_title);
            this.f1855g = (TextView) this.f1853e.findViewById(C0505R.C0507id.action_bar_subtitle);
            if (this.f1856h != 0) {
                this.f1854f.setTextAppearance(getContext(), this.f1856h);
            }
            if (this.f1857i != 0) {
                this.f1855g.setTextAppearance(getContext(), this.f1857i);
            }
        }
        this.f1854f.setText(this.f1849a);
        this.f1855g.setText(this.f1850b);
        boolean z2 = !TextUtils.isEmpty(this.f1849a);
        if (TextUtils.isEmpty(this.f1850b)) {
            z = false;
        }
        TextView textView = this.f1855g;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f1853e;
        if (z2 || z) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.f1853e.getParent() == null) {
            addView(this.f1853e);
        }
    }

    public void initForMode(final ActionMode actionMode) {
        if (this.f1851c == null) {
            this.f1851c = LayoutInflater.from(getContext()).inflate(this.f1859k, this, false);
            addView(this.f1851c);
        } else if (this.f1851c.getParent() == null) {
            addView(this.f1851c);
        }
        this.f1851c.findViewById(C0505R.C0507id.action_mode_close_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actionMode.finish();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.mo3977d();
        }
        this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter.mo3973a(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView.setBackgroundDrawable((Drawable) null);
        addView(this.mMenuView, layoutParams);
    }

    public void closeMode() {
        if (this.f1851c == null) {
            killMode();
        }
    }

    public void killMode() {
        removeAllViews();
        this.f1852d = null;
        this.mMenuView = null;
    }

    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.mo3975b();
        }
        return false;
    }

    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.mo3976c();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.mo3979f();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741824;
        int i6 = 0;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int size = View.MeasureSpec.getSize(i);
            int size2 = this.mContentHeight > 0 ? this.mContentHeight : View.MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i7 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, ExploreByTouchHelper.INVALID_ID);
            if (this.f1851c != null) {
                int measureChildView = measureChildView(this.f1851c, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1851c.getLayoutParams();
                paddingLeft = measureChildView - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.mMenuView != null && this.mMenuView.getParent() == this) {
                paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1853e != null && this.f1852d == null) {
                if (this.f1858j) {
                    this.f1853e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f1853e.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f1853e.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = measureChildView(this.f1853e, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1852d != null) {
                ViewGroup.LayoutParams layoutParams = this.f1852d.getLayoutParams();
                if (layoutParams.width != -2) {
                    i3 = 1073741824;
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i5 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i4 = Math.min(layoutParams.height, i7);
                } else {
                    i4 = i7;
                }
                this.f1852d.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), View.MeasureSpec.makeMeasureSpec(i4, i5));
            }
            if (this.mContentHeight <= 0) {
                int childCount = getChildCount();
                int i8 = 0;
                while (i6 < childCount) {
                    int measuredHeight = getChildAt(i6).getMeasuredHeight() + paddingTop;
                    if (measuredHeight <= i8) {
                        measuredHeight = i8;
                    }
                    i6++;
                    i8 = measuredHeight;
                }
                setMeasuredDimension(size, i8);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingRight = isLayoutRtl ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1851c == null || this.f1851c.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1851c.getLayoutParams();
            int i6 = isLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = isLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int next = next(paddingRight, i6, isLayoutRtl);
            i5 = next(positionChild(this.f1851c, next, paddingTop, paddingTop2, isLayoutRtl) + next, i7, isLayoutRtl);
        }
        if (!(this.f1853e == null || this.f1852d != null || this.f1853e.getVisibility() == 8)) {
            i5 += positionChild(this.f1853e, i5, paddingTop, paddingTop2, isLayoutRtl);
        }
        if (this.f1852d != null) {
            int positionChild = positionChild(this.f1852d, i5, paddingTop, paddingTop2, isLayoutRtl) + i5;
        }
        int paddingLeft = isLayoutRtl ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.mMenuView != null) {
            int positionChild2 = positionChild(this.mMenuView, paddingLeft, paddingTop, paddingTop2, !isLayoutRtl) + paddingLeft;
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1849a);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1858j) {
            requestLayout();
        }
        this.f1858j = z;
    }

    public boolean isTitleOptional() {
        return this.f1858j;
    }
}
