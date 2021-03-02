package android.support.p004v7.view;

import android.content.Context;
import android.support.p004v7.view.ActionMode;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuPopupHelper;
import android.support.p004v7.view.menu.SubMenuBuilder;
import android.support.p004v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.view.StandaloneActionMode */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* renamed from: a */
    private Context f1635a;

    /* renamed from: b */
    private ActionBarContextView f1636b;

    /* renamed from: c */
    private ActionMode.Callback f1637c;

    /* renamed from: d */
    private WeakReference<View> f1638d;

    /* renamed from: e */
    private boolean f1639e;

    /* renamed from: f */
    private boolean f1640f;

    /* renamed from: g */
    private MenuBuilder f1641g;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.f1635a = context;
        this.f1636b = actionBarContextView;
        this.f1637c = callback;
        this.f1641g = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f1641g.setCallback(this);
        this.f1640f = z;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1636b.setTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1636b.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.f1635a.getString(i));
    }

    public void setSubtitle(int i) {
        setSubtitle((CharSequence) this.f1635a.getString(i));
    }

    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.f1636b.setTitleOptional(z);
    }

    public boolean isTitleOptional() {
        return this.f1636b.isTitleOptional();
    }

    public void setCustomView(View view) {
        this.f1636b.setCustomView(view);
        this.f1638d = view != null ? new WeakReference<>(view) : null;
    }

    public void invalidate() {
        this.f1637c.onPrepareActionMode(this, this.f1641g);
    }

    public void finish() {
        if (!this.f1639e) {
            this.f1639e = true;
            this.f1636b.sendAccessibilityEvent(32);
            this.f1637c.onDestroyActionMode(this);
        }
    }

    public Menu getMenu() {
        return this.f1641g;
    }

    public CharSequence getTitle() {
        return this.f1636b.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.f1636b.getSubtitle();
    }

    public View getCustomView() {
        if (this.f1638d != null) {
            return (View) this.f1638d.get();
        }
        return null;
    }

    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.f1636b.getContext());
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f1637c.onActionItemClicked(this, menuItem);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            new MenuPopupHelper(this.f1636b.getContext(), subMenuBuilder).show();
        }
        return true;
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        invalidate();
        this.f1636b.showOverflowMenu();
    }

    public boolean isUiFocusable() {
        return this.f1640f;
    }
}
