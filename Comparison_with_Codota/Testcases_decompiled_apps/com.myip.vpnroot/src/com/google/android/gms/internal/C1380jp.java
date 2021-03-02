package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1369ji;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.jp */
public class C1380jp extends C1369ji implements SafeParcelable {
    public static final C1381jq CREATOR = new C1381jq();

    /* renamed from: BR */
    private final int f4129BR;

    /* renamed from: MF */
    private final Parcel f4130MF;

    /* renamed from: MG */
    private final int f4131MG;

    /* renamed from: MH */
    private int f4132MH;

    /* renamed from: MI */
    private int f4133MI;

    /* renamed from: My */
    private final C1375jm f4134My;
    private final String mClassName;

    C1380jp(int i, Parcel parcel, C1375jm jmVar) {
        this.f4129BR = i;
        this.f4130MF = (Parcel) C0348n.m861i(parcel);
        this.f4131MG = 2;
        this.f4134My = jmVar;
        if (this.f4134My == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.f4134My.mo9061hv();
        }
        this.f4132MH = 2;
    }

    private C1380jp(SafeParcelable safeParcelable, C1375jm jmVar, String str) {
        this.f4129BR = 1;
        this.f4130MF = Parcel.obtain();
        safeParcelable.writeToParcel(this.f4130MF, 0);
        this.f4131MG = 1;
        this.f4134My = (C1375jm) C0348n.m861i(jmVar);
        this.mClassName = (String) C0348n.m861i(str);
        this.f4132MH = 2;
    }

