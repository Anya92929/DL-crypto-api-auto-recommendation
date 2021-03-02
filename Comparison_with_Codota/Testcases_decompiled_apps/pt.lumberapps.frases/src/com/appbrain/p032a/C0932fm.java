package com.appbrain.p032a;

import android.content.Context;
import android.content.SharedPreferences;
import com.appbrain.C0983ad;
import com.appbrain.p037f.C1086n;
import com.appbrain.p037f.C1090r;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.appbrain.a.fm */
public final class C0932fm {

    /* renamed from: a */
    private static C0932fm f2444a;

    /* renamed from: b */
    private final SharedPreferences f2445b;

    /* renamed from: c */
    private final C0983ad f2446c;

    /* renamed from: d */
    private final C0983ad f2447d;

    private C0932fm(Context context) {
        this.f2445b = context.getSharedPreferences("ab_sdk_pref", 0);
        this.f2446c = new C0933fn(context.getSharedPreferences("ab_pref_int", 0));
        this.f2447d = new C0933fn(context.getSharedPreferences("ab_pref_ext", 0));
    }

    /* renamed from: a */
    public static synchronized C0932fm m3968a() {
        C0932fm fmVar;
        synchronized (C0932fm.class) {
            fmVar = f2444a;
        }
        return fmVar;
    }

    /* renamed from: a */
    static synchronized C0932fm m3969a(Context context) {
        C0932fm fmVar;
        synchronized (C0932fm.class) {
            if (f2444a == null) {
                f2444a = new C0932fm(context);
            }
            fmVar = f2444a;
        }
        return fmVar;
    }

    /* renamed from: a */
    static void m3970a(Context context, C1086n nVar) {
        if ((nVar.mo4350m() && nVar.mo4351n()) || nVar.mo4347j() > 0) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ab_pref_ext", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (nVar.mo4350m() && nVar.mo4351n()) {
                for (String remove : sharedPreferences.getAll().keySet()) {
                    edit.remove(remove);
                }
            }
            m3971a(nVar.mo4346i(), edit);
            edit.apply();
        }
        if ((nVar.mo4348k() && nVar.mo4349l()) || nVar.mo4345h() > 0) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("ab_pref_int", 0);
            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
            if (nVar.mo4348k() && nVar.mo4349l()) {
                for (String remove2 : sharedPreferences2.getAll().keySet()) {
                    edit2.remove(remove2);
                }
            }
            m3971a(nVar.mo4344g(), edit2);
            edit2.apply();
        }
    }

    /* renamed from: a */
    private static void m3971a(List list, SharedPreferences.Editor editor) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1090r rVar = (C1090r) it.next();
            if (!rVar.mo4358k() || !rVar.mo4359l()) {
                editor.putString(rVar.mo4355h(), rVar.mo4357j());
            } else {
                editor.remove(rVar.mo4355h());
            }
        }
    }

    /* renamed from: b */
    private void m3972b(String str) {
        this.f2445b.edit().putInt(str, this.f2445b.getInt(str, 0) + 1).apply();
    }

    /* renamed from: a */
    public final double mo3839a(String str, double d) {
        String a = this.f2446c.mo3856a(str);
        if (a == null) {
            return d;
        }
        try {
            return Double.parseDouble(a);
        } catch (Exception e) {
            return d;
        }
    }

    /* renamed from: a */
    public final int mo3840a(String str, int i) {
        String a = this.f2446c.mo3856a(str);
        if (a == null) {
            return i;
        }
        try {
            return Integer.parseInt(a);
        } catch (Throwable th) {
            return i;
        }
    }

    /* renamed from: a */
    public final String mo3841a(String str, String str2) {
        return this.f2446c.mo3857a(str, str2);
    }

    /* renamed from: a */
    public final void mo3842a(String str) {
        this.f2445b.edit().putString("ref", str).apply();
    }

    /* renamed from: b */
    public final SharedPreferences mo3843b() {
        return this.f2445b;
    }

    /* renamed from: c */
    public final C0983ad mo3844c() {
        return this.f2447d;
    }

    /* renamed from: d */
    public final String mo3845d() {
        return this.f2445b.getString("ref", (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo3846e() {
        m3972b("init_called2");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final int mo3847f() {
        return this.f2445b.getInt("init_called2", 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo3848g() {
        m3972b("pingcount");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final int mo3849h() {
        return this.f2445b.getInt("pingcount", 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final void mo3850i() {
        m3972b("ow_imp");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final int mo3851j() {
        return this.f2445b.getInt("ow_imp", 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final void mo3852k() {
        m3972b("ow_click");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final int mo3853l() {
        return this.f2445b.getInt("ow_click", 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final void mo3854m() {
        m3972b("ow_inst");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final int mo3855n() {
        return this.f2445b.getInt("ow_inst", 0);
    }
}
