package com.jackhenry.godough.core.session;

import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.session.h */
class C1892h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SessionTimeoutWarningActivity f6789a;

    C1892h(SessionTimeoutWarningActivity sessionTimeoutWarningActivity) {
        this.f6789a = sessionTimeoutWarningActivity;
    }

    public void run() {
        this.f6789a.f6779d.setVisibility(8);
        this.f6789a.f6781f.setTitle(C1506am.stw_title_exp);
        this.f6789a.f6778c.setText(C1506am.stw_message_exp);
        this.f6789a.f6781f.getButton(-2).setVisibility(8);
        this.f6789a.f6781f.getButton(-1).setVisibility(0);
        this.f6789a.f6781f.getButton(-1).setText(17039370);
    }
}
