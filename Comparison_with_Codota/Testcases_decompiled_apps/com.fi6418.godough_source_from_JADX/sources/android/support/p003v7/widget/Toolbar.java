package android.support.p003v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.MarginLayoutParamsCompat;
import android.support.p000v4.view.MenuItemCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.SupportMenuInflater;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuItemImpl;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.internal.view.menu.SubMenuBuilder;
import android.support.p003v7.internal.widget.DecorToolbar;
import android.support.p003v7.internal.widget.RtlSpacingHelper;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.support.p003v7.internal.widget.ToolbarWidgetWrapper;
import android.support.p003v7.internal.widget.ViewUtils;
import android.support.p003v7.view.CollapsibleActionView;
import android.support.p003v7.widget.ActionMenuView;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.Toolbar */
public class Toolbar extends ViewGroup {

    /* renamed from: A */
    private boolean f3240A;

    /* renamed from: B */
    private final ArrayList<View> f3241B;

    /* renamed from: C */
    private final ArrayList<View> f3242C;

    /* renamed from: D */
    private final int[] f3243D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public OnMenuItemClickListener f3244E;

    /* renamed from: F */
    private final ActionMenuView.OnMenuItemClickListener f3245F;

    /* renamed from: G */
    private ToolbarWidgetWrapper f3246G;

    /* renamed from: H */
    private ActionMenuPresenter f3247H;

    /* renamed from: I */
    private ExpandedActionViewMenuPresenter f3248I;

    /* renamed from: J */
    private MenuPresenter.Callback f3249J;

    /* renamed from: K */
    private MenuBuilder.Callback f3250K;

    /* renamed from: L */
    private boolean f3251L;

    /* renamed from: M */
    private final Runnable f3252M;

    /* renamed from: N */
    private final TintManager f3253N;

    /* renamed from: a */
    View f3254a;

    /* renamed from: b */
    private ActionMenuView f3255b;

    /* renamed from: c */
    private TextView f3256c;

    /* renamed from: d */
    private TextView f3257d;

    /* renamed from: e */
    private ImageButton f3258e;

    /* renamed from: f */
    private ImageView f3259f;

    /* renamed from: g */
    private Drawable f3260g;

    /* renamed from: h */
    private CharSequence f3261h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ImageButton f3262i;

    /* renamed from: j */
    private Context f3263j;

    /* renamed from: k */
    private int f3264k;

    /* renamed from: l */
    private int f3265l;

    /* renamed from: m */
    private int f3266m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f3267n;

    /* renamed from: o */
    private int f3268o;

    /* renamed from: p */
    private int f3269p;

    /* renamed from: q */
    private int f3270q;

    /* renamed from: r */
    private int f3271r;

    /* renamed from: s */
    private int f3272s;

    /* renamed from: t */
    private final RtlSpacingHelper f3273t;

    /* renamed from: u */
    private int f3274u;

    /* renamed from: v */
    private CharSequence f3275v;

    /* renamed from: w */
    private CharSequence f3276w;

    /* renamed from: x */
    private int f3277x;

    /* renamed from: y */
    private int f3278y;

    /* renamed from: z */
    private boolean f3279z;

    /* renamed from: android.support.v7.widget.Toolbar$ExpandedActionViewMenuPresenter */
    class ExpandedActionViewMenuPresenter implements MenuPresenter {

        /* renamed from: a */
        MenuBuilder f3283a;

        /* renamed from: b */
        MenuItemImpl f3284b;

