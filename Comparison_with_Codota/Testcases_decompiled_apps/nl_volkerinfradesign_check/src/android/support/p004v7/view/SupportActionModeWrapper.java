package android.support.p004v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.p001v4.internal.view.SupportMenu;
import android.support.p001v4.internal.view.SupportMenuItem;
import android.support.p001v4.util.SimpleArrayMap;
import android.support.p004v7.view.ActionMode;
import android.support.p004v7.view.menu.MenuWrapperFactory;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
/* renamed from: android.support.v7.view.SupportActionModeWrapper */
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a */
    final Context f1642a;

    /* renamed from: b */
    final ActionMode f1643b;

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f1642a = context;
        this.f1643b = actionMode;
    }

    public Object getTag() {
        return this.f1643b.getTag();
    }

    public void setTag(Object obj) {
        this.f1643b.setTag(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1643b.setTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1643b.setSubtitle(charSequence);
    }

    public void invalidate() {
        this.f1643b.invalidate();
    }

    public void finish() {
        this.f1643b.finish();
    }

    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.f1642a, (SupportMenu) this.f1643b.getMenu());
    }

    public CharSequence getTitle() {
        return this.f1643b.getTitle();
    }

    public void setTitle(int i) {
        this.f1643b.setTitle(i);
    }

    public CharSequence getSubtitle() {
        return this.f1643b.getSubtitle();
    }

    public void setSubtitle(int i) {
        this.f1643b.setSubtitle(i);
    }

    public View getCustomView() {
        return this.f1643b.getCustomView();
    }

    public void setCustomView(View view) {
        this.f1643b.setCustomView(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f1643b.getMenuInflater();
    }

    public boolean getTitleOptionalHint() {
        return this.f1643b.getTitleOptionalHint();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1643b.setTitleOptionalHint(z);
    }

    public boolean isTitleOptional() {
        return this.f1643b.isTitleOptional();
    }

    /* renamed from: android.support.v7.view.SupportActionModeWrapper$CallbackWrapper */
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a */
        final ActionMode.Callback f1644a;

        /* renamed from: b */
        final Context f1645b;

        /* renamed from: c */
        final ArrayList<SupportActionModeWrapper> f1646c = new ArrayList<>();

        /* renamed from: d */
        final SimpleArrayMap<Menu, Menu> f1647d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f1645b = context;
            this.f1644a = callback;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1644a.onCreateActionMode(getActionModeWrapper(actionMode), m2995a(menu));
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f1644a.onPrepareActionMode(getActionModeWrapper(actionMode), m2995a(menu));
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1644a.onActionItemClicked(getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(this.f1645b, (SupportMenuItem) menuItem));
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1644a.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        /* renamed from: a */
        private Menu m2995a(Menu menu) {
            Menu menu2 = this.f1647d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(this.f1645b, (SupportMenu) menu);
            this.f1647d.put(menu, wrapSupportMenu);
            return wrapSupportMenu;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.f1646c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f1646c.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f1643b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f1645b, actionMode);
            this.f1646c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }
}
