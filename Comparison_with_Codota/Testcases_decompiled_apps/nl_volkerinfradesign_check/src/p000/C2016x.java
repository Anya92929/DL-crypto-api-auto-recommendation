package p000;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* renamed from: x */
public class C2016x {
    /* renamed from: a */
    public static Intent m7663a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    /* renamed from: a */
    public static boolean m7665a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    /* renamed from: b */
    public static void m7666b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    /* renamed from: a */
    public static String m7664a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }
}
