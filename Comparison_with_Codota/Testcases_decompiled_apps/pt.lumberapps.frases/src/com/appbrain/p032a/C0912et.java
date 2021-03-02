package com.appbrain.p032a;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import com.appbrain.p037f.C1056av;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.appbrain.a.et */
public final class C0912et {

    /* renamed from: a */
    static C0923fd f2392a = new C0916ex();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Map f2393b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Set f2394c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final C0899eg f2395d = new C0899eg();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Integer f2396e;

    /* renamed from: a */
    static void m3897a(Activity activity, C1056av avVar, C0917ey eyVar) {
        Looper.myQueue().addIdleHandler(new C0913eu(activity, avVar, eyVar));
    }

    /* renamed from: a */
    static /* synthetic */ void m3898a(Activity activity, C1056av avVar, String str, C0920fa faVar) {
        faVar.setOnCancelListener(new C0915ew(avVar, str));
        f2395d.mo3783a(activity, faVar);
        f2394c.remove(faVar);
        faVar.show();
    }

    /* renamed from: a */
    static /* synthetic */ void m3899a(C1056av avVar, String str) {
        ((C0917ey) f2393b.get(str)).mo3786a(avVar, f2396e != null && f2396e.intValue() == avVar.mo4238h());
        f2396e = null;
    }

    /* renamed from: b */
    static /* synthetic */ void m3901b(Activity activity, C1056av avVar, C0917ey eyVar) {
        f2393b.put(eyVar.f2406a, eyVar);
        for (C0920fa ownerActivity : f2394c) {
            if (ownerActivity.getOwnerActivity() == activity) {
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 11) {
            if (f2395d.mo3784a(activity)) {
                return;
            }
        } else if (activity.getFragmentManager().findFragmentByTag("appbrain.internal.AppAlertWebViewManager") != null) {
            return;
        }
        C0920fa faVar = new C0920fa(activity, avVar, (byte) 0);
        f2394c.add(faVar);
        Runnable unused = faVar.f2413c = new C0914ev(activity, avVar, eyVar, faVar);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        faVar.f2412b.layout(0, 0, rect.width(), rect.height());
        C0920fa.m3912b(faVar);
    }
}
