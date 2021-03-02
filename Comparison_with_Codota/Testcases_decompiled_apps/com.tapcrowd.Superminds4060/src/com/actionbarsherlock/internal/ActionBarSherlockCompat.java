package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.C0051R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.internal.view.StandaloneActionMode;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.IcsProgressBar;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Window;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ActionBarSherlock.Implementation(api = 7)
public class ActionBarSherlockCompat extends ActionBarSherlock implements MenuBuilder.Callback, Window.Callback, MenuPresenter.Callback, MenuItem.OnMenuItemClickListener {
    protected static final int DEFAULT_FEATURES = 0;
    private ActionBarImpl aActionBar;
    /* access modifiers changed from: private */
    public ActionMode mActionMode;
    /* access modifiers changed from: private */
    public ActionBarContextView mActionModeView;
    private IcsProgressBar mCircularProgressBar;
    private boolean mClosingActionMenu;
    private ViewGroup mContentParent;
    private ViewGroup mDecor;
    private int mFeatures = 0;
    private IcsProgressBar mHorizontalProgressBar;
    /* access modifiers changed from: private */
    public boolean mIsDestroyed = false;
    private boolean mIsFloating;
    private boolean mIsTitleReady = false;
    /* access modifiers changed from: private */
    public MenuBuilder mMenu;
    private Bundle mMenuFrozenActionViewState;
    private boolean mMenuIsPrepared;
    private boolean mMenuKeyIsLongPress = false;
    private boolean mMenuRefreshContent;
    protected HashMap<MenuItem, MenuItemImpl> mNativeItemMap;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet = false;
    private CharSequence mTitle = null;
    private TextView mTitleView;
    private int mUiOptions = 0;
    private ActionBarView wActionBar;

    public ActionBarSherlockCompat(Activity activity, int flags) {
        super(activity, flags);
    }

    public ActionBar getActionBar() {
        initActionBar();
        return this.aActionBar;
    }

    private void initActionBar() {
        if (this.mDecor == null) {
            installDecor();
        }
        if (this.aActionBar == null && hasFeature(8) && !hasFeature(1) && !this.mActivity.isChild()) {
            this.aActionBar = new ActionBarImpl(this.mActivity, this.mFeatures);
            if (!this.mIsDelegate) {
                this.wActionBar.setWindowTitle(this.mActivity.getTitle());
            }
        }
    }

    /* access modifiers changed from: protected */
    public Context getThemedContext() {
        return this.aActionBar.getThemedContext();
    }

