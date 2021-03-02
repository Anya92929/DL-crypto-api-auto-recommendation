package android.support.p003v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.appcompat.C0091R;
import android.support.p003v7.internal.view.ActionBarPolicy;
import android.support.p003v7.internal.view.SupportMenuInflater;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.SubMenuBuilder;
import android.support.p003v7.internal.widget.ActionBarContainer;
import android.support.p003v7.internal.widget.ActionBarContextView;
import android.support.p003v7.internal.widget.ActionBarOverlayLayout;
import android.support.p003v7.internal.widget.ActionBarView;
import android.support.p003v7.internal.widget.ScrollingTabContainerView;
import android.support.p003v7.view.ActionMode;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.app.ActionBarImplBase */
class ActionBarImplBase extends ActionBar {
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    ActionModeImpl mActionMode;
    /* access modifiers changed from: private */
    public ActionBarView mActionView;
    private ActionBarActivity mActivity;
    private ActionBar.Callback mCallback;
    private ActionBarContainer mContainerView;
    private View mContentView;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mContextDisplayMode;
    /* access modifiers changed from: private */
    public ActionBarContextView mContextView;
    private int mCurWindowVisibility = 0;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private Dialog mDialog;
    private boolean mDisplayHomeAsUpSet;
    final Handler mHandler = new Handler();
    private boolean mHasEmbeddedTabs;
    /* access modifiers changed from: private */
    public boolean mHiddenByApp;
    /* access modifiers changed from: private */
    public boolean mHiddenBySystem;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    private boolean mNowShowing = true;
    private ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    private boolean mShowingForMode;
    private ActionBarContainer mSplitView;
    /* access modifiers changed from: private */
    public ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private Context mThemedContext;
    private ViewGroup mTopVisibilityView;

    public ActionBarImplBase(ActionBarActivity activity, ActionBar.Callback callback) {
        this.mActivity = activity;
        this.mContext = activity;
        this.mCallback = callback;
        init(this.mActivity);
    }

    private void init(ActionBarActivity activity) {
        int i;
        boolean homeAsUp;
        boolean z = false;
        this.mOverlayLayout = (ActionBarOverlayLayout) activity.findViewById(C0091R.C0093id.action_bar_overlay_layout);
        if (this.mOverlayLayout != null) {
            this.mOverlayLayout.setActionBar(this);
        }
        this.mActionView = (ActionBarView) activity.findViewById(C0091R.C0093id.action_bar);
        this.mContextView = (ActionBarContextView) activity.findViewById(C0091R.C0093id.action_context_bar);
        this.mContainerView = (ActionBarContainer) activity.findViewById(C0091R.C0093id.action_bar_container);
        this.mTopVisibilityView = (ViewGroup) activity.findViewById(C0091R.C0093id.top_action_bar);
        if (this.mTopVisibilityView == null) {
            this.mTopVisibilityView = this.mContainerView;
        }
        this.mSplitView = (ActionBarContainer) activity.findViewById(C0091R.C0093id.split_action_bar);
        if (this.mActionView == null || this.mContextView == null || this.mContainerView == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.mActionView.setContextView(this.mContextView);
        if (this.mActionView.isSplitActionBar()) {
            i = 1;
        } else {
            i = 0;
        }
        this.mContextDisplayMode = i;
        if ((this.mActionView.getDisplayOptions() & 4) != 0) {
            homeAsUp = true;
        } else {
            homeAsUp = false;
        }
        if (homeAsUp) {
            this.mDisplayHomeAsUpSet = true;
        }
        ActionBarPolicy abp = ActionBarPolicy.get(this.mContext);
        if (abp.enableHomeButtonByDefault() || homeAsUp) {
            z = true;
        }
        setHomeButtonEnabled(z);
        setHasEmbeddedTabs(abp.hasEmbeddedTabs());
        setTitle(this.mActivity.getTitle());
    }

    public void onConfigurationChanged(Configuration newConfig) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    private void setHasEmbeddedTabs(boolean hasEmbeddedTabs) {
        boolean isInTabMode;
        boolean z = true;
        this.mHasEmbeddedTabs = hasEmbeddedTabs;
        if (!this.mHasEmbeddedTabs) {
            this.mActionView.setEmbeddedTabView((ScrollingTabContainerView) null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        } else {
            this.mContainerView.setTabContainer((ScrollingTabContainerView) null);
            this.mActionView.setEmbeddedTabView(this.mTabScrollView);
        }
        if (getNavigationMode() == 2) {
            isInTabMode = true;
        } else {
            isInTabMode = false;
        }
        if (this.mTabScrollView != null) {
            if (isInTabMode) {
                this.mTabScrollView.setVisibility(0);
            } else {
                this.mTabScrollView.setVisibility(8);
            }
        }
        ActionBarView actionBarView = this.mActionView;
        if (this.mHasEmbeddedTabs || !isInTabMode) {
            z = false;
        }
        actionBarView.setCollapsable(z);
    }

    public boolean hasNonEmbeddedTabs() {
        return !this.mHasEmbeddedTabs && getNavigationMode() == 2;
    }

    public void setCustomView(View view) {
        this.mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(int resId) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, this.mActionView, false));
    }

