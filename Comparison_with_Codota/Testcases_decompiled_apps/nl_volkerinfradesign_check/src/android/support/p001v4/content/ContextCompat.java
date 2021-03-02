package android.support.p001v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.support.annotation.NonNull;
import android.util.Log;
import java.io.File;

/* renamed from: android.support.v4.content.ContextCompat */
public class ContextCompat {
    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, (Bundle) null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            C0596ao.m3394a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0014an.m29a(context, intentArr);
            return true;
        }
    }

    public static File[] getObbDirs(Context context) {
        File a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return C0597ap.m3397b(context);
        }
        if (i >= 11) {
            a = C0014an.m28a(context);
        } else {
            a = m436a(Environment.getExternalStorageDirectory(), "Android", "obb", context.getPackageName());
        }
        return new File[]{a};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        File a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return C0597ap.m3396a(context, str);
        }
        if (i >= 8) {
            a = C0013am.m27a(context, str);
        } else {
            a = m436a(Environment.getExternalStorageDirectory(), "Android", "data", context.getPackageName(), "files", str);
        }
        return new File[]{a};
    }

    public static File[] getExternalCacheDirs(Context context) {
        File a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return C0597ap.m3395a(context);
        }
        if (i >= 8) {
            a = C0013am.m26a(context);
        } else {
            a = m436a(Environment.getExternalStorageDirectory(), "Android", "data", context.getPackageName(), "cache");
        }
        return new File[]{a};
    }

    /* renamed from: a */
    private static File m436a(File file, String... strArr) {
        File file2;
        int length = strArr.length;
        int i = 0;
        File file3 = file;
        while (i < length) {
            String str = strArr[i];
            if (file3 == null) {
                file2 = new File(str);
            } else if (str != null) {
                file2 = new File(file3, str);
            } else {
                file2 = file3;
            }
            i++;
            file3 = file2;
        }
        return file3;
    }

    public static final Drawable getDrawable(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0011ak.m21a(context, i);
        }
        return context.getResources().getDrawable(i);
    }

    public static final ColorStateList getColorStateList(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0012al.m24a(context, i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static final int getColor(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0012al.m25b(context, i);
        }
        return context.getResources().getColor(i);
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public final File getNoBackupFilesDir(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0011ak.m22a(context);
        }
        return m435a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public final File getCodeCacheDir(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0011ak.m23b(context);
        }
        return m435a(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    /* renamed from: a */
    private static synchronized File m435a(File file) {
        synchronized (ContextCompat.class) {
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}
