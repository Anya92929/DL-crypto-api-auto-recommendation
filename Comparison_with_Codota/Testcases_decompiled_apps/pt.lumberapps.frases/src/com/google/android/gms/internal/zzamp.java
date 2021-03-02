package com.google.android.gms.internal;

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

public final class zzamp {

    /* renamed from: a */
    final zzamt f5771a;

    /* renamed from: b */
    final zzanc f5772b;

    /* renamed from: c */
    private final ThreadLocal f5773c;

    /* renamed from: d */
    private final Map f5774d;

    /* renamed from: e */
    private final List f5775e;

    /* renamed from: f */
    private final zzanp f5776f;

    /* renamed from: g */
    private final boolean f5777g;

    /* renamed from: h */
    private final boolean f5778h;

    /* renamed from: i */
    private final boolean f5779i;

    /* renamed from: j */
    private final boolean f5780j;

    public zzamp() {
        this(zzanq.beK, zzamn.bdI, Collections.emptyMap(), false, false, false, true, false, false, zzanf.bel, Collections.emptyList());
    }

    zzamp(zzanq zzanq, zzamo zzamo, Map map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, zzanf zzanf, List list) {
        this.f5773c = new ThreadLocal();
        this.f5774d = Collections.synchronizedMap(new HashMap());
        this.f5771a = new C1881z(this);
        this.f5772b = new C1409aa(this);
        this.f5776f = new zzanp(map);
        this.f5777g = z;
        this.f5779i = z3;
        this.f5778h = z4;
        this.f5780j = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzaok.bgN);
        arrayList.add(zzaof.bfu);
        arrayList.add(zzanq);
        arrayList.addAll(list);
        arrayList.add(zzaok.bgu);
        arrayList.add(zzaok.bgj);
        arrayList.add(zzaok.bgd);
        arrayList.add(zzaok.bgf);
        arrayList.add(zzaok.bgh);
        arrayList.add(zzaok.zza(Long.TYPE, Long.class, m6648a(zzanf)));
        arrayList.add(zzaok.zza(Double.TYPE, Double.class, m6649a(z6)));
        arrayList.add(zzaok.zza(Float.TYPE, Float.class, m6653b(z6)));
        arrayList.add(zzaok.bgo);
        arrayList.add(zzaok.bgq);
        arrayList.add(zzaok.bgw);
        arrayList.add(zzaok.bgy);
        arrayList.add(zzaok.zza(BigDecimal.class, zzaok.bgs));
        arrayList.add(zzaok.zza(BigInteger.class, zzaok.bgt));
        arrayList.add(zzaok.bgA);
        arrayList.add(zzaok.bgC);
        arrayList.add(zzaok.bgG);
        arrayList.add(zzaok.bgL);
        arrayList.add(zzaok.bgE);
        arrayList.add(zzaok.bga);
        arrayList.add(zzaoa.bfu);
        arrayList.add(zzaok.bgJ);
        arrayList.add(zzaoi.bfu);
        arrayList.add(zzaoh.bfu);
        arrayList.add(zzaok.bgH);
        arrayList.add(zzany.bfu);
        arrayList.add(zzaok.bfY);
        arrayList.add(new zzanz(this.f5776f));
        arrayList.add(new zzaoe(this.f5776f, z2));
        arrayList.add(new zzaob(this.f5776f));
        arrayList.add(zzaok.bgO);
        arrayList.add(new zzaog(this.f5776f, zzamo, zzanq));
        this.f5775e = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private zzanh m6648a(zzanf zzanf) {
        return zzanf == zzanf.bel ? zzaok.bgk : new C1412ad(this);
    }

    /* renamed from: a */
    private zzanh m6649a(boolean z) {
        return z ? zzaok.bgm : new C1410ab(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6650a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(new StringBuilder(168).append(d).append(" is not a valid double value as per JSON specification. To override this").append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        }
    }

    /* renamed from: a */
    private static void m6652a(Object obj, zzaom zzaom) {
        if (obj != null) {
            try {
                if (zzaom.mo7902b() != zzaon.END_DOCUMENT) {
                    throw new zzamw("JSON document was not fully consumed.");
                }
            } catch (zzaop e) {
                throw new zzane((Throwable) e);
            } catch (IOException e2) {
                throw new zzamw((Throwable) e2);
            }
        }
    }

    /* renamed from: b */
    private zzanh m6653b(boolean z) {
        return z ? zzaok.bgl : new C1411ac(this);
    }

    public String toString() {
        return "{serializeNulls:" + this.f5777g + "factories:" + this.f5775e + ",instanceCreators:" + this.f5776f + "}";
    }

    public zzanh zza(zzani zzani, zzaol zzaol) {
        boolean z = false;
        if (!this.f5775e.contains(zzani)) {
            z = true;
        }
        boolean z2 = z;
        for (zzani zzani2 : this.f5775e) {
            if (z2) {
                zzanh zza = zzani2.zza(this, zzaol);
                if (zza != null) {
                    return zza;
                }
            } else if (zzani2 == zzani) {
                z2 = true;
            }
        }
        String valueOf = String.valueOf(zzaol);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("GSON cannot serialize ").append(valueOf).toString());
    }

