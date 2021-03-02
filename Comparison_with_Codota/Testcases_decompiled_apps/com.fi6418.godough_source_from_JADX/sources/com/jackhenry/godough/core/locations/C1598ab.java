package com.jackhenry.godough.core.locations;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.locations.ab */
class C1598ab extends C1895t<List<GoDoughLocation>> {

    /* renamed from: c */
    final /* synthetic */ LocationsFragmentActivity f6230c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1598ab(LocationsFragmentActivity locationsFragmentActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6230c = locationsFragmentActivity;
    }

    /* renamed from: a */
    public void mo9578a(Loader<List<GoDoughLocation>> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<List<GoDoughLocation>> loader, List<GoDoughLocation> list) {
        GoDoughApp.setLocations(list);
        this.f6230c.dismissLoadingDialog();
    }

    /* renamed from: b */
    public void mo9581b(Loader<List<GoDoughLocation>> loader, C1389d dVar) {
        this.f6230c.dismissLoadingDialog();
    }

    public Loader<List<GoDoughLocation>> onCreateLoader(int i, Bundle bundle) {
        return new C1599ac(this.f6230c, this.f6230c.f6171m);
    }
}
