package com.jackhenry.godough.core;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.login.C1630ab;
import com.jackhenry.godough.p027b.C1389d;
import java.io.Serializable;

/* renamed from: com.jackhenry.godough.core.y */
public abstract class C1943y<T> implements C1759p<T>, Serializable {
    /* access modifiers changed from: protected */

    /* renamed from: c */
    public Fragment f6919c;

    /* renamed from: d */
    C1593j f6920d;

    public C1943y(Fragment fragment, C1593j jVar) {
        this.f6919c = fragment;
        this.f6920d = jVar;
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        return new C1630ab(this.f6919c).mo9947a(dVar, this.f6920d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo11216b(C1389d dVar) {
        ((AbstractActivity) this.f6919c.getActivity()).showDialog(GoDoughApp.getApp().getString(C1506am.dg_error_title), dVar.getMessage());
    }
}
