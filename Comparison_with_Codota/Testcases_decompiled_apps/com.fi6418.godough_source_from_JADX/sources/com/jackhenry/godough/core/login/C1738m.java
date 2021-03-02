package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.EmailAddressData;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.m */
class C1738m extends C1895t<EmailAddressData> {

    /* renamed from: c */
    final /* synthetic */ EmailAddressFragmentActivity f6481c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1738m(EmailAddressFragmentActivity emailAddressFragmentActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6481c = emailAddressFragmentActivity;
    }

    /* renamed from: a */
    private void m6505a() {
        new Handler().post(new C1739n(this));
    }

    /* renamed from: a */
    public void mo9578a(Loader<EmailAddressData> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<EmailAddressData> loader, EmailAddressData emailAddressData) {
        this.f6481c.f6272m.setEmailAddress(emailAddressData.getCustomerEmail());
        EmailAddressData unused = this.f6481c.f6273n = emailAddressData;
        m6505a();
    }

    /* renamed from: b */
    public void mo9581b(Loader<EmailAddressData> loader, C1389d dVar) {
        m6505a();
    }

    public Loader<EmailAddressData> onCreateLoader(int i, Bundle bundle) {
        return new C1682c(GoDoughApp.getApp());
    }
}
