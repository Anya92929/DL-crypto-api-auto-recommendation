package android.support.design.widget;

import android.os.Handler;
import android.os.Message;

/* renamed from: android.support.design.widget.ab */
class C0010ab implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C0009aa f115a;

    C0010ab(C0009aa aaVar) {
        this.f115a = aaVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f115a.m176b((C0012ad) message.obj);
                return true;
            default:
                return false;
        }
    }
}