        private ExpandedActionViewMenuPresenter() {
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (Toolbar.this.f3254a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.f3254a).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.f3254a);
            Toolbar.this.removeView(Toolbar.this.f3262i);
            Toolbar.this.f3254a = null;
            Toolbar.this.mo6151c();
            this.f3284b = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.m2394h();
            if (Toolbar.this.f3262i.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.f3262i);
            }
            Toolbar.this.f3254a = menuItemImpl.getActionView();
            this.f3284b = menuItemImpl;
            if (Toolbar.this.f3254a.getParent() != Toolbar.this) {
                LayoutParams a = Toolbar.this.generateDefaultLayoutParams();
                a.gravity = 8388611 | (Toolbar.this.f3267n & 112);
                a.f3286a = 2;
                Toolbar.this.f3254a.setLayoutParams(a);
                Toolbar.this.addView(Toolbar.this.f3254a);
            }
            Toolbar.this.mo6150b();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (Toolbar.this.f3254a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.f3254a).onActionViewExpanded();
            }
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            if (!(this.f3283a == null || this.f3284b == null)) {
                this.f3283a.collapseItemActionView(this.f3284b);
            }
            this.f3283a = menuBuilder;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void setCallback(MenuPresenter.Callback callback) {
        }

        public void updateMenuView(boolean z) {
            boolean z2 = false;
            if (this.f3284b != null) {
                if (this.f3283a != null) {
                    int size = this.f3283a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f3283a.getItem(i) == this.f3284b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.f3283a, this.f3284b);
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$LayoutParams */
    public class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: a */
        int f3286a;

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3286a = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f3286a = 0;
            this.gravity = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3286a = 0;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3286a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f3286a = 0;
            this.f3286a = layoutParams.f3286a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3286a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            this.f3286a = 0;
            mo6215a(marginLayoutParams);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6215a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$OnMenuItemClickListener */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* renamed from: android.support.v7.widget.Toolbar$SavedState */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f3287a;

        /* renamed from: b */
        boolean f3288b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3287a = parcel.readInt();
            this.f3288b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3287a);
            parcel.writeInt(this.f3288b ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3273t = new RtlSpacingHelper();
        this.f3274u = 8388627;
        this.f3241B = new ArrayList<>();
        this.f3242C = new ArrayList<>();
        this.f3243D = new int[2];
        this.f3245F = new ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.f3244E != null) {
                    return Toolbar.this.f3244E.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.f3252M = new Runnable() {
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, C0235R.styleable.Toolbar, i, 0);
        this.f3265l = obtainStyledAttributes.getResourceId(C0235R.styleable.Toolbar_titleTextAppearance, 0);
        this.f3266m = obtainStyledAttributes.getResourceId(C0235R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f3274u = obtainStyledAttributes.getInteger(C0235R.styleable.Toolbar_android_gravity, this.f3274u);
        this.f3267n = 48;
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.Toolbar_titleMargins, 0);
        this.f3272s = dimensionPixelOffset;
        this.f3271r = dimensionPixelOffset;
        this.f3270q = dimensionPixelOffset;
        this.f3269p = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f3269p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f3270q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f3271r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f3272s = dimensionPixelOffset5;
        }
        this.f3268o = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f3273t.setAbsolute(obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.Toolbar_contentInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.Toolbar_contentInsetRight, 0));
        if (!(dimensionPixelOffset6 == Integer.MIN_VALUE && dimensionPixelOffset7 == Integer.MIN_VALUE)) {
            this.f3273t.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f3260g = obtainStyledAttributes.getDrawable(C0235R.styleable.Toolbar_collapseIcon);
        this.f3261h = obtainStyledAttributes.getText(C0235R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(C0235R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(C0235R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f3263j = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(C0235R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(C0235R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(C0235R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C0235R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(C0235R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (obtainStyledAttributes.hasValue(C0235R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(obtainStyledAttributes.getColor(C0235R.styleable.Toolbar_titleTextColor, -1));
        }
        if (obtainStyledAttributes.hasValue(C0235R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(obtainStyledAttributes.getColor(C0235R.styleable.Toolbar_subtitleTextColor, -1));
        }
        obtainStyledAttributes.recycle();
        this.f3253N = obtainStyledAttributes.getTintManager();
    }

    /* renamed from: a */
    private int m2372a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f3274u & 112;
        }
    }

    /* renamed from: a */
    private int m2373a(View view, int i) {
        int max;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m2372a(layoutParams.gravity)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i3 < layoutParams.topMargin) {
                    max = layoutParams.topMargin;
                } else {
                    int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    max = i4 < layoutParams.bottomMargin ? Math.max(0, i3 - (layoutParams.bottomMargin - i4)) : i3;
                }
                return max + paddingTop;
        }
    }

    /* renamed from: a */
    private int m2374a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: a */
    private int m2375a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int a = m2373a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a, max + measuredWidth, view.getMeasuredHeight() + a);
        return layoutParams.rightMargin + measuredWidth + max;
    }

    /* renamed from: a */
    private int m2376a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i7 = layoutParams.leftMargin - i6;
            int i8 = layoutParams.rightMargin - i5;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            i6 = Math.max(0, -i7);
            i5 = Math.max(0, -i8);
            i3++;
            i4 += view.getMeasuredWidth() + max + max2;
        }
        return i4;
    }

    /* renamed from: a */
    private void m2378a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: a */
    private void m2379a(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams a = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        a.f3286a = 1;
        if (!z || this.f3254a == null) {
            addView(view, a);
            return;
        }
        view.setLayoutParams(a);
        this.f3242C.add(view);
    }

    /* renamed from: a */
    private void m2380a(List<View> list, int i) {
        boolean z = true;
        if (ViewCompat.getLayoutDirection(this) != 1) {
            z = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3286a == 0 && m2381a(childAt) && m2382b(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f3286a == 0 && m2381a(childAt2) && m2382b(layoutParams2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: a */
    private boolean m2381a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: b */
    private int m2382b(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return layoutDirection == 1 ? 5 : 3;
        }
    }

    /* renamed from: b */
    private int m2383b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
    }

    /* renamed from: b */
    private int m2384b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a = m2373a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a, max, view.getMeasuredHeight() + a);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    /* renamed from: c */
    private int m2386c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    /* renamed from: d */
    private void m2389d() {
        if (this.f3259f == null) {
            this.f3259f = new ImageView(getContext());
        }
    }

    /* renamed from: d */
    private boolean m2390d(View view) {
        return view.getParent() == this || this.f3242C.contains(view);
    }

    /* renamed from: e */
    private void m2391e() {
        m2392f();
        if (this.f3255b.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f3255b.getMenu();
            if (this.f3248I == null) {
                this.f3248I = new ExpandedActionViewMenuPresenter();
            }
            this.f3255b.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.f3248I, this.f3263j);
        }
    }

    /* renamed from: f */
    private void m2392f() {
        if (this.f3255b == null) {
            this.f3255b = new ActionMenuView(getContext());
            this.f3255b.setPopupTheme(this.f3264k);
            this.f3255b.setOnMenuItemClickListener(this.f3245F);
            this.f3255b.setMenuCallbacks(this.f3249J, this.f3250K);
            LayoutParams a = generateDefaultLayoutParams();
            a.gravity = 8388613 | (this.f3267n & 112);
            this.f3255b.setLayoutParams(a);
            m2379a((View) this.f3255b, false);
        }
    }

    /* renamed from: g */
    private void m2393g() {
        if (this.f3258e == null) {
            this.f3258e = new ImageButton(getContext(), (AttributeSet) null, C0235R.attr.toolbarNavigationButtonStyle);
            LayoutParams a = generateDefaultLayoutParams();
            a.gravity = 8388611 | (this.f3267n & 112);
            this.f3258e.setLayoutParams(a);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m2394h() {
        if (this.f3262i == null) {
            this.f3262i = new ImageButton(getContext(), (AttributeSet) null, C0235R.attr.toolbarNavigationButtonStyle);
            this.f3262i.setImageDrawable(this.f3260g);
            this.f3262i.setContentDescription(this.f3261h);
            LayoutParams a = generateDefaultLayoutParams();
            a.gravity = 8388611 | (this.f3267n & 112);
            a.f3286a = 2;
            this.f3262i.setLayoutParams(a);
            this.f3262i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    /* renamed from: i */
    private void m2395i() {
        removeCallbacks(this.f3252M);
        post(this.f3252M);
    }

    /* renamed from: j */
    private boolean m2396j() {
        if (!this.f3251L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2381a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ActionBar.LayoutParams ? new LayoutParams((ActionBar.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6150b() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f3286a == 2 || childAt == this.f3255b)) {
                removeViewAt(childCount);
                this.f3242C.add(childAt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6151c() {
        for (int size = this.f3242C.size() - 1; size >= 0; size--) {
            addView(this.f3242C.get(size));
        }
        this.f3242C.clear();
    }

    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.f3255b != null && this.f3255b.isOverflowReserved();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl = this.f3248I == null ? null : this.f3248I.f3284b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        if (this.f3255b != null) {
            this.f3255b.dismissPopupMenus();
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getContentInsetEnd() {
        return this.f3273t.getEnd();
    }

    public int getContentInsetLeft() {
        return this.f3273t.getLeft();
    }

    public int getContentInsetRight() {
        return this.f3273t.getRight();
    }

    public int getContentInsetStart() {
        return this.f3273t.getStart();
    }

    public Drawable getLogo() {
        if (this.f3259f != null) {
            return this.f3259f.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        if (this.f3259f != null) {
            return this.f3259f.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m2391e();
        return this.f3255b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        if (this.f3258e != null) {
            return this.f3258e.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        if (this.f3258e != null) {
            return this.f3258e.getDrawable();
        }
        return null;
    }

    public Drawable getOverflowIcon() {
        m2391e();
        return this.f3255b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f3264k;
    }

    public CharSequence getSubtitle() {
        return this.f3276w;
    }

    public CharSequence getTitle() {
        return this.f3275v;
    }

    public DecorToolbar getWrapper() {
        if (this.f3246G == null) {
            this.f3246G = new ToolbarWidgetWrapper(this, true);
        }
        return this.f3246G;
    }

    public boolean hasExpandedActionView() {
        return (this.f3248I == null || this.f3248I.f3284b == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        return this.f3255b != null && this.f3255b.hideOverflowMenu();
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public boolean isOverflowMenuShowPending() {
        return this.f3255b != null && this.f3255b.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.f3255b != null && this.f3255b.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        Layout layout;
        if (this.f3256c == null || (layout = this.f3256c.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3252M);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.f3240A = false;
        }
        if (!this.f3240A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f3240A = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f3240A = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int max;
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i15 = width - paddingRight;
        int[] iArr = this.f3243D;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (!m2381a((View) this.f3258e)) {
            i5 = paddingLeft;
        } else if (z2) {
            i15 = m2384b(this.f3258e, i15, iArr, minimumHeight);
            i5 = paddingLeft;
        } else {
            i5 = m2375a(this.f3258e, paddingLeft, iArr, minimumHeight);
        }
        if (m2381a((View) this.f3262i)) {
            if (z2) {
                i15 = m2384b(this.f3262i, i15, iArr, minimumHeight);
            } else {
                i5 = m2375a(this.f3262i, i5, iArr, minimumHeight);
            }
        }
        if (m2381a((View) this.f3255b)) {
            if (z2) {
                i5 = m2375a(this.f3255b, i5, iArr, minimumHeight);
            } else {
                i15 = m2384b(this.f3255b, i15, iArr, minimumHeight);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i15));
        int max2 = Math.max(i5, getContentInsetLeft());
        int min = Math.min(i15, (width - paddingRight) - getContentInsetRight());
        if (m2381a(this.f3254a)) {
            if (z2) {
                min = m2384b(this.f3254a, min, iArr, minimumHeight);
            } else {
                max2 = m2375a(this.f3254a, max2, iArr, minimumHeight);
            }
        }
        if (!m2381a((View) this.f3259f)) {
            i6 = min;
            i7 = max2;
        } else if (z2) {
            i6 = m2384b(this.f3259f, min, iArr, minimumHeight);
            i7 = max2;
        } else {
            i6 = min;
            i7 = m2375a(this.f3259f, max2, iArr, minimumHeight);
        }
        boolean a = m2381a((View) this.f3256c);
        boolean a2 = m2381a((View) this.f3257d);
        int i16 = 0;
        if (a) {
            LayoutParams layoutParams = (LayoutParams) this.f3256c.getLayoutParams();
            i16 = 0 + layoutParams.bottomMargin + layoutParams.topMargin + this.f3256c.getMeasuredHeight();
        }
        if (a2) {
            LayoutParams layoutParams2 = (LayoutParams) this.f3257d.getLayoutParams();
            i8 = layoutParams2.bottomMargin + layoutParams2.topMargin + this.f3257d.getMeasuredHeight() + i16;
        } else {
            i8 = i16;
        }
        if (a || a2) {
            TextView textView = a ? this.f3256c : this.f3257d;
            TextView textView2 = a2 ? this.f3257d : this.f3256c;
            LayoutParams layoutParams3 = (LayoutParams) textView.getLayoutParams();
            LayoutParams layoutParams4 = (LayoutParams) textView2.getLayoutParams();
            boolean z3 = (a && this.f3256c.getMeasuredWidth() > 0) || (a2 && this.f3257d.getMeasuredWidth() > 0);
            switch (this.f3274u & 112) {
                case 48:
                    i9 = layoutParams3.topMargin + getPaddingTop() + this.f3271r;
                    break;
                case 80:
                    i9 = (((height - paddingBottom) - layoutParams4.bottomMargin) - this.f3272s) - i8;
                    break;
                default:
                    int i17 = (((height - paddingTop) - paddingBottom) - i8) / 2;
                    if (i17 < layoutParams3.topMargin + this.f3271r) {
                        max = layoutParams3.topMargin + this.f3271r;
                    } else {
                        int i18 = (((height - paddingBottom) - i8) - i17) - paddingTop;
                        max = i18 < layoutParams3.bottomMargin + this.f3272s ? Math.max(0, i17 - ((layoutParams4.bottomMargin + this.f3272s) - i18)) : i17;
                    }
                    i9 = paddingTop + max;
                    break;
            }
            if (z2) {
                int i19 = (z3 ? this.f3269p : 0) - iArr[1];
                int max3 = i6 - Math.max(0, i19);
                iArr[1] = Math.max(0, -i19);
                if (a) {
                    int measuredWidth = max3 - this.f3256c.getMeasuredWidth();
                    int measuredHeight = this.f3256c.getMeasuredHeight() + i9;
                    this.f3256c.layout(measuredWidth, i9, max3, measuredHeight);
                    int i20 = measuredWidth - this.f3270q;
                    i9 = measuredHeight + ((LayoutParams) this.f3256c.getLayoutParams()).bottomMargin;
                    i13 = i20;
                } else {
                    i13 = max3;
                }
                if (a2) {
                    LayoutParams layoutParams5 = (LayoutParams) this.f3257d.getLayoutParams();
                    int i21 = layoutParams5.topMargin + i9;
                    int measuredHeight2 = this.f3257d.getMeasuredHeight() + i21;
                    this.f3257d.layout(max3 - this.f3257d.getMeasuredWidth(), i21, max3, measuredHeight2);
                    int i22 = layoutParams5.bottomMargin + measuredHeight2;
                    i14 = max3 - this.f3270q;
                } else {
                    i14 = max3;
                }
                i6 = z3 ? Math.min(i13, i14) : max3;
            } else {
                int i23 = (z3 ? this.f3269p : 0) - iArr[0];
                i7 += Math.max(0, i23);
                iArr[0] = Math.max(0, -i23);
                if (a) {
                    int measuredWidth2 = this.f3256c.getMeasuredWidth() + i7;
                    int measuredHeight3 = this.f3256c.getMeasuredHeight() + i9;
                    this.f3256c.layout(i7, i9, measuredWidth2, measuredHeight3);
                    int i24 = ((LayoutParams) this.f3256c.getLayoutParams()).bottomMargin + measuredHeight3;
                    i10 = measuredWidth2 + this.f3270q;
                    i11 = i24;
                } else {
                    i10 = i7;
                    i11 = i9;
                }
                if (a2) {
                    LayoutParams layoutParams6 = (LayoutParams) this.f3257d.getLayoutParams();
                    int i25 = i11 + layoutParams6.topMargin;
                    int measuredWidth3 = this.f3257d.getMeasuredWidth() + i7;
                    int measuredHeight4 = this.f3257d.getMeasuredHeight() + i25;
                    this.f3257d.layout(i7, i25, measuredWidth3, measuredHeight4);
                    int i26 = layoutParams6.bottomMargin + measuredHeight4;
                    i12 = this.f3270q + measuredWidth3;
                } else {
                    i12 = i7;
                }
                if (z3) {
                    i7 = Math.max(i10, i12);
                }
            }
        }
        m2380a((List<View>) this.f3241B, 3);
        int size = this.f3241B.size();
        int i27 = i7;
        for (int i28 = 0; i28 < size; i28++) {
            i27 = m2375a(this.f3241B.get(i28), i27, iArr, minimumHeight);
        }
        m2380a((List<View>) this.f3241B, 5);
        int size2 = this.f3241B.size();
        for (int i29 = 0; i29 < size2; i29++) {
            i6 = m2384b(this.f3241B.get(i29), i6, iArr, minimumHeight);
        }
        m2380a((List<View>) this.f3241B, 1);
        int a3 = m2376a((List<View>) this.f3241B, iArr);
        int i30 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (a3 / 2);
        int i31 = a3 + i30;
        if (i30 < i27) {
            i30 = i27;
        } else if (i31 > i6) {
            i30 -= i31 - i6;
        }
        int size3 = this.f3241B.size();
        int i32 = i30;
        for (int i33 = 0; i33 < size3; i33++) {
            i32 = m2375a(this.f3241B.get(i33), i32, iArr, minimumHeight);
        }
        this.f3241B.clear();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f3243D;
        if (ViewUtils.isLayoutRtl(this)) {
            c = 0;
            c2 = 1;
        } else {
            c = 1;
            c2 = 0;
        }
        int i7 = 0;
        if (m2381a((View) this.f3258e)) {
            m2378a((View) this.f3258e, i, 0, i2, 0, this.f3268o);
            i7 = this.f3258e.getMeasuredWidth() + m2383b((View) this.f3258e);
            int max = Math.max(0, this.f3258e.getMeasuredHeight() + m2386c((View) this.f3258e));
            i6 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.f3258e));
            i5 = max;
        }
        if (m2381a((View) this.f3262i)) {
            m2378a((View) this.f3262i, i, 0, i2, 0, this.f3268o);
            i7 = this.f3262i.getMeasuredWidth() + m2383b((View) this.f3262i);
            i5 = Math.max(i5, this.f3262i.getMeasuredHeight() + m2386c((View) this.f3262i));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.f3262i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[c2] = Math.max(0, contentInsetStart - i7);
        int i8 = 0;
        if (m2381a((View) this.f3255b)) {
            m2378a((View) this.f3255b, i, max2, i2, 0, this.f3268o);
            i8 = this.f3255b.getMeasuredWidth() + m2383b((View) this.f3255b);
            i5 = Math.max(i5, this.f3255b.getMeasuredHeight() + m2386c((View) this.f3255b));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.f3255b));
        }
        int contentInsetEnd = getContentInsetEnd();
        int max3 = max2 + Math.max(contentInsetEnd, i8);
        iArr[c] = Math.max(0, contentInsetEnd - i8);
        if (m2381a(this.f3254a)) {
            max3 += m2374a(this.f3254a, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f3254a.getMeasuredHeight() + m2386c(this.f3254a));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.f3254a));
        }
        if (m2381a((View) this.f3259f)) {
            max3 += m2374a((View) this.f3259f, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f3259f.getMeasuredHeight() + m2386c((View) this.f3259f));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.f3259f));
        }
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = i5;
        int i11 = i6;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (((LayoutParams) childAt.getLayoutParams()).f3286a != 0) {
                i3 = i11;
                i4 = i10;
            } else if (!m2381a(childAt)) {
                i3 = i11;
                i4 = i10;
            } else {
                max3 += m2374a(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i10, childAt.getMeasuredHeight() + m2386c(childAt));
                i3 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(childAt));
                i4 = max4;
            }
            i9++;
            i11 = i3;
            i10 = i4;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = this.f3271r + this.f3272s;
        int i15 = this.f3269p + this.f3270q;
        if (m2381a((View) this.f3256c)) {
            m2374a((View) this.f3256c, i, max3 + i15, i2, i14, iArr);
            i12 = m2383b((View) this.f3256c) + this.f3256c.getMeasuredWidth();
            i13 = this.f3256c.getMeasuredHeight() + m2386c((View) this.f3256c);
            i11 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(this.f3256c));
        }
        if (m2381a((View) this.f3257d)) {
            i12 = Math.max(i12, m2374a((View) this.f3257d, i, max3 + i15, i2, i14 + i13, iArr));
            i13 += this.f3257d.getMeasuredHeight() + m2386c((View) this.f3257d);
            i11 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(this.f3257d));
        }
        int max5 = Math.max(i10, i13);
        int paddingLeft = i12 + max3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max5 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i11);
        int resolveSizeAndState2 = ViewCompat.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i11 << 16);
        if (m2396j()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        MenuBuilder peekMenu = this.f3255b != null ? this.f3255b.peekMenu() : null;
        if (!(savedState.f3287a == 0 || this.f3248I == null || peekMenu == null || (findItem = peekMenu.findItem(savedState.f3287a)) == null)) {
            MenuItemCompat.expandActionView(findItem);
        }
        if (savedState.f3288b) {
            m2395i();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        RtlSpacingHelper rtlSpacingHelper = this.f3273t;
        if (i != 1) {
            z = false;
        }
        rtlSpacingHelper.setDirection(z);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f3248I == null || this.f3248I.f3284b == null)) {
            savedState.f3287a = this.f3248I.f3284b.getItemId();
        }
        savedState.f3288b = isOverflowMenuShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f3279z = false;
        }
        if (!this.f3279z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f3279z = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3279z = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f3251L = z;
        requestLayout();
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        this.f3273t.setAbsolute(i, i2);
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.f3273t.setRelative(i, i2);
    }

    public void setLogo(int i) {
        setLogo(this.f3253N.getDrawable(i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m2389d();
            if (!m2390d((View) this.f3259f)) {
                m2379a((View) this.f3259f, true);
            }
        } else if (this.f3259f != null && m2390d((View) this.f3259f)) {
            removeView(this.f3259f);
            this.f3242C.remove(this.f3259f);
        }
        if (this.f3259f != null) {
            this.f3259f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2389d();
        }
        if (this.f3259f != null) {
            this.f3259f.setContentDescription(charSequence);
        }
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.f3255b != null) {
            m2392f();
            MenuBuilder peekMenu = this.f3255b.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.f3247H);
                    peekMenu.removeMenuPresenter(this.f3248I);
                }
                if (this.f3248I == null) {
                    this.f3248I = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.f3263j);
                    menuBuilder.addMenuPresenter(this.f3248I, this.f3263j);
                } else {
                    actionMenuPresenter.initForMenu(this.f3263j, (MenuBuilder) null);
                    this.f3248I.initForMenu(this.f3263j, (MenuBuilder) null);
                    actionMenuPresenter.updateMenuView(true);
                    this.f3248I.updateMenuView(true);
                }
                this.f3255b.setPopupTheme(this.f3264k);
                this.f3255b.setPresenter(actionMenuPresenter);
                this.f3247H = actionMenuPresenter;
            }
        }
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f3249J = callback;
        this.f3250K = callback2;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2393g();
        }
        if (this.f3258e != null) {
            this.f3258e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f3253N.getDrawable(i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m2393g();
            if (!m2390d((View) this.f3258e)) {
                m2379a((View) this.f3258e, true);
            }
        } else if (this.f3258e != null && m2390d((View) this.f3258e)) {
            removeView(this.f3258e);
            this.f3242C.remove(this.f3258e);
        }
        if (this.f3258e != null) {
            this.f3258e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m2393g();
        this.f3258e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f3244E = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        m2391e();
        this.f3255b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f3264k != i) {
            this.f3264k = i;
            if (i == 0) {
                this.f3263j = getContext();
            } else {
                this.f3263j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f3257d == null) {
                Context context = getContext();
                this.f3257d = new TextView(context);
                this.f3257d.setSingleLine();
                this.f3257d.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f3266m != 0) {
                    this.f3257d.setTextAppearance(context, this.f3266m);
                }
                if (this.f3278y != 0) {
                    this.f3257d.setTextColor(this.f3278y);
                }
            }
            if (!m2390d((View) this.f3257d)) {
                m2379a((View) this.f3257d, true);
            }
        } else if (this.f3257d != null && m2390d((View) this.f3257d)) {
            removeView(this.f3257d);
            this.f3242C.remove(this.f3257d);
        }
        if (this.f3257d != null) {
            this.f3257d.setText(charSequence);
        }
        this.f3276w = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.f3266m = i;
        if (this.f3257d != null) {
            this.f3257d.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f3278y = i;
        if (this.f3257d != null) {
            this.f3257d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f3256c == null) {
                Context context = getContext();
                this.f3256c = new TextView(context);
                this.f3256c.setSingleLine();
                this.f3256c.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f3265l != 0) {
                    this.f3256c.setTextAppearance(context, this.f3265l);
                }
                if (this.f3277x != 0) {
                    this.f3256c.setTextColor(this.f3277x);
                }
            }
            if (!m2390d((View) this.f3256c)) {
                m2379a((View) this.f3256c, true);
            }
        } else if (this.f3256c != null && m2390d((View) this.f3256c)) {
            removeView(this.f3256c);
            this.f3242C.remove(this.f3256c);
        }
        if (this.f3256c != null) {
            this.f3256c.setText(charSequence);
        }
        this.f3275v = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.f3265l = i;
        if (this.f3256c != null) {
            this.f3256c.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.f3277x = i;
        if (this.f3256c != null) {
            this.f3256c.setTextColor(i);
        }
    }

    public boolean showOverflowMenu() {
        return this.f3255b != null && this.f3255b.showOverflowMenu();
    }
}
