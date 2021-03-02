package android.support.p003v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.app.NavUtils;
import android.support.p000v4.view.LayoutInflaterCompat;
import android.support.p000v4.view.LayoutInflaterFactory;
import android.support.p000v4.view.OnApplyWindowInsetsListener;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewConfigurationCompat;
import android.support.p000v4.view.WindowInsetsCompat;
import android.support.p003v7.appcompat.C0137R;
import android.support.p003v7.internal.app.AppCompatViewInflater;
import android.support.p003v7.internal.app.ToolbarActionBar;
import android.support.p003v7.internal.app.WindowDecorActionBar;
import android.support.p003v7.internal.view.ContextThemeWrapper;
import android.support.p003v7.internal.view.menu.ListMenuPresenter;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.internal.widget.ActionBarContextView;
import android.support.p003v7.internal.widget.ContentFrameLayout;
import android.support.p003v7.internal.widget.DecorContentParent;
import android.support.p003v7.internal.widget.FitWindowsViewGroup;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.ViewUtils;
import android.support.p003v7.view.ActionMode;
import android.support.p003v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* renamed from: android.support.v7.app.AppCompatDelegateImplV7 */
class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase implements LayoutInflaterFactory, MenuBuilder.Callback {
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private AppCompatViewInflater mAppCompatViewInflater;
    private boolean mClosingActionMenu;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    /* access modifiers changed from: private */
    public int mInvalidatePanelMenuFeatures;
    /* access modifiers changed from: private */
    public boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable = new Runnable() {
        public void run() {
            if ((AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures & 1) != 0) {
                AppCompatDelegateImplV7.this.doInvalidatePanelMenu(0);
            }
            if ((AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures & 256) != 0) {
                AppCompatDelegateImplV7.this.doInvalidatePanelMenu(8);
            }
            boolean unused = AppCompatDelegateImplV7.this.mInvalidatePanelMenuPosted = false;
            int unused2 = AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures = 0;
        }
    };
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    private ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private TextView mTitleView;
    private ViewGroup mWindowDecor;

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ActionMenuPresenterCallback */
    final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private ActionMenuPresenterCallback() {
        }

        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImplV7.this.checkCloseActionMenu(menuBuilder);
        }

        public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback windowCallback = AppCompatDelegateImplV7.this.getWindowCallback();
            if (windowCallback == null) {
                return true;
            }
            windowCallback.onMenuOpened(8, menuBuilder);
            return true;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapperV7 */
    class ActionModeCallbackWrapperV7 implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapperV7(ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            if (AppCompatDelegateImplV7.this.mActionModePopup != null) {
                AppCompatDelegateImplV7.this.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.mShowActionModePopup);
                AppCompatDelegateImplV7.this.mActionModePopup.dismiss();
            } else if (AppCompatDelegateImplV7.this.mActionModeView != null) {
                AppCompatDelegateImplV7.this.mActionModeView.setVisibility(8);
                if (AppCompatDelegateImplV7.this.mActionModeView.getParent() != null) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV7.this.mActionModeView.getParent());
                }
            }
            if (AppCompatDelegateImplV7.this.mActionModeView != null) {
                AppCompatDelegateImplV7.this.mActionModeView.removeAllViews();
            }
            if (AppCompatDelegateImplV7.this.mAppCompatCallback != null) {
                AppCompatDelegateImplV7.this.mAppCompatCallback.onSupportActionModeFinished(AppCompatDelegateImplV7.this.mActionMode);
            }
            AppCompatDelegateImplV7.this.mActionMode = null;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ListMenuDecorView */
    class ListMenuDecorView extends FrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean isOutOfBounds(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV7.this.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !isOutOfBounds((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImplV7.this.closePanel(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(TintManager.getDrawable(getContext(), i));
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState */
    final class PanelFeatureState {
        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView = false;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;

        /* renamed from: x */
        int f10x;

        /* renamed from: y */
        int f11y;

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState$SavedState */
        class SavedState implements Parcelable {
            public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
                public final SavedState createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel);
                }

                public final SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            int featureId;
            boolean isOpen;
            Bundle menuState;

            private SavedState() {
            }

            /* access modifiers changed from: private */
            public static SavedState readFromParcel(Parcel parcel) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.isOpen = z;
                if (savedState.isOpen) {
                    savedState.menuState = parcel.readBundle();
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }
        }

        PanelFeatureState(int i) {
            this.featureId = i;
        }

        /* access modifiers changed from: package-private */
        public final void applyFrozenState() {
            if (this.menu != null && this.frozenMenuState != null) {
                this.menu.restorePresenterStates(this.frozenMenuState);
                this.frozenMenuState = null;
            }
        }

        public final void clearMenuPresenters() {
            if (this.menu != null) {
                this.menu.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        /* access modifiers changed from: package-private */
        public final MenuView getListMenuView(MenuPresenter.Callback callback) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, C0137R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter.setCallback(callback);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public final boolean hasPanelItems() {
            if (this.shownPanelView == null) {
                return false;
            }
            if (this.createdPanelView != null) {
                return true;
            }
            return this.listMenuPresenter.getAdapter().getCount() > 0;
        }

        /* access modifiers changed from: package-private */
        public final void onRestoreInstanceState(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            this.featureId = savedState.featureId;
            this.wasLastOpen = savedState.isOpen;
            this.frozenMenuState = savedState.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        /* access modifiers changed from: package-private */
        public final Parcelable onSaveInstanceState() {
            SavedState savedState = new SavedState();
            savedState.featureId = this.featureId;
            savedState.isOpen = this.isOpen;
            if (this.menu != null) {
                savedState.menuState = new Bundle();
                this.menu.savePresenterStates(savedState.menuState);
            }
            return savedState;
        }

        /* access modifiers changed from: package-private */
        public final void setMenu(MenuBuilder menuBuilder) {
            if (menuBuilder != this.menu) {
                if (this.menu != null) {
                    this.menu.removeMenuPresenter(this.listMenuPresenter);
                }
                this.menu = menuBuilder;
                if (menuBuilder != null && this.listMenuPresenter != null) {
                    menuBuilder.addMenuPresenter(this.listMenuPresenter);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void setStyle(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0137R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0137R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0137R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.listPresenterContext = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(C0137R.styleable.Theme);
            this.background = obtainStyledAttributes.getResourceId(C0137R.styleable.Theme_panelBackground, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(C0137R.styleable.Theme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelMenuPresenterCallback */
    final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        private PanelMenuPresenterCallback() {
        }

        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState access$600 = appCompatDelegateImplV7.findMenuPanel(menuBuilder);
            if (access$600 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV7.this.callOnPanelClosed(access$600.featureId, access$600, rootMenu);
                AppCompatDelegateImplV7.this.closePanel(access$600, true);
                return;
            }
            AppCompatDelegateImplV7.this.closePanel(access$600, z);
        }

        public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback windowCallback;
            if (menuBuilder != null || !AppCompatDelegateImplV7.this.mHasActionBar || (windowCallback = AppCompatDelegateImplV7.this.getWindowCallback()) == null || AppCompatDelegateImplV7.this.isDestroyed()) {
                return true;
            }
            windowCallback.onMenuOpened(8, menuBuilder);
            return true;
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    private void applyFixedSizeWindow(ContentFrameLayout contentFrameLayout) {
        contentFrameLayout.setDecorPadding(this.mWindowDecor.getPaddingLeft(), this.mWindowDecor.getPaddingTop(), this.mWindowDecor.getPaddingRight(), this.mWindowDecor.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(C0137R.styleable.Theme);
        obtainStyledAttributes.getValue(C0137R.styleable.Theme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0137R.styleable.Theme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0137R.styleable.Theme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0137R.styleable.Theme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0137R.styleable.Theme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0137R.styleable.Theme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0137R.styleable.Theme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0137R.styleable.Theme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0137R.styleable.Theme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0137R.styleable.Theme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* access modifiers changed from: private */
    public void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, Menu menu) {
        Window.Callback windowCallback;
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.mPanels.length) {
                panelFeatureState = this.mPanels[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && (windowCallback = getWindowCallback()) != null) {
            windowCallback.onPanelClosed(i, menu);
        }
    }

    /* access modifiers changed from: private */
    public void checkCloseActionMenu(MenuBuilder menuBuilder) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.mDecorContentParent.dismissPopups();
            Window.Callback windowCallback = getWindowCallback();
            if (windowCallback != null && !isDestroyed()) {
                windowCallback.onPanelClosed(8, menuBuilder);
            }
            this.mClosingActionMenu = false;
        }
    }

    /* access modifiers changed from: private */
    public void closePanel(int i) {
        closePanel(getPanelState(i, true), true);
    }

    /* access modifiers changed from: private */
    public void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        if (!z || panelFeatureState.featureId != 0 || this.mDecorContentParent == null || !this.mDecorContentParent.isOverflowMenuShowing()) {
            boolean z2 = panelFeatureState.isOpen;
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (!(windowManager == null || !z2 || panelFeatureState.decorView == null)) {
                windowManager.removeView(panelFeatureState.decorView);
            }
            panelFeatureState.isPrepared = false;
            panelFeatureState.isHandled = false;
            panelFeatureState.isOpen = false;
            if (z2 && z) {
                callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, (Menu) null);
            }
            panelFeatureState.shownPanelView = null;
            panelFeatureState.refreshDecorView = true;
            if (this.mPreparedPanel == panelFeatureState) {
                this.mPreparedPanel = null;
                return;
            }
            return;
        }
        checkCloseActionMenu(panelFeatureState.menu);
    }

    /* access modifiers changed from: private */
    public void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState;
        PanelFeatureState panelState2 = getPanelState(i, true);
        if (panelState2.menu != null) {
            Bundle bundle = new Bundle();
            panelState2.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState2.frozenActionViewState = bundle;
            }
            panelState2.menu.stopDispatchingItemsChanged();
            panelState2.menu.clear();
        }
        panelState2.refreshMenuContent = true;
        panelState2.refreshDecorView = true;
        if ((i == 8 || i == 0) && this.mDecorContentParent != null && (panelState = getPanelState(0, false)) != null) {
            panelState.isPrepared = false;
            preparePanel(panelState, (KeyEvent) null);
        }
    }

    private void ensureSubDecor() {
        if (!this.mSubDecorInstalled) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            if (this.mWindowNoTitle) {
                if (this.mOverlayActionMode) {
                    this.mSubDecor = (ViewGroup) from.inflate(C0137R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    this.mSubDecor = (ViewGroup) from.inflate(C0137R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    ViewCompat.setOnApplyWindowInsetsListener(this.mSubDecor, new OnApplyWindowInsetsListener() {
                        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                            int access$300 = AppCompatDelegateImplV7.this.updateStatusGuard(systemWindowInsetTop);
                            if (systemWindowInsetTop != access$300) {
                                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), access$300, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                            }
                            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                        }
                    });
                } else {
                    ((FitWindowsViewGroup) this.mSubDecor).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() {
                        public void onFitSystemWindows(Rect rect) {
                            rect.top = AppCompatDelegateImplV7.this.updateStatusGuard(rect.top);
                        }
                    });
                }
            } else if (this.mIsFloating) {
                this.mSubDecor = (ViewGroup) from.inflate(C0137R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.mOverlayActionBar = false;
                this.mHasActionBar = false;
            } else if (this.mHasActionBar) {
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(C0137R.attr.actionBarTheme, typedValue, true);
                this.mSubDecor = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(this.mContext, typedValue.resourceId) : this.mContext).inflate(C0137R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.mDecorContentParent = (DecorContentParent) this.mSubDecor.findViewById(C0137R.C0139id.decor_content_parent);
                this.mDecorContentParent.setWindowCallback(getWindowCallback());
                if (this.mOverlayActionBar) {
                    this.mDecorContentParent.initFeature(9);
                }
                if (this.mFeatureProgress) {
                    this.mDecorContentParent.initFeature(2);
                }
                if (this.mFeatureIndeterminateProgress) {
                    this.mDecorContentParent.initFeature(5);
                }
            }
            if (this.mSubDecor == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features");
            }
            if (this.mDecorContentParent == null) {
                this.mTitleView = (TextView) this.mSubDecor.findViewById(C0137R.C0139id.title);
            }
            ViewUtils.makeOptionalFitsSystemWindows(this.mSubDecor);
            ViewGroup viewGroup = (ViewGroup) this.mWindow.findViewById(16908290);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.mSubDecor.findViewById(C0137R.C0139id.action_bar_activity_content);
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            this.mWindow.setContentView(this.mSubDecor);
            viewGroup.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground((Drawable) null);
            }
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                onTitleChanged(title);
            }
            applyFixedSizeWindow(contentFrameLayout);
            onSubDecorInstalled(this.mSubDecor);
            this.mSubDecorInstalled = true;
            PanelFeatureState panelState = getPanelState(0, false);
            if (isDestroyed()) {
                return;
            }
            if (panelState == null || panelState.menu == null) {
                invalidatePanelMenu(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public PanelFeatureState findMenuPanel(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private PanelFeatureState getPanelState(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean initializePanelContent(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.createdPanelView != null) {
            panelFeatureState.shownPanelView = panelFeatureState.createdPanelView;
            return true;
        } else if (panelFeatureState.menu == null) {
            return false;
        } else {
            if (this.mPanelMenuPresenterCallback == null) {
                this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
            }
            panelFeatureState.shownPanelView = (View) panelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
            return panelFeatureState.shownPanelView != null;
        }
    }

    private boolean initializePanelDecor(PanelFeatureState panelFeatureState) {
        panelFeatureState.setStyle(getActionBarThemedContext());
        panelFeatureState.decorView = new ListMenuDecorView(panelFeatureState.listPresenterContext);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState panelFeatureState) {
        Context context;
        Context context2 = this.mContext;
        if ((panelFeatureState.featureId == 0 || panelFeatureState.featureId == 8) && this.mDecorContentParent != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context2.getTheme();
            theme.resolveAttribute(C0137R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context2.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0137R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0137R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context2.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Resources.Theme theme3 = theme2;
            if (theme3 != null) {
                context = new ContextThemeWrapper(context2, 0);
                context.getTheme().setTo(theme3);
                MenuBuilder menuBuilder = new MenuBuilder(context);
                menuBuilder.setCallback(this);
                panelFeatureState.setMenu(menuBuilder);
                return true;
            }
        }
        context = context2;
        MenuBuilder menuBuilder2 = new MenuBuilder(context);
        menuBuilder2.setCallback(this);
        panelFeatureState.setMenu(menuBuilder2);
        return true;
    }

    private void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures |= 1 << i;
        if (!this.mInvalidatePanelMenuPosted && this.mWindowDecor != null) {
            ViewCompat.postOnAnimation(this.mWindowDecor, this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    private boolean onKeyDownPanel(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState panelState = getPanelState(i, true);
            if (!panelState.isOpen) {
                return preparePanel(panelState, keyEvent);
            }
        }
        return false;
    }

    private boolean onKeyUpPanel(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2 = true;
        if (this.mActionMode != null) {
            return false;
        }
        PanelFeatureState panelState = getPanelState(i, true);
        if (i != 0 || this.mDecorContentParent == null || !this.mDecorContentParent.canShowOverflowMenu() || ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
            if (panelState.isOpen || panelState.isHandled) {
                boolean z3 = panelState.isOpen;
                closePanel(panelState, true);
                z2 = z3;
            } else {
                if (panelState.isPrepared) {
                    if (panelState.refreshMenuContent) {
                        panelState.isPrepared = false;
                        z = preparePanel(panelState, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        openPanel(panelState, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (!this.mDecorContentParent.isOverflowMenuShowing()) {
            if (!isDestroyed() && preparePanel(panelState, keyEvent)) {
                z2 = this.mDecorContentParent.showOverflowMenu();
            }
            z2 = false;
        } else {
            z2 = this.mDecorContentParent.hideOverflowMenu();
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    private void openPanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (!panelFeatureState.isOpen && !isDestroyed()) {
            if (panelFeatureState.featureId == 0) {
                Context context = this.mContext;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Window.Callback windowCallback = getWindowCallback();
            if (windowCallback == null || windowCallback.onMenuOpened(panelFeatureState.featureId, panelFeatureState.menu)) {
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null && preparePanel(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.decorView == null || panelFeatureState.refreshDecorView) {
                        if (panelFeatureState.decorView == null) {
                            if (!initializePanelDecor(panelFeatureState) || panelFeatureState.decorView == null) {
                                return;
                            }
                        } else if (panelFeatureState.refreshDecorView && panelFeatureState.decorView.getChildCount() > 0) {
                            panelFeatureState.decorView.removeAllViews();
                        }
                        if (initializePanelContent(panelFeatureState) && panelFeatureState.hasPanelItems()) {
                            ViewGroup.LayoutParams layoutParams2 = panelFeatureState.shownPanelView.getLayoutParams();
                            ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                            panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                            ViewParent parent = panelFeatureState.shownPanelView.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                            }
                            panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams3);
                            if (!panelFeatureState.shownPanelView.hasFocus()) {
                                panelFeatureState.shownPanelView.requestFocus();
                            }
                            i = -2;
                        } else {
                            return;
                        }
                    } else if (panelFeatureState.createdPanelView == null || (layoutParams = panelFeatureState.createdPanelView.getLayoutParams()) == null || layoutParams.width != -1) {
                        i = -2;
                    }
                    panelFeatureState.isHandled = false;
                    WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f10x, panelFeatureState.f11y, 1002, 8519680, -3);
                    layoutParams4.gravity = panelFeatureState.gravity;
                    layoutParams4.windowAnimations = panelFeatureState.windowAnimations;
                    windowManager.addView(panelFeatureState.decorView, layoutParams4);
                    panelFeatureState.isOpen = true;
                    return;
                }
                return;
            }
            closePanel(panelFeatureState, true);
        }
    }

    private boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && panelFeatureState.menu != null) {
                z = panelFeatureState.menu.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.mDecorContentParent == null) {
                closePanel(panelFeatureState, true);
            }
        }
        return z;
    }

    private boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (isDestroyed()) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        if (!(this.mPreparedPanel == null || this.mPreparedPanel == panelFeatureState)) {
            closePanel(this.mPreparedPanel, false);
        }
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null) {
            panelFeatureState.createdPanelView = windowCallback.onCreatePanelView(panelFeatureState.featureId);
        }
        boolean z = panelFeatureState.featureId == 0 || panelFeatureState.featureId == 8;
        if (z && this.mDecorContentParent != null) {
            this.mDecorContentParent.setMenuPrepared();
        }
        if (panelFeatureState.createdPanelView == null && (!z || !(peekSupportActionBar() instanceof ToolbarActionBar))) {
            if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                if (panelFeatureState.menu == null && (!initializePanelMenu(panelFeatureState) || panelFeatureState.menu == null)) {
                    return false;
                }
                if (z && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
                    }
                    this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!windowCallback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                    panelFeatureState.setMenu((MenuBuilder) null);
                    if (!z || this.mDecorContentParent == null) {
                        return false;
                    }
                    this.mDecorContentParent.setMenu((Menu) null, this.mActionMenuPresenterCallback);
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            if (panelFeatureState.frozenActionViewState != null) {
                panelFeatureState.menu.restoreActionViewStates(panelFeatureState.frozenActionViewState);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (z && this.mDecorContentParent != null) {
                    this.mDecorContentParent.setMenu((Menu) null, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.menu.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    private void reopenMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.mDecorContentParent == null || !this.mDecorContentParent.canShowOverflowMenu() || (ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            PanelFeatureState panelState = getPanelState(0, true);
            panelState.refreshDecorView = true;
            closePanel(panelState, false);
            openPanel(panelState, (KeyEvent) null);
            return;
        }
        Window.Callback windowCallback = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() && z) {
            this.mDecorContentParent.hideOverflowMenu();
            if (!isDestroyed()) {
                windowCallback.onPanelClosed(8, getPanelState(0, true).menu);
            }
        } else if (windowCallback != null && !isDestroyed()) {
            if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
                this.mWindowDecor.removeCallbacks(this.mInvalidatePanelMenuRunnable);
                this.mInvalidatePanelMenuRunnable.run();
            }
            PanelFeatureState panelState2 = getPanelState(0, true);
            if (panelState2.menu != null && !panelState2.refreshMenuContent && windowCallback.onPreparePanel(0, panelState2.createdPanelView, panelState2.menu)) {
                windowCallback.onMenuOpened(8, panelState2.menu);
                this.mDecorContentParent.showOverflowMenu();
            }
        }
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* access modifiers changed from: private */
    public int updateStatusGuard(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i2 = 0;
        if (this.mActionModeView == null || !(this.mActionModeView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect = this.mTempRect1;
                Rect rect2 = this.mTempRect2;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.mSubDecor, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.mStatusGuard == null) {
                        this.mStatusGuard = new View(this.mContext);
                        this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(C0137R.color.abc_input_method_navigation_guard));
                        this.mSubDecor.addView(this.mStatusGuard, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.mStatusGuard.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.mStatusGuard.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                if (this.mStatusGuard == null) {
                    z4 = false;
                }
                if (!this.mOverlayActionMode && z4) {
                    i = 0;
                }
                boolean z5 = z3;
                z2 = z4;
                z4 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z4 = false;
                z2 = false;
            }
            if (z4) {
                this.mActionModeView.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.mStatusGuard != null) {
            View view = this.mStatusGuard;
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        return i;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(16908290)).addView(view, layoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public View callActivityOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        if (!(this.mOriginalWindowCallback instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.mOriginalWindowCallback).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    public ActionBar createSupportActionBar() {
        ensureSubDecor();
        WindowDecorActionBar windowDecorActionBar = null;
        if (this.mOriginalWindowCallback instanceof Activity) {
            windowDecorActionBar = new WindowDecorActionBar((Activity) this.mOriginalWindowCallback, this.mOverlayActionBar);
        } else if (this.mOriginalWindowCallback instanceof Dialog) {
            windowDecorActionBar = new WindowDecorActionBar((Dialog) this.mOriginalWindowCallback);
        }
        if (windowDecorActionBar != null) {
            windowDecorActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        }
        return windowDecorActionBar;
    }

    public View createView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = Build.VERSION.SDK_INT < 21;
        if (this.mAppCompatViewInflater == null) {
            this.mAppCompatViewInflater = new AppCompatViewInflater();
        }
        return this.mAppCompatViewInflater.createView(view, str, context, attributeSet, z && this.mSubDecorInstalled && view != null && view.getId() != 16908290 && !ViewCompat.isAttachedToWindow(view), z, true);
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory(from, this);
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onBackPressed() {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.mHasActionBar && this.mSubDecorInstalled && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWindowDecor = (ViewGroup) this.mWindow.getDecorView();
        if ((this.mOriginalWindowCallback instanceof Activity) && NavUtils.getParentActivityName((Activity) this.mOriginalWindowCallback) != null) {
            ActionBar peekSupportActionBar = peekSupportActionBar();
            if (peekSupportActionBar == null) {
                this.mEnableDefaultActionBarUp = true;
            } else {
                peekSupportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View callActivityOnCreateView = callActivityOnCreateView(view, str, context, attributeSet);
        return callActivityOnCreateView != null ? callActivityOnCreateView : createView(view, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case C0137R.styleable.Theme_colorPrimaryDark:
                if (onKeyDownPanel(0, keyEvent)) {
                    return true;
                }
                break;
        }
        if (Build.VERSION.SDK_INT < 11) {
            return onKeyShortcut(i, keyEvent);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.mPreparedPanel == null || !performPanelShortcut(this.mPreparedPanel, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.mPreparedPanel == null) {
                PanelFeatureState panelState = getPanelState(0, true);
                preparePanel(panelState, keyEvent);
                boolean performPanelShortcut = performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent, 1);
                panelState.isPrepared = false;
                if (performPanelShortcut) {
                    return true;
                }
            }
            return false;
        } else if (this.mPreparedPanel == null) {
            return true;
        } else {
            this.mPreparedPanel.isHandled = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                PanelFeatureState panelState = getPanelState(0, false);
                if (panelState != null && panelState.isOpen) {
                    closePanel(panelState, true);
                    return true;
                } else if (onBackPressed()) {
                    return true;
                }
                break;
            case C0137R.styleable.Theme_colorPrimaryDark:
                if (onKeyUpPanel(0, keyEvent)) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState findMenuPanel;
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback == null || isDestroyed() || (findMenuPanel = findMenuPanel(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return windowCallback.onMenuItemSelected(findMenuPanel.featureId, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        reopenMenu(menuBuilder, true);
    }

    /* access modifiers changed from: package-private */
    public boolean onMenuOpened(int i, Menu menu) {
        if (i != 8) {
            return false;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return true;
        }
        supportActionBar.dispatchMenuVisibilityChanged(true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean onPanelClosed(int i, Menu menu) {
        if (i == 8) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                return true;
            }
            supportActionBar.dispatchMenuVisibilityChanged(false);
            return true;
        }
        if (i == 0) {
            PanelFeatureState panelState = getPanelState(i, true);
            if (panelState.isOpen) {
                closePanel(panelState, false);
            }
        }
        return false;
    }

    public void onPostCreate(Bundle bundle) {
        ensureSubDecor();
    }

    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void onSubDecorInstalled(ViewGroup viewGroup) {
    }

    /* access modifiers changed from: package-private */
    public void onTitleChanged(CharSequence charSequence) {
        if (this.mDecorContentParent != null) {
            this.mDecorContentParent.setWindowTitle(charSequence);
        } else if (peekSupportActionBar() != null) {
            peekSupportActionBar().setWindowTitle(charSequence);
        } else if (this.mTitleView != null) {
            this.mTitleView.setText(charSequence);
        }
    }

    public boolean requestWindowFeature(int i) {
        switch (i) {
            case 1:
                throwFeatureRequestIfSubDecorInstalled();
                this.mWindowNoTitle = true;
                return true;
            case 2:
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureProgress = true;
                return true;
            case 5:
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureIndeterminateProgress = true;
                return true;
            case 8:
                throwFeatureRequestIfSubDecorInstalled();
                this.mHasActionBar = true;
                return true;
            case 9:
                throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionBar = true;
                return true;
            case 10:
                throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionMode = true;
                return true;
            default:
                return this.mWindow.requestFeature(i);
        }
    }

    public void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (this.mOriginalWindowCallback instanceof Activity) {
            if (getSupportActionBar() instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, ((Activity) this.mContext).getTitle(), this.mAppCompatWindowCallback);
            setSupportActionBar(toolbarActionBar);
            this.mWindow.setCallback(toolbarActionBar.getWrappedWindowCallback());
            toolbarActionBar.invalidateOptionsMenu();
        }
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionModeCallbackWrapperV7 actionModeCallbackWrapperV7 = new ActionModeCallbackWrapperV7(callback);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.mActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV7);
            if (!(this.mActionMode == null || this.mAppCompatCallback == null)) {
                this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
            }
        }
        if (this.mActionMode == null) {
            this.mActionMode = startSupportActionModeFromWindow(actionModeCallbackWrapperV7);
        }
        return this.mActionMode;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.support.p003v7.view.ActionMode startSupportActionModeFromWindow(android.support.p003v7.view.ActionMode.Callback r9) {
        /*
            r8 = this;
            r3 = 0
            r2 = 0
            r1 = 1
            android.support.v7.view.ActionMode r0 = r8.mActionMode
            if (r0 == 0) goto L_0x000c
            android.support.v7.view.ActionMode r0 = r8.mActionMode
            r0.finish()
        L_0x000c:
            android.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapperV7 r4 = new android.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapperV7
            r4.<init>(r9)
            android.support.v7.app.AppCompatCallback r0 = r8.mAppCompatCallback
            if (r0 == 0) goto L_0x0038
            boolean r0 = r8.isDestroyed()
            if (r0 != 0) goto L_0x0038
            android.support.v7.app.AppCompatCallback r0 = r8.mAppCompatCallback     // Catch:{ AbstractMethodError -> 0x0037 }
            android.support.v7.view.ActionMode r0 = r0.onWindowStartingSupportActionMode(r4)     // Catch:{ AbstractMethodError -> 0x0037 }
        L_0x0021:
            if (r0 == 0) goto L_0x003a
            r8.mActionMode = r0
        L_0x0025:
            android.support.v7.view.ActionMode r0 = r8.mActionMode
            if (r0 == 0) goto L_0x0034
            android.support.v7.app.AppCompatCallback r0 = r8.mAppCompatCallback
            if (r0 == 0) goto L_0x0034
            android.support.v7.app.AppCompatCallback r0 = r8.mAppCompatCallback
            android.support.v7.view.ActionMode r1 = r8.mActionMode
            r0.onSupportActionModeStarted(r1)
        L_0x0034:
            android.support.v7.view.ActionMode r0 = r8.mActionMode
            return r0
        L_0x0037:
            r0 = move-exception
        L_0x0038:
            r0 = r3
            goto L_0x0021
        L_0x003a:
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            if (r0 != 0) goto L_0x00bc
            boolean r0 = r8.mIsFloating
            if (r0 == 0) goto L_0x011f
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            android.content.Context r0 = r8.mContext
            android.content.res.Resources$Theme r0 = r0.getTheme()
            int r6 = android.support.p003v7.appcompat.C0137R.attr.actionBarTheme
            r0.resolveAttribute(r6, r5, r1)
            int r6 = r5.resourceId
            if (r6 == 0) goto L_0x011b
            android.content.Context r6 = r8.mContext
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Resources$Theme r6 = r6.newTheme()
            r6.setTo(r0)
            int r0 = r5.resourceId
            r6.applyStyle(r0, r1)
            android.support.v7.internal.view.ContextThemeWrapper r0 = new android.support.v7.internal.view.ContextThemeWrapper
            android.content.Context r7 = r8.mContext
            r0.<init>(r7, r2)
            android.content.res.Resources$Theme r7 = r0.getTheme()
            r7.setTo(r6)
        L_0x0076:
            android.support.v7.internal.widget.ActionBarContextView r6 = new android.support.v7.internal.widget.ActionBarContextView
            r6.<init>(r0)
            r8.mActionModeView = r6
            android.widget.PopupWindow r6 = new android.widget.PopupWindow
            int r7 = android.support.p003v7.appcompat.C0137R.attr.actionModePopupWindowStyle
            r6.<init>(r0, r3, r7)
            r8.mActionModePopup = r6
            android.widget.PopupWindow r6 = r8.mActionModePopup
            android.support.v7.internal.widget.ActionBarContextView r7 = r8.mActionModeView
            r6.setContentView(r7)
            android.widget.PopupWindow r6 = r8.mActionModePopup
            r7 = -1
            r6.setWidth(r7)
            android.content.res.Resources$Theme r6 = r0.getTheme()
            int r7 = android.support.p003v7.appcompat.C0137R.attr.actionBarSize
            r6.resolveAttribute(r7, r5, r1)
            int r5 = r5.data
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r5, r0)
            android.support.v7.internal.widget.ActionBarContextView r5 = r8.mActionModeView
            r5.setContentHeight(r0)
            android.widget.PopupWindow r0 = r8.mActionModePopup
            r5 = -2
            r0.setHeight(r5)
            android.support.v7.app.AppCompatDelegateImplV7$4 r0 = new android.support.v7.app.AppCompatDelegateImplV7$4
            r0.<init>()
            r8.mShowActionModePopup = r0
        L_0x00bc:
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            if (r0 == 0) goto L_0x0025
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            r0.killMode()
            android.support.v7.internal.view.StandaloneActionMode r5 = new android.support.v7.internal.view.StandaloneActionMode
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            android.content.Context r6 = r0.getContext()
            android.support.v7.internal.widget.ActionBarContextView r7 = r8.mActionModeView
            android.widget.PopupWindow r0 = r8.mActionModePopup
            if (r0 != 0) goto L_0x0140
            r0 = r1
        L_0x00d4:
            r5.<init>(r6, r7, r4, r0)
            android.view.Menu r0 = r5.getMenu()
            boolean r0 = r9.onCreateActionMode(r5, r0)
            if (r0 == 0) goto L_0x0142
            r5.invalidate()
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            r0.initForMode(r5)
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            r0.setVisibility(r2)
            r8.mActionMode = r5
            android.widget.PopupWindow r0 = r8.mActionModePopup
            if (r0 == 0) goto L_0x00ff
            android.view.Window r0 = r8.mWindow
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r8.mShowActionModePopup
            r0.post(r1)
        L_0x00ff:
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            r1 = 32
            r0.sendAccessibilityEvent(r1)
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0025
            android.support.v7.internal.widget.ActionBarContextView r0 = r8.mActionModeView
            android.view.ViewParent r0 = r0.getParent()
            android.view.View r0 = (android.view.View) r0
            android.support.p000v4.view.ViewCompat.requestApplyInsets(r0)
            goto L_0x0025
        L_0x011b:
            android.content.Context r0 = r8.mContext
            goto L_0x0076
        L_0x011f:
            android.view.ViewGroup r0 = r8.mSubDecor
            int r5 = android.support.p003v7.appcompat.C0137R.C0139id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r5)
            android.support.v7.internal.widget.ViewStubCompat r0 = (android.support.p003v7.internal.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00bc
            android.content.Context r5 = r8.getActionBarThemedContext()
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            r0.setLayoutInflater(r5)
            android.view.View r0 = r0.inflate()
            android.support.v7.internal.widget.ActionBarContextView r0 = (android.support.p003v7.internal.widget.ActionBarContextView) r0
            r8.mActionModeView = r0
            goto L_0x00bc
        L_0x0140:
            r0 = r2
            goto L_0x00d4
        L_0x0142:
            r8.mActionMode = r3
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.app.AppCompatDelegateImplV7.startSupportActionModeFromWindow(android.support.v7.view.ActionMode$Callback):android.support.v7.view.ActionMode");
    }
}
