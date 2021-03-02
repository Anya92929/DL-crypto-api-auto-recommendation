package com.qualcomm.QCAR;

import android.app.Activity;

public class QCAR {
    public static final int GL_11 = 1;
    public static final int GL_20 = 2;
    public static final int INIT_DEVICE_NOT_SUPPORTED = -2;
    public static final int INIT_ERROR = -1;

    public static native void deinit();

    public static native boolean isInitialized();

    public static native void onPause();

    public static native void onResume();

    public static native void onSurfaceChanged(int i, int i2);

    public static native void onSurfaceCreated();

    private static native void privateInit();

    private static native void privateSetInitParameters(Activity activity, int i);

    private static native int progressiveInit();

    public static native boolean requiresAlpha();

    public static int init() {
        return progressiveInit();
    }

    public static void setInitParameters(Activity nActivity, int nFlags) {
        privateSetInitParameters(nActivity, nFlags);
        privateInit();
    }
}
