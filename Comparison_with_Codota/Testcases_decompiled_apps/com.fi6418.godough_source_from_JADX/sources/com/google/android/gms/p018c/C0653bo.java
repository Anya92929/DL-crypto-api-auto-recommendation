package com.google.android.gms.p018c;

import com.google.android.gms.p018c.C0652bn;
import java.io.IOException;
import java.lang.reflect.Array;

/* renamed from: com.google.android.gms.c.bo */
public class C0653bo<M extends C0652bn<M>, T> {

    /* renamed from: a */
    protected final int f4322a;

    /* renamed from: b */
    protected final Class<T> f4323b;

    /* renamed from: c */
    public final int f4324c;

    /* renamed from: d */
    protected final boolean f4325d;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7170a(Object obj) {
        return this.f4325d ? mo7172b(obj) : mo7174c(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7171a(Object obj, C0650bl blVar) {
        if (this.f4325d) {
            mo7175c(obj, blVar);
        } else {
            mo7173b(obj, blVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo7172b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += mo7174c(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7173b(Object obj, C0650bl blVar) {
        try {
            blVar.mo7162e(this.f4324c);
            switch (this.f4322a) {
                case 10:
                    int a = C0660bv.m3838a(this.f4324c);
                    blVar.mo7153a((C0657bs) obj);
                    blVar.mo7160c(a, 4);
                    return;
                case 11:
                    blVar.mo7156b((C0657bs) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f4322a);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo7174c(Object obj) {
        int a = C0660bv.m3838a(this.f4324c);
        switch (this.f4322a) {
            case 10:
                return C0650bl.m3764b(a, (C0657bs) obj);
            case 11:
                return C0650bl.m3771c(a, (C0657bs) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f4322a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7175c(Object obj, C0650bl blVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                mo7173b(obj2, blVar);
            }
        }
    }
}
