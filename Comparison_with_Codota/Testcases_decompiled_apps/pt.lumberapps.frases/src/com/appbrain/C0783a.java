package com.appbrain;

import android.util.Log;
import cmn.C0752n;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.appbrain.a */
public class C0783a implements Serializable {

    /* renamed from: a */
    public static final C0783a f2047a = new C0783a(0, "DEFAULT");

    /* renamed from: b */
    public static final C0783a f2048b = new C0783a(1, "HOME_SCREEN");

    /* renamed from: c */
    public static final C0783a f2049c = new C0783a(2, "STARTUP");

    /* renamed from: d */
    public static final C0783a f2050d = new C0783a(3, "PAUSE");

    /* renamed from: e */
    public static final C0783a f2051e = new C0783a(4, "EXIT");

    /* renamed from: f */
    public static final C0783a f2052f = new C0783a(5, "LEVEL_START");

    /* renamed from: g */
    public static final C0783a f2053g = new C0783a(6, "LEVEL_COMPLETE");

    /* renamed from: h */
    public static final C0783a f2054h = new C0783a(7, "ACHIEVEMENTS");

    /* renamed from: i */
    public static final C0783a f2055i = new C0783a(8, "LEADERBOARDS");

    /* renamed from: j */
    public static final C0783a f2056j = new C0783a(9, "STORE");

    /* renamed from: k */
    private static final Map f2057k;

    /* renamed from: l */
    private final int f2058l;

    /* renamed from: m */
    private final String f2059m;

    /* renamed from: n */
    private final boolean f2060n;

    /* renamed from: o */
    private final boolean f2061o;

    static {
        C0783a[] aVarArr = {f2047a, f2048b, f2049c, f2050d, f2051e, f2052f, f2053g, f2054h, f2055i, f2056j};
        HashMap hashMap = new HashMap(10);
        for (int i = 0; i < 10; i++) {
            C0783a aVar = aVarArr[i];
            hashMap.put(aVar.f2059m, aVar);
        }
        f2057k = Collections.unmodifiableMap(hashMap);
    }

    private C0783a(int i, String str) {
        this(i, str, true, true);
    }

    private C0783a(int i, String str, boolean z, boolean z2) {
        this.f2058l = i;
        this.f2059m = str;
        this.f2060n = z;
        this.f2061o = z2;
    }

    /* renamed from: a */
    public static C0783a m3581a(String str) {
        if (str == null) {
            return null;
        }
        String upperCase = str.toUpperCase();
        if (m3583c(upperCase)) {
            return new C0783a(Integer.parseInt(upperCase.substring(4, 6), 16), "CUSTOM('" + str + "')", upperCase.startsWith("INT-"), upperCase.startsWith("BAN-"));
        }
        Log.println(6, "AppBrain", "Invalid custom id string '" + str + "'. Using no ad id instead.");
        return null;
    }

    /* renamed from: b */
    public static C0783a m3582b(String str) {
        if (str == null) {
            return null;
        }
        C0783a aVar = (C0783a) f2057k.get(str.toUpperCase());
        return aVar == null ? m3581a(str) : aVar;
    }

    /* renamed from: c */
    private static boolean m3583c(String str) {
        return str.length() == 10 && m3584d(str.substring(4)) && m3585e(str.substring(0, 6)).equals(str.substring(6));
    }

    /* renamed from: d */
    private static boolean m3584d(String str) {
        for (char indexOf : str.toCharArray()) {
            if ("0123456789ABCDEF".indexOf(indexOf) == -1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    private static String m3585e(String str) {
        return String.format("%04X", new Object[]{Long.valueOf(C0752n.m3281d(str + C0752n.m3278b().mo3429c()) & 65535)});
    }

    /* renamed from: a */
    public int mo3616a() {
        return this.f2058l;
    }

    /* renamed from: b */
    public boolean mo3617b() {
        return this.f2060n;
    }

    /* renamed from: c */
    public boolean mo3618c() {
        return this.f2061o;
    }

    public String toString() {
        return this.f2059m;
    }
}
