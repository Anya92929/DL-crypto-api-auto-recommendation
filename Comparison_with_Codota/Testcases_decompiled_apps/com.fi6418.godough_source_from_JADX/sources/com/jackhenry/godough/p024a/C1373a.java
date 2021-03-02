package com.jackhenry.godough.p024a;

import android.content.Context;
import com.jackhenry.godough.p024a.p025a.C1374a;
import com.jackhenry.godough.p024a.p025a.C1375b;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.jackhenry.godough.a.a */
public class C1373a {

    /* renamed from: a */
    private static String[] f5710a;

    /* renamed from: b */
    private static ArrayList<C1376b<?>> f5711b = new ArrayList<>();

    /* renamed from: c */
    private static ArrayList<Integer> f5712c = new ArrayList<>();

    /* renamed from: d */
    private static String f5713d;

    /* renamed from: a */
    public static void m5613a() {
        Iterator<Integer> it = f5712c.iterator();
        while (it.hasNext()) {
            f5711b.get(it.next().intValue()).mo9427b();
        }
    }

    /* renamed from: a */
    public static void m5614a(Context context, int i, String str) {
        if (context.getResources().getBoolean(C1383f.sendAnalyticsData)) {
            f5711b.add(new C1380c(context, i, str));
            f5712c.add(0);
        }
    }

    /* renamed from: a */
    private static void m5615a(C1374a aVar) {
        Iterator<C1376b<?>> it = f5711b.iterator();
        while (it.hasNext()) {
            it.next().mo9425a(aVar, m5622c());
        }
    }

    /* renamed from: a */
    public static void m5616a(String str) {
        Iterator<C1376b<?>> it = f5711b.iterator();
        while (it.hasNext()) {
            it.next().mo9428b(str);
        }
        m5619b(str);
    }

    /* renamed from: a */
    public static void m5617a(String str, String str2, String str3) {
        m5615a(new C1374a(str, str2, str3, m5621b()));
    }

    /* renamed from: a */
    public static void m5618a(String[] strArr) {
        m5620b(strArr);
        C1374a aVar = new C1374a(m5621b());
        if (aVar.mo9420e().equals("SplashActivity")) {
            aVar.mo9414a(C1375b.START_SESSION);
        }
        m5615a(aVar);
    }

    /* renamed from: b */
    public static void m5619b(String str) {
        f5713d = str;
    }

    /* renamed from: b */
    public static void m5620b(String[] strArr) {
        f5710a = strArr;
    }

    /* renamed from: b */
    public static String[] m5621b() {
        return f5710a;
    }

    /* renamed from: c */
    public static String m5622c() {
        return f5713d;
    }
}
