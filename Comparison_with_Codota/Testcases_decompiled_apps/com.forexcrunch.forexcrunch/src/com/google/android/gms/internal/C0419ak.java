package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0409ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ak */
public class C0419ak extends C0409ae implements SafeParcelable {
    public static final C0420al CREATOR = new C0420al();

    /* renamed from: ab */
    private final int f1006ab;

    /* renamed from: cB */
    private final C0414ah f1007cB;

    /* renamed from: cJ */
    private final Parcel f1008cJ;

    /* renamed from: cK */
    private final int f1009cK;

    /* renamed from: cL */
    private int f1010cL;

    /* renamed from: cM */
    private int f1011cM;
    private final String mClassName;

    C0419ak(int i, Parcel parcel, C0414ah ahVar) {
        this.f1006ab = i;
        this.f1008cJ = (Parcel) C0621s.m1890d(parcel);
        this.f1009cK = 2;
        this.f1007cB = ahVar;
        if (this.f1007cB == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.f1007cB.mo4516aj();
        }
        this.f1010cL = 2;
    }

    private C0419ak(SafeParcelable safeParcelable, C0414ah ahVar, String str) {
        this.f1006ab = 1;
        this.f1008cJ = Parcel.obtain();
        safeParcelable.writeToParcel(this.f1008cJ, 0);
        this.f1009cK = 1;
        this.f1007cB = (C0414ah) C0621s.m1890d(ahVar);
        this.mClassName = (String) C0621s.m1890d(str);
        this.f1010cL = 2;
    }

