package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.model.RDAUserRegistrationData;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.rda.registration.q */
class C1866q extends C1895t<RDAUserRegistrationData> {

    /* renamed from: c */
    final /* synthetic */ RDARegistrationConfirmInformationFragment f6756c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1866q(RDARegistrationConfirmInformationFragment rDARegistrationConfirmInformationFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6756c = rDARegistrationConfirmInformationFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<RDAUserRegistrationData> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<RDAUserRegistrationData> loader, RDAUserRegistrationData rDAUserRegistrationData) {
        RDAUserRegistrationData unused = this.f6756c.f6717e = rDAUserRegistrationData;
        this.f6756c.m6788n();
        this.f6756c.mo10989m();
    }

    /* renamed from: b */
    public void mo9581b(Loader<RDAUserRegistrationData> loader, C1389d dVar) {
        this.f6756c.mo10989m();
    }

    public Loader<RDAUserRegistrationData> onCreateLoader(int i, Bundle bundle) {
        return new C1847ae(this.f6756c.getActivity());
    }
}
