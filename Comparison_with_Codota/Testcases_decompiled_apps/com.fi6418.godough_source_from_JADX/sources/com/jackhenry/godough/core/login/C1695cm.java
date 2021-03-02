package com.jackhenry.godough.core.login;

import android.content.Intent;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.CredentialsChangeSettings;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.cm */
class C1695cm extends C1635ag<CredentialsChangeSettings> {

    /* renamed from: a */
    final /* synthetic */ PasswordChangeFragment f6437a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1695cm(PasswordChangeFragment passwordChangeFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6437a = passwordChangeFragment;
    }

    /* renamed from: a */
    public void mo9588a(CredentialsChangeSettings credentialsChangeSettings) {
        AbstractActivity abstractActivity = (AbstractActivity) this.f6437a.getActivity();
        this.f6437a.mo10989m();
        if (this.f6437a.getActivity() == null) {
            return;
        }
        if (credentialsChangeSettings != null) {
            Intent intent = new Intent(GoDoughApp.getApp(), PasswordChangeFragmentActivity.class);
            intent.putExtra(PasswordChangeFragmentActivity.EXTRA_PASSWORD_CHANGE_SETTINGS, credentialsChangeSettings);
            this.f6437a.mo10989m();
            this.f6437a.getActivity().startActivity(intent);
            this.f6437a.getActivity().finish();
            return;
        }
        super.mo9588a(credentialsChangeSettings);
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        AbstractActivity abstractActivity = (AbstractActivity) this.f6437a.getActivity();
        this.f6437a.mo10989m();
        if (abstractActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            mo11216b(dVar);
        }
        C1718di unused = this.f6437a.f6349h = null;
        return true;
    }
}
