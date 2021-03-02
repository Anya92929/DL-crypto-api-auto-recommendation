package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0422dw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ec */
public class C0433ec extends C0422dw implements SafeParcelable {
    public static final C0434ed CREATOR = new C0434ed();

    /* renamed from: iM */
    private final int f1175iM;

    /* renamed from: lH */
    private final C0427dz f1176lH;

    /* renamed from: lP */
    private final Parcel f1177lP;

    /* renamed from: lQ */
    private final int f1178lQ;

    /* renamed from: lR */
    private int f1179lR;

    /* renamed from: lS */
    private int f1180lS;
    private final String mClassName;

    C0433ec(int i, Parcel parcel, C0427dz dzVar) {
        this.f1175iM = i;
        this.f1177lP = (Parcel) C0411dm.m944e(parcel);
        this.f1178lQ = 2;
        this.f1176lH = dzVar;
        if (this.f1176lH == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.f1176lH.mo4470bF();
        }
        this.f1179lR = 2;
    }

    private C0433ec(SafeParcelable safeParcelable, C0427dz dzVar, String str) {
        this.f1175iM = 1;
        this.f1177lP = Parcel.obtain();
        safeParcelable.writeToParcel(this.f1177lP, 0);
        this.f1178lQ = 1;
        this.f1176lH = (C0427dz) C0411dm.m944e(dzVar);
        this.mClassName = (String) C0411dm.m944e(str);
        this.f1179lR = 2;
    }

