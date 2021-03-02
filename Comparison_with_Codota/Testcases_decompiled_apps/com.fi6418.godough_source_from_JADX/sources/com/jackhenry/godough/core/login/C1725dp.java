package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.dp */
class C1725dp extends C1635ag<Void> {

    /* renamed from: a */
    final /* synthetic */ TermsAndConditionsFragmentActivity f6469a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1725dp(TermsAndConditionsFragmentActivity termsAndConditionsFragmentActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6469a = termsAndConditionsFragmentActivity;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public void mo9588a(Void voidR) {
        this.f6469a.mo9879h();
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        if (!super.mo9589a(dVar)) {
            mo11216b(dVar);
        }
        this.f6469a.dismissLoadingDialog();
        return true;
    }
}
