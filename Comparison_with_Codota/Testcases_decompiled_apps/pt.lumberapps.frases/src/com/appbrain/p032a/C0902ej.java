package com.appbrain.p032a;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Base64;
import cmn.C0705a;
import cmn.C0725at;
import com.appbrain.AppBrainActivity;
import com.appbrain.AppBrainService;
import com.appbrain.p033b.C1015s;
import com.appbrain.p037f.C1056av;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: com.appbrain.a.ej */
public final class C0902ej {

    /* renamed from: a */
    private static C1056av f2376a;

    /* renamed from: b */
    private static C0917ey f2377b;

    /* renamed from: c */
    private static LinkedHashSet f2378c;

    /* renamed from: a */
    private static C1056av m3872a() {
        String a;
        boolean z = true;
        C1056av avVar = null;
        if (f2376a == null && (a = C0932fm.m3968a().mo3841a("app_alert", (String) null)) != null) {
            try {
                avVar = C1056av.m4690a(Base64.decode(a, 0));
            } catch (C1015s | IllegalArgumentException e) {
            }
            if (avVar != null && !m3877b(avVar)) {
                if (avVar.mo4253w()) {
                    if (((int) ((System.currentTimeMillis() - C0932fm.m3968a().mo3843b().getLong("last_app_alert_discard", 0)) / 1000)) <= avVar.mo4254x()) {
                        z = false;
                    }
                }
                if (z) {
                    f2376a = avVar;
                }
            }
        }
        return f2376a;
    }

    /* renamed from: a */
    static void m3873a(Context context) {
        C1056av a;
        boolean z;
        Activity a2 = C0725at.m3226a(context);
        if (a2 != null && !(a2 instanceof AppBrainActivity) && !C0725at.m3232b(a2) && (a = m3872a()) != null) {
            if (a.mo4256z()) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(a2.getPackageName());
                Iterator<ResolveInfo> it = a2.getPackageManager().queryIntentActivities(intent, 0).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.activityInfo != null && next.activityInfo.name != null && next.activityInfo.name.equals(a2.getClass().getName())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    return;
                }
            }
            switch (C0904el.f2379a[a.mo4248r().ordinal()]) {
                case 1:
                case 2:
                    C0891dz.m3860a(a2, a);
                    return;
                case 3:
                    C0905em.m3881a(a2, a);
                    return;
                case 4:
                    PendingIntent pendingIntent = null;
                    if (a.mo4245o()) {
                        Intent intent2 = new Intent(a2, AppBrainService.class);
                        intent2.putExtra("appbrain.internal.AppAlertNotificationManager.Alert", a.mo3915b());
                        pendingIntent = PendingIntent.getService(a2, a.mo4238h(), intent2, 0);
                    }
                    String n = !TextUtils.isEmpty(a.mo4244n()) ? a.mo4244n() : a.mo4240j();
                    Notification a3 = C0705a.m3174a().mo3374a(a2, !TextUtils.isEmpty(a.mo4244n()) ? a.mo4244n() : a2.getPackageManager().getApplicationLabel(a2.getApplicationInfo()).toString(), a.mo4240j(), pendingIntent);
                    if (a3 != null) {
                        a3.tickerText = n;
                        a3.icon = a2.getApplicationInfo().icon;
                        a3.flags = 16;
                        a3.defaults &= -3;
                        ((NotificationManager) a2.getSystemService("notification")).notify("appbrain.internal.AppAlertNotificationManager", a.mo4238h(), a3);
                    }
                    m3874a(a, false);
                    return;
                case 5:
                    if (f2377b == null) {
                        f2377b = new C0903ek("AppAlertService");
                    }
                    C0912et.m3897a(a2, a, f2377b);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    static void m3874a(C1056av avVar, boolean z) {
        if (!m3877b(avVar)) {
            SharedPreferences.Editor edit = C0932fm.m3968a().mo3843b().edit();
            if (!avVar.mo4253w() || (z && avVar.mo4252v())) {
                int h = avVar.mo4238h();
                m3876b();
                f2378c.add(Integer.valueOf(h));
                StringBuilder sb = new StringBuilder();
                int i = 0;
                int size = f2378c.size() - 100;
                Iterator it = f2378c.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    Integer num = (Integer) it.next();
                    if (i2 >= size) {
                        if (sb.length() > 0) {
                            sb.append(',');
                        }
                        sb.append(num);
                    }
                    i = i2 + 1;
                }
                edit.putString("discarded_app_alert_ids", sb.toString());
            }
            edit.putLong("last_app_alert_discard", System.currentTimeMillis());
            edit.apply();
        }
        if (f2376a != null && f2376a.mo4238h() == avVar.mo4238h()) {
            f2376a = null;
        }
    }

    /* renamed from: a */
    static boolean m3875a(C1056av avVar) {
        return f2376a != null && f2376a.mo4238h() == avVar.mo4238h();
    }

    /* renamed from: b */
    private static void m3876b() {
        if (f2378c == null) {
            f2378c = new LinkedHashSet();
            for (String parseInt : C0932fm.m3968a().mo3843b().getString("discarded_app_alert_ids", "").split(",")) {
                try {
                    f2378c.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    /* renamed from: b */
    private static boolean m3877b(C1056av avVar) {
        m3876b();
        return f2378c.contains(Integer.valueOf(avVar.mo4238h()));
    }
}
