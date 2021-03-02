package com.jackhenry.godough.core.login;

import android.content.Intent;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.login.bx */
class C1679bx implements C1578g {

    /* renamed from: a */
    final /* synthetic */ MFARecollectActivity f6419a;

    C1679bx(MFARecollectActivity mFARecollectActivity) {
        this.f6419a = mFARecollectActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -1:
                new C1654az((C1943y) null).execute(new Void[0]);
                Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
                intent.setFlags(67108864);
                this.f6419a.startActivity(intent);
                this.f6419a.finish();
                return;
            default:
                return;
        }
    }
}
