package cmn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: cmn.az */
final class C0731az extends Handler {
    public C0731az() {
        super(Looper.getMainLooper());
    }

    public final void handleMessage(Message message) {
        C0733ba baVar = (C0733ba) message.obj;
        switch (message.what) {
            case 1:
                C0726au.m3242c(baVar.f1808a, baVar.f1809b[0]);
                return;
            case 2:
                C0726au.m3239b();
                return;
            default:
                return;
        }
    }
}
