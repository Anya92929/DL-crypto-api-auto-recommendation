package android.support.p021v7.p022a;

import android.support.p021v7.view.C0574n;
import android.support.p021v7.view.menu.C0562o;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

/* renamed from: android.support.v7.a.am */
class C0439am extends C0574n {

    /* renamed from: a */
    final /* synthetic */ C0436aj f604a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0439am(C0436aj ajVar, Window.Callback callback) {
        super(callback);
        this.f604a = ajVar;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f604a.mo1999a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.f604a.mo1998a(keyEvent.getKeyCode(), keyEvent);
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof C0562o)) {
            return super.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.f604a.mo2001b(i, menu);
        return true;
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        this.f604a.mo1997a(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        C0562o oVar = menu instanceof C0562o ? (C0562o) menu : null;
        if (i == 0 && oVar == null) {
            return false;
        }
        if (oVar != null) {
            oVar.mo2472c(true);
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (oVar == null) {
            return onPreparePanel;
        }
        oVar.mo2472c(false);
        return onPreparePanel;
    }
}
