package android.support.p000v4.app;

import android.app.Activity;
import android.os.Build;
import android.support.p000v4.content.ContextCompat;

/* renamed from: android.support.v4.app.ActivityCompat */
public class ActivityCompat extends ContextCompat {
    public static boolean invalidateOptionsMenu(Activity activity) {
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        ActivityCompatHoneycomb.invalidateOptionsMenu(activity);
        return true;
    }
}
