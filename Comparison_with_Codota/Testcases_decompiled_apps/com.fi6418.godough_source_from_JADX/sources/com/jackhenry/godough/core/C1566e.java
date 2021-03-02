package com.jackhenry.godough.core;

import android.content.Intent;
import com.jackhenry.godough.core.login.C1654az;
import com.jackhenry.godough.core.login.SplashActivity;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.e */
class C1566e implements C1578g {

    /* renamed from: a */
    final /* synthetic */ AbstractActivity f6118a;

    /* renamed from: b */
    final /* synthetic */ AbstractActivity f6119b;

    C1566e(AbstractActivity abstractActivity, AbstractActivity abstractActivity2) {
        this.f6119b = abstractActivity;
        this.f6118a = abstractActivity2;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        new C1654az((C1943y) null).execute(new Void[0]);
        Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
        intent.setFlags(67108864);
        this.f6118a.startActivity(intent);
        this.f6118a.finish();
    }
}
