package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.login.ae */
class C1633ae implements C1578g {

    /* renamed from: a */
    final /* synthetic */ AbstractActivity f6375a;

    /* renamed from: b */
    final /* synthetic */ C1630ab f6376b;

    C1633ae(C1630ab abVar, AbstractActivity abstractActivity) {
        this.f6376b = abVar;
        this.f6375a = abstractActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        this.f6375a.gotoLandingPage();
    }
}
