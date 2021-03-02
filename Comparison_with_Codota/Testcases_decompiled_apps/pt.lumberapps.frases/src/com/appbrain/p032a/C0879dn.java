package com.appbrain.p032a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import cmn.C0726au;
import cmn.C0749k;
import cmn.C0752n;
import cmn.C0756r;
import com.appbrain.p033b.C1008l;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.appbrain.a.dn */
public class C0879dn {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f2338a = C0879dn.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Set f2339b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final AtomicBoolean f2340c = new AtomicBoolean(false);

    /* renamed from: d */
    private static volatile long f2341d = 0;

    static {
        HashSet hashSet = new HashSet();
        f2339b = hashSet;
        hashSet.add("com.android.vending");
        f2339b.add("com.google.android.feedback");
    }

    /* renamed from: a */
    public static long m3812a() {
        return C0932fm.m3968a().mo3843b().getLong("pref_ola", 0);
    }

    /* renamed from: a */
    public static void m3813a(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < f2341d) {
            f2341d = currentTimeMillis;
        }
        if (currentTimeMillis > f2341d + 3600000 && f2340c.compareAndSet(false, true)) {
            f2341d = currentTimeMillis;
            C0726au.m3237a((Runnable) new C0880do(context));
        }
    }

    /* renamed from: b */
    public static int m3814b() {
        return C0932fm.m3968a().mo3843b().getInt("pref_ac", -1);
    }

    /* renamed from: b */
    static /* synthetic */ void m3815b(Context context) {
        int i = 0;
        SharedPreferences b = C0932fm.m3968a().mo3843b();
        try {
            C0881dp a = C0881dp.m3822a();
            a.mo3757a(b.getLong("pref_ola", System.currentTimeMillis()));
            List<PackageInfo> a2 = C0749k.m3266a(context, 60000);
            HashSet hashSet = new HashSet(a2.size());
            PackageManager packageManager = context.getPackageManager();
            for (PackageInfo packageInfo : a2) {
                hashSet.add(packageInfo.packageName);
                a.mo3758a(packageInfo, packageManager.getInstallerPackageName(packageInfo.packageName));
            }
            List<C0852cn> a3 = C0850cl.m3747a(context, hashSet);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C1008l a4 = C1008l.m4211a((OutputStream) byteArrayOutputStream);
            for (C0852cn cnVar : a3) {
                if ("com.android.vending".equals(packageManager.getInstallerPackageName(cnVar.f2258a))) {
                    new StringBuilder("Adding active app: ").append(cnVar);
                    a4.mo4005e(Math.max(1, cnVar.f2259b / 10));
                    a4.mo4006f((int) C0752n.m3281d(cnVar.f2258a));
                    int i2 = i + 1;
                    if (i2 >= 16) {
                        break;
                    }
                    i = i2;
                }
            }
            a4.mo4005e(0);
            a4.mo3992a();
            String b2 = C0756r.m3312b(byteArrayOutputStream.toByteArray());
            SharedPreferences.Editor edit = b.edit();
            if (b2 != null) {
                edit.putString("pref_aav", b2);
            }
            edit.putString("pref_tv", a.mo3759b());
            edit.putLong("pref_ola", a.f2343a);
            edit.putInt("pref_ac", a.f2344b);
            edit.apply();
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public static byte[] m3816c() {
        String string = C0932fm.m3968a().mo3843b().getString("pref_tv", (String) null);
        if (string == null) {
            return null;
        }
        try {
            return C0756r.m3313b(string);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static byte[] m3817d() {
        String string = C0932fm.m3968a().mo3843b().getString("pref_aav", (String) null);
        if (string == null) {
            return null;
        }
        try {
            return C0756r.m3313b(string);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
