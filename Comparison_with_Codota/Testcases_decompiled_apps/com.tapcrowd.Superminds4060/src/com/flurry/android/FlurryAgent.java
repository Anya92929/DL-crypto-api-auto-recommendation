package com.flurry.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.p000v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.radiusnetworks.ibeacon.IBeaconManager;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.security.DigestOutputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class FlurryAgent implements LocationListener {

    /* renamed from: a */
    static String f18a;

    /* renamed from: b */
    private static final String[] f19b = {"9774d56d682e549c", "dead00beef"};

    /* renamed from: c */
    private static volatile String f20c = null;

    /* renamed from: d */
    private static volatile String f21d = null;

    /* renamed from: e */
    private static volatile String f22e = "http://ad.flurry.com/getCanvas.do";

    /* renamed from: f */
    private static volatile String f23f = null;

    /* renamed from: g */
    private static volatile String f24g = "http://ad.flurry.com/getAndroidApp.do";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final FlurryAgent f25h = new FlurryAgent();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static long f26i = IBeaconManager.DEFAULT_BACKGROUND_SCAN_PERIOD;

    /* renamed from: j */
    private static boolean f27j = true;

    /* renamed from: k */
    private static boolean f28k = false;
    private static volatile String kInsecureReportUrl = "http://data.flurry.com/aap.do";
    private static volatile String kSecureReportUrl = "https://data.flurry.com/aap.do";

    /* renamed from: l */
    private static boolean f29l = false;

    /* renamed from: m */
    private static boolean f30m = true;

    /* renamed from: n */
    private static Criteria f31n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static boolean f32o = false;

    /* renamed from: p */
    private static AppCircle f33p = new AppCircle();

    /* renamed from: q */
    private static AtomicInteger f34q = new AtomicInteger(0);

    /* renamed from: r */
    private static AtomicInteger f35r = new AtomicInteger(0);

    /* renamed from: A */
    private String f36A;

    /* renamed from: B */
    private String f37B;

    /* renamed from: C */
    private boolean f38C = true;

    /* renamed from: D */
    private List f39D;

    /* renamed from: E */
    private LocationManager f40E;

    /* renamed from: F */
    private String f41F;

    /* renamed from: G */
    private boolean f42G;

    /* renamed from: H */
    private long f43H;

    /* renamed from: I */
    private byte[] f44I;

    /* renamed from: J */
    private List f45J = new ArrayList();

    /* renamed from: K */
    private long f46K;

    /* renamed from: L */
    private long f47L;

    /* renamed from: M */
    private long f48M;

    /* renamed from: N */
    private String f49N = "";

    /* renamed from: O */
    private String f50O = "";

    /* renamed from: P */
    private byte f51P = -1;

    /* renamed from: Q */
    private String f52Q = "";

    /* renamed from: R */
    private byte f53R = -1;

    /* renamed from: S */
    private Long f54S;

    /* renamed from: T */
    private int f55T;

    /* renamed from: U */
    private Location f56U;

    /* renamed from: V */
    private Map f57V = new HashMap();

    /* renamed from: W */
    private List f58W = new ArrayList();

    /* renamed from: X */
    private boolean f59X;

    /* renamed from: Y */
    private int f60Y;

    /* renamed from: Z */
    private List f61Z = new ArrayList();

    /* renamed from: aa */
    private int f62aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public C0120v f63ab = new C0120v();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Handler f64s;

    /* renamed from: t */
    private File f65t;

    /* renamed from: u */
    private File f66u = null;

    /* renamed from: v */
    private volatile boolean f67v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public volatile boolean f68w = false;

    /* renamed from: x */
    private long f69x;

    /* renamed from: y */
    private Map f70y = new WeakHashMap();

    /* renamed from: z */
    private String f71z;

    /* renamed from: a */
    static /* synthetic */ void m17a(FlurryAgent flurryAgent, Context context, boolean z) {
        Location location = null;
        if (z) {
            try {
                location = flurryAgent.m43d(context);
            } catch (Throwable th) {
                C0095ai.m102b("FlurryAgent", "", th);
                return;
            }
        }
        synchronized (flurryAgent) {
            flurryAgent.f56U = location;
        }
        if (f32o) {
            flurryAgent.f63ab.mo3353b();
        }
        flurryAgent.f44I = m49e(context);
        C0095ai.m104c("FlurryAgent", "Fetching IMEI: " + flurryAgent.f44I);
        flurryAgent.m42c(true);
    }

    /* renamed from: b */
    static /* synthetic */ void m34b(FlurryAgent flurryAgent, Context context) {
        boolean z = false;
        try {
            synchronized (flurryAgent) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - flurryAgent.f69x;
                if (!flurryAgent.f67v && elapsedRealtime > f26i && flurryAgent.f45J.size() > 0) {
                    z = true;
                }
            }
            if (z) {
                flurryAgent.m42c(false);
            }
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
    }

    public class FlurryDefaultExceptionHandler implements Thread.UncaughtExceptionHandler {

        /* renamed from: a */
        private Thread.UncaughtExceptionHandler f72a = Thread.getDefaultUncaughtExceptionHandler();

        FlurryDefaultExceptionHandler() {
        }

        public void uncaughtException(Thread thread, Throwable th) {
            try {
                FlurryAgent.f25h.mo3266a(th);
            } catch (Throwable th2) {
                C0095ai.m102b("FlurryAgent", "", th2);
            }
            if (this.f72a != null) {
                this.f72a.uncaughtException(thread, th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3266a(Throwable th) {
        th.printStackTrace();
        String str = "";
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            StackTraceElement stackTraceElement = stackTrace[0];
            StringBuilder sb = new StringBuilder();
            sb.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append(":").append(stackTraceElement.getLineNumber());
            if (th.getMessage() != null) {
                sb.append(" (" + th.getMessage() + ")");
            }
            str = sb.toString();
        } else if (th.getMessage() != null) {
            str = th.getMessage();
        }
        onError("uncaught", str, th.getClass().toString());
        this.f70y.clear();
        m14a((Context) null, true);
    }

    private FlurryAgent() {
        HandlerThread handlerThread = new HandlerThread("FlurryAgent");
        handlerThread.start();
        this.f64s = new Handler(handlerThread.getLooper());
    }

    public static void setCatalogIntentName(String str) {
        f18a = str;
    }

    public static void enableAppCircle() {
        f32o = true;
    }

    public static AppCircle getAppCircle() {
        return f33p;
    }

    /* renamed from: a */
    static View m8a(Context context, String str, int i) {
        if (!f32o) {
            return null;
        }
        try {
            return f25h.f63ab.mo3333a(context, str, i);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
            return null;
        }
    }

    /* renamed from: a */
    static void m13a(Context context, String str) {
        if (f32o) {
            f25h.f63ab.mo3342a(context, str);
        }
    }

    /* renamed from: a */
    static Offer m9a(String str) {
        if (!f32o) {
            return null;
        }
        return f25h.f63ab.mo3350b(str);
    }

    /* renamed from: b */
    static List m31b(String str) {
        if (!f32o) {
            return null;
        }
        return f25h.f63ab.mo3354c(str);
    }

    /* renamed from: a */
    static void m12a(Context context, long j) {
        if (!f32o) {
            C0095ai.m106d("FlurryAgent", "Cannot accept Offer. AppCircle is not enabled");
        }
        f25h.f63ab.mo3339a(context, j);
    }

    /* renamed from: a */
    static void m22a(List list) {
        if (f32o) {
            f25h.f63ab.mo3346a(list);
        }
    }

    /* renamed from: a */
    static void m23a(boolean z) {
        if (f32o) {
            f25h.f63ab.mo3348a(z);
        }
    }

    /* renamed from: a */
    static boolean m24a() {
        return f25h.f63ab.mo3360h();
    }

    public static void setDefaultNoAdsMessage(String str) {
        if (f32o) {
            if (str == null) {
                str = "";
            }
            C0120v.f234b = str;
        }
    }

    /* renamed from: a */
    static void m15a(AppCircleCallback appCircleCallback) {
        f25h.f63ab.mo3343a(appCircleCallback);
    }

    public static void addUserCookie(String str, String str2) {
        if (f32o) {
            f25h.f63ab.mo3345a(str, str2);
        }
    }

    public static void clearUserCookies() {
        if (f32o) {
            f25h.f63ab.mo3363k();
        }
    }

    public static void setVersionName(String str) {
        synchronized (f25h) {
            f25h.f37B = str;
        }
    }

    public static int getAgentVersion() {
        return 122;
    }

    public static void setReportLocation(boolean z) {
        synchronized (f25h) {
            f25h.f38C = z;
        }
    }

    public static void setLogEnabled(boolean z) {
        synchronized (f25h) {
            if (z) {
                C0095ai.m103b();
            } else {
                C0095ai.m98a();
            }
        }
    }

    public static void setLogLevel(int i) {
        synchronized (f25h) {
            C0095ai.m99a(i);
        }
    }

    public static void setContinueSessionMillis(long j) {
        if (j < 5000) {
            C0095ai.m101b("FlurryAgent", "Invalid time set for session resumption: " + j);
            return;
        }
        synchronized (f25h) {
            f26i = j;
        }
    }

    public static void setLogEvents(boolean z) {
        synchronized (f25h) {
            f27j = z;
        }
    }

    public static void setUseHttps(boolean z) {
        f28k = z;
    }

    public static void setCaptureUncaughtExceptions(boolean z) {
        synchronized (f25h) {
            if (f25h.f67v) {
                C0095ai.m101b("FlurryAgent", "Cannot setCaptureUncaughtExceptions after onSessionStart");
            } else {
                f30m = z;
            }
        }
    }

    public static void onStartSession(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("Null context");
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Api key not specified");
        } else {
            try {
                f25h.m32b(context, str);
            } catch (Throwable th) {
                C0095ai.m102b("FlurryAgent", "", th);
            }
        }
    }

    public static void onEndSession(Context context) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        try {
            f25h.m14a(context, false);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
    }

    public static void logEvent(String str) {
        try {
            f25h.m21a(str, (Map) null, false);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "Failed to log event: " + str, th);
        }
    }

    public static void logEvent(String str, Map map) {
        try {
            f25h.m21a(str, map, false);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "Failed to log event: " + str, th);
        }
    }

    public static void logEvent(String str, boolean z) {
        try {
            f25h.m21a(str, (Map) null, z);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "Failed to log event: " + str, th);
        }
    }

    public static void logEvent(String str, Map map, boolean z) {
        try {
            f25h.m21a(str, map, z);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "Failed to log event: " + str, th);
        }
    }

    public static void endTimedEvent(String str) {
        try {
            f25h.m41c(str);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "Failed to signify the end of event: " + str, th);
        }
    }

    public static void onError(String str, String str2, String str3) {
        try {
            f25h.m20a(str, str2, str3);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
    }

    public static void onEvent(String str) {
        try {
            f25h.m21a(str, (Map) null, false);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
    }

    public static void onEvent(String str, Map map) {
        try {
            f25h.m21a(str, map, false);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
    }

    public static void onPageView() {
        try {
            f25h.m56l();
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
    }

    public static void setReportUrl(String str) {
        f20c = str;
    }

    public static void setCanvasUrl(String str) {
        f21d = str;
    }

    public static void setGetAppUrl(String str) {
        f23f = str;
    }

    public static void setLocationCriteria(Criteria criteria) {
        synchronized (f25h) {
            f31n = criteria;
        }
    }

    public static void setAge(int i) {
        if (i > 0 && i < 110) {
            Date date = new Date(new Date(System.currentTimeMillis() - (((long) i) * 31449600000L)).getYear(), 1, 1);
            f25h.f54S = Long.valueOf(date.getTime());
        }
    }

    public static void setGender(byte b) {
        switch (b) {
            case 0:
            case 1:
                f25h.f53R = b;
                return;
            default:
                f25h.f53R = -1;
                return;
        }
    }

    public static void setUserId(String str) {
        synchronized (f25h) {
            f25h.f52Q = C0116r.m123a(str, (int) MotionEventCompat.ACTION_MASK);
        }
    }

    public static boolean getForbidPlaintextFallback() {
        return false;
    }

    protected static boolean isCaptureUncaughtExceptions() {
        return f30m;
    }

    /* renamed from: b */
    static C0120v m29b() {
        return f25h.f63ab;
    }

    /* renamed from: b */
    private synchronized void m32b(Context context, String str) {
        if (this.f71z != null && !this.f71z.equals(str)) {
            C0095ai.m101b("FlurryAgent", "onStartSession called with different api keys: " + this.f71z + " and " + str);
        }
        if (((Context) this.f70y.put(context, context)) != null) {
            C0095ai.m106d("FlurryAgent", "onStartSession called with duplicate context, use a specific Activity or Service as context instead of using a global context");
        }
        if (!this.f67v) {
            C0095ai.m96a("FlurryAgent", "Initializing Flurry session");
            f34q.set(0);
            f35r.set(0);
            this.f71z = str;
            this.f66u = context.getFileStreamPath(".flurryagent." + Integer.toString(this.f71z.hashCode(), 16));
            this.f65t = context.getFileStreamPath(".flurryb.");
            if (f30m) {
                Thread.setDefaultUncaughtExceptionHandler(new FlurryDefaultExceptionHandler());
            }
            Context applicationContext = context.getApplicationContext();
            if (this.f37B == null) {
                this.f37B = m38c(applicationContext);
            }
            String packageName = applicationContext.getPackageName();
            if (this.f36A != null && !this.f36A.equals(packageName)) {
                C0095ai.m101b("FlurryAgent", "onStartSession called from different application packages: " + this.f36A + " and " + packageName);
            }
            this.f36A = packageName;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.f69x > f26i) {
                C0095ai.m96a("FlurryAgent", "New session");
                this.f46K = System.currentTimeMillis();
                this.f47L = elapsedRealtime;
                this.f48M = -1;
                this.f52Q = "";
                this.f55T = 0;
                this.f56U = null;
                this.f50O = TimeZone.getDefault().getID();
                this.f49N = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
                this.f57V = new HashMap();
                this.f58W = new ArrayList();
                this.f59X = true;
                this.f61Z = new ArrayList();
                this.f60Y = 0;
                this.f62aa = 0;
                if (f32o) {
                    if (!this.f63ab.mo3349a()) {
                        C0095ai.m96a("FlurryAgent", "Initializing AppCircle");
                        C0086a aVar = new C0086a();
                        aVar.f80a = this.f71z;
                        aVar.f81b = this.f43H;
                        aVar.f82c = f21d != null ? f21d : f22e;
                        aVar.f83d = m37c();
                        aVar.f84e = this.f64s;
                        this.f63ab.mo3340a(context, aVar);
                        C0095ai.m96a("FlurryAgent", "AppCircle initialized");
                    }
                    this.f63ab.mo3338a(this.f46K, this.f47L);
                }
                m19a((Runnable) new C0102d(this, applicationContext, this.f38C));
            } else {
                C0095ai.m96a("FlurryAgent", "Continuing previous session");
                if (!this.f45J.isEmpty()) {
                    this.f45J.remove(this.f45J.size() - 1);
                }
            }
            this.f67v = true;
        }
    }

    /* renamed from: a */
    private synchronized void m14a(Context context, boolean z) {
        if (context != null) {
            if (((Context) this.f70y.remove(context)) == null) {
                C0095ai.m106d("FlurryAgent", "onEndSession called without context from corresponding onStartSession");
            }
        }
        if (this.f67v && this.f70y.isEmpty()) {
            C0095ai.m96a("FlurryAgent", "Ending session");
            m59o();
            Context applicationContext = context == null ? null : context.getApplicationContext();
            if (context != null) {
                String packageName = applicationContext.getPackageName();
                if (!this.f36A.equals(packageName)) {
                    C0095ai.m101b("FlurryAgent", "onEndSession called from different application package, expected: " + this.f36A + " actual: " + packageName);
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f69x = elapsedRealtime;
            this.f48M = elapsedRealtime - this.f47L;
            if (this.f41F == null) {
                C0095ai.m101b("FlurryAgent", "Not creating report because of bad Android ID or generated ID is null");
            }
            m19a((Runnable) new C0100b(this, z, applicationContext));
            this.f67v = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public synchronized void m55k() {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(1);
                dataOutputStream.writeUTF(this.f37B);
                dataOutputStream.writeLong(this.f46K);
                dataOutputStream.writeLong(this.f48M);
                dataOutputStream.writeLong(0);
                dataOutputStream.writeUTF(this.f49N);
                dataOutputStream.writeUTF(this.f50O);
                dataOutputStream.writeByte(this.f51P);
                dataOutputStream.writeUTF(this.f52Q == null ? "" : this.f52Q);
                if (this.f56U == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeDouble(m7a(this.f56U.getLatitude()));
                    dataOutputStream.writeDouble(m7a(this.f56U.getLongitude()));
                    dataOutputStream.writeFloat(this.f56U.getAccuracy());
                }
                dataOutputStream.writeInt(this.f62aa);
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(this.f53R);
                if (this.f54S == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeLong(this.f54S.longValue());
                }
                dataOutputStream.writeShort(this.f57V.size());
                for (Map.Entry entry : this.f57V.entrySet()) {
                    dataOutputStream.writeUTF((String) entry.getKey());
                    dataOutputStream.writeInt(((C0105g) entry.getValue()).f197a);
                }
                dataOutputStream.writeShort(this.f58W.size());
                for (C0107i a : this.f58W) {
                    dataOutputStream.write(a.mo3315a());
                }
                dataOutputStream.writeBoolean(this.f59X);
                dataOutputStream.writeInt(this.f55T);
                dataOutputStream.writeShort(this.f61Z.size());
                for (C0088ab abVar : this.f61Z) {
                    dataOutputStream.writeShort(abVar.f96a);
                    dataOutputStream.writeLong(abVar.f97b);
                    dataOutputStream.writeUTF(abVar.f98c);
                    dataOutputStream.writeUTF(abVar.f99d);
                    dataOutputStream.writeUTF(abVar.f100e);
                }
                if (f32o) {
                    List<C0114p> f = this.f63ab.mo3358f();
                    dataOutputStream.writeShort(f.size());
                    for (C0114p a2 : f) {
                        a2.mo3326a((DataOutput) dataOutputStream);
                    }
                } else {
                    dataOutputStream.writeShort(0);
                }
                dataOutputStream.writeShort(0);
                this.f45J.add(byteArrayOutputStream.toByteArray());
                C0116r.m125a((Closeable) dataOutputStream);
            } catch (IOException e) {
                e = e;
                dataOutputStream2 = dataOutputStream;
                try {
                    C0095ai.m102b("FlurryAgent", "", e);
                    C0116r.m125a((Closeable) dataOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    C0116r.m125a((Closeable) dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C0116r.m125a((Closeable) dataOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            C0095ai.m102b("FlurryAgent", "", e);
            C0116r.m125a((Closeable) dataOutputStream2);
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            C0116r.m125a((Closeable) dataOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private static double m7a(double d) {
        return ((double) Math.round(d * 1000.0d)) / 1000.0d;
    }

    /* renamed from: a */
    private void m19a(Runnable runnable) {
        this.f64s.post(runnable);
    }

    /* renamed from: l */
    private synchronized void m56l() {
        this.f62aa++;
    }

    /* renamed from: a */
    private synchronized void m21a(String str, Map map, boolean z) {
        Map map2;
        if (this.f58W == null) {
            C0095ai.m101b("FlurryAgent", "onEvent called before onStartSession.  Event: " + str);
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f47L;
            String a = C0116r.m123a(str, (int) MotionEventCompat.ACTION_MASK);
            if (a.length() != 0) {
                C0105g gVar = (C0105g) this.f57V.get(a);
                if (gVar != null) {
                    gVar.f197a++;
                    C0095ai.m96a("FlurryAgent", "Event count incremented: " + a);
                } else if (this.f57V.size() < 100) {
                    C0105g gVar2 = new C0105g();
                    gVar2.f197a = 1;
                    this.f57V.put(a, gVar2);
                    C0095ai.m96a("FlurryAgent", "Event count incremented: " + a);
                } else if (C0095ai.m100a("FlurryAgent")) {
                    C0095ai.m96a("FlurryAgent", "Too many different events. Event not counted: " + a);
                }
                if (!f27j || this.f58W.size() >= 200 || this.f60Y >= 16000) {
                    this.f59X = false;
                } else {
                    if (map == null) {
                        map2 = Collections.emptyMap();
                    } else {
                        map2 = map;
                    }
                    if (map2.size() <= 10) {
                        C0107i iVar = new C0107i(a, map2, elapsedRealtime, z);
                        if (iVar.mo3315a().length + this.f60Y <= 16000) {
                            this.f58W.add(iVar);
                            this.f60Y = iVar.mo3315a().length + this.f60Y;
                            C0095ai.m96a("FlurryAgent", "Logged event: " + a);
                        } else {
                            this.f60Y = 16000;
                            this.f59X = false;
                            C0095ai.m96a("FlurryAgent", "Event Log size exceeded. No more event details logged.");
                        }
                    } else if (C0095ai.m100a("FlurryAgent")) {
                        C0095ai.m96a("FlurryAgent", "MaxEventParams exceeded: " + map2.size());
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private synchronized void m41c(String str) {
        Iterator it = this.f58W.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0107i iVar = (C0107i) it.next();
            if (iVar.mo3314a(str)) {
                iVar.mo3313a(SystemClock.elapsedRealtime() - this.f47L);
                break;
            }
        }
    }

    /* renamed from: a */
    private synchronized void m20a(String str, String str2, String str3) {
        if (this.f61Z == null) {
            C0095ai.m101b("FlurryAgent", "onError called before onStartSession.  Error: " + str);
        } else {
            this.f55T++;
            if (this.f61Z.size() < 10) {
                C0088ab abVar = new C0088ab();
                abVar.f97b = System.currentTimeMillis();
                abVar.f98c = C0116r.m123a(str, (int) MotionEventCompat.ACTION_MASK);
                abVar.f99d = C0116r.m123a(str2, 512);
                abVar.f100e = C0116r.m123a(str3, (int) MotionEventCompat.ACTION_MASK);
                this.f61Z.add(abVar);
                C0095ai.m96a("FlurryAgent", "Error logged: " + abVar.f98c);
            } else {
                C0095ai.m96a("FlurryAgent", "Max errors logged. No more errors logged.");
            }
        }
    }

    /* renamed from: b */
    private synchronized byte[] m36b(boolean z) {
        DataOutputStream dataOutputStream;
        byte[] bArr;
        synchronized (this) {
            try {
                CrcMessageDigest crcMessageDigest = new CrcMessageDigest();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, crcMessageDigest);
                dataOutputStream = new DataOutputStream(digestOutputStream);
                try {
                    dataOutputStream.writeShort(22);
                    if (!f32o || !z) {
                        dataOutputStream.writeShort(0);
                    } else {
                        dataOutputStream.writeShort(1);
                    }
                    if (f32o) {
                        dataOutputStream.writeLong(this.f63ab.mo3356d());
                        Set<Long> e = this.f63ab.mo3357e();
                        dataOutputStream.writeShort(e.size());
                        for (Long longValue : e) {
                            long longValue2 = longValue.longValue();
                            dataOutputStream.writeByte(1);
                            dataOutputStream.writeLong(longValue2);
                        }
                    } else {
                        dataOutputStream.writeLong(0);
                        dataOutputStream.writeShort(0);
                    }
                    dataOutputStream.writeShort(3);
                    dataOutputStream.writeShort(122);
                    dataOutputStream.writeLong(System.currentTimeMillis());
                    dataOutputStream.writeUTF(this.f71z);
                    dataOutputStream.writeUTF(this.f37B);
                    int i = this.f44I == null ? 1 : 2;
                    dataOutputStream.writeShort(i);
                    dataOutputStream.writeShort(0);
                    dataOutputStream.writeUTF(this.f41F);
                    if (i > 1) {
                        dataOutputStream.writeShort(5);
                        dataOutputStream.writeShort(this.f44I.length);
                        dataOutputStream.write(this.f44I);
                        C0095ai.m104c("FlurryAgent", "Sent IMEI: " + Arrays.toString(this.f44I));
                    }
                    dataOutputStream.write(0);
                    dataOutputStream.writeLong(this.f43H);
                    dataOutputStream.writeLong(this.f46K);
                    dataOutputStream.writeShort(6);
                    dataOutputStream.writeUTF("device.model");
                    dataOutputStream.writeUTF(Build.MODEL);
                    dataOutputStream.writeUTF("build.brand");
                    dataOutputStream.writeUTF(Build.BRAND);
                    dataOutputStream.writeUTF("build.id");
                    dataOutputStream.writeUTF(Build.ID);
                    dataOutputStream.writeUTF("version.release");
                    dataOutputStream.writeUTF(Build.VERSION.RELEASE);
                    dataOutputStream.writeUTF("build.device");
                    dataOutputStream.writeUTF(Build.DEVICE);
                    dataOutputStream.writeUTF("build.product");
                    dataOutputStream.writeUTF(Build.PRODUCT);
                    int size = this.f45J.size();
                    dataOutputStream.writeShort(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        dataOutputStream.write((byte[]) this.f45J.get(i2));
                    }
                    this.f39D = new ArrayList(this.f45J);
                    digestOutputStream.on(false);
                    dataOutputStream.write(crcMessageDigest.getDigest());
                    dataOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                    C0116r.m125a((Closeable) dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                C0116r.m125a((Closeable) dataOutputStream);
                throw th;
            }
        }
        return bArr;
    }

    /* renamed from: m */
    private static String m57m() {
        if (f20c != null) {
            return f20c;
        }
        if (f29l) {
            return kInsecureReportUrl;
        }
        if (f28k) {
            return kSecureReportUrl;
        }
        return kInsecureReportUrl;
    }

    /* renamed from: c */
    static String m37c() {
        return f23f != null ? f23f : f24g;
    }

    /* renamed from: d */
    static boolean m46d() {
        if (!f32o) {
            return false;
        }
        return f25h.f63ab.mo3365m();
    }

    /* renamed from: a */
    private boolean m27a(byte[] bArr) {
        boolean z;
        String m = m57m();
        if (m == null) {
            return false;
        }
        try {
            z = m28a(bArr, m);
        } catch (Exception e) {
            C0095ai.m96a("FlurryAgent", "Sending report exception: " + e.getMessage());
            z = false;
        }
        if (z || f20c != null || !f28k || f29l) {
            return z;
        }
        synchronized (f25h) {
            f29l = true;
            String m2 = m57m();
            if (m2 == null) {
                return false;
            }
            try {
                return m28a(bArr, m2);
            } catch (Exception e2) {
                return z;
            }
        }
    }

    /* renamed from: a */
    private boolean m28a(byte[] bArr, String str) {
        boolean z = true;
        if (!"local".equals(str)) {
            C0095ai.m96a("FlurryAgent", "Sending report to: " + str);
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bArr);
            byteArrayEntity.setContentType("application/octet-stream");
            HttpPost httpPost = new HttpPost(str);
            httpPost.setEntity(byteArrayEntity);
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
            httpPost.getParams().setBooleanParameter("http.protocol.expect-continue", false);
            HttpResponse execute = m10a((HttpParams) basicHttpParams).execute(httpPost);
            int statusCode = execute.getStatusLine().getStatusCode();
            synchronized (this) {
                if (statusCode == 200) {
                    C0095ai.m96a("FlurryAgent", "Report successful");
                    this.f42G = true;
                    this.f45J.removeAll(this.f39D);
                    HttpEntity entity = execute.getEntity();
                    C0095ai.m96a("FlurryAgent", "Processing report response");
                    if (!(entity == null || entity.getContentLength() == 0)) {
                        try {
                            m18a(new DataInputStream(entity.getContent()));
                        } finally {
                            entity.consumeContent();
                        }
                    }
                } else {
                    C0095ai.m96a("FlurryAgent", "Report failed. HTTP response: " + statusCode);
                    z = false;
                }
                this.f39D = null;
            }
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m18a(java.io.DataInputStream r15) {
        /*
            r14 = this;
            r7 = 0
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
        L_0x001f:
            int r9 = r15.readUnsignedShort()
            int r0 = r15.readInt()
            switch(r9) {
                case 258: goto L_0x0060;
                case 259: goto L_0x0064;
                case 260: goto L_0x002a;
                case 261: goto L_0x002a;
                case 262: goto L_0x0083;
                case 263: goto L_0x009b;
                case 264: goto L_0x0045;
                case 265: goto L_0x002a;
                case 266: goto L_0x00cc;
                case 267: goto L_0x002a;
                case 268: goto L_0x0102;
                case 269: goto L_0x0149;
                case 270: goto L_0x00c7;
                case 271: goto L_0x00e4;
                case 272: goto L_0x011f;
                case 273: goto L_0x014e;
                default: goto L_0x002a;
            }
        L_0x002a:
            java.lang.String r8 = "FlurryAgent"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unknown chunkType: "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r10 = r10.append(r9)
            java.lang.String r10 = r10.toString()
            com.flurry.android.C0095ai.m96a(r8, r10)
            r15.skipBytes(r0)
        L_0x0045:
            r0 = 264(0x108, float:3.7E-43)
            if (r9 != r0) goto L_0x001f
            boolean r0 = f32o
            if (r0 == 0) goto L_0x005f
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x005a
            java.lang.String r0 = "FlurryAgent"
            java.lang.String r7 = "No ads from server"
            com.flurry.android.C0095ai.m96a(r0, r7)
        L_0x005a:
            com.flurry.android.v r0 = r14.f63ab
            r0.mo3347a(r1, r2, r3, r4, r5, r6)
        L_0x005f:
            return
        L_0x0060:
            r15.readInt()
            goto L_0x0045
        L_0x0064:
            byte r8 = r15.readByte()
            int r10 = r15.readUnsignedShort()
            com.flurry.android.w[] r11 = new com.flurry.android.C0121w[r10]
            r0 = r7
        L_0x006f:
            if (r0 >= r10) goto L_0x007b
            com.flurry.android.w r12 = new com.flurry.android.w
            r12.<init>(r15)
            r11[r0] = r12
            int r0 = r0 + 1
            goto L_0x006f
        L_0x007b:
            java.lang.Byte r0 = java.lang.Byte.valueOf(r8)
            r1.put(r0, r11)
            goto L_0x0045
        L_0x0083:
            int r8 = r15.readUnsignedShort()
            r0 = r7
        L_0x0088:
            if (r0 >= r8) goto L_0x0045
            com.flurry.android.AdImage r10 = new com.flurry.android.AdImage
            r10.<init>(r15)
            long r11 = r10.f3a
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r4.put(r11, r10)
            int r0 = r0 + 1
            goto L_0x0088
        L_0x009b:
            int r8 = r15.readInt()
            r0 = r7
        L_0x00a0:
            if (r0 >= r8) goto L_0x0045
            com.flurry.android.e r10 = new com.flurry.android.e
            r10.<init>(r15)
            java.lang.String r11 = r10.f191a
            r2.put(r11, r10)
            java.lang.String r11 = "FlurryAgent"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Parsed hook: "
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.StringBuilder r10 = r12.append(r10)
            java.lang.String r10 = r10.toString()
            com.flurry.android.C0095ai.m96a(r11, r10)
            int r0 = r0 + 1
            goto L_0x00a0
        L_0x00c7:
            r15.skipBytes(r0)
            goto L_0x0045
        L_0x00cc:
            byte r8 = r15.readByte()
            r0 = r7
        L_0x00d1:
            if (r0 >= r8) goto L_0x0045
            com.flurry.android.c r10 = new com.flurry.android.c
            r10.<init>(r15)
            byte r11 = r10.f155a
            java.lang.Byte r11 = java.lang.Byte.valueOf(r11)
            r3.put(r11, r10)
            int r0 = r0 + 1
            goto L_0x00d1
        L_0x00e4:
            byte r10 = r15.readByte()
            r8 = r7
        L_0x00e9:
            if (r8 >= r10) goto L_0x0045
            byte r0 = r15.readByte()
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)
            java.lang.Object r0 = r3.get(r0)
            com.flurry.android.c r0 = (com.flurry.android.C0101c) r0
            if (r0 == 0) goto L_0x00fe
            r0.mo3306a((java.io.DataInput) r15)
        L_0x00fe:
            int r0 = r8 + 1
            r8 = r0
            goto L_0x00e9
        L_0x0102:
            int r8 = r15.readInt()
            r0 = r7
        L_0x0107:
            if (r0 >= r8) goto L_0x0045
            long r10 = r15.readLong()
            short r12 = r15.readShort()
            java.lang.Short r12 = java.lang.Short.valueOf(r12)
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r6.put(r12, r10)
            int r0 = r0 + 1
            goto L_0x0107
        L_0x011f:
            long r10 = r15.readLong()
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            java.lang.Object r0 = r5.get(r0)
            com.flurry.android.am r0 = (com.flurry.android.C0099am) r0
            if (r0 != 0) goto L_0x0134
            com.flurry.android.am r0 = new com.flurry.android.am
            r0.<init>()
        L_0x0134:
            java.lang.String r8 = r15.readUTF()
            r0.f123a = r8
            int r8 = r15.readInt()
            r0.f125c = r8
            java.lang.Long r8 = java.lang.Long.valueOf(r10)
            r5.put(r8, r0)
            goto L_0x0045
        L_0x0149:
            r15.skipBytes(r0)
            goto L_0x0045
        L_0x014e:
            r15.skipBytes(r0)
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.android.FlurryAgent.m18a(java.io.DataInputStream):void");
    }

    /* renamed from: c */
    private void m42c(boolean z) {
        try {
            C0095ai.m96a("FlurryAgent", "generating report");
            byte[] b = m36b(z);
            if (b == null) {
                C0095ai.m96a("FlurryAgent", "Error generating report");
            } else if (m27a(b)) {
                C0095ai.m96a("FlurryAgent", "Done sending " + (this.f67v ? "initial " : "") + "agent report");
                m58n();
            }
        } catch (IOException e) {
            C0095ai.m97a("FlurryAgent", "", e);
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d A[Catch:{ Throwable -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060 A[Catch:{ Throwable -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[Catch:{ Throwable -> 0x00f2 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x00e5=Splitter:B:48:0x00e5, B:12:0x0046=Splitter:B:12:0x0046, B:20:0x005c=Splitter:B:20:0x005c} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m11a(android.content.Context r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = r8.m30b((android.content.Context) r9)     // Catch:{ all -> 0x00e0 }
            r8.f41F = r0     // Catch:{ all -> 0x00e0 }
            java.io.File r0 = r8.f66u     // Catch:{ all -> 0x00e0 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x00fc
            java.lang.String r0 = "FlurryAgent"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r1.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r2 = "loading persistent data: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00e0 }
            java.io.File r2 = r8.f66u     // Catch:{ all -> 0x00e0 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00e0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e0 }
            com.flurry.android.C0095ai.m104c(r0, r1)     // Catch:{ all -> 0x00e0 }
            r2 = 0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0107, all -> 0x00e3 }
            java.io.File r1 = r8.f66u     // Catch:{ Throwable -> 0x0107, all -> 0x00e3 }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0107, all -> 0x00e3 }
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ Throwable -> 0x0107, all -> 0x00e3 }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x0107, all -> 0x00e3 }
            int r0 = r1.readUnsignedShort()     // Catch:{ Throwable -> 0x00d3 }
            r2 = 46586(0xb5fa, float:6.5281E-41)
            if (r0 != r2) goto L_0x00ca
            r8.m35b((java.io.DataInputStream) r1)     // Catch:{ Throwable -> 0x00d3 }
        L_0x0046:
            com.flurry.android.C0116r.m125a((java.io.Closeable) r1)     // Catch:{ all -> 0x00e0 }
        L_0x0049:
            boolean r0 = r8.f68w     // Catch:{ Throwable -> 0x00f2 }
            if (r0 != 0) goto L_0x005c
            java.io.File r0 = r8.f66u     // Catch:{ Throwable -> 0x00f2 }
            boolean r0 = r0.delete()     // Catch:{ Throwable -> 0x00f2 }
            if (r0 == 0) goto L_0x00e9
            java.lang.String r0 = "FlurryAgent"
            java.lang.String r1 = "Deleted persistence file"
            com.flurry.android.C0095ai.m96a(r0, r1)     // Catch:{ Throwable -> 0x00f2 }
        L_0x005c:
            boolean r0 = r8.f68w     // Catch:{ all -> 0x00e0 }
            if (r0 != 0) goto L_0x006a
            r0 = 0
            r8.f42G = r0     // Catch:{ all -> 0x00e0 }
            long r0 = r8.f46K     // Catch:{ all -> 0x00e0 }
            r8.f43H = r0     // Catch:{ all -> 0x00e0 }
            r0 = 1
            r8.f68w = r0     // Catch:{ all -> 0x00e0 }
        L_0x006a:
            java.lang.String r0 = r8.f41F     // Catch:{ all -> 0x00e0 }
            if (r0 != 0) goto L_0x00aa
            double r0 = java.lang.Math.random()     // Catch:{ all -> 0x00e0 }
            long r0 = java.lang.Double.doubleToLongBits(r0)     // Catch:{ all -> 0x00e0 }
            r2 = 37
            long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00e0 }
            java.lang.String r6 = r8.f71z     // Catch:{ all -> 0x00e0 }
            int r6 = r6.hashCode()     // Catch:{ all -> 0x00e0 }
            int r6 = r6 * 37
            long r6 = (long) r6     // Catch:{ all -> 0x00e0 }
            long r4 = r4 + r6
            long r2 = r2 * r4
            long r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r2.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r3 = "ID"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00e0 }
            r3 = 16
            java.lang.String r0 = java.lang.Long.toString(r0, r3)     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00e0 }
            r8.f41F = r0     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = "FlurryAgent"
            java.lang.String r1 = "Generated id"
            com.flurry.android.C0095ai.m104c(r0, r1)     // Catch:{ all -> 0x00e0 }
        L_0x00aa:
            com.flurry.android.v r0 = r8.f63ab     // Catch:{ all -> 0x00e0 }
            java.lang.String r1 = r8.f41F     // Catch:{ all -> 0x00e0 }
            r0.mo3344a((java.lang.String) r1)     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = r8.f41F     // Catch:{ all -> 0x00e0 }
            java.lang.String r1 = "AND"
            boolean r0 = r0.startsWith(r1)     // Catch:{ all -> 0x00e0 }
            if (r0 != 0) goto L_0x00c8
            java.io.File r0 = r8.f65t     // Catch:{ all -> 0x00e0 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x00e0 }
            if (r0 != 0) goto L_0x00c8
            java.lang.String r0 = r8.f41F     // Catch:{ all -> 0x00e0 }
            r8.m39c(r9, r0)     // Catch:{ all -> 0x00e0 }
        L_0x00c8:
            monitor-exit(r8)
            return
        L_0x00ca:
            java.lang.String r0 = "FlurryAgent"
            java.lang.String r2 = "Unexpected file type"
            com.flurry.android.C0095ai.m96a(r0, r2)     // Catch:{ Throwable -> 0x00d3 }
            goto L_0x0046
        L_0x00d3:
            r0 = move-exception
        L_0x00d4:
            java.lang.String r2 = "FlurryAgent"
            java.lang.String r3 = "Error when loading persistent file"
            com.flurry.android.C0095ai.m102b(r2, r3, r0)     // Catch:{ all -> 0x0105 }
            com.flurry.android.C0116r.m125a((java.io.Closeable) r1)     // Catch:{ all -> 0x00e0 }
            goto L_0x0049
        L_0x00e0:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x00e3:
            r0 = move-exception
            r1 = r2
        L_0x00e5:
            com.flurry.android.C0116r.m125a((java.io.Closeable) r1)     // Catch:{ all -> 0x00e0 }
            throw r0     // Catch:{ all -> 0x00e0 }
        L_0x00e9:
            java.lang.String r0 = "FlurryAgent"
            java.lang.String r1 = "Cannot delete persistence file"
            com.flurry.android.C0095ai.m101b(r0, r1)     // Catch:{ Throwable -> 0x00f2 }
            goto L_0x005c
        L_0x00f2:
            r0 = move-exception
            java.lang.String r1 = "FlurryAgent"
            java.lang.String r2 = ""
            com.flurry.android.C0095ai.m102b(r1, r2, r0)     // Catch:{ all -> 0x00e0 }
            goto L_0x005c
        L_0x00fc:
            java.lang.String r0 = "FlurryAgent"
            java.lang.String r1 = "Agent cache file doesn't exist."
            com.flurry.android.C0095ai.m104c(r0, r1)     // Catch:{ all -> 0x00e0 }
            goto L_0x005c
        L_0x0105:
            r0 = move-exception
            goto L_0x00e5
        L_0x0107:
            r0 = move-exception
            r1 = r2
            goto L_0x00d4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.android.FlurryAgent.m11a(android.content.Context):void");
    }

    /* renamed from: b */
    private synchronized void m35b(DataInputStream dataInputStream) {
        int i = 0;
        synchronized (this) {
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            if (readUnsignedShort > 2) {
                C0095ai.m101b("FlurryAgent", "Unknown agent file version: " + readUnsignedShort);
                throw new IOException("Unknown agent file version: " + readUnsignedShort);
            } else if (readUnsignedShort >= 2) {
                String readUTF = dataInputStream.readUTF();
                C0095ai.m96a("FlurryAgent", "Loading API key: " + m45d(this.f71z));
                if (readUTF.equals(this.f71z)) {
                    String readUTF2 = dataInputStream.readUTF();
                    if (this.f41F == null) {
                        C0095ai.m96a("FlurryAgent", "Loading phoneId: " + readUTF2);
                    }
                    this.f41F = readUTF2;
                    this.f42G = dataInputStream.readBoolean();
                    this.f43H = dataInputStream.readLong();
                    C0095ai.m96a("FlurryAgent", "Loading session reports");
                    while (true) {
                        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                        if (readUnsignedShort2 == 0) {
                            break;
                        }
                        byte[] bArr = new byte[readUnsignedShort2];
                        dataInputStream.readFully(bArr);
                        this.f45J.add(0, bArr);
                        i++;
                        C0095ai.m96a("FlurryAgent", "Session report added: " + i);
                    }
                    C0095ai.m96a("FlurryAgent", "Persistent file loaded");
                    this.f68w = true;
                } else {
                    C0095ai.m96a("FlurryAgent", "Api keys do not match, old: " + m45d(readUTF) + ", new: " + m45d(this.f71z));
                }
            } else {
                C0095ai.m106d("FlurryAgent", "Deleting old file version: " + readUnsignedShort);
            }
        }
    }

    /* renamed from: d */
    private static String m45d(String str) {
        if (str == null || str.length() <= 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 4; i++) {
            sb.append('*');
        }
        sb.append(str.substring(str.length() - 4));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public synchronized void m58n() {
        DataOutputStream dataOutputStream;
        try {
            if (!m26a(this.f66u)) {
                C0116r.m125a((Closeable) null);
            } else {
                dataOutputStream = new DataOutputStream(new FileOutputStream(this.f66u));
                try {
                    dataOutputStream.writeShort(46586);
                    dataOutputStream.writeShort(2);
                    dataOutputStream.writeUTF(this.f71z);
                    dataOutputStream.writeUTF(this.f41F);
                    dataOutputStream.writeBoolean(this.f42G);
                    dataOutputStream.writeLong(this.f43H);
                    int size = this.f45J.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        byte[] bArr = (byte[]) this.f45J.get(size);
                        int length = bArr.length;
                        if (length + 2 + dataOutputStream.size() > 50000) {
                            C0095ai.m96a("FlurryAgent", "discarded sessions: " + size);
                            break;
                        }
                        dataOutputStream.writeShort(length);
                        dataOutputStream.write(bArr);
                        size--;
                    }
                    dataOutputStream.writeShort(0);
                    C0116r.m125a((Closeable) dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                    try {
                        C0095ai.m102b("FlurryAgent", "", th);
                        C0116r.m125a((Closeable) dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        C0116r.m125a((Closeable) dataOutputStream);
                        throw th;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            C0116r.m125a((Closeable) dataOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private static boolean m26a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.mkdirs() || parentFile.exists()) {
            return true;
        }
        C0095ai.m101b("FlurryAgent", "Unable to create persistent dir: " + parentFile);
        return false;
    }

    /* renamed from: c */
    private synchronized void m39c(Context context, String str) {
        DataOutputStream dataOutputStream;
        this.f65t = context.getFileStreamPath(".flurryb.");
        if (m26a(this.f65t)) {
            try {
                dataOutputStream = new DataOutputStream(new FileOutputStream(this.f65t));
                try {
                    dataOutputStream.writeInt(1);
                    dataOutputStream.writeUTF(str);
                    C0116r.m125a((Closeable) dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                    try {
                        C0095ai.m102b("FlurryAgent", "Error when saving b file", th);
                        C0116r.m125a((Closeable) dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        C0116r.m125a((Closeable) dataOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                C0116r.m125a((Closeable) dataOutputStream);
                throw th;
            }
        }
    }

    /* renamed from: b */
    private String m30b(Context context) {
        DataInputStream dataInputStream;
        Throwable th;
        boolean z = false;
        if (this.f41F != null) {
            return this.f41F;
        }
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        if (string != null && string.length() > 0 && !string.equals("null")) {
            String[] strArr = f19b;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (string.equals(strArr[i])) {
                        break;
                    }
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            return "AND" + string;
        }
        File fileStreamPath = context.getFileStreamPath(".flurryb.");
        if (!fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                dataInputStream.readInt();
                String readUTF = dataInputStream.readUTF();
                C0116r.m125a((Closeable) dataInputStream);
                return readUTF;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0095ai.m102b("FlurryAgent", "Error when loading b file", th);
                    C0116r.m125a((Closeable) dataInputStream);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    C0116r.m125a((Closeable) dataInputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            dataInputStream = null;
            th = th4;
            C0116r.m125a((Closeable) dataInputStream);
            throw th;
        }
    }

    /* renamed from: c */
    private static String m38c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionName != null) {
                return packageInfo.versionName;
            }
            if (packageInfo.versionCode != 0) {
                return Integer.toString(packageInfo.versionCode);
            }
            return "Unknown";
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
    }

    /* renamed from: d */
    private Location m43d(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            synchronized (this) {
                if (this.f40E == null) {
                    this.f40E = locationManager;
                } else {
                    locationManager = this.f40E;
                }
            }
            Criteria criteria = f31n;
            if (criteria == null) {
                criteria = new Criteria();
            }
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                locationManager.requestLocationUpdates(bestProvider, 0, BitmapDescriptorFactory.HUE_RED, this, Looper.getMainLooper());
                return locationManager.getLastKnownLocation(bestProvider);
            }
        }
        return null;
    }

    /* renamed from: e */
    private static byte[] m49e(Context context) {
        TelephonyManager telephonyManager;
        String deviceId;
        if (!(context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (deviceId = telephonyManager.getDeviceId()) == null)) {
            try {
                byte[] b = C0116r.m126b(deviceId);
                if (b != null && b.length == 20) {
                    return b;
                }
                C0095ai.m101b("FlurryAgent", "sha1 is not 20 bytes long: " + Arrays.toString(b));
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* renamed from: o */
    private synchronized void m59o() {
        if (this.f40E != null) {
            this.f40E.removeUpdates(this);
        }
    }

    /* renamed from: e */
    static String m48e() {
        return f25h.f71z;
    }

    /* renamed from: p */
    private synchronized String m60p() {
        return this.f41F;
    }

    public static String getPhoneId() {
        return f25h.m60p();
    }

    public final synchronized void onLocationChanged(Location location) {
        try {
            this.f56U = location;
            m59o();
        } catch (Throwable th) {
            C0095ai.m102b("FlurryAgent", "", th);
        }
        return;
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* renamed from: a */
    private HttpClient m10a(HttpParams httpParams) {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((InputStream) null, (char[]) null);
            C0096aj ajVar = new C0096aj(this, instance);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", ajVar, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
        } catch (Exception e) {
            return new DefaultHttpClient(httpParams);
        }
    }

    /* renamed from: f */
    static int m50f() {
        return f34q.incrementAndGet();
    }

    /* renamed from: g */
    static int m51g() {
        return f35r.incrementAndGet();
    }
}
