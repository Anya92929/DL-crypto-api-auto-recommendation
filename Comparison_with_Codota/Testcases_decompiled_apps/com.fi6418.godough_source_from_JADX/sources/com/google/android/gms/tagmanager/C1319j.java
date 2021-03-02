package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.tagmanager.j */
public class C1319j {

    /* renamed from: g */
    private static C1319j f5400g;

    /* renamed from: a */
    private final C1324o f5401a;

    /* renamed from: b */
    private final Context f5402b;

    /* renamed from: c */
    private final C1294b f5403c;

    /* renamed from: d */
    private final C1289av f5404d;

    /* renamed from: e */
    private final ConcurrentMap<C1302bh, Boolean> f5405e;

    /* renamed from: f */
    private final C1304bj f5406f;

    C1319j(Context context, C1324o oVar, C1294b bVar, C1289av avVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.f5402b = context.getApplicationContext();
        this.f5404d = avVar;
        this.f5401a = oVar;
        this.f5405e = new ConcurrentHashMap();
        this.f5403c = bVar;
        this.f5403c.mo9117a((C1315f) new C1320k(this));
        this.f5403c.mo9117a((C1315f) new C1296bb(this.f5402b));
        this.f5406f = new C1304bj();
        m5422b();
    }

    /* renamed from: a */
    public static C1319j m5419a(Context context) {
        C1319j jVar;
        synchronized (C1319j.class) {
            if (f5400g == null) {
                if (context == null) {
                    C1333x.m5440a("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                f5400g = new C1319j(context, new C1321l(), new C1294b(new C1306bl(context)), C1290aw.m5321b());
            }
            jVar = f5400g;
        }
        return jVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5421a(String str) {
        for (C1302bh a : this.f5405e.keySet()) {
            a.mo9143a(str);
        }
    }

    /* renamed from: b */
    private void m5422b() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f5402b.registerComponentCallbacks(new C1322m(this));
        }
    }

    /* renamed from: a */
    public void mo9171a() {
        this.f5404d.mo9114a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo9172a(Uri uri) {
        boolean z;
        C1276ai a = C1276ai.m5275a();
        if (a.mo9094a(uri)) {
            String d = a.mo9097d();
            switch (C1323n.f5409a[a.mo9095b().ordinal()]) {
                case 1:
                    for (C1302bh bhVar : this.f5405e.keySet()) {
                        if (bhVar.mo9144b().equals(d)) {
                            bhVar.mo9145b((String) null);
                            bhVar.mo9142a();
                        }
                    }
                    break;
                case 2:
                case 3:
                    for (C1302bh bhVar2 : this.f5405e.keySet()) {
                        if (bhVar2.mo9144b().equals(d)) {
                            bhVar2.mo9145b(a.mo9096c());
                            bhVar2.mo9142a();
                        } else if (bhVar2.mo9146c() != null) {
                            bhVar2.mo9145b((String) null);
                            bhVar2.mo9142a();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
