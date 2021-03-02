package com.jackhenry.godough.core.session;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.session.e */
class C1889e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialog.Builder f6784a;

    /* renamed from: b */
    final /* synthetic */ SessionTimeoutWarningActivity f6785b;

    C1889e(SessionTimeoutWarningActivity sessionTimeoutWarningActivity, AlertDialog.Builder builder) {
        this.f6785b = sessionTimeoutWarningActivity;
        this.f6784a = builder;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6785b.f6776a.removeCallbacks(this.f6785b.f6783h);
        this.f6785b.f6779d.setIndeterminate(true);
        this.f6785b.f6778c.setText(C1506am.stw_message_extend);
        new C1890f(this, dialogInterface).execute(new Void[0]);
    }
}
