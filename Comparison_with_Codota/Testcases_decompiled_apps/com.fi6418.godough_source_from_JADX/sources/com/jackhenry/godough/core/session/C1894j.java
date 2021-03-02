package com.jackhenry.godough.core.session;

import android.os.AsyncTask;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Alert;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.Settings;
import com.jackhenry.godough.core.model.UserSettings;
import com.jackhenry.godough.core.rda.C1808ad;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.session.j */
class C1894j extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ SessionTimeoutWarningActivity f6791a;

    C1894j(SessionTimeoutWarningActivity sessionTimeoutWarningActivity) {
        this.f6791a = sessionTimeoutWarningActivity;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        try {
            GoDoughApp.setSettings((Settings) null);
            GoDoughApp.setUserSettings((UserSettings) null);
            GoDoughApp.setLocations((List<GoDoughLocation>) null);
            GoDoughApp.setAlertsList((List<Alert>) null);
            new C1887c().mo9441m();
        } catch (Exception e) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Void voidR) {
        C1808ad.m6711a(GoDoughApp.getApp()).mo11013a(this.f6791a.f6780e.getFilesDir().getAbsolutePath(), GoDoughApp.getApp());
    }
}
