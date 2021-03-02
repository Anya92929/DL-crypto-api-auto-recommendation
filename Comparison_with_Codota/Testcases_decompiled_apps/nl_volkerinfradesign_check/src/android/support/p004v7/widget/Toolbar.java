package android.support.p004v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.p001v4.view.GravityCompat;
import android.support.p001v4.view.MarginLayoutParamsCompat;
import android.support.p001v4.view.MenuItemCompat;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.support.p004v7.app.ActionBar;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.CollapsibleActionView;
import android.support.p004v7.view.SupportMenuInflater;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuItemImpl;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.view.menu.MenuView;
import android.support.p004v7.view.menu.SubMenuBuilder;
import android.support.p004v7.widget.ActionMenuView;
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
    private boolean f2319A;

    /* renamed from: B */
    private final ArrayList<View> f2320B;

    /* renamed from: C */
    private final ArrayList<View> f2321C;

    /* renamed from: D */
    private final int[] f2322D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public OnMenuItemClickListener f2323E;

    /* renamed from: F */
    private final ActionMenuView.OnMenuItemClickListener f2324F;

    /* renamed from: G */
    private ToolbarWidgetWrapper f2325G;

    /* renamed from: H */
    private ActionMenuPresenter f2326H;

    /* renamed from: I */
    private C0593a f2327I;

    /* renamed from: J */
    private MenuPresenter.Callback f2328J;

    /* renamed from: K */
    private MenuBuilder.Callback f2329K;

    /* renamed from: L */
    private boolean f2330L;

    /* renamed from: M */
    private final Runnable f2331M;

    /* renamed from: N */
    private final TintManager f2332N;

    /* renamed from: a */
    View f2333a;

    /* renamed from: b */
    private ActionMenuView f2334b;

    /* renamed from: c */
    private TextView f2335c;

    /* renamed from: d */
    private TextView f2336d;

    /* renamed from: e */
    private ImageButton f2337e;

    /* renamed from: f */
    private ImageView f2338f;

    /* renamed from: g */
    private Drawable f2339g;

    /* renamed from: h */
    private CharSequence f2340h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ImageButton f2341i;

    /* renamed from: j */
    private Context f2342j;

    /* renamed from: k */
    private int f2343k;

    /* renamed from: l */
    private int f2344l;

    /* renamed from: m */
    private int f2345m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f2346n;

    /* renamed from: o */
    private int f2347o;

    /* renamed from: p */
    private int f2348p;

    /* renamed from: q */
    private int f2349q;

    /* renamed from: r */
    private int f2350r;

    /* renamed from: s */
    private int f2351s;

    /* renamed from: t */
    private final C1181gy f2352t;

    /* renamed from: u */
    private int f2353u;

    /* renamed from: v */
    private CharSequence f2354v;

    /* renamed from: w */
    private CharSequence f2355w;

    /* renamed from: x */
    private int f2356x;

    /* renamed from: y */
    private int f2357y;

    /* renamed from: z */
    private boolean f2358z;

    /* renamed from: android.support.v7.widget.Toolbar$OnMenuItemClickListener */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2352t = new C1181gy();
        this.f2353u = 8388627;
        this.f2320B = new ArrayList<>();
        this.f2321C = new ArrayList<>();
        this.f2322D = new int[2];
        this.f2324F = new ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.f2323E != null) {
                    return Toolbar.this.f2323E.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.f2331M = new Runnable() {
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, C0505R.styleable.Toolbar, i, 0);
        this.f2344l = obtainStyledAttributes.getResourceId(C0505R.styleable.Toolbar_titleTextAppearance, 0);
        this.f2345m = obtainStyledAttributes.getResourceId(C0505R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f2353u = obtainStyledAttributes.getInteger(C0505R.styleable.Toolbar_android_gravity, this.f2353u);
        this.f2346n = 48;
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.Toolbar_titleMargins, 0);
        this.f2351s = dimensionPixelOffset;
        this.f2350r = dimensionPixelOffset;
        this.f2349q = dimensionPixelOffset;
        this.f2348p = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f2348p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f2349q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f2350r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f2351s = dimensionPixelOffset5;
        }
        this.f2347o = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.Toolbar_contentInsetStart, ExploreByTouchHelper.INVALID_ID);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.Toolbar_contentInsetEnd, ExploreByTouchHelper.INVALID_ID);
        this.f2352t.mo8255b(obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.Toolbar_contentInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.Toolbar_contentInsetRight, 0));
        if (!(dimensionPixelOffset6 == Integer.MIN_VALUE && dimensionPixelOffset7 == Integer.MIN_VALUE)) {
            this.f2352t.mo8252a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f2339g = obtainStyledAttributes.getDrawable(C0505R.styleable.Toolbar_collapseIcon);
        this.f2340h = obtainStyledAttributes.getText(C0505R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(C0505R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(C0505R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f2342j = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(C0505R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(C0505R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(C0505R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C0505R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(C0505R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (obtainStyledAttributes.hasValue(C0505R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(obtainStyledAttributes.getColor(C0505R.styleable.Toolbar_titleTextColor, -1));
        }
        if (obtainStyledAttributes.hasValue(C0505R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(obtainStyledAttributes.getColor(C0505R.styleable.Toolbar_subtitleTextColor, -1));
        }
        obtainStyledAttributes.recycle();
        this.f2332N = obtainStyledAttributes.getTintManager();
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.f2343k != i) {
            this.f2343k = i;
            if (i == 0) {
                this.f2342j = getContext();
            } else {
                this.f2342j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f2343k;
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        C1181gy gyVar = this.f2352t;
        if (i != 1) {
            z = false;
        }
        gyVar.mo8253a(z);
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(this.f2332N.getDrawable(i));
    }

    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.f2334b != null && this.f2334b.isOverflowReserved();
    }

    public boolean isOverflowMenuShowing() {
        return this.f2334b != null && this.f2334b.isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowPending() {
        return this.f2334b != null && this.f2334b.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        return this.f2334b != null && this.f2334b.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.f2334b != null && this.f2334b.hideOverflowMenu();
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.f2334b != null) {
            m3374e();
            MenuBuilder peekMenu = this.f2334b.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.f2326H);
                    peekMenu.removeMenuPresenter(this.f2327I);
                }
                if (this.f2327I == null) {
                    this.f2327I = new C0593a();
                }
                actionMenuPresenter.mo3974b(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.f2342j);
                    menuBuilder.addMenuPresenter(this.f2327I, this.f2342j);
                } else {
                    actionMenuPresenter.initForMenu(this.f2342j, (MenuBuilder) null);
                    this.f2327I.initForMenu(this.f2342j, (MenuBuilder) null);
                    actionMenuPresenter.updateMenuView(true);
                    this.f2327I.updateMenuView(true);
                }
                this.f2334b.setPopupTheme(this.f2343k);
                this.f2334b.setPresenter(actionMenuPresenter);
                this.f2326H = actionMenuPresenter;
            }
        }
    }

    public void dismissPopupMenus() {
        if (this.f2334b != null) {
            this.f2334b.dismissPopupMenus();
        }
    }

    public boolean isTitleTruncated() {
        Layout layout;
        if (this.f2335c == null || (layout = this.f2335c.getLayout()) == null) {
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

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m3370c();
            if (!m3373d((View) this.f2338f)) {
                m3361a((View) this.f2338f, true);
            }
        } else if (this.f2338f != null && m3373d((View) this.f2338f)) {
            removeView(this.f2338f);
            this.f2321C.remove(this.f2338f);
        }
        if (this.f2338f != null) {
            this.f2338f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.f2338f != null) {
            return this.f2338f.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m3370c();
        }
        if (this.f2338f != null) {
            this.f2338f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.f2338f != null) {
            return this.f2338f.getContentDescription();
        }
        return null;
    }

    /* renamed from: c */
    private void m3370c() {
        if (this.f2338f == null) {
            this.f2338f = new ImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        return (this.f2327I == null || this.f2327I.f2366b == null) ? false : true;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl = this.f2327I == null ? null : this.f2327I.f2366b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f2354v;
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2335c == null) {
                Context context = getContext();
                this.f2335c = new TextView(context);
                this.f2335c.setSingleLine();
                this.f2335c.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f2344l != 0) {
                    this.f2335c.setTextAppearance(context, this.f2344l);
                }
                if (this.f2356x != 0) {
                    this.f2335c.setTextColor(this.f2356x);
                }
            }
            if (!m3373d((View) this.f2335c)) {
                m3361a((View) this.f2335c, true);
            }
        } else if (this.f2335c != null && m3373d((View) this.f2335c)) {
            removeView(this.f2335c);
            this.f2321C.remove(this.f2335c);
        }
        if (this.f2335c != null) {
            this.f2335c.setText(charSequence);
        }
        this.f2354v = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f2355w;
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2336d == null) {
                Context context = getContext();
                this.f2336d = new TextView(context);
                this.f2336d.setSingleLine();
                this.f2336d.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f2345m != 0) {
                    this.f2336d.setTextAppearance(context, this.f2345m);
                }
                if (this.f2357y != 0) {
                    this.f2336d.setTextColor(this.f2357y);
                }
            }
            if (!m3373d((View) this.f2336d)) {
                m3361a((View) this.f2336d, true);
            }
        } else if (this.f2336d != null && m3373d((View) this.f2336d)) {
            removeView(this.f2336d);
            this.f2321C.remove(this.f2336d);
        }
        if (this.f2336d != null) {
            this.f2336d.setText(charSequence);
        }
        this.f2355w = charSequence;
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i) {
        this.f2344l = i;
        if (this.f2335c != null) {
            this.f2335c.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i) {
        this.f2345m = i;
        if (this.f2336d != null) {
            this.f2336d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        this.f2356x = i;
        if (this.f2335c != null) {
            this.f2335c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        this.f2357y = i;
        if (this.f2336d != null) {
            this.f2336d.setTextColor(i);
        }
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        if (this.f2337e != null) {
            return this.f2337e.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m3375f();
        }
        if (this.f2337e != null) {
            this.f2337e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(this.f2332N.getDrawable(i));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            m3375f();
            if (!m3373d((View) this.f2337e)) {
                m3361a((View) this.f2337e, true);
            }
        } else if (this.f2337e != null && m3373d((View) this.f2337e)) {
            removeView(this.f2337e);
            this.f2321C.remove(this.f2337e);
        }
        if (this.f2337e != null) {
            this.f2337e.setImageDrawable(drawable);
        }
    }

    @Nullable
    public Drawable getNavigationIcon() {
        if (this.f2337e != null) {
            return this.f2337e.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m3375f();
        this.f2337e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m3372d();
        return this.f2334b.getMenu();
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        m3372d();
        this.f2334b.setOverflowIcon(drawable);
    }

    @Nullable
    public Drawable getOverflowIcon() {
        m3372d();
        return this.f2334b.getOverflowIcon();
    }

    /* renamed from: d */
    private void m3372d() {
        m3374e();
        if (this.f2334b.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f2334b.getMenu();
            if (this.f2327I == null) {
                this.f2327I = new C0593a();
            }
            this.f2334b.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.f2327I, this.f2342j);
        }
    }

    /* renamed from: e */
    private void m3374e() {
        if (this.f2334b == null) {
            this.f2334b = new ActionMenuView(getContext());
            this.f2334b.setPopupTheme(this.f2343k);
            this.f2334b.setOnMenuItemClickListener(this.f2324F);
            this.f2334b.setMenuCallbacks(this.f2328J, this.f2329K);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388613 | (this.f2346n & 112);
            this.f2334b.setLayoutParams(generateDefaultLayoutParams);
            m3361a((View) this.f2334b, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void inflateMenu(@MenuRes int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2323E = onMenuItemClickListener;
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.f2352t.mo8252a(i, i2);
    }

    public int getContentInsetStart() {
        return this.f2352t.mo8256c();
    }

    public int getContentInsetEnd() {
        return this.f2352t.mo8257d();
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        this.f2352t.mo8255b(i, i2);
    }

    public int getContentInsetLeft() {
        return this.f2352t.mo8251a();
    }

    public int getContentInsetRight() {
        return this.f2352t.mo8254b();
    }

    /* renamed from: f */
    private void m3375f() {
        if (this.f2337e == null) {
            this.f2337e = new ImageButton(getContext(), (AttributeSet) null, C0505R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.f2346n & 112);
            this.f2337e.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m3376g() {
        if (this.f2341i == null) {
            this.f2341i = new ImageButton(getContext(), (AttributeSet) null, C0505R.attr.toolbarNavigationButtonStyle);
            this.f2341i.setImageDrawable(this.f2339g);
            this.f2341i.setContentDescription(this.f2340h);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.f2346n & 112);
            generateDefaultLayoutParams.f2362a = 2;
            this.f2341i.setLayoutParams(generateDefaultLayoutParams);
            this.f2341i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    /* renamed from: a */
    private void m3361a(View view, boolean z) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.f2362a = 1;
        if (!z || this.f2333a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f2321C.add(view);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f2327I == null || this.f2327I.f2366b == null)) {
            savedState.f2363a = this.f2327I.f2366b.getItemId();
        }
        savedState.f2364b = isOverflowMenuShowing();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        MenuBuilder peekMenu = this.f2334b != null ? this.f2334b.peekMenu() : null;
        if (!(savedState.f2363a == 0 || this.f2327I == null || peekMenu == null || (findItem = peekMenu.findItem(savedState.f2363a)) == null)) {
            MenuItemCompat.expandActionView(findItem);
        }
        if (savedState.f2364b) {
            m3377h();
        }
    }

    /* renamed from: h */
    private void m3377h() {
        removeCallbacks(this.f2331M);
        post(this.f2331M);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2331M);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f2358z = false;
        }
        if (!this.f2358z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f2358z = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2358z = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.f2319A = false;
        }
        if (!this.f2319A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f2319A = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2319A = false;
        }
        return true;
    }

    /* renamed from: a */
    private void m3360a(View view, int i, int i2, int i3, int i4, int i5) {
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
    private int m3356a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: i */
    private boolean m3378i() {
        if (!this.f2330L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m3363a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f2322D;
        if (ViewUtils.isLayoutRtl(this)) {
            c = 0;
            c2 = 1;
        } else {
            c = 1;
            c2 = 0;
        }
        int i7 = 0;
        if (m3363a((View) this.f2337e)) {
            m3360a((View) this.f2337e, i, 0, i2, 0, this.f2347o);
            i7 = this.f2337e.getMeasuredWidth() + m3365b((View) this.f2337e);
            int max = Math.max(0, this.f2337e.getMeasuredHeight() + m3368c((View) this.f2337e));
            i6 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.f2337e));
            i5 = max;
        }
        if (m3363a((View) this.f2341i)) {
            m3360a((View) this.f2341i, i, 0, i2, 0, this.f2347o);
            i7 = this.f2341i.getMeasuredWidth() + m3365b((View) this.f2341i);
            i5 = Math.max(i5, this.f2341i.getMeasuredHeight() + m3368c((View) this.f2341i));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.f2341i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[c2] = Math.max(0, contentInsetStart - i7);
        int i8 = 0;
        if (m3363a((View) this.f2334b)) {
            m3360a((View) this.f2334b, i, max2, i2, 0, this.f2347o);
            i8 = this.f2334b.getMeasuredWidth() + m3365b((View) this.f2334b);
            i5 = Math.max(i5, this.f2334b.getMeasuredHeight() + m3368c((View) this.f2334b));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.f2334b));
        }
        int contentInsetEnd = getContentInsetEnd();
        int max3 = max2 + Math.max(contentInsetEnd, i8);
        iArr[c] = Math.max(0, contentInsetEnd - i8);
        if (m3363a(this.f2333a)) {
            max3 += m3356a(this.f2333a, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f2333a.getMeasuredHeight() + m3368c(this.f2333a));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.f2333a));
        }
        if (m3363a((View) this.f2338f)) {
            max3 += m3356a((View) this.f2338f, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f2338f.getMeasuredHeight() + m3368c((View) this.f2338f));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.f2338f));
        }
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = i5;
        int i11 = i6;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (((LayoutParams) childAt.getLayoutParams()).f2362a != 0) {
                i3 = i11;
                i4 = i10;
            } else if (!m3363a(childAt)) {
                i3 = i11;
                i4 = i10;
            } else {
                max3 += m3356a(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i10, childAt.getMeasuredHeight() + m3368c(childAt));
                i3 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(childAt));
                i4 = max4;
            }
            i9++;
            i11 = i3;
            i10 = i4;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = this.f2350r + this.f2351s;
        int i15 = this.f2348p + this.f2349q;
        if (m3363a((View) this.f2335c)) {
            m3356a((View) this.f2335c, i, max3 + i15, i2, i14, iArr);
            i12 = m3365b((View) this.f2335c) + this.f2335c.getMeasuredWidth();
            i13 = this.f2335c.getMeasuredHeight() + m3368c((View) this.f2335c);
            i11 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(this.f2335c));
        }
        if (m3363a((View) this.f2336d)) {
            i12 = Math.max(i12, m3356a((View) this.f2336d, i, max3 + i15, i2, i14 + i13, iArr));
            i13 += this.f2336d.getMeasuredHeight() + m3368c((View) this.f2336d);
            i11 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(this.f2336d));
        }
        int max5 = Math.max(i10, i13);
        int paddingLeft = i12 + max3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max5 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i11);
        int resolveSizeAndState2 = ViewCompat.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i11 << 16);
        if (m3378i()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
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
        int i15;
        int i16;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i17 = width - paddingRight;
        int[] iArr = this.f2322D;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (!m3363a((View) this.f2337e)) {
            i5 = paddingLeft;
        } else if (z2) {
            i17 = m3366b(this.f2337e, i17, iArr, minimumHeight);
            i5 = paddingLeft;
        } else {
            i5 = m3357a(this.f2337e, paddingLeft, iArr, minimumHeight);
        }
        if (m3363a((View) this.f2341i)) {
            if (z2) {
                i17 = m3366b(this.f2341i, i17, iArr, minimumHeight);
            } else {
                i5 = m3357a(this.f2341i, i5, iArr, minimumHeight);
            }
        }
        if (m3363a((View) this.f2334b)) {
            if (z2) {
                i5 = m3357a(this.f2334b, i5, iArr, minimumHeight);
            } else {
                i17 = m3366b(this.f2334b, i17, iArr, minimumHeight);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i17));
        int max = Math.max(i5, getContentInsetLeft());
        int min = Math.min(i17, (width - paddingRight) - getContentInsetRight());
        if (m3363a(this.f2333a)) {
            if (z2) {
                min = m3366b(this.f2333a, min, iArr, minimumHeight);
            } else {
                max = m3357a(this.f2333a, max, iArr, minimumHeight);
            }
        }
        if (!m3363a((View) this.f2338f)) {
            i6 = min;
            i7 = max;
        } else if (z2) {
            i6 = m3366b(this.f2338f, min, iArr, minimumHeight);
            i7 = max;
        } else {
            i6 = min;
            i7 = m3357a(this.f2338f, max, iArr, minimumHeight);
        }
        boolean a = m3363a((View) this.f2335c);
        boolean a2 = m3363a((View) this.f2336d);
        int i18 = 0;
        if (a) {
            LayoutParams layoutParams = (LayoutParams) this.f2335c.getLayoutParams();
            i18 = 0 + layoutParams.bottomMargin + layoutParams.topMargin + this.f2335c.getMeasuredHeight();
        }
        if (a2) {
            LayoutParams layoutParams2 = (LayoutParams) this.f2336d.getLayoutParams();
            i8 = layoutParams2.bottomMargin + layoutParams2.topMargin + this.f2336d.getMeasuredHeight() + i18;
        } else {
            i8 = i18;
        }
        if (a || a2) {
            TextView textView = a ? this.f2335c : this.f2336d;
            TextView textView2 = a2 ? this.f2336d : this.f2335c;
            LayoutParams layoutParams3 = (LayoutParams) textView.getLayoutParams();
            LayoutParams layoutParams4 = (LayoutParams) textView2.getLayoutParams();
            boolean z3 = (a && this.f2335c.getMeasuredWidth() > 0) || (a2 && this.f2336d.getMeasuredWidth() > 0);
            switch (this.f2353u & 112) {
                case 48:
                    i9 = layoutParams3.topMargin + getPaddingTop() + this.f2350r;
                    break;
                case 80:
                    i9 = (((height - paddingBottom) - layoutParams4.bottomMargin) - this.f2351s) - i8;
                    break;
                default:
                    int i19 = (((height - paddingTop) - paddingBottom) - i8) / 2;
                    if (i19 < layoutParams3.topMargin + this.f2350r) {
                        i16 = layoutParams3.topMargin + this.f2350r;
                    } else {
                        int i20 = (((height - paddingBottom) - i8) - i19) - paddingTop;
                        if (i20 < layoutParams3.bottomMargin + this.f2351s) {
                            i16 = Math.max(0, i19 - ((layoutParams4.bottomMargin + this.f2351s) - i20));
                        } else {
                            i16 = i19;
                        }
                    }
                    i9 = paddingTop + i16;
                    break;
            }
            if (z2) {
                int i21 = (z3 ? this.f2348p : 0) - iArr[1];
                int max2 = i6 - Math.max(0, i21);
                iArr[1] = Math.max(0, -i21);
                if (a) {
                    int measuredWidth = max2 - this.f2335c.getMeasuredWidth();
                    int measuredHeight = this.f2335c.getMeasuredHeight() + i9;
                    this.f2335c.layout(measuredWidth, i9, max2, measuredHeight);
                    int i22 = measuredWidth - this.f2349q;
                    i9 = measuredHeight + ((LayoutParams) this.f2335c.getLayoutParams()).bottomMargin;
                    i13 = i22;
                } else {
                    i13 = max2;
                }
                if (a2) {
                    LayoutParams layoutParams5 = (LayoutParams) this.f2336d.getLayoutParams();
                    int i23 = layoutParams5.topMargin + i9;
                    int measuredHeight2 = this.f2336d.getMeasuredHeight() + i23;
                    this.f2336d.layout(max2 - this.f2336d.getMeasuredWidth(), i23, max2, measuredHeight2);
                    int i24 = layoutParams5.bottomMargin + measuredHeight2;
                    i14 = max2 - this.f2349q;
                } else {
                    i14 = max2;
                }
                if (z3) {
                    i15 = Math.min(i13, i14);
                } else {
                    i15 = max2;
                }
                i6 = i15;
            } else {
                int i25 = (z3 ? this.f2348p : 0) - iArr[0];
                i7 += Math.max(0, i25);
                iArr[0] = Math.max(0, -i25);
                if (a) {
                    int measuredWidth2 = this.f2335c.getMeasuredWidth() + i7;
                    int measuredHeight3 = this.f2335c.getMeasuredHeight() + i9;
                    this.f2335c.layout(i7, i9, measuredWidth2, measuredHeight3);
                    int i26 = ((LayoutParams) this.f2335c.getLayoutParams()).bottomMargin + measuredHeight3;
                    i10 = measuredWidth2 + this.f2349q;
                    i11 = i26;
                } else {
                    i10 = i7;
                    i11 = i9;
                }
                if (a2) {
                    LayoutParams layoutParams6 = (LayoutParams) this.f2336d.getLayoutParams();
                    int i27 = i11 + layoutParams6.topMargin;
                    int measuredWidth3 = this.f2336d.getMeasuredWidth() + i7;
                    int measuredHeight4 = this.f2336d.getMeasuredHeight() + i27;
                    this.f2336d.layout(i7, i27, measuredWidth3, measuredHeight4);
                    int i28 = layoutParams6.bottomMargin + measuredHeight4;
                    i12 = this.f2349q + measuredWidth3;
                } else {
                    i12 = i7;
                }
                if (z3) {
                    i7 = Math.max(i10, i12);
                }
            }
        }
        m3362a((List<View>) this.f2320B, 3);
        int size = this.f2320B.size();
        int i29 = i7;
        for (int i30 = 0; i30 < size; i30++) {
            i29 = m3357a(this.f2320B.get(i30), i29, iArr, minimumHeight);
        }
        m3362a((List<View>) this.f2320B, 5);
        int size2 = this.f2320B.size();
        for (int i31 = 0; i31 < size2; i31++) {
            i6 = m3366b(this.f2320B.get(i31), i6, iArr, minimumHeight);
        }
        m3362a((List<View>) this.f2320B, 1);
        int a3 = m3358a((List<View>) this.f2320B, iArr);
        int i32 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (a3 / 2);
        int i33 = a3 + i32;
        if (i32 < i29) {
            i32 = i29;
        } else if (i33 > i6) {
            i32 -= i33 - i6;
        }
        int size3 = this.f2320B.size();
        int i34 = i32;
        for (int i35 = 0; i35 < size3; i35++) {
            i34 = m3357a(this.f2320B.get(i35), i34, iArr, minimumHeight);
        }
        this.f2320B.clear();
    }

    /* renamed from: a */
    private int m3358a(List<View> list, int[] iArr) {
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
    private int m3357a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int a = m3355a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a, max + measuredWidth, view.getMeasuredHeight() + a);
        return layoutParams.rightMargin + measuredWidth + max;
    }

    /* renamed from: b */
    private int m3366b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a = m3355a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a, max, view.getMeasuredHeight() + a);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    /* renamed from: a */
    private int m3355a(View view, int i) {
        int max;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m3354a(layoutParams.gravity)) {
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
    private int m3354a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f2353u & 112;
        }
    }

    /* renamed from: a */
    private void m3362a(List<View> list, int i) {
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
                if (layoutParams.f2362a == 0 && m3363a(childAt) && m3364b(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f2362a == 0 && m3363a(childAt2) && m3364b(layoutParams2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: b */
    private int m3364b(int i) {
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

    /* renamed from: a */
    private boolean m3363a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: b */
    private int m3365b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
    }

    /* renamed from: c */
    private int m3368c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public DecorToolbar getWrapper() {
        if (this.f2325G == null) {
            this.f2325G = new ToolbarWidgetWrapper(this, true);
        }
        return this.f2325G;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4580a() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f2362a == 2 || childAt == this.f2334b)) {
                removeViewAt(childCount);
                this.f2321C.add(childAt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4581b() {
        for (int size = this.f2321C.size() - 1; size >= 0; size--) {
            addView(this.f2321C.get(size));
        }
        this.f2321C.clear();
    }

    /* renamed from: d */
    private boolean m3373d(View view) {
        return view.getParent() == this || this.f2321C.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f2330L = z;
        requestLayout();
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f2328J = callback;
        this.f2329K = callback2;
    }

    /* renamed from: android.support.v7.widget.Toolbar$LayoutParams */
    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: a */
        int f2362a;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2362a = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2362a = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f2362a = 0;
            this.gravity = i3;
        }

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f2362a = 0;
            this.f2362a = layoutParams.f2362a;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2362a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            this.f2362a = 0;
            mo4645a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2362a = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4645a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$SavedState */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f2363a;

        /* renamed from: b */
        boolean f2364b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2363a = parcel.readInt();
            this.f2364b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2363a);
            parcel.writeInt(this.f2364b ? 1 : 0);
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$a */
    class C0593a implements MenuPresenter {

        /* renamed from: a */
        MenuBuilder f2365a;

        /* renamed from: b */
        MenuItemImpl f2366b;

        private C0593a() {
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            if (!(this.f2365a == null || this.f2366b == null)) {
                this.f2365a.collapseItemActionView(this.f2366b);
            }
            this.f2365a = menuBuilder;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void updateMenuView(boolean z) {
            boolean z2 = false;
            if (this.f2366b != null) {
                if (this.f2365a != null) {
                    int size = this.f2365a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f2365a.getItem(i) == this.f2366b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.f2365a, this.f2366b);
                }
            }
        }

        public void setCallback(MenuPresenter.Callback callback) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean flagActionItems() {
            return false;
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.m3376g();
            if (Toolbar.this.f2341i.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.f2341i);
            }
            Toolbar.this.f2333a = menuItemImpl.getActionView();
            this.f2366b = menuItemImpl;
            if (Toolbar.this.f2333a.getParent() != Toolbar.this) {
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = 8388611 | (Toolbar.this.f2346n & 112);
                generateDefaultLayoutParams.f2362a = 2;
                Toolbar.this.f2333a.setLayoutParams(generateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.f2333a);
            }
            Toolbar.this.mo4580a();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (Toolbar.this.f2333a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.f2333a).onActionViewExpanded();
            }
            return true;
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (Toolbar.this.f2333a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.f2333a).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.f2333a);
            Toolbar.this.removeView(Toolbar.this.f2341i);
            Toolbar.this.f2333a = null;
            Toolbar.this.mo4581b();
            this.f2366b = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        public int getId() {
            return 0;
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }
    }
}
