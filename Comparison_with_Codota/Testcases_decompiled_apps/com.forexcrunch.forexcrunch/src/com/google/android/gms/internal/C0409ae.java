package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ae */
public abstract class C0409ae {

    /* renamed from: com.google.android.gms.internal.ae$a */
    public static class C0410a<I, O> implements SafeParcelable {
        public static final C0412af CREATOR = new C0412af();

        /* renamed from: ab */
        private final int f988ab;

        /* renamed from: cA */
        protected final String f989cA;

        /* renamed from: cB */
        private C0414ah f990cB;
        /* access modifiers changed from: private */

        /* renamed from: cC */
        public C0411b<I, O> f991cC;

        /* renamed from: ct */
        protected final int f992ct;

        /* renamed from: cu */
        protected final boolean f993cu;

        /* renamed from: cv */
        protected final int f994cv;

        /* renamed from: cw */
        protected final boolean f995cw;

        /* renamed from: cx */
        protected final String f996cx;

        /* renamed from: cy */
        protected final int f997cy;

        /* renamed from: cz */
        protected final Class<? extends C0409ae> f998cz;

        C0410a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, C0628z zVar) {
            this.f988ab = i;
            this.f992ct = i2;
            this.f993cu = z;
            this.f994cv = i3;
            this.f995cw = z2;
            this.f996cx = str;
            this.f997cy = i4;
            if (str2 == null) {
                this.f998cz = null;
                this.f989cA = null;
            } else {
                this.f998cz = C0419ak.class;
                this.f989cA = str2;
            }
            if (zVar == null) {
                this.f991cC = null;
            } else {
                this.f991cC = zVar.mo5516P();
            }
        }