    public zzanh zza(zzaol zzaol) {
        HashMap hashMap;
        zzanh zzanh = (zzanh) this.f5774d.get(zzaol);
        if (zzanh == null) {
            Map map = (Map) this.f5773c.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.f5773c.set(hashMap2);
                hashMap = hashMap2;
                z = true;
            } else {
                hashMap = map;
            }
            zzanh = (C1413ae) hashMap.get(zzaol);
            if (zzanh == null) {
                try {
                    C1413ae aeVar = new C1413ae();
                    hashMap.put(zzaol, aeVar);
                    for (zzani zza : this.f5775e) {
                        zzanh = zza.zza(this, zzaol);
                        if (zzanh != null) {
                            aeVar.mo7058a(zzanh);
                            this.f5774d.put(zzaol, zzanh);
                            hashMap.remove(zzaol);
                            if (z) {
                                this.f5773c.remove();
                            }
                        }
                    }
                    String valueOf = String.valueOf(zzaol);
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("GSON cannot handle ").append(valueOf).toString());
                } catch (Throwable th) {
                    hashMap.remove(zzaol);
                    if (z) {
                        this.f5773c.remove();
                    }
                    throw th;
                }
            }
        }
        return zzanh;
    }

    public zzaoo zza(Writer writer) {
        if (this.f5779i) {
            writer.write(")]}'\n");
        }
        zzaoo zzaoo = new zzaoo(writer);
        if (this.f5780j) {
            zzaoo.setIndent("  ");
        }
        zzaoo.zzdd(this.f5777g);
        return zzaoo;
    }

    public Object zza(zzamv zzamv, Class cls) {
        return zzanv.zzp(cls).cast(zza(zzamv, (Type) cls));
    }

    public Object zza(zzamv zzamv, Type type) {
        if (zzamv == null) {
            return null;
        }
        return zza((zzaom) new zzaoc(zzamv), type);
    }

    public Object zza(zzaom zzaom, Type type) {
        boolean z = true;
        boolean isLenient = zzaom.isLenient();
        zzaom.setLenient(true);
        try {
            zzaom.mo7902b();
            z = false;
            Object zzb = zza(zzaol.zzl(type)).zzb(zzaom);
            zzaom.setLenient(isLenient);
            return zzb;
        } catch (EOFException e) {
            if (z) {
                zzaom.setLenient(isLenient);
                return null;
            }
            throw new zzane((Throwable) e);
        } catch (IllegalStateException e2) {
            throw new zzane((Throwable) e2);
        } catch (IOException e3) {
            throw new zzane((Throwable) e3);
        } catch (Throwable th) {
            zzaom.setLenient(isLenient);
            throw th;
        }
    }

    public Object zza(Reader reader, Type type) {
        zzaom zzaom = new zzaom(reader);
        Object zza = zza(zzaom, type);
        m6652a(zza, zzaom);
        return zza;
    }

    public Object zza(String str, Type type) {
        if (str == null) {
            return null;
        }
        return zza((Reader) new StringReader(str), type);
    }

    public void zza(zzamv zzamv, zzaoo zzaoo) {
        boolean isLenient = zzaoo.isLenient();
        zzaoo.setLenient(true);
        boolean x = zzaoo.mo7948x();
        zzaoo.zzdc(this.f5778h);
        boolean y = zzaoo.mo7949y();
        zzaoo.zzdd(this.f5777g);
        try {
            zzanw.zzb(zzamv, zzaoo);
            zzaoo.setLenient(isLenient);
            zzaoo.zzdc(x);
            zzaoo.zzdd(y);
        } catch (IOException e) {
            throw new zzamw((Throwable) e);
        } catch (Throwable th) {
            zzaoo.setLenient(isLenient);
            zzaoo.zzdc(x);
            zzaoo.zzdd(y);
            throw th;
        }
    }

    public void zza(zzamv zzamv, Appendable appendable) {
        try {
            zza(zzamv, zza(zzanw.zza(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(Object obj, Type type, zzaoo zzaoo) {
        zzanh zza = zza(zzaol.zzl(type));
        boolean isLenient = zzaoo.isLenient();
        zzaoo.setLenient(true);
        boolean x = zzaoo.mo7948x();
        zzaoo.zzdc(this.f5778h);
        boolean y = zzaoo.mo7949y();
        zzaoo.zzdd(this.f5777g);
        try {
            zza.zza(zzaoo, obj);
            zzaoo.setLenient(isLenient);
            zzaoo.zzdc(x);
            zzaoo.zzdd(y);
        } catch (IOException e) {
            throw new zzamw((Throwable) e);
        } catch (Throwable th) {
            zzaoo.setLenient(isLenient);
            zzaoo.zzdc(x);
            zzaoo.zzdd(y);
            throw th;
        }
    }

    public void zza(Object obj, Type type, Appendable appendable) {
        try {
            zza(obj, type, zza(zzanw.zza(appendable)));
        } catch (IOException e) {
            throw new zzamw((Throwable) e);
        }
    }

    public String zzb(zzamv zzamv) {
        StringWriter stringWriter = new StringWriter();
        zza(zzamv, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public String zzc(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        zza(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public String zzch(Object obj) {
        return obj == null ? zzb(zzamx.bei) : zzc(obj, obj.getClass());
    }

    public Object zzf(String str, Class cls) {
        return zzanv.zzp(cls).cast(zza(str, (Type) cls));
    }

    public zzanh zzk(Class cls) {
        return zza(zzaol.zzr(cls));
    }
}
