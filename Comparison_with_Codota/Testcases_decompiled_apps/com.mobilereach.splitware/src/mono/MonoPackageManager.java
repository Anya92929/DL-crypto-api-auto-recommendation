package mono;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.util.Locale;
import mono.android.Runtime;
import mono.android.app.ApplicationRegistration;
import mono.android.app.NotifyTimeZoneChanges;

public class MonoPackageManager {
    static Context Context;
    static boolean initialized;
    static Object lock = new Object();

    public static void LoadApplication(Context context, ApplicationInfo applicationInfo, String[] strArr) {
        synchronized (lock) {
            if (context instanceof Application) {
                Context = context;
            }
            if (!initialized) {
                context.registerReceiver(new NotifyTimeZoneChanges(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
                System.loadLibrary("monodroid");
                Locale locale = Locale.getDefault();
                String absolutePath = context.getFilesDir().getAbsolutePath();
                String absolutePath2 = context.getCacheDir().getAbsolutePath();
                String nativeLibraryPath = getNativeLibraryPath(context);
                String[] strArr2 = {absolutePath, absolutePath2, nativeLibraryPath};
                String[] strArr3 = strArr;
                Runtime.init(locale.getLanguage() + "-" + locale.getCountry(), strArr3, getNativeLibraryPath(applicationInfo), strArr2, context.getClassLoader(), new File(Environment.getExternalStorageDirectory(), "Android/data/" + context.getPackageName() + "/files/.__override__").getAbsolutePath(), MonoPackageManager_Resources.Assemblies, context.getPackageName());
                ApplicationRegistration.registerApplications();
                initialized = true;
            }
        }
    }

    public static void setContext(Context context) {
    }

    static String getNativeLibraryPath(Context context) {
        return getNativeLibraryPath(context.getApplicationInfo());
    }

    static String getNativeLibraryPath(ApplicationInfo applicationInfo) {
        if (Build.VERSION.SDK_INT >= 9) {
            return applicationInfo.nativeLibraryDir;
        }
        return applicationInfo.dataDir + "/lib";
    }

    public static String[] getAssemblies() {
        return MonoPackageManager_Resources.Assemblies;
    }

    public static String[] getDependencies() {
        return MonoPackageManager_Resources.Dependencies;
    }

    public static String getApiPackageName() {
        return MonoPackageManager_Resources.ApiPackageName;
    }
}
