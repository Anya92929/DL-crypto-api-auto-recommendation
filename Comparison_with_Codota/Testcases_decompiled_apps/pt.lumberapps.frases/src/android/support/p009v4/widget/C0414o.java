package android.support.p009v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: android.support.v4.widget.o */
class C0414o extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ C0412m f567a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0414o(C0412m mVar) {
        super(new Handler());
        this.f567a = mVar;
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.f567a.mo1882b();
    }
}