    /* renamed from: a */
    public static <T extends C1369ji & SafeParcelable> C1380jp m5180a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new C1380jp((SafeParcelable) t, m5186b((C1369ji) t), canonicalName);
    }

    /* renamed from: a */
    private static void m5181a(C1375jm jmVar, C1369ji jiVar) {
        Class<?> cls = jiVar.getClass();
        if (!jmVar.mo9054b(cls)) {
            HashMap<String, C1369ji.C1370a<?, ?>> hf = jiVar.mo9023hf();
            jmVar.mo9053a(cls, jiVar.mo9023hf());
            for (String str : hf.keySet()) {
                C1369ji.C1370a aVar = hf.get(str);
                Class<? extends C1369ji> hn = aVar.mo9038hn();
                if (hn != null) {
                    try {
                        m5181a(jmVar, (C1369ji) hn.newInstance());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + aVar.mo9038hn().getCanonicalName(), e);
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not access object of type " + aVar.mo9038hn().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m5182a(StringBuilder sb, int i, Object obj) {
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
                sb.append("\"").append(C1390jz.m5225bf(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(C1383js.m5210d((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(C1383js.m5211e((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                C1392ka.m5235a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    /* renamed from: a */
    private void m5183a(StringBuilder sb, C1369ji.C1370a<?, ?> aVar, Parcel parcel, int i) {
        switch (aVar.mo9032he()) {
            case 0:
                m5189b(sb, aVar, (Object) mo9016a(aVar, Integer.valueOf(C0352a.m892g(parcel, i))));
                return;
            case 1:
                m5189b(sb, aVar, (Object) mo9016a(aVar, C0352a.m896k(parcel, i)));
                return;
            case 2:
                m5189b(sb, aVar, (Object) mo9016a(aVar, Long.valueOf(C0352a.m894i(parcel, i))));
                return;
            case 3:
                m5189b(sb, aVar, (Object) mo9016a(aVar, Float.valueOf(C0352a.m897l(parcel, i))));
                return;
            case 4:
                m5189b(sb, aVar, (Object) mo9016a(aVar, Double.valueOf(C0352a.m898m(parcel, i))));
                return;
            case 5:
                m5189b(sb, aVar, (Object) mo9016a(aVar, C0352a.m899n(parcel, i)));
                return;
            case 6:
                m5189b(sb, aVar, (Object) mo9016a(aVar, Boolean.valueOf(C0352a.m888c(parcel, i))));
                return;
            case 7:
                m5189b(sb, aVar, (Object) mo9016a(aVar, C0352a.m900o(parcel, i)));
                return;
            case 8:
            case 9:
                m5189b(sb, aVar, (Object) mo9016a(aVar, C0352a.m903r(parcel, i)));
                return;
            case 10:
                m5189b(sb, aVar, (Object) mo9016a(aVar, m5191e(C0352a.m902q(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + aVar.mo9032he());
        }
    }

    /* renamed from: a */
    private void m5184a(StringBuilder sb, String str, C1369ji.C1370a<?, ?> aVar, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (aVar.mo9040hp()) {
            m5183a(sb, aVar, parcel, i);
        } else {
            m5188b(sb, aVar, parcel, i);
        }
    }

    /* renamed from: a */
    private void m5185a(StringBuilder sb, HashMap<String, C1369ji.C1370a<?, ?>> hashMap, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, C1369ji.C1370a<?, ?>>> b = m5187b(hashMap);
        sb.append('{');
        int C = C0352a.m875C(parcel);
        boolean z = false;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            Map.Entry entry = b.get(Integer.valueOf(C0352a.m884aD(B)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                m5184a(sb, (String) entry.getKey(), (C1369ji.C1370a) entry.getValue(), parcel, B);
                z = true;
            }
        }
        if (parcel.dataPosition() != C) {
            throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
        }
        sb.append('}');
    }

    /* renamed from: b */
    private static C1375jm m5186b(C1369ji jiVar) {
        C1375jm jmVar = new C1375jm(jiVar.getClass());
        m5181a(jmVar, jiVar);
        jmVar.mo9059ht();
        jmVar.mo9058hs();
        return jmVar;
    }

    /* renamed from: b */
    private static HashMap<Integer, Map.Entry<String, C1369ji.C1370a<?, ?>>> m5187b(HashMap<String, C1369ji.C1370a<?, ?>> hashMap) {
        HashMap<Integer, Map.Entry<String, C1369ji.C1370a<?, ?>>> hashMap2 = new HashMap<>();
        for (Map.Entry next : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C1369ji.C1370a) next.getValue()).mo9037hm()), next);
        }
        return hashMap2;
    }

    /* renamed from: b */
    private void m5188b(StringBuilder sb, C1369ji.C1370a<?, ?> aVar, Parcel parcel, int i) {
        if (aVar.mo9035hk()) {
            sb.append("[");
            switch (aVar.mo9032he()) {
                case 0:
                    C1382jr.m5202a(sb, C0352a.m906u(parcel, i));
                    break;
                case 1:
                    C1382jr.m5204a(sb, (T[]) C0352a.m908w(parcel, i));
                    break;
                case 2:
                    C1382jr.m5203a(sb, C0352a.m907v(parcel, i));
                    break;
                case 3:
                    C1382jr.m5201a(sb, C0352a.m909x(parcel, i));
                    break;
                case 4:
                    C1382jr.m5200a(sb, C0352a.m910y(parcel, i));
                    break;
                case 5:
                    C1382jr.m5204a(sb, (T[]) C0352a.m911z(parcel, i));
                    break;
                case 6:
                    C1382jr.m5206a(sb, C0352a.m905t(parcel, i));
                    break;
                case 7:
                    C1382jr.m5205a(sb, C0352a.m872A(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] E = C0352a.m878E(parcel, i);
                    int length = E.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        E[i2].setDataPosition(0);
                        m5185a(sb, aVar.mo9042hr(), E[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (aVar.mo9032he()) {
            case 0:
                sb.append(C0352a.m892g(parcel, i));
                return;
            case 1:
                sb.append(C0352a.m896k(parcel, i));
                return;
            case 2:
                sb.append(C0352a.m894i(parcel, i));
                return;
            case 3:
                sb.append(C0352a.m897l(parcel, i));
                return;
            case 4:
                sb.append(C0352a.m898m(parcel, i));
                return;
            case 5:
                sb.append(C0352a.m899n(parcel, i));
                return;
            case 6:
                sb.append(C0352a.m888c(parcel, i));
                return;
            case 7:
                sb.append("\"").append(C1390jz.m5225bf(C0352a.m900o(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(C1383js.m5210d(C0352a.m903r(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(C1383js.m5211e(C0352a.m903r(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle q = C0352a.m902q(parcel, i);
                Set<String> keySet = q.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(C1390jz.m5225bf(q.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel D = C0352a.m877D(parcel, i);
                D.setDataPosition(0);
                m5185a(sb, aVar.mo9042hr(), D);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    /* renamed from: b */
    private void m5189b(StringBuilder sb, C1369ji.C1370a<?, ?> aVar, Object obj) {
        if (aVar.mo9034hj()) {
            m5190b(sb, aVar, (ArrayList<?>) (ArrayList) obj);
        } else {
            m5182a(sb, aVar.mo9031hd(), obj);
        }
    }

    /* renamed from: b */
    private void m5190b(StringBuilder sb, C1369ji.C1370a<?, ?> aVar, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            m5182a(sb, aVar.mo9031hd(), (Object) arrayList.get(i));
        }
        sb.append("]");
    }

    /* renamed from: e */
    public static HashMap<String, String> m5191e(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ba */
    public Object mo9019ba(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: bb */
    public boolean mo9020bb(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        C1381jq jqVar = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.f4129BR;
    }

    /* renamed from: hf */
    public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
        if (this.f4134My == null) {
            return null;
        }
        return this.f4134My.mo9055be(this.mClassName);
    }

    /* renamed from: hx */
    public Parcel mo9079hx() {
        switch (this.f4132MH) {
            case 0:
                this.f4133MI = C0354b.m912D(this.f4130MF);
                C0354b.m915H(this.f4130MF, this.f4133MI);
                this.f4132MH = 2;
                break;
            case 1:
                C0354b.m915H(this.f4130MF, this.f4133MI);
                this.f4132MH = 2;
                break;
        }
        return this.f4130MF;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: hy */
    public C1375jm mo9080hy() {
        switch (this.f4131MG) {
            case 0:
                return null;
            case 1:
                return this.f4134My;
            case 2:
                return this.f4134My;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.f4131MG);
        }
    }

    public String toString() {
        C0348n.m857b(this.f4134My, (Object) "Cannot convert to JSON on client side.");
        Parcel hx = mo9079hx();
        hx.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m5185a(sb, this.f4134My.mo9055be(this.mClassName), hx);
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1381jq jqVar = CREATOR;
        C1381jq.m5197a(this, out, flags);
    }
}
