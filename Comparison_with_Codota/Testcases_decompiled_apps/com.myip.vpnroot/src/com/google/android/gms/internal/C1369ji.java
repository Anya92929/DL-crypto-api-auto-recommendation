package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ji */
public abstract class C1369ji {

    /* renamed from: com.google.android.gms.internal.ji$a */
    public static class C1370a<I, O> implements SafeParcelable {
        public static final C1373jk CREATOR = new C1373jk();

        /* renamed from: BR */
        private final int f4111BR;

        /* renamed from: Mq */
        protected final int f4112Mq;

        /* renamed from: Mr */
        protected final boolean f4113Mr;

        /* renamed from: Ms */
        protected final int f4114Ms;

        /* renamed from: Mt */
        protected final boolean f4115Mt;

        /* renamed from: Mu */
        protected final String f4116Mu;

        /* renamed from: Mv */
        protected final int f4117Mv;

        /* renamed from: Mw */
        protected final Class<? extends C1369ji> f4118Mw;

        /* renamed from: Mx */
        protected final String f4119Mx;

        /* renamed from: My */
        private C1375jm f4120My;
        /* access modifiers changed from: private */

        /* renamed from: Mz */
        public C1371b<I, O> f4121Mz;

        C1370a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, C1363jd jdVar) {
            this.f4111BR = i;
            this.f4112Mq = i2;
            this.f4113Mr = z;
            this.f4114Ms = i3;
            this.f4115Mt = z2;
            this.f4116Mu = str;
            this.f4117Mv = i4;
            if (str2 == null) {
                this.f4118Mw = null;
                this.f4119Mx = null;
            } else {
                this.f4118Mw = C1380jp.class;
                this.f4119Mx = str2;
            }
            if (jdVar == null) {
                this.f4121Mz = null;
            } else {
                this.f4121Mz = jdVar.mo8991hb();
            }
        }

