package org.commonwealthcu.mobile;

import android.content.Intent;
import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.ad */
final class C0587ad extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ C0584aa f713a;

    C0587ad(C0584aa aaVar) {
        this.f713a = aaVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("EXIT_MESSAGE", "You have been logged off due to inactivity.");
        this.f713a.setResult(-1, intent);
        this.f713a.finish();
    }
}
