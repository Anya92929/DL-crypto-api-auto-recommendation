package android.support.p003v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.ActionMenuItem;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.widget.ActionMenuPresenter;
import android.support.p003v7.widget.AppCompatSpinner;
import android.support.p003v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.internal.widget.ToolbarWidgetWrapper */
public class ToolbarWidgetWrapper implements DecorToolbar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Toolbar f2396a;

    /* renamed from: b */
    private int f2397b;

    /* renamed from: c */
    private View f2398c;

    /* renamed from: d */
    private Spinner f2399d;

    /* renamed from: e */
    private View f2400e;

    /* renamed from: f */
    private Drawable f2401f;

    /* renamed from: g */
    private Drawable f2402g;

    /* renamed from: h */
    private Drawable f2403h;

    /* renamed from: i */
    private boolean f2404i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CharSequence f2405j;

    /* renamed from: k */
    private CharSequence f2406k;

    /* renamed from: l */
    private CharSequence f2407l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Window.Callback f2408m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f2409n;

    /* renamed from: o */
    private ActionMenuPresenter f2410o;

    /* renamed from: p */
    private int f2411p;

    /* renamed from: q */
    private final TintManager f2412q;

    /* renamed from: r */
    private int f2413r;

    /* renamed from: s */
    private Drawable f2414s;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0235R.string.abc_action_bar_up_description, C0235R.C0236drawable.abc_ic_ab_back_mtrl_am_alpha);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2411p = 0;
        this.f2413r = 0;
        this.f2396a = toolbar;
        this.f2405j = toolbar.getTitle();
        this.f2406k = toolbar.getSubtitle();
        this.f2404i = this.f2405j != null;
        this.f2403h = toolbar.getNavigationIcon();
        if (z) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), (AttributeSet) null, C0235R.styleable.ActionBar, C0235R.attr.actionBarStyle, 0);
            CharSequence text = obtainStyledAttributes.getText(C0235R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(C0235R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable = obtainStyledAttributes.getDrawable(C0235R.styleable.ActionBar_logo);
            if (drawable != null) {
                setLogo(drawable);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(C0235R.styleable.ActionBar_icon);
            if (this.f2403h == null && drawable2 != null) {
                setIcon(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(C0235R.styleable.ActionBar_homeAsUpIndicator);
            if (drawable3 != null) {
                setNavigationIcon(drawable3);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(C0235R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(C0235R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.f2396a.getContext()).inflate(resourceId, this.f2396a, false));
                setDisplayOptions(this.f2397b | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0235R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2396a.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f2396a.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.f2396a.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(C0235R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                this.f2396a.setTitleTextAppearance(this.f2396a.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(C0235R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                this.f2396a.setSubtitleTextAppearance(this.f2396a.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(C0235R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.f2396a.setPopupTheme(resourceId4);
            }
            obtainStyledAttributes.recycle();
            this.f2412q = obtainStyledAttributes.getTintManager();
        } else {
            this.f2397b = m1533a();
            this.f2412q = TintManager.get(toolbar.getContext());
        }
        setDefaultNavigationContentDescription(i);
        this.f2407l = this.f2396a.getNavigationContentDescription();
        setDefaultNavigationIcon(this.f2412q.getDrawable(i2));
        this.f2396a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a */
            final ActionMenuItem f2415a = new ActionMenuItem(ToolbarWidgetWrapper.this.f2396a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f2405j);

            public void onClick(View view) {
                if (ToolbarWidgetWrapper.this.f2408m != null && ToolbarWidgetWrapper.this.f2409n) {
                    ToolbarWidgetWrapper.this.f2408m.onMenuItemSelected(0, this.f2415a);
                }
            }
        });
    }

    /* renamed from: a */
    private int m1533a() {
        return this.f2396a.getNavigationIcon() != null ? 15 : 11;
    }

    /* renamed from: a */
    private void m1535a(CharSequence charSequence) {
        this.f2405j = charSequence;
        if ((this.f2397b & 8) != 0) {
            this.f2396a.setTitle(charSequence);
        }
    }

    /* renamed from: b */
    private void m1537b() {
        Drawable drawable = null;
        if ((this.f2397b & 2) != 0) {
            drawable = (this.f2397b & 1) != 0 ? this.f2402g != null ? this.f2402g : this.f2401f : this.f2401f;
        }
        this.f2396a.setLogo(drawable);
    }

    /* renamed from: c */
    private void m1539c() {
        if (this.f2399d == null) {
            this.f2399d = new AppCompatSpinner(getContext(), (AttributeSet) null, C0235R.attr.actionDropDownStyle);
            this.f2399d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    /* renamed from: d */
    private void m1540d() {
        if ((this.f2397b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2407l)) {
            this.f2396a.setNavigationContentDescription(this.f2413r);
        } else {
            this.f2396a.setNavigationContentDescription(this.f2407l);
        }
    }

    /* renamed from: e */
    private void m1542e() {
        if ((this.f2397b & 4) != 0) {
            this.f2396a.setNavigationIcon(this.f2403h != null ? this.f2403h : this.f2414s);
        }
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    public boolean canShowOverflowMenu() {
        return this.f2396a.canShowOverflowMenu();
    }

    public void collapseActionView() {
        this.f2396a.collapseActionView();
    }

    public void dismissPopupMenus() {
        this.f2396a.dismissPopupMenus();
    }

    public Context getContext() {
        return this.f2396a.getContext();
    }

    public View getCustomView() {
        return this.f2400e;
    }

    public int getDisplayOptions() {
        return this.f2397b;
    }

    public int getDropdownItemCount() {
        if (this.f2399d != null) {
            return this.f2399d.getCount();
        }
        return 0;
    }

    public int getDropdownSelectedPosition() {
        if (this.f2399d != null) {
            return this.f2399d.getSelectedItemPosition();
        }
        return 0;
    }

    public int getHeight() {
        return this.f2396a.getHeight();
    }

    public Menu getMenu() {
        return this.f2396a.getMenu();
    }

    public int getNavigationMode() {
        return this.f2411p;
    }

    public CharSequence getSubtitle() {
        return this.f2396a.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.f2396a.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.f2396a;
    }

    public int getVisibility() {
        return this.f2396a.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        return this.f2398c != null;
    }

    public boolean hasExpandedActionView() {
        return this.f2396a.hasExpandedActionView();
    }

    public boolean hasIcon() {
        return this.f2401f != null;
    }

    public boolean hasLogo() {
        return this.f2402g != null;
    }

    public boolean hideOverflowMenu() {
        return this.f2396a.hideOverflowMenu();
    }

    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.f2396a.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.f2396a.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        return this.f2396a.isTitleTruncated();
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f2396a.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f2396a.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f2396a.setBackgroundDrawable(drawable);
    }

    public void setCollapsible(boolean z) {
        this.f2396a.setCollapsible(z);
    }

    public void setCustomView(View view) {
        if (!(this.f2400e == null || (this.f2397b & 16) == 0)) {
            this.f2396a.removeView(this.f2400e);
        }
        this.f2400e = view;
        if (view != null && (this.f2397b & 16) != 0) {
            this.f2396a.addView(this.f2400e);
        }
    }

    public void setDefaultNavigationContentDescription(int i) {
        if (i != this.f2413r) {
            this.f2413r = i;
            if (TextUtils.isEmpty(this.f2396a.getNavigationContentDescription())) {
                setNavigationContentDescription(this.f2413r);
            }
        }
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.f2414s != drawable) {
            this.f2414s = drawable;
            m1542e();
        }
    }

    public void setDisplayOptions(int i) {
        int i2 = this.f2397b ^ i;
        this.f2397b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m1542e();
                    m1540d();
                } else {
                    this.f2396a.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                m1537b();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2396a.setTitle(this.f2405j);
                    this.f2396a.setSubtitle(this.f2406k);
                } else {
                    this.f2396a.setTitle((CharSequence) null);
                    this.f2396a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.f2400e != null) {
                if ((i & 16) != 0) {
                    this.f2396a.addView(this.f2400e);
                } else {
                    this.f2396a.removeView(this.f2400e);
                }
            }
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        m1539c();
        this.f2399d.setAdapter(spinnerAdapter);
        this.f2399d.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i) {
        if (this.f2399d == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        this.f2399d.setSelection(i);
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f2398c != null && this.f2398c.getParent() == this.f2396a) {
            this.f2396a.removeView(this.f2398c);
        }
        this.f2398c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f2411p == 2) {
            this.f2396a.addView(this.f2398c, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f2398c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? this.f2412q.getDrawable(i) : null);
    }

    public void setIcon(Drawable drawable) {
        this.f2401f = drawable;
        m1537b();
    }

    public void setLogo(int i) {
        setLogo(i != 0 ? this.f2412q.getDrawable(i) : null);
    }

    public void setLogo(Drawable drawable) {
        this.f2402g = drawable;
        m1537b();
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.f2410o == null) {
            this.f2410o = new ActionMenuPresenter(this.f2396a.getContext());
            this.f2410o.setId(C0235R.C0237id.action_menu_presenter);
        }
        this.f2410o.setCallback(callback);
        this.f2396a.setMenu((MenuBuilder) menu, this.f2410o);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f2396a.setMenuCallbacks(callback, callback2);
    }

    public void setMenuPrepared() {
        this.f2409n = true;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription((CharSequence) i == 0 ? null : getContext().getString(i));
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.f2407l = charSequence;
        m1540d();
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? this.f2412q.getDrawable(i) : null);
    }

    public void setNavigationIcon(Drawable drawable) {
        this.f2403h = drawable;
        m1542e();
    }

    public void setNavigationMode(int i) {
        int i2 = this.f2411p;
        if (i != i2) {
            switch (i2) {
                case 1:
                    if (this.f2399d != null && this.f2399d.getParent() == this.f2396a) {
                        this.f2396a.removeView(this.f2399d);
                        break;
                    }
                case 2:
                    if (this.f2398c != null && this.f2398c.getParent() == this.f2396a) {
                        this.f2396a.removeView(this.f2398c);
                        break;
                    }
            }
            this.f2411p = i;
            switch (i) {
                case 0:
                    return;
                case 1:
                    m1539c();
                    this.f2396a.addView(this.f2399d, 0);
                    return;
                case 2:
                    if (this.f2398c != null) {
                        this.f2396a.addView(this.f2398c, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f2398c.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.gravity = 8388691;
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2406k = charSequence;
        if ((this.f2397b & 8) != 0) {
            this.f2396a.setSubtitle(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f2404i = true;
        m1535a(charSequence);
    }

    public void setVisibility(int i) {
        this.f2396a.setVisibility(i);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f2408m = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f2404i) {
            m1535a(charSequence);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        if (i == 8) {
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this.f2396a).alpha(BitmapDescriptorFactory.HUE_RED);
            alpha.setDuration(j);
            alpha.setListener(new ViewPropertyAnimatorListenerAdapter() {

                /* renamed from: b */
                private boolean f2418b = false;

                public void onAnimationCancel(View view) {
                    this.f2418b = true;
                }

                public void onAnimationEnd(View view) {
                    if (!this.f2418b) {
                        ToolbarWidgetWrapper.this.f2396a.setVisibility(8);
                    }
                }
            });
            return alpha;
        } else if (i != 0) {
            return null;
        } else {
            ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this.f2396a).alpha(1.0f);
            alpha2.setDuration(j);
            alpha2.setListener(new ViewPropertyAnimatorListenerAdapter() {
                public void onAnimationStart(View view) {
                    ToolbarWidgetWrapper.this.f2396a.setVisibility(0);
                }
            });
            return alpha2;
        }
    }

    public boolean showOverflowMenu() {
        return this.f2396a.showOverflowMenu();
    }
}
