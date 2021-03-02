package android.support.p003v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p003v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.app.ActionBarImplICS */
class ActionBarImplICS extends ActionBar {
    final ActionBar mActionBar;
    FragmentTransaction mActiveTransaction;
    final Activity mActivity;
    private ArrayList<WeakReference<OnMenuVisibilityListenerWrapper>> mAddedMenuVisWrappers;
    final ActionBar.Callback mCallback;
    private ImageView mHomeActionView;

    public ActionBarImplICS(Activity activity, ActionBar.Callback callback) {
        this(activity, callback, true);
    }

    ActionBarImplICS(Activity activity, ActionBar.Callback callback, boolean checkHomeAsUpOption) {
        this.mAddedMenuVisWrappers = new ArrayList<>();
        this.mActivity = activity;
        this.mCallback = callback;
        this.mActionBar = activity.getActionBar();
        if (checkHomeAsUpOption && (getDisplayOptions() & 4) != 0) {
            setHomeButtonEnabled(true);
        }
    }

    private OnMenuVisibilityListenerWrapper findAndRemoveMenuVisWrapper(ActionBar.OnMenuVisibilityListener compatListener) {
        int i = 0;
        while (i < this.mAddedMenuVisWrappers.size()) {
            OnMenuVisibilityListenerWrapper wrapper = (OnMenuVisibilityListenerWrapper) this.mAddedMenuVisWrappers.get(i).get();
            if (wrapper == null) {
                this.mAddedMenuVisWrappers.remove(i);
                i--;
            } else if (wrapper.mWrappedListener == compatListener) {
                this.mAddedMenuVisWrappers.remove(i);
                return wrapper;
            }
            i++;
        }
        return null;
    }

    public void setCustomView(View view) {
        this.mActionBar.setCustomView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(layoutParams);
        lp.gravity = layoutParams.gravity;
        this.mActionBar.setCustomView(view, lp);
    }

    public void setCustomView(int resId) {
        this.mActionBar.setCustomView(resId);
    }

    public void setIcon(int resId) {
        this.mActionBar.setIcon(resId);
    }

    public void setIcon(Drawable icon) {
        this.mActionBar.setIcon(icon);
    }

    public void setLogo(int resId) {
        this.mActionBar.setLogo(resId);
    }

    public void setLogo(Drawable logo) {
        this.mActionBar.setLogo(logo);
    }

    public void setListNavigationCallbacks(SpinnerAdapter adapter, ActionBar.OnNavigationListener callback) {
        this.mActionBar.setListNavigationCallbacks(adapter, callback != null ? new OnNavigationListenerWrapper(callback) : null);
    }

    public void setSelectedNavigationItem(int position) {
        this.mActionBar.setSelectedNavigationItem(position);
    }

    public int getSelectedNavigationIndex() {
        return this.mActionBar.getSelectedNavigationIndex();
    }

    public int getNavigationItemCount() {
        return this.mActionBar.getNavigationItemCount();
    }

    public void setTitle(CharSequence title) {
        this.mActionBar.setTitle(title);
    }

    public void setTitle(int resId) {
        this.mActionBar.setTitle(resId);
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mActionBar.setSubtitle(subtitle);
    }

    public void setSubtitle(int resId) {
        this.mActionBar.setSubtitle(resId);
    }

    public void setDisplayOptions(int options) {
        this.mActionBar.setDisplayOptions(options);
    }

    public void setDisplayOptions(int options, int mask) {
        this.mActionBar.setDisplayOptions(options, mask);
    }

    public void setDisplayUseLogoEnabled(boolean useLogo) {
        this.mActionBar.setDisplayUseLogoEnabled(useLogo);
    }

