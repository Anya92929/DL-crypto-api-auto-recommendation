package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.i */
class C1734i extends C1635ag<Boolean> {

    /* renamed from: a */
    final /* synthetic */ EmailAddressFragment f6477a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1734i(EmailAddressFragment emailAddressFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6477a = emailAddressFragment;
    }

    /* renamed from: a */
    public void mo9588a(Boolean bool) {
        super.mo9588a(bool);
        if (((EmailAddressFragmentActivity) this.f6477a.getActivity()) != null) {
            C1715df unused = this.f6477a.f6271e = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6477a.mo10989m();
        if (((EmailAddressFragmentActivity) this.f6477a.getActivity()) == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            mo11216b(dVar);
        }
        C1715df unused = this.f6477a.f6271e = null;
        return true;
    }
}
