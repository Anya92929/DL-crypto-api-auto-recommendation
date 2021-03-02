package com.jackhenry.godough.p024a;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.analytics.C0580k;
import com.google.android.gms.analytics.C0581l;
import com.google.android.gms.analytics.C0583n;
import com.google.android.gms.analytics.C0584o;
import com.google.android.gms.analytics.C0586q;
import com.google.android.gms.analytics.C0589t;
import com.google.android.gms.analytics.p016a.C0502a;
import com.google.android.gms.analytics.p016a.C0503b;
import com.jackhenry.godough.p024a.p025a.C1374a;
import com.jackhenry.godough.p024a.p025a.C1375b;
import com.jackhenry.godough.p024a.p026b.C1378b;
import com.jackhenry.godough.p024a.p026b.C1379c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.jackhenry.godough.a.c */
public class C1380c extends C1376b<C0589t> {

    /* renamed from: b */
    private String f5736b = "";

    /* renamed from: c */
    private int f5737c = 0;

    /* renamed from: d */
    private String f5738d;

    /* renamed from: e */
    private HashMap<String, HashMap<String, String>> f5739e;

    public C1380c(Context context, int i, String str) {
        this.f5736b = context.getString(C1385h.jha_google_id);
        C0581l a = C0581l.m3407a(context);
        a.mo6909g().mo6758a(context.getResources().getInteger(C1384g.GAloglevel));
        mo9426a("primaryTracker", a.mo6902a(this.f5736b));
        this.f5739e = new C1378b().mo9431a();
        this.f5737c = i;
        this.f5738d = str;
        this.f5725a = context;
    }

    /* renamed from: a */
    private String m5645a(C1374a aVar) {
        HashMap hashMap = this.f5739e.get(aVar.mo9420e());
        if (hashMap == null || hashMap.get(aVar.mo9418c()) == null || !((String) hashMap.get(aVar.mo9418c())).equals(C1379c.Start.name())) {
            return null;
        }
        return "add";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9432a(C0589t tVar, String str) {
        tVar.mo6929a("&uid", mo9429c(mo9423a()));
        String valueOf = String.valueOf(this.f5737c);
        if (this.f5737c == 0) {
            valueOf = this.f5725a.getString(C1385h.not_set);
        }
        tVar.mo6929a("&cd1", valueOf);
        tVar.mo6929a("&cd2", mo9429c(str));
        tVar.mo6929a("&cd3", mo9429c(Build.MODEL));
        tVar.mo6929a("&cd4", mo9429c(this.f5738d));
        tVar.mo6929a("&cd5", mo9429c(Build.MANUFACTURER + " " + Build.PRODUCT));
    }

    /* renamed from: a */
    public void mo9424a(C1374a aVar, C0589t tVar, String str, String str2) {
        mo9432a(tVar, str2);
        tVar.mo6928a(aVar.mo9413a(str.equals("primaryTracker")));
        if (aVar.mo9421f() == C1375b.PAGE_ONLY) {
            tVar.mo6930a((Map<String, String>) new C0586q().mo6914a());
        } else if (aVar.mo9421f() == C1375b.EVENT) {
            tVar.mo6930a((Map<String, String>) new C0583n().mo6913a(aVar.mo9413a(str.equals("primaryTracker")) + "-" + aVar.mo9412a()).mo6915b(aVar.mo9416b()).mo6916c(aVar.mo9418c()).mo6914a());
            if (m5645a(aVar) != null) {
                C0502a a = new C0502a().mo6561a(aVar.mo9419d());
                tVar.mo6930a((Map<String, String>) ((C0586q) ((C0586q) new C0586q().mo6920a(a)).mo6921a(new C0503b(m5645a(aVar)))).mo6914a());
            }
        } else if (aVar.mo9421f() == C1375b.START_SESSION) {
            tVar.mo6930a((Map<String, String>) ((C0586q) ((C0586q) new C0586q().mo6923b()).mo6919a(1, Integer.toString(this.f5737c))).mo6914a());
        } else if (aVar.mo9421f() == C1375b.EXCEPTION) {
            tVar.mo6930a((Map<String, String>) new C0584o().mo6917a(aVar.mo9416b()).mo6914a());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9427b() {
        C0580k kVar = new C0580k((C0589t) mo9422a("primaryTracker"), Thread.getDefaultUncaughtExceptionHandler(), this.f5725a);
        Thread.setDefaultUncaughtExceptionHandler(kVar);
        kVar.mo6900a(new C1381d(this, this.f5725a, (Collection) null));
    }
}
