package android.support.p000v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import java.io.File;

/* renamed from: android.support.v4.content.ContextCompat */
public class ContextCompat {
    /* renamed from: a */
    private static synchronized File m618a(File file) {
        synchronized (ContextCompat.class) {
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }

    /* renamed from: a */
    private static File m619a(File file, String... strArr) {
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

    public static final int getColor(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? ContextCompatApi23.getColor(context, i) : context.getResources().getColor(i);
    }

    public static final ColorStateList getColorStateList(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? ContextCompatApi23.getColorStateList(context, i) : context.getResources().getColorStateList(i);
    }

    public static final Drawable getDrawable(Context context, int i) {
        return Build.VERSION.SDK_INT >= 21 ? ContextCompatApi21.getDrawable(context, i) : context.getResources().getDrawable(i);
    }

    public static File[] getExternalCacheDirs(Context context) {
        File a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getExternalCacheDirs(context);
        }
        if (i >= 8) {
            a = ContextCompatFroyo.getExternalCacheDir(context);
        } else {
            a = m619a(Environment.getExternalStorageDirectory(), "Android", "data", context.getPackageName(), "cache");
        }
        return new File[]{a};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        File a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getExternalFilesDirs(context, str);
        }
        if (i >= 8) {
            a = ContextCompatFroyo.getExternalFilesDir(context, str);
        } else {
            a = m619a(Environment.getExternalStorageDirectory(), "Android", "data", context.getPackageName(), "files", str);
        }
        return new File[]{a};
    }

    public static File[] getObbDirs(Context context) {
        File a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getObbDirs(context);
        }
        if (i >= 11) {
            a = ContextCompatHoneycomb.getObbDir(context);
        } else {
            a = m619a(Environment.getExternalStorageDirectory(), "Android", "obb", context.getPackageName());
        }
        return new File[]{a};
    }

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, (Bundle) null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            ContextCompatJellybean.startActivities(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            ContextCompatHoneycomb.m620a(context, intentArr);
            return true;
        }
    }

    public final File getCodeCacheDir(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? ContextCompatApi21.getCodeCacheDir(context) : m618a(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    public final File getNoBackupFilesDir(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? ContextCompatApi21.getNoBackupFilesDir(context) : m618a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }
}
