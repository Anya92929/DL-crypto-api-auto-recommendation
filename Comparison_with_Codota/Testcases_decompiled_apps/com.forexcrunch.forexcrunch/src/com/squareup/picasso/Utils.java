package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadFactory;

final class Utils {
    static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    static final int DEFAULT_READ_TIMEOUT = 20000;
    private static final int KEY_PADDING = 50;
    private static final int MAX_DISK_CACHE_SIZE = 52428800;
    private static final int MAX_MEM_CACHE_SIZE = 31457280;
    private static final int MIN_DISK_CACHE_SIZE = 5242880;
    private static final String PICASSO_CACHE = "picasso-cache";
    static final String THREAD_IDLE_NAME = "Picasso-Idle";
    static final String THREAD_PREFIX = "Picasso-";

    private Utils() {
    }

    static int getBitmapBytes(Bitmap bitmap) {
        int result;
        if (Build.VERSION.SDK_INT >= 12) {
            result = BitmapHoneycombMR1.getByteCount(bitmap);
        } else {
            result = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (result >= 0) {
            return result;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static void checkNotMain() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static String createKey(Request data) {
        StringBuilder builder;
        if (data.uri != null) {
            String path = data.uri.toString();
            builder = new StringBuilder(path.length() + 50);
            builder.append(path);
        } else {
            builder = new StringBuilder(50);
            builder.append(data.resourceId);
        }
        builder.append(10);
        if (data.rotationDegrees != BitmapDescriptorFactory.HUE_RED) {
            builder.append("rotation:").append(data.rotationDegrees);
            if (data.hasRotationPivot) {
                builder.append('@').append(data.rotationPivotX).append('x').append(data.rotationPivotY);
            }
            builder.append(10);
        }
        if (data.targetWidth != 0) {
            builder.append("resize:").append(data.targetWidth).append('x').append(data.targetHeight);
            builder.append(10);
        }
        if (data.centerCrop) {
            builder.append("centerCrop\n");
        } else if (data.centerInside) {
            builder.append("centerInside\n");
        }
        if (data.transformations != null) {
            int count = data.transformations.size();
            for (int i = 0; i < count; i++) {
                builder.append(data.transformations.get(i).key());
                builder.append(10);
            }
        }
        return builder.toString();
    }

    static void closeQuietly(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    static boolean parseResponseSourceHeader(String header) {
        boolean z = true;
        if (header == null) {
            return false;
        }
        String[] parts = header.split(" ", 2);
        if ("CACHE".equals(parts[0])) {
            return true;
        }
        if (parts.length == 1) {
            return false;
        }
        try {
            if (!"CONDITIONAL_CACHE".equals(parts[0]) || Integer.parseInt(parts[1]) != 304) {
                z = false;
            }
            return z;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static Downloader createDefaultDownloader(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return OkHttpLoaderCreator.create(context);
        } catch (ClassNotFoundException e) {
            return new UrlConnectionDownloader(context);
        }
    }

    static File createDefaultCacheDir(Context context) {
        File cache = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (!cache.exists()) {
            cache.mkdirs();
        }
        return cache;
    }

    static long calculateDiskCacheSize(File dir) {
        long size = 5242880;
        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            size = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException e) {
        }
        return Math.max(Math.min(size, 52428800), 5242880);
    }

    static int calculateMemoryCacheSize(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        boolean largeHeap = (context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0;
        int memoryClass = am.getMemoryClass();
        if (largeHeap && Build.VERSION.SDK_INT >= 11) {
            memoryClass = ActivityManagerHoneycomb.getLargeMemoryClass(am);
        }
        return Math.min((AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START * memoryClass) / 7, MAX_MEM_CACHE_SIZE);
    }

    static boolean isAirplaneModeOn(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
            return true;
        }
        return false;
    }

    static boolean hasPermission(Context context, String permission) {
        return context.checkCallingOrSelfPermission(permission) == 0;
    }

    @TargetApi(11)
    private static class ActivityManagerHoneycomb {
        private ActivityManagerHoneycomb() {
        }

        static int getLargeMemoryClass(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    static class PicassoThreadFactory implements ThreadFactory {
        PicassoThreadFactory() {
        }

        public Thread newThread(Runnable r) {
            return new PicassoThread(r);
        }
    }

    private static class PicassoThread extends Thread {
        public PicassoThread(Runnable r) {
            super(r);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    @TargetApi(12)
    private static class BitmapHoneycombMR1 {
        private BitmapHoneycombMR1() {
        }

        static int getByteCount(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    private static class OkHttpLoaderCreator {
        private OkHttpLoaderCreator() {
        }

        static Downloader create(Context context) {
            return new OkHttpDownloader(context);
        }
    }
}
