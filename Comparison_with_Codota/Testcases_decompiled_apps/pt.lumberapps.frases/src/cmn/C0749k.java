package cmn;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: cmn.k */
public final class C0749k {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static AtomicReference f1829a = new AtomicReference();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static volatile boolean f1830b = false;

    /* renamed from: a */
    public static List m3266a(Context context, long j) {
        C0751m mVar = (C0751m) f1829a.get();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (mVar == null || mVar.f1834b < elapsedRealtime - j) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            C0750l lVar = new C0750l(context, countDownLatch);
            f1830b = true;
            C0725at.m3234b((Runnable) lVar);
            try {
                countDownLatch.await(10, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mVar = (C0751m) f1829a.get();
        }
        return mVar == null ? Collections.emptyList() : mVar.f1833a;
    }

    /* renamed from: a */
    public static boolean m3268a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null && packageInfo.versionCode >= -1;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: b */
    public static void m3270b(Context context, String str) {
        Intent intent = null;
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception e) {
        }
        if (intent != null) {
            try {
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e2) {
            }
        }
    }
}
