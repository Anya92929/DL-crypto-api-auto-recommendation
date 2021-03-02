package org.apache.cordova;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class DirectoryManager {
    private static final String LOG_TAG = "DirectoryManager";

    protected static boolean testFileExists(String name) {
        if (!testSaveLocationExists() || name.equals("")) {
            return false;
        }
        return constructFilePaths(Environment.getExternalStorageDirectory().toString(), name).exists();
    }

    protected static long getFreeDiskSpace(boolean checkInternal) {
        long freeSpace;
        if (Environment.getExternalStorageState().equals("mounted")) {
            freeSpace = freeSpaceCalculation(Environment.getExternalStorageDirectory().getPath());
        } else if (!checkInternal) {
            return -1;
        } else {
            freeSpace = freeSpaceCalculation("/");
        }
        return freeSpace;
    }

    private static long freeSpaceCalculation(String path) {
        StatFs stat = new StatFs(path);
        return (((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize())) / 1024;
    }

    protected static boolean testSaveLocationExists() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    private static File constructFilePaths(String file1, String file2) {
        if (file2.startsWith(file1)) {
            return new File(file2);
        }
        return new File(file1 + "/" + file2);
    }

    protected static String getTempDirectoryPath(Context ctx) {
        File cache;
        if (Environment.getExternalStorageState().equals("mounted")) {
            cache = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + ctx.getPackageName() + "/cache/");
        } else {
            cache = ctx.getCacheDir();
        }
        if (!cache.exists()) {
            cache.mkdirs();
        }
        return cache.getAbsolutePath();
    }
}
