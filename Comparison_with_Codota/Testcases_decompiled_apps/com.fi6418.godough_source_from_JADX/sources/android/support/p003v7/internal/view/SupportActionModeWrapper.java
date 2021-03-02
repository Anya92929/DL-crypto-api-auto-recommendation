package android.support.p003v7.internal.view;

import android.annotation.TargetApi;
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

@TargetApi(11)
/* renamed from: android.support.v7.internal.view.SupportActionModeWrapper */
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a */
    final Context f1983a;

    /* renamed from: b */
    final android.support.p003v7.view.ActionMode f1984b;

    /* renamed from: android.support.v7.internal.view.SupportActionModeWrapper$CallbackWrapper */
    public class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a */
        final ActionMode.Callback f1985a;

        /* renamed from: b */
        final Context f1986b;

        /* renamed from: c */
        final ArrayList<SupportActionModeWrapper> f1987c = new ArrayList<>();

        /* renamed from: d */
        final SimpleArrayMap<Menu, Menu> f1988d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f1986b = context;
            this.f1985a = callback;
        }

        /* renamed from: a */
        private Menu m1373a(Menu menu) {
            Menu menu2 = this.f1988d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(this.f1986b, (SupportMenu) menu);
            this.f1988d.put(menu, wrapSupportMenu);
            return wrapSupportMenu;
        }

        public android.view.ActionMode getActionModeWrapper(android.support.p003v7.view.ActionMode actionMode) {
            int size = this.f1987c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f1987c.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f1984b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f1986b, actionMode);
            this.f1987c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        public boolean onActionItemClicked(android.support.p003v7.view.ActionMode actionMode, MenuItem menuItem) {
            return this.f1985a.onActionItemClicked(getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(this.f1986b, (SupportMenuItem) menuItem));
        }

        public boolean onCreateActionMode(android.support.p003v7.view.ActionMode actionMode, Menu menu) {
            return this.f1985a.onCreateActionMode(getActionModeWrapper(actionMode), m1373a(menu));
        }

        public void onDestroyActionMode(android.support.p003v7.view.ActionMode actionMode) {
            this.f1985a.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        public boolean onPrepareActionMode(android.support.p003v7.view.ActionMode actionMode, Menu menu) {
            return this.f1985a.onPrepareActionMode(getActionModeWrapper(actionMode), m1373a(menu));
        }
    }

    public SupportActionModeWrapper(Context context, android.support.p003v7.view.ActionMode actionMode) {
        this.f1983a = context;
        this.f1984b = actionMode;
    }

    public void finish() {
        this.f1984b.finish();
    }

    public View getCustomView() {
        return this.f1984b.getCustomView();
    }

    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.f1983a, (SupportMenu) this.f1984b.getMenu());
    }

    public MenuInflater getMenuInflater() {
        return this.f1984b.getMenuInflater();
    }

    public CharSequence getSubtitle() {
        return this.f1984b.getSubtitle();
    }

    public Object getTag() {
        return this.f1984b.getTag();
    }

    public CharSequence getTitle() {
        return this.f1984b.getTitle();
    }

    public boolean getTitleOptionalHint() {
        return this.f1984b.getTitleOptionalHint();
    }

    public void invalidate() {
        this.f1984b.invalidate();
    }

    public boolean isTitleOptional() {
        return this.f1984b.isTitleOptional();
    }

    public void setCustomView(View view) {
        this.f1984b.setCustomView(view);
    }

    public void setSubtitle(int i) {
        this.f1984b.setSubtitle(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1984b.setSubtitle(charSequence);
    }

    public void setTag(Object obj) {
        this.f1984b.setTag(obj);
    }

    public void setTitle(int i) {
        this.f1984b.setTitle(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1984b.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1984b.setTitleOptionalHint(z);
    }
}
