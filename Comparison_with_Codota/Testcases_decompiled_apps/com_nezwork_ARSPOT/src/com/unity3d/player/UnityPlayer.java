package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.Vibrator;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.qualcomm.ar.pl.SystemTools;
import com.unity3d.player.a;
import com.unity3d.player.a.e;
import com.unity3d.player.a.f;
import com.unity3d.player.a.i;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.fmod.FMODAudioDevice;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UnityPlayer extends FrameLayout implements GLSurfaceView.Renderer, a.C0004a {
    private static b S;
    public static Activity currentActivity = null;
    /* access modifiers changed from: private */
    public static boolean r = false;
    private static boolean s = true;
    /* access modifiers changed from: private */
    public boolean A = false;
    private final p B;
    private int C = 0;
    private String D = null;
    private NetworkInfo E = null;
    private e F = null;
    /* access modifiers changed from: private */
    public boolean G = false;
    /* access modifiers changed from: private */
    public boolean H = false;
    private boolean I = false;
    /* access modifiers changed from: private */
    public Bundle J = new Bundle();
    private List K = new ArrayList();
    private boolean L = true;
    private boolean M = false;
    /* access modifiers changed from: private */
    public boolean N = false;
    private Runnable O = new aa(this);
    /* access modifiers changed from: private */
    public ProgressBar P = null;
    private Runnable Q = new ab(this);
    private Runnable R = new ac(this);
    private float T = 0.0f;
    private float U = 0.0f;
    /* access modifiers changed from: private */
    public Method V = null;
    private LinkedHashMap W;
    private BroadcastReceiver Z = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                UnityPlayer.this.queueEvent(new Runnable() {
                    public final void run() {
                        UnityPlayer.this.nativeJoystickRemoved();
                    }
                });
            } catch (Exception e) {
            }
        }
    };
    x a = null;
    private boolean aa = false;
    private int ab = 1;
    private boolean ac = true;
    /* access modifiers changed from: private */
    public boolean b = false;
    /* access modifiers changed from: private */
    public boolean c = false;
    private final h d;
    private final y e = new y(this);
    private boolean f = false;
    private Bundle g = null;
    private SharedPreferences h = null;
    /* access modifiers changed from: private */
    public ContextWrapper i;
    private boolean j;
    /* access modifiers changed from: private */
    public UnityGL k;
    private o l;
    private PowerManager.WakeLock m;
    private SensorManager n;
    private WindowManager o;
    private FMODAudioDevice p;
    private Vibrator q = null;
    private boolean t = false;
    private boolean u = true;
    private int v;
    /* access modifiers changed from: private */
    public int w;
    private int x = 0;
    private int y = 0;
    /* access modifiers changed from: private */
    public int z = -1;

    static {
        S = null;
        S = new b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnityPlayer(ContextWrapper contextWrapper) {
        super(contextWrapper);
        c cVar = null;
        this.i = contextWrapper;
        try {
            this.j = Class.forName("android.app.NativeActivity").isAssignableFrom(this.i.getClass());
        } catch (Exception e2) {
        }
        this.d = Build.VERSION.SDK_INT >= 9 ? new c(contextWrapper) : cVar;
        String packageName = this.i.getPackageName();
        if (contextWrapper instanceof Activity) {
            currentActivity = (Activity) contextWrapper;
            this.g = currentActivity.getIntent().getExtras();
            UnityPlayerProxyActivity.copyPlayerPrefs(contextWrapper, new String[]{"com.unity3d.player.UnityPlayerActivity", "com.unity3d.player.UnityPlayerNativeActivity", currentActivity.getLocalClassName()});
        }
        this.h = contextWrapper.getSharedPreferences(packageName, 0);
        b();
        System.loadLibrary("mono");
        int a2 = S.a();
        if ((a2 & 2) == 0 || !((a2 & 128) == 0 || (a2 & 8) == 0)) {
            r = true;
            try {
                System.loadLibrary("unity");
            } catch (UnsatisfiedLinkError e3) {
                l.Log(5, "Unable to load libraries: " + e3);
                r = false;
            }
        } else {
            l.Log(6, "CPU features not supported! (no ARMv6+ / VFP)");
        }
        nativeFile(this.i.getPackageCodePath());
        this.B = new p(contextWrapper, this);
        if (Build.VERSION.SDK_INT >= 8) {
            this.f = true;
        }
        try {
            this.I = -1 == this.i.checkCallingOrSelfPermission(new String(com.unity3d.player.b.a.b("Y29tLmFuZHJvaWQudmVuZGluZy5DSEVDS19MSUNFTlNF".getBytes())));
        } catch (Exception e4) {
            this.I = true;
        }
    }

    public static native void UnitySendMessage(String str, String str2, String str3);

    private String a(String str, File file) {
        String externalStorageState = Environment.getExternalStorageState();
        if (this.i.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && "mounted".equals(externalStorageState)) {
            File file2 = new File(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + this.i.getPackageName() + str);
            if (file2.exists() || file2.mkdirs()) {
                return file2.getPath();
            }
        }
        return file.getPath();
    }

    /* access modifiers changed from: private */
    public void a(final int i2, boolean z2) {
        RectF b2;
        if (this.j) {
            nativeForwardEventsToDalvik(new m((Activity) this.i).a());
        }
        initJni();
        this.m = ((PowerManager) this.i.getSystemService("power")).newWakeLock(26, "DoNotDimScreen");
        new PlayerPrefs(this.h);
        nativeInitWWW(WWW.class);
        if (this.k == null) {
            AnonymousClass17 r0 = new z(this.i, i2, z2, false, this) {
                private /* synthetic */ View a;

                {
                    this.a = r7;
                }

                /* access modifiers changed from: protected */
                public final void init(int i, boolean z, int i2, int i3, int i4, int i5) {
                    if (UnityPlayer.this.z == -1) {
                        int unused = UnityPlayer.this.z = UnityPlayer.this.J.getInt("default_aa", 0);
                    }
                    if (!UnityPlayer.this.A) {
                        boolean unused2 = UnityPlayer.this.A = UnityPlayer.this.canUse32bitDisplayBuffer() ? UnityPlayer.this.J.getBoolean("32bit_display", false) : false;
                    }
                    super.init(i, z, UnityPlayer.this.A ? 32 : 16, UnityPlayer.this.J.getBoolean("24bit_depth", false) ? 24 : 16, 0, UnityPlayer.this.z);
                }

                public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
                    return this.a.onTouchEvent(motionEvent);
                }

                public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                    return this.a.onKeyPreIme(i, keyEvent) || super.onKeyPreIme(i, keyEvent);
                }
            };
            if (n.a) {
                j jVar = n.b;
                r0.setPreserveEGLContextOnPause(true);
            }
            r0.setFocusable(true);
            r0.setFocusableInTouchMode(true);
            this.k = r0;
        }
        this.k.setRenderer(this);
        if (Build.PRODUCT.compareToIgnoreCase("blaze") == 0 && Build.MODEL.toLowerCase().startsWith("kindle")) {
            this.l = new o(this.i);
            this.e.a(this.l);
        }
        this.n = (SensorManager) this.i.getSystemService("sensor");
        this.o = (WindowManager) this.i.getSystemService("window");
        final int i3 = getSettings().getInt("splash_mode");
        this.k.queueEvent(new Runnable() {
            public final void run() {
                UnityPlayer.this.nativeInit(i2, i3);
            }
        });
        nativeSetExtras(this.g);
        if (!(this.d == null || !this.j || (b2 = this.d.b()) == null)) {
            nativeEnableTouchpad(b2.width(), b2.height());
        }
        resume();
        windowFocusChanged(true);
    }

    private void a(Runnable runnable) {
        if (this.i instanceof Activity) {
            ((Activity) this.i).runOnUiThread(runnable);
        } else {
            l.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    private void a(boolean z2) {
        if (this.aa) {
            if (z2) {
                this.n.registerListener(this.B, this.n.getDefaultSensor(4), this.ab);
                this.n.registerListener(this.B, this.n.getDefaultSensor(9), this.ab);
                this.n.registerListener(this.B, this.n.getDefaultSensor(10), this.ab);
                this.n.registerListener(this.B, this.n.getDefaultSensor(11), this.ab);
                return;
            }
            this.n.unregisterListener(this.B, this.n.getDefaultSensor(4));
            this.n.unregisterListener(this.B, this.n.getDefaultSensor(9));
            this.n.unregisterListener(this.B, this.n.getDefaultSensor(10));
            this.n.unregisterListener(this.B, this.n.getDefaultSensor(11));
        }
    }

    private boolean a(int i2, KeyEvent keyEvent) {
        final boolean z2 = false;
        if (!this.t) {
            if (i2 != 4) {
                return true;
            }
            kill();
            return true;
        } else if (isFinishing()) {
            return false;
        } else {
            if (i2 == 25 || i2 == 24) {
                return keyEvent.getAction() == 0 ? super.onKeyDown(i2, keyEvent) : super.onKeyUp(i2, keyEvent);
            }
            final int i3 = (i2 == 4 && keyEvent.getMetaState() == 2) ? 101 : i2;
            final int unicodeChar = keyEvent.getUnicodeChar(keyEvent.getMetaState());
            if (keyEvent.getAction() == 0) {
                z2 = true;
            }
            final int scanCode = keyEvent.getScanCode();
            final int deviceId = keyEvent.getDeviceId();
            queueEvent(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeKeyState(i3, unicodeChar, z2, scanCode, deviceId);
                }
            });
            return true;
        }
    }

    private boolean a(MotionEvent motionEvent) {
        float f2;
        if (this.j) {
            return true;
        }
        int pointerCount = motionEvent.getPointerCount();
        int i2 = 0;
        while (i2 < pointerCount) {
            if (i2 == 0) {
                int action = motionEvent.getAction();
                int i3 = i2 == ((action & 255) >> 8) ? action & 255 : 2;
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                float f3 = this.T;
                float f4 = this.U;
                if (Build.VERSION.SDK_INT >= 12) {
                    try {
                        if (this.V == null) {
                            this.V = motionEvent.getClass().getDeclaredMethod("getAxisValue", new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        f2 = this.V != null ? ((Float) this.V.invoke(motionEvent, new Object[]{9, Integer.valueOf(i2)})).floatValue() : 0.0f;
                    } catch (Exception e2) {
                    }
                    queueEvent(new Runnable(i3, 0, x2, y2, f3, f4, f2) {
                        private /* synthetic */ int a;
                        private /* synthetic */ int b = 0;
                        private /* synthetic */ float c;
                        private /* synthetic */ float d;
                        private /* synthetic */ float e;
                        private /* synthetic */ float f;
                        private /* synthetic */ float g;

                        {
                            this.a = r3;
                            this.c = r5;
                            this.d = r6;
                            this.e = r7;
                            this.f = r8;
                            this.g = r9;
                        }

                        public final void run() {
                            int i;
                            int i2;
                            switch (this.a) {
                                case SystemTools.AR_ERROR_NONE:
                                    i2 = this.b;
                                    i = 0;
                                    break;
                                case 1:
                                    i2 = this.b;
                                    i = 1;
                                    break;
                                case 2:
                                    i = 3;
                                    i2 = 0;
                                    break;
                                case SystemTools.AR_ERROR_OPERATION_CANCELED:
                                    i = 2;
                                    i2 = 0;
                                    break;
                                default:
                                    i2 = 0;
                                    i = 0;
                                    break;
                            }
                            UnityPlayer.this.nativeQueueGUIEvent(i, this.c, this.d, i2);
                            float f2 = this.c;
                            float o = ((float) UnityPlayer.this.w) - this.d;
                            UnityPlayer.this.nativeSetMouseDelta(this.c - this.e, -(this.d - this.f), this.a == 8 ? this.g : 0.0f);
                            UnityPlayer.this.nativeSetMousePosition(f2, o);
                            if (this.a == 0) {
                                UnityPlayer.this.nativeSetMouseButton(0, true);
                            } else if (this.a == 1) {
                                UnityPlayer.this.nativeSetMouseButton(0, false);
                            }
                        }
                    });
                    this.T = x2;
                    this.U = y2;
                }
                f2 = 0.0f;
                queueEvent(new Runnable(i3, 0, x2, y2, f3, f4, f2) {
                    private /* synthetic */ int a;
                    private /* synthetic */ int b = 0;
                    private /* synthetic */ float c;
                    private /* synthetic */ float d;
                    private /* synthetic */ float e;
                    private /* synthetic */ float f;
                    private /* synthetic */ float g;

                    {
                        this.a = r3;
                        this.c = r5;
                        this.d = r6;
                        this.e = r7;
                        this.f = r8;
                        this.g = r9;
                    }

                    public final void run() {
                        int i;
                        int i2;
                        switch (this.a) {
                            case SystemTools.AR_ERROR_NONE:
                                i2 = this.b;
                                i = 0;
                                break;
                            case 1:
                                i2 = this.b;
                                i = 1;
                                break;
                            case 2:
                                i = 3;
                                i2 = 0;
                                break;
                            case SystemTools.AR_ERROR_OPERATION_CANCELED:
                                i = 2;
                                i2 = 0;
                                break;
                            default:
                                i2 = 0;
                                i = 0;
                                break;
                        }
                        UnityPlayer.this.nativeQueueGUIEvent(i, this.c, this.d, i2);
                        float f2 = this.c;
                        float o = ((float) UnityPlayer.this.w) - this.d;
                        UnityPlayer.this.nativeSetMouseDelta(this.c - this.e, -(this.d - this.f), this.a == 8 ? this.g : 0.0f);
                        UnityPlayer.this.nativeSetMousePosition(f2, o);
                        if (this.a == 0) {
                            UnityPlayer.this.nativeSetMouseButton(0, true);
                        } else if (this.a == 1) {
                            UnityPlayer.this.nativeSetMouseButton(0, false);
                        }
                    }
                });
                this.T = x2;
                this.U = y2;
            }
            i2++;
        }
        return true;
    }

    private void b() {
        try {
            InputStream open = this.i.getAssets().open("bin/Data/settings.xml");
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(open, (String) null);
            String str = null;
            String str2 = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    str2 = newPullParser.getName();
                    String str3 = str;
                    for (int i2 = 0; i2 < newPullParser.getAttributeCount(); i2++) {
                        if (newPullParser.getAttributeName(i2).equalsIgnoreCase("name")) {
                            str3 = newPullParser.getAttributeValue(i2);
                        }
                    }
                    str = str3;
                } else if (eventType == 3) {
                    str2 = null;
                } else if (eventType == 4 && str != null) {
                    if (str2.equalsIgnoreCase("integer")) {
                        this.J.putInt(str, Integer.parseInt(newPullParser.getText()));
                    } else if (str2.equalsIgnoreCase("string")) {
                        this.J.putString(str, newPullParser.getText());
                    } else if (str2.equalsIgnoreCase("bool")) {
                        this.J.putBoolean(str, Boolean.parseBoolean(newPullParser.getText()));
                    } else if (str2.equalsIgnoreCase("float")) {
                        this.J.putFloat(str, Float.parseFloat(newPullParser.getText()));
                    }
                    str = null;
                }
            }
        } catch (Exception e2) {
            l.Log(6, "Unable to locate player settings. " + e2.getLocalizedMessage());
            c();
        }
    }

    private void b(boolean z2) {
        if (this.ac) {
            if (z2) {
                this.n.registerListener(this.B, this.n.getDefaultSensor(2), 1);
            } else {
                this.n.unregisterListener(this.B, this.n.getDefaultSensor(2));
            }
        }
    }

    private boolean b(final MotionEvent motionEvent) {
        if (!this.j && Build.VERSION.SDK_INT >= 12) {
            if (this.V == null) {
                try {
                    this.V = motionEvent.getClass().getDeclaredMethod("getAxisValue", new Class[]{Integer.TYPE, Integer.TYPE});
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            queueEvent(new Runnable() {
                public final void run() {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i = 0; i < pointerCount; i++) {
                        Integer[] b2 = UnityPlayer.b(UnityPlayer.this, motionEvent.getDeviceId());
                        if (b2 != null) {
                            int intValue = b2[0].intValue() + 1;
                            for (int i2 = 1; i2 < b2.length; i2++) {
                                try {
                                    UnityPlayer.this.nativeSetJoystickPosition(intValue, i2 - 1, ((Float) UnityPlayer.this.V.invoke(motionEvent, new Object[]{b2[i2], Integer.valueOf(i)})).floatValue());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            });
        }
        return true;
    }

    static /* synthetic */ Integer[] b(UnityPlayer unityPlayer, int i2) {
        if (unityPlayer.W == null) {
            unityPlayer.getConnectedJoysticks();
        }
        Integer[] numArr = (Integer[]) unityPlayer.W.get(Integer.valueOf(i2));
        if (numArr != null) {
            return numArr;
        }
        unityPlayer.getConnectedJoysticks();
        Integer[] numArr2 = (Integer[]) unityPlayer.W.get(Integer.valueOf(i2));
        if (numArr2 == null) {
            return null;
        }
        return numArr2;
    }

    /* access modifiers changed from: private */
    public void c() {
        if ((this.i instanceof Activity) && !((Activity) this.i).isFinishing()) {
            ((Activity) this.i).finish();
        }
    }

    private void d() {
        if (this.N && !this.L && !this.M) {
            this.M = true;
            if ((!this.f ? indexOfChild((View) this.k) == -1 : true) && (this.k instanceof z)) {
                this.e.d((View) this.k);
            }
            if (this.t) {
                this.k.queueEvent(new Runnable() {
                    public final void run() {
                        UnityPlayer.this.nativeResume();
                    }
                });
            }
            if (s && this.p == null) {
                this.p = new FMODAudioDevice();
            }
            if (this.p != null && !this.p.isRunning()) {
                this.p.start();
            }
        }
    }

    static /* synthetic */ void f(UnityPlayer unityPlayer) {
        if (unityPlayer.l != null) {
            unityPlayer.l.a(unityPlayer.v, unityPlayer.w);
        }
    }

    private final native void initJni();

    /* access modifiers changed from: private */
    public final native int nativeActivityIndicatorStyle();

    /* access modifiers changed from: private */
    public final native void nativeDone();

    private final native void nativeEnableTouchpad(float f2, float f3);

    private final native void nativeFile(String str);

    /* access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z2);

    private final native String nativeGetGLContext();

    private final native String nativeGetGLScreen();

    private final native int nativeGetLicensePolicy();

    /* access modifiers changed from: private */
    public final native void nativeInit(int i2, int i3);

    private final native void nativeInitWWW(Class cls);

    private final native boolean nativeIsAutorotationOn();

    private final native void nativeJoyButtonState(int i2, int i3, boolean z2);

    /* access modifiers changed from: private */
    public final native void nativeKeyState(int i2, int i3, boolean z2, int i4, int i5);

    /* access modifiers changed from: private */
    public final native boolean nativePause();

    /* access modifiers changed from: private */
    public final native void nativeQueueGUIEvent(int i2, float f2, float f3, int i3);

    private final native void nativeRecreateGfxState();

    private final native boolean nativeRender();

    private final native boolean nativeRequested32bitDisplayBuffer();

    private final native int nativeRequestedAA();

    private final native void nativeResize(int i2, int i3, int i4, int i5);

    /* access modifiers changed from: private */
    public final native void nativeResume();

    private final native void nativeSetExtras(Bundle bundle);

    /* access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* access modifiers changed from: private */
    public final native void nativeSetJoystickPosition(int i2, int i3, float f2);

    /* access modifiers changed from: private */
    public final native void nativeSetMouseButton(int i2, boolean z2);

    /* access modifiers changed from: private */
    public final native void nativeSetMouseDelta(float f2, float f3, float f4);

    /* access modifiers changed from: private */
    public final native void nativeSetMousePosition(float f2, float f3);

    private final native void nativeSetTouchDeltaY(float f2);

    /* access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    /* access modifiers changed from: private */
    public final native void nativeTouch(int i2, float f2, float f3, int i3, long j2, int i4);

    /* access modifiers changed from: private */
    public final native void nativeVideoFrameCallback(int i2, byte[] bArr, int i3, int i4);

    private final native void unityAndroidInit(String str, String str2);

    private final native void unityAndroidPrepareGameLoop();

    /* access modifiers changed from: protected */
    public boolean Location_IsServiceEnabledByUser() {
        return this.B.a();
    }

    /* access modifiers changed from: protected */
    public void Location_SetDesiredAccuracy(float f2) {
        this.B.b(f2);
    }

    /* access modifiers changed from: protected */
    public void Location_SetDistanceFilter(float f2) {
        this.B.a(f2);
    }

    /* access modifiers changed from: protected */
    public void Location_StartUpdatingLocation() {
        this.B.b();
    }

    /* access modifiers changed from: protected */
    public void Location_StopUpdatingLocation() {
        this.B.c();
    }

    /* access modifiers changed from: protected */
    public boolean canUse32bitDisplayBuffer() {
        return z.b();
    }

    /* access modifiers changed from: protected */
    public void closeCamera(int i2) {
        for (a aVar : this.K) {
            if (aVar.c() == i2) {
                aVar.d();
                this.K.remove(aVar);
                return;
            }
        }
    }

    public void configurationChanged(Configuration configuration) {
        if (this.k instanceof SurfaceView) {
            ((SurfaceView) this.k).getHolder().setSizeFromLayout();
        }
        if (this.c && configuration.hardKeyboardHidden == 2) {
            ((InputMethodManager) this.i.getSystemService("input_method")).toggleSoftInput(0, 1);
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchTouchEvent(int i2, int i3, int i4, float f2, float f3, long j2, int i5) {
        if (this.t && !this.j) {
            final int i6 = i3 & 255;
            if (i2 != ((65280 & i3) >> 8)) {
                i6 = 2;
            }
            final int i7 = i4;
            final float f4 = f2;
            final float f5 = f3;
            final long j3 = j2;
            final int i8 = i5;
            queueEvent(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeTouch(i7, f4, f5, i6, j3, i8);
                }
            });
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void forwardMotionEventToDalvik(long j2, long j3, int i2, int i3, int[] iArr, float[] fArr, int i4, float f2, float f3, int i5, int i6, int i7, int i8, int i9, long[] jArr, float[] fArr2) {
        if (this.d != null) {
            this.d.a(j2, j3, i2, i3, iArr, fArr, i4, f2, f3, i5, i6, i7, i8, i9, jArr, fArr2);
        }
    }

    /* access modifiers changed from: protected */
    public String getCPUType() {
        return S.b();
    }

    /* access modifiers changed from: protected */
    public String getCacheDir() {
        return a("/cache", this.i.getCacheDir());
    }

    /* access modifiers changed from: protected */
    public int[] getConnectedJoysticks() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.view.InputDevice");
            int[] iArr = (int[]) cls.getDeclaredMethod("getDeviceIds", new Class[0]).invoke(cls, new Object[0]);
            Arrays.sort(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < iArr.length) {
                Object invoke = cls.getMethod("getDevice", new Class[]{Integer.TYPE}).invoke(cls, new Object[]{Integer.valueOf(iArr[i4])});
                if (invoke == null) {
                    iArr[i4] = -1;
                    i3 = i5;
                } else if ((((Integer) invoke.getClass().getMethod("getSources", new Class[0]).invoke(invoke, new Object[0])).intValue() & 16777232) == 16777232) {
                    i3 = i5 + 1;
                } else {
                    iArr[i4] = -1;
                    i3 = i5;
                }
                i4++;
                i5 = i3;
            }
            int[] iArr2 = new int[i5];
            int i6 = 0;
            int i7 = 0;
            while (i6 < iArr.length) {
                if (iArr[i6] != -1) {
                    i2 = i7 + 1;
                    iArr2[i7] = iArr[i6];
                } else {
                    i2 = i7;
                }
                i6++;
                i7 = i2;
            }
            this.W = new LinkedHashMap();
            int i8 = 0;
            for (int i9 : iArr2) {
                int[] joystickAxes = getJoystickAxes(i9);
                if (joystickAxes != null) {
                    Integer[] numArr = new Integer[(joystickAxes.length + 1)];
                    int i10 = i8 + 1;
                    numArr[0] = Integer.valueOf(i8);
                    for (int i11 = 0; i11 < joystickAxes.length; i11++) {
                        numArr[i11 + 1] = Integer.valueOf(joystickAxes[i11]);
                    }
                    this.W.put(Integer.valueOf(i9), numArr);
                    i8 = i10;
                }
            }
            return iArr2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public int getDeviceOrientation() {
        int i2 = 9;
        int orientation = this.o.getDefaultDisplay().getOrientation();
        boolean z2 = getResources().getConfiguration().orientation == 2;
        int i3 = Build.VERSION.SDK_INT >= 9 ? 8 : 0;
        if (Build.VERSION.SDK_INT < 9) {
            i2 = 1;
        }
        if (orientation == 0) {
            return z2 ? 0 : 1;
        }
        if (orientation == 1) {
            if (z2) {
                return 0;
            }
            return i2;
        } else if (orientation == 2) {
            return z2 ? i3 : i2;
        } else {
            if (orientation != 3 || !z2) {
                return 1;
            }
            return i2;
        }
    }

    /* access modifiers changed from: protected */
    public String getDeviceUniqueIdentifier() {
        try {
            if (this.D == null) {
                this.D = ((TelephonyManager) this.i.getSystemService("phone")).getDeviceId();
            }
            String str = this.D;
            if (!(str == null || str.length() == 0)) {
                return str;
            }
        } catch (Exception e2) {
            l.Log(5, "android.permission.READ_PHONE_STATE not available?");
        }
        return Settings.Secure.getString(this.i.getContentResolver(), "android_id");
    }

    /* access modifiers changed from: protected */
    public String getFilesDir() {
        return a("/files", this.i.getFilesDir());
    }

    /* access modifiers changed from: protected */
    public int getGyroUpdateDelay() {
        return this.ab;
    }

    /* access modifiers changed from: protected */
    public int getInternetReachability() {
        try {
            if (this.E == null) {
                this.E = ((ConnectivityManager) this.i.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            NetworkInfo networkInfo = this.E;
            if (networkInfo == null) {
                return 0;
            }
            if (!networkInfo.isConnected()) {
                return 0;
            }
            return networkInfo.getType() + 1;
        } catch (Exception e2) {
            l.Log(5, "android.permission.ACCESS_NETWORK_STATE not available?");
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public boolean getIsGyroAvailable() {
        return this.i.getPackageManager().hasSystemFeature("android.hardware.sensor.gyroscope");
    }

    /* access modifiers changed from: protected */
    public boolean getIsGyroEnabled() {
        return this.aa;
    }

    /* access modifiers changed from: protected */
    public int[] getJoystickAxes(int i2) {
        int[] iArr;
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.view.InputDevice");
            Object invoke = cls.getMethod("getDevice", new Class[]{Integer.TYPE}).invoke(cls, new Object[]{Integer.valueOf(i2)});
            if (invoke != null) {
                List list = (List) invoke.getClass().getMethod("getMotionRanges", new Class[0]).invoke(invoke, new Object[0]);
                int[] iArr2 = new int[list.size()];
                int i3 = 0;
                for (Object next : list) {
                    if ((((Integer) next.getClass().getMethod("getSource", new Class[0]).invoke(next, new Object[0])).intValue() & 16777232) == 16777232) {
                        iArr2[i3] = ((Integer) next.getClass().getMethod("getAxis", new Class[0]).invoke(next, new Object[0])).intValue();
                        i3++;
                    }
                }
                iArr = new int[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    iArr[i4] = iArr2[i4];
                }
                Arrays.sort(iArr);
            } else {
                iArr = null;
            }
            return iArr;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String getJoystickName(int i2) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.view.InputDevice");
            Object invoke = cls.getMethod("getDevice", new Class[]{Integer.TYPE}).invoke(cls, new Object[]{Integer.valueOf(i2)});
            return invoke != null ? (String) invoke.getClass().getMethod("getName", new Class[0]).invoke(invoke, new Object[0]) : null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public int getNumCameras() {
        if (this.d != null) {
            return this.d.a();
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public int getOrientation() {
        if (!(this.i instanceof Activity)) {
            return 1;
        }
        return ((Activity) this.i).getRequestedOrientation();
    }

    /* access modifiers changed from: protected */
    public String getPackageName() {
        return this.i.getPackageName();
    }

    /* access modifiers changed from: protected */
    public float getScreenDPI() {
        if (!(this.i instanceof Activity)) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.i).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (displayMetrics.xdpi + displayMetrics.ydpi) * 0.5f;
    }

    /* access modifiers changed from: protected */
    public int getScreenTimeout() {
        return Settings.System.getInt(this.i.getContentResolver(), "screen_off_timeout", 15000) / 1000;
    }

    public Bundle getSettings() {
        return this.J;
    }

    /* access modifiers changed from: protected */
    public int getTotalMemory() {
        return S.c();
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean hasWakeLock() {
        return this.m.isHeld();
    }

    /* access modifiers changed from: protected */
    public void hideSoftInput() {
        a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.c) {
                    ((InputMethodManager) UnityPlayer.this.i.getSystemService("input_method")).toggleSoftInput(1, 0);
                    boolean unused = UnityPlayer.this.c = false;
                } else if (UnityPlayer.this.a != null) {
                    UnityPlayer.this.a.dismiss();
                    UnityPlayer.this.a = null;
                }
            }
        });
    }

    public void init(final int i2, final boolean z2) {
        if (!r) {
            AlertDialog create = new AlertDialog.Builder(this.i).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.c();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            create.setCancelable(false);
            create.show();
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("samsung") || Build.VERSION.SDK_INT >= 8 || (S.a() & 16) == 0) {
            a(i2, z2);
        } else {
            r = false;
            AlertDialog create2 = new AlertDialog.Builder(this.i).setTitle("Old Android OS detected!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    boolean unused = UnityPlayer.r = true;
                    UnityPlayer.this.a(i2, z2);
                }
            }).setMessage("This application requires at least Android OS version 2.2 on Samsung devices. Your device seems to be running an older OS version.\nPlease contact your carrier or the hardware vendor and ask them how to install a more recent version. It is a simple process that your provider's customer service can help you with.").create();
            create2.setCancelable(false);
            create2.show();
        }
    }

    /* access modifiers changed from: protected */
    public int[] initCamera(int i2, int i3, int i4, int i5) {
        a aVar = new a(i2, i3, i4, i5);
        try {
            aVar.a((a.C0004a) this);
            this.K.add(aVar);
            return new int[]{aVar.a(), aVar.b()};
        } catch (Exception e2) {
            aVar.d();
            l.Log(6, "Camera failed to open: " + e2.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isCameraFrontFacing(int i2) {
        if (this.d != null) {
            return this.d.a(i2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isCompassAvailable() {
        return this.i.getPackageManager().hasSystemFeature("android.hardware.sensor.compass");
    }

    /* access modifiers changed from: protected */
    public boolean isCompassEnabled() {
        return this.ac;
    }

    /* access modifiers changed from: protected */
    public boolean isFinishing() {
        return (this.i instanceof Activity) && ((Activity) this.i).isFinishing();
    }

    /* access modifiers changed from: protected */
    public void kill() {
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: protected */
    public boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e2) {
            l.Log(6, "Unable to find " + str);
            return false;
        } catch (Exception e3) {
            l.Log(6, "Unknown error " + e3);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final native void nativeAttitude(float f2, float f3, float f4, float f5, long j2);

    /* access modifiers changed from: package-private */
    public final native void nativeCompass(float f2, float f3, float f4, float f5, float f6, double d2);

    /* access modifiers changed from: package-private */
    public final native void nativeDeviceOrientation(int i2);

    /* access modifiers changed from: package-private */
    public final native void nativeForwardEventsToDalvik(boolean z2);

    /* access modifiers changed from: package-private */
    public final native void nativeGravity(float f2, float f3, float f4, long j2);

    /* access modifiers changed from: package-private */
    public final native void nativeGyro(float f2, float f3, float f4, long j2);

    /* access modifiers changed from: package-private */
    public final native void nativeJoystickRemoved();

    /* access modifiers changed from: package-private */
    public final native void nativeLinearAcc(float f2, float f3, float f4, long j2);

    /* access modifiers changed from: package-private */
    public final native void nativeSensor(float f2, float f3, float f4, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetLocation(float f2, float f3, float f4, float f5, double d2);

    /* access modifiers changed from: protected */
    public native void nativeSetLocationStatus(int i2);

    public void onCameraFrame(a aVar, byte[] bArr) {
        if (!isFinishing()) {
            final int a2 = aVar.a();
            final int b2 = aVar.b();
            final int c2 = aVar.c();
            final byte[] bArr2 = bArr;
            final a aVar2 = aVar;
            queueEvent(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeVideoFrameCallback(c2, bArr2, a2, b2);
                    aVar2.a(bArr2);
                }
            });
        }
    }

    public void onDrawFrame(GL10 gl10) {
        String nativeGetGLContext;
        boolean z2 = false;
        boolean z3 = true;
        if (!isFinishing()) {
            if (!this.I && this.F == null && (nativeGetGLContext = nativeGetGLContext()) != null) {
                try {
                    this.F = new e(this.i, new i(this.i, new com.unity3d.player.a.a(new String("android.opengl.GLSurfaceView$GLWrapper").getBytes(), this.i.getPackageName(), nativeGetGLScreen())), nativeGetGLContext);
                    this.F.a((f) new f() {
                        public final void a() {
                            boolean unused = UnityPlayer.this.G = true;
                            boolean unused2 = UnityPlayer.this.H = true;
                        }

                        public final void b() {
                            boolean unused = UnityPlayer.this.G = false;
                            boolean unused2 = UnityPlayer.this.H = true;
                        }
                    });
                } catch (Exception e2) {
                    this.I = true;
                }
            }
            if (!nativeRender()) {
                c();
                return;
            }
            this.C++;
            if (!this.t) {
                if (this.u) {
                    this.u = false;
                    return;
                }
                unityAndroidInit("assets/bin/", this.i.getApplicationInfo().dataDir + "/lib");
                unityAndroidPrepareGameLoop();
                this.t = true;
                nativeResize(this.v, this.w, this.v, this.w);
                nativeResume();
                windowFocusChanged(true);
            }
            if (this.k instanceof z) {
                boolean nativeRequested32bitDisplayBuffer = canUse32bitDisplayBuffer() ? nativeRequested32bitDisplayBuffer() : false;
                int nativeRequestedAA = nativeRequestedAA();
                if (this.z != nativeRequestedAA) {
                    this.z = nativeRequestedAA;
                    ((z) this.k).a(this.z);
                    z2 = true;
                }
                if (this.A != nativeRequested32bitDisplayBuffer) {
                    this.A = nativeRequested32bitDisplayBuffer;
                    ((z) this.k).a(this.A);
                } else {
                    z3 = z2;
                }
                if (z3) {
                    a(this.O);
                }
            }
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent);
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        return (!this.c || i2 != 4) ? super.onKeyPreIme(i2, keyEvent) : a(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public boolean onNativeKey(long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        return a(i3, new KeyEvent(j2, j3, i2, i3, i4, i5, i6, i7, i8));
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        int i4;
        int i5;
        if ((this.k instanceof SurfaceView) && !((this.x == 0 && this.y == 0) || (this.x == i2 && this.y == i3))) {
            setScreenSize(this.x, this.y);
        }
        if (this.k instanceof View) {
            i5 = ((View) this.k).getWidth();
            i4 = ((View) this.k).getHeight();
        } else {
            i4 = i3;
            i5 = i2;
        }
        this.v = i2;
        this.w = i3;
        nativeResize(i2, i3, i5, i4);
        if (this.i instanceof Activity) {
            float f2 = 0.0f;
            if (!getSettings().getBoolean("hide_status_bar", true)) {
                Rect rect = new Rect();
                ((Activity) this.i).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                f2 = (float) rect.top;
            }
            nativeSetTouchDeltaY(f2);
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        nativeRecreateGfxState();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.t) {
            return true;
        }
        if (this.j) {
            return true;
        }
        int a2 = this.d != null ? this.d.a(motionEvent) : 4098;
        if (a2 == 8194) {
            return a(motionEvent);
        }
        if (a2 == 16777232) {
            return b(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            int historySize = motionEvent.getHistorySize();
            for (int i3 = 0; i3 < historySize; i3++) {
                dispatchTouchEvent(i2, 2, pointerId, motionEvent.getHistoricalX(i2, i3), motionEvent.getHistoricalY(i2, i3), motionEvent.getHistoricalEventTime(i3), a2);
            }
            dispatchTouchEvent(i2, motionEvent.getAction(), pointerId, motionEvent.getX(i2), motionEvent.getY(i2), motionEvent.getEventTime(), a2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void openURL(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri parse = Uri.parse(str);
        intent.setData(parse);
        if (parse.isRelative()) {
            intent.setDataAndType(Uri.fromFile(new File(str)), MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)));
        }
        this.i.startActivity(intent);
    }

    public void pause() {
        if (!this.L && r) {
            this.L = true;
            this.M = false;
            for (a d2 : this.K) {
                d2.d();
            }
            if (this.p != null) {
                this.p.stop();
            }
            if (this.t) {
                final Semaphore semaphore = new Semaphore(0);
                if (isFinishing()) {
                    this.k.queueEvent(new Runnable() {
                        public final void run() {
                            UnityPlayer.this.nativeDone();
                            semaphore.release();
                        }
                    });
                } else {
                    this.k.queueEvent(new Runnable() {
                        public final void run() {
                            UnityPlayer.f(UnityPlayer.this);
                            if (UnityPlayer.this.nativePause()) {
                                UnityPlayer.this.nativeDone();
                                semaphore.release(2);
                                return;
                            }
                            semaphore.release();
                        }
                    });
                }
                try {
                    semaphore.tryAcquire(10, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                }
                if (semaphore.drainPermits() > 0) {
                    quit();
                }
            }
            this.i.unregisterReceiver(this.Z);
            if (this.f && (this.k instanceof z)) {
                if (this.l != null) {
                    this.l.a();
                }
                this.e.e((View) this.k);
            }
            this.k.onPause();
            setWakeLock(false);
            a(false);
            b(false);
            this.n.unregisterListener(this.B);
            this.B.d();
        }
    }

    /* access modifiers changed from: protected */
    public void queueEvent(final Runnable runnable) {
        if (this.t && !isFinishing()) {
            this.k.queueEvent(new Runnable() {
                public final void run() {
                    if (!UnityPlayer.this.isFinishing()) {
                        runnable.run();
                    }
                }
            });
        }
    }

    public void quit() {
        if (r) {
            removeAllViews();
            this.k.a();
        }
        if (this.F != null) {
            this.F.a();
        }
        this.F = null;
        kill();
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputStr(final String str, final int i2) {
        if (i2 == 1) {
            hideSoftInput();
        }
        queueEvent(new Runnable() {
            public final void run() {
                if (str != null) {
                    UnityPlayer.this.nativeSetInputString(str);
                }
                if (i2 == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    public void resume() {
        if (this.L && r) {
            this.L = false;
            for (a a2 : this.K) {
                try {
                    a2.a((a.C0004a) this);
                } catch (Exception e2) {
                    l.Log(6, "Camera failed to open: " + e2.getMessage());
                }
            }
            this.k.onResume();
            this.i.registerReceiver(this.Z, new IntentFilter("android.hardware.usb.action.USB_DEVICE_DETACHED"));
            this.n.registerListener(this.B, this.n.getDefaultSensor(1), 1);
            a(true);
            b(true);
            d();
            this.B.e();
            this.D = null;
            this.E = null;
        }
    }

    /* access modifiers changed from: protected */
    public void setCompassEnabled(boolean z2) {
        boolean z3 = false;
        if (this.ac != z2) {
            if (z2) {
                if (z2 && isCompassAvailable()) {
                    z3 = true;
                }
                this.ac = z3;
                b(true);
                return;
            }
            b(false);
            this.ac = z2;
            queueEvent(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeCompass(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0d);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void setGyroEnabled(boolean z2) {
        boolean z3 = false;
        if (this.aa != z2) {
            if (z2) {
                if (z2 && getIsGyroAvailable()) {
                    z3 = true;
                }
                this.aa = z3;
                a(true);
                return;
            }
            a(false);
            this.aa = z2;
            queueEvent(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeGyro(0.0f, 0.0f, 0.0f, -1);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void setGyroUpdateDelay(int i2) {
        this.ab = i2;
    }

    /* access modifiers changed from: protected */
    public void setHideInputField(boolean z2) {
        this.b = z2;
    }

    /* access modifiers changed from: protected */
    public void setOrientation(int i2) {
        if (this.i instanceof Activity) {
            Activity activity = (Activity) this.i;
            if (i2 == activity.getRequestedOrientation()) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 9 || !(i2 == 9 || i2 == 8)) {
                activity.setRequestedOrientation(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setScreenSize(final int i2, final int i3) {
        if (!(this.k instanceof SurfaceView)) {
            l.Log(5, "setScreenSize: Unable to retrieve surface holder");
            return;
        }
        final SurfaceView surfaceView = (SurfaceView) this.k;
        surfaceView.getHolder().getSurfaceFrame();
        final boolean z2 = (surfaceView.getWidth() == i2 && surfaceView.getHeight() == i3) || (i2 == -1 && i3 == -1);
        if (z2) {
            this.x = 0;
            this.y = 0;
        } else {
            this.x = i2;
            this.y = i3;
        }
        a((Runnable) new Runnable() {
            public final void run() {
                if (z2) {
                    surfaceView.getHolder().setSizeFromLayout();
                } else {
                    surfaceView.getHolder().setFixedSize(i2, i3);
                }
                surfaceView.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setWakeLock(boolean z2) {
        if (z2 != hasWakeLock()) {
            if (z2) {
                this.m.acquire();
            } else if (!z2) {
                this.m.release();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean showBuildSetup() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public boolean showRuntimeSetup() {
        return this.H;
    }

    /* access modifiers changed from: protected */
    public void showSoftInput(String str, int i2, boolean z2, boolean z3, boolean z4, boolean z5, String str2) {
        final String str3 = str;
        final int i3 = i2;
        final boolean z6 = z2;
        final boolean z7 = z3;
        final boolean z8 = z4;
        final boolean z9 = z5;
        final String str4 = str2;
        a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.b) {
                    ((InputMethodManager) this.i.getSystemService("input_method")).toggleSoftInput(0, 1);
                    boolean unused = UnityPlayer.this.c = true;
                    return;
                }
                UnityPlayer unityPlayer = UnityPlayer.this;
                ContextWrapper n = UnityPlayer.this.i;
                UnityPlayer unityPlayer2 = this;
                String str = str3;
                int i2 = i3;
                boolean z = z6;
                boolean z2 = z7;
                boolean z3 = z8;
                boolean z4 = z9;
                unityPlayer.a = new x(n, unityPlayer2, str, i2, z, z2, z3, str4);
                UnityPlayer.this.a.show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showVideoPlayer(String str, int i2, int i3, int i4, boolean z2) {
        final Intent intent = new Intent(this.i, VideoPlayer.class);
        intent.putExtra("fileName", str);
        intent.putExtra("backgroundColor", i2);
        intent.putExtra("controlMode", i3);
        intent.putExtra("scalingMode", i4);
        intent.putExtra("isURL", z2);
        if (this.i instanceof Activity) {
            intent.putExtra("screenOrientation", ((Activity) this.i).getRequestedOrientation());
            intent.putExtra("autorotationOn", nativeIsAutorotationOn());
        } else {
            intent.putExtra("screenOrientation", 1);
            intent.putExtra("autorotationOn", false);
        }
        intent.putExtra("wakeLock", hasWakeLock());
        intent.addFlags(65536);
        a((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer.this.i.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void startActivityIndicator() {
        a(this.Q);
    }

    /* access modifiers changed from: protected */
    public void stopActivityIndicator() {
        a(this.R);
    }

    /* access modifiers changed from: protected */
    public void vibrate(int i2) {
        if (this.q == null) {
            this.q = (Vibrator) this.i.getSystemService("vibrator");
        }
        if (i2 == 0) {
            try {
                this.q.cancel();
            } catch (Exception e2) {
                l.Log(5, "android.permission.VIBRATE not available?");
            }
        } else {
            this.q.vibrate((long) i2);
        }
    }

    public void windowFocusChanged(boolean z2) {
        this.N = z2;
        if (this.N && this.a != null) {
            reportSoftInputStr(this.a.a(), 1);
        }
        if (this.t) {
            this.k.queueEvent(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeFocusChanged(UnityPlayer.this.N);
                }
            });
        }
        d();
    }
}
