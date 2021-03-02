package com.jackhenry.godough.core.session;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1585n;

/* renamed from: com.jackhenry.godough.core.session.a */
public class C1885a {
    /* renamed from: a */
    private static PendingIntent m6859a(Context context) {
        long h = new C1585n(context).mo9817h();
        Intent intent = new Intent("com.jackhenry.godough.action.SESSION_TIMEOUT");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra(SessionTimeoutWarningActivity.EXTRA_TIMEOUT, h);
        return PendingIntent.getBroadcast(context, 0, intent, 134217728);
    }

    /* renamed from: a */
    public static void m6860a() {
        GoDoughApp app = GoDoughApp.getApp();
        long currentTimeMillis = System.currentTimeMillis();
        new C1585n(app).mo9804a(599000 + currentTimeMillis);
        ((AlarmManager) app.getSystemService("alarm")).set(1, currentTimeMillis + 539000, m6859a(app));
    }

    /* renamed from: b */
    public static void m6861b() {
        GoDoughApp app = GoDoughApp.getApp();
        ((AlarmManager) app.getSystemService("alarm")).cancel(m6859a(app));
        new C1585n(app).mo9804a(Long.MAX_VALUE);
    }
}
