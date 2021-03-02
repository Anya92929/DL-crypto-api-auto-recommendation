package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.bj */
class C1665bj implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6403a;

    C1665bj(MFAActivity mFAActivity) {
        this.f6403a = mFAActivity;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f6403a.f6300r.getTag() == null) {
            this.f6403a.f6300r.setTag("");
        } else {
            this.f6403a.m6329g();
        }
    }
}
