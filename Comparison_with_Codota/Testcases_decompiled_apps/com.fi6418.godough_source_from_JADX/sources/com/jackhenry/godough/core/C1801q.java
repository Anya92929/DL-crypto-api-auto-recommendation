package com.jackhenry.godough.core;

import android.support.p000v4.app.Fragment;
import android.view.View;
import com.jackhenry.android.p022a.p023a.C1353e;
import com.jackhenry.godough.core.login.C1630ab;
import com.jackhenry.godough.core.p038e.C1573b;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.q */
public abstract class C1801q<T> implements C1353e<T> {

    /* renamed from: a */
    Fragment f6607a;

    public C1801q(Fragment fragment) {
        this.f6607a = fragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10985a(Exception exc) {
        AbstractActivity abstractActivity = (AbstractActivity) this.f6607a.getActivity();
        if (!abstractActivity.isFinishing()) {
            abstractActivity.showDialog(this.f6607a.getString(C1506am.dg_error_title), C1573b.m6140a(exc));
        }
    }

    /* renamed from: a */
    public boolean mo9280a(View view, Exception exc) {
        if (!((AbstractActivity) this.f6607a.getActivity()).isFinishing()) {
            if (!(exc instanceof C1389d)) {
                return mo9567b(view, exc);
            }
            C1389d dVar = (C1389d) exc;
            if (!new C1630ab(this.f6607a).mo9947a(dVar, (C1593j) null)) {
                return mo9567b(view, dVar);
            }
        }
        return false;
    }

    /* renamed from: b */
    public abstract boolean mo9567b(View view, Exception exc);
}
