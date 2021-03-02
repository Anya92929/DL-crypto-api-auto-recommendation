package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.login.bq */
class C1672bq implements C1578g {

    /* renamed from: a */
    final /* synthetic */ C1670bo f6411a;

    C1672bq(C1670bo boVar) {
        this.f6411a = boVar;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -2:
                if (this.f6411a.f6409b.f6296n != 0) {
                    ((MFAActivity) this.f6411a.f6409b.f6304v).resetMFA();
                    return;
                } else {
                    this.f6411a.f6409b.f6304v.finish();
                    return;
                }
            default:
                return;
        }
    }
}
