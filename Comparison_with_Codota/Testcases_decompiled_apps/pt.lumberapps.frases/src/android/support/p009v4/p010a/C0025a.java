package android.support.p009v4.p010a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.support.p009v4.p018e.C0130c;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;

/* renamed from: android.support.v4.a.a */
public class C0025a {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";
    private static final Object sLock = new Object();
    private static TypedValue sTempValue;

    private static File buildPath(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            String str = strArr[i];
            i++;
            file2 = file2 == null ? new File(str) : str != null ? new File(file2, str) : file2;
        }
        return file2;
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    @Deprecated
    public static Context createDeviceEncryptedStorageContext(Context context) {
        return createDeviceProtectedStorageContext(context);
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        if (C0130c.m319a()) {
            return C0038d.m149b(context);
        }
        return null;
    }

    private static synchronized File createFilesDir(File file) {
        synchronized (C0025a.class) {
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                Log.w(TAG, "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }

    public static File getCodeCacheDir(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? C0036b.m145b(context) : createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    public static final int getColor(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? C0037c.m147b(context, i) : context.getResources().getColor(i);
    }

    public static final ColorStateList getColorStateList(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? C0037c.m146a(context, i) : context.getResources().getColorStateList(i);
    }

    public static File getDataDir(Context context) {
        if (C0130c.m319a()) {
            return C0038d.m148a(context);
        }
        String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    public static final Drawable getDrawable(Context context, int i) {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            return C0036b.m143a(context, i);
        }
        if (i3 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (sLock) {
            if (sTempValue == null) {
                sTempValue = new TypedValue();
            }
            context.getResources().getValue(i, sTempValue, true);
            i2 = sTempValue.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static File[] getExternalCacheDirs(Context context) {
        File buildPath;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return C0042h.m156a(context);
        }
        if (i >= 8) {
            buildPath = C0039e.m151a(context);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context.getPackageName(), DIR_CACHE);
        }
        return new File[]{buildPath};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        File buildPath;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return C0042h.m157a(context, str);
        }
        if (i >= 8) {
            buildPath = C0039e.m152a(context, str);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context.getPackageName(), DIR_FILES, str);
        }
        return new File[]{buildPath};
    }

    public static File[] getObbDirs(Context context) {
        File buildPath;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return C0042h.m158b(context);
        }
        if (i >= 11) {
            buildPath = C0040f.m153a(context);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_OBB, context.getPackageName());
        }
        return new File[]{buildPath};
    }

    @Deprecated
    public static boolean isDeviceEncryptedStorage(Context context) {
        return isDeviceProtectedStorage(context);
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        if (C0130c.m319a()) {
            return C0038d.m150c(context);
        }
        return false;
    }

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, (Bundle) null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            C0041g.m155a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0040f.m154a(context, intentArr);
            return true;
        }
    }

    public final File getNoBackupFilesDir(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? C0036b.m144a(context) : createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }
}
