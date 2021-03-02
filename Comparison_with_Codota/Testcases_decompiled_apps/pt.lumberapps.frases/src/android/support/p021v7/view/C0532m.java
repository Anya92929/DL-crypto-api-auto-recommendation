package android.support.p021v7.view;

import android.support.p009v4.view.C0333fc;
import android.view.View;

/* renamed from: android.support.v7.view.m */
class C0532m extends C0333fc {

    /* renamed from: a */
    final /* synthetic */ C0531l f953a;

    /* renamed from: b */
    private boolean f954b = false;

    /* renamed from: c */
    private int f955c = 0;

    C0532m(C0531l lVar) {
        this.f953a = lVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2237a() {
        this.f955c = 0;
        this.f954b = false;
        this.f953a.m2255c();
    }

    public void onAnimationEnd(View view) {
        int i = this.f955c + 1;
        this.f955c = i;
        if (i == this.f953a.f947a.size()) {
            if (this.f953a.f950d != null) {
                this.f953a.f950d.onAnimationEnd((View) null);
            }
            mo2237a();
        }
    }

    public void onAnimationStart(View view) {
        if (!this.f954b) {
            this.f954b = true;
            if (this.f953a.f950d != null) {
                this.f953a.f950d.onAnimationStart((View) null);
            }
        }
    }
}
