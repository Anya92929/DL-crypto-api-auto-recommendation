package android.support.p021v7.view.menu;

import android.os.SystemClock;
import android.support.p021v7.widget.C0647cr;
import android.view.MenuItem;

/* renamed from: android.support.v7.view.menu.i */
class C0556i implements C0647cr {

    /* renamed from: a */
    final /* synthetic */ C0554g f1078a;

    C0556i(C0554g gVar) {
        this.f1078a = gVar;
    }

    /* renamed from: a */
    public void mo2417a(C0562o oVar, MenuItem menuItem) {
        this.f1078a.f1059f.removeCallbacksAndMessages(oVar);
    }

    /* renamed from: b */
    public void mo2418b(C0562o oVar, MenuItem menuItem) {
        int i;
        this.f1078a.f1059f.removeCallbacksAndMessages((Object) null);
        int i2 = 0;
        int size = this.f1078a.f1061h.size();
        while (true) {
            if (i2 >= size) {
                i = -1;
                break;
            } else if (oVar == ((C0558k) this.f1078a.f1061h.get(i2)).f1084b) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i != -1) {
            int i3 = i + 1;
            this.f1078a.f1059f.postAtTime(new C0557j(this, i3 < this.f1078a.f1061h.size() ? (C0558k) this.f1078a.f1061h.get(i3) : null, menuItem, oVar), oVar, SystemClock.uptimeMillis() + 200);
        }
    }
}
