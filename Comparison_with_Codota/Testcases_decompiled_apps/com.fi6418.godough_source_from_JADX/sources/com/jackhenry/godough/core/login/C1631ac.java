package com.jackhenry.godough.core.login;

import android.content.Intent;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.login.ac */
class C1631ac implements C1578g {

    /* renamed from: a */
    final /* synthetic */ AbstractActivity f6371a;

    /* renamed from: b */
    final /* synthetic */ C1630ab f6372b;

    C1631ac(C1630ab abVar, AbstractActivity abstractActivity) {
        this.f6372b = abVar;
        this.f6371a = abstractActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -2:
                this.f6371a.gotoLandingPage();
                return;
            case -1:
                Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
                intent.setFlags(67108864);
                intent.putExtra(SplashActivity.EXTRA_FINISH, true);
                this.f6371a.startActivity(intent);
                this.f6371a.finish();
                return;
            default:
                return;
        }
    }
}
