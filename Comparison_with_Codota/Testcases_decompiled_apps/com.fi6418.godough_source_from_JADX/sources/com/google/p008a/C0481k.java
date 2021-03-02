package com.google.p008a;

import com.google.p008a.p010b.C0433ag;
import com.google.p008a.p010b.C0446f;
import com.google.p008a.p010b.C0459s;
import com.google.p008a.p010b.p011a.C0367a;
import com.google.p008a.p010b.p011a.C0403c;
import com.google.p008a.p010b.p011a.C0405e;
import com.google.p008a.p010b.p011a.C0407g;
import com.google.p008a.p010b.p011a.C0412l;
import com.google.p008a.p010b.p011a.C0414n;
import com.google.p008a.p010b.p011a.C0417q;
import com.google.p008a.p010b.p011a.C0421u;
import com.google.p008a.p010b.p011a.C0423w;
import com.google.p008a.p010b.p011a.C0426z;
import com.google.p008a.p012c.C0468a;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import com.google.p008a.p013d.C0474e;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.a.k */
public final class C0481k {

    /* renamed from: a */
    final C0491u f3618a;

    /* renamed from: b */
    final C0354ac f3619b;

    /* renamed from: c */
    private final ThreadLocal<Map<C0468a<?>, C0487q<?>>> f3620c;

    /* renamed from: d */
    private final Map<C0468a<?>, C0363al<?>> f3621d;

    /* renamed from: e */
    private final List<C0364am> f3622e;

    /* renamed from: f */
    private final C0446f f3623f;

    /* renamed from: g */
    private final boolean f3624g;

    /* renamed from: h */
    private final boolean f3625h;

    /* renamed from: i */
    private final boolean f3626i;

    /* renamed from: j */
    private final boolean f3627j;

    public C0481k() {
        this(C0459s.f3544a, C0469d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, C0357af.DEFAULT, Collections.emptyList());
    }

    C0481k(C0459s sVar, C0480j jVar, Map<Type, C0489s<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, C0357af afVar, List<C0364am> list) {
        this.f3620c = new ThreadLocal<>();
        this.f3621d = Collections.synchronizedMap(new HashMap());
        this.f3618a = new C0482l(this);
        this.f3619b = new C0483m(this);
        this.f3623f = new C0446f(map);
        this.f3624g = z;
        this.f3626i = z3;
        this.f3625h = z4;
        this.f3627j = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C0426z.f3463Q);
        arrayList.add(C0414n.f3423a);
        arrayList.add(sVar);
        arrayList.addAll(list);
        arrayList.add(C0426z.f3488x);
        arrayList.add(C0426z.f3477m);
        arrayList.add(C0426z.f3471g);
        arrayList.add(C0426z.f3473i);
        arrayList.add(C0426z.f3475k);
        arrayList.add(C0426z.m2712a(Long.TYPE, Long.class, m2879a(afVar)));
        arrayList.add(C0426z.m2712a(Double.TYPE, Double.class, m2880a(z6)));
        arrayList.add(C0426z.m2712a(Float.TYPE, Float.class, m2885b(z6)));
        arrayList.add(C0426z.f3482r);
        arrayList.add(C0426z.f3484t);
        arrayList.add(C0426z.f3490z);
        arrayList.add(C0426z.f3448B);
        arrayList.add(C0426z.m2711a(BigDecimal.class, C0426z.f3486v));
        arrayList.add(C0426z.m2711a(BigInteger.class, C0426z.f3487w));
        arrayList.add(C0426z.f3450D);
        arrayList.add(C0426z.f3452F);
        arrayList.add(C0426z.f3456J);
        arrayList.add(C0426z.f3461O);
        arrayList.add(C0426z.f3454H);
        arrayList.add(C0426z.f3468d);
        arrayList.add(C0405e.f3404a);
        arrayList.add(C0426z.f3459M);
        arrayList.add(C0423w.f3442a);
        arrayList.add(C0421u.f3440a);
        arrayList.add(C0426z.f3457K);
        arrayList.add(C0367a.f3381a);
        arrayList.add(C0426z.f3464R);
        arrayList.add(C0426z.f3466b);
        arrayList.add(new C0403c(this.f3623f));
        arrayList.add(new C0412l(this.f3623f, z2));
        arrayList.add(new C0407g(this.f3623f));
        arrayList.add(new C0417q(this.f3623f, jVar, sVar));
        this.f3622e = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private C0363al<Number> m2879a(C0357af afVar) {
        return afVar == C0357af.DEFAULT ? C0426z.f3478n : new C0486p(this);
    }

