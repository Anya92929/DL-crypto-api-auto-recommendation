package android.support.p021v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.p021v7.p022a.C0431ae;
import android.support.p021v7.p022a.C0432af;
import android.support.p021v7.p023b.C0512h;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* renamed from: android.support.v7.view.menu.r */
class C0565r implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, C0539af {

    /* renamed from: a */
    C0559l f1129a;

    /* renamed from: b */
    private C0562o f1130b;

    /* renamed from: c */
    private C0431ae f1131c;

    /* renamed from: d */
    private C0539af f1132d;

    public C0565r(C0562o oVar) {
        this.f1130b = oVar;
    }

    /* renamed from: a */
    public void mo2502a() {
        if (this.f1131c != null) {
            this.f1131c.dismiss();
        }
    }

    /* renamed from: a */
    public void mo2503a(IBinder iBinder) {
        C0562o oVar = this.f1130b;
        C0432af afVar = new C0432af(oVar.mo2477e());
        this.f1129a = new C0559l(afVar.mo1941a(), C0512h.abc_list_menu_item_layout);
        this.f1129a.mo2333a((C0539af) this);
        this.f1130b.mo2449a((C0538ae) this.f1129a);
        afVar.mo1945a(this.f1129a.mo2422a(), this);
        View o = oVar.mo2491o();
        if (o != null) {
            afVar.mo1944a(o);
        } else {
            afVar.mo1943a(oVar.mo2490n()).mo1946a(oVar.mo2489m());
        }
        afVar.mo1942a((DialogInterface.OnKeyListener) this);
        this.f1131c = afVar.mo1947b();
        this.f1131c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1131c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1131c.show();
    }

    /* renamed from: a */
    public void mo2041a(C0562o oVar, boolean z) {
        if (z || oVar == this.f1130b) {
            mo2502a();
        }
        if (this.f1132d != null) {
            this.f1132d.mo2041a(oVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo2042a(C0562o oVar) {
        if (this.f1132d != null) {
            return this.f1132d.mo2042a(oVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1130b.mo2455a((MenuItem) (C0566s) this.f1129a.mo2422a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1129a.mo2334a(this.f1130b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1131c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1131c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1130b.mo2454a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1130b.performShortcut(i, keyEvent, 0);
    }
}