        protected C1370a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends C1369ji> cls, C1371b<I, O> bVar) {
            this.f4111BR = 1;
            this.f4112Mq = i;
            this.f4113Mr = z;
            this.f4114Ms = i2;
            this.f4115Mt = z2;
            this.f4116Mu = str;
            this.f4117Mv = i3;
            this.f4118Mw = cls;
            if (cls == null) {
                this.f4119Mx = null;
            } else {
                this.f4119Mx = cls.getCanonicalName();
            }
            this.f4121Mz = bVar;
        }

        /* renamed from: a */
        public static C1370a m5132a(String str, int i, C1371b<?, ?> bVar, boolean z) {
            return new C1370a(bVar.mo9003hd(), z, bVar.mo9004he(), false, str, i, (Class<? extends C1369ji>) null, bVar);
        }

        /* renamed from: a */
        public static <T extends C1369ji> C1370a<T, T> m5133a(String str, int i, Class<T> cls) {
            return new C1370a<>(11, false, 11, false, str, i, cls, (C1371b) null);
        }

        /* renamed from: b */
        public static <T extends C1369ji> C1370a<ArrayList<T>, ArrayList<T>> m5134b(String str, int i, Class<T> cls) {
            return new C1370a<>(11, true, 11, true, str, i, cls, (C1371b) null);
        }

        /* renamed from: i */
        public static C1370a<Integer, Integer> m5136i(String str, int i) {
            return new C1370a<>(0, false, 0, false, str, i, (Class<? extends C1369ji>) null, (C1371b) null);
        }

        /* renamed from: j */
        public static C1370a<Double, Double> m5137j(String str, int i) {
            return new C1370a<>(4, false, 4, false, str, i, (Class<? extends C1369ji>) null, (C1371b) null);
        }

        /* renamed from: k */
        public static C1370a<Boolean, Boolean> m5138k(String str, int i) {
            return new C1370a<>(6, false, 6, false, str, i, (Class<? extends C1369ji>) null, (C1371b) null);
        }

        /* renamed from: l */
        public static C1370a<String, String> m5139l(String str, int i) {
            return new C1370a<>(7, false, 7, false, str, i, (Class<? extends C1369ji>) null, (C1371b) null);
        }

        /* renamed from: m */
        public static C1370a<ArrayList<String>, ArrayList<String>> m5140m(String str, int i) {
            return new C1370a<>(7, true, 7, true, str, i, (Class<? extends C1369ji>) null, (C1371b) null);
        }

        /* renamed from: a */
        public void mo9027a(C1375jm jmVar) {
            this.f4120My = jmVar;
        }

        public I convertBack(O output) {
            return this.f4121Mz.convertBack(output);
        }

        public int describeContents() {
            C1373jk jkVar = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.f4111BR;
        }

        /* renamed from: hd */
        public int mo9031hd() {
            return this.f4112Mq;
        }

        /* renamed from: he */
        public int mo9032he() {
            return this.f4114Ms;
        }

        /* renamed from: hi */
        public C1370a<I, O> mo9033hi() {
            return new C1370a<>(this.f4111BR, this.f4112Mq, this.f4113Mr, this.f4114Ms, this.f4115Mt, this.f4116Mu, this.f4117Mv, this.f4119Mx, mo9041hq());
        }

        /* renamed from: hj */
        public boolean mo9034hj() {
            return this.f4113Mr;
        }

        /* renamed from: hk */
        public boolean mo9035hk() {
            return this.f4115Mt;
        }

        /* renamed from: hl */
        public String mo9036hl() {
            return this.f4116Mu;
        }

        /* renamed from: hm */
        public int mo9037hm() {
            return this.f4117Mv;
        }

        /* renamed from: hn */
        public Class<? extends C1369ji> mo9038hn() {
            return this.f4118Mw;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ho */
        public String mo9039ho() {
            if (this.f4119Mx == null) {
                return null;
            }
            return this.f4119Mx;
        }

        /* renamed from: hp */
        public boolean mo9040hp() {
            return this.f4121Mz != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: hq */
        public C1363jd mo9041hq() {
            if (this.f4121Mz == null) {
                return null;
            }
            return C1363jd.m5102a(this.f4121Mz);
        }

        /* renamed from: hr */
        public HashMap<String, C1370a<?, ?>> mo9042hr() {
            C0348n.m861i(this.f4119Mx);
            C0348n.m861i(this.f4120My);
            return this.f4120My.mo9055be(this.f4119Mx);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.f4111BR).append(10);
            sb.append("                 typeIn=").append(this.f4112Mq).append(10);
            sb.append("            typeInArray=").append(this.f4113Mr).append(10);
            sb.append("                typeOut=").append(this.f4114Ms).append(10);
            sb.append("           typeOutArray=").append(this.f4115Mt).append(10);
            sb.append("        outputFieldName=").append(this.f4116Mu).append(10);
            sb.append("      safeParcelFieldId=").append(this.f4117Mv).append(10);
            sb.append("       concreteTypeName=").append(mo9039ho()).append(10);
            if (mo9038hn() != null) {
                sb.append("     concreteType.class=").append(mo9038hn().getCanonicalName()).append(10);
            }
            sb.append("          converterName=").append(this.f4121Mz == null ? "null" : this.f4121Mz.getClass().getCanonicalName()).append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            C1373jk jkVar = CREATOR;
            C1373jk.m5158a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ji$b */
    public interface C1371b<I, O> {
        I convertBack(O o);

        /* renamed from: hd */
        int mo9003hd();

        /* renamed from: he */
        int mo9004he();
    }

    /* renamed from: a */
    private void m5120a(StringBuilder sb, C1370a aVar, Object obj) {
        if (aVar.mo9031hd() == 11) {
            sb.append(((C1369ji) aVar.mo9038hn().cast(obj)).toString());
        } else if (aVar.mo9031hd() == 7) {
            sb.append("\"");
            sb.append(C1390jz.m5225bf((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    /* renamed from: a */
    private void m5121a(StringBuilder sb, C1370a aVar, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m5120a(sb, aVar, obj);
            }
        }
        sb.append("]");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <O, I> I mo9016a(C1370a<I, O> aVar, Object obj) {
        return aVar.f4121Mz != null ? aVar.convertBack(obj) : obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo9017a(C1370a aVar) {
        return aVar.mo9032he() == 11 ? aVar.mo9035hk() ? mo9022bd(aVar.mo9036hl()) : mo9021bc(aVar.mo9036hl()) : mo9020bb(aVar.mo9036hl());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo9018b(C1370a aVar) {
        String hl = aVar.mo9036hl();
        if (aVar.mo9038hn() == null) {
            return mo9019ba(aVar.mo9036hl());
        }
        C0348n.m853a(mo9019ba(aVar.mo9036hl()) == null, "Concrete field shouldn't be value object: %s", aVar.mo9036hl());
        HashMap<String, Object> hh = aVar.mo9035hk() ? mo9025hh() : mo9024hg();
        if (hh != null) {
            return hh.get(hl);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(hl.charAt(0)) + hl.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ba */
    public abstract Object mo9019ba(String str);

    /* access modifiers changed from: protected */
    /* renamed from: bb */
    public abstract boolean mo9020bb(String str);

    /* access modifiers changed from: protected */
    /* renamed from: bc */
    public boolean mo9021bc(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    /* renamed from: bd */
    public boolean mo9022bd(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    /* renamed from: hf */
    public abstract HashMap<String, C1370a<?, ?>> mo9023hf();

    /* renamed from: hg */
    public HashMap<String, Object> mo9024hg() {
        return null;
    }

    /* renamed from: hh */
    public HashMap<String, Object> mo9025hh() {
        return null;
    }

    public String toString() {
        HashMap<String, C1370a<?, ?>> hf = mo9023hf();
        StringBuilder sb = new StringBuilder(100);
        for (String next : hf.keySet()) {
            C1370a aVar = hf.get(next);
            if (mo9017a(aVar)) {
                Object a = mo9016a(aVar, mo9018b(aVar));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(next).append("\":");
                if (a != null) {
                    switch (aVar.mo9032he()) {
                        case 8:
                            sb.append("\"").append(C1383js.m5210d((byte[]) a)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(C1383js.m5211e((byte[]) a)).append("\"");
                            break;
                        case 10:
                            C1392ka.m5235a(sb, (HashMap) a);
                            break;
                        default:
                            if (!aVar.mo9034hj()) {
                                m5120a(sb, aVar, a);
                                break;
                            } else {
                                m5121a(sb, aVar, (ArrayList<Object>) (ArrayList) a);
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
