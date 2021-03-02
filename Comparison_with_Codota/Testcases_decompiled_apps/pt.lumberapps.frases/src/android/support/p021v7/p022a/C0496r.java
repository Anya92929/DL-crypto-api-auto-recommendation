package android.support.p021v7.p022a;

import android.os.Message;
import android.view.View;

/* renamed from: android.support.v7.a.r */
class C0496r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0495q f816a;

    C0496r(C0495q qVar) {
        this.f816a = qVar;
    }

    public void onClick(View view) {
        Message obtain = (view != this.f816a.f803n || this.f816a.f805p == null) ? (view != this.f816a.f806q || this.f816a.f808s == null) ? (view != this.f816a.f809t || this.f816a.f811v == null) ? null : Message.obtain(this.f816a.f811v) : Message.obtain(this.f816a.f808s) : Message.obtain(this.f816a.f805p);
        if (obtain != null) {
            obtain.sendToTarget();
        }
        this.f816a.f788M.obtainMessage(1, this.f816a.f791b).sendToTarget();
    }
}
