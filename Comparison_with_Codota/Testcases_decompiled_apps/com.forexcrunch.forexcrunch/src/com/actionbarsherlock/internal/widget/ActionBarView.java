package com.actionbarsherlock.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.actionbarsherlock.C0044R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.view.menu.ActionMenuItem;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuView;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.internal.widget.IcsAdapterView;
import com.actionbarsherlock.view.CollapsibleActionView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;
import com.parse.ParseException;

public class ActionBarView extends AbsActionBarView {
    private static final int DEFAULT_CUSTOM_GRAVITY = 19;
    public static final int DISPLAY_DEFAULT = 0;
    private static final int DISPLAY_RELAYOUT_MASK = 31;
    private static final String TAG = "ActionBarView";
    /* access modifiers changed from: private */
    public ActionBar.OnNavigationListener mCallback;
    private ActionBarContextView mContextView;
    /* access modifiers changed from: private */
    public View mCustomNavView;
    /* access modifiers changed from: private */
    public int mDisplayOptions = -1;
    View mExpandedActionView;
    private final View.OnClickListener mExpandedActionViewUpListener = new View.OnClickListener() {
        public void onClick(View v) {
            MenuItemImpl item = ActionBarView.this.mExpandedMenuPresenter.mCurrentExpandedItem;
            if (item != null) {
                item.collapseActionView();
            }
        }
    };
    /* access modifiers changed from: private */
    public HomeView mExpandedHomeLayout;
    /* access modifiers changed from: private */
    public ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    /* access modifiers changed from: private */
    public HomeView mHomeLayout;
    /* access modifiers changed from: private */
    public Drawable mIcon;
    private boolean mIncludeTabs;
    private int mIndeterminateProgressStyle;
    private IcsProgressBar mIndeterminateProgressView;
    private boolean mIsCollapsable;
    private boolean mIsCollapsed;
    private int mItemPadding;
    private IcsLinearLayout mListNavLayout;
    private Drawable mLogo;
    /* access modifiers changed from: private */
    public ActionMenuItem mLogoNavItem;
    private final IcsAdapterView.OnItemSelectedListener mNavItemSelectedListener = new IcsAdapterView.OnItemSelectedListener() {
        public void onItemSelected(IcsAdapterView parent, View view, int position, long id) {
            if (ActionBarView.this.mCallback != null) {
                ActionBarView.this.mCallback.onNavigationItemSelected(position, id);
            }
        }

        public void onNothingSelected(IcsAdapterView parent) {
        }
    };
    /* access modifiers changed from: private */
    public int mNavigationMode;
    private MenuBuilder mOptionsMenu;
    private int mProgressBarPadding;
    private int mProgressStyle;
    private IcsProgressBar mProgressView;
    /* access modifiers changed from: private */
    public IcsSpinner mSpinner;
    private SpinnerAdapter mSpinnerAdapter;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    /* access modifiers changed from: private */
    public ScrollingTabContainerView mTabScrollView;
    private CharSequence mTitle;
    /* access modifiers changed from: private */
    public LinearLayout mTitleLayout;
    private int mTitleStyleRes;
    private View mTitleUpView;
    private TextView mTitleView;
    private final View.OnClickListener mUpClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            ActionBarView.this.mWindowCallback.onMenuItemSelected(0, ActionBarView.this.mLogoNavItem);
        }
    };
    private boolean mUserTitle;
    Window.Callback mWindowCallback;

    public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        int resId;
        setBackgroundResource(0);
        TypedArray a = context.obtainStyledAttributes(attrs, C0044R.styleable.SherlockActionBar, C0044R.attr.actionBarStyle, 0);
        ApplicationInfo appInfo = context.getApplicationInfo();
        PackageManager pm = context.getPackageManager();
        this.mNavigationMode = a.getInt(6, 0);
        this.mTitle = a.getText(8);
        this.mSubtitle = a.getText(9);
        this.mLogo = a.getDrawable(11);
        if (this.mLogo == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                if (context instanceof Activity) {
                    try {
                        this.mLogo = pm.getActivityLogo(((Activity) context).getComponentName());
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e(TAG, "Activity component name not found!", e);
                    }
                }
                if (this.mLogo == null) {
                    this.mLogo = appInfo.loadLogo(pm);
                }
            } else if ((context instanceof Activity) && (resId = ResourcesCompat.loadLogoFromManifest((Activity) context)) != 0) {
                this.mLogo = context.getResources().getDrawable(resId);
            }
        }
        this.mIcon = a.getDrawable(10);
        if (this.mIcon == null) {
            if (context instanceof Activity) {
                try {
                    this.mIcon = pm.getActivityIcon(((Activity) context).getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.e(TAG, "Activity component name not found!", e2);
                }
            }
            if (this.mIcon == null) {
                this.mIcon = appInfo.loadIcon(pm);
            }
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        int homeResId = a.getResourceId(14, C0044R.layout.abs__action_bar_home);
        this.mHomeLayout = (HomeView) inflater.inflate(homeResId, this, false);
        this.mExpandedHomeLayout = (HomeView) inflater.inflate(homeResId, this, false);
        this.mExpandedHomeLayout.setUp(true);
        this.mExpandedHomeLayout.setOnClickListener(this.mExpandedActionViewUpListener);
        this.mExpandedHomeLayout.setContentDescription(getResources().getText(C0044R.string.abs__action_bar_up_description));
        this.mTitleStyleRes = a.getResourceId(0, 0);
        this.mSubtitleStyleRes = a.getResourceId(1, 0);
        this.mProgressStyle = a.getResourceId(15, 0);
        this.mIndeterminateProgressStyle = a.getResourceId(16, 0);
        this.mProgressBarPadding = a.getDimensionPixelOffset(17, 0);
        this.mItemPadding = a.getDimensionPixelOffset(18, 0);
        setDisplayOptions(a.getInt(7, 0));
        int customNavId = a.getResourceId(13, 0);
        if (customNavId != 0) {
            this.mCustomNavView = inflater.inflate(customNavId, this, false);
            this.mNavigationMode = 0;
            setDisplayOptions(this.mDisplayOptions | 16);
        }
        this.mContentHeight = a.getLayoutDimension(4, 0);
        a.recycle();
        this.mLogoNavItem = new ActionMenuItem(context, 0, 16908332, 0, 0, this.mTitle);
        this.mHomeLayout.setOnClickListener(this.mUpClickListener);
        this.mHomeLayout.setClickable(true);
        this.mHomeLayout.setFocusable(true);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mTitleView = null;
        this.mSubtitleView = null;
        this.mTitleUpView = null;
        if (this.mTitleLayout != null && this.mTitleLayout.getParent() == this) {
            removeView(this.mTitleLayout);
        }
        this.mTitleLayout = null;
        if ((this.mDisplayOptions & 8) != 0) {
            initTitle();
        }
        if (this.mTabScrollView != null && this.mIncludeTabs) {
            ViewGroup.LayoutParams lp = this.mTabScrollView.getLayoutParams();
            if (lp != null) {
                lp.width = -2;
                lp.height = -1;
            }
            this.mTabScrollView.setAllowCollapse(true);
        }
    }

    public void setWindowCallback(Window.Callback cb) {
        this.mWindowCallback = cb;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void initProgress() {
        this.mProgressView = new IcsProgressBar(this.mContext, (AttributeSet) null, 0, this.mProgressStyle);
        this.mProgressView.setId(C0044R.C0045id.abs__progress_horizontal);
        this.mProgressView.setMax(10000);
        addView(this.mProgressView);
    }

    public void initIndeterminateProgress() {
        this.mIndeterminateProgressView = new IcsProgressBar(this.mContext, (AttributeSet) null, 0, this.mIndeterminateProgressStyle);
        this.mIndeterminateProgressView.setId(C0044R.C0045id.abs__progress_circular);
        addView(this.mIndeterminateProgressView);
    }

    public void setSplitActionBar(boolean splitActionBar) {
        if (this.mSplitActionBar != splitActionBar) {
            if (this.mMenuView != null) {
                ViewGroup oldParent = (ViewGroup) this.mMenuView.getParent();
                if (oldParent != null) {
                    oldParent.removeView(this.mMenuView);
                }
                if (!splitActionBar) {
                    addView(this.mMenuView);
                } else if (this.mSplitView != null) {
                    this.mSplitView.addView(this.mMenuView);
                }
            }
            if (this.mSplitView != null) {
                this.mSplitView.setVisibility(splitActionBar ? 0 : 8);
            }
            super.setSplitActionBar(splitActionBar);
        }
    }

    public boolean isSplitActionBar() {
        return this.mSplitActionBar;
    }

    public boolean hasEmbeddedTabs() {
        return this.mIncludeTabs;
    }

    public void setEmbeddedTabView(ScrollingTabContainerView tabs) {
        if (this.mTabScrollView != null) {
            removeView(this.mTabScrollView);
        }
        this.mTabScrollView = tabs;
        this.mIncludeTabs = tabs != null;
        if (this.mIncludeTabs && this.mNavigationMode == 2) {
            addView(this.mTabScrollView);
            ViewGroup.LayoutParams lp = this.mTabScrollView.getLayoutParams();
            lp.width = -2;
            lp.height = -1;
            tabs.setAllowCollapse(true);
        }
    }

    public void setCallback(ActionBar.OnNavigationListener callback) {
        this.mCallback = callback;
    }

    public void setMenu(Menu menu, MenuPresenter.Callback cb) {
        ActionMenuView menuView;
        ViewGroup oldParent;
        if (menu != this.mOptionsMenu) {
            if (this.mOptionsMenu != null) {
                this.mOptionsMenu.removeMenuPresenter(this.mActionMenuPresenter);
                this.mOptionsMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
            }
            MenuBuilder builder = (MenuBuilder) menu;
            this.mOptionsMenu = builder;
            if (!(this.mMenuView == null || (oldParent = (ViewGroup) this.mMenuView.getParent()) == null)) {
                oldParent.removeView(this.mMenuView);
            }
            if (this.mActionMenuPresenter == null) {
                this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext);
                this.mActionMenuPresenter.setCallback(cb);
                this.mActionMenuPresenter.setId(C0044R.C0045id.abs__action_menu_presenter);
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this, (ExpandedActionViewMenuPresenter) null);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            if (!this.mSplitActionBar) {
                this.mActionMenuPresenter.setExpandedActionViewsExclusive(ResourcesCompat.getResources_getBoolean(getContext(), C0044R.bool.abs__action_bar_expanded_action_views_exclusive));
                configPresenters(builder);
                menuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                ViewGroup oldParent2 = (ViewGroup) menuView.getParent();
                if (!(oldParent2 == null || oldParent2 == this)) {
                    oldParent2.removeView(menuView);
                }
                addView(menuView, layoutParams);
            } else {
                this.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
                this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
                this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                layoutParams.width = -1;
                configPresenters(builder);
                menuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                if (this.mSplitView != null) {
                    ViewGroup oldParent3 = (ViewGroup) menuView.getParent();
                    if (!(oldParent3 == null || oldParent3 == this.mSplitView)) {
                        oldParent3.removeView(menuView);
                    }
                    menuView.setVisibility(getAnimatedVisibility());
                    this.mSplitView.addView(menuView, layoutParams);
                } else {
                    menuView.setLayoutParams(layoutParams);
                }
            }
            this.mMenuView = menuView;
        }
    }

    private void configPresenters(MenuBuilder builder) {
        if (builder != null) {
            builder.addMenuPresenter(this.mActionMenuPresenter);
            builder.addMenuPresenter(this.mExpandedMenuPresenter);
            return;
        }
        this.mActionMenuPresenter.initForMenu(this.mContext, (MenuBuilder) null);
        this.mExpandedMenuPresenter.initForMenu(this.mContext, (MenuBuilder) null);
        this.mActionMenuPresenter.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public void collapseActionView() {
        MenuItemImpl item;
        if (this.mExpandedMenuPresenter == null) {
            item = null;
        } else {
            item = this.mExpandedMenuPresenter.mCurrentExpandedItem;
        }
        if (item != null) {
            item.collapseActionView();
        }
    }

    public void setCustomNavigationView(View view) {
        boolean showCustom = (this.mDisplayOptions & 16) != 0;
        if (this.mCustomNavView != null && showCustom) {
            removeView(this.mCustomNavView);
        }
        this.mCustomNavView = view;
        if (this.mCustomNavView != null && showCustom) {
            addView(this.mCustomNavView);
        }
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public void setTitle(CharSequence title) {
        this.mUserTitle = true;
        setTitleImpl(title);
    }

    public void setWindowTitle(CharSequence title) {
        if (!this.mUserTitle) {
            setTitleImpl(title);
        }
    }

    private void setTitleImpl(CharSequence title) {
        int i = 0;
        this.mTitle = title;
        if (this.mTitleView != null) {
            this.mTitleView.setText(title);
            boolean visible = this.mExpandedActionView == null && (this.mDisplayOptions & 8) != 0 && (!TextUtils.isEmpty(this.mTitle) || !TextUtils.isEmpty(this.mSubtitle));
            LinearLayout linearLayout = this.mTitleLayout;
            if (!visible) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
        if (this.mLogoNavItem != null) {
            this.mLogoNavItem.setTitle(title);
        }
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public void setSubtitle(CharSequence subtitle) {
        boolean visible;
        int i = 0;
        this.mSubtitle = subtitle;
        if (this.mSubtitleView != null) {
            this.mSubtitleView.setText(subtitle);
            this.mSubtitleView.setVisibility(subtitle != null ? 0 : 8);
            if (this.mExpandedActionView != null || (this.mDisplayOptions & 8) == 0 || (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle))) {
                visible = false;
            } else {
                visible = true;
            }
            LinearLayout linearLayout = this.mTitleLayout;
            if (!visible) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
    }

    public void setHomeButtonEnabled(boolean enable) {
        this.mHomeLayout.setEnabled(enable);
        this.mHomeLayout.setFocusable(enable);
        if (!enable) {
            this.mHomeLayout.setContentDescription((CharSequence) null);
        } else if ((this.mDisplayOptions & 4) != 0) {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(C0044R.string.abs__action_bar_up_description));
        } else {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(C0044R.string.abs__action_bar_home_description));
        }
    }

    public void setDisplayOptions(int options) {
        boolean showHome;
        int vis;
        boolean homeAsUp;
        boolean setUp;
        int i = 8;
        int flagsChanged = -1;
        boolean z = true;
        if (this.mDisplayOptions != -1) {
            flagsChanged = options ^ this.mDisplayOptions;
        }
        this.mDisplayOptions = options;
        if ((flagsChanged & 31) != 0) {
            if ((options & 2) != 0) {
                showHome = true;
            } else {
                showHome = false;
            }
            if (!showHome || this.mExpandedActionView != null) {
                vis = 8;
            } else {
                vis = 0;
            }
            this.mHomeLayout.setVisibility(vis);
            if ((flagsChanged & 4) != 0) {
                if ((options & 4) != 0) {
                    setUp = true;
                } else {
                    setUp = false;
                }
                this.mHomeLayout.setUp(setUp);
                if (setUp) {
                    setHomeButtonEnabled(true);
                }
            }
            if ((flagsChanged & 1) != 0) {
                this.mHomeLayout.setIcon(this.mLogo != null && (options & 1) != 0 ? this.mLogo : this.mIcon);
            }
            if ((flagsChanged & 8) != 0) {
                if ((options & 8) != 0) {
                    initTitle();
                } else {
                    removeView(this.mTitleLayout);
                }
            }
            if (!(this.mTitleLayout == null || (flagsChanged & 6) == 0)) {
                if ((this.mDisplayOptions & 4) != 0) {
                    homeAsUp = true;
                } else {
                    homeAsUp = false;
                }
                View view = this.mTitleUpView;
                if (!showHome) {
                    i = homeAsUp ? 0 : 4;
                }
                view.setVisibility(i);
                LinearLayout linearLayout = this.mTitleLayout;
                if (showHome || !homeAsUp) {
                    z = false;
                }
                linearLayout.setEnabled(z);
            }
            if (!((flagsChanged & 16) == 0 || this.mCustomNavView == null)) {
                if ((options & 16) != 0) {
                    addView(this.mCustomNavView);
                } else {
                    removeView(this.mCustomNavView);
                }
            }
            requestLayout();
        } else {
            invalidate();
        }
        if (!this.mHomeLayout.isEnabled()) {
            this.mHomeLayout.setContentDescription((CharSequence) null);
        } else if ((options & 4) != 0) {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(C0044R.string.abs__action_bar_up_description));
        } else {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(C0044R.string.abs__action_bar_home_description));
        }
    }

    public void setIcon(Drawable icon) {
        this.mIcon = icon;
        if (icon == null) {
            return;
        }
        if ((this.mDisplayOptions & 1) == 0 || this.mLogo == null) {
            this.mHomeLayout.setIcon(icon);
        }
    }

    public void setIcon(int resId) {
        setIcon(this.mContext.getResources().getDrawable(resId));
    }

    public void setLogo(Drawable logo) {
        this.mLogo = logo;
        if (logo != null && (this.mDisplayOptions & 1) != 0) {
            this.mHomeLayout.setIcon(logo);
        }
    }

    public void setLogo(int resId) {
        setLogo(this.mContext.getResources().getDrawable(resId));
    }

    public void setNavigationMode(int mode) {
        int oldMode = this.mNavigationMode;
        if (mode != oldMode) {
            switch (oldMode) {
                case 1:
                    if (this.mListNavLayout != null) {
                        removeView(this.mListNavLayout);
                        break;
                    }
                    break;
                case 2:
                    if (this.mTabScrollView != null && this.mIncludeTabs) {
                        removeView(this.mTabScrollView);
                        break;
                    }
            }
            switch (mode) {
                case 1:
                    if (this.mSpinner == null) {
                        this.mSpinner = new IcsSpinner(this.mContext, (AttributeSet) null, C0044R.attr.actionDropDownStyle);
                        this.mListNavLayout = (IcsLinearLayout) LayoutInflater.from(this.mContext).inflate(C0044R.layout.abs__action_bar_tab_bar_view, (ViewGroup) null);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -1);
                        params.gravity = 17;
                        this.mListNavLayout.addView(this.mSpinner, params);
                    }
                    if (this.mSpinner.getAdapter() != this.mSpinnerAdapter) {
                        this.mSpinner.setAdapter(this.mSpinnerAdapter);
                    }
                    this.mSpinner.setOnItemSelectedListener(this.mNavItemSelectedListener);
                    addView(this.mListNavLayout);
                    break;
                case 2:
                    if (this.mTabScrollView != null && this.mIncludeTabs) {
                        addView(this.mTabScrollView);
                        break;
                    }
            }
            this.mNavigationMode = mode;
            requestLayout();
        }
    }

    public void setDropdownAdapter(SpinnerAdapter adapter) {
        this.mSpinnerAdapter = adapter;
        if (this.mSpinner != null) {
            this.mSpinner.setAdapter(adapter);
        }
    }

    public SpinnerAdapter getDropdownAdapter() {
        return this.mSpinnerAdapter;
    }

    public void setDropdownSelectedPosition(int position) {
        this.mSpinner.setSelection(position);
    }

    public int getDropdownSelectedPosition() {
        return this.mSpinner.getSelectedItemPosition();
    }

    public View getCustomNavigationView() {
        return this.mCustomNavView;
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public int getDisplayOptions() {
        return this.mDisplayOptions;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ActionBar.LayoutParams(19);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        ViewParent parent;
        super.onFinishInflate();
        addView(this.mHomeLayout);
        if (this.mCustomNavView != null && (this.mDisplayOptions & 16) != 0 && (parent = this.mCustomNavView.getParent()) != this) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mCustomNavView);
            }
            addView(this.mCustomNavView);
        }
    }

    /* access modifiers changed from: private */
    public void initTitle() {
        boolean homeAsUp;
        boolean showHome;
        boolean z = true;
        if (this.mTitleLayout == null) {
            this.mTitleLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(C0044R.layout.abs__action_bar_title_item, this, false);
            this.mTitleView = (TextView) this.mTitleLayout.findViewById(C0044R.C0045id.abs__action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(C0044R.C0045id.abs__action_bar_subtitle);
            this.mTitleUpView = this.mTitleLayout.findViewById(C0044R.C0045id.abs__up);
            this.mTitleLayout.setOnClickListener(this.mUpClickListener);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
            }
            if (this.mTitle != null) {
                this.mTitleView.setText(this.mTitle);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
            }
            if (this.mSubtitle != null) {
                this.mSubtitleView.setText(this.mSubtitle);
                this.mSubtitleView.setVisibility(0);
            }
            if ((this.mDisplayOptions & 4) != 0) {
                homeAsUp = true;
            } else {
                homeAsUp = false;
            }
            if ((this.mDisplayOptions & 2) != 0) {
                showHome = true;
            } else {
                showHome = false;
            }
            this.mTitleUpView.setVisibility(!showHome ? homeAsUp ? 0 : 4 : 8);
            LinearLayout linearLayout = this.mTitleLayout;
            if (!homeAsUp || showHome) {
                z = false;
            }
            linearLayout.setEnabled(z);
        }
        addView(this.mTitleLayout);
        if (this.mExpandedActionView != null || (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle))) {
            this.mTitleLayout.setVisibility(8);
        }
    }

    public void setContextView(ActionBarContextView view) {
        this.mContextView = view;
    }

    public void setCollapsable(boolean collapsable) {
        this.mIsCollapsable = collapsable;
    }

    public boolean isCollapsed() {
        return this.mIsCollapsed;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int customNavHeightMode;
        int i;
        int itemPaddingSize;
        int itemPaddingSize2;
        int homeWidthSpec;
        int childCount = getChildCount();
        if (this.mIsCollapsable) {
            int visibleChildren = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View child = getChildAt(i2);
                if (!(child.getVisibility() == 8 || (child == this.mMenuView && this.mMenuView.getChildCount() == 0))) {
                    visibleChildren++;
                }
            }
            if (visibleChildren == 0) {
                setMeasuredDimension(0, 0);
                this.mIsCollapsed = true;
                return;
            }
        }
        this.mIsCollapsed = false;
        if (View.MeasureSpec.getMode(widthMeasureSpec) != 1073741824) {
            throw new IllegalStateException(String.valueOf(getClass().getSimpleName()) + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(heightMeasureSpec) != Integer.MIN_VALUE) {
            throw new IllegalStateException(String.valueOf(getClass().getSimpleName()) + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int contentWidth = View.MeasureSpec.getSize(widthMeasureSpec);
            int maxHeight = this.mContentHeight > 0 ? this.mContentHeight : View.MeasureSpec.getSize(heightMeasureSpec);
            int verticalPadding = getPaddingTop() + getPaddingBottom();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int height = maxHeight - verticalPadding;
            int childSpecHeight = View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
            int availableWidth = (contentWidth - paddingLeft) - paddingRight;
            int leftOfCenter = availableWidth / 2;
            int rightOfCenter = leftOfCenter;
            HomeView homeLayout = this.mExpandedActionView != null ? this.mExpandedHomeLayout : this.mHomeLayout;
            if (homeLayout.getVisibility() != 8) {
                ViewGroup.LayoutParams lp = homeLayout.getLayoutParams();
                if (lp.width < 0) {
                    homeWidthSpec = View.MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE);
                } else {
                    homeWidthSpec = View.MeasureSpec.makeMeasureSpec(lp.width, 1073741824);
                }
                homeLayout.measure(homeWidthSpec, View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                int homeWidth = homeLayout.getMeasuredWidth() + homeLayout.getLeftOffset();
                availableWidth = Math.max(0, availableWidth - homeWidth);
                leftOfCenter = Math.max(0, availableWidth - homeWidth);
            }
            if (this.mMenuView != null && this.mMenuView.getParent() == this) {
                availableWidth = measureChildView(this.mMenuView, availableWidth, childSpecHeight, 0);
                rightOfCenter = Math.max(0, rightOfCenter - this.mMenuView.getMeasuredWidth());
            }
            if (!(this.mIndeterminateProgressView == null || this.mIndeterminateProgressView.getVisibility() == 8)) {
                availableWidth = measureChildView(this.mIndeterminateProgressView, availableWidth, childSpecHeight, 0);
                rightOfCenter = Math.max(0, rightOfCenter - this.mIndeterminateProgressView.getMeasuredWidth());
            }
            boolean showTitle = (this.mTitleLayout == null || this.mTitleLayout.getVisibility() == 8 || (this.mDisplayOptions & 8) == 0) ? false : true;
            if (this.mExpandedActionView == null) {
                switch (this.mNavigationMode) {
                    case 1:
                        if (this.mListNavLayout != null) {
                            if (showTitle) {
                                itemPaddingSize2 = this.mItemPadding * 2;
                            } else {
                                itemPaddingSize2 = this.mItemPadding;
                            }
                            int availableWidth2 = Math.max(0, availableWidth - itemPaddingSize2);
                            int leftOfCenter2 = Math.max(0, leftOfCenter - itemPaddingSize2);
                            this.mListNavLayout.measure(View.MeasureSpec.makeMeasureSpec(availableWidth2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                            int listNavWidth = this.mListNavLayout.getMeasuredWidth();
                            availableWidth = Math.max(0, availableWidth2 - listNavWidth);
                            leftOfCenter = Math.max(0, leftOfCenter2 - listNavWidth);
                            break;
                        }
                        break;
                    case 2:
                        if (this.mTabScrollView != null) {
                            if (showTitle) {
                                itemPaddingSize = this.mItemPadding * 2;
                            } else {
                                itemPaddingSize = this.mItemPadding;
                            }
                            int availableWidth3 = Math.max(0, availableWidth - itemPaddingSize);
                            int leftOfCenter3 = Math.max(0, leftOfCenter - itemPaddingSize);
                            this.mTabScrollView.measure(View.MeasureSpec.makeMeasureSpec(availableWidth3, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                            int tabWidth = this.mTabScrollView.getMeasuredWidth();
                            availableWidth = Math.max(0, availableWidth3 - tabWidth);
                            leftOfCenter = Math.max(0, leftOfCenter3 - tabWidth);
                            break;
                        }
                        break;
                }
            }
            View customView = null;
            if (this.mExpandedActionView != null) {
                customView = this.mExpandedActionView;
            } else if (!((this.mDisplayOptions & 16) == 0 || this.mCustomNavView == null)) {
                customView = this.mCustomNavView;
            }
            if (customView != null) {
                ViewGroup.LayoutParams lp2 = generateLayoutParams(customView.getLayoutParams());
                ActionBar.LayoutParams ablp = lp2 instanceof ActionBar.LayoutParams ? (ActionBar.LayoutParams) lp2 : null;
                int horizontalMargin = 0;
                int verticalMargin = 0;
                if (ablp != null) {
                    horizontalMargin = ablp.leftMargin + ablp.rightMargin;
                    verticalMargin = ablp.topMargin + ablp.bottomMargin;
                }
                if (this.mContentHeight <= 0) {
                    customNavHeightMode = Integer.MIN_VALUE;
                } else {
                    customNavHeightMode = lp2.height != -2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (lp2.height >= 0) {
                    height = Math.min(lp2.height, height);
                }
                int customNavHeight = Math.max(0, height - verticalMargin);
                int customNavWidthMode = lp2.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (lp2.width >= 0) {
                    i = Math.min(lp2.width, availableWidth);
                } else {
                    i = availableWidth;
                }
                int customNavWidth = Math.max(0, i - horizontalMargin);
                if (((ablp != null ? ablp.gravity : 19) & 7) == 1 && lp2.width == -1) {
                    customNavWidth = Math.min(leftOfCenter, rightOfCenter) * 2;
                }
                customView.measure(View.MeasureSpec.makeMeasureSpec(customNavWidth, customNavWidthMode), View.MeasureSpec.makeMeasureSpec(customNavHeight, customNavHeightMode));
                availableWidth -= customView.getMeasuredWidth() + horizontalMargin;
            }
            if (this.mExpandedActionView == null && showTitle) {
                int availableWidth4 = measureChildView(this.mTitleLayout, availableWidth, View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824), 0);
                int leftOfCenter4 = Math.max(0, leftOfCenter - this.mTitleLayout.getMeasuredWidth());
            }
            if (this.mContentHeight <= 0) {
                int measuredHeight = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    int paddedViewHeight = getChildAt(i3).getMeasuredHeight() + verticalPadding;
                    if (paddedViewHeight > measuredHeight) {
                        measuredHeight = paddedViewHeight;
                    }
                }
                setMeasuredDimension(contentWidth, measuredHeight);
            } else {
                setMeasuredDimension(contentWidth, maxHeight);
            }
            if (this.mContextView != null) {
                this.mContextView.setContentHeight(getMeasuredHeight());
            }
            if (this.mProgressView != null && this.mProgressView.getVisibility() != 8) {
                this.mProgressView.measure(View.MeasureSpec.makeMeasureSpec(contentWidth - (this.mProgressBarPadding * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int x = getPaddingLeft();
        int y = getPaddingTop();
        int contentHeight = ((b - t) - getPaddingTop()) - getPaddingBottom();
        if (contentHeight > 0) {
            HomeView homeLayout = this.mExpandedActionView != null ? this.mExpandedHomeLayout : this.mHomeLayout;
            if (homeLayout.getVisibility() != 8) {
                int leftOffset = homeLayout.getLeftOffset();
                x += positionChild(homeLayout, x + leftOffset, y, contentHeight) + leftOffset;
            }
            if (this.mExpandedActionView == null) {
                boolean showTitle = (this.mTitleLayout == null || this.mTitleLayout.getVisibility() == 8 || (this.mDisplayOptions & 8) == 0) ? false : true;
                if (showTitle) {
                    x += positionChild(this.mTitleLayout, x, y, contentHeight);
                }
                switch (this.mNavigationMode) {
                    case 1:
                        if (this.mListNavLayout != null) {
                            if (showTitle) {
                                x += this.mItemPadding;
                            }
                            x += positionChild(this.mListNavLayout, x, y, contentHeight) + this.mItemPadding;
                            break;
                        }
                        break;
                    case 2:
                        if (this.mTabScrollView != null) {
                            if (showTitle) {
                                x += this.mItemPadding;
                            }
                            x += positionChild(this.mTabScrollView, x, y, contentHeight) + this.mItemPadding;
                            break;
                        }
                        break;
                }
            }
            int menuLeft = (r - l) - getPaddingRight();
            if (this.mMenuView != null && this.mMenuView.getParent() == this) {
                positionChildInverse(this.mMenuView, menuLeft, y, contentHeight);
                menuLeft -= this.mMenuView.getMeasuredWidth();
            }
            if (!(this.mIndeterminateProgressView == null || this.mIndeterminateProgressView.getVisibility() == 8)) {
                positionChildInverse(this.mIndeterminateProgressView, menuLeft, y, contentHeight);
                menuLeft -= this.mIndeterminateProgressView.getMeasuredWidth();
            }
            View customView = null;
            if (this.mExpandedActionView != null) {
                customView = this.mExpandedActionView;
            } else if (!((this.mDisplayOptions & 16) == 0 || this.mCustomNavView == null)) {
                customView = this.mCustomNavView;
            }
            if (customView != null) {
                ViewGroup.LayoutParams lp = customView.getLayoutParams();
                ActionBar.LayoutParams ablp = lp instanceof ActionBar.LayoutParams ? (ActionBar.LayoutParams) lp : null;
                int gravity = ablp != null ? ablp.gravity : 19;
                int navWidth = customView.getMeasuredWidth();
                int topMargin = 0;
                int bottomMargin = 0;
                if (ablp != null) {
                    x += ablp.leftMargin;
                    menuLeft -= ablp.rightMargin;
                    topMargin = ablp.topMargin;
                    bottomMargin = ablp.bottomMargin;
                }
                int hgravity = gravity & 7;
                if (hgravity == 1) {
                    int centeredLeft = ((getRight() - getLeft()) - navWidth) / 2;
                    if (centeredLeft < x) {
                        hgravity = 3;
                    } else if (centeredLeft + navWidth > menuLeft) {
                        hgravity = 5;
                    }
                } else if (gravity == -1) {
                    hgravity = 3;
                }
                int xpos = 0;
                switch (hgravity) {
                    case 1:
                        xpos = ((getRight() - getLeft()) - navWidth) / 2;
                        break;
                    case 3:
                        xpos = x;
                        break;
                    case 5:
                        xpos = menuLeft - navWidth;
                        break;
                }
                int vgravity = gravity & ParseException.INVALID_CHANNEL_NAME;
                if (gravity == -1) {
                    vgravity = 16;
                }
                int ypos = 0;
                switch (vgravity) {
                    case 16:
                        ypos = ((((getBottom() - getTop()) - getPaddingBottom()) - getPaddingTop()) - customView.getMeasuredHeight()) / 2;
                        break;
                    case 48:
                        ypos = getPaddingTop() + topMargin;
                        break;
                    case 80:
                        ypos = ((getHeight() - getPaddingBottom()) - customView.getMeasuredHeight()) - bottomMargin;
                        break;
                }
                int customWidth = customView.getMeasuredWidth();
                customView.layout(xpos, ypos, xpos + customWidth, customView.getMeasuredHeight() + ypos);
                int x2 = x + customWidth;
            }
            if (this.mProgressView != null) {
                this.mProgressView.bringToFront();
                int halfProgressHeight = this.mProgressView.getMeasuredHeight() / 2;
                this.mProgressView.layout(this.mProgressBarPadding, -halfProgressHeight, this.mProgressBarPadding + this.mProgressView.getMeasuredWidth(), halfProgressHeight);
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ActionBar.LayoutParams(getContext(), attrs);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp == null) {
            return generateDefaultLayoutParams();
        }
        return lp;
    }

    public Parcelable onSaveInstanceState() {
        SavedState state = new SavedState(super.onSaveInstanceState());
        if (!(this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null)) {
            state.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        state.isOverflowOpen = isOverflowMenuShowing();
        return state;
    }

    public void onRestoreInstanceState(Parcelable p) {
        MenuItem item;
        SavedState state = (SavedState) p;
        super.onRestoreInstanceState(state.getSuperState());
        if (!(state.expandedMenuItemId == 0 || this.mExpandedMenuPresenter == null || this.mOptionsMenu == null || (item = this.mOptionsMenu.findItem(state.expandedMenuItemId)) == null)) {
            item.expandActionView();
        }
        if (state.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, (SavedState) null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        SavedState(Parcelable superState) {
            super(superState);
        }

        /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel in) {
            super(in);
            this.expandedMenuItemId = in.readInt();
            this.isOverflowOpen = in.readInt() != 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.expandedMenuItemId);
            out.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    public static class HomeView extends FrameLayout {
        private ImageView mIconView;
        private View mUpView;
        private int mUpWidth;

        public HomeView(Context context) {
            this(context, (AttributeSet) null);
        }

        public HomeView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public void setUp(boolean isUp) {
            this.mUpView.setVisibility(isUp ? 0 : 8);
        }

        public void setIcon(Drawable icon) {
            this.mIconView.setImageDrawable(icon);
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            onPopulateAccessibilityEvent(event);
            return true;
        }

        public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
            if (Build.VERSION.SDK_INT >= 14) {
                super.onPopulateAccessibilityEvent(event);
            }
            CharSequence cdesc = getContentDescription();
            if (!TextUtils.isEmpty(cdesc)) {
                event.getText().add(cdesc);
            }
        }

        public boolean dispatchHoverEvent(MotionEvent event) {
            return onHoverEvent(event);
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            this.mUpView = findViewById(C0044R.C0045id.abs__up);
            this.mIconView = (ImageView) findViewById(C0044R.C0045id.abs__home);
        }

        public int getLeftOffset() {
            if (this.mUpView.getVisibility() == 8) {
                return this.mUpWidth;
            }
            return 0;
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            measureChildWithMargins(this.mUpView, widthMeasureSpec, 0, heightMeasureSpec, 0);
            FrameLayout.LayoutParams upLp = (FrameLayout.LayoutParams) this.mUpView.getLayoutParams();
            this.mUpWidth = upLp.leftMargin + this.mUpView.getMeasuredWidth() + upLp.rightMargin;
            int width = this.mUpView.getVisibility() == 8 ? 0 : this.mUpWidth;
            int height = upLp.topMargin + this.mUpView.getMeasuredHeight() + upLp.bottomMargin;
            measureChildWithMargins(this.mIconView, widthMeasureSpec, width, heightMeasureSpec, 0);
            FrameLayout.LayoutParams iconLp = (FrameLayout.LayoutParams) this.mIconView.getLayoutParams();
            int width2 = width + iconLp.leftMargin + this.mIconView.getMeasuredWidth() + iconLp.rightMargin;
            int height2 = Math.max(height, iconLp.topMargin + this.mIconView.getMeasuredHeight() + iconLp.bottomMargin);
            int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
            int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
            int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
            int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
            switch (widthMode) {
                case Integer.MIN_VALUE:
                    width2 = Math.min(width2, widthSize);
                    break;
                case 1073741824:
                    width2 = widthSize;
                    break;
            }
            switch (heightMode) {
                case Integer.MIN_VALUE:
                    height2 = Math.min(height2, heightSize);
                    break;
                case 1073741824:
                    height2 = heightSize;
                    break;
            }
            setMeasuredDimension(width2, height2);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean changed, int l, int t, int r, int b) {
            int vCenter = (b - t) / 2;
            int upOffset = 0;
            if (this.mUpView.getVisibility() != 8) {
                FrameLayout.LayoutParams upLp = (FrameLayout.LayoutParams) this.mUpView.getLayoutParams();
                int upHeight = this.mUpView.getMeasuredHeight();
                int upWidth = this.mUpView.getMeasuredWidth();
                int upTop = vCenter - (upHeight / 2);
                this.mUpView.layout(0, upTop, upWidth, upTop + upHeight);
                upOffset = upLp.leftMargin + upWidth + upLp.rightMargin;
                l += upOffset;
            }
            FrameLayout.LayoutParams iconLp = (FrameLayout.LayoutParams) this.mIconView.getLayoutParams();
            int iconHeight = this.mIconView.getMeasuredHeight();
            int iconWidth = this.mIconView.getMeasuredWidth();
            int iconLeft = upOffset + Math.max(iconLp.leftMargin, ((r - l) / 2) - (iconWidth / 2));
            int iconTop = Math.max(iconLp.topMargin, vCenter - (iconHeight / 2));
            this.mIconView.layout(iconLeft, iconTop, iconLeft + iconWidth, iconTop + iconHeight);
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        /* synthetic */ ExpandedActionViewMenuPresenter(ActionBarView actionBarView, ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter) {
            this();
        }

        public void initForMenu(Context context, MenuBuilder menu) {
            if (!(this.mMenu == null || this.mCurrentExpandedItem == null)) {
                this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
            }
            this.mMenu = menu;
        }

        public MenuView getMenuView(ViewGroup root) {
            return null;
        }

        public void updateMenuView(boolean cleared) {
            if (this.mCurrentExpandedItem != null) {
                boolean found = false;
                if (this.mMenu != null) {
                    int count = this.mMenu.size();
                    int i = 0;
                    while (true) {
                        if (i >= count) {
                            break;
                        } else if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            found = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!found) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }

        public void setCallback(MenuPresenter.Callback cb) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            return false;
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        public boolean flagActionItems() {
            return false;
        }

        public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
            ActionBarView.this.mExpandedActionView = item.getActionView();
            ActionBarView.this.mExpandedHomeLayout.setIcon(ActionBarView.this.mIcon.getConstantState().newDrawable());
            this.mCurrentExpandedItem = item;
            if (ActionBarView.this.mExpandedActionView.getParent() != ActionBarView.this) {
                ActionBarView.this.addView(ActionBarView.this.mExpandedActionView);
            }
            if (ActionBarView.this.mExpandedHomeLayout.getParent() != ActionBarView.this) {
                ActionBarView.this.addView(ActionBarView.this.mExpandedHomeLayout);
            }
            ActionBarView.this.mHomeLayout.setVisibility(8);
            if (ActionBarView.this.mTitleLayout != null) {
                ActionBarView.this.mTitleLayout.setVisibility(8);
            }
            if (ActionBarView.this.mTabScrollView != null) {
                ActionBarView.this.mTabScrollView.setVisibility(8);
            }
            if (ActionBarView.this.mSpinner != null) {
                ActionBarView.this.mSpinner.setVisibility(8);
            }
            if (ActionBarView.this.mCustomNavView != null) {
                ActionBarView.this.mCustomNavView.setVisibility(8);
            }
            ActionBarView.this.requestLayout();
            item.setActionViewExpanded(true);
            if (ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) ActionBarView.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
            if (ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) ActionBarView.this.mExpandedActionView).onActionViewCollapsed();
            }
            ActionBarView.this.removeView(ActionBarView.this.mExpandedActionView);
            ActionBarView.this.removeView(ActionBarView.this.mExpandedHomeLayout);
            ActionBarView.this.mExpandedActionView = null;
            if ((ActionBarView.this.mDisplayOptions & 2) != 0) {
                ActionBarView.this.mHomeLayout.setVisibility(0);
            }
            if ((ActionBarView.this.mDisplayOptions & 8) != 0) {
                if (ActionBarView.this.mTitleLayout == null) {
                    ActionBarView.this.initTitle();
                } else {
                    ActionBarView.this.mTitleLayout.setVisibility(0);
                }
            }
            if (ActionBarView.this.mTabScrollView != null && ActionBarView.this.mNavigationMode == 2) {
                ActionBarView.this.mTabScrollView.setVisibility(0);
            }
            if (ActionBarView.this.mSpinner != null && ActionBarView.this.mNavigationMode == 1) {
                ActionBarView.this.mSpinner.setVisibility(0);
            }
            if (!(ActionBarView.this.mCustomNavView == null || (ActionBarView.this.mDisplayOptions & 16) == 0)) {
                ActionBarView.this.mCustomNavView.setVisibility(0);
            }
            ActionBarView.this.mExpandedHomeLayout.setIcon((Drawable) null);
            this.mCurrentExpandedItem = null;
            ActionBarView.this.requestLayout();
            item.setActionViewExpanded(false);
            return true;
        }

        public int getId() {
            return 0;
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable state) {
        }
    }
}
