package android.support.p021v7.p022a;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.a.ac */
final class C0429ac extends Handler {

    /* renamed from: a */
    private WeakReference f580a;

    public C0429ac(DialogInterface dialogInterface) {
        this.f580a = new WeakReference(dialogInterface);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case -3:
            case -2:
            case -1:
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f580a.get(), message.what);
                return;
            case 1:
                ((DialogInterface) message.obj).dismiss();
                return;
            default:
                return;
        }
    }
}