    /* renamed from: a */
    private C0363al<Number> m2880a(boolean z) {
        return z ? C0426z.f3480p : new C0484n(this);
    }

    /* renamed from: a */
    private C0473d m2881a(Writer writer) {
        if (this.f3626i) {
            writer.write(")]}'\n");
        }
        C0473d dVar = new C0473d(writer);
        if (this.f3627j) {
            dVar.mo6503c("  ");
        }
        dVar.mo6505d(this.f3624g);
        return dVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2882a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* renamed from: a */
    private static void m2884a(Object obj, C0470a aVar) {
        if (obj != null) {
            try {
                if (aVar.mo6381f() != C0472c.END_DOCUMENT) {
                    throw new C0494x("JSON document was not fully consumed.");
                }
            } catch (C0474e e) {
                throw new C0356ae((Throwable) e);
            } catch (IOException e2) {
                throw new C0494x((Throwable) e2);
            }
        }
    }

    /* renamed from: b */
    private C0363al<Number> m2885b(boolean z) {
        return z ? C0426z.f3479o : new C0485o(this);
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6510a(C0364am amVar, C0468a<T> aVar) {
        boolean z = false;
        for (C0364am next : this.f3622e) {
            if (z) {
                C0363al<T> a = next.mo6311a(this, aVar);
                if (a != null) {
                    return a;
                }
            } else if (next == amVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6511a(C0468a<T> aVar) {
        HashMap hashMap;
        C0363al<T> alVar = this.f3621d.get(aVar);
        if (alVar == null) {
            Map map = this.f3620c.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.f3620c.set(hashMap2);
                hashMap = hashMap2;
                z = true;
            } else {
                hashMap = map;
            }
            alVar = (C0487q) hashMap.get(aVar);
            if (alVar == null) {
                try {
                    C0487q qVar = new C0487q();
                    hashMap.put(aVar, qVar);
                    for (C0364am a : this.f3622e) {
                        alVar = a.mo6311a(this, aVar);
                        if (alVar != null) {
                            qVar.mo6526a(alVar);
                            this.f3621d.put(aVar, alVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.f3620c.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.f3620c.remove();
                    }
                    throw th;
                }
            }
        }
        return alVar;
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6512a(Class<T> cls) {
        return mo6511a(C0468a.m2796b(cls));
    }

    /* renamed from: a */
    public <T> T mo6513a(C0470a aVar, Type type) {
        boolean z = true;
        boolean p = aVar.mo6500p();
        aVar.mo6499a(true);
        try {
            aVar.mo6381f();
            z = false;
            T b = mo6511a(C0468a.m2794a(type)).mo6310b(aVar);
            aVar.mo6499a(p);
            return b;
        } catch (EOFException e) {
            if (z) {
                aVar.mo6499a(p);
                return null;
            }
            throw new C0356ae((Throwable) e);
        } catch (IllegalStateException e2) {
            throw new C0356ae((Throwable) e2);
        } catch (IOException e3) {
            throw new C0356ae((Throwable) e3);
        } catch (Throwable th) {
            aVar.mo6499a(p);
            throw th;
        }
    }

    /* renamed from: a */
    public <T> T mo6514a(Reader reader, Type type) {
        C0470a aVar = new C0470a(reader);
        T a = mo6513a(aVar, type);
        m2884a((Object) a, aVar);
        return a;
    }

    /* renamed from: a */
    public <T> T mo6515a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return mo6514a((Reader) new StringReader(str), type);
    }

    /* renamed from: a */
    public String mo6516a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        mo6518a(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void mo6517a(Object obj, Type type, C0473d dVar) {
        C0363al<?> a = mo6511a(C0468a.m2794a(type));
        boolean g = dVar.mo6506g();
        dVar.mo6502b(true);
        boolean h = dVar.mo6507h();
        dVar.mo6504c(this.f3625h);
        boolean i = dVar.mo6508i();
        dVar.mo6505d(this.f3624g);
        try {
            a.mo6309a(dVar, obj);
            dVar.mo6502b(g);
            dVar.mo6504c(h);
            dVar.mo6505d(i);
        } catch (IOException e) {
            throw new C0494x((Throwable) e);
        } catch (Throwable th) {
            dVar.mo6502b(g);
            dVar.mo6504c(h);
            dVar.mo6505d(i);
            throw th;
        }
    }

    /* renamed from: a */
    public void mo6518a(Object obj, Type type, Appendable appendable) {
        try {
            mo6517a(obj, type, m2881a(C0433ag.m2722a(appendable)));
        } catch (IOException e) {
            throw new C0494x((Throwable) e);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f3624g + "factories:" + this.f3622e + ",instanceCreators:" + this.f3623f + "}";
    }
}