    public void setIcon(int resId) {
        this.mActionView.setIcon(resId);
    }

    public void setIcon(Drawable icon) {
        this.mActionView.setIcon(icon);
    }

    public void setLogo(int resId) {
        this.mActionView.setLogo(resId);
    }

    public void setLogo(Drawable logo) {
        this.mActionView.setLogo(logo);
    }

    public void setListNavigationCallbacks(SpinnerAdapter adapter, ActionBar.OnNavigationListener callback) {
        this.mActionView.setDropdownAdapter(adapter);
        this.mActionView.setCallback(callback);
    }

    public void setSelectedNavigationItem(int position) {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                this.mActionView.setDropdownSelectedPosition(position);
                return;
            case 2:
                selectTab(this.mTabs.get(position));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public int getSelectedNavigationIndex() {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                return this.mActionView.getDropdownSelectedPosition();
            case 2:
                if (this.mSelectedTab != null) {
                    return this.mSelectedTab.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    public int getNavigationItemCount() {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                SpinnerAdapter adapter = this.mActionView.getDropdownAdapter();
                if (adapter != null) {
                    return adapter.getCount();
                }
                return 0;
            case 2:
                return this.mTabs.size();
            default:
                return 0;
        }
    }

    public void setTitle(CharSequence title) {
        this.mActionView.setTitle(title);
    }

    public void setTitle(int resId) {
        setTitle((CharSequence) this.mContext.getString(resId));
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mActionView.setSubtitle(subtitle);
    }

    public void setSubtitle(int resId) {
        setSubtitle((CharSequence) this.mContext.getString(resId));
    }

    public void setDisplayOptions(int options) {
        if ((options & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mActionView.setDisplayOptions(options);
    }

    public void setDisplayOptions(int options, int mask) {
        int current = this.mActionView.getDisplayOptions();
        if ((mask & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mActionView.setDisplayOptions((options & mask) | ((mask ^ -1) & current));
    }

    public void setDisplayUseLogoEnabled(boolean useLogo) {
        setDisplayOptions(useLogo ? 1 : 0, 1);
    }

    public void setDisplayShowHomeEnabled(boolean showHome) {
        setDisplayOptions(showHome ? 2 : 0, 2);
    }

    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        setDisplayOptions(showHomeAsUp ? 4 : 0, 4);
    }

    public void setDisplayShowTitleEnabled(boolean showTitle) {
        setDisplayOptions(showTitle ? 8 : 0, 8);
    }

    public void setDisplayShowCustomEnabled(boolean showCustom) {
        setDisplayOptions(showCustom ? 16 : 0, 16);
    }

    public void setHomeButtonEnabled(boolean enable) {
        this.mActionView.setHomeButtonEnabled(enable);
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mContainerView.setPrimaryBackground(d);
    }

    public void setStackedBackgroundDrawable(Drawable d) {
        this.mContainerView.setStackedBackground(d);
    }

    public void setSplitBackgroundDrawable(Drawable d) {
        this.mContainerView.setSplitBackground(d);
    }

    public View getCustomView() {
        return this.mActionView.getCustomNavigationView();
    }

    public CharSequence getTitle() {
        return this.mActionView.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mActionView.getSubtitle();
    }

    public int getNavigationMode() {
        return this.mActionView.getNavigationMode();
    }

    public void setNavigationMode(int mode) {
        boolean z = false;
        switch (this.mActionView.getNavigationMode()) {
            case 2:
                this.mSavedTabPosition = getSelectedNavigationIndex();
                selectTab((ActionBar.Tab) null);
                this.mTabScrollView.setVisibility(8);
                break;
        }
        this.mActionView.setNavigationMode(mode);
        switch (mode) {
            case 2:
                ensureTabsExist();
                this.mTabScrollView.setVisibility(0);
                if (this.mSavedTabPosition != -1) {
                    setSelectedNavigationItem(this.mSavedTabPosition);
                    this.mSavedTabPosition = -1;
                    break;
                }
                break;
        }
        ActionBarView actionBarView = this.mActionView;
        if (mode == 2 && !this.mHasEmbeddedTabs) {
            z = true;
        }
        actionBarView.setCollapsable(z);
    }

    public int getDisplayOptions() {
        return this.mActionView.getDisplayOptions();
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, boolean setSelected) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, setSelected);
        configureTab(tab, this.mTabs.size());
        if (setSelected) {
            selectTab(tab);
        }
    }

    public void addTab(ActionBar.Tab tab, int position) {
        addTab(tab, position, this.mTabs.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, position, setSelected);
        configureTab(tab, position);
        if (setSelected) {
            selectTab(tab);
        }
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int position) {
        if (this.mTabScrollView != null) {
            int selectedTabPosition = this.mSelectedTab != null ? this.mSelectedTab.getPosition() : this.mSavedTabPosition;
            this.mTabScrollView.removeTabAt(position);
            TabImpl removedTab = this.mTabs.remove(position);
            if (removedTab != null) {
                removedTab.setPosition(-1);
            }
            int newTabCount = this.mTabs.size();
            for (int i = position; i < newTabCount; i++) {
                this.mTabs.get(i).setPosition(i);
            }
            if (selectedTabPosition == position) {
                selectTab(this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, position - 1)));
            }
        }
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void selectTab(ActionBar.Tab tab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i = tab.getPosition();
            }
            this.mSavedTabPosition = i;
            return;
        }
        FragmentTransaction trans = this.mActivity.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        if (this.mSelectedTab != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, trans);
            }
            this.mSelectedTab = (TabImpl) tab;
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, trans);
            }
        } else if (this.mSelectedTab != null) {
            this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, trans);
            this.mTabScrollView.animateToTab(tab.getPosition());
        }
        if (!trans.isEmpty()) {
            trans.commit();
        }
    }

    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public ActionBar.Tab getTabAt(int index) {
        return this.mTabs.get(index);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue outValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0091R.attr.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, targetThemeRes);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public void setHomeAsUpIndicator(Drawable indicator) {
        this.mActionView.setHomeAsUpIndicator(indicator);
    }

    public void setHomeAsUpIndicator(int resId) {
        this.mActionView.setHomeAsUpIndicator(resId);
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            updateVisibility(false);
        }
    }

    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            updateVisibility(false);
        }
    }

    public boolean isShowing() {
        return this.mNowShowing;
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.add(listener);
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.remove(listener);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        this.mContextView.killMode();
        ActionModeImpl mode = new ActionModeImpl(callback);
        if (!mode.dispatchOnCreate()) {
            return null;
        }
        mode.invalidate();
        this.mContextView.initForMode(mode);
        animateToMode(true);
        if (!(this.mSplitView == null || this.mContextDisplayMode != 1 || this.mSplitView.getVisibility() == 0)) {
            this.mSplitView.setVisibility(0);
        }
        this.mContextView.sendAccessibilityEvent(32);
        this.mActionMode = mode;
        return mode;
    }

    /* access modifiers changed from: package-private */
    public void animateToMode(boolean toActionMode) {
        int i;
        int i2;
        int i3 = 8;
        if (toActionMode) {
            showForActionMode();
        } else {
            hideForActionMode();
        }
        ActionBarView actionBarView = this.mActionView;
        if (toActionMode) {
            i = 4;
        } else {
            i = 0;
        }
        actionBarView.animateToVisibility(i);
        ActionBarContextView actionBarContextView = this.mContextView;
        if (toActionMode) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        actionBarContextView.animateToVisibility(i2);
        if (this.mTabScrollView != null && !this.mActionView.hasEmbeddedTabs() && this.mActionView.isCollapsed()) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (!toActionMode) {
                i3 = 0;
            }
            scrollingTabContainerView.setVisibility(i3);
        }
    }

    /* renamed from: android.support.v7.app.ActionBarImplBase$TabImpl */
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;

        public TabImpl() {
        }

        public Object getTag() {
            return this.mTag;
        }

        public ActionBar.Tab setTag(Object tag) {
            this.mTag = tag;
            return this;
        }

        public ActionBar.TabListener getCallback() {
            return this.mCallback;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener callback) {
            this.mCallback = callback;
            return this;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public ActionBar.Tab setCustomView(View view) {
            this.mCustomView = view;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int layoutResId) {
            return setCustomView(LayoutInflater.from(ActionBarImplBase.this.getThemedContext()).inflate(layoutResId, (ViewGroup) null));
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public void setPosition(int position) {
            this.mPosition = position;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public ActionBar.Tab setIcon(Drawable icon) {
            this.mIcon = icon;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setIcon(int resId) {
            return setIcon(ActionBarImplBase.this.mContext.getResources().getDrawable(resId));
        }

        public ActionBar.Tab setText(CharSequence text) {
            this.mText = text;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setText(int resId) {
            return setText(ActionBarImplBase.this.mContext.getResources().getText(resId));
        }

        public void select() {
            ActionBarImplBase.this.selectTab(this);
        }

        public ActionBar.Tab setContentDescription(int resId) {
            return setContentDescription(ActionBarImplBase.this.mContext.getResources().getText(resId));
        }

        public ActionBar.Tab setContentDescription(CharSequence contentDesc) {
            this.mContentDesc = contentDesc;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }
    }

    /* renamed from: android.support.v7.app.ActionBarImplBase$ActionModeImpl */
    class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private MenuBuilder mMenu;

        public ActionModeImpl(ActionMode.Callback callback) {
            this.mCallback = callback;
            this.mMenu = new MenuBuilder(ActionBarImplBase.this.getThemedContext()).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(ActionBarImplBase.this.getThemedContext());
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public void finish() {
            if (ActionBarImplBase.this.mActionMode == this) {
                if (!ActionBarImplBase.checkShowingFlags(ActionBarImplBase.this.mHiddenByApp, ActionBarImplBase.this.mHiddenBySystem, false)) {
                    ActionBarImplBase.this.mDeferredDestroyActionMode = this;
                    ActionBarImplBase.this.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                ActionBarImplBase.this.animateToMode(false);
                ActionBarImplBase.this.mContextView.closeMode();
                ActionBarImplBase.this.mActionView.sendAccessibilityEvent(32);
                ActionBarImplBase.this.mActionMode = null;
            }
        }

        public void invalidate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.mCallback.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void setCustomView(View view) {
            ActionBarImplBase.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference<>(view);
        }

        public void setSubtitle(CharSequence subtitle) {
            ActionBarImplBase.this.mContextView.setSubtitle(subtitle);
        }

        public void setTitle(CharSequence title) {
            ActionBarImplBase.this.mContextView.setTitle(title);
        }

        public void setTitle(int resId) {
            setTitle((CharSequence) ActionBarImplBase.this.mContext.getResources().getString(resId));
        }

        public void setSubtitle(int resId) {
            setSubtitle((CharSequence) ActionBarImplBase.this.mContext.getResources().getString(resId));
        }

        public CharSequence getTitle() {
            return ActionBarImplBase.this.mContextView.getTitle();
        }

        public CharSequence getSubtitle() {
            return ActionBarImplBase.this.mContextView.getSubtitle();
        }

        public void setTitleOptionalHint(boolean titleOptional) {
            super.setTitleOptionalHint(titleOptional);
            ActionBarImplBase.this.mContextView.setTitleOptional(titleOptional);
        }

        public boolean isTitleOptional() {
            return ActionBarImplBase.this.mContextView.isTitleOptional();
        }

        public View getCustomView() {
            if (this.mCustomView != null) {
                return (View) this.mCustomView.get();
            }
            return null;
        }

        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            if (this.mCallback != null) {
                return this.mCallback.onActionItemClicked(this, item);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menu) {
            if (this.mCallback != null) {
                invalidate();
                ActionBarImplBase.this.mContextView.showOverflowMenu();
            }
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenu.hasVisibleItems()) {
            }
            return true;
        }

        public void onCloseSubMenu(SubMenuBuilder menu) {
        }

        public void onMenuModeChange(Menu menu) {
            if (this.mCallback != null) {
                invalidate();
                ActionBarImplBase.this.mContextView.showOverflowMenu();
            }
        }
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView tabScroller = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                tabScroller.setVisibility(0);
                this.mActionView.setEmbeddedTabView(tabScroller);
            } else {
                if (getNavigationMode() == 2) {
                    tabScroller.setVisibility(0);
                } else {
                    tabScroller.setVisibility(8);
                }
                this.mContainerView.setTabContainer(tabScroller);
            }
            this.mTabScrollView = tabScroller;
        }
    }

    private void configureTab(ActionBar.Tab tab, int position) {
        TabImpl tabi = (TabImpl) tab;
        if (tabi.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabi.setPosition(position);
        this.mTabs.add(position, tabi);
        int count = this.mTabs.size();
        for (int i = position + 1; i < count; i++) {
            this.mTabs.get(i).setPosition(i);
        }
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.mTabs.clear();
        if (this.mTabScrollView != null) {
            this.mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    /* access modifiers changed from: private */
    public static boolean checkShowingFlags(boolean hiddenByApp, boolean hiddenBySystem, boolean showingForMode) {
        if (showingForMode) {
            return true;
        }
        if (hiddenByApp || hiddenBySystem) {
            return false;
        }
        return true;
    }

    private void updateVisibility(boolean fromSystem) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(fromSystem);
            }
        } else if (this.mNowShowing) {
            this.mNowShowing = false;
            doHide(fromSystem);
        }
    }

    public void setShowHideAnimationEnabled(boolean enabled) {
        this.mShowHideAnimationEnabled = enabled;
        if (!enabled) {
            this.mTopVisibilityView.clearAnimation();
            if (this.mSplitView != null) {
                this.mSplitView.clearAnimation();
            }
        }
    }

    public void doShow(boolean fromSystem) {
        boolean animate;
        this.mTopVisibilityView.clearAnimation();
        if (this.mTopVisibilityView.getVisibility() != 0) {
            if (isShowHideAnimationEnabled() || fromSystem) {
                animate = true;
            } else {
                animate = false;
            }
            if (animate) {
                this.mTopVisibilityView.startAnimation(AnimationUtils.loadAnimation(this.mContext, C0091R.anim.abc_slide_in_top));
            }
            this.mTopVisibilityView.setVisibility(0);
            if (this.mSplitView != null && this.mSplitView.getVisibility() != 0) {
                if (animate) {
                    this.mSplitView.startAnimation(AnimationUtils.loadAnimation(this.mContext, C0091R.anim.abc_slide_in_bottom));
                }
                this.mSplitView.setVisibility(0);
            }
        }
    }

    public void doHide(boolean fromSystem) {
        this.mTopVisibilityView.clearAnimation();
        if (this.mTopVisibilityView.getVisibility() != 8) {
            boolean animate = isShowHideAnimationEnabled() || fromSystem;
            if (animate) {
                this.mTopVisibilityView.startAnimation(AnimationUtils.loadAnimation(this.mContext, C0091R.anim.abc_slide_out_top));
            }
            this.mTopVisibilityView.setVisibility(8);
            if (this.mSplitView != null && this.mSplitView.getVisibility() != 8) {
                if (animate) {
                    this.mSplitView.startAnimation(AnimationUtils.loadAnimation(this.mContext, C0091R.anim.abc_slide_out_bottom));
                }
                this.mSplitView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isShowHideAnimationEnabled() {
        return this.mShowHideAnimationEnabled;
    }
}
