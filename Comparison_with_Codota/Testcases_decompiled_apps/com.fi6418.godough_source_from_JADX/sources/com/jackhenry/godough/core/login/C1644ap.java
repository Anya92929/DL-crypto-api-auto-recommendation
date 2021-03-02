package com.jackhenry.godough.core.login;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.jackhenry.godough.core.login.ap */
class C1644ap implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f6387a;

    C1644ap(LoginActivity loginActivity) {
        this.f6387a = loginActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2 && this.f6387a.f6290p.isEnabled()) {
            this.f6387a.f6290p.performClick();
        }
        return true;
    }
}
