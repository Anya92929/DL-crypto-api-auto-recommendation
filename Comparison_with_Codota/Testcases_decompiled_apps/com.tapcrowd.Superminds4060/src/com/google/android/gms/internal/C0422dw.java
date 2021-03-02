package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.dw */
public abstract class C0422dw {

    /* renamed from: com.google.android.gms.internal.dw$a */
    public static class C0423a<I, O> implements SafeParcelable {
        public static final C0425dx CREATOR = new C0425dx();

        /* renamed from: iM */
        private final int f1153iM;

        /* renamed from: lA */
        protected final boolean f1154lA;

        /* renamed from: lB */
        protected final int f1155lB;

        /* renamed from: lC */
        protected final boolean f1156lC;

        /* renamed from: lD */
        protected final String f1157lD;

        /* renamed from: lE */
        protected final int f1158lE;

        /* renamed from: lF */
        protected final Class<? extends C0422dw> f1159lF;

        /* renamed from: lG */
        protected final String f1160lG;

        /* renamed from: lH */
        private C0427dz f1161lH;
        /* access modifiers changed from: private */

        /* renamed from: lI */
        public C0424b<I, O> f1162lI;

        /* renamed from: lz */
        protected final int f1163lz;

        C0423a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, C0416dr drVar) {
            this.f1153iM = i;
            this.f1163lz = i2;
            this.f1154lA = z;
            this.f1155lB = i3;
            this.f1156lC = z2;
            this.f1157lD = str;
            this.f1158lE = i4;
            if (str2 == null) {
                this.f1159lF = null;
                this.f1160lG = null;
            } else {
                this.f1159lF = C0433ec.class;
                this.f1160lG = str2;
            }
            if (drVar == null) {
                this.f1162lI = null;
            } else {
                this.f1162lI = drVar.mo4400bl();
            }
        }

