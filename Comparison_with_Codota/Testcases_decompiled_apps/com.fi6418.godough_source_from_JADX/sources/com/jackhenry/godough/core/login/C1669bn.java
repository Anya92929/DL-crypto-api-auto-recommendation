package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.bn */
class C1669bn extends C1942x<Boolean> {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6407a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1669bn(MFAActivity mFAActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6407a = mFAActivity;
    }

    /* renamed from: a */
    public void mo9588a(Boolean bool) {
        this.f6407a.dismissLoadingDialog();
        this.f6407a.setResult(0);
        this.f6407a.finish();
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6407a.dismissLoadingDialog();
        if (super.mo9589a(dVar)) {
            return true;
        }
        mo11216b(dVar);
        return true;
    }
}
