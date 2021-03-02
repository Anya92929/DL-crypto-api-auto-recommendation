package p000;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.p004v7.app.AlertDialog;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.menu.ListMenuPresenter;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuItemImpl;
import android.support.p004v7.view.menu.MenuPresenter;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* renamed from: gj */
public class C1165gj implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.Callback {

    /* renamed from: a */
    ListMenuPresenter f4163a;

    /* renamed from: b */
    private MenuBuilder f4164b;

    /* renamed from: c */
    private AlertDialog f4165c;

    /* renamed from: d */
    private MenuPresenter.Callback f4166d;

    public C1165gj(MenuBuilder menuBuilder) {
        this.f4164b = menuBuilder;
    }

    /* renamed from: a */
    public void mo8137a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f4164b;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
        this.f4163a = new ListMenuPresenter(builder.getContext(), C0505R.layout.abc_list_menu_item_layout);
        this.f4163a.setCallback(this);
        this.f4164b.addMenuPresenter(this.f4163a);
        builder.setAdapter(this.f4163a.getAdapter(), this);
        View headerView = menuBuilder.getHeaderView();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener(this);
        this.f4165c = builder.create();
        this.f4165c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f4165c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f4165c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f4165c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f4165c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f4164b.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f4164b.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: a */
    public void mo8136a() {
        if (this.f4165c != null) {
            this.f4165c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f4163a.onCloseMenu(this.f4164b, true);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f4164b) {
            mo8136a();
        }
        if (this.f4166d != null) {
            this.f4166d.onCloseMenu(menuBuilder, z);
        }
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (this.f4166d != null) {
            return this.f4166d.onOpenSubMenu(menuBuilder);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4164b.performItemAction((MenuItemImpl) this.f4163a.getAdapter().getItem(i), 0);
    }
}
