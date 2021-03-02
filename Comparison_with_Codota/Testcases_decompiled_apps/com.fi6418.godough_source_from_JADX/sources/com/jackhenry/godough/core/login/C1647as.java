package com.jackhenry.godough.core.login;

import android.view.View;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.login.as */
class C1647as implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f6390a;

    C1647as(LoginActivity loginActivity) {
        this.f6390a = loginActivity;
    }

    public void onBackKeyPressed(View view) {
        this.f6390a.f6288n.setHint("");
    }
}
