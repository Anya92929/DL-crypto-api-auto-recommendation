package android.support.p021v7.p022a;

import android.support.p021v7.view.C0574n;
import android.view.Menu;
import android.view.View;
import android.view.Window;

/* renamed from: android.support.v7.a.br */
class C0471br extends C0574n {

    /* renamed from: a */
    final /* synthetic */ C0465bl f696a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0471br(C0465bl blVar, Window.Callback callback) {
        super(callback);
        this.f696a = blVar;
    }

    public View onCreatePanelView(int i) {
        switch (i) {
            case 0:
                Menu r = this.f696a.f681a.mo3112r();
                if (onPreparePanel(i, (View) null, r) && onMenuOpened(i, r)) {
                    return this.f696a.m1971a(r);
                }
        }
        return super.onCreatePanelView(i);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (onPreparePanel && !this.f696a.f682b) {
            this.f696a.f681a.mo3107m();
            boolean unused = this.f696a.f682b = true;
        }
        return onPreparePanel;
    }
}
