package android.support.p003v7.internal.view;

import android.content.Context;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.util.SimpleArrayMap;
import android.support.p003v7.internal.view.menu.MenuWrapperFactory;
import android.support.p003v7.view.ActionMode;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.SupportActionModeWrapper */
public class SupportActionModeWrapper extends ActionMode {
    final Context mContext;
    final android.support.p003v7.view.ActionMode mWrappedObject;

    /* renamed from: android.support.v7.internal.view.SupportActionModeWrapper$CallbackWrapper */
    public class CallbackWrapper implements ActionMode.Callback {
        final ArrayList mActionModes = new ArrayList();
        final Context mContext;
        final SimpleArrayMap mMenus = new SimpleArrayMap();
        final ActionMode.Callback mWrappedCallback;

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.mContext = context;
            this.mWrappedCallback = callback;
        }

        private Menu getMenuWrapper(Menu menu) {
            Menu menu2 = (Menu) this.mMenus.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) menu);
            this.mMenus.put(menu, wrapSupportMenu);
            return wrapSupportMenu;
        }

        public android.view.ActionMode getActionModeWrapper(android.support.p003v7.view.ActionMode actionMode) {
            int size = this.mActionModes.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) this.mActionModes.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
            this.mActionModes.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        public boolean onActionItemClicked(android.support.p003v7.view.ActionMode actionMode, MenuItem menuItem) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem) menuItem));
        }

        public boolean onCreateActionMode(android.support.p003v7.view.ActionMode actionMode, Menu menu) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
        }

        public void onDestroyActionMode(android.support.p003v7.view.ActionMode actionMode) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        public boolean onPrepareActionMode(android.support.p003v7.view.ActionMode actionMode, Menu menu) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
        }
    }

    public SupportActionModeWrapper(Context context, android.support.p003v7.view.ActionMode actionMode) {
        this.mContext = context;
        this.mWrappedObject = actionMode;
    }

    public void finish() {
        this.mWrappedObject.finish();
    }

    public View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) this.mWrappedObject.getMenu());
    }

    public MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }

    public CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    public Object getTag() {
        return this.mWrappedObject.getTag();
    }

    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    public void invalidate() {
        this.mWrappedObject.invalidate();
    }

    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    public void setCustomView(View view) {
        this.mWrappedObject.setCustomView(view);
    }

    public void setSubtitle(int i) {
        this.mWrappedObject.setSubtitle(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mWrappedObject.setSubtitle(charSequence);
    }

    public void setTag(Object obj) {
        this.mWrappedObject.setTag(obj);
    }

    public void setTitle(int i) {
        this.mWrappedObject.setTitle(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.mWrappedObject.setTitleOptionalHint(z);
    }
}
