package com.jackhenry.godough.core.login;

import android.view.View;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.login.bm */
class C1668bm implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6406a;

    C1668bm(MFAActivity mFAActivity) {
        this.f6406a = mFAActivity;
    }

    public void onBackKeyPressed(View view) {
        this.f6406a.f6301s.setHint("");
    }
}
