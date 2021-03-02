package com.google.zxing.client.android.camera.open;

import android.hardware.Camera;
import android.util.Log;

public final class OpenCameraInterface {
    private static final String TAG = OpenCameraInterface.class.getName();

    private OpenCameraInterface() {
    }

    public static Camera open() {
        int numCameras = Camera.getNumberOfCameras();
        if (numCameras == 0) {
            Log.w(TAG, "No cameras!");
            return null;
        }
        int index = 0;
        while (index < numCameras) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(index, cameraInfo);
            if (cameraInfo.facing == 0) {
                break;
            }
            index++;
        }
        if (index < numCameras) {
            Log.i(TAG, "Opening camera #" + index);
            return Camera.open(index);
        }
        Log.i(TAG, "No camera facing back; returning camera #0");
        return Camera.open(0);
    }
}
