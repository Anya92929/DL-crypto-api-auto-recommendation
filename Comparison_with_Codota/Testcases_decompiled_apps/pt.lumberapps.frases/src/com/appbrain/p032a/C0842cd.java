package com.appbrain.p032a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cmn.C0725at;
import cmn.C0749k;
import cmn.C0752n;
import cmn.C0756r;
import com.appbrain.p037f.C1040af;
import com.appbrain.p037f.C1054at;
import com.appbrain.p037f.C1063bb;
import com.appbrain.p037f.C1065bd;
import com.appbrain.p037f.C1067bf;
import com.appbrain.p037f.C1069bh;
import com.appbrain.p037f.C1070bi;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.appbrain.a.cd */
public class C0842cd {

    /* renamed from: a */
    private static final String f2219a = C0842cd.class.getSimpleName();

    /* renamed from: b */
    private static final String[] f2220b = {"market://", "http://play.google.com", "https://play.google.com", "http://market.android.com", "https://market.android.com"};

    /* renamed from: c */
    private static Boolean f2221c = null;

    /* renamed from: a */
    public static long m3715a(Context context) {
        C1067bf a;
        C1069bh bhVar;
        Set set;
        C1069bh bhVar2;
        long j;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = Long.MAX_VALUE;
        C0932fm a2 = C0932fm.m3968a();
        boolean equals = a2.mo3841a("run", "1").equals("1");
        Set set2 = null;
        List<PackageInfo> a3 = C0749k.m3266a(context, 10000);
        HashSet hashSet = new HashSet(a3.size());
        for (PackageInfo packageInfo : a3) {
            hashSet.add(packageInfo.packageName);
        }
        SharedPreferences b = a2.mo3843b();
        for (Map.Entry next : b.getAll().entrySet()) {
            if (((String) next.getKey()).startsWith(C1040af.CLICK.toString()) && (a = C0860cv.m3772a(next.getValue())) != null) {
                C1063bb h = a.mo4295h();
                String j3 = h.mo4267j();
                int l = a.mo4299l();
                boolean contains = hashSet.contains(j3);
                long p = elapsedRealtime - h.mo4273p();
                new StringBuilder("Checking installs for: ").append(j3).append(", status: ").append(l).append(", ran: ").append(h.mo4280w()).append(", installed: ").append(contains);
                if (equals) {
                    Set a4 = set2 == null ? m3718a(context, (Set) hashSet) : set2;
                    if (a4.contains(j3)) {
                        C1069bh n = a.mo4027d();
                        n.mo4303a(n.mo4295h().mo4027d().mo4282a(h.mo4280w() + 1));
                        C1069bh bhVar3 = n;
                        set = a4;
                        bhVar = bhVar3;
                    } else if (!h.mo4279v()) {
                        C1069bh n2 = a.mo4027d();
                        n2.mo4303a(n2.mo4295h().mo4027d().mo4282a(0));
                        C1069bh bhVar4 = n2;
                        set = a4;
                        bhVar = bhVar4;
                    } else {
                        set = a4;
                        bhVar = null;
                    }
                } else {
                    bhVar = null;
                    set = set2;
                }
                if (l != 0 || !contains) {
                    if (l == 1 && !contains) {
                        if (bhVar == null) {
                            bhVar = a.mo4027d();
                        }
                        bhVar.mo4301a(2);
                        m3719a(context, (C1070bi) bhVar, C1040af.UNINSTALL);
                    }
                    set2 = set;
                } else {
                    if (bhVar == null) {
                        bhVar = a.mo4027d();
                    }
                    bhVar.mo4301a(1);
                    C0932fm.m3968a().mo3854m();
                    m3719a(context, (C1070bi) bhVar, C1040af.INSTALL);
                    if (TextUtils.equals(m3717a(h.mo4276s(), "as"), "1")) {
                        try {
                            if (p < ((long) a2.mo3840a("asmd", 900)) * 1000) {
                                if (set == null) {
                                    set = m3718a(context, (Set) hashSet);
                                }
                                if (!set.contains(j3)) {
                                    C0749k.m3270b(context, j3);
                                }
                            }
                            set2 = set;
                        } catch (Throwable th) {
                        }
                    }
                    set2 = set;
                }
                if (p < 300000) {
                    bhVar2 = bhVar;
                    j = 30000;
                } else if (p < 900000) {
                    bhVar2 = bhVar;
                    j = 120000;
                } else if (p < 3600000) {
                    bhVar2 = bhVar;
                    j = 300000;
                } else if (p < 93600000) {
                    bhVar2 = bhVar;
                    j = 1800000;
                } else {
                    if (l != 3) {
                        if (bhVar == null) {
                            bhVar = a.mo4027d();
                        }
                        bhVar.mo4303a(bhVar.mo4295h().mo4027d().mo4288a(contains));
                        bhVar.mo4301a(3);
                        m3719a(context, (C1070bi) bhVar, C1040af.FINAL_CHECK);
                    }
                    bhVar2 = bhVar;
                    j = Long.MAX_VALUE;
                }
                if (bhVar2 != null) {
                    b.edit().putString(C1040af.CLICK + j3, C0756r.m3308a(bhVar2.mo4028d().mo3915b())).apply();
                }
                j2 = Math.min(j2, j);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return -1;
        }
        return j2;
    }

    /* renamed from: a */
    private static C1063bb m3716a(String str, C1040af afVar, String str2, String str3) {
        C1065bd x = C1063bb.m4780x();
        x.mo4287a(str);
        x.mo4285a(afVar);
        x.mo4289b(SystemClock.elapsedRealtime());
        x.mo4283a(System.currentTimeMillis());
        x.mo4290b(str2);
        x.mo4291c(str3);
        return x.mo4028d();
    }

    /* renamed from: a */
    public static String m3717a(String str, String str2) {
        for (String split : str.split("&")) {
            String[] split2 = split.split("=", 2);
            if (split2.length == 2 && split2[0].equalsIgnoreCase(str2)) {
                return split2[1];
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Set m3718a(Context context, Set set) {
        HashSet hashSet = new HashSet();
        try {
            for (C0852cn cnVar : C0850cl.m3747a(context, set)) {
                hashSet.add(cnVar.f2258a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashSet;
    }

    /* renamed from: a */
    private static void m3719a(Context context, C1070bi biVar, C1040af afVar) {
        String j = biVar.mo4295h().mo4267j();
        long n = biVar.mo4295h().mo4271n();
        String str = "time=" + (n / 1000) + "&delta=" + ((System.currentTimeMillis() - n) / 1000);
        C1065bd y = biVar.mo4295h().mo4027d();
        y.mo4285a(afVar);
        y.mo4289b(SystemClock.elapsedRealtime());
        y.mo4283a(System.currentTimeMillis());
        y.mo4291c(str);
        C1069bh m = C1067bf.m4830m();
        m.mo4305a(false);
        m.mo4303a(y);
        m.mo4301a(biVar.mo4299l());
        C0860cv.m3774a(context, afVar, j, m.mo4028d());
    }

    /* renamed from: a */
    public static void m3720a(Context context, String str, C0844cf cfVar) {
        if (!m3728b(context, str, cfVar)) {
            C0934fo.m3999a(context, str, cfVar);
        }
    }

    /* renamed from: a */
    static void m3721a(Context context, String str, String str2, String str3) {
        C1069bh m = C1067bf.m4830m();
        m.mo4302a(m3716a(str, C1040af.CLICK, str2, str3));
        m.mo4305a(false);
        m.mo4301a(0);
        C0860cv.m3774a(context, C1040af.CLICK, str, m.mo4028d());
        if (!m3726b(context)) {
            C0860cv.m3773a(context);
        }
    }

    /* renamed from: a */
    static void m3722a(WebView webView) {
        SharedPreferences b = C0932fm.m3968a().mo3843b();
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.getLong("last_cache_clear", 0);
        if (j != 0 && currentTimeMillis >= j) {
            if (currentTimeMillis > 259200000 + j) {
                webView.clearCache(true);
            } else {
                currentTimeMillis = j;
            }
        }
        if (currentTimeMillis != j) {
            b.edit().putLong("last_cache_clear", currentTimeMillis).apply();
        }
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setBlockNetworkImage(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("UTF-8");
    }

    /* renamed from: a */
    static boolean m3723a(Context context, Uri uri) {
        try {
            context.startActivity(m3729c(context, uri));
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m3724a(Uri uri, String str) {
        try {
            for (String split : uri.getQuery().split("&")) {
                String[] split2 = split.split("=", 2);
                if (split2.length == 2 && split2[1].equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m3725a(String str) {
        return str.startsWith("http://") || str.startsWith("https://");
    }

    /* renamed from: b */
    private static synchronized boolean m3726b(Context context) {
        boolean booleanValue;
        synchronized (C0842cd.class) {
            if (f2221c == null) {
                try {
                    context.getPackageManager().getReceiverInfo(new ComponentName(context, "com.appspot.swisscodemonkeys.featured.InstallBroadcastReceiver"), 0);
                    f2221c = true;
                } catch (PackageManager.NameNotFoundException e) {
                    f2221c = false;
                }
            }
            booleanValue = f2221c.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: b */
    private static boolean m3727b(Context context, Uri uri) {
        try {
            Intent c = m3729c(context, uri);
            for (ResolveInfo next : context.getPackageManager().queryIntentActivities(c, 65536)) {
                if (next.activityInfo.packageName.equals("com.android.vending")) {
                    c.setClassName(next.activityInfo.packageName, next.activityInfo.name);
                    context.startActivity(c);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: b */
    static boolean m3728b(Context context, String str, C0844cf cfVar) {
        boolean z;
        Uri parse = Uri.parse(str);
        if (cfVar != null) {
            String[] strArr = f2220b;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (str.startsWith(strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z && !m3724a(parse, cfVar.f2225b) && m3730c(context, str, cfVar)) {
                return true;
            }
        }
        if (!m3727b(context, parse)) {
            return !m3725a(str) && m3723a(context, parse);
        }
        return true;
    }

    /* renamed from: c */
    private static Intent m3729c(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (C0725at.m3226a(context) == null) {
            intent.addFlags(268435456);
            intent.addFlags(8388608);
        }
        intent.setData(uri);
        return intent;
    }

    /* renamed from: c */
    static boolean m3730c(Context context, String str, C0844cf cfVar) {
        if (cfVar == null) {
            return false;
        }
        new StringBuilder("Handling invalid URL: ").append(str).append(", ").append(cfVar.f2225b);
        boolean z = C0752n.m3278b().mo3436j() >= 0;
        if (cfVar.f2224a && z) {
            C0860cv.m3774a(context, C1040af.INVALID_URL, cfVar.f2225b, C1067bf.m4830m().mo4302a(m3716a(cfVar.f2225b, C1040af.INVALID_URL, cfVar.f2226c, str)).mo4028d());
        }
        if (cfVar.f2228e) {
            return false;
        }
        Uri parse = Uri.parse("market://details?id=" + cfVar.f2225b + "&referrer=utm_source%3Dappbrain%26utm_medium%3Dpromoted%26utm_campaign%3Dappbrain_cpi");
        if (m3727b(context, parse) || m3723a(context, parse)) {
            return true;
        }
        if (z) {
            return false;
        }
        C0934fo.m3998a(context, new C0936fq(C1054at.NO_PLAY_STORE));
        return true;
    }
}
