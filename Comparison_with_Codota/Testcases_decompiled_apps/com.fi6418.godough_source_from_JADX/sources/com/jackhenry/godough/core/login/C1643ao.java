package com.jackhenry.godough.core.login;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;

/* renamed from: com.jackhenry.godough.core.login.ao */
class C1643ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f6386a;

    C1643ao(LoginActivity loginActivity) {
        this.f6386a = loginActivity;
    }

    public void onClick(View view) {
        this.f6386a.showDialog(this.f6386a.getString(C1506am.remember_me_dlg_title), this.f6386a.getString(C1506am.remember_me_dlg_warning, new Object[]{GoDoughApp.getSettings().getUserNameLabel(), GoDoughApp.getSettings().getPasswordLabel()}));
    }
}
