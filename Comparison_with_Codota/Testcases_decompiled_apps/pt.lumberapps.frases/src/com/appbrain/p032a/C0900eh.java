package com.appbrain.p032a;

import android.content.Context;
import android.content.Intent;
import cmn.C0725at;
import com.appbrain.p033b.C1015s;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.eh */
public final class C0900eh {
    /* renamed from: a */
    public static boolean m3871a(Context context, Intent intent) {
        if (!intent.hasExtra("appbrain.internal.AppAlertNotificationManager.Alert")) {
            return false;
        }
        try {
            C0725at.m3234b((Runnable) new C0901ei(C1056av.m4690a(intent.getByteArrayExtra("appbrain.internal.AppAlertNotificationManager.Alert")), context));
            return true;
        } catch (C1015s e) {
            return false;
        }
    }
}