        protected C0423a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends C0422dw> cls, C0424b<I, O> bVar) {
            this.f1153iM = 1;
            this.f1163lz = i;
            this.f1154lA = z;
            this.f1155lB = i2;
            this.f1156lC = z2;
            this.f1157lD = str;
            this.f1158lE = i3;
            this.f1159lF = cls;
            if (cls == null) {
                this.f1160lG = null;
            } else {
                this.f1160lG = cls.getCanonicalName();
            }
            this.f1162lI = bVar;
        }

        /* renamed from: a */
        public static C0423a m991a(String str, int i, C0424b<?, ?> bVar, boolean z) {
            return new C0423a(bVar.mo4410bn(), z, bVar.mo4411bo(), false, str, i, (Class<? extends C0422dw>) null, bVar);
        }

        /* renamed from: a */
        public static <T extends C0422dw> C0423a<T, T> m992a(String str, int i, Class<T> cls) {
            return new C0423a<>(11, false, 11, false, str, i, cls, (C0424b) null);
        }

        /* renamed from: b */
        public static <T extends C0422dw> C0423a<ArrayList<T>, ArrayList<T>> m993b(String str, int i, Class<T> cls) {
            return new C0423a<>(11, true, 11, true, str, i, cls, (C0424b) null);
        }

        /* renamed from: d */
        public static C0423a<Integer, Integer> m995d(String str, int i) {
            return new C0423a<>(0, false, 0, false, str, i, (Class<? extends C0422dw>) null, (C0424b) null);
        }

        /* renamed from: e */
        public static C0423a<Double, Double> m996e(String str, int i) {
            return new C0423a<>(4, false, 4, false, str, i, (Class<? extends C0422dw>) null, (C0424b) null);
        }

        /* renamed from: f */
        public static C0423a<Boolean, Boolean> m997f(String str, int i) {
            return new C0423a<>(6, false, 6, false, str, i, (Class<? extends C0422dw>) null, (C0424b) null);
        }

        /* renamed from: g */
        public static C0423a<String, String> m998g(String str, int i) {
            return new C0423a<>(7, false, 7, false, str, i, (Class<? extends C0422dw>) null, (C0424b) null);
        }

        /* renamed from: h */
        public static C0423a<ArrayList<String>, ArrayList<String>> m999h(String str, int i) {
            return new C0423a<>(7, true, 7, true, str, i, (Class<? extends C0422dw>) null, (C0424b) null);
        }

        /* renamed from: a */
        public void mo4438a(C0427dz dzVar) {
            this.f1161lH = dzVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bA */
        public C0416dr mo4439bA() {
            if (this.f1162lI == null) {
                return null;
            }
            return C0416dr.m960a(this.f1162lI);
        }

        /* renamed from: bB */
        public HashMap<String, C0423a<?, ?>> mo4440bB() {
            C0411dm.m944e(this.f1160lG);
            C0411dm.m944e(this.f1161lH);
            return this.f1161lH.mo4464H(this.f1160lG);
        }

        /* renamed from: bn */
        public int mo4441bn() {
            return this.f1163lz;
        }

        /* renamed from: bo */
        public int mo4442bo() {
            return this.f1155lB;
        }

        /* renamed from: bs */
        public C0423a<I, O> mo4443bs() {
            return new C0423a<>(this.f1153iM, this.f1163lz, this.f1154lA, this.f1155lB, this.f1156lC, this.f1157lD, this.f1158lE, this.f1160lG, mo4439bA());
        }

        /* renamed from: bt */
        public boolean mo4444bt() {
            return this.f1154lA;
        }

        /* renamed from: bu */
        public boolean mo4445bu() {
            return this.f1156lC;
        }

        /* renamed from: bv */
        public String mo4446bv() {
            return this.f1157lD;
        }

        /* renamed from: bw */
        public int mo4447bw() {
            return this.f1158lE;
        }

        /* renamed from: bx */
        public Class<? extends C0422dw> mo4448bx() {
            return this.f1159lF;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: by */
        public String mo4449by() {
            if (this.f1160lG == null) {
                return null;
            }
            return this.f1160lG;
        }

        /* renamed from: bz */
        public boolean mo4450bz() {
            return this.f1162lI != null;
        }

        public int describeContents() {
            C0425dx dxVar = CREATOR;
            return 0;
        }

        /* renamed from: f */
        public I mo4452f(O o) {
            return this.f1162lI.mo4414f(o);
        }

        public int getVersionCode() {
            return this.f1153iM;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.f1153iM).append(10);
            sb.append("                 typeIn=").append(this.f1163lz).append(10);
            sb.append("            typeInArray=").append(this.f1154lA).append(10);
            sb.append("                typeOut=").append(this.f1155lB).append(10);
            sb.append("           typeOutArray=").append(this.f1156lC).append(10);
            sb.append("        outputFieldName=").append(this.f1157lD).append(10);
            sb.append("      safeParcelFieldId=").append(this.f1158lE).append(10);
            sb.append("       concreteTypeName=").append(mo4449by()).append(10);
            if (mo4448bx() != null) {
                sb.append("     concreteType.class=").append(mo4448bx().getCanonicalName()).append(10);
            }
            sb.append("          converterName=").append(this.f1162lI == null ? "null" : this.f1162lI.getClass().getCanonicalName()).append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            C0425dx dxVar = CREATOR;
            C0425dx.m1017a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.dw$b */
    public interface C0424b<I, O> {
        /* renamed from: bn */
        int mo4410bn();

        /* renamed from: bo */
        int mo4411bo();

        /* renamed from: f */
        I mo4414f(O o);
    }

    /* renamed from: a */
    private void m979a(StringBuilder sb, C0423a aVar, Object obj) {
        if (aVar.mo4441bn() == 11) {
            sb.append(((C0422dw) aVar.mo4448bx().cast(obj)).toString());
        } else if (aVar.mo4441bn() == 7) {
            sb.append("\"");
            sb.append(C0439ei.m1083I((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    /* renamed from: a */
    private void m980a(StringBuilder sb, C0423a aVar, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m979a(sb, aVar, obj);
            }
        }
        sb.append("]");
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public abstract Object mo4427D(String str);

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public abstract boolean mo4428E(String str);

    /* access modifiers changed from: protected */
    /* renamed from: F */
    public boolean mo4429F(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    /* renamed from: G */
    public boolean mo4430G(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <O, I> I mo4431a(C0423a<I, O> aVar, Object obj) {
        return aVar.f1162lI != null ? aVar.mo4452f(obj) : obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4432a(C0423a aVar) {
        return aVar.mo4442bo() == 11 ? aVar.mo4445bu() ? mo4430G(aVar.mo4446bv()) : mo4429F(aVar.mo4446bv()) : mo4428E(aVar.mo4446bv());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo4433b(C0423a aVar) {
        boolean z = true;
        String bv = aVar.mo4446bv();
        if (aVar.mo4448bx() == null) {
            return mo4427D(aVar.mo4446bv());
        }
        if (mo4427D(aVar.mo4446bv()) != null) {
            z = false;
        }
        C0411dm.m941a(z, (Object) "Concrete field shouldn't be value object: " + aVar.mo4446bv());
        HashMap<String, Object> br = aVar.mo4445bu() ? mo4436br() : mo4435bq();
        if (br != null) {
            return br.get(bv);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(bv.charAt(0)) + bv.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: bp */
    public abstract HashMap<String, C0423a<?, ?>> mo4434bp();

    /* renamed from: bq */
    public HashMap<String, Object> mo4435bq() {
        return null;
    }

    /* renamed from: br */
    public HashMap<String, Object> mo4436br() {
        return null;
    }

    public String toString() {
        HashMap<String, C0423a<?, ?>> bp = mo4434bp();
        StringBuilder sb = new StringBuilder(100);
        for (String next : bp.keySet()) {
            C0423a aVar = bp.get(next);
            if (mo4432a(aVar)) {
                Object a = mo4431a(aVar, mo4433b(aVar));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(next).append("\":");
                if (a != null) {
                    switch (aVar.mo4442bo()) {
                        case 8:
                            sb.append("\"").append(C0436ef.m1079b((byte[]) a)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(C0436ef.m1080c((byte[]) a)).append("\"");
                            break;
                        case 10:
                            C0440ej.m1084a(sb, (HashMap) a);
                            break;
                        default:
                            if (!aVar.mo4444bt()) {
                                m979a(sb, aVar, a);
                                break;
                            } else {
                                m980a(sb, aVar, (ArrayList<Object>) (ArrayList) a);
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
