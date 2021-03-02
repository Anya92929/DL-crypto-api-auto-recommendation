package com.jackhenry.godough.core.login;

import android.content.Intent;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.login.bp */
class C1671bp implements C1578g {

    /* renamed from: a */
    final /* synthetic */ C1670bo f6410a;

    C1671bp(C1670bo boVar) {
        this.f6410a = boVar;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        if (this.f6410a.f6409b.f6296n != 0) {
            new C1654az((C1943y) null).execute(new Void[0]);
            Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
            intent.setFlags(67108864);
            this.f6410a.f6409b.f6304v.startActivity(intent);
        }
        this.f6410a.f6409b.f6304v.finish();
    }
}
