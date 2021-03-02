package com.qualcomm.ar.pl;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraPreview implements Camera.PreviewCallback {
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_FRAMERATES = 4;
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_IMAGEFORMATS = 5;
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_IMAGESIZES = 3;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_PARAMVALUES = 2;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_QUERYABLE_PARAMS = 0;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_SETTABLE_PARAMS = 1;
    private static final int CAMERA_CAPTUREINFO_VALUE_FORMAT = 2;
    private static final int CAMERA_CAPTUREINFO_VALUE_FRAMERATE = 3;
    private static final int CAMERA_CAPTUREINFO_VALUE_HEIGHT = 1;
    private static final int CAMERA_CAPTUREINFO_VALUE_PREVIEWSURFACEENABLED = 4;
    private static final int CAMERA_CAPTUREINFO_VALUE_WIDTH = 0;
    private static final int CAMERA_DIRECTION_BACK = 268443665;
    private static final int CAMERA_DIRECTION_FRONT = 268443666;
    private static final int CAMERA_DIRECTION_UNKNOWN = 268443664;
    private static final int CAMERA_EXPOSUREMODE_AUTO = 805314560;
    private static final int CAMERA_EXPOSUREMODE_CONTINUOUSAUTO = 805322752;
    private static final int CAMERA_EXPOSUREMODE_NORMAL = 805310464;
    private static final int CAMERA_FOCUSMODE_AUTO = 805306400;
    private static final int CAMERA_FOCUSMODE_CONTINUOUSAUTO = 805306432;
    private static final int CAMERA_FOCUSMODE_FIXED = 805306880;
    private static final int CAMERA_FOCUSMODE_INFINITY = 805306624;
    private static final int CAMERA_FOCUSMODE_MACRO = 805306496;
    private static final int CAMERA_FOCUSMODE_NORMAL = 805306384;
    private static final int CAMERA_IMAGE_FORMAT_ARGB32 = 268439813;
    private static final int CAMERA_IMAGE_FORMAT_ARGB8888 = 268439813;
    private static final int CAMERA_IMAGE_FORMAT_BGR24 = 268439822;
    private static final int CAMERA_IMAGE_FORMAT_BGR888 = 268439822;
    private static final int CAMERA_IMAGE_FORMAT_BGRA32 = 268439814;
    private static final int CAMERA_IMAGE_FORMAT_BGRA8888 = 268439814;
    private static final int[] CAMERA_IMAGE_FORMAT_CONVERSIONTABLE = {16, CAMERA_IMAGE_FORMAT_NV16, 17, CAMERA_IMAGE_FORMAT_NV21, 4, CAMERA_IMAGE_FORMAT_RGB565, 842094169, CAMERA_IMAGE_FORMAT_YV12};
    private static final int CAMERA_IMAGE_FORMAT_LUM = 268439809;
    private static final int CAMERA_IMAGE_FORMAT_NV12 = 268439815;
    private static final int CAMERA_IMAGE_FORMAT_NV16 = 268439816;
    private static final int CAMERA_IMAGE_FORMAT_NV21 = 268439817;
    private static final int CAMERA_IMAGE_FORMAT_RGB24 = 268439811;
    private static final int CAMERA_IMAGE_FORMAT_RGB565 = 268439810;
    private static final int CAMERA_IMAGE_FORMAT_RGB888 = 268439811;
    private static final int CAMERA_IMAGE_FORMAT_RGBA32 = 268439812;
    private static final int CAMERA_IMAGE_FORMAT_RGBA4444 = 268439821;
    private static final int CAMERA_IMAGE_FORMAT_RGBA5551 = 268439820;
    private static final int CAMERA_IMAGE_FORMAT_RGBA8888 = 268439812;
    private static final int CAMERA_IMAGE_FORMAT_UNKNOWN = 268439808;
    private static final int CAMERA_IMAGE_FORMAT_YV12 = 268439818;
    private static final int CAMERA_IMAGE_FORMAT_YV16 = 268439819;
    private static final int CAMERA_PARAMTYPE_BASE = 536870912;
    private static final int CAMERA_PARAMTYPE_BRIGHTNESSRANGE = 536936448;
    private static final int CAMERA_PARAMTYPE_BRIGHTNESSVALUE = 536903680;
    private static final int CAMERA_PARAMTYPE_CONTRASTRANGE = 537133056;
    private static final int CAMERA_PARAMTYPE_CONTRASTVALUE = 537001984;
    private static final int CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONRANGE = 536871424;
    private static final int CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONVALUE = 536871168;
    private static final int CAMERA_PARAMTYPE_EXPOSUREMODE = 536870944;
    private static final int CAMERA_PARAMTYPE_EXPOSURERANGE = 536871040;
    private static final int CAMERA_PARAMTYPE_EXPOSUREVALUE = 536870976;
    private static final int CAMERA_PARAMTYPE_FOCUSMODE = 536870914;
    private static final int CAMERA_PARAMTYPE_FOCUSRANGE = 536870920;
    private static final int CAMERA_PARAMTYPE_FOCUSREGION = 536870928;
    private static final int CAMERA_PARAMTYPE_FOCUSVALUE = 536870916;
    private static final int CAMERA_PARAMTYPE_ROTATION = 537395200;
    private static final int CAMERA_PARAMTYPE_TORCHMODE = 536870913;
    private static final int CAMERA_PARAMTYPE_WHITEBALANCEMODE = 536871936;
    private static final int CAMERA_PARAMTYPE_WHITEBALANCERANGE = 536875008;
    private static final int CAMERA_PARAMTYPE_WHITEBALANCEVALUE = 536872960;
    private static final int CAMERA_PARAMTYPE_ZOOMRANGE = 536887296;
    private static final int CAMERA_PARAMTYPE_ZOOMVALUE = 536879104;
    private static final int CAMERA_PARAMVALUE_BASE = 805306368;
    private static final int CAMERA_STATUS_CAPTURE_RUNNING = 268443651;
    private static final int CAMERA_STATUS_OPENED = 268443650;
    private static final int CAMERA_STATUS_UNINITIALIZED = 268443649;
    private static final int CAMERA_STATUS_UNKNOWN = 268443648;
    private static final int CAMERA_TORCHMODE_AUTO = 805306372;
    private static final int CAMERA_TORCHMODE_CONTINUOUSAUTO = 805306376;
    private static final int CAMERA_TORCHMODE_OFF = 805306369;
    private static final int CAMERA_TORCHMODE_ON = 805306370;
    private static final int CAMERA_TYPE_MONO = 268447761;
    private static final int CAMERA_TYPE_STEREO = 268447762;
    private static final int CAMERA_TYPE_UNKNOWN = 268447760;
    private static final int CAMERA_WHITEBALANCEMODE_AUTO = 805437440;
    private static final int CAMERA_WHITEBALANCEMODE_CONTINUOUSAUTO = 805568512;
    private static final int CAMERA_WHITEBALANCEMODE_NORMAL = 805371904;
    private static boolean CONVERT_FORMAT_TO_ANDROID = false;
    private static boolean CONVERT_FORMAT_TO_PL = true;
    private static final String MODULENAME = "CameraPreview";
    private static final int NUM_CAPTURE_BUFFERS = 2;
    private static final int NUM_CAPTURE_BUFFERS_TO_ADD = 2;
    private static final int NUM_MAX_CAMERAOPEN_RETRY = 10;
    private static final int TIME_CAMERAOPEN_RETRY_DELAY_MS = 250;
    private static final int _NUM_CAMERA_CAPSINFO_VALUE_ = 6;
    private static final int _NUM_CAMERA_CAPTUREINFO_VALUE_ = 5;
    private static Object[] _addCallbackBufferArgs;
    private static Method _addCallbackBufferFunc;
    private static Method _setPreviewCallbackWithBufferFunc;
    private static Method _setPreviewTextureFunc;
    private static Constructor<?> _surfaceTextureConstructor;
    private static Method _updateTexImage;
    private Vector<CameraCacheInfo> cameraCacheInfo = null;
    /* access modifiers changed from: private */
    public HashMap<Camera, Integer> cameraCacheInfoIndexCache = null;
    SurfaceManager surfaceManager = null;

    private native void newFrameAvailable(int i, int i2, int i3, int i4, byte[] bArr);

    public class CameraCacheInfo {
        byte[][] buffer;
        int bufferFormatPL;
        int bufferHeight;
        int bufferWidth;
        Camera camera;
        int[] caps;
        int deviceID;
        boolean isAutoFocusing;
        int overrideFormatAndroid;
        int overrideHeight;
        int overrideWidth;
        int requestFormatAndroid;
        int requestHeight;
        int requestWidth;
        int status;
        CameraSurface surface;
        Object surfaceTexture;

        public CameraCacheInfo() {
        }
    }

    public CameraPreview() {
        _addCallbackBufferFunc = null;
        _addCallbackBufferArgs = null;
        _setPreviewCallbackWithBufferFunc = null;
    }

    private boolean checkPermission() {
        try {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity.getPackageManager().checkPermission("android.permission.CAMERA", activity.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    private int getCameraDeviceIndex(int camIndex, int type, int direction) {
        if (type != CAMERA_TYPE_UNKNOWN) {
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            int camInfoDirection = -1;
            switch (direction) {
                case CAMERA_DIRECTION_UNKNOWN /*268443664*/:
                    break;
                case CAMERA_DIRECTION_BACK /*268443665*/:
                    camInfoDirection = 0;
                    break;
                case CAMERA_DIRECTION_FRONT /*268443666*/:
                    camInfoDirection = 1;
                    break;
                default:
                    SystemTools.setSystemErrorCode(2);
                    return -1;
            }
            int num = Camera.getNumberOfCameras();
            int i = 0;
            while (i < num) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                try {
                    Camera.getCameraInfo(i, cameraInfo);
                    if ((camInfoDirection < 0 || camInfoDirection == cameraInfo.facing) && (camIndex < 0 || camIndex == i)) {
                        return i;
                    }
                } catch (Exception e) {
                }
                i++;
            }
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (direction == CAMERA_DIRECTION_FRONT) {
            SystemTools.setSystemErrorCode(2);
            return -1;
        } else if (camIndex < 1) {
            return 0;
        } else {
            SystemTools.setSystemErrorCode(2);
            return -1;
        }
    }

    private Camera.Parameters getCameraParameters(Camera camera) {
        try {
            return camera.getParameters();
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public CameraCacheInfo getCameraCacheInfo(int cameraCacheInfoIndex) {
        if (cameraCacheInfoIndex < 0 || cameraCacheInfoIndex >= this.cameraCacheInfo.size()) {
            return null;
        }
        return this.cameraCacheInfo.get(cameraCacheInfoIndex);
    }

    private boolean setCustomCameraParams(Camera.Parameters cameraParams, String customData) {
        try {
            JSONObject jsonObj = new JSONObject(customData);
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                try {
                    Object value = jsonObj.get(key);
                    if (value.getClass() == String.class) {
                        cameraParams.set(key, (String) value);
                    } else if (value.getClass() == Integer.class) {
                        cameraParams.set(key, ((Integer) value).intValue());
                    } else {
                        JSONObject jSONObject = jsonObj;
                        return false;
                    }
                } catch (JSONException e) {
                    JSONObject jSONObject2 = jsonObj;
                    return false;
                }
            }
            JSONObject jSONObject3 = jsonObj;
            return true;
        } catch (JSONException e2) {
            return false;
        }
    }

    private boolean setCameraCaptureParams(CameraCacheInfo camCacheInfo, Camera.Parameters camParams, int[] captureInfo, int[] overrideCaptureInfo) {
        boolean previewSurfaceEnabled;
        if (!(captureInfo == null && overrideCaptureInfo == null)) {
            camCacheInfo.overrideWidth = overrideCaptureInfo != null ? overrideCaptureInfo[0] : captureInfo[0];
            camCacheInfo.overrideHeight = overrideCaptureInfo != null ? overrideCaptureInfo[1] : captureInfo[1];
            camCacheInfo.overrideFormatAndroid = translateImageFormat(overrideCaptureInfo != null ? overrideCaptureInfo[2] : captureInfo[2], CONVERT_FORMAT_TO_ANDROID);
        }
        if (captureInfo == null) {
            return true;
        }
        camCacheInfo.requestWidth = captureInfo[0];
        camCacheInfo.requestHeight = captureInfo[1];
        camCacheInfo.requestFormatAndroid = translateImageFormat(captureInfo[2], CONVERT_FORMAT_TO_ANDROID);
        int framerate = captureInfo[3];
        try {
            if (camCacheInfo.requestWidth > 0 && camCacheInfo.requestHeight > 0) {
                camParams.setPreviewSize(camCacheInfo.requestWidth, camCacheInfo.requestHeight);
            }
            if (framerate > 0) {
                camParams.setPreviewFrameRate(framerate);
            }
            if (camCacheInfo.requestFormatAndroid != 0) {
                camParams.setPreviewFormat(camCacheInfo.requestFormatAndroid);
            }
            if (captureInfo[4] > 0) {
                previewSurfaceEnabled = true;
            } else {
                previewSurfaceEnabled = false;
            }
            if (previewSurfaceEnabled) {
                if (SystemTools.checkMinimumApiLevel(11)) {
                    Object[] argList = {new Integer(-1)};
                    try {
                        camCacheInfo.surfaceTexture = _surfaceTextureConstructor.newInstance(argList);
                        try {
                            argList[0] = camCacheInfo.surfaceTexture;
                            _setPreviewTextureFunc.invoke(camCacheInfo.camera, argList);
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        return false;
                    }
                } else if (this.surfaceManager == null) {
                    return false;
                } else {
                    if (!this.surfaceManager.addCameraSurface(camCacheInfo)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e3) {
            return false;
        }
    }

    private boolean setupPreviewBuffer(CameraCacheInfo cci) {
        int bitsPerPixel;
        Camera.Parameters cameraParams = getCameraParameters(cci.camera);
        if (cameraParams == null) {
            return false;
        }
        try {
            cci.bufferWidth = cci.requestWidth == cci.overrideWidth ? cameraParams.getPreviewSize().width : cci.overrideWidth;
            cci.bufferHeight = cci.requestHeight == cci.overrideHeight ? cameraParams.getPreviewSize().height : cci.overrideHeight;
            int bufferFormatAndroid = cci.requestFormatAndroid == cci.overrideFormatAndroid ? cameraParams.getPreviewFormat() : cci.overrideFormatAndroid;
            cci.bufferFormatPL = translateImageFormat(bufferFormatAndroid, CONVERT_FORMAT_TO_PL);
            try {
                PixelFormat pixelFormatInfo = new PixelFormat();
                PixelFormat.getPixelFormatInfo(bufferFormatAndroid, pixelFormatInfo);
                bitsPerPixel = pixelFormatInfo.bitsPerPixel;
            } catch (Exception e) {
                bitsPerPixel = getBitsPerPixel(bufferFormatAndroid);
                if (bitsPerPixel == 0) {
                    return false;
                }
            }
            int bufferSize = (((cci.bufferWidth * cci.bufferHeight) * bitsPerPixel) / 8) + 4096;
            cci.buffer = new byte[2][];
            for (int i = 0; i < 2; i++) {
                cci.buffer[i] = new byte[bufferSize];
                if (i < 2) {
                    _addCallbackBuffer(cci.camera, cci.buffer[i]);
                }
            }
            _setPreviewCallbackWithBuffer(cci.camera, this);
            System.gc();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private void setCameraCapsBit(CameraCacheInfo cci, int capsIndex, int paramType, boolean value) {
        int baseValue;
        switch (capsIndex) {
            case SystemTools.AR_ERROR_NONE /*0*/:
            case 1:
                baseValue = CAMERA_PARAMTYPE_BASE;
                break;
            case 2:
                baseValue = CAMERA_PARAMVALUE_BASE;
                break;
            default:
                return;
        }
        int index = (int) (Math.log((double) ((baseValue ^ -1) & paramType)) / Math.log(2.0d));
        if (value) {
            int[] iArr = cci.caps;
            iArr[capsIndex] = iArr[capsIndex] | (1 << index);
            return;
        }
        int[] iArr2 = cci.caps;
        iArr2[capsIndex] = iArr2[capsIndex] & ((1 << index) ^ -1);
    }

    private int translateImageFormat(int fromValue, boolean conversionMode) {
        int i = 0;
        while (i < CAMERA_IMAGE_FORMAT_CONVERSIONTABLE.length / 2) {
            if (fromValue != (conversionMode == CONVERT_FORMAT_TO_PL ? CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2] : CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[(i * 2) + 1])) {
                i++;
            } else if (conversionMode == CONVERT_FORMAT_TO_PL) {
                return CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[(i * 2) + 1];
            } else {
                return CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2];
            }
        }
        if (conversionMode == CONVERT_FORMAT_TO_PL) {
            return CAMERA_IMAGE_FORMAT_UNKNOWN;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getBitsPerPixel(int imgFormat) {
        switch (imgFormat) {
            case SystemTools.AR_ERROR_INVALID_HANDLE /*4*/:
            case 16:
                return 16;
            case 17:
                return 12;
            case 842094169:
                return 12;
            default:
                return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r1 = ((java.lang.Integer) r7).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreviewFrame(byte[] r9, android.hardware.Camera r10) {
        /*
            r8 = this;
            java.util.HashMap<android.hardware.Camera, java.lang.Integer> r0 = r8.cameraCacheInfoIndexCache
            java.lang.Object r7 = r0.get(r10)
            if (r7 != 0) goto L_0x0009
        L_0x0008:
            return
        L_0x0009:
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r1 = r7.intValue()
            com.qualcomm.ar.pl.CameraPreview$CameraCacheInfo r6 = r8.getCameraCacheInfo(r1)
            if (r6 == 0) goto L_0x0008
            int r2 = r6.bufferWidth
            int r3 = r6.bufferHeight
            int r4 = r6.bufferFormatPL
            r0 = r8
            r5 = r9
            r0.newFrameAvailable(r1, r2, r3, r4, r5)
            r8._addCallbackBuffer(r10, r9)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualcomm.ar.pl.CameraPreview.onPreviewFrame(byte[], android.hardware.Camera):void");
    }

    private void _addCallbackBuffer(Camera cam, byte[] buffer) {
        _addCallbackBufferArgs[0] = buffer;
        try {
            _addCallbackBufferFunc.invoke(cam, _addCallbackBufferArgs);
        } catch (Exception e) {
        }
    }

    private void _setPreviewCallbackWithBuffer(Camera cam, Camera.PreviewCallback previewCB) {
        try {
            _setPreviewCallbackWithBufferFunc.invoke(cam, new Object[]{previewCB});
        } catch (Exception e) {
        }
    }

    public boolean init() {
        this.cameraCacheInfo = new Vector<>();
        this.cameraCacheInfoIndexCache = new HashMap<>();
        try {
            Class<?> cameraClass = Class.forName("android.hardware.Camera");
            _addCallbackBufferFunc = SystemTools.retrieveClassMethod(cameraClass, "addCallbackBuffer", new byte[1].getClass());
            if (_addCallbackBufferFunc == null) {
                return false;
            }
            _addCallbackBufferArgs = new Object[1];
            _setPreviewCallbackWithBufferFunc = SystemTools.retrieveClassMethod(cameraClass, "setPreviewCallbackWithBuffer", Camera.PreviewCallback.class);
            if (_setPreviewCallbackWithBufferFunc == null) {
                return false;
            }
            if (SystemTools.checkMinimumApiLevel(11)) {
                Class<?> surfaceTextureClass = Class.forName("android.graphics.SurfaceTexture");
                _setPreviewTextureFunc = SystemTools.retrieveClassMethod(cameraClass, "setPreviewTexture", surfaceTextureClass);
                if (_setPreviewTextureFunc == null) {
                    return false;
                }
                _surfaceTextureConstructor = surfaceTextureClass.getConstructor(new Class[]{Integer.TYPE});
                if (_surfaceTextureConstructor == null) {
                    return false;
                }
                _updateTexImage = SystemTools.retrieveClassMethod(surfaceTextureClass, "updateTexImage", new Class[0]);
                if (_updateTexImage == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setSurfaceManager(SurfaceManager sm) {
        this.surfaceManager = sm;
    }

    public int getNumberOfCameras() {
        int i;
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (SystemTools.checkMinimumApiLevel(9)) {
            try {
                return Camera.getNumberOfCameras();
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
        } else {
            try {
                if (SystemTools.getActivityFromNative().getPackageManager().hasSystemFeature("android.hardware.camera")) {
                    i = 1;
                } else {
                    i = 0;
                }
                return i;
            } catch (Exception e2) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
        }
    }

    public int getDirection(int cameraID) {
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (!SystemTools.checkMinimumApiLevel(9)) {
            return CAMERA_DIRECTION_BACK;
        } else {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo(cameraID, cameraInfo);
                switch (cameraInfo.facing) {
                    case SystemTools.AR_ERROR_NONE /*0*/:
                        return CAMERA_DIRECTION_BACK;
                    case 1:
                        return CAMERA_DIRECTION_FRONT;
                    default:
                        return CAMERA_DIRECTION_UNKNOWN;
                }
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
        }
    }

    public int getDeviceID(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci != null) {
            return cci.deviceID;
        }
        SystemTools.setSystemErrorCode(4);
        return -1;
    }

    public int open(int camIndex, int type, int direction, String customData, int[] captureInfo, int[] overrideCaptureInfo) {
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        int cameraDeviceIndex = getCameraDeviceIndex(camIndex, type, direction);
        if (cameraDeviceIndex < 0) {
            return -1;
        }
        int cameraCacheInfoIndex = -1;
        CameraCacheInfo cci = null;
        int cameraCacheInfoSize = this.cameraCacheInfo.size();
        int i = 0;
        while (true) {
            if (i >= cameraCacheInfoSize) {
                break;
            }
            cci = this.cameraCacheInfo.get(i);
            if (cci.deviceID == cameraDeviceIndex) {
                cameraCacheInfoIndex = i;
                break;
            }
            i++;
        }
        if (cci == null) {
            cci = new CameraCacheInfo();
            cci.deviceID = cameraDeviceIndex;
            cci.camera = null;
            cci.surface = null;
            cci.buffer = null;
            cci.overrideWidth = 0;
            cci.requestWidth = 0;
            cci.bufferWidth = 0;
            cci.overrideHeight = 0;
            cci.requestHeight = 0;
            cci.bufferHeight = 0;
            cci.bufferFormatPL = CAMERA_IMAGE_FORMAT_UNKNOWN;
            cci.overrideFormatAndroid = 0;
            cci.requestFormatAndroid = 0;
            cci.caps = null;
            cci.status = CAMERA_STATUS_UNINITIALIZED;
            cci.isAutoFocusing = false;
        }
        boolean resultCameraOpened = false;
        int cameraOpenRetryCount = NUM_MAX_CAMERAOPEN_RETRY;
        while (true) {
            int cameraOpenRetryCount2 = cameraOpenRetryCount;
            try {
                if (SystemTools.checkMinimumApiLevel(9)) {
                    cci.camera = Camera.open(cci.deviceID);
                } else if (cci.deviceID == 0) {
                    cci.camera = Camera.open();
                }
                resultCameraOpened = cci.camera != null;
            } catch (Exception e) {
            }
            if (!resultCameraOpened && cameraOpenRetryCount2 > 0) {
                try {
                    synchronized (this) {
                        wait(250);
                    }
                } catch (Exception e2) {
                }
            }
            if (resultCameraOpened) {
                int i2 = cameraOpenRetryCount2;
                break;
            }
            cameraOpenRetryCount = cameraOpenRetryCount2 - 1;
            if (cameraOpenRetryCount2 <= 0) {
                break;
            }
        }
        if (cci.camera == null) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        boolean setCaptureInfo = (captureInfo != null && captureInfo.length > 0) || (overrideCaptureInfo != null && overrideCaptureInfo.length > 0);
        boolean setCustomData = customData != null && customData.length() > 0;
        if (setCaptureInfo || setCustomData) {
            Camera.Parameters cameraParams = getCameraParameters(cci.camera);
            if (cameraParams == null) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            if (setCaptureInfo) {
                if (captureInfo != null && captureInfo.length != 5) {
                    SystemTools.setSystemErrorCode(2);
                    return -1;
                } else if (!setCameraCaptureParams(cci, cameraParams, captureInfo, overrideCaptureInfo)) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                }
            }
            if (!setCustomData || setCustomCameraParams(cameraParams, customData)) {
                try {
                    cci.camera.setParameters(cameraParams);
                } catch (Exception e3) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                }
            } else {
                SystemTools.setSystemErrorCode(2);
                return -1;
            }
        }
        cci.status = CAMERA_STATUS_OPENED;
        if (cameraCacheInfoIndex < 0) {
            this.cameraCacheInfo.add(cci);
            cameraCacheInfoIndex = this.cameraCacheInfo.size() - 1;
        }
        this.cameraCacheInfoIndexCache.put(cci.camera, Integer.valueOf(cameraCacheInfoIndex));
        return cameraCacheInfoIndex;
    }

    public boolean close(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        this.cameraCacheInfoIndexCache.remove(cci.camera);
        boolean result = false;
        try {
            cci.camera.release();
            result = true;
        } catch (Exception e) {
        }
        cci.camera = null;
        cci.buffer = null;
        cci.status = CAMERA_STATUS_UNINITIALIZED;
        System.gc();
        return result;
    }

    public int[] getCameraCapabilities(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        } else if (cci.caps != null) {
            return cci.caps;
        } else {
            Camera.Parameters cameraParams = getCameraParameters(cci.camera);
            if (cameraParams == null) {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
            List<Camera.Size> supportedImageSizes = cameraParams.getSupportedPreviewSizes();
            List<Integer> supportedFrameRates = cameraParams.getSupportedPreviewFrameRates();
            List<Integer> supportedImageFormats = cameraParams.getSupportedPreviewFormats();
            List<String> supportedFlashModes = cameraParams.getSupportedFlashModes();
            List<String> supportedFocusModes = cameraParams.getSupportedFocusModes();
            int numSupportedImageSizes = supportedImageSizes != null ? supportedImageSizes.size() : 0;
            int numSupportedFrameRates = supportedFrameRates != null ? supportedFrameRates.size() : 0;
            int numSupportedImageFormats = supportedImageFormats != null ? supportedImageFormats.size() : 0;
            cci.caps = new int[((numSupportedImageSizes * 2) + 6 + numSupportedFrameRates + numSupportedImageFormats)];
            cci.caps[0] = CAMERA_PARAMTYPE_BASE;
            setCameraCapsBit(cci, 0, CAMERA_PARAMTYPE_TORCHMODE, supportedFlashModes != null ? supportedFlashModes.contains("torch") || supportedFlashModes.contains("on") : false);
            setCameraCapsBit(cci, 0, CAMERA_PARAMTYPE_FOCUSMODE, true);
            setCameraCapsBit(cci, 0, CAMERA_PARAMTYPE_FOCUSVALUE, SystemTools.checkMinimumApiLevel(8));
            setCameraCapsBit(cci, 0, CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONVALUE, SystemTools.checkMinimumApiLevel(8));
            setCameraCapsBit(cci, 0, CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONRANGE, SystemTools.checkMinimumApiLevel(8));
            setCameraCapsBit(cci, 0, CAMERA_PARAMTYPE_ZOOMVALUE, SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported());
            setCameraCapsBit(cci, 0, CAMERA_PARAMTYPE_ZOOMRANGE, SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported());
            cci.caps[1] = CAMERA_PARAMTYPE_BASE;
            setCameraCapsBit(cci, 1, CAMERA_PARAMTYPE_TORCHMODE, supportedFlashModes != null ? supportedFlashModes.contains("torch") || supportedFlashModes.contains("on") : false);
            setCameraCapsBit(cci, 1, CAMERA_PARAMTYPE_FOCUSMODE, true);
            setCameraCapsBit(cci, 1, CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONVALUE, SystemTools.checkMinimumApiLevel(8));
            setCameraCapsBit(cci, 1, CAMERA_PARAMTYPE_ZOOMVALUE, SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported());
            cci.caps[2] = CAMERA_PARAMVALUE_BASE;
            if (supportedFlashModes != null && (supportedFlashModes.contains("torch") || supportedFlashModes.contains("on"))) {
                setCameraCapsBit(cci, 2, CAMERA_TORCHMODE_OFF, true);
                setCameraCapsBit(cci, 2, CAMERA_TORCHMODE_ON, true);
            }
            if (supportedFocusModes != null) {
                setCameraCapsBit(cci, 2, CAMERA_FOCUSMODE_NORMAL, true);
                setCameraCapsBit(cci, 2, CAMERA_FOCUSMODE_AUTO, supportedFocusModes.contains("auto"));
                setCameraCapsBit(cci, 2, CAMERA_FOCUSMODE_CONTINUOUSAUTO, SystemTools.checkMinimumApiLevel(9) && supportedFocusModes.contains("continuous-video"));
                setCameraCapsBit(cci, 2, CAMERA_FOCUSMODE_MACRO, supportedFocusModes.contains("macro"));
                setCameraCapsBit(cci, 2, CAMERA_FOCUSMODE_INFINITY, supportedFocusModes.contains("infinity"));
                setCameraCapsBit(cci, 2, CAMERA_FOCUSMODE_FIXED, supportedFocusModes.contains("fixed"));
            }
            cci.caps[3] = numSupportedImageSizes;
            cci.caps[4] = numSupportedFrameRates;
            cci.caps[5] = numSupportedImageFormats;
            int indexOffset = 6;
            if (numSupportedImageSizes > 0) {
                ListIterator<Camera.Size> iterSizes = supportedImageSizes.listIterator();
                while (iterSizes.hasNext()) {
                    Camera.Size size = iterSizes.next();
                    cci.caps[indexOffset] = size.width;
                    cci.caps[indexOffset + 1] = size.height;
                    indexOffset += 2;
                }
            }
            if (numSupportedFrameRates > 0) {
                ListIterator<Integer> iterFramerates = supportedFrameRates.listIterator();
                while (iterFramerates.hasNext()) {
                    cci.caps[indexOffset] = iterFramerates.next().intValue();
                    indexOffset++;
                }
            }
            if (numSupportedImageFormats > 0) {
                ListIterator<Integer> iterFormats = supportedImageFormats.listIterator();
                while (iterFormats.hasNext()) {
                    cci.caps[indexOffset] = translateImageFormat(iterFormats.next().intValue(), true);
                    indexOffset++;
                }
            }
            return cci.caps;
        }
    }

    public boolean setCaptureInfo(int cameraCacheInfoIndex, int[] captureInfo, int[] overrideCaptureInfo) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        } else if (captureInfo.length != 5) {
            SystemTools.setSystemErrorCode(2);
            return false;
        } else {
            Camera.Parameters cameraParams = getCameraParameters(cci.camera);
            if (cameraParams == null) {
                SystemTools.setSystemErrorCode(6);
                return false;
            } else if (!setCameraCaptureParams(cci, cameraParams, captureInfo, overrideCaptureInfo)) {
                SystemTools.setSystemErrorCode(6);
                return false;
            } else {
                try {
                    cci.camera.setParameters(cameraParams);
                    return true;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            }
        }
    }

    public int[] getCaptureInfo(int cameraCacheInfoIndex) {
        int i = 0;
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Camera.Parameters cameraParams = getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        try {
            int[] captureInfo = new int[5];
            captureInfo[0] = cameraParams.getPreviewSize().width;
            captureInfo[1] = cameraParams.getPreviewSize().height;
            captureInfo[2] = translateImageFormat(cameraParams.getPreviewFormat(), CONVERT_FORMAT_TO_PL);
            captureInfo[3] = cameraParams.getPreviewFrameRate();
            if (cci.surface != null) {
                i = 1;
            }
            captureInfo[4] = i;
            return captureInfo;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
    }

    public boolean start(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        } else if (!setupPreviewBuffer(cci)) {
            SystemTools.setSystemErrorCode(6);
            return false;
        } else {
            try {
                cci.camera.startPreview();
                cci.status = CAMERA_STATUS_CAPTURE_RUNNING;
                return true;
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
    }

    public boolean stop(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        try {
            cci.camera.stopPreview();
            cci.status = CAMERA_STATUS_OPENED;
            return true;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setTypedCameraParameter(int cameraCacheInfoIndex, int type, Object value) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        Camera.Parameters cameraParams = getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        boolean doPostSetAction = false;
        switch (type) {
            case CAMERA_PARAMTYPE_TORCHMODE /*536870913*/:
                try {
                    switch (((Number) value).intValue()) {
                        case CAMERA_TORCHMODE_OFF /*805306369*/:
                            cameraParams.setFlashMode("off");
                            break;
                        case CAMERA_TORCHMODE_ON /*805306370*/:
                            if (!cameraParams.getSupportedFlashModes().contains("torch")) {
                                cameraParams.setFlashMode("on");
                                break;
                            } else {
                                cameraParams.setFlashMode("torch");
                                break;
                            }
                        case CAMERA_TORCHMODE_AUTO /*805306372*/:
                            SystemTools.setSystemErrorCode(3);
                            return false;
                        default:
                            SystemTools.setSystemErrorCode(3);
                            return false;
                    }
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            case CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                int focusMode = ((Number) value).intValue();
                switch (focusMode) {
                    case CAMERA_FOCUSMODE_NORMAL /*805306384*/:
                    case CAMERA_FOCUSMODE_AUTO /*805306400*/:
                        cameraParams.setFocusMode("auto");
                        doPostSetAction = focusMode == CAMERA_FOCUSMODE_AUTO;
                        break;
                    case CAMERA_FOCUSMODE_CONTINUOUSAUTO /*805306432*/:
                        if (SystemTools.checkMinimumApiLevel(9)) {
                            cameraParams.setFocusMode("continuous-video");
                            break;
                        } else {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                    case CAMERA_FOCUSMODE_MACRO /*805306496*/:
                        cameraParams.setFocusMode("macro");
                        break;
                    case CAMERA_FOCUSMODE_INFINITY /*805306624*/:
                        cameraParams.setFocusMode("infinity");
                        break;
                    case CAMERA_FOCUSMODE_FIXED /*805306880*/:
                        cameraParams.setFocusMode("fixed");
                        break;
                    default:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                }
            case CAMERA_PARAMTYPE_FOCUSVALUE /*536870916*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_FOCUSRANGE /*536870920*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_FOCUSREGION /*536870928*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_EXPOSUREMODE /*536870944*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_EXPOSUREVALUE /*536870976*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_EXPOSURERANGE /*536871040*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONVALUE /*536871168*/:
                if (SystemTools.checkMinimumApiLevel(8)) {
                    cameraParams.setExposureCompensation(((Number) value).intValue());
                    break;
                } else {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            case CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONRANGE /*536871424*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_WHITEBALANCEMODE /*536871936*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_WHITEBALANCEVALUE /*536872960*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_WHITEBALANCERANGE /*536875008*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_ZOOMVALUE /*536879104*/:
                if (SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported()) {
                    cameraParams.setZoom(((Number) value).intValue());
                    break;
                } else {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                break;
            case CAMERA_PARAMTYPE_ZOOMRANGE /*536887296*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_BRIGHTNESSVALUE /*536903680*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_BRIGHTNESSRANGE /*536936448*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_CONTRASTVALUE /*537001984*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_CONTRASTRANGE /*537133056*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case CAMERA_PARAMTYPE_ROTATION /*537395200*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            default:
                return false;
        }
        try {
            cci.camera.setParameters(cameraParams);
            if (doPostSetAction) {
                switch (type) {
                    case CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                        try {
                            cci.isAutoFocusing = true;
                            cci.camera.autoFocus(new Camera.AutoFocusCallback() {
                                public void onAutoFocus(boolean success, Camera camera) {
                                    CameraCacheInfo cci;
                                    Object intObj = CameraPreview.this.cameraCacheInfoIndexCache.get(camera);
                                    if (intObj != null && (cci = CameraPreview.this.getCameraCacheInfo(((Integer) intObj).intValue())) != null) {
                                        cci.isAutoFocusing = false;
                                    }
                                }
                            });
                            break;
                        } catch (Exception e2) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                }
            }
            return true;
        } catch (Exception e3) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public Object getTypedCameraParameter(int cameraCacheInfoIndex, int type) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Camera.Parameters cameraParams = getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        switch (type) {
            case CAMERA_PARAMTYPE_TORCHMODE /*536870913*/:
                try {
                    String flashMode = cameraParams.getFlashMode();
                    if (flashMode.equals("torch") || flashMode.equals("on")) {
                        return Integer.valueOf(CAMERA_TORCHMODE_ON);
                    }
                    if (flashMode.equals("off")) {
                        return Integer.valueOf(CAMERA_TORCHMODE_OFF);
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
            case CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                String focusMode = cameraParams.getFocusMode();
                if (focusMode.equals("auto")) {
                    return Integer.valueOf(cci.isAutoFocusing ? CAMERA_FOCUSMODE_AUTO : CAMERA_FOCUSMODE_NORMAL);
                } else if (SystemTools.checkMinimumApiLevel(9) && focusMode.equals("continuous-video")) {
                    return Integer.valueOf(CAMERA_FOCUSMODE_CONTINUOUSAUTO);
                } else {
                    if (focusMode.equals("infinity")) {
                        return Integer.valueOf(CAMERA_FOCUSMODE_INFINITY);
                    }
                    if (focusMode.equals("macro")) {
                        return Integer.valueOf(CAMERA_FOCUSMODE_MACRO);
                    }
                    if (focusMode.equals("fixed")) {
                        return Integer.valueOf(CAMERA_FOCUSMODE_FIXED);
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
            case CAMERA_PARAMTYPE_FOCUSVALUE /*536870916*/:
                if (SystemTools.checkMinimumApiLevel(8)) {
                    return Float.valueOf(cameraParams.getFocalLength());
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_FOCUSRANGE /*536870920*/:
                if (SystemTools.checkMinimumApiLevel(9)) {
                    float[] focusDistances = new float[3];
                    cameraParams.getFocusDistances(focusDistances);
                    return new float[]{focusDistances[0], focusDistances[2]};
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_FOCUSREGION /*536870928*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_EXPOSUREMODE /*536870944*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_EXPOSUREVALUE /*536870976*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_EXPOSURERANGE /*536871040*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONVALUE /*536871168*/:
                if (SystemTools.checkMinimumApiLevel(8)) {
                    return Integer.valueOf(cameraParams.getExposureCompensation());
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONRANGE /*536871424*/:
                if (SystemTools.checkMinimumApiLevel(8)) {
                    return new int[]{cameraParams.getMinExposureCompensation(), cameraParams.getMaxExposureCompensation()};
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_WHITEBALANCEMODE /*536871936*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_WHITEBALANCEVALUE /*536872960*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_WHITEBALANCERANGE /*536875008*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_ZOOMVALUE /*536879104*/:
                if (SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported()) {
                    return Integer.valueOf(cameraParams.getZoom());
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_ZOOMRANGE /*536887296*/:
                if (!SystemTools.checkMinimumApiLevel(8) || !cameraParams.isZoomSupported()) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                return new int[]{0, cameraParams.getMaxZoom()};
            case CAMERA_PARAMTYPE_BRIGHTNESSVALUE /*536903680*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_BRIGHTNESSRANGE /*536936448*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_CONTRASTVALUE /*537001984*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_CONTRASTRANGE /*537133056*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case CAMERA_PARAMTYPE_ROTATION /*537395200*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            default:
                return null;
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getStatus(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci != null) {
            return cci.status;
        }
        SystemTools.setSystemErrorCode(4);
        return CAMERA_STATUS_UNKNOWN;
    }
}
