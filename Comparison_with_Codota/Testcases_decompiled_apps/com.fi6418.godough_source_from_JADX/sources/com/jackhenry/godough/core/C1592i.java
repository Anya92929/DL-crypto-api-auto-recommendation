package com.jackhenry.godough.core;

import android.content.Intent;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.login.SplashActivity;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.i */
class C1592i extends C1942x<String> {

    /* renamed from: a */
    AbstractActivity f6167a;

    /* renamed from: b */
    final /* synthetic */ AbstractActivity f6168b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1592i(AbstractActivity abstractActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6168b = abstractActivity;
        this.f6167a = (AbstractActivity) fragment.getActivity();
    }

    /* renamed from: a */
    private void m6216a() {
        if (this.f6167a != null) {
            this.f6168b.f5762l = false;
            this.f6168b.dismissLoadingDialog();
        }
        Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
        intent.setFlags(67108864);
        this.f6168b.startActivity(intent);
        this.f6168b.finish();
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public void mo9588a(String str) {
        m6216a();
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        m6216a();
        return true;
    }
}
