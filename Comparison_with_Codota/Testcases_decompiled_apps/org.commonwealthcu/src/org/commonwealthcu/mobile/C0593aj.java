package org.commonwealthcu.mobile;

import android.content.Intent;
import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.aj */
final class C0593aj extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ C0589af f721a;

    C0593aj(C0589af afVar) {
        this.f721a = afVar;
    }

    public final void run() {
        this.f721a.setResult(-1, new Intent());
        this.f721a.finish();
    }
}
