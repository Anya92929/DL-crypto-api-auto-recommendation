package android.support.p001v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.p001v4.content.IntentCompat;
import android.util.Log;

/* renamed from: android.support.v4.app.NavUtils */
public class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";

    /* renamed from: a */
    private static final C0066a f274a;

    /* renamed from: android.support.v4.app.NavUtils$a */
    interface C0066a {
        /* renamed from: a */
        Intent mo503a(Activity activity);

        /* renamed from: a */
        String mo504a(Context context, ActivityInfo activityInfo);

        /* renamed from: a */
        boolean mo505a(Activity activity, Intent intent);

        /* renamed from: b */
        void mo506b(Activity activity, Intent intent);
    }

    /* renamed from: android.support.v4.app.NavUtils$b */
    static class C0067b implements C0066a {
        C0067b() {
        }

        /* renamed from: a */
        public Intent mo503a(Activity activity) {
            String parentActivityName = NavUtils.getParentActivityName(activity);
            if (parentActivityName == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, parentActivityName);
            try {
                return NavUtils.getParentActivityName(activity, componentName) == null ? IntentCompat.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + parentActivityName + "' in manifest");
                return null;
            }
        }

        /* renamed from: a */
        public boolean mo505a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return action != null && !action.equals("android.intent.action.MAIN");
        }

        /* renamed from: b */
        public void mo506b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        /* renamed from: a */
        public String mo504a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString(NavUtils.PARENT_ACTIVITY);
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    /* renamed from: android.support.v4.app.NavUtils$c */
    static class C0068c extends C0067b {
        C0068c() {
        }

        /* renamed from: a */
        public Intent mo503a(Activity activity) {
            Intent a = C2016x.m7663a(activity);
            if (a == null) {
                return mo507b(activity);
            }
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Intent mo507b(Activity activity) {
            return super.mo503a(activity);
        }

        /* renamed from: a */
        public boolean mo505a(Activity activity, Intent intent) {
            return C2016x.m7665a(activity, intent);
        }

        /* renamed from: b */
        public void mo506b(Activity activity, Intent intent) {
            C2016x.m7666b(activity, intent);
        }

        /* renamed from: a */
        public String mo504a(Context context, ActivityInfo activityInfo) {
            String a = C2016x.m7664a(activityInfo);
            if (a == null) {
                return super.mo504a(context, activityInfo);
            }
            return a;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f274a = new C0068c();
        } else {
            f274a = new C0067b();
        }
    }

    public static boolean shouldUpRecreateTask(Activity activity, Intent intent) {
        return f274a.mo505a(activity, intent);
    }

    public static void navigateUpFromSameTask(Activity activity) {
        Intent parentActivityIntent = getParentActivityIntent(activity);
        if (parentActivityIntent == null) {
            throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
        }
        navigateUpTo(activity, parentActivityIntent);
    }

    public static void navigateUpTo(Activity activity, Intent intent) {
        f274a.mo506b(activity, intent);
    }

    public static Intent getParentActivityIntent(Activity activity) {
        return f274a.mo503a(activity);
    }

    public static Intent getParentActivityIntent(Context context, Class<?> cls) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, new ComponentName(context, cls));
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, parentActivityName);
        return getParentActivityName(context, componentName) == null ? IntentCompat.makeMainActivity(componentName) : new Intent().setComponent(componentName);
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
        return getParentActivityName(context, componentName2) == null ? IntentCompat.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    @Nullable
    public static String getParentActivityName(Activity activity) {
        try {
            return getParentActivityName(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Nullable
    public static String getParentActivityName(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return f274a.mo504a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    private NavUtils() {
    }
}
