package com.jackhenry.godough.core.login;

import android.content.Intent;
import android.support.p000v4.app.FragmentActivity;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.login.dn */
class C1723dn implements C1578g {

    /* renamed from: a */
    final /* synthetic */ TermsAndConditionsFragmentActivity f6467a;

    C1723dn(TermsAndConditionsFragmentActivity termsAndConditionsFragmentActivity) {
        this.f6467a = termsAndConditionsFragmentActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -1:
                new C1654az((C1943y) null).execute(new Void[0]);
                Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
                intent.setFlags(67108864);
                FragmentActivity activity = this.f6467a.mo9485d().getActivity();
                activity.startActivity(intent);
                activity.finish();
                return;
            default:
                return;
        }
    }
}
