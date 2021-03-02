package com.jackhenry.godough.core.login;

import android.widget.CompoundButton;
import com.jackhenry.godough.core.p038e.C1584m;
import com.jackhenry.godough.core.p038e.p039a.C1572e;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.login.an */
class C1642an implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1584m f6384a;

    /* renamed from: b */
    final /* synthetic */ LoginActivity f6385b;

    C1642an(LoginActivity loginActivity, C1584m mVar) {
        this.f6385b = loginActivity;
        this.f6384a = mVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!z && !this.f6385b.f6288n.isEnabled()) {
            try {
                new C1572e().mo9787b("DATA2");
            } catch (C1389d e) {
                e.printStackTrace();
            }
            this.f6385b.f6288n.setText("");
            this.f6385b.f6288n.setEnabled(true);
        }
        this.f6384a.mo9802b("REMEMBER_ME_CHECKED", z);
    }
}
