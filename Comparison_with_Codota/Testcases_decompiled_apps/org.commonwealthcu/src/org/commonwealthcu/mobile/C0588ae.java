package org.commonwealthcu.mobile;

import android.content.Intent;
import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.ae */
final class C0588ae extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ C0584aa f714a;

    C0588ae(C0584aa aaVar) {
        this.f714a = aaVar;
    }

    public final void run() {
        this.f714a.setResult(-1, new Intent());
        this.f714a.finish();
    }
}
