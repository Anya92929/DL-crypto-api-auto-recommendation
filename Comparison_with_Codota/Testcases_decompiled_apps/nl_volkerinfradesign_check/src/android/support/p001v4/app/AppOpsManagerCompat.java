package android.support.p001v4.app;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.app.AppOpsManagerCompat */
public class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_IGNORED = 1;

    /* renamed from: a */
    private static final C0042b f54a;

    /* renamed from: android.support.v4.app.AppOpsManagerCompat$b */
    static class C0042b {
        private C0042b() {
        }

        /* renamed from: a */
        public String mo118a(String str) {
            return null;
        }

        /* renamed from: a */
        public int mo116a(Context context, String str, int i, String str2) {
            return 1;
        }

        /* renamed from: a */
        public int mo117a(Context context, String str, String str2) {
            return 1;
        }
    }

    /* renamed from: android.support.v4.app.AppOpsManagerCompat$a */
    static class C0041a extends C0042b {
        private C0041a() {
            super();
        }

        /* renamed from: a */
        public String mo118a(String str) {
            return AppOpsManagerCompat23.permissionToOp(str);
        }

        /* renamed from: a */
        public int mo116a(Context context, String str, int i, String str2) {
            return AppOpsManagerCompat23.noteOp(context, str, i, str2);
        }

        /* renamed from: a */
        public int mo117a(Context context, String str, String str2) {
            return AppOpsManagerCompat23.noteProxyOp(context, str, str2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f54a = new C0041a();
        } else {
            f54a = new C0042b();
        }
    }

    public static String permissionToOp(@NonNull String str) {
        return f54a.mo118a(str);
    }

    public static int noteOp(@NonNull Context context, @NonNull String str, int i, @NonNull String str2) {
        return f54a.mo116a(context, str, i, str2);
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return f54a.mo117a(context, str, str2);
    }
}
