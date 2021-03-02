package com.vertifi.imageproc;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class ImageProcessing {
    private static boolean DEBUG = false;
    private static final String TITLE = "VIPLibrary";
    static final float VASPECT_RATIO_MAX = 3.4f;
    static final float VASPECT_RATIO_MIN = 1.6f;
    static final int VCORNER_LOCATOR_THUMB_WIDTH = 1024;
    static final float VCROP_CORNER_ANGLE_MAX = 105.0f;
    static final float VCROP_CORNER_ANGLE_MIN = 75.0f;
    static final float VCROP_CORNER_ANGLE_OPTIMAL_MAX = 92.0f;
    static final float VCROP_CORNER_ANGLE_OPTIMAL_MIN = 88.0f;
    static final float VCROP_CORNER_ANGLE_SUBOPTIMAL_MAX = 98.0f;
    static final float VCROP_CORNER_ANGLE_SUBOPTIMAL_MIN = 82.0f;
    static final float VDARKNESS_BACK_MAX = 0.15f;
    static final float VDARKNESS_BACK_MIN = 0.006f;
    static final float VDARKNESS_BACK_OPTIMAL_MAX = 0.12f;
    static final float VDARKNESS_BACK_OPTIMAL_MIN = 0.008f;
    static final float VDARKNESS_FRONT_MAX = 0.25f;
    static final float VDARKNESS_FRONT_MIN = 0.03f;
    static final float VDARKNESS_FRONT_OPTIMAL_MAX = 0.12f;
    static final float VDARKNESS_FRONT_OPTIMAL_MIN = 0.04f;
    private static final String VERSION = "5.1";
    static final Object VGLSV_TAG = 300300;
    private static Object gSync = null;
    private static final String mVIPFragmentShaderString = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform mediump float texelWidthOffset; \nuniform mediump float texelHeightOffset; \nuniform lowp float threshold;\nconst highp vec3 W = vec3(0.299, 0.587, 0.114);\nconst highp vec3 W2 = vec3(0.333, 0.333, 0.333);\nconst highp float darkPixel = 0.35;\nconst highp float darkBlurPixel = 0.45;\nvoid main()\n{\n\tfloat luminance = dot(texture2D(inputImageTexture, textureCoordinate).rgb, W);\n\t// Kernel box blur matrix\n\t// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n\t// 1 1 0 1 0 1 0 1 0 1 0 1 0 1 1\n\t// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n\t// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n\tfloat kernelColor = (luminance +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, -7.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, 7.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(-7.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(7.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, -6.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, 6.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(-6.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(6.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, -4.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, 4.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(-4.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(4.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, -2.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, 2.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(-2.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(2.0 * texelWidthOffset, 0)).rgb, W)\n\t\t\t) / 17.0;\n\t// pixel luminance blur matrix\n\t// 0 0 1 0 0\n\t// 0 0 1 0 0\n\t// 1 1 1 1 1\n\t// 0 0 1 0 0\n\t// 0 0 1 0 0\n\tluminance = (luminance +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, -2.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, 2.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(-2.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(2.0 * texelWidthOffset, 0)).rgb, W) +\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, -1.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(0, 1.0 * texelHeightOffset)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(-1.0 * texelWidthOffset, 0)).rgb, W) +\n\t\t\tdot(texture2D(inputImageTexture, textureCoordinate + vec2(1.0 * texelWidthOffset, 0)).rgb, W)\n\t\t\t) / 9.0;\n\tfloat thresholdResult = step(kernelColor - threshold, luminance);\n\tif ((thresholdResult == 1.0) && (dot(texture2D(inputImageTexture, textureCoordinate).rgb, W2) < darkPixel) && (kernelColor < darkBlurPixel))\n\t\tthresholdResult = 0.0;\n\tgl_FragColor = vec4(vec3(thresholdResult), 1.0);\n}\n";
    private static final String mVIPIdentityVertexShaderString = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main()\n{\n\tgl_Position = position;\n\ttextureCoordinate = inputTextureCoordinate.xy;\n}\n";
    private Bitmap mBitmapBW;
    private int mBrightness = 50;
    private WeakReference mContext;
    private float mDarkness;
    IntBuffer mFilterFrameBuffer;
    int mFilterInputTextureUniform;
    int mFilterPositionAttribute;
    int mFilterProgram;
    int mFilterTexelHeightOffsetUniform;
    int mFilterTexelWidthOffsetUniform;
    int mFilterTextureCoordinateAttribute;
    int mFilterThresholdUniform;
    int mFragmentShader;
    private int mHeight;
    FloatBuffer mImageVerticesBuffer;
    IntBuffer mInputTexture;
    private boolean mIsAuto;
    private boolean mIsFront;
    private byte[] mLumaPixels;
    private GLSurfaceView.Renderer mOGLRenderer = new GLSurfaceView.Renderer() {
        public void onDrawFrame(GL10 gl10) {
            if (ImageProcessing.this.mPixels32 != null) {
                ImageProcessing.this.onOGLDraw();
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            if (ImageProcessing.this.mPixels32 != null) {
                ImageProcessing.this.onOGLBindImage();
            }
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            ImageProcessing.this.onOGLInitialize();
        }
    };
    IntBuffer mOutputTexture;
    private short[] mPixels16;
    /* access modifiers changed from: private */
    public int[] mPixels32;
    FloatBuffer mTextureCoordinatesBuffer;
    int mVertexShader;
    private int mWidth;
    private GLSurfaceView mglView;

    class ContextFactory implements GLSurfaceView.EGLContextFactory {
        private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

        private ContextFactory() {
        }

        /* synthetic */ ContextFactory(ContextFactory contextFactory) {
            this();
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            Log.w(ImageProcessing.TITLE, "Creating OpenGL ES 2.0 context");
            ImageProcessing.checkEglError("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            ImageProcessing.checkEglError("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    static {
        System.loadLibrary("ImageProcessing");
    }

    public ImageProcessing(WeakReference weakReference, boolean z) {
        this.mIsFront = z;
        this.mBitmapBW = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mPixels32 = null;
        this.mPixels16 = null;
        this.mLumaPixels = null;
        this.mContext = null;
        this.mglView = null;
        this.mFilterProgram = -1;
        if (weakReference != null) {
            try {
                this.mContext = weakReference;
                Activity activity = (Activity) this.mContext.get();
                if (Build.VERSION.SDK_INT < 8) {
                    throw new Exception("OpenGL ES 2.0 not supported");
                } else if (((ActivityManager) activity.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion < 131072) {
                    throw new Exception("OpenGL ES 2.0 not supported");
                } else {
                    if (gSync == null) {
                        gSync = new Object();
                    }
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    if (viewGroup == null) {
                        throw new Exception("Context has no root ViewGroup");
                    }
                    this.mglView = new GLSurfaceView(activity);
                    this.mglView.getHolder().setFormat(1);
                    this.mglView.setTag(VGLSV_TAG);
                    this.mglView.setLayoutParams(new FrameLayout.LayoutParams(1, 1));
                    this.mglView.setEGLContextClientVersion(2);
                    this.mglView.setEGLContextFactory(new ContextFactory((ContextFactory) null));
                    this.mglView.setEGLConfigChooser(8, 8, 8, 8, 0, 0);
                    this.mglView.setRenderer(this.mOGLRenderer);
                    this.mglView.setRenderMode(0);
                    viewGroup.addView(this.mglView);
                }
            } catch (Exception e) {
                Log.e(TITLE, e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void checkEglError(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12288) {
                Log.e(TITLE, String.format("%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(eglGetError)}));
            } else {
                return;
            }
        }
    }

    private static native void doPerspectiveTransform(Bitmap bitmap, Bitmap bitmap2, double[] dArr);

    private static native void doPerspectiveTransform565(Bitmap bitmap, Bitmap bitmap2, double[] dArr);

    private static native int getBlackPixels(int[] iArr, int i, int i2);

    private static native int getBlackPixels565(short[] sArr, int i, int i2);

    private static native void getCornersLuma(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    private static native void getPerspectiveTransform(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, double[] dArr, double[] dArr2);

    private static native int getPixelLuma(int i);

    public static String getVersion() {
        return VERSION;
    }

    private static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.w(TITLE, GLES20.glGetShaderInfoLog(glCreateShader));
        return 0;
    }

    private static void onConvertBWImage(Bitmap bitmap, boolean z, int i, ArrayList arrayList) {
        try {
            float imageBW = ((float) setImageBW(bitmap, (int) Math.floor(255.0d * ((double) ((0.05f * (((float) i) / 100.0f)) + 0.01f))), z)) / ((float) (bitmap.getWidth() * bitmap.getHeight()));
            if (z && imageBW >= VDARKNESS_FRONT_MAX) {
                arrayList.add("TooDark");
            }
            if (!z && imageBW >= VDARKNESS_BACK_MAX) {
                arrayList.add("TooDark");
            }
            if (z && imageBW <= VDARKNESS_FRONT_MIN) {
                arrayList.add("TooLight");
            }
            if (!z && imageBW <= VDARKNESS_BACK_MIN) {
                arrayList.add("TooLight");
            }
        } catch (Exception e) {
            Log.e(TITLE, e.getMessage());
        }
    }

    private void onConvertBWImage(ArrayList arrayList) {
        try {
            this.mDarkness = 0.0f;
            for (int i = 0; i < 5; i++) {
                if (i > 0) {
                    if (this.mDarkness < (this.mIsFront ? 0.04f : 0.008f)) {
                        this.mBrightness = this.mBrightness > 12 ? this.mBrightness - 12 : 0;
                    } else {
                        this.mBrightness = this.mBrightness < 88 ? this.mBrightness + 12 : 100;
                    }
                }
                int floor = (int) Math.floor(255.0d * ((double) ((0.05f * (((float) this.mBrightness) / 100.0f)) + 0.01f)));
                if (this.mPixels16 == null) {
                    this.mPixels16 = new short[(this.mWidth * this.mHeight)];
                }
                this.mDarkness = ((float) setImageBW565(this.mLumaPixels, this.mPixels16, this.mWidth, this.mHeight, floor)) / ((float) (this.mWidth * this.mHeight));
                if (DEBUG) {
                    Log.d(TITLE, String.format("setImageBW565: brightness %d threshold %d darkness %f", new Object[]{Integer.valueOf(this.mBrightness), Integer.valueOf(floor), Float.valueOf(this.mDarkness)}));
                }
                if (!this.mIsAuto) {
                    break;
                }
                float f = this.mDarkness;
                boolean z = this.mIsFront;
                if (f < 0.12f) {
                    if (this.mDarkness > (this.mIsFront ? 0.04f : 0.008f)) {
                        break;
                    }
                }
            }
            if (this.mBitmapBW == null) {
                this.mBitmapBW = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.RGB_565);
            }
            this.mBitmapBW.copyPixelsFromBuffer(ShortBuffer.wrap(this.mPixels16));
        } catch (Exception e) {
            arrayList.add("SystemError");
            Log.e(TITLE, e.getMessage());
        }
    }

    public static void onCropImageYUV(byte[] bArr, Camera.Size size, RectF rectF, int[] iArr) {
        float f;
        byte[] bArr2;
        int i = size.width;
        int i2 = size.height;
        if (size.width > 1024) {
            int i3 = (int) ((1024.0f / ((float) size.width)) * ((float) size.height));
            float f2 = ((float) size.width) / 1024.0f;
            Bitmap createBitmap = Bitmap.createBitmap(size.width, size.height, Bitmap.Config.ARGB_8888);
            int[] iArr2 = new int[(size.width * size.height)];
            yuv2rgb(bArr, iArr2, size.width, size.height);
            createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(iArr2));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, 1024, i3, false);
            createScaledBitmap.getPixels(iArr2, 0, 1024, 0, 0, 1024, i3);
            createScaledBitmap.recycle();
            byte[] bArr3 = new byte[(i3 * 1024)];
            setImagePixelsLuma(iArr2, 1024, i3, bArr3);
            f = f2;
            i2 = i3;
            i = 1024;
            bArr2 = bArr3;
        } else {
            f = 1.0f;
            bArr2 = bArr;
        }
        int i4 = (int) (((float) i) * rectF.left);
        int i5 = (int) (((float) i) * rectF.right);
        if (i5 >= i) {
            i5 = i - 1;
        }
        int i6 = (int) (((float) i2) * rectF.top);
        if (i6 > 20) {
            i6 -= 20;
        }
        int i7 = (int) (((float) i2) * rectF.bottom);
        if (i7 >= i2) {
            i7 = i2 - 1;
        }
        getCornersLuma(bArr2, i, i2, i4, i6, (i5 - i4) + 1, ((i7 < i2 + -20 ? i7 + 20 : i7) - i6) + 1, iArr);
        if (f != 1.0f) {
            for (int i8 = 0; i8 < 8; i8++) {
                iArr[i8] = (int) (((float) iArr[i8]) * f);
            }
        }
    }

    private static double onGetAngle(Point point, Point point2, Point point3) {
        return Math.acos(((double) (((point2.x - point.x) * (point3.x - point.x)) + ((point2.y - point.y) * (point3.y - point.y)))) / (Math.hypot((double) (point2.x - point.x), (double) (point2.y - point.y)) * Math.hypot((double) (point3.x - point.x), (double) (point3.y - point.y)))) * 57.29577951308232d;
    }

    private static double onGetLength(Point point, Point point2) {
        return Math.hypot((double) (point2.x - point.x), (double) (point2.y - point.y));
    }

    /* access modifiers changed from: private */
    public void onOGLBindImage() {
        try {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.mInputTexture.get(0));
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, IntBuffer.wrap(this.mPixels32));
            synchronized (gSync) {
                gSync.notify();
            }
        } catch (Exception e) {
            Log.e(TITLE, e.getMessage());
            synchronized (gSync) {
                gSync.notify();
            }
        } catch (Throwable th) {
            synchronized (gSync) {
                gSync.notify();
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void onOGLCleanup() {
        try {
            if (this.mFilterProgram >= 0) {
                GLES20.glDeleteFramebuffers(1, this.mFilterFrameBuffer);
                GLES20.glDeleteTextures(1, this.mInputTexture);
                GLES20.glDeleteTextures(1, this.mOutputTexture);
                GLES20.glDeleteShader(this.mFragmentShader);
                GLES20.glDeleteShader(this.mVertexShader);
                GLES20.glDeleteProgram(this.mFilterProgram);
            }
            this.mFilterProgram = -1;
        } catch (Exception e) {
            Log.e(TITLE, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void onOGLDraw() {
        try {
            this.mDarkness = 0.0f;
            if (this.mPixels16 == null) {
                this.mPixels16 = new short[(this.mWidth * this.mHeight)];
            }
            ShortBuffer wrap = ShortBuffer.wrap(this.mPixels16);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.mOutputTexture.get(0));
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glUseProgram(this.mFilterProgram);
            GLES20.glEnableVertexAttribArray(this.mFilterPositionAttribute);
            GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute);
            GLES20.glUniform1f(this.mFilterTexelWidthOffsetUniform, (float) (1.0d / ((double) ((float) this.mWidth))));
            GLES20.glUniform1f(this.mFilterTexelHeightOffsetUniform, (float) (1.0d / ((double) ((float) this.mHeight))));
            GLES20.glActiveTexture(33985);
            GLES20.glBindFramebuffer(36160, this.mFilterFrameBuffer.get(0));
            GLES20.glBindTexture(3553, this.mOutputTexture.get(0));
            GLES20.glTexImage2D(3553, 0, 6407, this.mWidth, this.mHeight, 0, 6407, 33635, (Buffer) null);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOutputTexture.get(0), 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            for (int i = 0; i < 5; i++) {
                GLES20.glUniform1f(this.mFilterThresholdUniform, (0.05f * (((float) this.mBrightness) / 100.0f)) + 0.01f);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(3553, this.mInputTexture.get(0));
                GLES20.glUniform1i(this.mFilterInputTextureUniform, 2);
                GLES20.glVertexAttribPointer(this.mFilterPositionAttribute, 2, 5126, false, 0, this.mImageVerticesBuffer);
                GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute, 2, 5126, false, 0, this.mTextureCoordinatesBuffer);
                GLES20.glDrawArrays(5, 0, 4);
                wrap.position(0);
                GLES20.glReadPixels(0, 0, this.mWidth, this.mHeight, 6407, 33635, wrap);
                this.mDarkness = ((float) getBlackPixels565(this.mPixels16, this.mWidth, this.mHeight)) / ((float) (this.mHeight * this.mWidth));
                if (!this.mIsAuto || ((this.mIsFront && this.mDarkness < 0.12f && this.mDarkness > VDARKNESS_FRONT_OPTIMAL_MIN) || (!this.mIsFront && this.mDarkness < 0.12f && this.mDarkness > VDARKNESS_BACK_OPTIMAL_MIN))) {
                    break;
                }
                if ((!this.mIsFront || this.mDarkness > VDARKNESS_FRONT_OPTIMAL_MIN) && (this.mIsFront || this.mDarkness > VDARKNESS_BACK_OPTIMAL_MIN)) {
                    this.mBrightness = this.mBrightness < 88 ? this.mBrightness + 12 : 100;
                } else {
                    this.mBrightness = this.mBrightness > 12 ? this.mBrightness - 12 : 0;
                }
            }
            if (this.mBitmapBW == null) {
                this.mBitmapBW = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.RGB_565);
            }
            this.mBitmapBW.copyPixelsFromBuffer(wrap);
            synchronized (gSync) {
                gSync.notify();
            }
        } catch (Exception e) {
            Log.d(TITLE, e.getMessage());
            synchronized (gSync) {
                gSync.notify();
            }
        } catch (Throwable th) {
            synchronized (gSync) {
                gSync.notify();
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void onOGLInitialize() {
        try {
            this.mDarkness = 0.0f;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.mImageVerticesBuffer = allocateDirect.asFloatBuffer();
            this.mImageVerticesBuffer.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
            this.mImageVerticesBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
            allocateDirect2.order(ByteOrder.nativeOrder());
            this.mTextureCoordinatesBuffer = allocateDirect2.asFloatBuffer();
            this.mTextureCoordinatesBuffer.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
            this.mTextureCoordinatesBuffer.position(0);
            GLES20.glDisable(2929);
            GLES20.glEnable(3553);
            GLES20.glPixelStorei(3317, 1);
            GLES20.glPixelStorei(3333, 1);
            this.mVertexShader = loadShader(35633, mVIPIdentityVertexShaderString);
            this.mFragmentShader = loadShader(35632, mVIPFragmentShaderString);
            this.mFilterProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.mFilterProgram, this.mVertexShader);
            GLES20.glAttachShader(this.mFilterProgram, this.mFragmentShader);
            GLES20.glLinkProgram(this.mFilterProgram);
            this.mFilterPositionAttribute = GLES20.glGetAttribLocation(this.mFilterProgram, "position");
            this.mFilterTextureCoordinateAttribute = GLES20.glGetAttribLocation(this.mFilterProgram, "inputTextureCoordinate");
            this.mFilterInputTextureUniform = GLES20.glGetUniformLocation(this.mFilterProgram, "inputImageTexture");
            this.mFilterTexelWidthOffsetUniform = GLES20.glGetUniformLocation(this.mFilterProgram, "texelWidthOffset");
            this.mFilterTexelHeightOffsetUniform = GLES20.glGetUniformLocation(this.mFilterProgram, "texelHeightOffset");
            this.mFilterThresholdUniform = GLES20.glGetUniformLocation(this.mFilterProgram, "threshold");
            this.mInputTexture = IntBuffer.allocate(1);
            GLES20.glActiveTexture(33984);
            GLES20.glGenTextures(1, this.mInputTexture);
            this.mOutputTexture = IntBuffer.allocate(1);
            GLES20.glGenTextures(1, this.mOutputTexture);
            this.mFilterFrameBuffer = IntBuffer.allocate(1);
            GLES20.glGenFramebuffers(1, this.mFilterFrameBuffer);
        } catch (Exception e) {
            Log.e(TITLE, e.getMessage());
        }
    }

    private void setDarknessResults(ArrayList arrayList) {
        if (this.mIsFront && this.mDarkness >= VDARKNESS_FRONT_MAX) {
            arrayList.add("TooDark");
        }
        if (!this.mIsFront && this.mDarkness >= VDARKNESS_BACK_MAX) {
            arrayList.add("TooDark");
        }
        if (this.mIsFront && this.mDarkness <= VDARKNESS_FRONT_MIN) {
            arrayList.add("TooLight");
        }
        if (!this.mIsFront && this.mDarkness <= VDARKNESS_BACK_MIN) {
            arrayList.add("TooLight");
        }
    }

    private static native int setImageBW(Bitmap bitmap, int i, boolean z);

    private static native int setImageBW565(byte[] bArr, short[] sArr, int i, int i2, int i3);

    private static native void setImagePixelsLuma(int[] iArr, int i, int i2, byte[] bArr);

    private static native void yuv2rgb(byte[] bArr, int[] iArr, int i, int i2);

    /* access modifiers changed from: protected */
    public void finalize() {
        super.finalize();
    }

    public int getBrightness() {
        return this.mBrightness;
    }

    public float getDarkness() {
        return this.mDarkness;
    }

    public void onProcessImageBWBindImage(Bitmap bitmap) {
        try {
            this.mWidth = bitmap.getWidth();
            this.mHeight = bitmap.getHeight();
            if (this.mBitmapBW != null) {
                this.mBitmapBW.recycle();
            }
            this.mBitmapBW = null;
            this.mPixels32 = null;
            this.mPixels16 = null;
            this.mLumaPixels = null;
            this.mPixels32 = new int[(this.mWidth * this.mHeight)];
            bitmap.getPixels(this.mPixels32, 0, this.mWidth, 0, 0, this.mWidth, this.mHeight);
            if (this.mglView != null) {
                this.mglView.queueEvent(new Runnable() {
                    public void run() {
                        ImageProcessing.this.onOGLBindImage();
                    }
                });
                synchronized (gSync) {
                    gSync.wait();
                }
                return;
            }
            this.mLumaPixels = new byte[(this.mWidth * this.mHeight)];
            setImagePixelsLuma(this.mPixels32, this.mWidth, this.mHeight, this.mLumaPixels);
            this.mPixels32 = null;
        } catch (Exception e) {
        }
    }

    public Bitmap onProcessImageBWDrawImage(int i, ArrayList arrayList) {
        try {
            this.mBrightness = i;
            this.mIsAuto = false;
            if (this.mglView != null) {
                this.mglView.requestRender();
                synchronized (gSync) {
                    gSync.wait();
                }
            } else {
                onConvertBWImage(arrayList);
            }
            setDarknessResults(arrayList);
            return this.mBitmapBW;
        } catch (Exception e) {
            arrayList.add("SystemError");
            Log.e(TITLE, e.getMessage());
            return null;
        }
    }

    public Bitmap onProcessImageBWDrawImageAuto(ArrayList arrayList) {
        try {
            this.mBrightness = 50;
            this.mIsAuto = true;
            if (this.mglView != null) {
                this.mglView.requestRender();
                synchronized (gSync) {
                    gSync.wait();
                }
            } else {
                onConvertBWImage(arrayList);
            }
            setDarknessResults(arrayList);
            return this.mBitmapBW;
        } catch (Exception e) {
            arrayList.add("SystemError");
            Log.e(TITLE, e.getMessage());
            return null;
        }
    }

    public Bitmap onProcessImageCropLocate(Bitmap bitmap, Point[] pointArr, ArrayList arrayList, Rect rect, RectF rectF, Camera.Size size) {
        float width;
        try {
            int[] iArr = new int[8];
            int i = (int) ((1024.0f / ((float) size.width)) * ((float) size.height));
            float f = ((float) size.width) / 1024.0f;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 1024, i, false);
            int[] iArr2 = new int[(i * 1024)];
            createScaledBitmap.getPixels(iArr2, 0, 1024, 0, 0, 1024, i);
            createScaledBitmap.recycle();
            byte[] bArr = new byte[(i * 1024)];
            setImagePixelsLuma(iArr2, 1024, i, bArr);
            int i2 = (int) ((rectF.left > 0.05f ? rectF.left - 0.025f : rectF.left) * 1024.0f);
            int i3 = (int) ((rectF.right < 0.95f ? rectF.right + 0.025f : rectF.right) * 1024.0f);
            int i4 = i3 >= 1024 ? 1023 : i3;
            int i5 = (int) ((rectF.top < 0.05f ? rectF.top - 0.025f : rectF.top) * ((float) i));
            int i6 = (int) ((rectF.bottom < 0.95f ? rectF.bottom + 0.025f : rectF.bottom) * ((float) i));
            if (i6 >= i) {
                i6 = i - 1;
            }
            getCornersLuma(bArr, 1024, i, i2, i5, (i4 - i2) + 1, (i6 - i5) + 1, iArr);
            for (int i7 = 0; i7 < 8; i7++) {
                iArr[i7] = (int) (((float) iArr[i7]) * f);
            }
            Point point = new Point(iArr[0], iArr[1]);
            Point point2 = new Point(iArr[2], iArr[3]);
            Point point3 = new Point(iArr[4], iArr[5]);
            Point point4 = new Point(iArr[6], iArr[7]);
            if ((point.x == 0 && point.y == 0) || ((point2.x == 0 && point2.y == 0) || ((point4.x == 0 && point4.y == 0) || (point3.x == 0 && point3.y == 0)))) {
                if (DEBUG) {
                    Log.d(TITLE, String.format("rectCrop missing point(s)", new Object[0]));
                }
                arrayList.add("CropError");
                return null;
            }
            int min = Math.min(point.x, point4.x);
            int min2 = Math.min(point.y, point2.y);
            int max = Math.max(point2.x, point3.x);
            int max2 = Math.max(point4.y, point3.y);
            if (point.x > 0 && point4.x > 0 && point2.x > 0 && point3.x > 0) {
                if (min < ((int) (((float) size.width) * rectF.left))) {
                    min = (int) (((float) size.width) * rectF.left);
                }
                if (max > ((int) (((float) size.width) * rectF.right))) {
                    max = (int) (((float) size.width) * rectF.right);
                }
                if (min2 < ((int) (((float) size.height) * rectF.top))) {
                    min2 = (int) (((float) size.height) * rectF.top);
                }
                if (max2 > ((int) (((float) size.height) * rectF.bottom))) {
                    max2 = (int) (((float) size.height) * rectF.bottom);
                }
            }
            Rect rect2 = new Rect(min, min2, max, max2);
            if (rect2.width() <= 0 || rect2.height() <= 0) {
                if (DEBUG) {
                    Log.d(TITLE, String.format("rectCrop.width()=%d rectCrop.height() = %d", new Object[]{Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height())}));
                }
                arrayList.add("CropError");
                return null;
            }
            Matrix matrix = new Matrix();
            int width2 = rect2.width();
            int height = rect2.height();
            float f2 = 1.0f;
            if (rect == null) {
                while (true) {
                    if (((float) width2) * f2 <= 1720.0f && ((float) height) * f2 <= 820.0f) {
                        break;
                    }
                    f2 = (float) (((double) f2) - 0.05d);
                }
                while (true) {
                    if (((float) width2) * f2 >= 1180.0f && ((float) height) * f2 >= 500.0f) {
                        break;
                    }
                    f2 = (float) (((double) f2) + 0.1d);
                }
                width = f2;
            } else {
                width = ((float) rect.width()) / ((float) rect2.width());
            }
            matrix.setScale(width, width);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect2.left, rect2.top, rect2.width(), rect2.height(), matrix, false);
            int width3 = createBitmap.getWidth();
            int height2 = createBitmap.getHeight();
            float abs = ((float) Math.abs(point.x - point4.x)) * width;
            if (point.x <= point4.x) {
                point.x = 0;
                point4.x = (int) abs;
            } else {
                point.x = (int) abs;
                point4.x = 0;
            }
            float abs2 = ((float) Math.abs(point.y - point2.y)) * width;
            if (point.y <= point2.y) {
                point.y = 0;
                point2.y = (int) abs2;
            } else {
                point.y = (int) abs2;
                point2.y = 0;
            }
            float abs3 = ((float) Math.abs(point2.x - point3.x)) * width;
            if (point2.x >= point3.x) {
                point2.x = width3 - 1;
                point3.x = (width3 - 1) - ((int) abs3);
            } else {
                point2.x = (width3 - 1) - ((int) abs3);
                point3.x = width3 - 1;
            }
            float abs4 = ((float) Math.abs(point4.y - point3.y)) * width;
            if (point4.y >= point3.y) {
                point4.y = height2 - 1;
                point3.y = (height2 - 1) - ((int) abs4);
            } else {
                point4.y = (height2 - 1) - ((int) abs4);
                point3.y = height2 - 1;
            }
            pointArr[0] = point;
            pointArr[1] = point2;
            pointArr[2] = point3;
            pointArr[3] = point4;
            return createBitmap;
        } catch (Exception e) {
            arrayList.add("SystemError");
            Log.e(TITLE, e.getMessage());
            return null;
        }
    }

    public Bitmap onProcessImageCropTransform(Bitmap bitmap, Point[] pointArr, ArrayList arrayList, Rect rect) {
        int i;
        float f;
        try {
            Point point = pointArr[0];
            Point point2 = pointArr[1];
            Point point3 = pointArr[2];
            Point point4 = pointArr[3];
            double onGetAngle = onGetAngle(point, point2, point4);
            double onGetAngle2 = onGetAngle(point2, point, point3);
            double onGetAngle3 = onGetAngle(point4, point, point3);
            double onGetAngle4 = onGetAngle(point3, point2, point4);
            if (onGetAngle < 75.0d || onGetAngle > 105.0d || onGetAngle2 < 75.0d || onGetAngle2 > 105.0d || onGetAngle3 < 75.0d || onGetAngle3 > 105.0d || onGetAngle4 < 75.0d || onGetAngle4 > 105.0d) {
                if (DEBUG) {
                    Log.d(TITLE, String.format("angles = %f, %f, %f, %f", new Object[]{Double.valueOf(onGetAngle), Double.valueOf(onGetAngle2), Double.valueOf(onGetAngle3), Double.valueOf(onGetAngle4)}));
                }
                arrayList.add("CropError");
            } else {
                int i2 = 0;
                if (onGetAngle > 88.0d && onGetAngle < 92.0d) {
                    i2 = 1;
                }
                if (onGetAngle2 > 88.0d && onGetAngle2 < 92.0d) {
                    i2++;
                }
                if (onGetAngle3 > 88.0d && onGetAngle3 < 92.0d) {
                    i2++;
                }
                int i3 = (onGetAngle4 <= 88.0d || onGetAngle4 >= 92.0d) ? i2 : i2 + 1;
                int i4 = 0;
                if (onGetAngle < 82.0d || onGetAngle > 98.0d) {
                    i4 = 1;
                }
                if (onGetAngle2 < 82.0d || onGetAngle2 > 98.0d) {
                    i4++;
                }
                if (onGetAngle3 < 82.0d || onGetAngle3 > 98.0d) {
                    i4++;
                }
                if (onGetAngle4 < 82.0d || onGetAngle4 > 98.0d) {
                    i4++;
                }
                if (i3 >= 2 && i4 > 0) {
                    if (DEBUG) {
                        Log.d(TITLE, String.format("non-optimal angles = %f, %f, %f, %f", new Object[]{Double.valueOf(onGetAngle), Double.valueOf(onGetAngle2), Double.valueOf(onGetAngle3), Double.valueOf(onGetAngle4)}));
                    }
                    arrayList.add("CropError");
                }
            }
            int max = (int) Math.max(onGetLength(point, point2), onGetLength(point4, point3));
            int max2 = (int) Math.max(onGetLength(point, point4), onGetLength(point2, point3));
            if (((onGetAngle > 92.0d && onGetAngle2 > 92.0d) || (onGetAngle < 88.0d && onGetAngle2 < 88.0d)) && onGetAngle >= 75.0d && onGetAngle <= 105.0d && onGetAngle2 >= 75.0d && onGetAngle2 <= 105.0d && onGetAngle3 >= 75.0d && onGetAngle3 <= 105.0d && onGetAngle4 >= 75.0d && onGetAngle4 <= 105.0d) {
                max2 = (int) (((Math.abs(((onGetAngle + onGetAngle2) / 2.0d) - 90.0d) / 100.0d) + 1.0d) * ((double) max2));
            }
            if (DEBUG) {
                Log.d(TITLE, String.format("adjusted size %d x %d", new Object[]{Integer.valueOf(max), Integer.valueOf(i)}));
            }
            if (rect != null) {
                float width = ((float) rect.width()) / ((float) max);
                int width2 = rect.width();
                i = (int) (((float) i) * width);
                if (DEBUG) {
                    Log.d(TITLE, String.format("back image scale %f, ref width %d adjusted size %d x %d", new Object[]{Float.valueOf(width), Integer.valueOf(rect.width()), Integer.valueOf(width2), Integer.valueOf(i)}));
                }
                if (Math.abs((((float) i) * width) - ((float) rect.height())) >= 100.0f) {
                    int width3 = rect.width() - 70;
                    while (true) {
                        if (width3 > rect.width() + 70) {
                            break;
                        }
                        width = ((float) width3) / ((float) rect.width());
                        if (DEBUG) {
                            Log.d(TITLE, String.format("back image scale %f, out of scale %f", new Object[]{Float.valueOf(width), Float.valueOf(Math.abs((((float) i) * width) - ((float) rect.height())))}));
                        }
                        if (Math.abs((((float) i) * width) - ((float) rect.height())) < 100.0f) {
                            i = (int) (((float) i) * width);
                            float f2 = width;
                            max = width3;
                            f = f2;
                            break;
                        }
                        width3 += 10;
                    }
                }
                f = width;
                max = width2;
                if (DEBUG) {
                    Log.d(TITLE, String.format("back image scale %f, ref width %d adjusted size %d x %d", new Object[]{Float.valueOf(f), Integer.valueOf(rect.width()), Integer.valueOf(max), Integer.valueOf(i)}));
                }
                if (Math.abs(i - rect.height()) >= 100) {
                    arrayList.add("OutOfScale");
                }
            }
            if (max > 1880 || i > 900) {
                arrayList.add("OversizedImage");
            }
            if (max < 1140 || i < 460) {
                arrayList.add("UndersizedImage");
            }
            float f3 = ((float) max) / ((float) i);
            if (f3 < VASPECT_RATIO_MIN || f3 > VASPECT_RATIO_MAX) {
                if (arrayList.size() == 0) {
                    arrayList.add("CropError");
                }
                if (DEBUG) {
                    Log.d(TITLE, String.format("aspectRatio w/h = %f", new Object[]{Float.valueOf(f3)}));
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(max, i, bitmap.getConfig());
            double[] dArr = new double[9];
            getPerspectiveTransform(max, i, point.x, point.y, point2.x, point2.y, point4.x, point4.y, point3.x, point3.y, new double[9], dArr);
            if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                doPerspectiveTransform(bitmap, createBitmap, dArr);
            } else if (bitmap.getConfig() == Bitmap.Config.RGB_565) {
                doPerspectiveTransform565(bitmap, createBitmap, dArr);
            } else {
                throw new Exception(String.format("Bitmap format %s not supported", new Object[]{bitmap.getConfig().toString()}));
            }
            return createBitmap;
        } catch (Exception e) {
            arrayList.add("SystemError");
            Log.e(TITLE, e.getMessage());
            return null;
        }
    }

    public void onProcessImageDestroy() {
        try {
            if (this.mglView != null) {
                try {
                    this.mglView.queueEvent(new Runnable() {
                        public void run() {
                            ImageProcessing.this.onOGLCleanup();
                        }
                    });
                    ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext.get()).getWindow().getDecorView();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.mglView);
                    }
                } catch (Exception e) {
                }
            }
            if (this.mBitmapBW != null) {
                this.mBitmapBW.recycle();
            }
            this.mBitmapBW = null;
            this.mLumaPixels = null;
            this.mPixels32 = null;
            this.mPixels16 = null;
        } catch (Exception e2) {
            Log.e(TITLE, e2.getMessage());
        }
    }

    public void onProcessImagePause() {
        try {
            if (this.mglView != null) {
                this.mglView.onPause();
            }
        } catch (Exception e) {
        }
    }

    public void onProcessImageResume() {
        try {
            if (this.mglView != null) {
                this.mglView.onResume();
            }
        } catch (Exception e) {
        }
    }
}