    public void setDisplayShowHomeEnabled(boolean showHome) {
        this.mActionBar.setDisplayShowHomeEnabled(showHome);
    }

    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        this.mActionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
    }

    public void setDisplayShowTitleEnabled(boolean showTitle) {
        this.mActionBar.setDisplayShowTitleEnabled(showTitle);
    }

    public void setDisplayShowCustomEnabled(boolean showCustom) {
        this.mActionBar.setDisplayShowCustomEnabled(showCustom);
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mActionBar.setBackgroundDrawable(d);
    }

    public void setStackedBackgroundDrawable(Drawable d) {
        this.mActionBar.setStackedBackgroundDrawable(d);
    }

    public void setSplitBackgroundDrawable(Drawable d) {
        this.mActionBar.setSplitBackgroundDrawable(d);
    }

    public View getCustomView() {
        return this.mActionBar.getCustomView();
    }

    public CharSequence getTitle() {
        return this.mActionBar.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mActionBar.getSubtitle();
    }

    public int getNavigationMode() {
        return this.mActionBar.getNavigationMode();
    }

    public void setNavigationMode(int mode) {
        this.mActionBar.setNavigationMode(mode);
    }

    public int getDisplayOptions() {
        return this.mActionBar.getDisplayOptions();
    }

    public ActionBar.Tab newTab() {
        ActionBar.Tab realTab = this.mActionBar.newTab();
        TabWrapper result = new TabWrapper(realTab);
        realTab.setTag(result);
        return result;
    }

    public void addTab(ActionBar.Tab tab) {
        this.mActionBar.addTab(((TabWrapper) tab).mWrappedTab);
    }

    public void addTab(ActionBar.Tab tab, boolean setSelected) {
        this.mActionBar.addTab(((TabWrapper) tab).mWrappedTab, setSelected);
    }

    public void addTab(ActionBar.Tab tab, int position) {
        this.mActionBar.addTab(((TabWrapper) tab).mWrappedTab, position);
    }

    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        this.mActionBar.addTab(((TabWrapper) tab).mWrappedTab, position, setSelected);
    }

    public void removeTab(ActionBar.Tab tab) {
        this.mActionBar.removeTab(((TabWrapper) tab).mWrappedTab);
    }

    public void removeTabAt(int position) {
        this.mActionBar.removeTabAt(position);
    }

    public void removeAllTabs() {
        this.mActionBar.removeAllTabs();
    }

    public void selectTab(ActionBar.Tab tab) {
        this.mActionBar.selectTab(((TabWrapper) tab).mWrappedTab);
    }

    public ActionBar.Tab getSelectedTab() {
        return (ActionBar.Tab) this.mActionBar.getSelectedTab().getTag();
    }

    public ActionBar.Tab getTabAt(int index) {
        return (ActionBar.Tab) this.mActionBar.getTabAt(index).getTag();
    }

    public int getTabCount() {
        return this.mActionBar.getTabCount();
    }

    public Context getThemedContext() {
        return this.mActionBar.getThemedContext();
    }

    public void setHomeAsUpIndicator(Drawable indicator) {
        ImageView homeActionView = getHomeActionView();
        if (homeActionView != null) {
            if (indicator == null) {
                indicator = getThemeDefaultUpIndicator();
            }
            homeActionView.setImageDrawable(indicator);
        }
    }

    public void setHomeAsUpIndicator(int resId) {
        ImageView homeActionView = getHomeActionView();
        if (homeActionView == null) {
            return;
        }
        if (resId != 0) {
            homeActionView.setImageResource(resId);
        } else {
            homeActionView.setImageDrawable(getThemeDefaultUpIndicator());
        }
    }

    public int getHeight() {
        return this.mActionBar.getHeight();
    }

    public void show() {
        this.mActionBar.show();
    }

    public void hide() {
        this.mActionBar.hide();
    }

    public boolean isShowing() {
        return this.mActionBar.isShowing();
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener listener) {
        if (listener != null) {
            OnMenuVisibilityListenerWrapper w = new OnMenuVisibilityListenerWrapper(listener);
            this.mAddedMenuVisWrappers.add(new WeakReference(w));
            this.mActionBar.addOnMenuVisibilityListener(w);
        }
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener listener) {
        this.mActionBar.removeOnMenuVisibilityListener(findAndRemoveMenuVisWrapper(listener));
    }

    public void setHomeButtonEnabled(boolean enabled) {
        this.mActionBar.setHomeButtonEnabled(enabled);
    }

    /* access modifiers changed from: package-private */
    public FragmentTransaction getActiveTransaction() {
        if (this.mActiveTransaction == null) {
            this.mActiveTransaction = this.mCallback.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        return this.mActiveTransaction;
    }

    /* access modifiers changed from: package-private */
    public void commitActiveTransaction() {
        if (this.mActiveTransaction != null && !this.mActiveTransaction.isEmpty()) {
            this.mActiveTransaction.commit();
        }
        this.mActiveTransaction = null;
    }

    /* access modifiers changed from: package-private */
    public ImageView getHomeActionView() {
        View up;
        if (this.mHomeActionView == null) {
            View home = this.mActivity.findViewById(16908332);
            if (home == null) {
                return null;
            }
            ViewGroup parent = (ViewGroup) home.getParent();
            if (parent.getChildCount() != 2) {
                return null;
            }
            View first = parent.getChildAt(0);
            View second = parent.getChildAt(1);
            if (first.getId() == 16908332) {
                up = second;
            } else {
                up = first;
            }
            if (up instanceof ImageView) {
                this.mHomeActionView = (ImageView) up;
            }
        }
        return this.mHomeActionView;
    }

    /* access modifiers changed from: package-private */
    public Drawable getThemeDefaultUpIndicator() {
        TypedArray a = this.mActivity.obtainStyledAttributes(new int[]{16843531});
        Drawable result = a.getDrawable(0);
        a.recycle();
        return result;
    }

    /* renamed from: android.support.v7.app.ActionBarImplICS$OnNavigationListenerWrapper */
    static class OnNavigationListenerWrapper implements ActionBar.OnNavigationListener {
        private final ActionBar.OnNavigationListener mWrappedListener;

        public OnNavigationListenerWrapper(ActionBar.OnNavigationListener l) {
            this.mWrappedListener = l;
        }

        public boolean onNavigationItemSelected(int itemPosition, long itemId) {
            return this.mWrappedListener.onNavigationItemSelected(itemPosition, itemId);
        }
    }

    /* renamed from: android.support.v7.app.ActionBarImplICS$OnMenuVisibilityListenerWrapper */
    static class OnMenuVisibilityListenerWrapper implements ActionBar.OnMenuVisibilityListener {
        final ActionBar.OnMenuVisibilityListener mWrappedListener;

        public OnMenuVisibilityListenerWrapper(ActionBar.OnMenuVisibilityListener l) {
            this.mWrappedListener = l;
        }

        public void onMenuVisibilityChanged(boolean isVisible) {
            this.mWrappedListener.onMenuVisibilityChanged(isVisible);
        }
    }

    /* renamed from: android.support.v7.app.ActionBarImplICS$TabWrapper */
    class TabWrapper extends ActionBar.Tab implements ActionBar.TabListener {
        private CharSequence mContentDescription;
        private ActionBar.TabListener mTabListener;
        private Object mTag;
        final ActionBar.Tab mWrappedTab;

        public TabWrapper(ActionBar.Tab tab) {
            this.mWrappedTab = tab;
        }

        public int getPosition() {
            return this.mWrappedTab.getPosition();
        }

        public Drawable getIcon() {
            return this.mWrappedTab.getIcon();
        }

        public CharSequence getText() {
            return this.mWrappedTab.getText();
        }

        public ActionBar.Tab setIcon(Drawable icon) {
            this.mWrappedTab.setIcon(icon);
            return this;
        }

        public ActionBar.Tab setIcon(int resId) {
            this.mWrappedTab.setIcon(resId);
            return this;
        }

        public ActionBar.Tab setText(CharSequence text) {
            this.mWrappedTab.setText(text);
            return this;
        }

        public ActionBar.Tab setText(int resId) {
            this.mWrappedTab.setText(resId);
            return this;
        }

        public ActionBar.Tab setCustomView(View view) {
            this.mWrappedTab.setCustomView(view);
            return this;
        }

        public ActionBar.Tab setCustomView(int layoutResId) {
            this.mWrappedTab.setCustomView(layoutResId);
            return this;
        }

        public View getCustomView() {
            return this.mWrappedTab.getCustomView();
        }

        public ActionBar.Tab setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public Object getTag() {
            return this.mTag;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener listener) {
            this.mTabListener = listener;
            this.mWrappedTab.setTabListener(listener != null ? this : null);
            return this;
        }

        public void select() {
            this.mWrappedTab.select();
        }

        public ActionBar.Tab setContentDescription(int resId) {
            this.mContentDescription = ActionBarImplICS.this.mActivity.getText(resId);
            return this;
        }

        public ActionBar.Tab setContentDescription(CharSequence contentDesc) {
            this.mContentDescription = contentDesc;
            return this;
        }

        public CharSequence getContentDescription() {
            return this.mContentDescription;
        }

        public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
            this.mTabListener.onTabSelected(this, ft != null ? ActionBarImplICS.this.getActiveTransaction() : null);
            ActionBarImplICS.this.commitActiveTransaction();
        }

        public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
            this.mTabListener.onTabUnselected(this, ft != null ? ActionBarImplICS.this.getActiveTransaction() : null);
        }

        public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
            this.mTabListener.onTabReselected(this, ft != null ? ActionBarImplICS.this.getActiveTransaction() : null);
            ActionBarImplICS.this.commitActiveTransaction();
        }
    }
}
