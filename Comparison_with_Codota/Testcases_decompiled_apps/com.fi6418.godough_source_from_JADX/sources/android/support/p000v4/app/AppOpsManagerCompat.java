package android.support.p000v4.app;

import android.content.Context;
import android.os.Build;

/* renamed from: android.support.v4.app.AppOpsManagerCompat */
public class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_IGNORED = 1;

    /* renamed from: a */
    private static final AppOpsManagerImpl f285a;

    /* renamed from: android.support.v4.app.AppOpsManagerCompat$AppOpsManager23 */
    class AppOpsManager23 extends AppOpsManagerImpl {
        private AppOpsManager23() {
            super();
        }

        public int noteOp(Context context, String str, int i, String str2) {
            return AppOpsManagerCompat23.noteOp(context, str, i, str2);
        }

        public int noteProxyOp(Context context, String str, String str2) {
            return AppOpsManagerCompat23.noteProxyOp(context, str, str2);
        }

        public String permissionToOp(String str) {
            return AppOpsManagerCompat23.permissionToOp(str);
        }
    }

    /* renamed from: android.support.v4.app.AppOpsManagerCompat$AppOpsManagerImpl */
    class AppOpsManagerImpl {
        private AppOpsManagerImpl() {
        }

        public int noteOp(Context context, String str, int i, String str2) {
            return 1;
        }

        public int noteProxyOp(Context context, String str, String str2) {
            return 1;
        }

        public String permissionToOp(String str) {
            return null;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f285a = new AppOpsManager23();
        } else {
            f285a = new AppOpsManagerImpl();
        }
    }

    public static int noteOp(Context context, String str, int i, String str2) {
        return f285a.noteOp(context, str, i, str2);
    }

    public static int noteProxyOp(Context context, String str, String str2) {
        return f285a.noteProxyOp(context, str, str2);
    }

    public static String permissionToOp(String str) {
        return f285a.permissionToOp(str);
    }
}
