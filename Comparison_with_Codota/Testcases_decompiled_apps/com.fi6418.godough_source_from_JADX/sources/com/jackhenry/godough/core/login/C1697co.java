package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.login.co */
class C1697co implements C1578g {

    /* renamed from: a */
    final /* synthetic */ C1696cn f6439a;

    C1697co(C1696cn cnVar) {
        this.f6439a = cnVar;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -1:
                this.f6439a.f6438a.mo10988l();
                this.f6439a.f6438a.reloadSettings();
                return;
            default:
                return;
        }
    }
}
