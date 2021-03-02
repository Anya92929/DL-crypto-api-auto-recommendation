package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import java.io.IOException;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraSource {
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int zzDE;
    /* access modifiers changed from: private */
    public Camera zzbmA;
    /* access modifiers changed from: private */
    public int zzbmB;
    /* access modifiers changed from: private */
    public Size zzbmC;
    /* access modifiers changed from: private */
    public float zzbmD;
    /* access modifiers changed from: private */
    public int zzbmE;
    /* access modifiers changed from: private */
    public int zzbmF;
    /* access modifiers changed from: private */
    public boolean zzbmG;
    private SurfaceView zzbmH;
    private SurfaceTexture zzbmI;
    private boolean zzbmJ;
    /* access modifiers changed from: private */
    public Thread zzbmK;
    /* access modifiers changed from: private */
    public zzb zzbmL;
    /* access modifiers changed from: private */
    public Map<byte[], ByteBuffer> zzbmM;
    /* access modifiers changed from: private */
    public final Object zzbmz;

    public static class Builder {
        private final Detector<?> zzbmN;
        private CameraSource zzbmO = new CameraSource();

        public Builder(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            } else {
                this.zzbmN = detector;
                Context unused = this.zzbmO.mContext = context;
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzbmO;
            CameraSource cameraSource2 = this.zzbmO;
            cameraSource2.getClass();
            zzb unused = cameraSource.zzbmL = new zzb(this.zzbmN);
            return this.zzbmO;
        }

        public Builder setAutoFocusEnabled(boolean autoFocusEnabled) {
            boolean unused = this.zzbmO.zzbmG = autoFocusEnabled;
            return this;
        }

        public Builder setFacing(int facing) {
            if (facing == 0 || facing == 1) {
                int unused = this.zzbmO.zzbmB = facing;
                return this;
            }
            throw new IllegalArgumentException("Invalid camera: " + facing);
        }

        public Builder setRequestedFps(float fps) {
            if (fps <= 0.0f) {
                throw new IllegalArgumentException("Invalid fps: " + fps);
            }
            float unused = this.zzbmO.zzbmD = fps;
            return this;
        }

        public Builder setRequestedPreviewSize(int width, int height) {
            if (width <= 0 || width > 1000000 || height <= 0 || height > 1000000) {
                throw new IllegalArgumentException("Invalid preview size: " + width + "x" + height);
            }
            int unused = this.zzbmO.zzbmE = width;
            int unused2 = this.zzbmO.zzbmF = height;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    private class zza implements Camera.PreviewCallback {
        private zza() {
        }

        public void onPreviewFrame(byte[] data, Camera camera) {
            CameraSource.this.zzbmL.zza(data, camera);
        }
    }

    private class zzb implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = (!CameraSource.class.desiredAssertionStatus());
        private long zzRD = SystemClock.elapsedRealtime();
        private Detector<?> zzbmN;
        private boolean zzbmQ = true;
        private long zzbmR;
        private int zzbmS = 0;
        private ByteBuffer zzbmT;
        private final Object zzpV = new Object();

        zzb(Detector<?> detector) {
            this.zzbmN = detector;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"Assert"})
        public void release() {
            if ($assertionsDisabled || CameraSource.this.zzbmK.getState() == Thread.State.TERMINATED) {
                this.zzbmN.release();
                this.zzbmN = null;
                return;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r6.zzbmN.receiveFrame(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            android.util.Log.e("CameraSource", "Exception thrown from receiver.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
            com.google.android.gms.vision.CameraSource.zzb(r6.zzbmP).addCallbackBuffer(r2.array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
            throw r0;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        @android.annotation.SuppressLint({"InlinedApi"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                java.lang.Object r1 = r6.zzpV
                monitor-enter(r1)
                boolean r0 = r6.zzbmQ     // Catch:{ all -> 0x0020 }
                if (r0 == 0) goto L_0x0010
                java.nio.ByteBuffer r0 = r6.zzbmT     // Catch:{ all -> 0x0020 }
                if (r0 != 0) goto L_0x0010
                java.lang.Object r0 = r6.zzpV     // Catch:{ InterruptedException -> 0x0016 }
                r0.wait()     // Catch:{ InterruptedException -> 0x0016 }
            L_0x0010:
                boolean r0 = r6.zzbmQ     // Catch:{ all -> 0x0020 }
                if (r0 != 0) goto L_0x0023
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            L_0x0015:
                return
            L_0x0016:
                r0 = move-exception
                java.lang.String r2 = "CameraSource"
                java.lang.String r3 = "Frame processing loop terminated."
                android.util.Log.d(r2, r3, r0)     // Catch:{ all -> 0x0020 }
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
                goto L_0x0015
            L_0x0020:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
                throw r0
            L_0x0023:
                com.google.android.gms.vision.Frame$Builder r0 = new com.google.android.gms.vision.Frame$Builder     // Catch:{ all -> 0x0020 }
                r0.<init>()     // Catch:{ all -> 0x0020 }
                java.nio.ByteBuffer r2 = r6.zzbmT     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.CameraSource r3 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0020 }
                com.google.android.gms.common.images.Size r3 = r3.zzbmC     // Catch:{ all -> 0x0020 }
                int r3 = r3.getWidth()     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.CameraSource r4 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0020 }
                com.google.android.gms.common.images.Size r4 = r4.zzbmC     // Catch:{ all -> 0x0020 }
                int r4 = r4.getHeight()     // Catch:{ all -> 0x0020 }
                r5 = 17
                com.google.android.gms.vision.Frame$Builder r0 = r0.setImageData(r2, r3, r4, r5)     // Catch:{ all -> 0x0020 }
                int r2 = r6.zzbmS     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Frame$Builder r0 = r0.setId(r2)     // Catch:{ all -> 0x0020 }
                long r2 = r6.zzbmR     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Frame$Builder r0 = r0.setTimestampMillis(r2)     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.CameraSource r2 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0020 }
                int r2 = r2.zzDE     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Frame$Builder r0 = r0.setRotation(r2)     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Frame r0 = r0.build()     // Catch:{ all -> 0x0020 }
                java.nio.ByteBuffer r2 = r6.zzbmT     // Catch:{ all -> 0x0020 }
                r3 = 0
                r6.zzbmT = r3     // Catch:{ all -> 0x0020 }
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Detector<?> r1 = r6.zzbmN     // Catch:{ Throwable -> 0x0077 }
                r1.receiveFrame(r0)     // Catch:{ Throwable -> 0x0077 }
                com.google.android.gms.vision.CameraSource r0 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r0 = r0.zzbmA
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x0077:
                r0 = move-exception
                java.lang.String r1 = "CameraSource"
                java.lang.String r3 = "Exception thrown from receiver."
                android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x008e }
                com.google.android.gms.vision.CameraSource r0 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r0 = r0.zzbmA
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x008e:
                r0 = move-exception
                com.google.android.gms.vision.CameraSource r1 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r1 = r1.zzbmA
                byte[] r2 = r2.array()
                r1.addCallbackBuffer(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb.run():void");
        }

        /* access modifiers changed from: package-private */
        public void setActive(boolean active) {
            synchronized (this.zzpV) {
                this.zzbmQ = active;
                this.zzpV.notifyAll();
            }
        }

        /* access modifiers changed from: package-private */
        public void zza(byte[] bArr, Camera camera) {
            synchronized (this.zzpV) {
                if (this.zzbmT != null) {
                    camera.addCallbackBuffer(this.zzbmT.array());
                    this.zzbmT = null;
                }
                this.zzbmR = SystemClock.elapsedRealtime() - this.zzRD;
                this.zzbmS++;
                this.zzbmT = (ByteBuffer) CameraSource.this.zzbmM.get(bArr);
                this.zzpV.notifyAll();
            }
        }
    }

    private class zzc implements Camera.PictureCallback {
        /* access modifiers changed from: private */
        public PictureCallback zzbmU;

        private zzc() {
        }

        public void onPictureTaken(byte[] data, Camera camera) {
            if (this.zzbmU != null) {
                this.zzbmU.onPictureTaken(data);
            }
            synchronized (CameraSource.this.zzbmz) {
                if (CameraSource.this.zzbmA != null) {
                    CameraSource.this.zzbmA.startPreview();
                }
            }
        }
    }

    private class zzd implements Camera.ShutterCallback {
        /* access modifiers changed from: private */
        public ShutterCallback zzbmV;

        private zzd() {
        }

        public void onShutter() {
            if (this.zzbmV != null) {
                this.zzbmV.onShutter();
            }
        }
    }

    private static class zze {
        private Size zzbmW;
        private Size zzbmX;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzbmW = new Size(size.width, size.height);
            this.zzbmX = new Size(size2.width, size2.height);
        }

        public Size zzIc() {
            return this.zzbmW;
        }

        public Size zzId() {
            return this.zzbmX;
        }
    }

    private CameraSource() {
        this.zzbmz = new Object();
        this.zzbmB = 0;
        this.zzbmD = 30.0f;
        this.zzbmE = 1024;
        this.zzbmF = 768;
        this.zzbmG = false;
        this.zzbmM = new HashMap();
    }

    @SuppressLint({"InlinedApi"})
    private Camera zzIb() {
        int zzkp = zzkp(this.zzbmB);
        if (zzkp == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera open = Camera.open(zzkp);
        zze zza2 = zza(open, this.zzbmE, this.zzbmF);
        if (zza2 == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size zzId = zza2.zzId();
        this.zzbmC = zza2.zzIc();
        int[] zza3 = zza(open, this.zzbmD);
        if (zza3 == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Camera.Parameters parameters = open.getParameters();
        parameters.setPictureSize(zzId.getWidth(), zzId.getHeight());
        parameters.setPreviewSize(this.zzbmC.getWidth(), this.zzbmC.getHeight());
        parameters.setPreviewFpsRange(zza3[0], zza3[1]);
        parameters.setPreviewFormat(17);
        zza(open, parameters, zzkp);
        if (this.zzbmG) {
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            } else {
                Log.i("CameraSource", "Camera auto focus is not supported on this device.");
            }
        }
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new zza());
        open.addCallbackBuffer(zza(this.zzbmC));
        open.addCallbackBuffer(zza(this.zzbmC));
        open.addCallbackBuffer(zza(this.zzbmC));
        open.addCallbackBuffer(zza(this.zzbmC));
        return open;
    }

    private static zze zza(Camera camera, int i, int i2) {
        int i3;
        zze zze2;
        zze zze3 = null;
        int i4 = Integer.MAX_VALUE;
        for (zze next : zza(camera)) {
            Size zzIc = next.zzIc();
            int abs = Math.abs(zzIc.getHeight() - i2) + Math.abs(zzIc.getWidth() - i);
            if (abs < i4) {
                int i5 = abs;
                zze2 = next;
                i3 = i5;
            } else {
                i3 = i4;
                zze2 = zze3;
            }
            i4 = i3;
            zze3 = zze2;
        }
        return zze3;
    }

    private static List<zze> zza(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size next : supportedPreviewSizes) {
            float f = ((float) next.width) / ((float) next.height);
            Iterator<Camera.Size> it = supportedPictureSizes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next2 = it.next();
                if (Math.abs(f - (((float) next2.width) / ((float) next2.height))) < 0.01f) {
                    arrayList.add(new zze(next, next2));
                    break;
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            for (Camera.Size zze2 : supportedPreviewSizes) {
                arrayList.add(new zze(zze2, (Camera.Size) null));
            }
        }
        return arrayList;
    }

    private void zza(Camera camera, Camera.Parameters parameters, int i) {
        int i2;
        int i3;
        int i4;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = SktSsiProtocol.kSsiSubCmdSecurityModeResponse;
                break;
            default:
                Log.e("CameraSource", "Bad rotation value: " + rotation);
                i2 = 0;
                break;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i4 = (i2 + cameraInfo.orientation) % 360;
            i3 = (360 - i4) % 360;
        } else {
            i3 = ((cameraInfo.orientation - i2) + 360) % 360;
            i4 = i3;
        }
        this.zzDE = i4 / 90;
        camera.setDisplayOrientation(i3);
        parameters.setRotation(i4);
    }

    @SuppressLint({"InlinedApi"})
    private byte[] zza(Size size) {
        byte[] bArr = new byte[(((int) Math.ceil(((double) ((long) (ImageFormat.getBitsPerPixel(17) * (size.getHeight() * size.getWidth())))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.zzbmM.put(bArr, wrap);
        return bArr;
    }

    @SuppressLint({"InlinedApi"})
    private int[] zza(Camera camera, float f) {
        int i;
        int[] iArr;
        int i2 = (int) (1000.0f * f);
        int[] iArr2 = null;
        int i3 = Integer.MAX_VALUE;
        for (int[] next : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i2 - next[0]) + Math.abs(i2 - next[1]);
            if (abs < i3) {
                int i4 = abs;
                iArr = next;
                i = i4;
            } else {
                i = i3;
                iArr = iArr2;
            }
            i3 = i;
            iArr2 = iArr;
        }
        return iArr2;
    }

    private static int zzkp(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getCameraFacing() {
        return this.zzbmB;
    }

    public Size getPreviewSize() {
        return this.zzbmC;
    }

    public void release() {
        synchronized (this.zzbmz) {
            stop();
            this.zzbmL.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() throws IOException {
        synchronized (this.zzbmz) {
            if (this.zzbmA == null) {
                this.zzbmA = zzIb();
                if (Build.VERSION.SDK_INT >= 11) {
                    this.zzbmI = new SurfaceTexture(100);
                    this.zzbmA.setPreviewTexture(this.zzbmI);
                    this.zzbmJ = true;
                } else {
                    this.zzbmH = new SurfaceView(this.mContext);
                    this.zzbmA.setPreviewDisplay(this.zzbmH.getHolder());
                    this.zzbmJ = false;
                }
                this.zzbmA.startPreview();
                this.zzbmK = new Thread(this.zzbmL);
                this.zzbmL.setActive(true);
                this.zzbmK.start();
            }
        }
        return this;
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzbmz) {
            if (this.zzbmA == null) {
                this.zzbmA = zzIb();
                this.zzbmA.setPreviewDisplay(surfaceHolder);
                this.zzbmA.startPreview();
                this.zzbmK = new Thread(this.zzbmL);
                this.zzbmL.setActive(true);
                this.zzbmK.start();
                this.zzbmJ = false;
            }
        }
        return this;
    }

    public void stop() {
        synchronized (this.zzbmz) {
            this.zzbmL.setActive(false);
            if (this.zzbmK != null) {
                try {
                    this.zzbmK.join();
                } catch (InterruptedException e) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzbmK = null;
            }
            if (this.zzbmA != null) {
                this.zzbmA.stopPreview();
                this.zzbmA.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                try {
                    if (this.zzbmJ) {
                        this.zzbmA.setPreviewTexture((SurfaceTexture) null);
                    } else {
                        this.zzbmA.setPreviewDisplay((SurfaceHolder) null);
                    }
                } catch (Exception e2) {
                    Log.e("CameraSource", "Failed to clear camera preview: " + e2);
                }
                this.zzbmA.release();
                this.zzbmA = null;
            }
            this.zzbmM.clear();
        }
        return;
    }

    public void takePicture(ShutterCallback shutter, PictureCallback jpeg) {
        synchronized (this.zzbmz) {
            if (this.zzbmA != null) {
                zzd zzd2 = new zzd();
                ShutterCallback unused = zzd2.zzbmV = shutter;
                zzc zzc2 = new zzc();
                PictureCallback unused2 = zzc2.zzbmU = jpeg;
                this.zzbmA.takePicture(zzd2, (Camera.PictureCallback) null, (Camera.PictureCallback) null, zzc2);
            }
        }
    }
}