    /* renamed from: a */
    public static <T extends C0422dw & SafeParcelable> C0433ec m1052a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new C0433ec((SafeParcelable) t, m1058b((C0422dw) t), canonicalName);
    }

    /* renamed from: a */
    private static void m1053a(C0427dz dzVar, C0422dw dwVar) {
        Class<?> cls = dwVar.getClass();
        if (!dzVar.mo4466b((Class<? extends C0422dw>) cls)) {
            HashMap<String, C0422dw.C0423a<?, ?>> bp = dwVar.mo4434bp();
            dzVar.mo4465a(cls, dwVar.mo4434bp());
            for (String str : bp.keySet()) {
                C0422dw.C0423a aVar = bp.get(str);
                Class<? extends C0422dw> bx = aVar.mo4448bx();
                if (bx != null) {
                    try {
                        m1053a(dzVar, (C0422dw) bx.newInstance());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + aVar.mo4448bx().getCanonicalName(), e);
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not access object of type " + aVar.mo4448bx().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1054a(StringBuilder sb, int i, Object obj) {
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
                sb.append("\"").append(C0439ei.m1083I(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(C0436ef.m1079b((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(C0436ef.m1080c((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                C0440ej.m1084a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    /* renamed from: a */
    private void m1055a(StringBuilder sb, C0422dw.C0423a<?, ?> aVar, Parcel parcel, int i) {
        switch (aVar.mo4442bo()) {
            case 0:
                m1062b(sb, aVar, (Object) mo4431a(aVar, Integer.valueOf(C0153a.m314f(parcel, i))));
                return;
            case 1:
                m1062b(sb, aVar, (Object) mo4431a(aVar, C0153a.m316h(parcel, i)));
                return;
            case 2:
                m1062b(sb, aVar, (Object) mo4431a(aVar, Long.valueOf(C0153a.m315g(parcel, i))));
                return;
            case 3:
                m1062b(sb, aVar, (Object) mo4431a(aVar, Float.valueOf(C0153a.m317i(parcel, i))));
                return;
            case 4:
                m1062b(sb, aVar, (Object) mo4431a(aVar, Double.valueOf(C0153a.m319j(parcel, i))));
                return;
            case 5:
                m1062b(sb, aVar, (Object) mo4431a(aVar, C0153a.m321k(parcel, i)));
                return;
            case 6:
                m1062b(sb, aVar, (Object) mo4431a(aVar, Boolean.valueOf(C0153a.m311c(parcel, i))));
                return;
            case 7:
                m1062b(sb, aVar, (Object) mo4431a(aVar, C0153a.m322l(parcel, i)));
                return;
            case 8:
            case 9:
                m1062b(sb, aVar, (Object) mo4431a(aVar, C0153a.m325o(parcel, i)));
                return;
            case 10:
                m1062b(sb, aVar, (Object) mo4431a(aVar, m1059b(C0153a.m324n(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + aVar.mo4442bo());
        }
    }

    /* renamed from: a */
    private void m1056a(StringBuilder sb, String str, C0422dw.C0423a<?, ?> aVar, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (aVar.mo4450bz()) {
            m1055a(sb, aVar, parcel, i);
        } else {
            m1061b(sb, aVar, parcel, i);
        }
    }

    /* renamed from: a */
    private void m1057a(StringBuilder sb, HashMap<String, C0422dw.C0423a<?, ?>> hashMap, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, C0422dw.C0423a<?, ?>>> b = m1060b(hashMap);
        sb.append('{');
        int j = C0153a.m320j(parcel);
        boolean z = false;
        while (parcel.dataPosition() < j) {
            int i = C0153a.m318i(parcel);
            Map.Entry entry = b.get(Integer.valueOf(C0153a.m335y(i)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                m1056a(sb, (String) entry.getKey(), (C0422dw.C0423a) entry.getValue(), parcel, i);
                z = true;
            }
        }
        if (parcel.dataPosition() != j) {
            throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
        }
        sb.append('}');
    }

    /* renamed from: b */
    private static C0427dz m1058b(C0422dw dwVar) {
        C0427dz dzVar = new C0427dz(dwVar.getClass());
        m1053a(dzVar, dwVar);
        dzVar.mo4468bD();
        dzVar.mo4467bC();
        return dzVar;
    }

    /* renamed from: b */
    public static HashMap<String, String> m1059b(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    /* renamed from: b */
    private static HashMap<Integer, Map.Entry<String, C0422dw.C0423a<?, ?>>> m1060b(HashMap<String, C0422dw.C0423a<?, ?>> hashMap) {
        HashMap<Integer, Map.Entry<String, C0422dw.C0423a<?, ?>>> hashMap2 = new HashMap<>();
        for (Map.Entry next : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0422dw.C0423a) next.getValue()).mo4447bw()), next);
        }
        return hashMap2;
    }

    /* renamed from: b */
    private void m1061b(StringBuilder sb, C0422dw.C0423a<?, ?> aVar, Parcel parcel, int i) {
        if (aVar.mo4445bu()) {
            sb.append("[");
            switch (aVar.mo4442bo()) {
                case 0:
                    C0435ee.m1074a(sb, C0153a.m327q(parcel, i));
                    break;
                case 1:
                    C0435ee.m1076a(sb, (T[]) C0153a.m329s(parcel, i));
                    break;
                case 2:
                    C0435ee.m1075a(sb, C0153a.m328r(parcel, i));
                    break;
                case 3:
                    C0435ee.m1073a(sb, C0153a.m330t(parcel, i));
                    break;
                case 4:
                    C0435ee.m1072a(sb, C0153a.m331u(parcel, i));
                    break;
                case 5:
                    C0435ee.m1076a(sb, (T[]) C0153a.m332v(parcel, i));
                    break;
                case 6:
                    C0435ee.m1078a(sb, C0153a.m326p(parcel, i));
                    break;
                case 7:
                    C0435ee.m1077a(sb, C0153a.m333w(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] z = C0153a.m337z(parcel, i);
                    int length = z.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        z[i2].setDataPosition(0);
                        m1057a(sb, aVar.mo4440bB(), z[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (aVar.mo4442bo()) {
            case 0:
                sb.append(C0153a.m314f(parcel, i));
                return;
            case 1:
                sb.append(C0153a.m316h(parcel, i));
                return;
            case 2:
                sb.append(C0153a.m315g(parcel, i));
                return;
            case 3:
                sb.append(C0153a.m317i(parcel, i));
                return;
            case 4:
                sb.append(C0153a.m319j(parcel, i));
                return;
            case 5:
                sb.append(C0153a.m321k(parcel, i));
                return;
            case 6:
                sb.append(C0153a.m311c(parcel, i));
                return;
            case 7:
                sb.append("\"").append(C0439ei.m1083I(C0153a.m322l(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(C0436ef.m1079b(C0153a.m325o(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(C0436ef.m1080c(C0153a.m325o(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle n = C0153a.m324n(parcel, i);
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
                    sb.append("\"").append(C0439ei.m1083I(n.getString(str))).append("\"");
                    z2 = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel y = C0153a.m336y(parcel, i);
                y.setDataPosition(0);
                m1057a(sb, aVar.mo4440bB(), y);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    /* renamed from: b */
    private void m1062b(StringBuilder sb, C0422dw.C0423a<?, ?> aVar, Object obj) {
        if (aVar.mo4444bt()) {
            m1063b(sb, aVar, (ArrayList<?>) (ArrayList) obj);
        } else {
            m1054a(sb, aVar.mo4441bn(), obj);
        }
    }

    /* renamed from: b */
    private void m1063b(StringBuilder sb, C0422dw.C0423a<?, ?> aVar, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            m1054a(sb, aVar.mo4441bn(), (Object) arrayList.get(i));
        }
        sb.append("]");
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public Object mo4427D(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public boolean mo4428E(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* renamed from: bH */
    public Parcel mo4494bH() {
        switch (this.f1179lR) {
            case 0:
                this.f1180lS = C0155b.m361k(this.f1177lP);
                C0155b.m340C(this.f1177lP, this.f1180lS);
                this.f1179lR = 2;
                break;
            case 1:
                C0155b.m340C(this.f1177lP, this.f1180lS);
                this.f1179lR = 2;
                break;
        }
        return this.f1177lP;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bI */
    public C0427dz mo4495bI() {
        switch (this.f1178lQ) {
            case 0:
                return null;
            case 1:
                return this.f1176lH;
            case 2:
                return this.f1176lH;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.f1178lQ);
        }
    }

    /* renamed from: bp */
    public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
        if (this.f1176lH == null) {
            return null;
        }
        return this.f1176lH.mo4464H(this.mClassName);
    }

    public int describeContents() {
        C0434ed edVar = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.f1175iM;
    }

    public String toString() {
        C0411dm.m940a(this.f1176lH, (Object) "Cannot convert to JSON on client side.");
        Parcel bH = mo4494bH();
        bH.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m1057a(sb, this.f1176lH.mo4464H(this.mClassName), bH);
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0434ed edVar = CREATOR;
        C0434ed.m1069a(this, out, flags);
    }
}
