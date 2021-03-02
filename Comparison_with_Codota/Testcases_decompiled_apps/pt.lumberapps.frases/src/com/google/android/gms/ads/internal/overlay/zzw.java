package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
@zzin
public class zzw extends Thread implements SurfaceTexture.OnFrameAvailableListener, C1293q {

    /* renamed from: a */
    private static final float[] f3809a = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: A */
    private volatile boolean f3810A;

    /* renamed from: B */
    private volatile boolean f3811B;

    /* renamed from: b */
    private final C1291o f3812b;

    /* renamed from: c */
    private final float[] f3813c;

    /* renamed from: d */
    private final float[] f3814d;

    /* renamed from: e */
    private final float[] f3815e;

    /* renamed from: f */
    private final float[] f3816f;

    /* renamed from: g */
    private final float[] f3817g;

    /* renamed from: h */
    private final float[] f3818h;

    /* renamed from: i */
    private final float[] f3819i;

    /* renamed from: j */
    private float f3820j;

    /* renamed from: k */
    private float f3821k;

    /* renamed from: l */
    private float f3822l;

    /* renamed from: m */
    private int f3823m;

    /* renamed from: n */
    private int f3824n;

    /* renamed from: o */
    private SurfaceTexture f3825o;

    /* renamed from: p */
    private SurfaceTexture f3826p;

    /* renamed from: q */
    private int f3827q;

    /* renamed from: r */
    private int f3828r;

    /* renamed from: s */
    private int f3829s;

    /* renamed from: t */
    private FloatBuffer f3830t = ByteBuffer.allocateDirect(f3809a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* renamed from: u */
    private final CountDownLatch f3831u;

    /* renamed from: v */
    private final Object f3832v;

    /* renamed from: w */
    private EGL10 f3833w;

    /* renamed from: x */
    private EGLDisplay f3834x;

    /* renamed from: y */
    private EGLContext f3835y;

    /* renamed from: z */
    private EGLSurface f3836z;

    zzw(Context context) {
        super("SphericalVideoProcessor");
        this.f3830t.put(f3809a).position(0);
        this.f3813c = new float[9];
        this.f3814d = new float[9];
        this.f3815e = new float[9];
        this.f3816f = new float[9];
        this.f3817g = new float[9];
        this.f3818h = new float[9];
        this.f3819i = new float[9];
        this.f3820j = Float.NaN;
        this.f3812b = new C1291o(context);
        this.f3812b.mo5417a((C1293q) this);
        this.f3831u = new CountDownLatch(1);
        this.f3832v = new Object();
    }

    /* renamed from: a */
    private float m5682a(float[] fArr) {
        float[] a = m5687a(fArr, new float[]{0.0f, 1.0f, 0.0f});
        return ((float) Math.atan2((double) a[1], (double) a[0])) - 1.5707964f;
    }

    /* renamed from: a */
    private int m5683a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m5684a("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            m5684a("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            m5684a("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            m5684a("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", new StringBuilder(37).append("Could not compile shader ").append(i).append(":").toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                m5684a("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    /* renamed from: a */
    private void m5684a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", new StringBuilder(String.valueOf(str).length() + 21).append(str).append(": glError ").append(glGetError).toString());
        }
    }

    /* renamed from: a */
    private void m5685a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = (float) (-Math.sin((double) f));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin((double) f);
        fArr[8] = (float) Math.cos((double) f);
    }

    /* renamed from: a */
    private void m5686a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    /* renamed from: a */
    private float[] m5687a(float[] fArr, float[] fArr2) {
        return new float[]{(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[5] * fArr2[2]), (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[8] * fArr2[2])};
    }

