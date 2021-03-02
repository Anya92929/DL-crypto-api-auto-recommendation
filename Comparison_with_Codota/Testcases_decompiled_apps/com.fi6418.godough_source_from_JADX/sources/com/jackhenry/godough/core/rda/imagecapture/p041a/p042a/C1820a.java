package com.jackhenry.godough.core.rda.imagecapture.p041a.p042a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.rda.imagecapture.C1819a;
import com.jackhenry.godough.core.rda.imagecapture.C1823b;
import com.jackhenry.godough.core.rda.p040a.C1804a;
import com.jackhenry.godough.p027b.C1387b;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.rda.imagecapture.a.a.a */
public class C1820a extends C1819a implements Camera.AutoFocusCallback, Camera.PictureCallback {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Camera f6672b;

    /* renamed from: c */
    private int f6673c = 0;

    /* renamed from: d */
    private boolean f6674d = false;

    /* renamed from: e */
    private Handler f6675e = new Handler();

    /* renamed from: f */
    private C1822c f6676f;

    /* renamed from: g */
    private SurfaceView f6677g;

    /* renamed from: h */
    private int f6678h;

    /* renamed from: i */
    private int f6679i;

    public C1820a(AbstractActivity abstractActivity, C1823b bVar) {
        super(abstractActivity, bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m6743f() {
        ArrayList arrayList;
        int i;
        Camera.Size size;
        int i2 = 1;
        ((WindowManager) mo11029a().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        Camera.Parameters parameters = this.f6672b.getParameters();
        ArrayList arrayList2 = (ArrayList) parameters.getSupportedPreviewSizes();
        Camera.Size size2 = (Camera.Size) arrayList2.get(0);
        int i3 = size2.width;
        float height = ((float) this.f6677g.getHeight()) / ((float) this.f6677g.getWidth());
        float abs = Math.abs(height - (((float) ((Camera.Size) arrayList2.get(0)).height) / ((float) ((Camera.Size) arrayList2.get(0)).width)));
        Camera.Size size3 = size2;
        for (int i4 = 1; i4 < arrayList2.size(); i4++) {
            int i5 = ((Camera.Size) arrayList2.get(i4)).width;
            float f = ((float) ((Camera.Size) arrayList2.get(i4)).height) / ((float) ((Camera.Size) arrayList2.get(i4)).width);
            if (abs > Math.abs(height - f) && i5 <= i3) {
                abs = Math.abs(height - f);
                size3 = (Camera.Size) arrayList2.get(i4);
            }
        }
        parameters.setPreviewSize(size3.width, size3.height);
        ArrayList arrayList3 = (ArrayList) parameters.getSupportedPictureSizes();
        int abs2 = Math.abs(1600 - ((Camera.Size) arrayList3.get(0)).width);
        Camera.Size size4 = (Camera.Size) arrayList3.get(0);
        while (i2 < arrayList3.size()) {
            int abs3 = Math.abs(1600 - ((Camera.Size) arrayList3.get(i2)).width);
            if (1600 > ((Camera.Size) arrayList3.get(i2)).width || abs3 > abs2 || ((Camera.Size) arrayList3.get(i2)).height != (((Camera.Size) arrayList3.get(i2)).width * this.f6677g.getHeight()) / this.f6677g.getWidth()) {
                i = abs2;
                size = size4;
            } else {
                size = (Camera.Size) arrayList3.get(i2);
                i = abs3;
            }
            i2++;
            size4 = size;
            abs2 = i;
        }
        if (size4.width < 1600) {
            throw new C1804a(mo11029a().getString(C1506am.no_supported_size_found), 1000);
        }
        parameters.setPictureSize(size4.width, size4.height);
        if (parameters.getSupportedPictureFormats().contains(256)) {
            parameters.setPictureFormat(256);
            parameters.removeGpsData();
            if (!(parameters.getFlashMode() == null || (arrayList = (ArrayList) parameters.getSupportedFocusModes()) == null || !arrayList.contains("on"))) {
                parameters.setFlashMode("on");
            }
            ArrayList arrayList4 = (ArrayList) parameters.getSupportedFocusModes();
            if (arrayList4 != null && arrayList4.contains("continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
            } else if (arrayList4 != null && arrayList4.contains("auto")) {
                parameters.setFocusMode("auto");
            }
            this.f6672b.setDisplayOrientation(mo11036e());
            this.f6672b.setParameters(parameters);
            return;
        }
        throw new C1387b(mo11029a().getString(C1506am.rdaCameraParameterError), 1000);
    }

    /* renamed from: a */
    public void mo11030a(ViewGroup viewGroup) {
        this.f6675e.post(new C1821b(this, viewGroup));
    }

    /* renamed from: b */
    public void mo11035b(ViewGroup viewGroup) {
        int i = C1506am.rdaCameraAccessError;
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i2 = 0;
            while (true) {
                if (i2 >= numberOfCameras) {
                    break;
                }
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    this.f6678h = i2;
                    this.f6679i = cameraInfo.orientation;
                    break;
                }
                i2++;
            }
            this.f6672b = Camera.open(this.f6678h);
            int i3 = C1506am.rdaSurfaceError;
            this.f6677g = new SurfaceView(mo11029a());
            SurfaceHolder holder = this.f6677g.getHolder();
            this.f6676f = new C1822c(this);
            holder.addCallback(this.f6676f);
            viewGroup.addView(this.f6677g);
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1389d(mo11029a().getString(i), 1000);
        }
    }

    /* renamed from: c */
    public void mo11033c() {
        if (this.f6673c < 2) {
            this.f6672b.autoFocus(this);
        } else {
            this.f6672b.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, this);
        }
    }

    /* renamed from: d */
    public void mo11034d() {
        if (this.f6672b != null) {
            this.f6672b.release();
            if (this.f6672b != null) {
                this.f6677g.getHolder().removeCallback(this.f6676f);
            }
        }
    }

    /* renamed from: e */
    public int mo11036e() {
        int i = 0;
        switch (mo11029a().getWindowManager().getDefaultDisplay().getRotation()) {
            case 1:
                i = 90;
                break;
            case 2:
                i = 180;
                break;
            case 3:
                i = 270;
                break;
        }
        return ((this.f6679i - i) + 360) % 360;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        boolean z2 = false;
        if ((!this.f6674d) && z) {
            this.f6674d = true;
            camera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, this);
            return;
        }
        boolean z3 = !z;
        if (!this.f6674d) {
            z2 = true;
        }
        if ((z3 && z2) && this.f6673c < 2) {
            this.f6673c++;
            if (this.f6673c == 2) {
                mo11029a().showDialog(mo11029a().getString(C1506am.autoFocusOffTitle), mo11029a().getString(C1506am.autoFocusOffMessage));
            } else {
                Toast.makeText(mo11029a(), "Unable to focus", 1).show();
            }
        }
    }

    public void onPictureTaken(byte[] bArr, Camera camera) {
        this.f6673c = 0;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        int e = mo11036e();
        if (e != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate((float) e);
            decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
        }
        byte[] a = mo11031a(decodeByteArray);
        camera.release();
        mo11032b().showImagePreview(a, decodeByteArray);
    }
}
