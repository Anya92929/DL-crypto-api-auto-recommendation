package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.j */
class C1735j extends C1635ag<String> {

    /* renamed from: a */
    final /* synthetic */ EmailAddressFragment f6478a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1735j(EmailAddressFragment emailAddressFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6478a = emailAddressFragment;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public void mo9588a(String str) {
        EmailAddressFragmentActivity emailAddressFragmentActivity = (EmailAddressFragmentActivity) this.f6478a.getActivity();
        if (emailAddressFragmentActivity != null) {
            if (str == null) {
                super.mo9588a(str);
            } else {
                this.f6478a.mo10989m();
                emailAddressFragmentActivity.showDialog(this.f6478a.getString(C1506am.dg_email_update_failed), str);
            }
            C1714de unused = this.f6478a.f6270d = null;
        }
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6478a.mo10989m();
        if (((EmailAddressFragmentActivity) this.f6478a.getActivity()) == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            mo11216b(dVar);
        }
        C1714de unused = this.f6478a.f6270d = null;
        return true;
    }
}
