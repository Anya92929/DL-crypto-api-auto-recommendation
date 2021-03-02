package cmn;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(10)
/* renamed from: cmn.a */
public class C0705a {

    /* renamed from: a */
    private static C0705a f1743a = null;

    /* renamed from: b */
    private final AtomicInteger f1744b = new AtomicInteger(1);

    /* renamed from: a */
    public static synchronized C0705a m3174a() {
        C0705a aVar;
        synchronized (C0705a.class) {
            if (f1743a == null) {
                if (Build.VERSION.SDK_INT >= 20) {
                    f1743a = new C0748j();
                } else if (Build.VERSION.SDK_INT >= 18) {
                    f1743a = new C0747i();
                } else if (Build.VERSION.SDK_INT >= 17) {
                    f1743a = new C0746h();
                } else if (Build.VERSION.SDK_INT >= 16) {
                    f1743a = new C0745g();
                } else if (Build.VERSION.SDK_INT >= 14) {
                    f1743a = new C0744f();
                } else if (Build.VERSION.SDK_INT >= 13) {
                    f1743a = new C0743e();
                } else if (Build.VERSION.SDK_INT >= 11) {
                    f1743a = new C0742d();
                } else {
                    f1743a = new C0705a();
                }
            }
            aVar = f1743a;
        }
        return aVar;
    }

    /* renamed from: a */
    public Notification mo3374a(Context context, String str, String str2, PendingIntent pendingIntent) {
        return null;
    }

    /* renamed from: a */
    public Point mo3375a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager == null ? null : windowManager.getDefaultDisplay();
        Point point = new Point();
        if (defaultDisplay != null) {
            point.x = defaultDisplay.getWidth();
            point.y = defaultDisplay.getHeight();
        }
        return point;
    }

    /* renamed from: a */
    public void mo3376a(Activity activity) {
    }

    /* renamed from: a */
    public void mo3377a(View view) {
    }

    /* renamed from: a */
    public void mo3378a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    /* renamed from: b */
    public int mo3379b() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (int) Math.min((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024, 2147483647L);
        } catch (Throwable th) {
            return -1;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo3380b(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Class<android.webkit.WebSettings> r0 = android.webkit.WebSettings.class
            r1 = 2
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ Throwable -> 0x0036 }
            r2 = 0
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r1[r2] = r3     // Catch:{ Throwable -> 0x0036 }
            r2 = 1
            java.lang.Class<android.webkit.WebView> r3 = android.webkit.WebView.class
            r1[r2] = r3     // Catch:{ Throwable -> 0x0036 }
            java.lang.reflect.Constructor r1 = r0.getDeclaredConstructor(r1)     // Catch:{ Throwable -> 0x0036 }
            r0 = 1
            r1.setAccessible(r0)     // Catch:{ Throwable -> 0x0036 }
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0030 }
            r2 = 0
            r0[r2] = r5     // Catch:{ all -> 0x0030 }
            r2 = 1
            r3 = 0
            r0[r2] = r3     // Catch:{ all -> 0x0030 }
            java.lang.Object r0 = r1.newInstance(r0)     // Catch:{ all -> 0x0030 }
            android.webkit.WebSettings r0 = (android.webkit.WebSettings) r0     // Catch:{ all -> 0x0030 }
            java.lang.String r0 = r0.getUserAgentString()     // Catch:{ all -> 0x0030 }
            r2 = 0
            r1.setAccessible(r2)     // Catch:{ Throwable -> 0x0036 }
        L_0x002f:
            return r0
        L_0x0030:
            r0 = move-exception
            r2 = 0
            r1.setAccessible(r2)     // Catch:{ Throwable -> 0x0036 }
            throw r0     // Catch:{ Throwable -> 0x0036 }
        L_0x0036:
            r0 = move-exception
            java.lang.String r0 = "http.agent"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: cmn.C0705a.mo3380b(android.content.Context):java.lang.String");
    }

    /* renamed from: c */
    public int mo3381c() {
        return 2;
    }
}
