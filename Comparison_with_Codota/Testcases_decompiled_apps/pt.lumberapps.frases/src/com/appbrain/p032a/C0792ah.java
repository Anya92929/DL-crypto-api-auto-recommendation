package com.appbrain.p032a;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.appbrain.C1136x;
import com.appbrain.p037f.C1035aa;

/* renamed from: com.appbrain.a.ah */
public class C0792ah {

    /* renamed from: a */
    private static final String f2073a = C0792ah.class.getSimpleName();

    /* renamed from: b */
    private static volatile C1136x f2074b;

    /* renamed from: c */
    private static volatile boolean f2075c;

    /* renamed from: d */
    private static Long f2076d;

    /* renamed from: e */
    private final Context f2077e;

    /* renamed from: f */
    private final boolean f2078f;

    /* renamed from: g */
    private boolean f2079g;

    /* renamed from: h */
    private boolean f2080h = true;

    private C0792ah(Context context) {
        this.f2077e = context.getApplicationContext();
        this.f2078f = true;
        if (!C0926fg.m3925a().mo3818b()) {
            C0926fg.m3925a().mo3817a(context, false, false);
        }
    }

    /* renamed from: a */
    public static C0792ah m3596a(Context context) {
        C0792ah ahVar = new C0792ah(context);
        ahVar.f2079g = true;
        return ahVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02dd, code lost:
        if (r0.getTime() <= r1.getTime()) goto L_0x02df;
     */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02bc  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.appbrain.p037f.C1035aa m3597a(boolean r11) {
        /*
            r10 = this;
            cmn.C0725at.m3231b()
            cmn.n r1 = cmn.C0752n.m3278b()
            com.appbrain.f.ac r2 = com.appbrain.p037f.C1035aa.m4316aD()
            long r4 = android.os.SystemClock.elapsedRealtime()
            r2.mo4138a((long) r4)
            long r4 = java.lang.System.currentTimeMillis()
            r2.mo4144b((long) r4)
            r0 = 0
            boolean r3 = r10.f2078f
            if (r3 == 0) goto L_0x0053
            long r4 = android.os.SystemClock.elapsedRealtime()
            if (r11 == 0) goto L_0x022e
            android.content.Context r0 = r10.f2077e
            com.appbrain.a.dt r0 = com.appbrain.p032a.C0885dt.m3847a((android.content.Context) r0)
            r3 = 500(0x1f4, float:7.0E-43)
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.appbrain.a.dw r0 = r0.mo3764a(r3, r6)
        L_0x0032:
            boolean r3 = r10.f2080h
            if (r3 == 0) goto L_0x0053
            r3 = 0
            r10.f2080h = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "Fetching ad id took "
            r3.<init>(r6)
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6 - r4
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = ", result: "
            java.lang.StringBuilder r3 = r3.append(r4)
            r3.append(r0)
        L_0x0053:
            if (r0 == 0) goto L_0x023d
            java.lang.String r3 = r0.mo3767a()
            r2.mo4184q(r3)
            boolean r0 = r0.mo3768b()
            if (r0 == 0) goto L_0x0066
            r0 = 1
            r2.mo4147b((boolean) r0)
        L_0x0066:
            java.lang.String r0 = r1.mo3429c()
            r2.mo4146b((java.lang.String) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r3 = r1.mo3432f()
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.mo4151c((java.lang.String) r0)
            java.lang.String r0 = r1.mo3437k()
            r2.mo4155d((java.lang.String) r0)
            java.lang.String r0 = android.os.Build.VERSION.RELEASE
            r2.mo4159e((java.lang.String) r0)
            int r0 = r1.mo3430d()
            r2.mo4137a((int) r0)
            int r0 = com.appbrain.p032a.C0879dn.m3814b()
            r2.mo4143b((int) r0)
            java.lang.String r0 = r1.mo3439m()
            r2.mo4167h((java.lang.String) r0)
            java.lang.String r0 = r1.mo3440n()
            r2.mo4170i((java.lang.String) r0)
            java.lang.String r0 = android.os.Build.DEVICE
            r2.mo4172j((java.lang.String) r0)
            java.lang.String r0 = android.os.Build.PRODUCT
            r2.mo4178m((java.lang.String) r0)
            java.lang.String r0 = r1.mo3444r()
            r2.mo4174k((java.lang.String) r0)
            java.lang.String r0 = android.os.Build.MODEL
            r2.mo4176l((java.lang.String) r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r2.mo4181o((int) r0)
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()
            long r4 = java.lang.System.currentTimeMillis()
            int r0 = r0.getOffset(r4)
            r2.mo4179n((int) r0)
            com.appbrain.a.fm r3 = com.appbrain.p032a.C0932fm.m3968a()
            r0 = 118(0x76, float:1.65E-43)
            r2.mo4148c((int) r0)
            java.lang.String r0 = r3.mo3845d()
            if (r0 == 0) goto L_0x00e5
            r2.mo4180n((java.lang.String) r0)
        L_0x00e5:
            int r0 = r3.mo3849h()
            r2.mo4153d((int) r0)
            int r0 = r3.mo3847f()
            r2.mo4157e((int) r0)
            android.content.Context r0 = r10.f2077e
            long r4 = m3598b(r0)
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            r2.mo4149c((long) r4)
            int r0 = r1.mo3436j()
            r2.mo4161f((int) r0)
            int r0 = r1.mo3438l()
            r2.mo4164g((int) r0)
            int r0 = r1.mo3442p()
            r2.mo4166h((int) r0)
            android.content.Context r0 = r10.f2077e     // Catch:{ Exception -> 0x0266 }
            java.lang.String r4 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r4)     // Catch:{ Exception -> 0x0266 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x0266 }
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0266 }
            if (r0 != 0) goto L_0x0254
            r0 = 1
            r2.mo4169i((int) r0)     // Catch:{ Exception -> 0x0266 }
        L_0x0128:
            int r0 = r3.mo3851j()
            r2.mo4171j((int) r0)
            int r0 = r3.mo3853l()
            r2.mo4173k((int) r0)
            int r0 = r3.mo3855n()
            r2.mo4175l((int) r0)
            java.lang.String r0 = r1.mo3441o()
            r2.mo4182o((java.lang.String) r0)
            int r0 = r1.mo3443q()
            r2.mo4177m((int) r0)
            java.lang.String r0 = "extra"
            r4 = 0
            java.lang.String r0 = r3.mo3841a((java.lang.String) r0, (java.lang.String) r4)
            if (r0 == 0) goto L_0x0157
            r2.mo4183p(r0)
        L_0x0157:
            byte[] r0 = com.appbrain.p032a.C0879dn.m3816c()
            if (r0 == 0) goto L_0x0164
            com.appbrain.b.f r0 = com.appbrain.p033b.C1002f.m4161a((byte[]) r0)
            r2.mo4145b((com.appbrain.p033b.C1002f) r0)
        L_0x0164:
            byte[] r0 = com.appbrain.p032a.C0879dn.m3817d()
            if (r0 == 0) goto L_0x0171
            com.appbrain.b.f r0 = com.appbrain.p033b.C1002f.m4161a((byte[]) r0)
            r2.mo4150c((com.appbrain.p033b.C1002f) r0)
        L_0x0171:
            long r4 = com.appbrain.p032a.C0879dn.m3812a()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            r2.mo4154d((long) r4)
            com.appbrain.a.fg r0 = com.appbrain.p032a.C0926fg.m3925a()
            boolean r0 = r0.mo3823g()
            if (r0 == 0) goto L_0x0189
            r0 = 1
            r2.mo4141a((boolean) r0)
        L_0x0189:
            java.lang.String r0 = r1.mo3431e()
            r2.mo4185r(r0)
            boolean r0 = m3599c()
            if (r0 == 0) goto L_0x019a
            r0 = 1
            r2.mo4156d((boolean) r0)
        L_0x019a:
            com.appbrain.x r1 = f2074b
            if (r1 == 0) goto L_0x0270
            android.location.Location r0 = r1.mo4458d()
            if (r0 == 0) goto L_0x01c2
            boolean r0 = m3599c()
            if (r0 != 0) goto L_0x01c2
            android.location.Location r0 = r1.mo4458d()
            double r4 = r0.getLatitude()
            float r0 = (float) r4
            r2.mo4136a((float) r0)
            android.location.Location r0 = r1.mo4458d()
            double r4 = r0.getLongitude()
            float r0 = (float) r4
            r2.mo4142b((float) r0)
        L_0x01c2:
            java.util.Date r0 = r1.mo4455a()
            if (r0 == 0) goto L_0x01d6
            java.util.Date r0 = r1.mo4455a()
            long r4 = r0.getTime()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            r2.mo4158e((long) r4)
        L_0x01d6:
            com.appbrain.y r0 = r1.mo4457c()
            if (r0 == 0) goto L_0x01f0
            com.appbrain.y r0 = r1.mo4457c()
            com.appbrain.y r3 = com.appbrain.C1137y.UNKNOWN
            if (r0 == r3) goto L_0x01f0
            com.appbrain.y r0 = r1.mo4457c()
            com.appbrain.y r3 = com.appbrain.C1137y.MALE
            if (r0 != r3) goto L_0x026d
            r0 = 1
        L_0x01ed:
            r2.mo4152c((boolean) r0)
        L_0x01f0:
            java.util.Set r0 = r1.mo4456b()
            if (r0 == 0) goto L_0x0270
            java.util.Set r0 = r1.mo4456b()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0270
            r0 = 10
            java.util.Set r1 = r1.mo4456b()
            java.util.Iterator r3 = r1.iterator()
        L_0x020a:
            int r1 = r0 + -1
            if (r0 <= 0) goto L_0x0270
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0270
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            int r4 = r0.length()
            r5 = 15
            if (r4 <= r5) goto L_0x0229
            r4 = 0
            r5 = 15
            java.lang.String r0 = r0.substring(r4, r5)
        L_0x0229:
            r2.mo4186s(r0)
            r0 = r1
            goto L_0x020a
        L_0x022e:
            android.content.Context r0 = r10.f2077e
            com.appbrain.a.dt r0 = com.appbrain.p032a.C0885dt.m3847a((android.content.Context) r0)
            r3 = 5
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
            com.appbrain.a.dw r0 = r0.mo3764a(r3, r6)
            goto L_0x0032
        L_0x023d:
            java.lang.String r0 = r1.mo3435i()
            r2.mo4140a((java.lang.String) r0)
            java.lang.String r0 = r1.mo3434h()
            r2.mo4162f((java.lang.String) r0)
            java.lang.String r0 = r1.mo3433g()
            r2.mo4165g((java.lang.String) r0)
            goto L_0x0066
        L_0x0254:
            int r4 = r0.getType()     // Catch:{ Exception -> 0x0266 }
            int r4 = r4 + 1
            int r4 = r4 * 1000
            int r0 = r0.getSubtype()     // Catch:{ Exception -> 0x0266 }
            int r0 = r0 + r4
            r2.mo4169i((int) r0)     // Catch:{ Exception -> 0x0266 }
            goto L_0x0128
        L_0x0266:
            r0 = move-exception
            r0 = 0
            r2.mo4169i((int) r0)
            goto L_0x0128
        L_0x026d:
            r0 = 0
            goto L_0x01ed
        L_0x0270:
            boolean r0 = r2.mo4168h()
            if (r0 != 0) goto L_0x02cc
            boolean r0 = r10.f2079g
            if (r0 == 0) goto L_0x02cc
            boolean r0 = m3599c()
            if (r0 != 0) goto L_0x02cc
            com.appbrain.a.fm r0 = com.appbrain.p032a.C0932fm.m3968a()
            java.lang.String r1 = "useloc"
            r3 = 1
            int r0 = r0.mo3840a((java.lang.String) r1, (int) r3)
            r1 = 1
            if (r0 != r1) goto L_0x02cc
            r1 = 0
            android.content.Context r0 = r10.f2077e     // Catch:{ Throwable -> 0x02e1 }
            java.lang.String r3 = "location"
            java.lang.Object r0 = r0.getSystemService(r3)     // Catch:{ Throwable -> 0x02e1 }
            android.location.LocationManager r0 = (android.location.LocationManager) r0     // Catch:{ Throwable -> 0x02e1 }
            java.lang.String r3 = "gps"
            android.location.Location r1 = r0.getLastKnownLocation(r3)     // Catch:{ Exception -> 0x02e9 }
        L_0x029f:
            java.lang.String r3 = "network"
            android.location.Location r0 = r0.getLastKnownLocation(r3)     // Catch:{ Exception -> 0x02e7 }
            if (r1 != 0) goto L_0x02d1
        L_0x02a7:
            if (r0 == 0) goto L_0x02ba
            long r4 = r0.getTime()     // Catch:{ Throwable -> 0x02e4 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x02e4 }
            r8 = 3600000(0x36ee80, double:1.7786363E-317)
            long r6 = r6 - r8
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x02ba
            r0 = 0
        L_0x02ba:
            if (r0 == 0) goto L_0x02cc
            double r4 = r0.getLatitude()
            float r1 = (float) r4
            r2.mo4136a((float) r1)
            double r0 = r0.getLongitude()
            float r0 = (float) r0
            r2.mo4142b((float) r0)
        L_0x02cc:
            com.appbrain.f.aa r0 = r2.mo4028d()
            return r0
        L_0x02d1:
            if (r0 == 0) goto L_0x02df
            long r4 = r0.getTime()     // Catch:{ Exception -> 0x02e7 }
            long r6 = r1.getTime()     // Catch:{ Exception -> 0x02e7 }
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x02a7
        L_0x02df:
            r0 = r1
            goto L_0x02a7
        L_0x02e1:
            r0 = move-exception
        L_0x02e2:
            r0 = r1
            goto L_0x02ba
        L_0x02e4:
            r1 = move-exception
            r1 = r0
            goto L_0x02e2
        L_0x02e7:
            r0 = move-exception
            goto L_0x02df
        L_0x02e9:
            r3 = move-exception
            goto L_0x029f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p032a.C0792ah.m3597a(boolean):com.appbrain.f.aa");
    }

    /* renamed from: b */
    private static long m3598b(Context context) {
        if (f2076d == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                f2076d = Long.valueOf(packageInfo == null ? 0 : packageInfo.firstInstallTime);
            } catch (Throwable th) {
                th.printStackTrace();
                f2076d = 0L;
            }
        }
        return f2076d.longValue();
    }

    /* renamed from: c */
    private static boolean m3599c() {
        return C0827bp.m3673b().mo3690c() || f2075c;
    }

    /* renamed from: a */
    public final C1035aa mo3634a() {
        return m3597a(true);
    }

    /* renamed from: b */
    public final C1035aa mo3635b() {
        return m3597a(false);
    }
}
