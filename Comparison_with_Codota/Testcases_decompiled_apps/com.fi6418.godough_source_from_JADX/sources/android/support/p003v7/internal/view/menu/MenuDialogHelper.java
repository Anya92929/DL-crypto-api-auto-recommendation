package android.support.p003v7.internal.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* renamed from: android.support.v7.internal.view.menu.MenuDialogHelper */
public class MenuDialogHelper implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.Callback {

    /* renamed from: a */
    ListMenuPresenter f2128a;

    /* renamed from: b */
    private MenuBuilder f2129b;

    /* renamed from: c */
    private AlertDialog f2130c;

    /* renamed from: d */
    private MenuPresenter.Callback f2131d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f2129b = menuBuilder;
    }

    public void dismiss() {
        if (this.f2130c != null) {
            this.f2130c.dismiss();
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2129b.performItemAction((MenuItemImpl) this.f2128a.getAdapter().getItem(i), 0);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f2129b) {
            dismiss();
        }
        if (this.f2131d != null) {
            this.f2131d.onCloseMenu(menuBuilder, z);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f2128a.onCloseMenu(this.f2129b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f2130c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f2130c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f2129b.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f2129b.performShortcut(i, keyEvent, 0);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (this.f2131d != null) {
            return this.f2131d.onOpenSubMenu(menuBuilder);
        }
        return false;
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.f2131d = callback;
    }

    public void show(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f2129b;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
        this.f2128a = new ListMenuPresenter(builder.getContext(), C0235R.layout.abc_list_menu_item_layout);
        this.f2128a.setCallback(this);
        this.f2129b.addMenuPresenter(this.f2128a);
        builder.setAdapter(this.f2128a.getAdapter(), this);
        View headerView = menuBuilder.getHeaderView();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener(this);
        this.f2130c = builder.create();
        this.f2130c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f2130c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f2130c.show();
    }
}
