package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.bz */
class C1681bz extends C1635ag<String> {

    /* renamed from: a */
    final /* synthetic */ MFARecollectActivity f6421a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1681bz(MFARecollectActivity mFARecollectActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6421a = mFARecollectActivity;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6421a.dismissLoadingDialog();
        if (super.mo9589a(dVar)) {
            return true;
        }
        mo11216b(dVar);
        return true;
    }
}
