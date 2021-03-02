package android.support.p021v7.view.menu;

import android.view.MenuItem;

/* renamed from: android.support.v7.view.menu.j */
class C0557j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0558k f1079a;

    /* renamed from: b */
    final /* synthetic */ MenuItem f1080b;

    /* renamed from: c */
    final /* synthetic */ C0562o f1081c;

    /* renamed from: d */
    final /* synthetic */ C0556i f1082d;

    C0557j(C0556i iVar, C0558k kVar, MenuItem menuItem, C0562o oVar) {
        this.f1082d = iVar;
        this.f1079a = kVar;
        this.f1080b = menuItem;
        this.f1081c = oVar;
    }

    public void run() {
        if (this.f1079a != null) {
            boolean unused = this.f1082d.f1078a.f1076w = true;
            this.f1079a.f1084b.mo2454a(false);
            boolean unused2 = this.f1082d.f1078a.f1076w = false;
        }
        if (this.f1080b.isEnabled() && this.f1080b.hasSubMenu()) {
            this.f1081c.mo2455a(this.f1080b, 0);
        }
    }
}
