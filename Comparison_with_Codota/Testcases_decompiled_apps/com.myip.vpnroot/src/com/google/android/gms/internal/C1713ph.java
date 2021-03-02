package com.google.android.gms.internal;

import com.google.android.gms.internal.C1712pg;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ph */
public class C1713ph<M extends C1712pg<M>, T> {
    protected final boolean awA;
    protected final Class<T> awz;
    protected final int tag;
    protected final int type;

    private C1713ph(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.awz = cls;
        this.tag = i2;
        this.awA = z;
    }

    /* renamed from: a */
    public static <M extends C1712pg<M>, T extends C1718pm> C1713ph<M, T> m6059a(int i, Class<T> cls, int i2) {
        return new C1713ph<>(i, cls, i2, false);
    }

    /* renamed from: m */
    private T m6060m(List<C1720po> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C1720po poVar = list.get(i);
            if (poVar.awK.length != 0) {
                mo10086a(poVar, (List<Object>) arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T cast = this.awz.cast(Array.newInstance(this.awz.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    /* renamed from: n */
    private T m6061n(List<C1720po> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.awz.cast(mo10091u(C1709pe.m5966p(list.get(list.size() - 1).awK)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public int mo10083A(Object obj) {
        return this.awA ? mo10084B(obj) : mo10085C(obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public int mo10084B(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += mo10085C(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public int mo10085C(Object obj) {
        int gH = C1721pp.m6108gH(this.tag);
        switch (this.type) {
            case 10:
                return C1710pf.m5998b(gH, (C1718pm) obj);
            case 11:
                return C1710pf.m6002c(gH, (C1718pm) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10086a(C1720po poVar, List<Object> list) {
        list.add(mo10091u(C1709pe.m5966p(poVar.awK)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10087a(Object obj, C1710pf pfVar) throws IOException {
        if (this.awA) {
            mo10089c(obj, pfVar);
        } else {
            mo10088b(obj, pfVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10088b(Object obj, C1710pf pfVar) {
        try {
            pfVar.mo10071gz(this.tag);
            switch (this.type) {
                case 10:
                    int gH = C1721pp.m6108gH(this.tag);
                    pfVar.mo10060b((C1718pm) obj);
                    pfVar.mo10078w(gH, 4);
                    return;
                case 11:
                    pfVar.mo10062c((C1718pm) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10089c(Object obj, C1710pf pfVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                mo10088b(obj2, pfVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final T mo10090l(List<C1720po> list) {
        if (list == null) {
            return null;
        }
        return this.awA ? m6060m(list) : m6061n(list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public Object mo10091u(C1709pe peVar) {
        Class<?> componentType = this.awA ? this.awz.getComponentType() : this.awz;
        try {
            switch (this.type) {
                case 10:
                    C1718pm pmVar = (C1718pm) componentType.newInstance();
                    peVar.mo10019a(pmVar, C1721pp.m6108gH(this.tag));
                    return pmVar;
                case 11:
                    C1718pm pmVar2 = (C1718pm) componentType.newInstance();
                    peVar.mo10018a(pmVar2);
                    return pmVar2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }
}
