package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzapq {

    /* renamed from: a */
    protected final int f5896a;

    /* renamed from: b */
    protected final Class f5897b;

    /* renamed from: c */
    protected final boolean f5898c;
    public final int tag;

    private zzapq(int i, Class cls, int i2, boolean z) {
        this.f5896a = i;
        this.f5897b = cls;
        this.tag = i2;
        this.f5898c = z;
    }

    /* renamed from: b */
    private Object m6797b(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C1501dl dlVar = (C1501dl) list.get(i);
            if (dlVar.f4936b.length != 0) {
                mo8031a(dlVar, (List) arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Object cast = this.f5897b.cast(Array.newInstance(this.f5897b.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    /* renamed from: c */
    private Object m6798c(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.f5897b.cast(mo8029a(zzapn.zzbd(((C1501dl) list.get(list.size() - 1)).f4936b)));
    }

    public static zzapq zza(int i, Class cls, long j) {
        return new zzapq(i, cls, (int) j, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8028a(Object obj) {
        return this.f5898c ? mo8033b(obj) : mo8035c(obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo8029a(zzapn zzapn) {
        Class<?> componentType = this.f5898c ? this.f5897b.getComponentType() : this.f5897b;
        try {
            switch (this.f5896a) {
                case 10:
                    zzapv zzapv = (zzapv) componentType.newInstance();
                    zzapn.zza(zzapv, zzapy.zzagj(this.tag));
                    return zzapv;
                case 11:
                    zzapv zzapv2 = (zzapv) componentType.newInstance();
                    zzapn.zza(zzapv2);
                    return zzapv2;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.f5896a).toString());
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 33).append("Error creating instance of class ").append(valueOf2).toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Object mo8030a(List list) {
        if (list == null) {
            return null;
        }
        return this.f5898c ? m6797b(list) : m6798c(list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8031a(C1501dl dlVar, List list) {
        list.add(mo8029a(zzapn.zzbd(dlVar.f4936b)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8032a(Object obj, zzapo zzapo) {
        if (this.f5898c) {
            mo8036c(obj, zzapo);
        } else {
            mo8034b(obj, zzapo);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo8033b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += mo8035c(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8034b(Object obj, zzapo zzapo) {
        try {
            zzapo.zzagb(this.tag);
            switch (this.f5896a) {
                case 10:
                    int zzagj = zzapy.zzagj(this.tag);
                    zzapo.zzb((zzapv) obj);
                    zzapo.zzai(zzagj, 4);
                    return;
                case 11:
                    zzapo.zzc((zzapv) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.f5896a).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo8035c(Object obj) {
        int zzagj = zzapy.zzagj(this.tag);
        switch (this.f5896a) {
            case 10:
                return zzapo.zzb(zzagj, (zzapv) obj);
            case 11:
                return zzapo.zzc(zzagj, (zzapv) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.f5896a).toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8036c(Object obj, zzapo zzapo) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                mo8034b(obj2, zzapo);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzapq)) {
            return false;
        }
        zzapq zzapq = (zzapq) obj;
        return this.f5896a == zzapq.f5896a && this.f5897b == zzapq.f5897b && this.tag == zzapq.tag && this.f5898c == zzapq.f5898c;
    }

    public int hashCode() {
        return (this.f5898c ? 1 : 0) + ((((((this.f5896a + 1147) * 31) + this.f5897b.hashCode()) * 31) + this.tag) * 31);
    }
}
