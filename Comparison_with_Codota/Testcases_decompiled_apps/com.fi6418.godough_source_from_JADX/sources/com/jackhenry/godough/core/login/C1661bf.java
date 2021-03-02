package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.bf */
class C1661bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6399a;

    C1661bf(MFAActivity mFAActivity) {
        this.f6399a = mFAActivity;
    }

    public void onClick(View view) {
        this.f6399a.onCancelClicked(view);
    }
}
