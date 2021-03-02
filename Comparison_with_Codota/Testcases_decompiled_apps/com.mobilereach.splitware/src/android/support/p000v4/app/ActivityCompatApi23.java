package android.support.p000v4.app;

import android.app.Activity;

/* renamed from: android.support.v4.app.ActivityCompatApi23 */
/* compiled from: ActivityCompat23 */
class ActivityCompatApi23 {

    /* renamed from: android.support.v4.app.ActivityCompatApi23$RequestPermissionsRequestCodeValidator */
    /* compiled from: ActivityCompat23 */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    ActivityCompatApi23() {
    }

    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(requestCode);
        }
        activity.requestPermissions(permissions, requestCode);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
        return activity.shouldShowRequestPermissionRationale(permission);
    }
}
