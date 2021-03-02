package com.jackhenry.godough.core.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.model.Notification;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.login.db */
class C1711db implements C1578g {

    /* renamed from: a */
    final /* synthetic */ Notification f6453a;

    /* renamed from: b */
    final /* synthetic */ AbstractActivity f6454b;

    /* renamed from: c */
    final /* synthetic */ SplashActivity f6455c;

    C1711db(SplashActivity splashActivity, Notification notification, AbstractActivity abstractActivity) {
        this.f6455c = splashActivity;
        this.f6453a = notification;
        this.f6454b = abstractActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -3:
                this.f6455c.dismissInfoDialog();
                return;
            case -1:
                String upgradePackageName = this.f6453a.getUpgradePackageName();
                if (!upgradePackageName.toUpperCase().startsWith("HTTP:") && !upgradePackageName.toUpperCase().startsWith("HTTPS:")) {
                    try {
                        this.f6454b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + upgradePackageName)));
                    } catch (ActivityNotFoundException e) {
                        this.f6454b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + upgradePackageName)));
                    }
                }
                this.f6454b.finish();
                return;
            default:
                return;
        }
    }
}
