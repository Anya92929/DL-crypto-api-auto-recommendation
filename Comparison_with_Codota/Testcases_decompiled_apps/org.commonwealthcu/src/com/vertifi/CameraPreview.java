package com.vertifi;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.media.MediaActionSound;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import com.vertifi.imageproc.ImageProcessing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CameraPreview extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback {
    private static float VIP_ASPECT_RATIO_TOLERANCE = 0.015f;
    /* access modifiers changed from: private */
    public static int VIP_MAX_AUTO_FOCUS_FAILURES = 2;
    private static float VIP_MAX_VIEW_ASPECT = 1.85f;
    private static int VIP_MIN_PHOTO_SIZE = 1600;
    private static int VIP_MIN_PHOTO_SIZE_OPTIMAL = 1920;
    /* access modifiers changed from: private */
    public static String VIP_SETTINGS_CAMERA_CAN_FOCUS = "camera.canFocus";
    /* access modifiers changed from: private */
    public static String VIP_SETTINGS_STORAGE = "VIPSettings";
    private static float VIP_VIEWPORT_ASPECT = 2.2f;
    /* access modifiers changed from: private */
    public boolean mAcquiringStill;
    /* access modifiers changed from: private */
    public final Camera.AutoFocusCallback mAutoFocusCallback = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
            try {
                if (!CameraPreview.this.mAcquiringStill) {
                    if (!z) {
                        if (CameraPreview.this.mFocusAttempts < CameraPreview.VIP_MAX_AUTO_FOCUS_FAILURES) {
                            CameraPreview.access$308(CameraPreview.this);
                            Camera.Parameters parameters = CameraPreview.this.mCamera.getParameters();
                            if (Build.VERSION.SDK_INT >= 14) {
                                parameters.setFocusAreas((List) null);
                            }
                            CameraPreview.this.mCamera.setParameters(parameters);
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    try {
                                        CameraPreview.this.mCamera.autoFocus(CameraPreview.this.mAutoFocusCallback);
                                    } catch (Exception e) {
                                    }
                                }
                            }, 250);
                            return;
                        } else if (CameraPreview.this.mCameraCanFocus) {
                            boolean unused = CameraPreview.this.mFocusing = false;
                            int unused2 = CameraPreview.this.mFocusAttempts = 0;
                            CameraPreview.this.mCameraActivity.onPictureFailed();
                            return;
                        }
                    } else if (!CameraPreview.this.mCameraCanFocus) {
                        SharedPreferences.Editor edit = CameraPreview.this.mCameraActivity.getSharedPreferences(CameraPreview.VIP_SETTINGS_STORAGE, 0).edit();
                        edit.putBoolean(CameraPreview.VIP_SETTINGS_CAMERA_CAN_FOCUS, true);
                        edit.commit();
                    }
                    if (Build.VERSION.SDK_INT >= 16 && CameraPreview.this.mMediaActionSound != null) {
                        CameraPreview.this.mMediaActionSound.play(1);
                    }
                    if (CameraPreview.this.mPreviewEnabled) {
                        CameraPreview.this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                    }
                    boolean unused3 = CameraPreview.this.mFocusing = false;
                    boolean unused4 = CameraPreview.this.mAcquiringStill = true;
                    camera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, CameraPreview.this.mPictureCallback);
                }
            } catch (Exception e) {
                Log.e("VIPSample", e.getMessage());
            }
        }
    };
    /* access modifiers changed from: private */
    public Camera mCamera;
    /* access modifiers changed from: private */
    public CameraActivity mCameraActivity;
    /* access modifiers changed from: private */
    public boolean mCameraCanFocus;
    private boolean mContinuousFocus;
    /* access modifiers changed from: private */
    public int[] mCorners;
    private String mFlashMode;
    private List mFocusAreas;
    /* access modifiers changed from: private */
    public int mFocusAttempts;
    /* access modifiers changed from: private */
    public boolean mFocusing;
    private SurfaceHolder mHolder;
    /* access modifiers changed from: private */
    public MediaActionSound mMediaActionSound;
    /* access modifiers changed from: private */
    public final Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] bArr, Camera camera) {
            try {
                if (Build.VERSION.SDK_INT >= 16 && CameraPreview.this.mMediaActionSound != null) {
                    CameraPreview.this.mMediaActionSound.play(0);
                }
                RDCGlobal.mRawImage = bArr;
                boolean unused = CameraPreview.this.mAcquiringStill = false;
                CameraPreview.this.mCameraActivity.onPictureTaken();
            } catch (Exception e) {
                Log.e("VIPSample", e.getMessage());
            }
        }
    };
    /* access modifiers changed from: private */
    public Point mPointBL;
    /* access modifiers changed from: private */
    public Point mPointBR;
    /* access modifiers changed from: private */
    public Point mPointTL;
    /* access modifiers changed from: private */
    public Point mPointTR;
    /* access modifiers changed from: private */
    public boolean mPreviewEnabled;
    /* access modifiers changed from: private */
    public boolean mPreviewProcessing;
    /* access modifiers changed from: private */
    public int mRotateDegrees;

    class ProcessPreviewFrameTask extends AsyncTask {
        private ProcessPreviewFrameTask() {
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(byte[]... bArr) {
            try {
                byte[] bArr2 = bArr[0];
                RectF rectF = new RectF(RDCGlobal.mRectViewportPreview);
                if (CameraPreview.this.mRotateDegrees == 180) {
                    rectF.left = 1.0f - RDCGlobal.mRectViewportPreview.right;
                    rectF.top = 1.0f - RDCGlobal.mRectViewportPreview.bottom;
                    rectF.right = 1.0f - RDCGlobal.mRectViewportPreview.left;
                    rectF.bottom = 1.0f - RDCGlobal.mRectViewportPreview.top;
                }
                ImageProcessing.onCropImageYUV(bArr2, RDCGlobal.mSizePreview, RDCGlobal.mRectViewportPreview, CameraPreview.this.mCorners);
            } catch (Exception e) {
                Log.e("VIPSample", e.getMessage());
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            if (CameraPreview.this.mRotateDegrees == 180) {
                CameraPreview.this.mPointTL.x = RDCGlobal.mSizePreview.width - CameraPreview.this.mCorners[4];
                CameraPreview.this.mPointTL.y = RDCGlobal.mSizePreview.height - CameraPreview.this.mCorners[5];
                CameraPreview.this.mPointTR.x = RDCGlobal.mSizePreview.width - CameraPreview.this.mCorners[6];
                CameraPreview.this.mPointTR.y = RDCGlobal.mSizePreview.height - CameraPreview.this.mCorners[7];
                CameraPreview.this.mPointBR.x = RDCGlobal.mSizePreview.width - CameraPreview.this.mCorners[0];
                CameraPreview.this.mPointBR.y = RDCGlobal.mSizePreview.height - CameraPreview.this.mCorners[1];
                CameraPreview.this.mPointBL.x = RDCGlobal.mSizePreview.width - CameraPreview.this.mCorners[2];
                CameraPreview.this.mPointBL.y = RDCGlobal.mSizePreview.height - CameraPreview.this.mCorners[3];
            } else {
                CameraPreview.this.mPointTL.x = CameraPreview.this.mCorners[0];
                CameraPreview.this.mPointTL.y = CameraPreview.this.mCorners[1];
                CameraPreview.this.mPointTR.x = CameraPreview.this.mCorners[2];
                CameraPreview.this.mPointTR.y = CameraPreview.this.mCorners[3];
                CameraPreview.this.mPointBR.x = CameraPreview.this.mCorners[4];
                CameraPreview.this.mPointBR.y = CameraPreview.this.mCorners[5];
                CameraPreview.this.mPointBL.x = CameraPreview.this.mCorners[6];
                CameraPreview.this.mPointBL.y = CameraPreview.this.mCorners[7];
            }
            CameraPreview.this.mCameraActivity.setCorners(CameraPreview.this.mPointTL, CameraPreview.this.mPointTR, CameraPreview.this.mPointBL, CameraPreview.this.mPointBR);
            boolean unused = CameraPreview.this.mPreviewProcessing = false;
        }
    }

    public CameraPreview(Context context) {
        super(context);
        init(context);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    static /* synthetic */ int access$308(CameraPreview cameraPreview) {
        int i = cameraPreview.mFocusAttempts;
        cameraPreview.mFocusAttempts = i + 1;
        return i;
    }

    private void init(Context context) {
        this.mCameraActivity = (CameraActivity) context;
        this.mFocusing = false;
        this.mAcquiringStill = false;
        this.mPreviewEnabled = false;
        this.mFocusAttempts = 0;
        this.mRotateDegrees = 0;
        this.mContinuousFocus = false;
        this.mCameraCanFocus = context.getSharedPreferences(VIP_SETTINGS_STORAGE, 0).getBoolean(VIP_SETTINGS_CAMERA_CAN_FOCUS, false);
        this.mCorners = new int[8];
        this.mPointTL = new Point();
        this.mPointTR = new Point();
        this.mPointBL = new Point();
        this.mPointBR = new Point();
        initCamera();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mMediaActionSound = new MediaActionSound();
            this.mMediaActionSound.load(1);
        }
        this.mHolder = getHolder();
        this.mHolder.addCallback(this);
    }

    private void initCamera() {
        boolean z;
        int i;
        try {
            if (this.mCamera != null) {
                this.mCamera.release();
                this.mCamera = null;
            }
            this.mCamera = Camera.open();
            Camera.Parameters parameters = this.mCamera.getParameters();
            if (parameters.getSupportedPreviewFormats().contains(17)) {
                parameters.setPreviewFormat(17);
                this.mPreviewEnabled = true;
            }
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
            if (supportedPreviewSizes == null || supportedPictureSizes == null) {
                z = false;
            } else {
                Collections.sort(supportedPreviewSizes, new Comparator() {
                    public int compare(Camera.Size size, Camera.Size size2) {
                        int i = size2.width - size.width;
                        return i != 0 ? i : size2.height - size.height;
                    }
                });
                Collections.sort(supportedPictureSizes, new Comparator() {
                    public int compare(Camera.Size size, Camera.Size size2) {
                        int i = size.width - size2.width;
                        return i != 0 ? i : size.height - size2.height;
                    }
                });
                z = findBestSize(supportedPreviewSizes, supportedPictureSizes, VIP_MIN_PHOTO_SIZE_OPTIMAL, parameters);
                if (!z) {
                    z = findBestSize(supportedPreviewSizes, supportedPictureSizes, VIP_MIN_PHOTO_SIZE, parameters);
                }
            }
            if (!z) {
                Toast.makeText(this.mCameraActivity, "No Valid Photo Configuration Found", 1).show();
                return;
            }
            RectF rectF = new RectF();
            RDCGlobal.mRectViewportPreview = rectF;
            rectF.left = 0.005f;
            RDCGlobal.mRectViewportPreview.right = 0.995f;
            if (RDCGlobal.mSizePreview.width > Math.max(RDCGlobal.mWindowWidth, RDCGlobal.mWindowHeight)) {
                float max = 1.0f - (((float) Math.max(RDCGlobal.mWindowWidth, RDCGlobal.mWindowHeight)) / ((float) RDCGlobal.mSizePreview.width));
                RDCGlobal.mRectViewportPreview.left = max / 2.0f;
                RDCGlobal.mRectViewportPreview.right = 1.0f - (max / 2.0f);
            }
            float f = ((((float) RDCGlobal.mSizePreview.width) * (RDCGlobal.mRectViewportPreview.right - RDCGlobal.mRectViewportPreview.left)) / VIP_VIEWPORT_ASPECT) / ((float) RDCGlobal.mSizePreview.height);
            RDCGlobal.mRectViewportPreview.top = 0.5f - (f / 2.0f);
            RDCGlobal.mRectViewportPreview.bottom = (f / 2.0f) + 0.5f;
            RDCGlobal.mSizeRawImage = parameters.getPictureSize();
            RectF rectF2 = new RectF();
            RDCGlobal.mRectViewportPhoto = rectF2;
            rectF2.left = RDCGlobal.mRectViewportPreview.left;
            RDCGlobal.mRectViewportPhoto.right = RDCGlobal.mRectViewportPreview.right;
            float f2 = ((((float) RDCGlobal.mSizeRawImage.width) * (RDCGlobal.mRectViewportPhoto.right - RDCGlobal.mRectViewportPhoto.left)) / VIP_VIEWPORT_ASPECT) / ((float) RDCGlobal.mSizeRawImage.height);
            RDCGlobal.mRectViewportPhoto.top = 0.5f - (f2 / 2.0f);
            RDCGlobal.mRectViewportPhoto.bottom = (f2 / 2.0f) + 0.5f;
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null) {
                if (this.mFlashMode == null) {
                    this.mFlashMode = "off";
                }
                if (supportedFlashModes.contains(this.mFlashMode)) {
                    parameters.setFlashMode(this.mFlashMode);
                }
            }
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                if (supportedFocusModes.contains("continuous-picture")) {
                    parameters.setFocusMode("continuous-picture");
                    this.mContinuousFocus = true;
                } else if (supportedFocusModes.contains("auto")) {
                    parameters.setFocusMode("auto");
                } else if (supportedFocusModes.contains("macro")) {
                    parameters.setFocusMode("macro");
                }
            }
            Rect rect = new Rect(((int) (RDCGlobal.mRectViewportPreview.left * 2000.0f)) - 1000, ((int) (RDCGlobal.mRectViewportPreview.top * 2000.0f)) - 1000, ((int) (RDCGlobal.mRectViewportPreview.right * 2000.0f)) - 1000, ((int) (RDCGlobal.mRectViewportPreview.bottom * 2000.0f)) - 1000);
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 14) {
                arrayList.add(new Camera.Area(rect, RDCGlobal.DIALOG_SHOW_ERRORS));
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    parameters.setMeteringAreas(arrayList);
                }
            }
            Rect rect2 = new Rect((((int) (((RDCGlobal.mRectViewportPreview.left + RDCGlobal.mRectViewportPreview.right) / 2.0f) * 2000.0f)) - 1000) - 200, (((int) (((RDCGlobal.mRectViewportPreview.top + RDCGlobal.mRectViewportPreview.bottom) / 2.0f) * 2000.0f)) - 1000) - 200, (((int) (((RDCGlobal.mRectViewportPreview.left + RDCGlobal.mRectViewportPreview.right) / 2.0f) * 2000.0f)) - 1000) + 200, (((int) (((RDCGlobal.mRectViewportPreview.top + RDCGlobal.mRectViewportPreview.bottom) / 2.0f) * 2000.0f)) - 1000) + 200);
            if (Build.VERSION.SDK_INT >= 14) {
                this.mFocusAreas = new ArrayList();
                this.mFocusAreas.add(new Camera.Area(rect2, RDCGlobal.DIALOG_SHOW_ERRORS));
                if (parameters.getMaxNumFocusAreas() > 0) {
                    parameters.setFocusAreas(this.mFocusAreas);
                }
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                int numberOfCameras = Camera.getNumberOfCameras();
                int i2 = 0;
                while (true) {
                    if (i2 >= numberOfCameras) {
                        break;
                    }
                    Camera.getCameraInfo(i2, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        switch (this.mCameraActivity.getWindowManager().getDefaultDisplay().getRotation()) {
                            case 0:
                                i = 0;
                                break;
                            case 1:
                                i = 90;
                                break;
                            case 2:
                                i = 180;
                                break;
                            case 3:
                                i = 270;
                                break;
                            default:
                                i = 0;
                                break;
                        }
                        this.mRotateDegrees = ((cameraInfo.orientation - i) + 360) % 360;
                        this.mCamera.setDisplayOrientation(this.mRotateDegrees);
                        parameters.setRotation(this.mRotateDegrees);
                    } else {
                        i2++;
                    }
                }
            }
            this.mCamera.setParameters(parameters);
        } catch (Exception e) {
            Toast.makeText(this.mCameraActivity, String.format("Failed to open camera: %s", new Object[]{e.getMessage()}), 1).show();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean findBestSize(List list, List list2, int i, Camera.Parameters parameters) {
        boolean z;
        boolean z2 = false;
        Iterator it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            Camera.Size size = (Camera.Size) it.next();
            if ((size.width <= Math.max(RDCGlobal.mWindowWidth, RDCGlobal.mWindowHeight) || size.height <= Math.min(RDCGlobal.mWindowWidth, RDCGlobal.mWindowHeight)) && ((float) size.width) / ((float) size.height) <= VIP_MAX_VIEW_ASPECT) {
                float f = ((float) size.width) / ((float) size.height);
                Iterator it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Camera.Size size2 = (Camera.Size) it2.next();
                    float f2 = ((float) size2.width) / ((float) size2.height);
                    if (size2.width >= i && Math.abs(f2 - f) / f2 <= VIP_ASPECT_RATIO_TOLERANCE) {
                        parameters.setPictureSize(size2.width, size2.height);
                        z = true;
                        break;
                    }
                }
                if (z) {
                    parameters.setPreviewSize(size.width, size.height);
                    Camera.Size previewSize = parameters.getPreviewSize();
                    RDCGlobal.mSizePreview = previewSize;
                    previewSize.height = size.height;
                    RDCGlobal.mSizePreview.width = size.width;
                    break;
                }
            }
            z2 = z;
        }
        return z;
    }

    public void onLowMemory() {
        if (this.mMediaActionSound != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.mMediaActionSound.release();
            }
            this.mMediaActionSound = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (RDCGlobal.mSizePreview != null) {
            setMeasuredDimension(RDCGlobal.mSizePreview.width, RDCGlobal.mSizePreview.height);
        } else {
            setMeasuredDimension(RDCGlobal.getWindowWidth(this.mCameraActivity), RDCGlobal.getWindowHeight(this.mCameraActivity));
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.mPreviewEnabled && bArr != null && this.mCameraActivity.mOverlay != null && this.mCameraActivity.mOverlay.isLiveCornersEnabled() && !this.mPreviewProcessing) {
            this.mPreviewProcessing = true;
            new ProcessPreviewFrameTask().execute(new byte[][]{bArr});
        }
    }

    public boolean onSetFlashMode(String str) {
        try {
            Camera.Parameters parameters = this.mCamera.getParameters();
            if (parameters.getFlashMode().equals(str)) {
                return true;
            }
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null && supportedFlashModes.contains(str)) {
                parameters.setFlashMode(str);
                this.mCamera.setParameters(parameters);
                this.mFlashMode = str;
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    public void onStartPreview(boolean z) {
        List<String> supportedFocusModes;
        try {
            if (this.mCamera != null) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (z && (supportedFocusModes = parameters.getSupportedFocusModes()) != null && supportedFocusModes.contains("continuous-picture")) {
                    parameters.setFocusMode("continuous-picture");
                    this.mContinuousFocus = true;
                }
                if (Build.VERSION.SDK_INT >= 14 && parameters.getMaxNumFocusAreas() > 0) {
                    parameters.setFocusAreas(this.mFocusAreas);
                }
                this.mCamera.setParameters(parameters);
                this.mCamera.setPreviewDisplay(this.mHolder);
                if (this.mPreviewEnabled) {
                    this.mCamera.setPreviewCallback(this);
                }
                this.mPreviewProcessing = false;
                this.mCamera.startPreview();
                return;
            }
            initCamera();
            if (this.mCamera != null) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        try {
                            CameraPreview.this.onStartPreview(false);
                        } catch (Exception e) {
                        }
                    }
                }, 10);
            }
        } catch (Exception e) {
        }
    }

    public void onStopPreview() {
        try {
            if (this.mCamera != null) {
                if (this.mPreviewEnabled) {
                    this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                }
                this.mCamera.stopPreview();
                this.mPreviewEnabled = false;
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: protected */
    public void onTakePicture(Rect rect) {
        try {
            if (!this.mFocusing && !this.mAcquiringStill) {
                this.mFocusAttempts = 0;
                ArrayList arrayList = new ArrayList();
                if (Build.VERSION.SDK_INT >= 16) {
                    arrayList.add(new Camera.Area(rect, RDCGlobal.DIALOG_SHOW_ERRORS));
                }
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (this.mContinuousFocus) {
                    this.mCamera.cancelAutoFocus();
                    List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null) {
                        if (supportedFocusModes.contains("auto")) {
                            parameters.setFocusMode("auto");
                        } else if (supportedFocusModes.contains("macro")) {
                            parameters.setFocusMode("macro");
                        }
                        if (Build.VERSION.SDK_INT >= 14 && parameters.getMaxNumFocusAreas() > 0) {
                            parameters.setFocusAreas(arrayList);
                        }
                        this.mCamera.setParameters(parameters);
                        this.mContinuousFocus = false;
                    }
                    this.mFocusing = true;
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            try {
                                CameraPreview.this.mCamera.autoFocus(CameraPreview.this.mAutoFocusCallback);
                            } catch (Exception e) {
                            }
                        }
                    }, 1000);
                    return;
                }
                if (Build.VERSION.SDK_INT >= 14 && parameters.getMaxNumFocusAreas() > 0) {
                    parameters.setFocusAreas(arrayList);
                    this.mCamera.setParameters(parameters);
                }
                if (parameters.getFocusMode().equals("fixed") || parameters.getFocusMode().equals("infinity")) {
                    this.mAcquiringStill = true;
                    this.mCamera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, this.mPictureCallback);
                    return;
                }
                this.mFocusing = true;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        try {
                            CameraPreview.this.mCamera.autoFocus(CameraPreview.this.mAutoFocusCallback);
                        } catch (Exception e) {
                        }
                    }
                }, 100);
            }
        } catch (Exception e) {
            Log.e("VIPSample", e.getMessage() != null ? e.getMessage() : "");
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        try {
            onStartPreview(false);
        } catch (Exception e) {
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        onStopPreview();
    }
}
