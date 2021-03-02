package com.qualcomm.QCARUnityPlayer;

import android.app.Activity;
import com.qualcomm.QCAR.QCAR;
import com.unity3d.player.UnityPlayer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class QCARUnityPlayerLegacy extends UnityPlayer {
    private Activity mActivity = null;

    public native void setSurfaceOrientationNative(int i);

    public native void updateQCARRendering(int i, int i2);

    public QCARUnityPlayerLegacy(Activity activity) {
        super(activity);
        this.mActivity = activity;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        DebugLog.LOGI("onSurfaceCreated");
        QCAR.onSurfaceCreated();
        super.onSurfaceCreated(gl, config);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        DebugLog.LOGI("onSurfaceChanged");
        updateQCARRendering(width, height);
        QCAR.onSurfaceChanged(width, height);
        super.onSurfaceChanged(gl, width, height);
    }

    public void onDrawFrame(GL10 gl) {
        setSurfaceOrientationNative(QCARUnityPlayerShared.getSurfaceOrientation(this.mActivity));
        super.onDrawFrame(gl);
    }
}
