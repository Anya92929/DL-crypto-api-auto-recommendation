package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: com.google.android.gms.analytics.ad */
class C0155ad implements C0178l {

    /* renamed from: Bi */
    private static C0155ad f149Bi;

    /* renamed from: xz */
    private static Object f150xz = new Object();
    private final Context mContext;

    protected C0155ad(Context context) {
        this.mContext = context;
    }

    /* renamed from: eR */
    public static C0155ad m104eR() {
        C0155ad adVar;
        synchronized (f150xz) {
            adVar = f149Bi;
        }
        return adVar;
    }

    /* renamed from: y */
    public static void m105y(Context context) {
        synchronized (f150xz) {
            if (f149Bi == null) {
                f149Bi = new C0155ad(context);
            }
        }
    }

    /* renamed from: ac */
    public boolean mo3615ac(String str) {
        return "&sr".equals(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: eS */
    public String mo3616eS() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public String getValue(String field) {
        if (field != null && field.equals("&sr")) {
            return mo3616eS();
        }
        return null;
    }
}
