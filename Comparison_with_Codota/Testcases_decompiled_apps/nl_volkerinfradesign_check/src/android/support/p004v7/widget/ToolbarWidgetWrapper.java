package android.support.p004v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewPropertyAnimatorCompat;
import android.support.p001v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.menu.ActionMenuItem;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.widget.Toolbar;
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

/* renamed from: android.support.v7.widget.ToolbarWidgetWrapper */
public class ToolbarWidgetWrapper implements DecorToolbar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Toolbar f2368a;

    /* renamed from: b */
    private int f2369b;

    /* renamed from: c */
    private View f2370c;

    /* renamed from: d */
    private Spinner f2371d;

    /* renamed from: e */
    private View f2372e;

    /* renamed from: f */
    private Drawable f2373f;

    /* renamed from: g */
    private Drawable f2374g;

    /* renamed from: h */
    private Drawable f2375h;

    /* renamed from: i */
    private boolean f2376i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CharSequence f2377j;

    /* renamed from: k */
    private CharSequence f2378k;

    /* renamed from: l */
    private CharSequence f2379l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Window.Callback f2380m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f2381n;

    /* renamed from: o */
    private ActionMenuPresenter f2382o;

    /* renamed from: p */
    private int f2383p;

    /* renamed from: q */
    private final TintManager f2384q;

    /* renamed from: r */
    private int f2385r;

    /* renamed from: s */
    private Drawable f2386s;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0505R.string.abc_action_bar_up_description, C0505R.C0506drawable.abc_ic_ab_back_mtrl_am_alpha);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2383p = 0;
        this.f2385r = 0;
        this.f2368a = toolbar;
        this.f2377j = toolbar.getTitle();
        this.f2378k = toolbar.getSubtitle();
        this.f2376i = this.f2377j != null;
        this.f2375h = toolbar.getNavigationIcon();
        if (z) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), (AttributeSet) null, C0505R.styleable.ActionBar, C0505R.attr.actionBarStyle, 0);
            CharSequence text = obtainStyledAttributes.getText(C0505R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(C0505R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable = obtainStyledAttributes.getDrawable(C0505R.styleable.ActionBar_logo);
            if (drawable != null) {
                setLogo(drawable);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(C0505R.styleable.ActionBar_icon);
            if (this.f2375h == null && drawable2 != null) {
                setIcon(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(C0505R.styleable.ActionBar_homeAsUpIndicator);
            if (drawable3 != null) {
                setNavigationIcon(drawable3);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(C0505R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(C0505R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.f2368a.getContext()).inflate(resourceId, this.f2368a, false));
                setDisplayOptions(this.f2369b | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0505R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2368a.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f2368a.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.f2368a.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(C0505R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                this.f2368a.setTitleTextAppearance(this.f2368a.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(C0505R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                this.f2368a.setSubtitleTextAppearance(this.f2368a.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(C0505R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.f2368a.setPopupTheme(resourceId4);
            }
            obtainStyledAttributes.recycle();
            this.f2384q = obtainStyledAttributes.getTintManager();
        } else {
            this.f2369b = m3384a();
            this.f2384q = TintManager.get(toolbar.getContext());
        }
        setDefaultNavigationContentDescription(i);
        this.f2379l = this.f2368a.getNavigationContentDescription();
        setDefaultNavigationIcon(this.f2384q.getDrawable(i2));
        this.f2368a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a */
            final ActionMenuItem f2387a = new ActionMenuItem(ToolbarWidgetWrapper.this.f2368a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f2377j);

            public void onClick(View view) {
                if (ToolbarWidgetWrapper.this.f2380m != null && ToolbarWidgetWrapper.this.f2381n) {
                    ToolbarWidgetWrapper.this.f2380m.onMenuItemSelected(0, this.f2387a);
                }
            }
        });
    }

    public void setDefaultNavigationContentDescription(int i) {
        if (i != this.f2385r) {
            this.f2385r = i;
            if (TextUtils.isEmpty(this.f2368a.getNavigationContentDescription())) {
                setNavigationContentDescription(this.f2385r);
            }
        }
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.f2386s != drawable) {
            this.f2386s = drawable;
            m3393e();
        }
    }

    /* renamed from: a */
    private int m3384a() {
        if (this.f2368a.getNavigationIcon() != null) {
            return 15;
        }
        return 11;
    }

    public ViewGroup getViewGroup() {
        return this.f2368a;
    }

    public Context getContext() {
        return this.f2368a.getContext();
    }

    public boolean hasExpandedActionView() {
        return this.f2368a.hasExpandedActionView();
    }

    public void collapseActionView() {
        this.f2368a.collapseActionView();
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f2380m = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f2376i) {
            m3386a(charSequence);
        }
    }

    public CharSequence getTitle() {
        return this.f2368a.getTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2376i = true;
        m3386a(charSequence);
    }

    /* renamed from: a */
    private void m3386a(CharSequence charSequence) {
        this.f2377j = charSequence;
        if ((this.f2369b & 8) != 0) {
            this.f2368a.setTitle(charSequence);
        }
    }

    public CharSequence getSubtitle() {
        return this.f2368a.getSubtitle();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2378k = charSequence;
        if ((this.f2369b & 8) != 0) {
            this.f2368a.setSubtitle(charSequence);
        }
    }

    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean hasIcon() {
        return this.f2373f != null;
    }

    public boolean hasLogo() {
        return this.f2374g != null;
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? this.f2384q.getDrawable(i) : null);
    }

    public void setIcon(Drawable drawable) {
        this.f2373f = drawable;
        m3388b();
    }

    public void setLogo(int i) {
        setLogo(i != 0 ? this.f2384q.getDrawable(i) : null);
    }

    public void setLogo(Drawable drawable) {
        this.f2374g = drawable;
        m3388b();
    }

    /* renamed from: b */
    private void m3388b() {
        Drawable drawable = null;
        if ((this.f2369b & 2) != 0) {
            if ((this.f2369b & 1) != 0) {
                drawable = this.f2374g != null ? this.f2374g : this.f2373f;
            } else {
                drawable = this.f2373f;
            }
        }
        this.f2368a.setLogo(drawable);
    }

    public boolean canShowOverflowMenu() {
        return this.f2368a.canShowOverflowMenu();
    }

    public boolean isOverflowMenuShowing() {
        return this.f2368a.isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowPending() {
        return this.f2368a.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        return this.f2368a.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.f2368a.hideOverflowMenu();
    }

    public void setMenuPrepared() {
        this.f2381n = true;
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.f2382o == null) {
            this.f2382o = new ActionMenuPresenter(this.f2368a.getContext());
            this.f2382o.setId(C0505R.C0507id.action_menu_presenter);
        }
        this.f2382o.setCallback(callback);
        this.f2368a.setMenu((MenuBuilder) menu, this.f2382o);
    }

    public void dismissPopupMenus() {
        this.f2368a.dismissPopupMenus();
    }

    public int getDisplayOptions() {
        return this.f2369b;
    }

    public void setDisplayOptions(int i) {
        int i2 = this.f2369b ^ i;
        this.f2369b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m3393e();
                    m3391d();
                } else {
                    this.f2368a.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                m3388b();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2368a.setTitle(this.f2377j);
                    this.f2368a.setSubtitle(this.f2378k);
                } else {
                    this.f2368a.setTitle((CharSequence) null);
                    this.f2368a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.f2372e != null) {
                if ((i & 16) != 0) {
                    this.f2368a.addView(this.f2372e);
                } else {
                    this.f2368a.removeView(this.f2372e);
                }
            }
        }
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f2370c != null && this.f2370c.getParent() == this.f2368a) {
            this.f2368a.removeView(this.f2370c);
        }
        this.f2370c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f2383p == 2) {
            this.f2368a.addView(this.f2370c, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f2370c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public boolean hasEmbeddedTabs() {
        return this.f2370c != null;
    }

    public boolean isTitleTruncated() {
        return this.f2368a.isTitleTruncated();
    }

    public void setCollapsible(boolean z) {
        this.f2368a.setCollapsible(z);
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public int getNavigationMode() {
        return this.f2383p;
    }

    public void setNavigationMode(int i) {
        int i2 = this.f2383p;
        if (i != i2) {
            switch (i2) {
                case 1:
                    if (this.f2371d != null && this.f2371d.getParent() == this.f2368a) {
                        this.f2368a.removeView(this.f2371d);
                        break;
                    }
                case 2:
                    if (this.f2370c != null && this.f2370c.getParent() == this.f2368a) {
                        this.f2368a.removeView(this.f2370c);
                        break;
                    }
            }
            this.f2383p = i;
            switch (i) {
                case 0:
                    return;
                case 1:
                    m3390c();
                    this.f2368a.addView(this.f2371d, 0);
                    return;
                case 2:
                    if (this.f2370c != null) {
                        this.f2368a.addView(this.f2370c, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f2370c.getLayoutParams();
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

    /* renamed from: c */
    private void m3390c() {
        if (this.f2371d == null) {
            this.f2371d = new AppCompatSpinner(getContext(), (AttributeSet) null, C0505R.attr.actionDropDownStyle);
            this.f2371d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        m3390c();
        this.f2371d.setAdapter(spinnerAdapter);
        this.f2371d.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i) {
        if (this.f2371d == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        this.f2371d.setSelection(i);
    }

    public int getDropdownSelectedPosition() {
        if (this.f2371d != null) {
            return this.f2371d.getSelectedItemPosition();
        }
        return 0;
    }

    public int getDropdownItemCount() {
        if (this.f2371d != null) {
            return this.f2371d.getCount();
        }
        return 0;
    }

    public void setCustomView(View view) {
        if (!(this.f2372e == null || (this.f2369b & 16) == 0)) {
            this.f2368a.removeView(this.f2372e);
        }
        this.f2372e = view;
        if (view != null && (this.f2369b & 16) != 0) {
            this.f2368a.addView(this.f2372e);
        }
    }

    public View getCustomView() {
        return this.f2372e;
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        return ViewCompat.animate(this.f2368a).alpha(i == 0 ? 1.0f : BitmapDescriptorFactory.HUE_RED).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter() {

            /* renamed from: c */
            private boolean f2391c = false;

            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.f2368a.setVisibility(0);
            }

            public void onAnimationEnd(View view) {
                if (!this.f2391c) {
                    ToolbarWidgetWrapper.this.f2368a.setVisibility(i);
                }
            }

            public void onAnimationCancel(View view) {
                this.f2391c = true;
            }
        });
    }

    public void setNavigationIcon(Drawable drawable) {
        this.f2375h = drawable;
        m3393e();
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? this.f2384q.getDrawable(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.f2379l = charSequence;
        m3391d();
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription((CharSequence) i == 0 ? null : getContext().getString(i));
    }

    /* renamed from: d */
    private void m3391d() {
        if ((this.f2369b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2379l)) {
            this.f2368a.setNavigationContentDescription(this.f2385r);
        } else {
            this.f2368a.setNavigationContentDescription(this.f2379l);
        }
    }

    /* renamed from: e */
    private void m3393e() {
        if ((this.f2369b & 4) != 0) {
            this.f2368a.setNavigationIcon(this.f2375h != null ? this.f2375h : this.f2386s);
        }
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f2368a.saveHierarchyState(sparseArray);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f2368a.restoreHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f2368a.setBackgroundDrawable(drawable);
    }

    public int getHeight() {
        return this.f2368a.getHeight();
    }

    public void setVisibility(int i) {
        this.f2368a.setVisibility(i);
    }

    public int getVisibility() {
        return this.f2368a.getVisibility();
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f2368a.setMenuCallbacks(callback, callback2);
    }

    public Menu getMenu() {
        return this.f2368a.getMenu();
    }
}