    public void setTitle(CharSequence title) {
        dispatchTitleChanged(title, 0);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ViewStub stub;
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionMode.Callback wrappedCallback = new ActionModeCallbackWrapper(callback);
        ActionMode mode = null;
        initActionBar();
        if (this.aActionBar != null) {
            mode = this.aActionBar.startActionMode(wrappedCallback);
        }
        if (mode != null) {
            this.mActionMode = mode;
        } else {
            if (this.mActionModeView == null && (stub = (ViewStub) this.mDecor.findViewById(C0051R.C0052id.abs__action_mode_bar_stub)) != null) {
                this.mActionModeView = (ActionBarContextView) stub.inflate();
            }
            if (this.mActionModeView != null) {
                this.mActionModeView.killMode();
                ActionMode mode2 = new StandaloneActionMode(this.mActivity, this.mActionModeView, wrappedCallback, true);
                if (callback.onCreateActionMode(mode2, mode2.getMenu())) {
                    mode2.invalidate();
                    this.mActionModeView.initForMode(mode2);
                    this.mActionModeView.setVisibility(0);
                    this.mActionMode = mode2;
                    this.mActionModeView.sendAccessibilityEvent(32);
                } else {
                    this.mActionMode = null;
                }
            }
        }
        if (this.mActionMode != null && (this.mActivity instanceof ActionBarSherlock.OnActionModeStartedListener)) {
            ((ActionBarSherlock.OnActionModeStartedListener) this.mActivity).onActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }

    public void dispatchConfigurationChanged(Configuration newConfig) {
        if (this.aActionBar != null) {
            this.aActionBar.onConfigurationChanged(newConfig);
        }
    }

    public void dispatchPostResume() {
        if (this.aActionBar != null) {
            this.aActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void dispatchPause() {
        if (this.wActionBar != null && this.wActionBar.isOverflowMenuShowing()) {
            this.wActionBar.hideOverflowMenu();
        }
    }

    public void dispatchStop() {
        if (this.aActionBar != null) {
            this.aActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void dispatchInvalidateOptionsMenu() {
        if (this.mMenu != null) {
            Bundle savedActionViewStates = new Bundle();
            this.mMenu.saveActionViewStates(savedActionViewStates);
            if (savedActionViewStates.size() > 0) {
                this.mMenuFrozenActionViewState = savedActionViewStates;
            }
            this.mMenu.stopDispatchingItemsChanged();
            this.mMenu.clear();
        }
        this.mMenuRefreshContent = true;
        if (this.wActionBar != null) {
            this.mMenuIsPrepared = false;
            preparePanel();
        }
    }

    public boolean dispatchOpenOptionsMenu() {
        if (!isReservingOverflow()) {
            return false;
        }
        return this.wActionBar.showOverflowMenu();
    }

    public boolean dispatchCloseOptionsMenu() {
        if (!isReservingOverflow()) {
            return false;
        }
        return this.wActionBar.hideOverflowMenu();
    }

    public void dispatchPostCreate(Bundle savedInstanceState) {
        if (this.mIsDelegate) {
            this.mIsTitleReady = true;
        }
        if (this.mDecor == null) {
            initActionBar();
        }
    }

    public boolean dispatchCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.mActionMode != null) {
            return false;
        }
        this.mMenuIsPrepared = false;
        if (!preparePanel() || isReservingOverflow()) {
            return false;
        }
        if (this.mNativeItemMap == null) {
            this.mNativeItemMap = new HashMap<>();
        } else {
            this.mNativeItemMap.clear();
        }
        if (this.mMenu != null) {
            return this.mMenu.bindNativeOverflow(menu, this, this.mNativeItemMap);
        }
        return false;
    }

    public boolean dispatchOptionsItemSelected(MenuItem item) {
        throw new IllegalStateException("Native callback invoked. Create a test case and report!");
    }

    public boolean dispatchMenuOpened(int featureId, Menu menu) {
        if (featureId != 8 && featureId != 0) {
            return false;
        }
        if (this.aActionBar == null) {
            return true;
        }
        this.aActionBar.dispatchMenuVisibilityChanged(true);
        return true;
    }

    public void dispatchPanelClosed(int featureId, Menu menu) {
        if ((featureId == 8 || featureId == 0) && this.aActionBar != null) {
            this.aActionBar.dispatchMenuVisibilityChanged(false);
        }
    }

    public void dispatchTitleChanged(CharSequence title, int color) {
        if (!this.mIsDelegate || this.mIsTitleReady) {
            if (this.mTitleView != null) {
                this.mTitleView.setText(title);
            } else if (this.wActionBar != null) {
                this.wActionBar.setWindowTitle(title);
            }
        }
        this.mTitle = title;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == 4) {
            int action = event.getAction();
            if (this.mActionMode != null) {
                if (action == 1) {
                    this.mActionMode.finish();
                }
                return true;
            } else if (this.wActionBar != null && this.wActionBar.hasExpandedActionView()) {
                if (action == 1) {
                    this.wActionBar.collapseActionView();
                }
                return true;
            }
        }
        boolean result = false;
        if (keyCode != 82 || !isReservingOverflow()) {
            return false;
        }
        if (event.getAction() == 0 && event.isLongPress()) {
            this.mMenuKeyIsLongPress = true;
            return false;
        } else if (event.getAction() != 1) {
            return false;
        } else {
            if (!this.mMenuKeyIsLongPress) {
                if (this.mActionMode == null && this.wActionBar != null) {
                    if (this.wActionBar.isOverflowMenuShowing()) {
                        this.wActionBar.hideOverflowMenu();
                    } else {
                        this.wActionBar.showOverflowMenu();
                    }
                }
                result = true;
            }
            this.mMenuKeyIsLongPress = false;
            return result;
        }
    }

    public void dispatchDestroy() {
        this.mIsDestroyed = true;
    }

    private boolean preparePanel() {
        boolean z = false;
        if (this.mMenuIsPrepared) {
            return true;
        }
        if (this.mMenu == null || this.mMenuRefreshContent) {
            if (this.mMenu == null && (!initializePanelMenu() || this.mMenu == null)) {
                return false;
            }
            if (this.wActionBar != null) {
                this.wActionBar.setMenu(this.mMenu, this);
            }
            this.mMenu.stopDispatchingItemsChanged();
            if (!callbackCreateOptionsMenu(this.mMenu)) {
                this.mMenu = null;
                if (this.wActionBar == null) {
                    return false;
                }
                this.wActionBar.setMenu((com.actionbarsherlock.view.Menu) null, this);
                return false;
            }
            this.mMenuRefreshContent = false;
        }
        this.mMenu.stopDispatchingItemsChanged();
        if (this.mMenuFrozenActionViewState != null) {
            this.mMenu.restoreActionViewStates(this.mMenuFrozenActionViewState);
            this.mMenuFrozenActionViewState = null;
        }
        if (!callbackPrepareOptionsMenu(this.mMenu)) {
            if (this.wActionBar != null) {
                this.wActionBar.setMenu((com.actionbarsherlock.view.Menu) null, this);
            }
            this.mMenu.startDispatchingItemsChanged();
            return false;
        }
        KeyCharacterMap kmap = KeyCharacterMap.load(-1);
        MenuBuilder menuBuilder = this.mMenu;
        if (kmap.getKeyboardType() != 1) {
            z = true;
        }
        menuBuilder.setQwertyMode(z);
        this.mMenu.startDispatchingItemsChanged();
        this.mMenuIsPrepared = true;
        return true;
    }

    public boolean onMenuItemSelected(MenuBuilder menu, com.actionbarsherlock.view.MenuItem item) {
        return callbackOptionsItemSelected(item);
    }

    public void onMenuModeChange(MenuBuilder menu) {
        reopenMenu(true);
    }

    private void reopenMenu(boolean toggleMenuMode) {
        if (this.wActionBar != null && this.wActionBar.isOverflowReserved()) {
            if (this.wActionBar.isOverflowMenuShowing() && toggleMenuMode) {
                this.wActionBar.hideOverflowMenu();
            } else if (this.wActionBar.getVisibility() == 0 && callbackPrepareOptionsMenu(this.mMenu)) {
                this.wActionBar.showOverflowMenu();
            }
        }
    }

    private boolean initializePanelMenu() {
        Context context = this.mActivity;
        if (this.wActionBar != null) {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(C0051R.attr.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                context = new ContextThemeWrapper(context, targetThemeRes);
            }
        }
        this.mMenu = new MenuBuilder(context);
        this.mMenu.setCallback(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void checkCloseActionMenu(com.actionbarsherlock.view.Menu menu) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.wActionBar.dismissPopupMenus();
            this.mClosingActionMenu = false;
        }
    }

    public boolean onOpenSubMenu(MenuBuilder subMenu) {
        return true;
    }

    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        checkCloseActionMenu(menu);
    }

    public boolean onMenuItemClick(MenuItem item) {
        MenuItemImpl sherlockItem = this.mNativeItemMap.get(item);
        if (sherlockItem != null) {
            sherlockItem.invoke();
            return true;
        }
        Log.e("ActionBarSherlock", "Options item \"" + item + "\" not found in mapping");
        return true;
    }

    public boolean onMenuItemSelected(int featureId, com.actionbarsherlock.view.MenuItem item) {
        return callbackOptionsItemSelected(item);
    }

    public void setProgressBarVisibility(boolean visible) {
        int i;
        if (visible) {
            i = -1;
        } else {
            i = -2;
        }
        setFeatureInt(2, i);
    }

    public void setProgressBarIndeterminateVisibility(boolean visible) {
        setFeatureInt(5, visible ? -1 : -2);
    }

    public void setProgressBarIndeterminate(boolean indeterminate) {
        setFeatureInt(2, indeterminate ? -3 : -4);
    }

    public void setProgress(int progress) {
        setFeatureInt(2, progress + 0);
    }

    public void setSecondaryProgress(int secondaryProgress) {
        setFeatureInt(2, secondaryProgress + 20000);
    }

    private void setFeatureInt(int featureId, int value) {
        updateInt(featureId, value, false);
    }

    private void updateInt(int featureId, int value, boolean fromResume) {
        if (this.mContentParent != null) {
            if ((getFeatures() & (1 << featureId)) != 0 || fromResume) {
                onIntChanged(featureId, value);
            }
        }
    }

    private void onIntChanged(int featureId, int value) {
        if (featureId == 2 || featureId == 5) {
            updateProgressBars(value);
        }
    }

    private void updateProgressBars(int value) {
        int visibility;
        IcsProgressBar circularProgressBar = getCircularProgressBar(true);
        IcsProgressBar horizontalProgressBar = getHorizontalProgressBar(true);
        int features = this.mFeatures;
        if (value == -1) {
            if ((features & 4) != 0) {
                int level = horizontalProgressBar.getProgress();
                if (horizontalProgressBar.isIndeterminate() || level < 10000) {
                    visibility = 0;
                } else {
                    visibility = 4;
                }
                horizontalProgressBar.setVisibility(visibility);
            }
            if ((features & 32) != 0) {
                circularProgressBar.setVisibility(0);
            }
        } else if (value == -2) {
            if ((features & 4) != 0) {
                horizontalProgressBar.setVisibility(8);
            }
            if ((features & 32) != 0) {
                circularProgressBar.setVisibility(8);
            }
        } else if (value == -3) {
            horizontalProgressBar.setIndeterminate(true);
        } else if (value == -4) {
            horizontalProgressBar.setIndeterminate(false);
        } else if (value >= 0 && value <= 10000) {
            horizontalProgressBar.setProgress(value + 0);
            if (value < 10000) {
                showProgressBars(horizontalProgressBar, circularProgressBar);
            } else {
                hideProgressBars(horizontalProgressBar, circularProgressBar);
            }
        } else if (20000 <= value && value <= 30000) {
            horizontalProgressBar.setSecondaryProgress(value - 20000);
            showProgressBars(horizontalProgressBar, circularProgressBar);
        }
    }

    private void showProgressBars(IcsProgressBar horizontalProgressBar, IcsProgressBar spinnyProgressBar) {
        int features = this.mFeatures;
        if ((features & 32) != 0 && spinnyProgressBar.getVisibility() == 4) {
            spinnyProgressBar.setVisibility(0);
        }
        if ((features & 4) != 0 && horizontalProgressBar.getProgress() < 10000) {
            horizontalProgressBar.setVisibility(0);
        }
    }

    private void hideProgressBars(IcsProgressBar horizontalProgressBar, IcsProgressBar spinnyProgressBar) {
        int features = this.mFeatures;
        Animation anim = AnimationUtils.loadAnimation(this.mActivity, 17432577);
        anim.setDuration(1000);
        if ((features & 32) != 0 && spinnyProgressBar.getVisibility() == 0) {
            spinnyProgressBar.startAnimation(anim);
            spinnyProgressBar.setVisibility(4);
        }
        if ((features & 4) != 0 && horizontalProgressBar.getVisibility() == 0) {
            horizontalProgressBar.startAnimation(anim);
            horizontalProgressBar.setVisibility(4);
        }
    }

    private IcsProgressBar getCircularProgressBar(boolean shouldInstallDecor) {
        if (this.mCircularProgressBar != null) {
            return this.mCircularProgressBar;
        }
        if (this.mContentParent == null && shouldInstallDecor) {
            installDecor();
        }
        this.mCircularProgressBar = (IcsProgressBar) this.mDecor.findViewById(C0051R.C0052id.abs__progress_circular);
        if (this.mCircularProgressBar != null) {
            this.mCircularProgressBar.setVisibility(4);
        }
        return this.mCircularProgressBar;
    }

    private IcsProgressBar getHorizontalProgressBar(boolean shouldInstallDecor) {
        if (this.mHorizontalProgressBar != null) {
            return this.mHorizontalProgressBar;
        }
        if (this.mContentParent == null && shouldInstallDecor) {
            installDecor();
        }
        this.mHorizontalProgressBar = (IcsProgressBar) this.mDecor.findViewById(C0051R.C0052id.abs__progress_horizontal);
        if (this.mHorizontalProgressBar != null) {
            this.mHorizontalProgressBar.setVisibility(4);
        }
        return this.mHorizontalProgressBar;
    }

    private int getFeatures() {
        return this.mFeatures;
    }

    public boolean hasFeature(int featureId) {
        return (this.mFeatures & (1 << featureId)) != 0;
    }

    public boolean requestFeature(int featureId) {
        if (this.mContentParent != null) {
            throw new AndroidRuntimeException("requestFeature() must be called before adding content");
        }
        switch (featureId) {
            case 1:
            case 2:
            case 5:
            case 8:
            case 9:
            case 10:
                this.mFeatures |= 1 << featureId;
                return true;
            default:
                return false;
        }
    }

    public void setUiOptions(int uiOptions) {
        this.mUiOptions = uiOptions;
    }

    public void setUiOptions(int uiOptions, int mask) {
        this.mUiOptions = (this.mUiOptions & (mask ^ -1)) | (uiOptions & mask);
    }

    public void setContentView(int layoutResId) {
        if (this.mContentParent == null) {
            installDecor();
        } else {
            this.mContentParent.removeAllViews();
        }
        this.mActivity.getLayoutInflater().inflate(layoutResId, this.mContentParent);
        Window.Callback callback = this.mActivity.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
        initActionBar();
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (this.mContentParent == null) {
            installDecor();
        } else {
            this.mContentParent.removeAllViews();
        }
        this.mContentParent.addView(view, params);
        Window.Callback callback = this.mActivity.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
        initActionBar();
    }

    public void addContentView(View view, ViewGroup.LayoutParams params) {
        if (this.mContentParent == null) {
            installDecor();
        }
        this.mContentParent.addView(view, params);
        initActionBar();
    }

    private void installDecor() {
        boolean splitActionBar;
        boolean splitWhenNarrow = true;
        if (this.mDecor == null) {
            this.mDecor = (ViewGroup) this.mActivity.getWindow().getDecorView().findViewById(16908290);
        }
        if (this.mContentParent == null) {
            List<View> views = null;
            if (this.mDecor.getChildCount() > 0) {
                views = new ArrayList<>(1);
                int children = this.mDecor.getChildCount();
                for (int i = 0; i < children; i++) {
                    View child = this.mDecor.getChildAt(0);
                    this.mDecor.removeView(child);
                    views.add(child);
                }
            }
            this.mContentParent = generateLayout();
            if (views != null) {
                for (View child2 : views) {
                    this.mContentParent.addView(child2);
                }
            }
            this.mTitleView = (TextView) this.mDecor.findViewById(16908310);
            if (this.mTitleView == null) {
                this.wActionBar = (ActionBarView) this.mDecor.findViewById(C0051R.C0052id.abs__action_bar);
                if (this.wActionBar != null) {
                    this.wActionBar.setWindowCallback(this);
                    if (this.wActionBar.getTitle() == null) {
                        this.wActionBar.setWindowTitle(this.mActivity.getTitle());
                    }
                    if (hasFeature(2)) {
                        this.wActionBar.initProgress();
                    }
                    if (hasFeature(5)) {
                        this.wActionBar.initIndeterminateProgress();
                    }
                    int uiOptions = loadUiOptionsFromManifest(this.mActivity);
                    if (uiOptions != 0) {
                        this.mUiOptions = uiOptions;
                    }
                    if ((this.mUiOptions & 1) == 0) {
                        splitWhenNarrow = false;
                    }
                    if (splitWhenNarrow) {
                        splitActionBar = ResourcesCompat.getResources_getBoolean(this.mActivity, C0051R.bool.abs__split_action_bar_is_narrow);
                    } else {
                        splitActionBar = this.mActivity.getTheme().obtainStyledAttributes(C0051R.styleable.SherlockTheme).getBoolean(48, false);
                    }
                    ActionBarContainer splitView = (ActionBarContainer) this.mDecor.findViewById(C0051R.C0052id.abs__split_action_bar);
                    if (splitView != null) {
                        this.wActionBar.setSplitView(splitView);
                        this.wActionBar.setSplitActionBar(splitActionBar);
                        this.wActionBar.setSplitWhenNarrow(splitWhenNarrow);
                        this.mActionModeView = (ActionBarContextView) this.mDecor.findViewById(C0051R.C0052id.abs__action_context_bar);
                        this.mActionModeView.setSplitView(splitView);
                        this.mActionModeView.setSplitActionBar(splitActionBar);
                        this.mActionModeView.setSplitWhenNarrow(splitWhenNarrow);
                    } else if (splitActionBar) {
                        Log.e("ActionBarSherlock", "Requested split action bar with incompatible window decor! Ignoring request.");
                    }
                    this.mDecor.post(new Runnable() {
                        public void run() {
                            if (!ActionBarSherlockCompat.this.mIsDestroyed && !ActionBarSherlockCompat.this.mActivity.isFinishing() && ActionBarSherlockCompat.this.mMenu == null) {
                                ActionBarSherlockCompat.this.dispatchInvalidateOptionsMenu();
                            }
                        }
                    });
                }
            } else if (hasFeature(1)) {
                this.mTitleView.setVisibility(8);
                if (this.mContentParent instanceof FrameLayout) {
                    ((FrameLayout) this.mContentParent).setForeground((Drawable) null);
                }
            } else {
                this.mTitleView.setText(this.mTitle);
            }
        }
    }

    private ViewGroup generateLayout() {
        int layoutResource;
        IcsProgressBar progress;
        TypedArray a = this.mActivity.getTheme().obtainStyledAttributes(C0051R.styleable.SherlockTheme);
        this.mIsFloating = a.getBoolean(0, false);
        if (!a.hasValue(45)) {
            throw new IllegalStateException("You must use Theme.Sherlock, Theme.Sherlock.Light, Theme.Sherlock.Light.DarkActionBar, or a derivative.");
        }
        if (a.getBoolean(44, false)) {
            requestFeature(1);
        } else if (a.getBoolean(45, false)) {
            requestFeature(8);
        }
        if (a.getBoolean(46, false)) {
            requestFeature(9);
        }
        if (a.getBoolean(47, false)) {
            requestFeature(10);
        }
        a.recycle();
        if (!hasFeature(1)) {
            if (this.mIsFloating) {
                this.mDecor = (ViewGroup) this.mDecor.getParent();
                this.mDecor.removeAllViews();
                layoutResource = C0051R.layout.abs__dialog_title_holo;
            } else if (hasFeature(9)) {
                layoutResource = C0051R.layout.abs__screen_action_bar_overlay;
            } else {
                layoutResource = C0051R.layout.abs__screen_action_bar;
            }
        } else if (!hasFeature(10) || hasFeature(1)) {
            layoutResource = C0051R.layout.abs__screen_simple;
        } else {
            layoutResource = C0051R.layout.abs__screen_simple_overlay_action_mode;
        }
        this.mDecor.addView(this.mActivity.getLayoutInflater().inflate(layoutResource, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        ViewGroup contentParent = (ViewGroup) this.mDecor.findViewById(C0051R.C0052id.abs__content);
        if (contentParent == null) {
            throw new RuntimeException("Couldn't find content container view");
        }
        this.mDecor.setId(-1);
        contentParent.setId(16908290);
        if (hasFeature(5) && (progress = getCircularProgressBar(false)) != null) {
            progress.setIndeterminate(true);
        }
        return contentParent;
    }

    private boolean isReservingOverflow() {
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = ActionMenuPresenter.reserveOverflow(this.mActivity);
            this.mReserveOverflowSet = true;
        }
        return this.mReserveOverflow;
    }

    private static int loadUiOptionsFromManifest(Activity activity) {
        int uiOptions = 0;
        try {
            String thisPackage = activity.getClass().getName();
            String packageName = activity.getApplicationInfo().packageName;
            XmlResourceParser xml = activity.createPackageContext(packageName, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = xml.getEventType();
            while (true) {
                if (eventType == 1) {
                    break;
                }
                if (eventType == 2) {
                    String name = xml.getName();
                    if ("application".equals(name)) {
                        int i = xml.getAttributeCount() - 1;
                        while (true) {
                            if (i < 0) {
                                break;
                            } else if ("uiOptions".equals(xml.getAttributeName(i))) {
                                uiOptions = xml.getAttributeIntValue(i, 0);
                                break;
                            } else {
                                i--;
                            }
                        }
                    } else if ("activity".equals(name)) {
                        Integer activityUiOptions = null;
                        String activityPackage = null;
                        boolean isOurActivity = false;
                        for (int i2 = xml.getAttributeCount() - 1; i2 >= 0; i2--) {
                            String attrName = xml.getAttributeName(i2);
                            if (!"uiOptions".equals(attrName)) {
                                if (DBFavorites.KEY_NAME.equals(attrName)) {
                                    activityPackage = cleanActivityName(packageName, xml.getAttributeValue(i2));
                                    if (!thisPackage.equals(activityPackage)) {
                                        break;
                                    }
                                    isOurActivity = true;
                                }
                            } else {
                                activityUiOptions = Integer.valueOf(xml.getAttributeIntValue(i2, 0));
                            }
                            if (!(activityUiOptions == null || activityPackage == null)) {
                                uiOptions = activityUiOptions.intValue();
                            }
                        }
                        if (isOurActivity) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xml.nextToken();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uiOptions;
    }

    public static String cleanActivityName(String manifestPackage, String activityName) {
        if (activityName.charAt(0) == '.') {
            return String.valueOf(manifestPackage) + activityName;
        }
        if (activityName.indexOf(46, 1) == -1) {
            return String.valueOf(manifestPackage) + "." + activityName;
        }
        return activityName;
    }

    private class ActionModeCallbackWrapper implements ActionMode.Callback {
        private final ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapper(ActionMode.Callback wrapped) {
            this.mWrapped = wrapped;
        }

        public boolean onCreateActionMode(ActionMode mode, com.actionbarsherlock.view.Menu menu) {
            return this.mWrapped.onCreateActionMode(mode, menu);
        }

        public boolean onPrepareActionMode(ActionMode mode, com.actionbarsherlock.view.Menu menu) {
            return this.mWrapped.onPrepareActionMode(mode, menu);
        }

        public boolean onActionItemClicked(ActionMode mode, com.actionbarsherlock.view.MenuItem item) {
            return this.mWrapped.onActionItemClicked(mode, item);
        }

        public void onDestroyActionMode(ActionMode mode) {
            this.mWrapped.onDestroyActionMode(mode);
            if (ActionBarSherlockCompat.this.mActionModeView != null) {
                ActionBarSherlockCompat.this.mActionModeView.setVisibility(8);
                ActionBarSherlockCompat.this.mActionModeView.removeAllViews();
            }
            if (ActionBarSherlockCompat.this.mActivity instanceof ActionBarSherlock.OnActionModeFinishedListener) {
                ((ActionBarSherlock.OnActionModeFinishedListener) ActionBarSherlockCompat.this.mActivity).onActionModeFinished(ActionBarSherlockCompat.this.mActionMode);
            }
            ActionBarSherlockCompat.this.mActionMode = null;
        }
    }
}
