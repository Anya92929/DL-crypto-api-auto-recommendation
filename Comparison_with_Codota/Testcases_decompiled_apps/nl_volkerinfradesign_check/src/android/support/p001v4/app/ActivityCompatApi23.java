package android.support.p001v4.app;

import android.app.Activity;

/* renamed from: android.support.v4.app.ActivityCompatApi23 */
class ActivityCompatApi23 {

    /* renamed from: android.support.v4.app.ActivityCompatApi23$RequestPermissionsRequestCodeValidator */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* renamed from: a */
    public static void m103a(Activity activity, String[] strArr, int i) {
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }

    /* renamed from: a */
    public static boolean m104a(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
