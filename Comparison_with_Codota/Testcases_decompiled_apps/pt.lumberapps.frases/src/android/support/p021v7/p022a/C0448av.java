package android.support.p021v7.p022a;

import android.support.p009v4.app.FragmentTransaction;
import android.support.p021v7.p023b.C0515k;

/* renamed from: android.support.v7.a.av */
class C0448av implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0447au f638a;

    C0448av(C0447au auVar) {
        this.f638a = auVar;
    }

    public void run() {
        if ((this.f638a.f618F & 1) != 0) {
            this.f638a.m1901f(0);
        }
        if ((this.f638a.f618F & FragmentTransaction.TRANSIT_ENTER_MASK) != 0) {
            this.f638a.m1901f(C0515k.AppCompatTheme_ratingBarStyle);
        }
        boolean unused = this.f638a.f617E = false;
        int unused2 = this.f638a.f618F = 0;
    }
}
