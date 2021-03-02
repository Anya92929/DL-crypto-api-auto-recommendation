package com.jackhenry.godough.core.session;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.session.f */
class C1890f extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    final /* synthetic */ DialogInterface f6786a;

    /* renamed from: b */
    final /* synthetic */ C1889e f6787b;

    C1890f(C1889e eVar, DialogInterface dialogInterface) {
        this.f6787b = eVar;
        this.f6786a = dialogInterface;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean doInBackground(Void... voidArr) {
        try {
            return Boolean.valueOf(new C1887c().mo11119b());
        } catch (Exception e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            this.f6787b.f6785b.finish();
            return;
        }
        this.f6787b.f6785b.f6779d.setVisibility(8);
        this.f6787b.f6785b.f6778c.setText(C1506am.stw_message_exp_error);
        this.f6787b.f6784a.setTitle(C1506am.stw_title_exp);
        ((AlertDialog) this.f6786a).getButton(-2).setVisibility(8);
        ((AlertDialog) this.f6786a).getButton(-1).setText(17039370);
    }
}
