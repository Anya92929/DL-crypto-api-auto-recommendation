package com.jackhenry.godough.core;

import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.LoaderManager;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.login.C1630ab;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.p038e.C1573b;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1392g;
import java.io.Serializable;

/* renamed from: com.jackhenry.godough.core.t */
public abstract class C1895t<D> implements LoaderManager.LoaderCallbacks<D>, Serializable {

    /* renamed from: a */
    Fragment f6792a;

    /* renamed from: b */
    C1593j f6793b;

    public C1895t(Fragment fragment, C1593j jVar) {
        this.f6792a = fragment;
        this.f6793b = jVar;
    }

    /* renamed from: a */
    public abstract void mo9578a(Loader<D> loader, C1389d dVar);

    /* renamed from: a */
    public abstract void mo9580a(Loader<D> loader, D d);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11133a(C1389d dVar) {
        ((AbstractActivity) this.f6792a.getActivity()).showDialog(GoDoughApp.getApp().getString(C1506am.dg_error_title), C1573b.m6140a(dVar));
    }

    /* renamed from: b */
    public abstract void mo9581b(Loader<D> loader, C1389d dVar);

    public final void onLoadFinished(Loader<D> loader, D d) {
        if (d == null) {
            C1389d i = ((C1752m) loader).mo10081i();
            if (new C1630ab(this.f6792a).mo9947a(i, this.f6793b)) {
                mo9581b(loader, i);
            } else if (!(i instanceof C1392g) || Redirect.RedirectType.getEnum(i.getMessage().toUpperCase()) != Redirect.RedirectType.USERSETTINGS) {
                mo9578a(loader, i);
            } else {
                ((AbstractActivity) this.f6792a.getActivity()).gotoLandingPage(GoDoughApp.getUserSettings().getOfflineMessage());
            }
        } else {
            mo9580a(loader, d);
        }
    }

    public void onLoaderReset(Loader<D> loader) {
    }
}
