package com.jackhenry.godough.core.login;

import android.view.View;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.login.ai */
class C1637ai implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f6379a;

    C1637ai(LoginActivity loginActivity) {
        this.f6379a = loginActivity;
    }

    public void onBackKeyPressed(View view) {
        this.f6379a.f6289o.setHint("");
    }
}
