package android.support.p004v7.widget;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.SupportMenuInflater;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuPopupHelper;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.view.menu.SubMenuBuilder;
import android.support.p004v7.widget.ListPopupWindow;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.widget.PopupMenu */
public class PopupMenu implements MenuBuilder.Callback, MenuPresenter.Callback {

    /* renamed from: a */
    private Context f2157a;

    /* renamed from: b */
    private MenuBuilder f2158b;

    /* renamed from: c */
    private View f2159c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MenuPopupHelper f2160d;

    /* renamed from: e */
    private OnMenuItemClickListener f2161e;

    /* renamed from: f */
    private OnDismissListener f2162f;

    /* renamed from: g */
    private View.OnTouchListener f2163g;

    /* renamed from: android.support.v7.widget.PopupMenu$OnDismissListener */
    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    /* renamed from: android.support.v7.widget.PopupMenu$OnMenuItemClickListener */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, C0505R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.f2157a = context;
        this.f2158b = new MenuBuilder(context);
        this.f2158b.setCallback(this);
        this.f2159c = view;
        this.f2160d = new MenuPopupHelper(context, this.f2158b, view, false, i2, i3);
        this.f2160d.setGravity(i);
        this.f2160d.setCallback(this);
    }

    public void setGravity(int i) {
        this.f2160d.setGravity(i);
    }

    public int getGravity() {
        return this.f2160d.getGravity();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.f2163g == null) {
            this.f2163g = new ListPopupWindow.ForwardingListener(this.f2159c) {
                /* access modifiers changed from: protected */
                public boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                /* access modifiers changed from: protected */
                public boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }

                public ListPopupWindow getPopup() {
                    return PopupMenu.this.f2160d.getPopup();
                }
            };
        }
        return this.f2163g;
    }

    public Menu getMenu() {
        return this.f2158b;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f2157a);
    }

    public void inflate(@MenuRes int i) {
        getMenuInflater().inflate(i, this.f2158b);
    }

    public void show() {
        this.f2160d.show();
    }

    public void dismiss() {
        this.f2160d.dismiss();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2161e = onMenuItemClickListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f2162f = onDismissListener;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f2161e != null) {
            return this.f2161e.onMenuItemClick(menuItem);
        }
        return false;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.f2162f != null) {
            this.f2162f.onDismiss(this);
        }
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            return false;
        }
        if (!menuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.f2157a, menuBuilder, this.f2159c).show();
        return true;
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
