package android.support.p003v7.widget;

import android.content.Context;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.SupportMenuInflater;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPopupHelper;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.SubMenuBuilder;
import android.support.p003v7.widget.ListPopupWindow;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.widget.PopupMenu */
public class PopupMenu implements MenuBuilder.Callback, MenuPresenter.Callback {

    /* renamed from: a */
    private Context f2882a;

    /* renamed from: b */
    private MenuBuilder f2883b;

    /* renamed from: c */
    private View f2884c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MenuPopupHelper f2885d;

    /* renamed from: e */
    private OnMenuItemClickListener f2886e;

    /* renamed from: f */
    private OnDismissListener f2887f;

    /* renamed from: g */
    private View.OnTouchListener f2888g;

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
        this(context, view, i, C0235R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.f2882a = context;
        this.f2883b = new MenuBuilder(context);
        this.f2883b.setCallback(this);
        this.f2884c = view;
        this.f2885d = new MenuPopupHelper(context, this.f2883b, view, false, i2, i3);
        this.f2885d.setGravity(i);
        this.f2885d.setCallback(this);
    }

    public void dismiss() {
        this.f2885d.dismiss();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.f2888g == null) {
            this.f2888g = new ListPopupWindow.ForwardingListener(this.f2884c) {
                public ListPopupWindow getPopup() {
                    return PopupMenu.this.f2885d.getPopup();
                }

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
            };
        }
        return this.f2888g;
    }

    public int getGravity() {
        return this.f2885d.getGravity();
    }

    public Menu getMenu() {
        return this.f2883b;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f2882a);
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, this.f2883b);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.f2887f != null) {
            this.f2887f.onDismiss(this);
        }
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f2886e != null) {
            return this.f2886e.onMenuItemClick(menuItem);
        }
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            return false;
        }
        if (!menuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.f2882a, menuBuilder, this.f2884c).show();
        return true;
    }

    public void setGravity(int i) {
        this.f2885d.setGravity(i);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f2887f = onDismissListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2886e = onMenuItemClickListener;
    }

    public void show() {
        this.f2885d.show();
    }
}