    /* renamed from: b */
    private void m5688b(float[] fArr, float f) {
        fArr[0] = (float) Math.cos((double) f);
        fArr[1] = (float) (-Math.sin((double) f));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin((double) f);
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    /* renamed from: f */
    private void m5689f() {
        GLES20.glViewport(0, 0, this.f3824n, this.f3823m);
        m5684a("viewport");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3827q, "uFOVx");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3827q, "uFOVy");
        if (this.f3824n > this.f3823m) {
            GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
            GLES20.glUniform1f(glGetUniformLocation2, (((float) this.f3823m) * 0.87266463f) / ((float) this.f3824n));
            return;
        }
        GLES20.glUniform1f(glGetUniformLocation, (((float) this.f3824n) * 0.87266463f) / ((float) this.f3823m));
        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
    }

    /* renamed from: g */
    private int m5690g() {
        int a;
        int a2 = m5683a(35633, m5692i());
        if (a2 == 0 || (a = m5683a(35632, m5693j())) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        m5684a("createProgram");
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a2);
            m5684a("attachShader");
            GLES20.glAttachShader(glCreateProgram, a);
            m5684a("attachShader");
            GLES20.glLinkProgram(glCreateProgram);
            m5684a("linkProgram");
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            m5684a("getProgramiv");
            if (iArr[0] != 1) {
                Log.e("SphericalVideoRenderer", "Could not link program: ");
                Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                m5684a("deleteProgram");
                return 0;
            }
            GLES20.glValidateProgram(glCreateProgram);
            m5684a("validateProgram");
        }
        return glCreateProgram;
    }

    /* renamed from: h */
    private EGLConfig m5691h() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f3833w.eglChooseConfig(this.f3834x, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr)) {
            return null;
        }
        if (iArr[0] > 0) {
            return eGLConfigArr[0];
        }
        return null;
    }

    /* renamed from: i */
    private String m5692i() {
        zzcy zzcy = zzdc.zzbam;
        return !((String) zzcy.get()).equals(zzcy.zzjw()) ? (String) zzcy.get() : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
    }

    /* renamed from: j */
    private String m5693j() {
        zzcy zzcy = zzdc.zzban;
        return !((String) zzcy.get()).equals(zzcy.zzjw()) ? (String) zzcy.get() : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5539a() {
        synchronized (this.f3832v) {
            this.f3811B = true;
            this.f3826p = null;
            this.f3832v.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5540a(float f, float f2) {
        float f3;
        float f4;
        if (this.f3824n > this.f3823m) {
            f3 = (1.7453293f * f) / ((float) this.f3824n);
            f4 = (1.7453293f * f2) / ((float) this.f3824n);
        } else {
            f3 = (1.7453293f * f) / ((float) this.f3823m);
            f4 = (1.7453293f * f2) / ((float) this.f3823m);
        }
        this.f3821k -= f3;
        this.f3822l -= f4;
        if (this.f3822l < -1.5707964f) {
            this.f3822l = -1.5707964f;
        }
        if (this.f3822l > 1.5707964f) {
            this.f3822l = 1.5707964f;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5541a(int i, int i2) {
        synchronized (this.f3832v) {
            this.f3824n = i;
            this.f3823m = i2;
            this.f3810A = true;
            this.f3832v.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5542a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f3824n = i;
        this.f3823m = i2;
        this.f3826p = surfaceTexture;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5543b() {
        while (this.f3829s > 0) {
            this.f3825o.updateTexImage();
            this.f3829s--;
        }
        if (this.f3812b.mo5420b(this.f3813c)) {
            if (Float.isNaN(this.f3820j)) {
                this.f3820j = -m5682a(this.f3813c);
            }
            m5688b(this.f3818h, this.f3820j + this.f3821k);
        } else {
            m5685a(this.f3813c, -1.5707964f);
            m5688b(this.f3818h, this.f3821k);
        }
        m5685a(this.f3814d, 1.5707964f);
        m5686a(this.f3815e, this.f3818h, this.f3814d);
        m5686a(this.f3816f, this.f3813c, this.f3815e);
        m5685a(this.f3817g, this.f3822l);
        m5686a(this.f3819i, this.f3817g, this.f3816f);
        GLES20.glUniformMatrix3fv(this.f3828r, 1, false, this.f3819i, 0);
        GLES20.glDrawArrays(5, 0, 4);
        m5684a("drawArrays");
        GLES20.glFinish();
        this.f3833w.eglSwapBuffers(this.f3834x, this.f3836z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo5544c() {
        this.f3827q = m5690g();
        GLES20.glUseProgram(this.f3827q);
        m5684a("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f3827q, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.f3830t);
        m5684a("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        m5684a("enableVertexAttribArray");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        m5684a("genTextures");
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        m5684a("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        m5684a("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        m5684a("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        m5684a("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        m5684a("texParameteri");
        this.f3828r = GLES20.glGetUniformLocation(this.f3827q, "uVMat");
        GLES20.glUniformMatrix3fv(this.f3828r, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5545d() {
        this.f3833w = (EGL10) EGLContext.getEGL();
        this.f3834x = this.f3833w.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f3834x == EGL10.EGL_NO_DISPLAY) {
            return false;
        }
        if (!this.f3833w.eglInitialize(this.f3834x, new int[2])) {
            return false;
        }
        EGLConfig h = m5691h();
        if (h == null) {
            return false;
        }
        this.f3835y = this.f3833w.eglCreateContext(this.f3834x, h, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        if (this.f3835y == null || this.f3835y == EGL10.EGL_NO_CONTEXT) {
            return false;
        }
        this.f3836z = this.f3833w.eglCreateWindowSurface(this.f3834x, h, this.f3826p, (int[]) null);
        if (this.f3836z == null || this.f3836z == EGL10.EGL_NO_SURFACE) {
            return false;
        }
        return this.f3833w.eglMakeCurrent(this.f3834x, this.f3836z, this.f3836z, this.f3835y);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5546e() {
        boolean z = false;
        if (!(this.f3836z == null || this.f3836z == EGL10.EGL_NO_SURFACE)) {
            z = this.f3833w.eglMakeCurrent(this.f3834x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false | this.f3833w.eglDestroySurface(this.f3834x, this.f3836z);
            this.f3836z = null;
        }
        if (this.f3835y != null) {
            z |= this.f3833w.eglDestroyContext(this.f3834x, this.f3835y);
            this.f3835y = null;
        }
        if (this.f3834x == null) {
            return z;
        }
        boolean eglTerminate = z | this.f3833w.eglTerminate(this.f3834x);
        this.f3834x = null;
        return eglTerminate;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f3829s++;
        synchronized (this.f3832v) {
            this.f3832v.notifyAll();
        }
    }

    public void run() {
        boolean z = false;
        if (this.f3826p == null) {
            zzkd.m5769e("SphericalVideoProcessor started with no output texture.");
            this.f3831u.countDown();
            return;
        }
        boolean d = mo5545d();
        int c = mo5544c();
        if (this.f3827q != 0) {
            z = true;
        }
        if (!d || !z) {
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.f3833w.eglGetError()));
            String concat = valueOf.length() != 0 ? "EGL initialization failed: ".concat(valueOf) : new String("EGL initialization failed: ");
            zzkd.m5769e(concat);
            zzu.zzft().zzb(new Throwable(concat), true);
            mo5546e();
            this.f3831u.countDown();
            return;
        }
        this.f3825o = new SurfaceTexture(c);
        this.f3825o.setOnFrameAvailableListener(this);
        this.f3831u.countDown();
        this.f3812b.mo5419b();
        try {
            this.f3810A = true;
            while (!this.f3811B) {
                mo5543b();
                if (this.f3810A) {
                    m5689f();
                    this.f3810A = false;
                }
                try {
                    synchronized (this.f3832v) {
                        if (!this.f3811B && !this.f3810A && this.f3829s == 0) {
                            this.f3832v.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        } catch (IllegalStateException e2) {
            zzkd.zzcx("SphericalVideoProcessor halted unexpectedly.");
        } catch (Throwable th) {
            zzkd.zzb("SphericalVideoProcessor died.", th);
            zzu.zzft().zzb(th, true);
        } finally {
            this.f3812b.mo5421c();
            this.f3825o.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            this.f3825o = null;
            mo5546e();
        }
    }

    public void zznz() {
        synchronized (this.f3832v) {
            this.f3832v.notifyAll();
        }
    }

    public SurfaceTexture zzox() {
        if (this.f3826p == null) {
            return null;
        }
        try {
            this.f3831u.await();
        } catch (InterruptedException e) {
        }
        return this.f3825o;
    }
}
