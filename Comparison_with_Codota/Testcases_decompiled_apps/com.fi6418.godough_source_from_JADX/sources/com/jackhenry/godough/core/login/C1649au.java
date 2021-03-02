package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.p027b.C1388c;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.au */
class C1649au extends C1635ag<String> {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f6392a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1649au(LoginActivity loginActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6392a = loginActivity;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public void mo9588a(String str) {
        if (str == null) {
            super.mo9588a(str);
        } else {
            this.f6392a.m6314b(str);
        }
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        if ((dVar instanceof C1388c) && dVar.mo9435b() == 403) {
            this.f6392a.m6314b(dVar.getMessage());
            return true;
        } else if (super.mo9589a(dVar)) {
            return true;
        } else {
            mo11216b(dVar);
            return true;
        }
    }
}
