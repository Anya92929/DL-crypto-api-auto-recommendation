package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Alert;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.Settings;
import com.jackhenry.godough.core.model.UserSettings;
import com.jackhenry.godough.core.rda.C1808ad;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.login.az */
public class C1654az extends C1757n<String> {
    public C1654az(C1943y yVar) {
        super(null, yVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo9592a(Void... voidArr) {
        GoDoughApp.setSettings((Settings) null);
        GoDoughApp.setUserSettings((UserSettings) null);
        GoDoughApp.setLocations((List<GoDoughLocation>) null);
        GoDoughApp.setAlertsList((List<Alert>) null);
        C1656ba.m6416a();
        C1808ad.m6711a(GoDoughApp.getApp()).mo11013a(GoDoughApp.getApp().getFilesDir().getAbsolutePath(), GoDoughApp.getApp());
        new C1689cg().mo9441m();
        return null;
    }
}
