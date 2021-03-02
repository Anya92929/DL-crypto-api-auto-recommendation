package com.jackhenry.godough.core.session;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.session.g */
class C1891g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SessionTimeoutWarningActivity f6788a;

    C1891g(SessionTimeoutWarningActivity sessionTimeoutWarningActivity) {
        this.f6788a = sessionTimeoutWarningActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6788a.f6779d.setIndeterminate(true);
        this.f6788a.f6779d.setVisibility(0);
        ((AlertDialog) dialogInterface).getButton(-2).setVisibility(8);
        ((AlertDialog) dialogInterface).getButton(-1).setVisibility(4);
        if (this.f6788a.f6779d.getVisibility() == 0) {
            this.f6788a.f6778c.setText(C1506am.stw_message_logout);
        } else {
            this.f6788a.f6778c.setText(C1506am.stw_message_gohome);
        }
        this.f6788a.mo11113a();
    }
}
