package android.support.p000v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.p000v4.content.IntentCompat;
import android.util.Log;

/* renamed from: android.support.v4.app.NavUtils */
public class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";

    /* renamed from: a */
    private static final NavUtilsImpl f573a;

    /* renamed from: android.support.v4.app.NavUtils$NavUtilsImpl */
    interface NavUtilsImpl {
        Intent getParentActivityIntent(Activity activity);

        String getParentActivityName(Context context, ActivityInfo activityInfo);

        void navigateUpTo(Activity activity, Intent intent);

        boolean shouldUpRecreateTask(Activity activity, Intent intent);
    }

    /* renamed from: android.support.v4.app.NavUtils$NavUtilsImplBase */
    class NavUtilsImplBase implements NavUtilsImpl {
        NavUtilsImplBase() {
        }

        public Intent getParentActivityIntent(Activity activity) {
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

        public String getParentActivityName(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString(NavUtils.PARENT_ACTIVITY);
            if (string == null) {
                return null;
            }
            return string.charAt(0) == '.' ? context.getPackageName() + string : string;
        }

        public void navigateUpTo(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public boolean shouldUpRecreateTask(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return action != null && !action.equals("android.intent.action.MAIN");
        }
    }

    /* renamed from: android.support.v4.app.NavUtils$NavUtilsImplJB */
    class NavUtilsImplJB extends NavUtilsImplBase {
        NavUtilsImplJB() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Intent mo879a(Activity activity) {
            return super.getParentActivityIntent(activity);
        }

        public Intent getParentActivityIntent(Activity activity) {
            Intent parentActivityIntent = NavUtilsJB.getParentActivityIntent(activity);
            return parentActivityIntent == null ? mo879a(activity) : parentActivityIntent;
        }

        public String getParentActivityName(Context context, ActivityInfo activityInfo) {
            String parentActivityName = NavUtilsJB.getParentActivityName(activityInfo);
            return parentActivityName == null ? super.getParentActivityName(context, activityInfo) : parentActivityName;
        }

        public void navigateUpTo(Activity activity, Intent intent) {
            NavUtilsJB.navigateUpTo(activity, intent);
        }

        public boolean shouldUpRecreateTask(Activity activity, Intent intent) {
            return NavUtilsJB.shouldUpRecreateTask(activity, intent);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f573a = new NavUtilsImplJB();
        } else {
            f573a = new NavUtilsImplBase();
        }
    }

    private NavUtils() {
    }

    public static Intent getParentActivityIntent(Activity activity) {
        return f573a.getParentActivityIntent(activity);
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentName) {
        String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
        return getParentActivityName(context, componentName2) == null ? IntentCompat.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static Intent getParentActivityIntent(Context context, Class<?> cls) {
        String parentActivityName = getParentActivityName(context, new ComponentName(context, cls));
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, parentActivityName);
        return getParentActivityName(context, componentName) == null ? IntentCompat.makeMainActivity(componentName) : new Intent().setComponent(componentName);
    }

    public static String getParentActivityName(Activity activity) {
        try {
            return getParentActivityName(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getParentActivityName(Context context, ComponentName componentName) {
        return f573a.getParentActivityName(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void navigateUpFromSameTask(Activity activity) {
        Intent parentActivityIntent = getParentActivityIntent(activity);
        if (parentActivityIntent == null) {
            throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
        }
        navigateUpTo(activity, parentActivityIntent);
    }

    public static void navigateUpTo(Activity activity, Intent intent) {
        f573a.navigateUpTo(activity, intent);
    }

    public static boolean shouldUpRecreateTask(Activity activity, Intent intent) {
        return f573a.shouldUpRecreateTask(activity, intent);
    }
}
