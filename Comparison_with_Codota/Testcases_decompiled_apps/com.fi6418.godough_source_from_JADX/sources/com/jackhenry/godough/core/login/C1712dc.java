package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Settings;
import com.jackhenry.godough.core.p038e.C1584m;
import com.jackhenry.godough.core.p038e.C1585n;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.dc */
class C1712dc extends C1895t<Settings> {

    /* renamed from: c */
    final /* synthetic */ SplashActivity f6456c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1712dc(SplashActivity splashActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6456c = splashActivity;
    }

    /* renamed from: a */
    public void mo9578a(Loader<Settings> loader, C1389d dVar) {
        if (dVar.mo9435b() == 404) {
            this.f6456c.showDialog(this.f6456c.getString(C1506am.dg_error_title), this.f6456c.getString(C1506am.dg_404_message));
        } else {
            mo11133a(dVar);
        }
        this.f6456c.m6382h();
    }

    /* renamed from: a */
    public void mo9580a(Loader<Settings> loader, Settings settings) {
        GoDoughApp.setSettings(settings);
        C1585n nVar = new C1585n(GoDoughApp.getApp());
        nVar.mo9809c(settings.getLocationsMenuName());
        nVar.mo9812d(settings.getLoginMenuName());
        nVar.mo9808b(settings.getActionItemColor());
        nVar.mo9806a(settings.getMainColor());
        nVar.mo9805a(settings.getMobileBackgroundTextureImageId() == null ? Settings.Texture.TRANSPARENT : settings.getMobileBackgroundTextureImageId());
        C1584m mVar = new C1584m(GoDoughApp.getApp());
        if (!mVar.mo9800a("REMEMBER_ME_ENABLED", false) || !mVar.mo9800a("REMEMBER_ME_CHECKED", false)) {
            mVar.mo9799a("DATA2");
            mVar.mo9802b("REMEMBER_ME_CHECKED", false);
        }
        mVar.mo9802b("REMEMBER_ME_ENABLED", settings.isRememberMeEnabled());
        this.f6456c.m6382h();
    }

    /* renamed from: b */
    public void mo9581b(Loader<Settings> loader, C1389d dVar) {
        this.f6456c.m6382h();
    }

    public Loader<Settings> onCreateLoader(int i, Bundle bundle) {
        new C1585n(GoDoughApp.getApp());
        return new C1702ct(GoDoughApp.getApp());
    }
}
