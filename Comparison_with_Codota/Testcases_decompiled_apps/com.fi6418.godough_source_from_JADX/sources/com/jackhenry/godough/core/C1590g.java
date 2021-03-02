package com.jackhenry.godough.core;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import com.jackhenry.godough.core.login.SplashActivity;
import com.jackhenry.godough.core.p037d.C1564a;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.g */
final class C1590g implements C1578g {

    /* renamed from: a */
    final /* synthetic */ AbstractActivity f6164a;

    /* renamed from: b */
    final /* synthetic */ C1593j f6165b;

    C1590g(AbstractActivity abstractActivity, C1593j jVar) {
        this.f6164a = abstractActivity;
        this.f6165b = jVar;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -3:
                Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
                if (Build.VERSION.SDK_INT < 14) {
                    intent.setComponent(new ComponentName("com.android.phone", "com.android.phone.Settings"));
                }
                if (!AbstractActivity.isCallable(this.f6164a, intent)) {
                    intent.setAction("android.settings.SETTINGS");
                }
                this.f6164a.startActivityForResult(intent, 5002);
                return;
            case -2:
                if (this.f6165b != null) {
                    this.f6165b.run();
                    return;
                } else if (!C1564a.m6120a()) {
                    this.f6164a.showNoNetworkDialog();
                    return;
                } else if (this.f6164a instanceof SplashActivity) {
                    Intent intent2 = new Intent(GoDoughApp.getApp(), SplashActivity.class);
                    intent2.addFlags(67108864);
                    this.f6164a.startActivity(intent2);
                    this.f6164a.finish();
                    return;
                } else {
                    return;
                }
            case -1:
                Intent intent3 = new Intent(GoDoughApp.getApp(), SplashActivity.class);
                intent3.setFlags(67108864);
                intent3.putExtra(SplashActivity.EXTRA_FINISH, true);
                this.f6164a.startActivity(intent3);
                this.f6164a.finish();
                return;
            default:
                return;
        }
    }
}
