package com.google.zxing.client.android.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.zxing.client.android.PreferencesActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

final class CameraConfigurationManager {
    private static final double MAX_ASPECT_DISTORTION = 0.15d;
    private static final int MIN_PREVIEW_PIXELS = 153600;
    private static final String TAG = "CameraConfiguration";
    private Point cameraResolution;
    private final Context context;
    private Point screenResolution;

    CameraConfigurationManager(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public void initFromCameraParameters(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display display = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        this.screenResolution = new Point(display.getWidth(), display.getHeight());
        Log.i(TAG, "Screen resolution: " + this.screenResolution);
        this.cameraResolution = findBestPreviewSizeValue(parameters, this.screenResolution);
        Log.i(TAG, "Camera resolution: " + this.cameraResolution);
    }

    /* access modifiers changed from: package-private */
    public void setDesiredCameraParameters(Camera camera, boolean safeMode) {
        String colorMode;
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w(TAG, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i(TAG, "Initial camera parameters: " + parameters.flatten());
        if (safeMode) {
            Log.w(TAG, "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
        initializeTorch(parameters, prefs, safeMode);
        String focusMode = null;
        if (prefs.getBoolean(PreferencesActivity.KEY_AUTO_FOCUS, true)) {
            if (safeMode || prefs.getBoolean(PreferencesActivity.KEY_DISABLE_CONTINUOUS_FOCUS, false)) {
                focusMode = findSettableValue(parameters.getSupportedFocusModes(), "auto");
            } else {
                focusMode = findSettableValue(parameters.getSupportedFocusModes(), "continuous-picture", "continuous-video", "auto");
            }
        }
        if (!safeMode && focusMode == null) {
            focusMode = findSettableValue(parameters.getSupportedFocusModes(), "macro", "edof");
        }
        if (focusMode != null) {
            parameters.setFocusMode(focusMode);
        }
        if (prefs.getBoolean(PreferencesActivity.KEY_INVERT_SCAN, false) && (colorMode = findSettableValue(parameters.getSupportedColorEffects(), "negative")) != null) {
            parameters.setColorEffect(colorMode);
        }
        parameters.setPreviewSize(this.cameraResolution.x, this.cameraResolution.y);
        camera.setParameters(parameters);
        if (this.context.getResources().getConfiguration().orientation == 1) {
            camera.setDisplayOrientation(90);
        }
    }

    /* access modifiers changed from: package-private */
    public Point getCameraResolution() {
        return this.cameraResolution;
    }

    /* access modifiers changed from: package-private */
    public Point getScreenResolution() {
        return this.screenResolution;
    }

    /* access modifiers changed from: package-private */
    public boolean getTorchState(Camera camera) {
        String flashMode;
        if (camera == null || camera.getParameters() == null || (flashMode = camera.getParameters().getFlashMode()) == null) {
            return false;
        }
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setTorch(Camera camera, boolean newSetting) {
        Camera.Parameters parameters = camera.getParameters();
        doSetTorch(parameters, newSetting, false);
        camera.setParameters(parameters);
    }

    private void initializeTorch(Camera.Parameters parameters, SharedPreferences prefs, boolean safeMode) {
        doSetTorch(parameters, FrontLightMode.readPref(prefs) == FrontLightMode.ON, safeMode);
    }

    private void doSetTorch(Camera.Parameters parameters, boolean newSetting, boolean safeMode) {
        String flashMode;
        if (newSetting) {
            flashMode = findSettableValue(parameters.getSupportedFlashModes(), "torch", "on");
        } else {
            flashMode = findSettableValue(parameters.getSupportedFlashModes(), "off");
        }
        if (flashMode != null) {
            parameters.setFlashMode(flashMode);
        }
    }

    private Point findBestPreviewSizeValue(Camera.Parameters parameters, Point screenResolution2) {
        boolean isCandidatePortrait;
        int maybeFlippedWidth;
        int maybeFlippedHeight;
        List<Camera.Size> rawSupportedSizes = parameters.getSupportedPreviewSizes();
        if (rawSupportedSizes == null) {
            Log.w(TAG, "Device returned no supported preview sizes; using default");
            Camera.Size defaultSize = parameters.getPreviewSize();
            return new Point(defaultSize.width, defaultSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList<>(rawSupportedSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            public int compare(Camera.Size a, Camera.Size b) {
                int aPixels = a.height * a.width;
                int bPixels = b.height * b.width;
                if (bPixels < aPixels) {
                    return -1;
                }
                if (bPixels > aPixels) {
                    return 1;
                }
                return 0;
            }
        });
        if (Log.isLoggable(TAG, 4)) {
            StringBuilder previewSizesString = new StringBuilder();
            for (Camera.Size supportedPreviewSize : arrayList) {
                previewSizesString.append(supportedPreviewSize.width).append('x').append(supportedPreviewSize.height).append(' ');
            }
            Log.i(TAG, "Supported preview sizes: " + previewSizesString);
        }
        double screenAspectRatio = ((double) screenResolution2.x) / ((double) screenResolution2.y);
        Iterator<Camera.Size> it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size supportedPreviewSize2 = it.next();
            int realWidth = supportedPreviewSize2.width;
            int realHeight = supportedPreviewSize2.height;
            if (realWidth * realHeight < MIN_PREVIEW_PIXELS) {
                it.remove();
            } else {
                if (this.context.getResources().getConfiguration().orientation == 2) {
                    isCandidatePortrait = realWidth < realHeight;
                } else {
                    isCandidatePortrait = (realWidth < realHeight) ^ (screenResolution2.x < screenResolution2.y);
                }
                if (isCandidatePortrait) {
                    maybeFlippedWidth = realHeight;
                } else {
                    maybeFlippedWidth = realWidth;
                }
                if (isCandidatePortrait) {
                    maybeFlippedHeight = realWidth;
                } else {
                    maybeFlippedHeight = realHeight;
                }
                if (Math.abs((((double) maybeFlippedWidth) / ((double) maybeFlippedHeight)) - screenAspectRatio) > MAX_ASPECT_DISTORTION) {
                    it.remove();
                } else if (maybeFlippedWidth == screenResolution2.x && maybeFlippedHeight == screenResolution2.y) {
                    Point exactPoint = new Point(realWidth, realHeight);
                    Log.i(TAG, "Found preview size exactly matching screen size: " + exactPoint);
                    return exactPoint;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Camera.Size largestPreview = (Camera.Size) arrayList.get(0);
            Point largestSize = new Point(largestPreview.width, largestPreview.height);
            Log.i(TAG, "Using largest suitable preview size: " + largestSize);
            return largestSize;
        }
        Camera.Size defaultPreview = parameters.getPreviewSize();
        Point defaultSize2 = new Point(defaultPreview.width, defaultPreview.height);
        Log.i(TAG, "No suitable preview sizes, using default: " + defaultSize2);
        return defaultSize2;
    }

    private static String findSettableValue(Collection<String> supportedValues, String... desiredValues) {
        Log.i(TAG, "Supported values: " + supportedValues);
        String result = null;
        if (supportedValues != null) {
            int length = desiredValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String desiredValue = desiredValues[i];
                if (supportedValues.contains(desiredValue)) {
                    result = desiredValue;
                    break;
                }
                i++;
            }
        }
        Log.i(TAG, "Settable value: " + result);
        return result;
    }
}