        protected C0410a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends C0409ae> cls, C0411b<I, O> bVar) {
            this.f988ab = 1;
            this.f992ct = i;
            this.f993cu = z;
            this.f994cv = i2;
            this.f995cw = z2;
            this.f996cx = str;
            this.f997cy = i3;
            this.f998cz = cls;
            if (cls == null) {
                this.f989cA = null;
            } else {
                this.f989cA = cls.getCanonicalName();
            }
            this.f991cC = bVar;
        }

        /* renamed from: a */
        public static C0410a m825a(String str, int i, C0411b<?, ?> bVar, boolean z) {
            return new C0410a(bVar.mo4457R(), z, bVar.mo4458S(), false, str, i, (Class<? extends C0409ae>) null, bVar);
        }

        /* renamed from: a */
        public static <T extends C0409ae> C0410a<T, T> m826a(String str, int i, Class<T> cls) {
            return new C0410a<>(11, false, 11, false, str, i, cls, (C0411b) null);
        }

        /* renamed from: b */
        public static <T extends C0409ae> C0410a<ArrayList<T>, ArrayList<T>> m827b(String str, int i, Class<T> cls) {
            return new C0410a<>(11, true, 11, true, str, i, cls, (C0411b) null);
        }

        /* renamed from: c */
        public static C0410a<Integer, Integer> m828c(String str, int i) {
            return new C0410a<>(0, false, 0, false, str, i, (Class<? extends C0409ae>) null, (C0411b) null);
        }

        /* renamed from: d */
        public static C0410a<Double, Double> m830d(String str, int i) {
            return new C0410a<>(4, false, 4, false, str, i, (Class<? extends C0409ae>) null, (C0411b) null);
        }

        /* renamed from: e */
        public static C0410a<Boolean, Boolean> m831e(String str, int i) {
            return new C0410a<>(6, false, 6, false, str, i, (Class<? extends C0409ae>) null, (C0411b) null);
        }

        /* renamed from: f */
        public static C0410a<String, String> m832f(String str, int i) {
            return new C0410a<>(7, false, 7, false, str, i, (Class<? extends C0409ae>) null, (C0411b) null);
        }

        /* renamed from: g */
        public static C0410a<ArrayList<String>, ArrayList<String>> m833g(String str, int i) {
            return new C0410a<>(7, true, 7, true, str, i, (Class<? extends C0409ae>) null, (C0411b) null);
        }

        /* renamed from: R */
        public int mo4486R() {
            return this.f992ct;
        }

        /* renamed from: S */
        public int mo4487S() {
            return this.f994cv;
        }

        /* renamed from: W */
        public C0410a<I, O> mo4488W() {
            return new C0410a<>(this.f988ab, this.f992ct, this.f993cu, this.f994cv, this.f995cw, this.f996cx, this.f997cy, this.f989cA, mo4497ae());
        }

        /* renamed from: X */
        public boolean mo4489X() {
            return this.f993cu;
        }

        /* renamed from: Y */
        public boolean mo4490Y() {
            return this.f995cw;
        }

        /* renamed from: Z */
        public String mo4491Z() {
            return this.f996cx;
        }

        /* renamed from: a */
        public void mo4492a(C0414ah ahVar) {
            this.f990cB = ahVar;
        }

        /* renamed from: aa */
        public int mo4493aa() {
            return this.f997cy;
        }

        /* renamed from: ab */
        public Class<? extends C0409ae> mo4494ab() {
            return this.f998cz;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ac */
        public String mo4495ac() {
            if (this.f989cA == null) {
                return null;
            }
            return this.f989cA;
        }

        /* renamed from: ad */
        public boolean mo4496ad() {
            return this.f991cC != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ae */
        public C0628z mo4497ae() {
            if (this.f991cC == null) {
                return null;
            }
            return C0628z.m1912a(this.f991cC);
        }

        /* renamed from: af */
        public HashMap<String, C0410a<?, ?>> mo4498af() {
            C0621s.m1890d(this.f989cA);
            C0621s.m1890d(this.f990cB);
            return this.f990cB.mo4520q(this.f989cA);
        }

        public int describeContents() {
            C0412af afVar = CREATOR;
            return 0;
        }

        /* renamed from: e */
        public I mo4500e(O o) {
            return this.f991cC.mo4462e(o);
        }

        /* renamed from: i */
        public int mo4501i() {
            return this.f988ab;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.f988ab).append(10);
            sb.append("                 typeIn=").append(this.f992ct).append(10);
            sb.append("            typeInArray=").append(this.f993cu).append(10);
            sb.append("                typeOut=").append(this.f994cv).append(10);
            sb.append("           typeOutArray=").append(this.f995cw).append(10);
            sb.append("        outputFieldName=").append(this.f996cx).append(10);
            sb.append("      safeParcelFieldId=").append(this.f997cy).append(10);
            sb.append("       concreteTypeName=").append(mo4495ac()).append(10);
            if (mo4494ab() != null) {
                sb.append("     concreteType.class=").append(mo4494ab().getCanonicalName()).append(10);
            }
            sb.append("          converterName=").append(this.f991cC == null ? "null" : this.f991cC.getClass().getCanonicalName()).append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            C0412af afVar = CREATOR;
            C0412af.m852a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ae$b */
    public interface C0411b<I, O> {
        /* renamed from: R */
        int mo4457R();

        /* renamed from: S */
        int mo4458S();

        /* renamed from: e */
        I mo4462e(O o);
    }

    /* renamed from: a */
    private void m813a(StringBuilder sb, C0410a aVar, Object obj) {
        if (aVar.mo4486R() == 11) {
            sb.append(((C0409ae) aVar.mo4494ab().cast(obj)).toString());
        } else if (aVar.mo4486R() == 7) {
            sb.append("\"");
            sb.append(C0425aq.m907r((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    /* renamed from: a */
    private void m814a(StringBuilder sb, C0410a aVar, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m813a(sb, aVar, obj);
            }
        }
        sb.append("]");
    }

    /* renamed from: T */
    public abstract HashMap<String, C0410a<?, ?>> mo4475T();

    /* renamed from: U */
    public HashMap<String, Object> mo4476U() {
        return null;
    }

    /* renamed from: V */
    public HashMap<String, Object> mo4477V() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <O, I> I mo4478a(C0410a<I, O> aVar, Object obj) {
        return aVar.f991cC != null ? aVar.mo4500e(obj) : obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4479a(C0410a aVar) {
        return aVar.mo4487S() == 11 ? aVar.mo4490Y() ? mo4484p(aVar.mo4491Z()) : mo4483o(aVar.mo4491Z()) : mo4482n(aVar.mo4491Z());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo4480b(C0410a aVar) {
        boolean z = true;
        String Z = aVar.mo4491Z();
        if (aVar.mo4494ab() == null) {
            return mo4481m(aVar.mo4491Z());
        }
        if (mo4481m(aVar.mo4491Z()) != null) {
            z = false;
        }
        C0621s.m1885a(z, "Concrete field shouldn't be value object: " + aVar.mo4491Z());
        HashMap<String, Object> V = aVar.mo4490Y() ? mo4477V() : mo4476U();
        if (V != null) {
            return V.get(Z);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(Z.charAt(0)) + Z.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public abstract Object mo4481m(String str);

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public abstract boolean mo4482n(String str);

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public boolean mo4483o(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo4484p(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        HashMap<String, C0410a<?, ?>> T = mo4475T();
        StringBuilder sb = new StringBuilder(100);
        for (String next : T.keySet()) {
            C0410a aVar = T.get(next);
            if (mo4479a(aVar)) {
                Object a = mo4478a(aVar, mo4480b(aVar));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(next).append("\":");
                if (a != null) {
                    switch (aVar.mo4487S()) {
                        case 8:
                            sb.append("\"").append(C0422an.m903a((byte[]) a)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(C0422an.m904b((byte[]) a)).append("\"");
                            break;
                        case 10:
                            C0426ar.m908a(sb, (HashMap) a);
                            break;
                        default:
                            if (!aVar.mo4489X()) {
                                m813a(sb, aVar, a);
                                break;
                            } else {
                                m814a(sb, aVar, (ArrayList<Object>) (ArrayList) a);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
