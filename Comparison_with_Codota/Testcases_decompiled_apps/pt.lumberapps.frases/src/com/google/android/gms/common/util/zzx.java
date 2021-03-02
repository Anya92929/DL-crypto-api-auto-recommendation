package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;

public class zzx {
    /* renamed from: a */
    private static synchronized File m6205a(File file) {
        synchronized (zzx.class) {
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                String valueOf = String.valueOf(file.getPath());
                Log.w("SupportV4Utils", valueOf.length() != 0 ? "Unable to create no-backup dir ".concat(valueOf) : new String("Unable to create no-backup dir "));
                file = null;
            }
        }
        return file;
    }

    @TargetApi(21)
    public static File getNoBackupFilesDir(Context context) {
        return zzs.zzavx() ? context.getNoBackupFilesDir() : m6205a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }
}
