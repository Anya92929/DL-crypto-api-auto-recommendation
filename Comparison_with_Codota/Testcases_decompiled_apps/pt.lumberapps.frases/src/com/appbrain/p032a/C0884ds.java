package com.appbrain.p032a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ListAdapter;
import com.appbrain.C0984b;
import com.appbrain.C1025d;
import com.appbrain.C1107h;
import com.appbrain.p037f.C1054at;

/* renamed from: com.appbrain.a.ds */
public final class C0884ds implements C1107h {

    /* renamed from: a */
    private static final C0884ds f2350a = new C0884ds();

    private C0884ds() {
    }

    /* renamed from: a */
    public static C0884ds m3834a() {
        return f2350a;
    }

    /* renamed from: a */
    private static C0984b m3835a(Context context, ListAdapter listAdapter, C0804at atVar) {
        return listAdapter == null ? new C0848cj(context, atVar) : new C0784a(context, listAdapter, atVar);
    }

    /* renamed from: a */
    public static void m3836a(Context context, String str) {
        C0926fg.m3925a().mo3817a(context, true, false);
        if (C0926fg.m3925a().mo3820d()) {
            C0936fq fqVar = new C0936fq(C1054at.DIRECT);
            fqVar.f2455c = str;
            C0934fo.m3998a(context, fqVar);
        }
    }

    /* renamed from: a */
    private static boolean m3837a(boolean z) {
        int a;
        boolean z2;
        if (C0926fg.m3925a().mo3820d() && m3840c() && (a = C0932fm.m3968a().mo3840a("offerwall", 86400)) > 0) {
            SharedPreferences b = C0932fm.m3968a().mo3843b();
            long max = Math.max(b.getLong("last_offer_wall_shown", 0), b.getLong("last_offer_time", 0));
            long currentTimeMillis = System.currentTimeMillis();
            if (System.currentTimeMillis() > (((long) a) * 1000) + max) {
                if (z) {
                    b.edit().putLong("last_offer_time", System.currentTimeMillis()).apply();
                }
                z2 = true;
            } else {
                if (max > currentTimeMillis) {
                    b.edit().putLong("last_offer_time", System.currentTimeMillis()).apply();
                }
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static void m3838b() {
        SharedPreferences.Editor edit = C0932fm.m3968a().mo3843b().edit();
        edit.putLong("last_offer_wall_shown", System.currentTimeMillis());
        edit.apply();
    }

    /* renamed from: b */
    public static void m3839b(Context context, String str) {
        if (C0926fg.m3925a().mo3820d()) {
            C0936fq fqVar = new C0936fq(C1054at.DIRECT_CLICK);
            fqVar.f2455c = str;
            fqVar.f2457e = true;
            C0934fo.m3998a(context, fqVar);
        }
    }

    /* renamed from: c */
    public static boolean m3840c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C0926fg.m3925a().mo3819c().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        } catch (RuntimeException e) {
            return true;
        }
    }

    /* renamed from: a */
    public final C0984b mo3693a(Context context, ListAdapter listAdapter) {
        return m3835a(context, listAdapter, new C0804at());
    }

    /* renamed from: a */
    public final boolean mo3694a(Context context) {
        C0926fg.m3925a().mo3817a(context, true, false);
        return m3837a(false);
    }

    /* renamed from: a */
    public final boolean mo3695a(Context context, C1025d dVar) {
        C0926fg.m3925a().mo3817a(context, true, false);
        if (m3837a(true)) {
            C0934fo.m4000a(context, true, dVar);
            return true;
        }
        C0926fg.m3925a().mo3822f();
        return false;
    }

    /* renamed from: b */
    public final boolean mo3696b(Context context) {
        return mo3697b(context, (C1025d) null);
    }

    /* renamed from: b */
    public final boolean mo3697b(Context context, C1025d dVar) {
        C0926fg.m3925a().mo3817a(context, true, false);
        if (!C0926fg.m3925a().mo3820d() || !m3840c()) {
            C0926fg.m3925a().mo3822f();
            return false;
        }
        C0934fo.m4000a(context, false, dVar);
        return true;
    }

    /* renamed from: c */
    public final void mo3698c(Context context) {
        m3836a(context, (String) null);
    }
}
