package com.unity3d.player;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class z extends GLSurfaceView implements UnityGL {
    private static boolean a = false;
    /* access modifiers changed from: private */
    public static boolean b;
    private a c = null;

    static class a implements GLSurfaceView.EGLConfigChooser {
        private static final int[] f = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
        private static final int[] g = {12324, 5, 12323, 6, 12322, 5, 12352, 1, 12344};
        private static int[] j = new int[1];
        private static /* synthetic */ boolean k = (!z.class.desiredAssertionStatus());
        protected int a;
        protected int b;
        protected int c;
        protected int d;
        public int e;
        private int h;
        private int i;

        public a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.h = i6;
            this.i = i7;
            this.e = i8;
        }

        /* access modifiers changed from: private */
        public static int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, j)) {
                return j[0];
            }
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12292) {
                Log.e("Unity", String.format("findConfigAttrib: EGL error: 0x%x", new Object[]{Integer.valueOf(eglGetError)}));
            }
            z.a("findConfigAttrib (" + Integer.toHexString(i2) + ")", egl10);
            return 0;
        }

        private EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            int i2 = 0;
            while (i2 < length) {
                EGLConfig eGLConfig = eGLConfigArr[i2];
                if (k || eGLConfig != null) {
                    int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12337, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12513, 0);
                    if (a2 >= this.h && a3 >= this.i && (a4 >= this.e || a5 - 1 >= this.e)) {
                        int a6 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                        int a7 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                        int a8 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                        int a9 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                        if (a6 == this.a && a7 == this.b && a8 == this.c && a9 == this.d) {
                            return eGLConfig;
                        }
                    }
                    i2++;
                } else {
                    throw new AssertionError();
                }
            }
            return null;
        }

        protected static void printConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354, 12512, 12513};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT", "EGL_COVERAGE_BUFFERS_NV", "EGL_COVERAGE_SAMPLES_NV"};
            int[] iArr2 = new int[1];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                String str = strArr[i2];
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, iArr2)) {
                    z.a(String.format("  %s: %d\n", new Object[]{str, Integer.valueOf(iArr2[0])}));
                } else {
                    z.a("printConfig (" + str + ")", egl10);
                }
            }
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = z.b ? f : g;
            int[] iArr2 = new int[1];
            egl10.eglChooseConfig(eGLDisplay, iArr, (EGLConfig[]) null, 0, iArr2);
            int i2 = iArr2[0];
            if (i2 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i2];
            egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i2, iArr2);
            EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
            while (a2 == null && this.e > 0) {
                this.e = this.e == 2 ? 0 : this.e / 2;
                a2 = a(egl10, eGLDisplay, eGLConfigArr);
            }
            if (a2 == null && this.h == 24) {
                this.h = 16;
                a2 = a(egl10, eGLDisplay, eGLConfigArr);
            }
            return a2 == null ? eGLConfigArr[0] : a2;
        }
    }

    static class b implements GLSurfaceView.EGLContextFactory {
        /* synthetic */ b() {
            this((byte) 0);
        }

        private b(byte b) {
        }

        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int a = a.a(egl10, eGLDisplay, eGLConfig, 12320, 0);
            int a2 = a.a(egl10, eGLDisplay, eGLConfig, 12324, 0);
            int a3 = a.a(egl10, eGLDisplay, eGLConfig, 12323, 0);
            int a4 = a.a(egl10, eGLDisplay, eGLConfig, 12322, 0);
            int a5 = a.a(egl10, eGLDisplay, eGLConfig, 12321, 0);
            int a6 = a.a(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int a7 = a.a(egl10, eGLDisplay, eGLConfig, 12326, 0);
            int a8 = a.a(egl10, eGLDisplay, eGLConfig, 12337, 0);
            int a9 = a.a(egl10, eGLDisplay, eGLConfig, 12513, 0);
            z.a("Creating OpenGL ES " + (z.b ? "2.0" : "1.x") + " context (" + ((a5 == 0 ? "RGB" : "RGBA") + a + " " + Integer.toString(a2) + Integer.toString(a3) + Integer.toString(a4) + (a5 == 0 ? "" : Integer.toString(a5)) + " " + Integer.toString(a6) + "/" + Integer.toString(a7) + (a8 < 2 ? "" : " AAx" + Integer.toString(a8)) + (a9 < 2 ? "" : " CSAAx" + Integer.toString(a9))) + ")");
            z.a("Before eglCreateContext", egl10);
            int[] iArr = new int[3];
            iArr[0] = 12440;
            iArr[1] = z.b ? 2 : 1;
            iArr[2] = 12344;
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
            z.a("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public z(Context context, int i, boolean z, boolean z2) {
        super(context);
        a = z2;
        init(i, z, 16, 16, 0, 0);
    }

    static /* synthetic */ void a(String str) {
        if (!a) {
            Log.d("Unity", str);
        }
    }

    static /* synthetic */ void a(String str, EGL10 egl10) {
        int i = 0;
        while (i < 2) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12288) {
                Log.e("Unity", String.format("%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(eglGetError)}));
                i++;
            } else {
                return;
            }
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public final void a() {
        super.onDetachedFromWindow();
    }

    public final void a(int i) {
        if (this.c != null) {
            this.c.e = i;
        }
    }

    public final void a(boolean z) {
        if (this.c != null) {
            if (z) {
                if (!(Build.VERSION.SDK_INT >= 9)) {
                    return;
                }
            }
            if (z) {
                this.c.a = 8;
                this.c.b = 8;
                this.c.c = 8;
                this.c.d = 8;
                return;
            }
            this.c.a = 5;
            this.c.b = 6;
            this.c.c = 5;
            this.c.d = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void init(int i, boolean z, int i2, int i3, int i4, int i5) {
        boolean z2 = true;
        b = i == 2;
        if (Build.VERSION.SDK_INT < 9) {
            z2 = false;
        }
        if (!z2) {
            i2 = 16;
        }
        int i6 = z ? -3 : -1;
        if (i2 == 32 && !z) {
            i6 = 2;
        }
        getHolder().setFormat(i6);
        setEGLContextFactory(new b());
        this.c = (z || i2 == 32) ? new a(8, 8, 8, 8, i3, i4, i5) : new a(5, 6, 5, 0, i3, i4, i5);
        setEGLConfigChooser(this.c);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!a) {
            Log.d("Unity", "onDetachedFromWindow");
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }
}
