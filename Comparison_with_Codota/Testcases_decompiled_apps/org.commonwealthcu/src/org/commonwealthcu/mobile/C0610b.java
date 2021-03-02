package org.commonwealthcu.mobile;

import android.os.Handler;
import android.os.Message;

/* renamed from: org.commonwealthcu.mobile.b */
final class C0610b extends Handler {

    /* renamed from: a */
    private /* synthetic */ C0578a f791a;

    C0610b(C0578a aVar) {
        this.f791a = aVar;
    }

    public final void handleMessage(Message message) {
        this.f791a.f691e.setCurrentItem(((Integer) message.obj).intValue(), true);
    }
}