    /* renamed from: a */
    public static <T extends C0409ae & SafeParcelable> C0419ak m875a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new C0419ak((SafeParcelable) t, m882b((C0409ae) t), canonicalName);
    }

    /* renamed from: a */
    public static HashMap<String, String> m876a(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m877a(C0414ah ahVar, C0409ae aeVar) {
        Class<?> cls = aeVar.getClass();
        if (!ahVar.mo4517b((Class<? extends C0409ae>) cls)) {
            HashMap<String, C0409ae.C0410a<?, ?>> T = aeVar.mo4475T();
            ahVar.mo4512a(cls, aeVar.mo4475T());
            for (String str : T.keySet()) {
                C0409ae.C0410a aVar = T.get(str);
                Class<? extends C0409ae> ab = aVar.mo4494ab();
                if (ab != null) {
                    try {
                        m877a(ahVar, (C0409ae) ab.newInstance());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + aVar.mo4494ab().getCanonicalName(), e);
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not access object of type " + aVar.mo4494ab().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m878a(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(C0425aq.m907r(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(C0422an.m903a((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(C0422an.m904b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                C0426ar.m908a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    /* renamed from: a */
    private void m879a(StringBuilder sb, C0409ae.C0410a<?, ?> aVar, Parcel parcel, int i) {
        switch (aVar.mo4487S()) {
            case 0:
                m885b(sb, aVar, (Object) mo4478a(aVar, Integer.valueOf(C0357a.m639f(parcel, i))));
                return;
            case 1:
                m885b(sb, aVar, (Object) mo4478a(aVar, C0357a.m641h(parcel, i)));
                return;
            case 2:
                m885b(sb, aVar, (Object) mo4478a(aVar, Long.valueOf(C0357a.m640g(parcel, i))));
                return;
            case 3:
                m885b(sb, aVar, (Object) mo4478a(aVar, Float.valueOf(C0357a.m642i(parcel, i))));
                return;
            case 4:
                m885b(sb, aVar, (Object) mo4478a(aVar, Double.valueOf(C0357a.m643j(parcel, i))));
                return;
            case 5:
                m885b(sb, aVar, (Object) mo4478a(aVar, C0357a.m644k(parcel, i)));
                return;
            case 6:
                m885b(sb, aVar, (Object) mo4478a(aVar, Boolean.valueOf(C0357a.m636c(parcel, i))));
                return;
            case 7:
                m885b(sb, aVar, (Object) mo4478a(aVar, C0357a.m645l(parcel, i)));
                return;
            case 8:
            case 9:
                m885b(sb, aVar, (Object) mo4478a(aVar, C0357a.m649o(parcel, i)));
                return;
            case 10:
                m885b(sb, aVar, (Object) mo4478a(aVar, m876a(C0357a.m648n(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + aVar.mo4487S());
        }
    }

    /* renamed from: a */
    private void m880a(StringBuilder sb, String str, C0409ae.C0410a<?, ?> aVar, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (aVar.mo4496ad()) {
            m879a(sb, aVar, parcel, i);
        } else {
            m884b(sb, aVar, parcel, i);
        }
    }

    /* renamed from: a */
    private void m881a(StringBuilder sb, HashMap<String, C0409ae.C0410a<?, ?>> hashMap, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, C0409ae.C0410a<?, ?>>> b = m883b(hashMap);
        sb.append('{');
        int c = C0357a.m634c(parcel);
        boolean z = false;
        while (parcel.dataPosition() < c) {
            int b2 = C0357a.m631b(parcel);
            Map.Entry entry = b.get(Integer.valueOf(C0357a.m646m(b2)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                m880a(sb, (String) entry.getKey(), (C0409ae.C0410a) entry.getValue(), parcel, b2);
                z = true;
            }
        }
        if (parcel.dataPosition() != c) {
            throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
        }
        sb.append('}');
    }

    /* renamed from: b */
    private static C0414ah m882b(C0409ae aeVar) {
        C0414ah ahVar = new C0414ah(aeVar.getClass());
        m877a(ahVar, aeVar);
        ahVar.mo4514ah();
        ahVar.mo4513ag();
        return ahVar;
    }

    /* renamed from: b */
    private static HashMap<Integer, Map.Entry<String, C0409ae.C0410a<?, ?>>> m883b(HashMap<String, C0409ae.C0410a<?, ?>> hashMap) {
        HashMap<Integer, Map.Entry<String, C0409ae.C0410a<?, ?>>> hashMap2 = new HashMap<>();
        for (Map.Entry next : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0409ae.C0410a) next.getValue()).mo4493aa()), next);
        }
        return hashMap2;
    }

    /* renamed from: b */
    private void m884b(StringBuilder sb, C0409ae.C0410a<?, ?> aVar, Parcel parcel, int i) {
        if (aVar.mo4490Y()) {
            sb.append("[");
            switch (aVar.mo4487S()) {
                case 0:
                    C0421am.m898a(sb, C0357a.m651q(parcel, i));
                    break;
                case 1:
                    C0421am.m900a(sb, (T[]) C0357a.m653s(parcel, i));
                    break;
                case 2:
                    C0421am.m899a(sb, C0357a.m652r(parcel, i));
                    break;
                case 3:
                    C0421am.m897a(sb, C0357a.m654t(parcel, i));
                    break;
                case 4:
                    C0421am.m896a(sb, C0357a.m655u(parcel, i));
                    break;
                case 5:
                    C0421am.m900a(sb, (T[]) C0357a.m656v(parcel, i));
                    break;
                case 6:
                    C0421am.m902a(sb, C0357a.m650p(parcel, i));
                    break;
                case 7:
                    C0421am.m901a(sb, C0357a.m657w(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] z = C0357a.m660z(parcel, i);
                    int length = z.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        z[i2].setDataPosition(0);
                        m881a(sb, aVar.mo4498af(), z[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (aVar.mo4487S()) {
            case 0:
                sb.append(C0357a.m639f(parcel, i));
                return;
            case 1:
                sb.append(C0357a.m641h(parcel, i));
                return;
            case 2:
                sb.append(C0357a.m640g(parcel, i));
                return;
            case 3:
                sb.append(C0357a.m642i(parcel, i));
                return;
            case 4:
                sb.append(C0357a.m643j(parcel, i));
                return;
            case 5:
                sb.append(C0357a.m644k(parcel, i));
                return;
            case 6:
                sb.append(C0357a.m636c(parcel, i));
                return;
            case 7:
                sb.append("\"").append(C0425aq.m907r(C0357a.m645l(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(C0422an.m903a(C0357a.m649o(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(C0422an.m904b(C0357a.m649o(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle n = C0357a.m648n(parcel, i);
                Set<String> keySet = n.keySet();
                keySet.size();
                sb.append("{");
                boolean z2 = true;
                for (String str : keySet) {
                    if (!z2) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(C0425aq.m907r(n.getString(str))).append("\"");
                    z2 = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel y = C0357a.m659y(parcel, i);
                y.setDataPosition(0);
                m881a(sb, aVar.mo4498af(), y);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    /* renamed from: b */
    private void m885b(StringBuilder sb, C0409ae.C0410a<?, ?> aVar, Object obj) {
        if (aVar.mo4489X()) {
            m886b(sb, aVar, (ArrayList<?>) (ArrayList) obj);
        } else {
            m878a(sb, aVar.mo4486R(), obj);
        }
    }

    /* renamed from: b */
    private void m886b(StringBuilder sb, C0409ae.C0410a<?, ?> aVar, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            m878a(sb, aVar.mo4486R(), (Object) arrayList.get(i));
        }
        sb.append("]");
    }

    /* renamed from: T */
    public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
        if (this.f1007cB == null) {
            return null;
        }
        return this.f1007cB.mo4520q(this.mClassName);
    }

    /* renamed from: al */
    public Parcel mo4536al() {
        switch (this.f1010cL) {
            case 0:
                this.f1011cM = C0359b.m684d(this.f1008cJ);
                C0359b.m663C(this.f1008cJ, this.f1011cM);
                this.f1010cL = 2;
                break;
            case 1:
                C0359b.m663C(this.f1008cJ, this.f1011cM);
                this.f1010cL = 2;
                break;
        }
        return this.f1008cJ;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: am */
    public C0414ah mo4537am() {
        switch (this.f1009cK) {
            case 0:
                return null;
            case 1:
                return this.f1007cB;
            case 2:
                return this.f1007cB;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.f1009cK);
        }
    }

    public int describeContents() {
        C0420al alVar = CREATOR;
        return 0;
    }

    /* renamed from: i */
    public int mo4539i() {
        return this.f1006ab;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Object mo4481m(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public boolean mo4482n(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public String toString() {
        C0621s.m1887b(this.f1007cB, (Object) "Cannot convert to JSON on client side.");
        Parcel al = mo4536al();
        al.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m881a(sb, this.f1007cB.mo4520q(this.mClassName), al);
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0420al alVar = CREATOR;
        C0420al.m893a(this, out, flags);
    }
}
