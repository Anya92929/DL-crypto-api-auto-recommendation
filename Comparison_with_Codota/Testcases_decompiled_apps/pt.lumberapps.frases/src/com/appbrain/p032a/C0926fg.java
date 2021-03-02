package com.appbrain.p032a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import cmn.C0709ad;
import cmn.C0725at;
import cmn.C0752n;
import java.util.Set;

/* renamed from: com.appbrain.a.fg */
public final class C0926fg {

    /* renamed from: a */
    private static final C0926fg f2421a = new C0926fg();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f2422b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0932fm f2423c;

    /* renamed from: d */
    private boolean f2424d = true;

    /* renamed from: e */
    private boolean f2425e = true;

    /* renamed from: f */
    private String f2426f;

    /* renamed from: g */
    private Set f2427g;

    /* renamed from: h */
    private C0858ct f2428h;

    /* renamed from: i */
    private Activity f2429i;

    private C0926fg() {
    }

    /* renamed from: a */
    public static C0926fg m3925a() {
        return f2421a;
    }

    /* renamed from: h */
    private String m3927h() {
        if (this.f2426f == null) {
            String string = Settings.Secure.getString(this.f2422b.getContentResolver(), "android_id");
            if (string == null) {
                string = "testtest";
            }
            this.f2426f = Long.toHexString(C0752n.m3281d(string));
        }
        return this.f2426f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A[ExcHandler: NoSuchMethodException (e java.lang.NoSuchMethodException), Splitter:B:1:0x0009] */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3928i() {
        /*
            r9 = this;
            r7 = 17
            r1 = 1
            r2 = 0
            java.lang.Class<com.appbrain.a.ap> r0 = com.appbrain.p032a.C0800ap.class
            java.lang.String r3 = "isPackageInstalled"
            r4 = 1
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0067 }
            r5 = 0
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r4[r5] = r6     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0067 }
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0067 }
            java.lang.String r3 = r0.getName()     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0067 }
            java.lang.String r4 = "isPackage"
            boolean r3 = r3.contains(r4)     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0067 }
            if (r3 != 0) goto L_0x0077
            r3 = r2
        L_0x0021:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            if (r4 < r7) goto L_0x0075
            android.content.Context r4 = r9.f2422b     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            android.content.Context r5 = r9.f2422b     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            r6 = 0
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            int r4 = r4.targetSdkVersion     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            if (r4 < r7) goto L_0x0075
            java.lang.annotation.Annotation[] r4 = r0.getAnnotations()     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            if (r4 == 0) goto L_0x005f
            java.lang.annotation.Annotation[] r5 = r0.getAnnotations()     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            int r6 = r5.length     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            r4 = r2
            r0 = r2
        L_0x0047:
            if (r4 >= r6) goto L_0x0060
            r7 = r5[r4]     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            java.lang.Class r7 = r7.annotationType()     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            java.lang.String r7 = r7.getName()     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            java.lang.String r8 = "JavascriptInterface"
            boolean r7 = r7.contains(r8)     // Catch:{ NoSuchMethodException -> 0x0064, NameNotFoundException -> 0x0072 }
            if (r7 == 0) goto L_0x005c
            r0 = r1
        L_0x005c:
            int r4 = r4 + 1
            goto L_0x0047
        L_0x005f:
            r0 = r2
        L_0x0060:
            if (r0 != 0) goto L_0x0075
            r0 = r2
        L_0x0063:
            return r0
        L_0x0064:
            r0 = move-exception
            r0 = r2
            goto L_0x0063
        L_0x0067:
            r0 = move-exception
            r0 = r1
        L_0x0069:
            r1 = 6
            java.lang.String r2 = "AppBrain"
            java.lang.String r3 = "Couldn't find current app on the system."
            android.util.Log.println(r1, r2, r3)
            goto L_0x0063
        L_0x0072:
            r0 = move-exception
            r0 = r3
            goto L_0x0069
        L_0x0075:
            r0 = r3
            goto L_0x0063
        L_0x0077:
            r3 = r1
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p032a.C0926fg.m3928i():boolean");
    }

    /* renamed from: a */
    public final synchronized void mo3816a(Activity activity) {
        this.f2429i = activity;
    }

    /* renamed from: a */
    public final synchronized void mo3817a(Context context, boolean z, boolean z2) {
        boolean z3 = true;
        synchronized (this) {
            boolean z4 = this.f2422b == null;
            this.f2422b = context.getApplicationContext();
            C0752n.m3276a(this.f2422b);
            C0885dt.m3847a(this.f2422b);
            C0752n.m3275a();
            C0827bp.m3672a();
            this.f2423c = C0932fm.m3969a(this.f2422b);
            C0709ad.m3187a(this.f2422b);
            if (("com.android.vending".equals(C0752n.m3278b().mo3431e()) || Build.BRAND.contains("GeneralMobile")) ? false : z4) {
                try {
                    this.f2422b.getPackageManager().getActivityInfo(new ComponentName(this.f2422b, "com.appbrain.AppBrainActivity"), 0);
                    this.f2422b.getPackageManager().getServiceInfo(new ComponentName(this.f2422b, "com.appbrain.AppBrainService"), 0);
                    if (this.f2422b.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                        throw new IllegalStateException("Add the INTERNET permission to your Android manifest!");
                    }
                    this.f2425e = m3928i();
                    if (!this.f2425e) {
                        Log.println(6, "AppBrain", "AppBrain SDK requires changes to your proguard config as detailed in the documentation!");
                        Toast.makeText(this.f2422b, "AppBrain SDK requires changes to your proguard config as detailed in the documentation!", 1).show();
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalStateException("No AppBrainService defined in the manifest!");
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalStateException("No AppBrainActivity defined in the manifest!");
                }
            }
            if (z4) {
                C0860cv.m3773a(this.f2422b);
            }
            C0879dn.m3813a(this.f2422b);
            if (z) {
                if (z2) {
                    this.f2423c.mo3846e();
                }
                String h = m3927h();
                if (this.f2427g == null || !this.f2427g.contains(h)) {
                    z3 = false;
                }
                if (z3) {
                    Log.println(5, "AppBrain", "AppBrain is running in test mode for device: " + h);
                } else {
                    Log.println(4, "AppBrain", "To run AppBrain in test mode on this device, call AppBrain.addTestDevice(\"" + h + "\") before calling AppBrain.init().");
                }
                if (this.f2428h == null) {
                    this.f2428h = new C0928fi(this, "ping", ((long) (z3 ? this.f2423c.mo3840a("test_ping_interval", 30) : this.f2423c.mo3840a("ping_interval", 86400))) * 1000);
                }
                this.f2428h.mo3735b(this.f2422b);
            }
            if (this.f2423c.mo3840a("sdk_off", 0) != 0) {
                this.f2424d = false;
            }
            C0870de.m3790a(this.f2422b).mo3743a();
            C0725at.m3234b((Runnable) new C0927fh(this, context));
        }
    }

    /* renamed from: b */
    public final synchronized boolean mo3818b() {
        return this.f2422b != null;
    }

    /* renamed from: c */
    public final synchronized Context mo3819c() {
        return this.f2422b;
    }

    /* renamed from: d */
    public final synchronized boolean mo3820d() {
        return this.f2424d;
    }

    /* renamed from: e */
    public final synchronized boolean mo3821e() {
        return this.f2425e;
    }

    /* renamed from: f */
    public final synchronized void mo3822f() {
        if (this.f2429i != null) {
            this.f2429i.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final synchronized boolean mo3823g() {
        return this.f2427g != null && this.f2427g.contains(m3927h());
    }
}
