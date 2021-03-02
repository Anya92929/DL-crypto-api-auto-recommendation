package com.actionbarsherlock.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.p000v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.C0051R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorListenerAdapter;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuPopupHelper;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarImpl extends ActionBar {
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    ActionModeImpl mActionMode;
    /* access modifiers changed from: private */
    public ActionBarView mActionView;
    private Activity mActivity;
    /* access modifiers changed from: private */
    public ActionBarContainer mContainerView;
    /* access modifiers changed from: private */
    public NineFrameLayout mContentView;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int mContextDisplayMode;
    /* access modifiers changed from: private */
    public ActionBarContextView mContextView;
    private Animator mCurrentModeAnim;
    /* access modifiers changed from: private */
    public Animator mCurrentShowAnim;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    final Handler mHandler = new Handler();
    private boolean mHasEmbeddedTabs;
    final Animator.AnimatorListener mHideListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animation) {
            if (ActionBarImpl.this.mContentView != null) {
                ActionBarImpl.this.mContentView.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                ActionBarImpl.this.mContainerView.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            }
            if (ActionBarImpl.this.mSplitView != null && ActionBarImpl.this.mContextDisplayMode == 1) {
                ActionBarImpl.this.mSplitView.setVisibility(8);
            }
            ActionBarImpl.this.mContainerView.setVisibility(8);
            ActionBarImpl.this.mContainerView.setTransitioning(false);
            ActionBarImpl.this.mCurrentShowAnim = null;
            ActionBarImpl.this.completeDeferredDestroyActionMode();
        }
    };
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final Animator.AnimatorListener mShowListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animation) {
            ActionBarImpl.this.mCurrentShowAnim = null;
            ActionBarImpl.this.mContainerView.requestLayout();
        }
    };
    /* access modifiers changed from: private */
    public ActionBarContainer mSplitView;
    /* access modifiers changed from: private */
    public ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private Context mThemedContext;
    boolean mWasHiddenBeforeMode;

    public ActionBarImpl(Activity activity, int features) {
        this.mActivity = activity;
        View decor = activity.getWindow().getDecorView();
        init(decor);
        if ((features & 512) == 0) {
            this.mContentView = (NineFrameLayout) decor.findViewById(16908290);
        }
    }

    public ActionBarImpl(Dialog dialog) {
        init(dialog.getWindow().getDecorView());
    }

    private void init(View decor) {
        int i;
        boolean z = true;
        this.mContext = decor.getContext();
        this.mActionView = (ActionBarView) decor.findViewById(C0051R.C0052id.abs__action_bar);
        this.mContextView = (ActionBarContextView) decor.findViewById(C0051R.C0052id.abs__action_context_bar);
        this.mContainerView = (ActionBarContainer) decor.findViewById(C0051R.C0052id.abs__action_bar_container);
        this.mSplitView = (ActionBarContainer) decor.findViewById(C0051R.C0052id.abs__split_action_bar);
        if (this.mActionView == null || this.mContextView == null || this.mContainerView == null) {
            throw new IllegalStateException(String.valueOf(getClass().getSimpleName()) + " can only be used " + "with a compatible window decor layout");
        }
        this.mActionView.setContextView(this.mContextView);
        if (this.mActionView.isSplitActionBar()) {
            i = 1;
        } else {
            i = 0;
        }
        this.mContextDisplayMode = i;
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 14) {
            z = false;
        }
        setHomeButtonEnabled(z);
        setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, C0051R.bool.abs__action_bar_embed_tabs));
    }

    public void onConfigurationChanged(Configuration newConfig) {
        setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, C0051R.bool.abs__action_bar_embed_tabs));
        if (Build.VERSION.SDK_INT < 8) {
            this.mActionView.onConfigurationChanged(newConfig);
            if (this.mContextView != null) {
                this.mContextView.onConfigurationChanged(newConfig);
            }
        }
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
            this.mTabScrollView.setVisibility(isInTabMode ? 0 : 8);
        }
        ActionBarView actionBarView = this.mActionView;
        if (this.mHasEmbeddedTabs || !isInTabMode) {
            z = false;
        }
        actionBarView.setCollapsable(z);
    }

    private void ensureTabsExist() {
        int i = 0;
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView tabScroller = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                tabScroller.setVisibility(0);
                this.mActionView.setEmbeddedTabView(tabScroller);
            } else {
                if (getNavigationMode() != 2) {
                    i = 8;
                }
                tabScroller.setVisibility(i);
                this.mContainerView.setTabContainer(tabScroller);
            }
            this.mTabScrollView = tabScroller;
        }
    }

    /* access modifiers changed from: package-private */
    public void completeDeferredDestroyActionMode() {
        if (this.mDeferredModeDestroyCallback != null) {
            this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void setShowHideAnimationEnabled(boolean enabled) {
        this.mShowHideAnimationEnabled = enabled;
        if (!enabled && this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.add(listener);
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.remove(listener);
    }

    public void dispatchMenuVisibilityChanged(boolean isVisible) {
        if (isVisible != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = isVisible;
            int count = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < count; i++) {
                this.mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(isVisible);
            }
        }
    }

    public void setCustomView(int resId) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, this.mActionView, false));
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

    public void setTitle(int resId) {
        setTitle((CharSequence) this.mContext.getString(resId));
    }

    public void setSubtitle(int resId) {
        setSubtitle((CharSequence) this.mContext.getString(resId));
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

    public void removeAllTabs() {
        cleanupTabs();
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

    public void setTitle(CharSequence title) {
        this.mActionView.setTitle(title);
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mActionView.setSubtitle(subtitle);
    }

    public void setDisplayOptions(int options) {
        this.mActionView.setDisplayOptions(options);
    }

    public void setDisplayOptions(int options, int mask) {
        this.mActionView.setDisplayOptions((options & mask) | ((mask ^ -1) & this.mActionView.getDisplayOptions()));
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mContainerView.setPrimaryBackground(d);
    }

    public void setStackedBackgroundDrawable(Drawable d) {
        this.mContainerView.setStackedBackground(d);
    }

    public void setSplitBackgroundDrawable(Drawable d) {
        if (this.mSplitView != null) {
            this.mSplitView.setSplitBackground(d);
        }
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

    public int getDisplayOptions() {
        return this.mActionView.getDisplayOptions();
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        boolean z;
        boolean wasHidden = false;
        if (this.mActionMode != null) {
            wasHidden = this.mWasHiddenBeforeMode;
            this.mActionMode.finish();
        }
        this.mContextView.killMode();
        ActionModeImpl mode = new ActionModeImpl(callback);
        if (!mode.dispatchOnCreate()) {
            return null;
        }
        if (!isShowing() || wasHidden) {
            z = true;
        } else {
            z = false;
        }
        this.mWasHiddenBeforeMode = z;
        mode.invalidate();
        this.mContextView.initForMode(mode);
        animateToMode(true);
        if (this.mSplitView != null && this.mContextDisplayMode == 1) {
            this.mSplitView.setVisibility(0);
        }
        this.mContextView.sendAccessibilityEvent(32);
        this.mActionMode = mode;
        return mode;
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

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, int position) {
        addTab(tab, position, this.mTabs.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, boolean setSelected) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, setSelected);
        configureTab(tab, this.mTabs.size());
        if (setSelected) {
            selectTab(tab);
        }
    }

    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, position, setSelected);
        configureTab(tab, position);
        if (setSelected) {
            selectTab(tab);
        }
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int position) {
        TabImpl tabImpl;
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
                if (this.mTabs.isEmpty()) {
                    tabImpl = null;
                } else {
                    tabImpl = this.mTabs.get(Math.max(0, position - 1));
                }
                selectTab(tabImpl);
            }
        }
    }

    public void selectTab(ActionBar.Tab tab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            this.mSavedTabPosition = tab != null ? tab.getPosition() : -1;
            return;
        }
        FragmentTransaction trans = null;
        if (this.mActivity instanceof SherlockFragmentActivity) {
            trans = ((SherlockFragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
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
        if (trans != null && !trans.isEmpty()) {
            trans.commit();
        }
    }

    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public void show() {
        show(true);
    }

    /* access modifiers changed from: package-private */
    public void show(boolean markHiddenBeforeMode) {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() != 0) {
            this.mContainerView.setVisibility(0);
            if (this.mShowHideAnimationEnabled) {
                this.mContainerView.setAlpha(BitmapDescriptorFactory.HUE_RED);
                AnimatorSet anim = new AnimatorSet();
                AnimatorSet.Builder b = anim.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", 1.0f));
                if (this.mContentView != null) {
                    b.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", (float) (-this.mContainerView.getHeight()), 0.0f));
                    this.mContainerView.setTranslationY((float) (-this.mContainerView.getHeight()));
                    b.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", 0.0f));
                }
                if (this.mSplitView != null && this.mContextDisplayMode == 1) {
                    this.mSplitView.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    this.mSplitView.setVisibility(0);
                    b.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", 1.0f));
                }
                anim.addListener(this.mShowListener);
                this.mCurrentShowAnim = anim;
                anim.start();
                return;
            }
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            this.mShowListener.onAnimationEnd((Animator) null);
        } else if (markHiddenBeforeMode) {
            this.mWasHiddenBeforeMode = false;
        }
    }

    public void hide() {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() != 8) {
            if (this.mShowHideAnimationEnabled) {
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTransitioning(true);
                AnimatorSet anim = new AnimatorSet();
                AnimatorSet.Builder b = anim.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", 0.0f));
                if (this.mContentView != null) {
                    b.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", 0.0f, (float) (-this.mContainerView.getHeight())));
                    b.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", (float) (-this.mContainerView.getHeight())));
                }
                if (this.mSplitView != null && this.mSplitView.getVisibility() == 0) {
                    this.mSplitView.setAlpha(1.0f);
                    b.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", 0.0f));
                }
                anim.addListener(this.mHideListener);
                this.mCurrentShowAnim = anim;
                anim.start();
                return;
            }
            this.mHideListener.onAnimationEnd((Animator) null);
        }
    }

    public boolean isShowing() {
        return this.mContainerView.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void animateToMode(boolean toActionMode) {
        int i;
        int i2 = 8;
        if (toActionMode) {
            show(false);
        }
        if (this.mCurrentModeAnim != null) {
            this.mCurrentModeAnim.end();
        }
        this.mActionView.animateToVisibility(toActionMode ? 8 : 0);
        ActionBarContextView actionBarContextView = this.mContextView;
        if (toActionMode) {
            i = 0;
        } else {
            i = 8;
        }
        actionBarContextView.animateToVisibility(i);
        if (this.mTabScrollView != null && !this.mActionView.hasEmbeddedTabs() && this.mActionView.isCollapsed()) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (!toActionMode) {
                i2 = 0;
            }
            scrollingTabContainerView.animateToVisibility(i2);
        }
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue outValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0051R.attr.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, targetThemeRes);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private MenuBuilder mMenu;

        public ActionModeImpl(ActionMode.Callback callback) {
            this.mCallback = callback;
            this.mMenu = new MenuBuilder(ActionBarImpl.this.getThemedContext()).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        public MenuInflater getMenuInflater() {
            return new MenuInflater(ActionBarImpl.this.getThemedContext());
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public void finish() {
            if (ActionBarImpl.this.mActionMode == this) {
                if (ActionBarImpl.this.mWasHiddenBeforeMode) {
                    ActionBarImpl.this.mDeferredDestroyActionMode = this;
                    ActionBarImpl.this.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                ActionBarImpl.this.animateToMode(false);
                ActionBarImpl.this.mContextView.closeMode();
                ActionBarImpl.this.mActionView.sendAccessibilityEvent(32);
                ActionBarImpl.this.mActionMode = null;
                if (ActionBarImpl.this.mWasHiddenBeforeMode) {
                    ActionBarImpl.this.hide();
                }
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
            ActionBarImpl.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference<>(view);
        }

        public void setSubtitle(CharSequence subtitle) {
            ActionBarImpl.this.mContextView.setSubtitle(subtitle);
        }

        public void setTitle(CharSequence title) {
            ActionBarImpl.this.mContextView.setTitle(title);
        }

        public void setTitle(int resId) {
            setTitle((CharSequence) ActionBarImpl.this.mContext.getResources().getString(resId));
        }

        public void setSubtitle(int resId) {
            setSubtitle((CharSequence) ActionBarImpl.this.mContext.getResources().getString(resId));
        }

        public CharSequence getTitle() {
            return ActionBarImpl.this.mContextView.getTitle();
        }

        public CharSequence getSubtitle() {
            return ActionBarImpl.this.mContextView.getSubtitle();
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

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenu.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(ActionBarImpl.this.getThemedContext(), subMenu).show();
            return true;
        }

        public void onCloseSubMenu(SubMenuBuilder menu) {
        }

        public void onMenuModeChange(MenuBuilder menu) {
            if (this.mCallback != null) {
                invalidate();
                ActionBarImpl.this.mContextView.showOverflowMenu();
            }
        }
    }

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
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int layoutResId) {
            return setCustomView(LayoutInflater.from(ActionBarImpl.this.getThemedContext()).inflate(layoutResId, (ViewGroup) null));
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
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setIcon(int resId) {
            return setIcon(ActionBarImpl.this.mContext.getResources().getDrawable(resId));
        }

        public ActionBar.Tab setText(CharSequence text) {
            this.mText = text;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setText(int resId) {
            return setText(ActionBarImpl.this.mContext.getResources().getText(resId));
        }

        public void select() {
            ActionBarImpl.this.selectTab(this);
        }

        public ActionBar.Tab setContentDescription(int resId) {
            return setContentDescription(ActionBarImpl.this.mContext.getResources().getText(resId));
        }

        public ActionBar.Tab setContentDescription(CharSequence contentDesc) {
            this.mContentDesc = contentDesc;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }
    }

    public void setCustomView(View view) {
        this.mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mActionView.setCustomNavigationView(view);
    }

    public void setListNavigationCallbacks(SpinnerAdapter adapter, ActionBar.OnNavigationListener callback) {
        this.mActionView.setDropdownAdapter(adapter);
        this.mActionView.setCallback(callback);
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

    public int getTabCount() {
        return this.mTabs.size();
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

    public ActionBar.Tab getTabAt(int index) {
        return this.mTabs.get(index);
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
}
