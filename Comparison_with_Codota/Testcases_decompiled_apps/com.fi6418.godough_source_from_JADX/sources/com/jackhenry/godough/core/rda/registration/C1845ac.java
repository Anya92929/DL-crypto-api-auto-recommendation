package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.RDATermsAndConditions;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.rda.registration.ac */
class C1845ac extends C1895t<RDATermsAndConditions> {

    /* renamed from: c */
    final /* synthetic */ RDATermsAndConditionsFragment f6732c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1845ac(RDATermsAndConditionsFragment rDATermsAndConditionsFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6732c = rDATermsAndConditionsFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<RDATermsAndConditions> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<RDATermsAndConditions> loader, RDATermsAndConditions rDATermsAndConditions) {
        this.f6732c.mo10989m();
        String unused = this.f6732c.f6725d = rDATermsAndConditions.getRdaTermsAndConditions();
        this.f6732c.initUI();
    }

    /* renamed from: b */
    public void mo9581b(Loader<RDATermsAndConditions> loader, C1389d dVar) {
        this.f6732c.mo10989m();
    }

    public Loader<RDATermsAndConditions> onCreateLoader(int i, Bundle bundle) {
        return new C1846ad(GoDoughApp.getApp(), this.f6732c.f6727f.booleanValue());
    }
}
