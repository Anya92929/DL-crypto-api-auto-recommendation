package android.support.design.widget;

import android.os.Handler;
import android.os.Message;

/* renamed from: android.support.design.widget.q */
final class C0069q implements Handler.Callback {
    C0069q() {
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                ((Snackbar) message.obj).mo132a();
                return true;
            case 1:
                ((Snackbar) message.obj).mo133a(message.arg1);
                return true;
            default:
                return false;
        }
    }
}
