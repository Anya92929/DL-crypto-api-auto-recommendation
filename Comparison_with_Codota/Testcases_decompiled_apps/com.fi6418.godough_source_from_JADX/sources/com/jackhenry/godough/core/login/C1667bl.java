package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.bl */
class C1667bl implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6405a;

    C1667bl(MFAActivity mFAActivity) {
        this.f6405a = mFAActivity;
    }

    public void onFocusChange(View view, boolean z) {
        this.f6405a.m6329g();
    }
}
