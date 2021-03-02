package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.bc */
class C1658bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6396a;

    C1658bc(MFAActivity mFAActivity) {
        this.f6396a = mFAActivity;
    }

    public void onClick(View view) {
        this.f6396a.onContinueClicked(view);
    }
}
