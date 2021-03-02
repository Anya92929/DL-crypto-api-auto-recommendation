package cmn;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: cmn.at */
public final class C0725at {

    /* renamed from: a */
    private static final Handler f1792a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static final AtomicInteger f1793b = new AtomicInteger(1);

    /* renamed from: a */
    public static Activity m3226a(Context context) {
        Context context2 = context;
        while (!(context2 instanceof Activity)) {
            if (!(context2 instanceof ContextWrapper)) {
                return null;
            }
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        return (Activity) context2;
    }

    /* renamed from: a */
    public static FrameLayout m3227a(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        if (findViewById instanceof FrameLayout) {
            return (FrameLayout) findViewById;
        }
        return null;
    }

    /* renamed from: a */
    public static void m3228a(Runnable runnable) {
        f1792a.post(runnable);
    }

    /* renamed from: a */
    public static void m3229a(Runnable runnable, long j) {
        f1792a.postDelayed(runnable, j);
    }

    /* renamed from: a */
    public static boolean m3230a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: b */
    public static void m3231b() {
        if (!(!m3230a())) {
            new IllegalStateException("should be worker thread");
        }
    }

    /* renamed from: b */
    public static boolean m3232b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 11 || !activity.isChangingConfigurations()) {
            return activity.isFinishing();
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m3233b(Context context) {
        int i = context.getResources().getConfiguration().screenLayout & 15;
        return i == 4 || i == 3;
    }

    /* renamed from: b */
    public static boolean m3234b(Runnable runnable) {
        if (m3230a()) {
            runnable.run();
            return true;
        }
        f1792a.post(runnable);
        return false;
    }
}
