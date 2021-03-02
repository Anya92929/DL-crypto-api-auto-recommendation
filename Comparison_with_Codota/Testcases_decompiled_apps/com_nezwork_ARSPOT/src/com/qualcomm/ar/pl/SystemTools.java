package com.qualcomm.ar.pl;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class SystemTools {
    public static final int AR_ERROR_INVALID_ENUM = 3;
    public static final int AR_ERROR_INVALID_HANDLE = 4;
    public static final int AR_ERROR_INVALID_OPERATION = 5;
    public static final int AR_ERROR_INVALID_VALUE = 2;
    public static final int AR_ERROR_NONE = 0;
    public static final int AR_ERROR_OPERATION_CANCELED = 7;
    public static final int AR_ERROR_OPERATION_FAILED = 6;
    public static final int AR_ERROR_UNKNOWN = 1;
    public static final int AR_VIDEOTEXTURE_ROTATION_LANDSCAPE_LEFT = 268455955;
    public static final int AR_VIDEOTEXTURE_ROTATION_LANDSCAPE_RIGHT = 268455956;
    public static final int AR_VIDEOTEXTURE_ROTATION_PORTRAIT = 268455953;
    public static final int AR_VIDEOTEXTURE_ROTATION_PORTRAIT_UPSIDEDOWN = 268455954;
    private static final String MODULENAME = "SystemTools";

    public static native Activity getActivityFromNative();

    public static native void logSystemError(String str);

    public static native void setSystemErrorCode(int i);

    public static boolean checkMinimumApiLevel(int apiLevel) {
        return Build.VERSION.SDK_INT >= apiLevel;
    }

    public static Method retrieveClassMethod(Class<?> cls, String name, Class<?>... parameterTypes) {
        Method classMethod = null;
        try {
            classMethod = cls.getMethod(name, parameterTypes);
        } catch (Exception e) {
        }
        if (classMethod != null) {
        }
        return classMethod;
    }

    public static int getActivityOrientation(Activity activity) {
        int displayRotation;
        if (activity == null) {
            return -1;
        }
        Configuration config = activity.getResources().getConfiguration();
        Display display = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (checkMinimumApiLevel(8)) {
            displayRotation = display.getRotation();
        } else {
            displayRotation = display.getOrientation();
        }
        switch (config.orientation) {
            case 1:
            case AR_ERROR_INVALID_ENUM /*3*/:
                return (displayRotation == 0 || displayRotation == 3) ? AR_VIDEOTEXTURE_ROTATION_PORTRAIT : AR_VIDEOTEXTURE_ROTATION_PORTRAIT_UPSIDEDOWN;
            case 2:
                return (displayRotation == 0 || displayRotation == 1) ? AR_VIDEOTEXTURE_ROTATION_LANDSCAPE_LEFT : AR_VIDEOTEXTURE_ROTATION_LANDSCAPE_RIGHT;
            default:
                return -1;
        }
    }

    public static String getNativeLibraryPath(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            ApplicationInfo appInfo = activity.getApplicationInfo();
            if (appInfo == null) {
                return null;
            }
            if (!checkMinimumApiLevel(9)) {
                return "/data/data/" + activity.getPackageName() + "/lib/";
            }
            String path = appInfo.nativeLibraryDir;
            if (path == null || path.length() <= 0 || path.charAt(path.length() - 1) == '/') {
                return path;
            }
            return path + '/';
        } catch (Exception e) {
            return null;
        }
    }

    public static int[] getActivitySize(Activity activity) {
        if (activity == null) {
            return null;
        }
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;
        if (screenWidth <= 0 || screenHeight <= 0) {
            return null;
        }
        return new int[]{screenWidth, screenHeight};
    }
}
