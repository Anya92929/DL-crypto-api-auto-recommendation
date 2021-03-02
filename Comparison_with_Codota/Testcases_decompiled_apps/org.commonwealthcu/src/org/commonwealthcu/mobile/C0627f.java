package org.commonwealthcu.mobile;

import android.os.Message;
import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.f */
public final class C0627f extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ C0578a f845a;

    public C0627f(C0578a aVar) {
        this.f845a = aVar;
    }

    public final void run() {
        int count = this.f845a.f691e.getAdapter().getCount();
        int currentItem = this.f845a.f691e.getCurrentItem() + 1;
        if (count > 1) {
            if (currentItem >= count) {
                currentItem = 0;
            }
            Message obtain = Message.obtain();
            obtain.obj = Integer.valueOf(currentItem);
            this.f845a.f687a.sendMessage(obtain);
        }
    }
}
