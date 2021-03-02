package com.jackhenry.godough.core.alerts;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.alerts.e */
class C1502e extends C1895t<Boolean> {

    /* renamed from: c */
    final /* synthetic */ AlertDetailFragment f5984c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1502e(AlertDetailFragment alertDetailFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f5984c = alertDetailFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<Boolean> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<Boolean> loader, Boolean bool) {
        this.f5984c.mo10989m();
    }

    /* renamed from: b */
    public void mo9581b(Loader<Boolean> loader, C1389d dVar) {
        this.f5984c.mo10989m();
    }

    public Loader<Boolean> onCreateLoader(int i, Bundle bundle) {
        return new C1499b(this.f5984c.getActivity(), this.f5984c.f5973a.getAlertId());
    }

    public void onLoaderReset(Loader<Boolean> loader) {
    }
}
