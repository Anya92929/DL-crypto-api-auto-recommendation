package com.jackhenry.godough.core.login;

import android.view.View;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.login.bk */
class C1666bk implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6404a;

    C1666bk(MFAActivity mFAActivity) {
        this.f6404a = mFAActivity;
    }

    public void onBackKeyPressed(View view) {
        this.f6404a.f6300r.setHint("");
    }
}
