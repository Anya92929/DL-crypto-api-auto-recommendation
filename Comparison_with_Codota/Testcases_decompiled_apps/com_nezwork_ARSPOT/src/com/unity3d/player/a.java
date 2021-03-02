package com.unity3d.player;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import java.util.List;

final class a {
    /* access modifiers changed from: private */
    public final Object[] a = new Object[0];
    private e b;
    /* access modifiers changed from: private */
    public Camera c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = -1;
    private int h;
    private int i;
    private int j;

    /* renamed from: com.unity3d.player.a$a  reason: collision with other inner class name */
    interface C0004a {
        void onCameraFrame(a aVar, byte[] bArr);
    }

    a(int i2, int i3, int i4, int i5) {
        i3 = i3 == 0 ? 640 : i3;
        i4 = i4 == 0 ? 480 : i4;
        i5 = i5 == 0 ? 24 : i5;
        this.g = i2;
        this.j = i5;
        this.h = i3;
        this.i = i4;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public final void a(C0004a aVar) {
        String format;
        double d2;
        int[] iArr;
        String str;
        int i2;
        int i3;
        double d3;
        Camera.Size size;
        synchronized (this.a) {
            if (Build.VERSION.SDK_INT < 9) {
                this.c = Camera.open();
            } else {
                this.c = Camera.open(this.g);
            }
            Camera.Parameters parameters = this.c.getParameters();
            double d4 = (double) this.h;
            double d5 = (double) this.i;
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            double d6 = Double.MAX_VALUE;
            Camera.Size size2 = supportedPreviewSizes.get(0);
            for (Camera.Size next : supportedPreviewSizes) {
                double abs = Math.abs(Math.log(d4 / ((double) next.width))) + Math.abs(Math.log(d5 / ((double) next.height)));
                if (abs < d6) {
                    size = next;
                    d3 = abs;
                } else {
                    d3 = d6;
                    size = size2;
                }
                d6 = d3;
                size2 = size;
            }
            parameters.setPreviewSize(size2.width, size2.height);
            if (Build.VERSION.SDK_INT < 9) {
                int i4 = this.j;
                List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                if (supportedPreviewFrameRates != null) {
                    i2 = supportedPreviewFrameRates.get(0).intValue();
                    int abs2 = Math.abs(i2 - i4);
                    for (Integer intValue : supportedPreviewFrameRates) {
                        int intValue2 = intValue.intValue();
                        int abs3 = Math.abs(intValue2 - i4);
                        if (abs3 < abs2) {
                            i3 = intValue2;
                        } else {
                            abs3 = abs2;
                            i3 = i2;
                        }
                        i2 = i3;
                        abs2 = abs3;
                    }
                } else {
                    i2 = 24;
                }
                parameters.setPreviewFrameRate(i2);
                format = String.format("%d", new Object[]{Integer.valueOf(i2)});
            } else {
                double d7 = (double) (this.j * 1000);
                List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                ArrayList arrayList = supportedPreviewFpsRange == null ? new ArrayList() : supportedPreviewFpsRange;
                double d8 = Double.MAX_VALUE;
                int[] iArr2 = arrayList.get(0);
                for (int[] next2 : arrayList) {
                    double abs4 = Math.abs(Math.log(d7 / ((double) next2[0]))) + Math.abs(Math.log(d7 / ((double) next2[1])));
                    if (abs4 < d8) {
                        iArr = next2;
                        d2 = abs4;
                    } else {
                        d2 = d8;
                        iArr = iArr2;
                    }
                    d8 = d2;
                    iArr2 = iArr;
                }
                parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                format = String.format("(%d, %d)", new Object[]{Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1])});
            }
            this.c.setParameters(parameters);
            int previewFormat = parameters.getPreviewFormat();
            this.e = size2.height;
            this.f = size2.width;
            if (Build.VERSION.SDK_INT >= 8) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(previewFormat);
                this.d = (((size2.width * size2.height) * bitsPerPixel) / 8) + 4096;
                str = String.format(", bpp=%d", new Object[]{Integer.valueOf(bitsPerPixel)});
            } else {
                str = "";
            }
            l.Log(3, String.format("cam[%d]: size = %dx%d; format=%d, fps=%s%s", new Object[]{Integer.valueOf(this.g), Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(previewFormat), format, str}));
            final C0004a aVar2 = aVar;
            AnonymousClass2 r2 = new Camera.PreviewCallback() {
                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    if (a.this.c == camera) {
                        aVar2.onCameraFrame(a.this, bArr);
                    }
                }
            };
            if (Build.VERSION.SDK_INT < 8) {
                this.c.setPreviewCallback(r2);
            } else {
                this.c.addCallbackBuffer(new byte[this.d]);
                this.c.addCallbackBuffer(new byte[this.d]);
                this.c.setPreviewCallbackWithBuffer(r2);
            }
            if (this.b == null) {
                this.b = new e() {
                    private Camera a = a.this.c;

                    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                        synchronized (a.this.a) {
                            if (a.this.c == this.a) {
                                try {
                                    a.this.c.setPreviewDisplay(surfaceHolder);
                                    a.this.c.startPreview();
                                } catch (Exception e) {
                                    l.Log(6, "Unable to initialize webcam data stream: " + e.getMessage());
                                }
                                return;
                            }
                            return;
                        }
                    }

                    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                        synchronized (a.this.a) {
                            if (a.this.c == this.a) {
                                a.this.c.stopPreview();
                            }
                        }
                    }
                };
                this.b.a();
            }
        }
    }

    public final void a(byte[] bArr) {
        if (Build.VERSION.SDK_INT >= 8 && this.c != null) {
            this.c.addCallbackBuffer(bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.stopPreview();
                if (Build.VERSION.SDK_INT < 8) {
                    this.c.setPreviewCallback((Camera.PreviewCallback) null);
                } else {
                    this.c.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                }
                this.c.release();
                this.c = null;
            }
            if (this.b != null) {
                this.b.b();
                this.b = null;
            }
        }
    }
}
