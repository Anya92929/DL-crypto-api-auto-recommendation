package com.google.p008a;

import com.google.p008a.p010b.C0366a;
import com.google.p008a.p010b.C0459s;
import com.google.p008a.p010b.p011a.C0426z;
import com.google.p008a.p012c.C0468a;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.a.r */
public final class C0488r {

    /* renamed from: a */
    private C0459s f3634a = C0459s.f3544a;

    /* renamed from: b */
    private C0357af f3635b = C0357af.DEFAULT;

    /* renamed from: c */
    private C0480j f3636c = C0469d.IDENTITY;

    /* renamed from: d */
    private final Map<Type, C0489s<?>> f3637d = new HashMap();

    /* renamed from: e */
    private final List<C0364am> f3638e = new ArrayList();

    /* renamed from: f */
    private final List<C0364am> f3639f = new ArrayList();

    /* renamed from: g */
    private boolean f3640g;

    /* renamed from: h */
    private String f3641h;

    /* renamed from: i */
    private int f3642i = 2;

    /* renamed from: j */
    private int f3643j = 2;

    /* renamed from: k */
    private boolean f3644k;

    /* renamed from: l */
    private boolean f3645l;

    /* renamed from: m */
    private boolean f3646m = true;

    /* renamed from: n */
    private boolean f3647n;

    /* renamed from: o */
    private boolean f3648o;

    /* renamed from: a */
    private void m2910a(String str, int i, int i2, List<C0364am> list) {
        C0346a aVar;
        if (str != null && !"".equals(str.trim())) {
            aVar = new C0346a(str);
        } else if (i != 2 && i2 != 2) {
            aVar = new C0346a(i, i2);
        } else {
            return;
        }
        list.add(C0360ai.m2500a((C0468a<?>) C0468a.m2796b(Date.class), (Object) aVar));
        list.add(C0360ai.m2500a((C0468a<?>) C0468a.m2796b(Timestamp.class), (Object) aVar));
        list.add(C0360ai.m2500a((C0468a<?>) C0468a.m2796b(java.sql.Date.class), (Object) aVar));
    }

    /* renamed from: a */
    public C0488r mo6527a() {
        this.f3646m = false;
        return this;
    }

    /* renamed from: a */
    public C0488r mo6528a(C0469d dVar) {
        this.f3636c = dVar;
        return this;
    }

    /* renamed from: a */
    public C0488r mo6529a(Type type, Object obj) {
        C0366a.m2512a((obj instanceof C0355ad) || (obj instanceof C0492v) || (obj instanceof C0489s) || (obj instanceof C0363al));
        if (obj instanceof C0489s) {
            this.f3637d.put(type, (C0489s) obj);
        }
        if ((obj instanceof C0355ad) || (obj instanceof C0492v)) {
            this.f3638e.add(C0360ai.m2501b(C0468a.m2794a(type), obj));
        }
        if (obj instanceof C0363al) {
            this.f3638e.add(C0426z.m2710a(C0468a.m2794a(type), (C0363al) obj));
        }
        return this;
    }

    /* renamed from: b */
    public C0481k mo6530b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3638e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f3639f);
        m2910a(this.f3641h, this.f3642i, this.f3643j, arrayList);
        return new C0481k(this.f3634a, this.f3636c, this.f3637d, this.f3640g, this.f3644k, this.f3648o, this.f3646m, this.f3647n, this.f3645l, this.f3635b, arrayList);
    }
}
