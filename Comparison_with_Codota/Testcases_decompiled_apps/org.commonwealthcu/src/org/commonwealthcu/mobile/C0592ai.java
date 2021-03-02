package org.commonwealthcu.mobile;

import android.content.Intent;
import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.ai */
final class C0592ai extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ C0589af f720a;

    C0592ai(C0589af afVar) {
        this.f720a = afVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("EXIT_MESSAGE", "You have been logged off due to inactivity.");
        this.f720a.setResult(-1, intent);
        this.f720a.finish();
    }
}
