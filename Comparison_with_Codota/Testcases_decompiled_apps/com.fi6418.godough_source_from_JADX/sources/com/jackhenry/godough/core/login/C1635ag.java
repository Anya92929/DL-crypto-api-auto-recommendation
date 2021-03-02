package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1392g;

/* renamed from: com.jackhenry.godough.core.login.ag */
public abstract class C1635ag<T> extends C1943y<T> {
    public C1635ag(Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6919c = fragment;
    }

    /* renamed from: a */
    public void mo9588a(T t) {
        AbstractActivity abstractActivity = (AbstractActivity) this.f6919c.getActivity();
        abstractActivity.dismissLoadingDialog();
        abstractActivity.gotoLandingPage();
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        boolean z = false;
        if (super.mo9589a(dVar)) {
            z = true;
        } else if (dVar instanceof C1392g) {
            new C1630ab(this.f6919c).mo9945a((C1392g) dVar);
            z = true;
        }
        ((AbstractActivity) this.f6919c.getActivity()).dismissLoadingDialog();
        return z;
    }
}
