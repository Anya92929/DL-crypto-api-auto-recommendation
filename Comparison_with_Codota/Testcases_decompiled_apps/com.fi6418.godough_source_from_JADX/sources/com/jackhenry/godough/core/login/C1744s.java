package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.SelfEnrollmentData;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.s */
class C1744s extends C1895t<SelfEnrollmentData> {

    /* renamed from: c */
    final /* synthetic */ EnrollmentFragmentActivity f6490c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1744s(EnrollmentFragmentActivity enrollmentFragmentActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6490c = enrollmentFragmentActivity;
    }

    /* renamed from: a */
    private void m6514a() {
        new Handler().post(new C1745t(this));
    }

    /* renamed from: a */
    public void mo9578a(Loader<SelfEnrollmentData> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<SelfEnrollmentData> loader, SelfEnrollmentData selfEnrollmentData) {
        this.f6490c.f6363n = true;
        m6514a();
        this.f6490c.setCarriers(selfEnrollmentData.getCarriers());
        this.f6490c.setTermsAndConditions(selfEnrollmentData.getTermsAndConditions());
        TermsFragment termsFragment = (TermsFragment) this.f6490c.getSupportFragmentManager().findFragmentByTag(TermsFragment.TAG);
        if (termsFragment != null) {
            termsFragment.setData(this.f6490c.getTermsAndConditions());
        }
    }

    /* renamed from: b */
    public void mo9581b(Loader<SelfEnrollmentData> loader, C1389d dVar) {
        m6514a();
    }

    public Loader<SelfEnrollmentData> onCreateLoader(int i, Bundle bundle) {
        return new C1701cs(GoDoughApp.getApp());
    }
}
