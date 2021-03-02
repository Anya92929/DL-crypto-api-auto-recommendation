package android.support.p003v7.internal.view;

import android.content.Context;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPopupHelper;
import android.support.p003v7.internal.view.menu.SubMenuBuilder;
import android.support.p003v7.internal.widget.ActionBarContextView;
import android.support.p003v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.internal.view.StandaloneActionMode */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* renamed from: a */
    private Context f1976a;

    /* renamed from: b */
    private ActionBarContextView f1977b;

    /* renamed from: c */
    private ActionMode.Callback f1978c;

    /* renamed from: d */
    private WeakReference<View> f1979d;

    /* renamed from: e */
    private boolean f1980e;

    /* renamed from: f */
    private boolean f1981f;

    /* renamed from: g */
    private MenuBuilder f1982g;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.f1976a = context;
        this.f1977b = actionBarContextView;
        this.f1978c = callback;
        this.f1982g = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f1982g.setCallback(this);
        this.f1981f = z;
    }

    public void finish() {
        if (!this.f1980e) {
            this.f1980e = true;
            this.f1977b.sendAccessibilityEvent(32);
            this.f1978c.onDestroyActionMode(this);
        }
    }

    public View getCustomView() {
        if (this.f1979d != null) {
            return (View) this.f1979d.get();
        }
        return null;
    }

    public Menu getMenu() {
        return this.f1982g;
    }

    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.f1977b.getContext());
    }

    public CharSequence getSubtitle() {
        return this.f1977b.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.f1977b.getTitle();
    }

    public void invalidate() {
        this.f1978c.onPrepareActionMode(this, this.f1982g);
    }

    public boolean isTitleOptional() {
        return this.f1977b.isTitleOptional();
    }

    public boolean isUiFocusable() {
        return this.f1981f;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f1978c.onActionItemClicked(this, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        invalidate();
        this.f1977b.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            new MenuPopupHelper(this.f1977b.getContext(), subMenuBuilder).show();
        }
        return true;
    }

    public void setCustomView(View view) {
        this.f1977b.setCustomView(view);
        this.f1979d = view != null ? new WeakReference<>(view) : null;
    }

    public void setSubtitle(int i) {
        setSubtitle((CharSequence) this.f1976a.getString(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1977b.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.f1976a.getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        this.f1977b.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.f1977b.setTitleOptional(z);
    }
}
