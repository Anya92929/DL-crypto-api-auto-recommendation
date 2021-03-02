package android.support.p001v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

/* renamed from: android.support.v4.content.IntentCompat */
public class IntentCompat {
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;

    /* renamed from: a */
    private static final C0111a f444a;

    /* renamed from: android.support.v4.content.IntentCompat$a */
    interface C0111a {
        /* renamed from: a */
        Intent mo814a(ComponentName componentName);

        /* renamed from: a */
        Intent mo815a(String str, String str2);

        /* renamed from: b */
        Intent mo816b(ComponentName componentName);
    }

    /* renamed from: android.support.v4.content.IntentCompat$b */
    static class C0112b implements C0111a {
        C0112b() {
        }

        /* renamed from: a */
        public Intent mo814a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }

        /* renamed from: a */
        public Intent mo815a(String str, String str2) {
            Intent intent = new Intent(str);
            intent.addCategory(str2);
            return intent;
        }

        /* renamed from: b */
        public Intent mo816b(ComponentName componentName) {
            Intent a = mo814a(componentName);
            a.addFlags(268468224);
            return a;
        }
    }

    /* renamed from: android.support.v4.content.IntentCompat$c */
    static class C0113c extends C0112b {
        C0113c() {
        }

        /* renamed from: a */
        public Intent mo814a(ComponentName componentName) {
            return C0600as.m3400a(componentName);
        }

        /* renamed from: b */
        public Intent mo816b(ComponentName componentName) {
            return C0600as.m3401b(componentName);
        }
    }

    /* renamed from: android.support.v4.content.IntentCompat$d */
    static class C0114d extends C0113c {
        C0114d() {
        }

        /* renamed from: a */
        public Intent mo815a(String str, String str2) {
            return C0601at.m3402a(str, str2);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 15) {
            f444a = new C0114d();
        } else if (i >= 11) {
            f444a = new C0113c();
        } else {
            f444a = new C0112b();
        }
    }

    private IntentCompat() {
    }

    public static Intent makeMainActivity(ComponentName componentName) {
        return f444a.mo814a(componentName);
    }

    public static Intent makeMainSelectorActivity(String str, String str2) {
        return f444a.mo815a(str, str2);
    }

    public static Intent makeRestartActivityTask(ComponentName componentName) {
        return f444a.mo816b(componentName);
    }
}
