package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.do */
class C1724do extends C1895t<String> {

    /* renamed from: c */
    final /* synthetic */ TermsAndConditionsFragmentActivity f6468c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1724do(TermsAndConditionsFragmentActivity termsAndConditionsFragmentActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6468c = termsAndConditionsFragmentActivity;
    }

    /* renamed from: a */
    public void mo9578a(Loader<String> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<String> loader, String str) {
        this.f6468c.f6363n = true;
        this.f6468c.dismissLoadingDialog();
        TermsFragment termsFragment = (TermsFragment) this.f6468c.getSupportFragmentManager().findFragmentByTag(TermsFragment.TAG);
        if (termsFragment != null) {
            termsFragment.setData(str);
        }
        String unused = this.f6468c.f6362m = str;
    }

    /* renamed from: b */
    public void mo9581b(Loader<String> loader, C1389d dVar) {
        this.f6468c.dismissLoadingDialog();
    }

    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        return new C1726dq(GoDoughApp.getApp());
    }
}
