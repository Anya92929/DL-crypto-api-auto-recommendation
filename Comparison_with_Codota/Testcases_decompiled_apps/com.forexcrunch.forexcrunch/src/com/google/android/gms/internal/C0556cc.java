package com.google.android.gms.internal;

import android.os.Parcel;
import com.forexcrunch.forexcrunch.gui.ChartActivity;
import com.google.analytics.tracking.android.ModelFields;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0409ae;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.cc */
public final class C0556cc extends C0409ae implements SafeParcelable, Person {
    public static final C0567cd CREATOR = new C0567cd();

    /* renamed from: iC */
    private static final HashMap<String, C0409ae.C0410a<?, ?>> f1259iC = new HashMap<>();

    /* renamed from: ab */
    private final int f1260ab;

    /* renamed from: cl */
    private String f1261cl;

    /* renamed from: iD */
    private final Set<Integer> f1262iD;

    /* renamed from: ie */
    private String f1263ie;

    /* renamed from: jE */
    private String f1264jE;

    /* renamed from: jF */
    private C0557a f1265jF;

    /* renamed from: jG */
    private String f1266jG;

    /* renamed from: jH */
    private String f1267jH;

    /* renamed from: jI */
    private int f1268jI;

    /* renamed from: jJ */
    private C0558b f1269jJ;

    /* renamed from: jK */
    private String f1270jK;

    /* renamed from: jL */
    private int f1271jL;

    /* renamed from: jM */
    private C0561c f1272jM;

    /* renamed from: jN */
    private boolean f1273jN;

    /* renamed from: jO */
    private String f1274jO;

    /* renamed from: jP */
    private C0562d f1275jP;

    /* renamed from: jQ */
    private String f1276jQ;

    /* renamed from: jR */
    private int f1277jR;

    /* renamed from: jS */
    private List<C0564f> f1278jS;

    /* renamed from: jT */
    private List<C0565g> f1279jT;

    /* renamed from: jU */
    private int f1280jU;

    /* renamed from: jV */
    private int f1281jV;

    /* renamed from: jW */
    private String f1282jW;

    /* renamed from: jX */
    private List<C0566h> f1283jX;

    /* renamed from: jY */
    private boolean f1284jY;

    /* renamed from: jh */
    private String f1285jh;

    /* renamed from: com.google.android.gms.internal.cc$a */
    public static final class C0557a extends C0409ae implements SafeParcelable, Person.AgeRange {
        public static final C0568ce CREATOR = new C0568ce();

        /* renamed from: iC */
        private static final HashMap<String, C0409ae.C0410a<?, ?>> f1286iC = new HashMap<>();

        /* renamed from: ab */
        private final int f1287ab;

        /* renamed from: iD */
        private final Set<Integer> f1288iD;

        /* renamed from: jZ */
        private int f1289jZ;

        /* renamed from: ka */
        private int f1290ka;

        static {
            f1286iC.put("max", C0409ae.C0410a.m828c("max", 2));
            f1286iC.put("min", C0409ae.C0410a.m828c("min", 3));
        }

        public C0557a() {
            this.f1287ab = 1;
            this.f1288iD = new HashSet();
        }

        C0557a(Set<Integer> set, int i, int i2, int i3) {
            this.f1288iD = set;
            this.f1287ab = i;
            this.f1289jZ = i2;
            this.f1290ka = i3;
        }

        /* renamed from: T */
        public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
            return f1286iC;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4479a(C0409ae.C0410a aVar) {
            return this.f1288iD.contains(Integer.valueOf(aVar.mo4493aa()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4480b(C0409ae.C0410a aVar) {
            switch (aVar.mo4493aa()) {
                case 2:
                    return Integer.valueOf(this.f1289jZ);
                case 3:
                    return Integer.valueOf(this.f1290ka);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bH */
        public Set<Integer> mo5178bH() {
            return this.f1288iD;
        }

        /* renamed from: ck */
        public C0557a freeze() {
            return this;
        }

        public int describeContents() {
            C0568ce ceVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0557a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0557a aVar = (C0557a) obj;
            for (C0409ae.C0410a next : f1286iC.values()) {
                if (mo4479a(next)) {
                    if (!aVar.mo4479a(next)) {
                        return false;
                    }
                    if (!mo4480b(next).equals(aVar.mo4480b(next))) {
                        return false;
                    }
                } else if (aVar.mo4479a(next)) {
                    return false;
                }
            }
            return true;
        }

        public int getMax() {
            return this.f1289jZ;
        }

        public int getMin() {
            return this.f1290ka;
        }

        public boolean hasMax() {
            return this.f1288iD.contains(2);
        }

        public boolean hasMin() {
            return this.f1288iD.contains(3);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0409ae.C0410a<?, ?>> it = f1286iC.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0409ae.C0410a next = it.next();
                if (mo4479a(next)) {
                    i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                } else {
                    i = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public int mo5187i() {
            return this.f1287ab;
        }

        public boolean isDataValid() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public Object mo4481m(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public boolean mo4482n(String str) {
            return false;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0568ce ceVar = CREATOR;
            C0568ce.m1696a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$b */
    public static final class C0558b extends C0409ae implements SafeParcelable, Person.Cover {
        public static final C0569cf CREATOR = new C0569cf();

        /* renamed from: iC */
        private static final HashMap<String, C0409ae.C0410a<?, ?>> f1291iC = new HashMap<>();

        /* renamed from: ab */
        private final int f1292ab;

        /* renamed from: iD */
        private final Set<Integer> f1293iD;

        /* renamed from: kb */
        private C0559a f1294kb;

        /* renamed from: kc */
        private C0560b f1295kc;

        /* renamed from: kd */
        private int f1296kd;

        /* renamed from: com.google.android.gms.internal.cc$b$a */
        public static final class C0559a extends C0409ae implements SafeParcelable, Person.Cover.CoverInfo {
            public static final C0570cg CREATOR = new C0570cg();

            /* renamed from: iC */
            private static final HashMap<String, C0409ae.C0410a<?, ?>> f1297iC = new HashMap<>();

            /* renamed from: ab */
            private final int f1298ab;

            /* renamed from: iD */
            private final Set<Integer> f1299iD;

            /* renamed from: ke */
            private int f1300ke;

            /* renamed from: kf */
            private int f1301kf;

            static {
                f1297iC.put("leftImageOffset", C0409ae.C0410a.m828c("leftImageOffset", 2));
                f1297iC.put("topImageOffset", C0409ae.C0410a.m828c("topImageOffset", 3));
            }

            public C0559a() {
                this.f1298ab = 1;
                this.f1299iD = new HashSet();
            }

            C0559a(Set<Integer> set, int i, int i2, int i3) {
                this.f1299iD = set;
                this.f1298ab = i;
                this.f1300ke = i2;
                this.f1301kf = i3;
            }

            /* renamed from: T */
            public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
                return f1297iC;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo4479a(C0409ae.C0410a aVar) {
                return this.f1299iD.contains(Integer.valueOf(aVar.mo4493aa()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Object mo4480b(C0409ae.C0410a aVar) {
                switch (aVar.mo4493aa()) {
                    case 2:
                        return Integer.valueOf(this.f1300ke);
                    case 3:
                        return Integer.valueOf(this.f1301kf);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: bH */
            public Set<Integer> mo5204bH() {
                return this.f1299iD;
            }

            /* renamed from: co */
            public C0559a freeze() {
                return this;
            }

            public int describeContents() {
                C0570cg cgVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0559a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0559a aVar = (C0559a) obj;
                for (C0409ae.C0410a next : f1297iC.values()) {
                    if (mo4479a(next)) {
                        if (!aVar.mo4479a(next)) {
                            return false;
                        }
                        if (!mo4480b(next).equals(aVar.mo4480b(next))) {
                            return false;
                        }
                    } else if (aVar.mo4479a(next)) {
                        return false;
                    }
                }
                return true;
            }

            public int getLeftImageOffset() {
                return this.f1300ke;
            }

            public int getTopImageOffset() {
                return this.f1301kf;
            }

            public boolean hasLeftImageOffset() {
                return this.f1299iD.contains(2);
            }

            public boolean hasTopImageOffset() {
                return this.f1299iD.contains(3);
            }

            public int hashCode() {
                int i = 0;
                Iterator<C0409ae.C0410a<?, ?>> it = f1297iC.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    C0409ae.C0410a next = it.next();
                    if (mo4479a(next)) {
                        i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                    } else {
                        i = i2;
                    }
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public int mo5213i() {
                return this.f1298ab;
            }

            public boolean isDataValid() {
                return true;
            }

            /* access modifiers changed from: protected */
            /* renamed from: m */
            public Object mo4481m(String str) {
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: n */
            public boolean mo4482n(String str) {
                return false;
            }

            public void writeToParcel(Parcel out, int flags) {
                C0570cg cgVar = CREATOR;
                C0570cg.m1702a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.cc$b$b */
        public static final class C0560b extends C0409ae implements SafeParcelable, Person.Cover.CoverPhoto {
            public static final C0571ch CREATOR = new C0571ch();

            /* renamed from: iC */
            private static final HashMap<String, C0409ae.C0410a<?, ?>> f1302iC = new HashMap<>();

            /* renamed from: ab */
            private final int f1303ab;

            /* renamed from: hL */
            private int f1304hL;

            /* renamed from: hM */
            private int f1305hM;

            /* renamed from: iD */
            private final Set<Integer> f1306iD;

            /* renamed from: ie */
            private String f1307ie;

            static {
                f1302iC.put("height", C0409ae.C0410a.m828c("height", 2));
                f1302iC.put("url", C0409ae.C0410a.m832f("url", 3));
                f1302iC.put("width", C0409ae.C0410a.m828c("width", 4));
            }

            public C0560b() {
                this.f1303ab = 1;
                this.f1306iD = new HashSet();
            }

            C0560b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.f1306iD = set;
                this.f1303ab = i;
                this.f1305hM = i2;
                this.f1307ie = str;
                this.f1304hL = i3;
            }

            /* renamed from: T */
            public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
                return f1302iC;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo4479a(C0409ae.C0410a aVar) {
                return this.f1306iD.contains(Integer.valueOf(aVar.mo4493aa()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Object mo4480b(C0409ae.C0410a aVar) {
                switch (aVar.mo4493aa()) {
                    case 2:
                        return Integer.valueOf(this.f1305hM);
                    case 3:
                        return this.f1307ie;
                    case 4:
                        return Integer.valueOf(this.f1304hL);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: bH */
            public Set<Integer> mo5215bH() {
                return this.f1306iD;
            }

            /* renamed from: cp */
            public C0560b freeze() {
                return this;
            }

            public int describeContents() {
                C0571ch chVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0560b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0560b bVar = (C0560b) obj;
                for (C0409ae.C0410a next : f1302iC.values()) {
                    if (mo4479a(next)) {
                        if (!bVar.mo4479a(next)) {
                            return false;
                        }
                        if (!mo4480b(next).equals(bVar.mo4480b(next))) {
                            return false;
                        }
                    } else if (bVar.mo4479a(next)) {
                        return false;
                    }
                }
                return true;
            }

            public int getHeight() {
                return this.f1305hM;
            }

            public String getUrl() {
                return this.f1307ie;
            }

            public int getWidth() {
                return this.f1304hL;
            }

            public boolean hasHeight() {
                return this.f1306iD.contains(2);
            }

            public boolean hasUrl() {
                return this.f1306iD.contains(3);
            }

            public boolean hasWidth() {
                return this.f1306iD.contains(4);
            }

            public int hashCode() {
                int i = 0;
                Iterator<C0409ae.C0410a<?, ?>> it = f1302iC.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    C0409ae.C0410a next = it.next();
                    if (mo4479a(next)) {
                        i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                    } else {
                        i = i2;
                    }
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public int mo5226i() {
                return this.f1303ab;
            }

            public boolean isDataValid() {
                return true;
            }

            /* access modifiers changed from: protected */
            /* renamed from: m */
            public Object mo4481m(String str) {
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: n */
            public boolean mo4482n(String str) {
                return false;
            }

            public void writeToParcel(Parcel out, int flags) {
                C0571ch chVar = CREATOR;
                C0571ch.m1705a(this, out, flags);
            }
        }

        static {
            f1291iC.put("coverInfo", C0409ae.C0410a.m826a("coverInfo", 2, C0559a.class));
            f1291iC.put("coverPhoto", C0409ae.C0410a.m826a("coverPhoto", 3, C0560b.class));
            f1291iC.put("layout", C0409ae.C0410a.m825a("layout", 4, new C0405ab().mo4460b("banner", 0), false));
        }

        public C0558b() {
            this.f1292ab = 1;
            this.f1293iD = new HashSet();
        }

        C0558b(Set<Integer> set, int i, C0559a aVar, C0560b bVar, int i2) {
            this.f1293iD = set;
            this.f1292ab = i;
            this.f1294kb = aVar;
            this.f1295kc = bVar;
            this.f1296kd = i2;
        }

        /* renamed from: T */
        public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
            return f1291iC;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4479a(C0409ae.C0410a aVar) {
            return this.f1293iD.contains(Integer.valueOf(aVar.mo4493aa()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4480b(C0409ae.C0410a aVar) {
            switch (aVar.mo4493aa()) {
                case 2:
                    return this.f1294kb;
                case 3:
                    return this.f1295kc;
                case 4:
                    return Integer.valueOf(this.f1296kd);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bH */
        public Set<Integer> mo5189bH() {
            return this.f1293iD;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: cl */
        public C0559a mo5190cl() {
            return this.f1294kb;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: cm */
        public C0560b mo5191cm() {
            return this.f1295kc;
        }

        /* renamed from: cn */
        public C0558b freeze() {
            return this;
        }

        public int describeContents() {
            C0569cf cfVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0558b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0558b bVar = (C0558b) obj;
            for (C0409ae.C0410a next : f1291iC.values()) {
                if (mo4479a(next)) {
                    if (!bVar.mo4479a(next)) {
                        return false;
                    }
                    if (!mo4480b(next).equals(bVar.mo4480b(next))) {
                        return false;
                    }
                } else if (bVar.mo4479a(next)) {
                    return false;
                }
            }
            return true;
        }

        public Person.Cover.CoverInfo getCoverInfo() {
            return this.f1294kb;
        }

        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.f1295kc;
        }

        public int getLayout() {
            return this.f1296kd;
        }

        public boolean hasCoverInfo() {
            return this.f1293iD.contains(2);
        }

        public boolean hasCoverPhoto() {
            return this.f1293iD.contains(3);
        }

        public boolean hasLayout() {
            return this.f1293iD.contains(4);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0409ae.C0410a<?, ?>> it = f1291iC.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0409ae.C0410a next = it.next();
                if (mo4479a(next)) {
                    i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                } else {
                    i = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public int mo5202i() {
            return this.f1292ab;
        }

        public boolean isDataValid() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public Object mo4481m(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public boolean mo4482n(String str) {
            return false;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0569cf cfVar = CREATOR;
            C0569cf.m1699a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$c */
    public static final class C0561c extends C0409ae implements SafeParcelable, Person.Image {
        public static final C0572ci CREATOR = new C0572ci();

        /* renamed from: iC */
        private static final HashMap<String, C0409ae.C0410a<?, ?>> f1308iC = new HashMap<>();

        /* renamed from: ab */
        private final int f1309ab;

        /* renamed from: iD */
        private final Set<Integer> f1310iD;

        /* renamed from: ie */
        private String f1311ie;

        static {
            f1308iC.put("url", C0409ae.C0410a.m832f("url", 2));
        }

        public C0561c() {
            this.f1309ab = 1;
            this.f1310iD = new HashSet();
        }

        public C0561c(String str) {
            this.f1310iD = new HashSet();
            this.f1309ab = 1;
            this.f1311ie = str;
            this.f1310iD.add(2);
        }

        C0561c(Set<Integer> set, int i, String str) {
            this.f1310iD = set;
            this.f1309ab = i;
            this.f1311ie = str;
        }

        /* renamed from: T */
        public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
            return f1308iC;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4479a(C0409ae.C0410a aVar) {
            return this.f1310iD.contains(Integer.valueOf(aVar.mo4493aa()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4480b(C0409ae.C0410a aVar) {
            switch (aVar.mo4493aa()) {
                case 2:
                    return this.f1311ie;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bH */
        public Set<Integer> mo5228bH() {
            return this.f1310iD;
        }

        /* renamed from: cq */
        public C0561c freeze() {
            return this;
        }

        public int describeContents() {
            C0572ci ciVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0561c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0561c cVar = (C0561c) obj;
            for (C0409ae.C0410a next : f1308iC.values()) {
                if (mo4479a(next)) {
                    if (!cVar.mo4479a(next)) {
                        return false;
                    }
                    if (!mo4480b(next).equals(cVar.mo4480b(next))) {
                        return false;
                    }
                } else if (cVar.mo4479a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getUrl() {
            return this.f1311ie;
        }

        public boolean hasUrl() {
            return this.f1310iD.contains(2);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0409ae.C0410a<?, ?>> it = f1308iC.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0409ae.C0410a next = it.next();
                if (mo4479a(next)) {
                    i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                } else {
                    i = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public int mo5235i() {
            return this.f1309ab;
        }

        public boolean isDataValid() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public Object mo4481m(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public boolean mo4482n(String str) {
            return false;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0572ci ciVar = CREATOR;
            C0572ci.m1708a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$d */
    public static final class C0562d extends C0409ae implements SafeParcelable, Person.Name {
        public static final C0573cj CREATOR = new C0573cj();

        /* renamed from: iC */
        private static final HashMap<String, C0409ae.C0410a<?, ?>> f1312iC = new HashMap<>();

        /* renamed from: ab */
        private final int f1313ab;

        /* renamed from: iD */
        private final Set<Integer> f1314iD;

        /* renamed from: jc */
        private String f1315jc;

        /* renamed from: jf */
        private String f1316jf;

        /* renamed from: kg */
        private String f1317kg;

        /* renamed from: kh */
        private String f1318kh;

        /* renamed from: ki */
        private String f1319ki;

        /* renamed from: kj */
        private String f1320kj;

        static {
            f1312iC.put("familyName", C0409ae.C0410a.m832f("familyName", 2));
            f1312iC.put("formatted", C0409ae.C0410a.m832f("formatted", 3));
            f1312iC.put("givenName", C0409ae.C0410a.m832f("givenName", 4));
            f1312iC.put("honorificPrefix", C0409ae.C0410a.m832f("honorificPrefix", 5));
            f1312iC.put("honorificSuffix", C0409ae.C0410a.m832f("honorificSuffix", 6));
            f1312iC.put("middleName", C0409ae.C0410a.m832f("middleName", 7));
        }

        public C0562d() {
            this.f1313ab = 1;
            this.f1314iD = new HashSet();
        }

        C0562d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f1314iD = set;
            this.f1313ab = i;
            this.f1315jc = str;
            this.f1317kg = str2;
            this.f1316jf = str3;
            this.f1318kh = str4;
            this.f1319ki = str5;
            this.f1320kj = str6;
        }

        /* renamed from: T */
        public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
            return f1312iC;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4479a(C0409ae.C0410a aVar) {
            return this.f1314iD.contains(Integer.valueOf(aVar.mo4493aa()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4480b(C0409ae.C0410a aVar) {
            switch (aVar.mo4493aa()) {
                case 2:
                    return this.f1315jc;
                case 3:
                    return this.f1317kg;
                case 4:
                    return this.f1316jf;
                case 5:
                    return this.f1318kh;
                case 6:
                    return this.f1319ki;
                case 7:
                    return this.f1320kj;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bH */
        public Set<Integer> mo5237bH() {
            return this.f1314iD;
        }

        /* renamed from: cr */
        public C0562d freeze() {
            return this;
        }

        public int describeContents() {
            C0573cj cjVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0562d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0562d dVar = (C0562d) obj;
            for (C0409ae.C0410a next : f1312iC.values()) {
                if (mo4479a(next)) {
                    if (!dVar.mo4479a(next)) {
                        return false;
                    }
                    if (!mo4480b(next).equals(dVar.mo4480b(next))) {
                        return false;
                    }
                } else if (dVar.mo4479a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getFamilyName() {
            return this.f1315jc;
        }

        public String getFormatted() {
            return this.f1317kg;
        }

        public String getGivenName() {
            return this.f1316jf;
        }

        public String getHonorificPrefix() {
            return this.f1318kh;
        }

        public String getHonorificSuffix() {
            return this.f1319ki;
        }

        public String getMiddleName() {
            return this.f1320kj;
        }

        public boolean hasFamilyName() {
            return this.f1314iD.contains(2);
        }

        public boolean hasFormatted() {
            return this.f1314iD.contains(3);
        }

        public boolean hasGivenName() {
            return this.f1314iD.contains(4);
        }

        public boolean hasHonorificPrefix() {
            return this.f1314iD.contains(5);
        }

        public boolean hasHonorificSuffix() {
            return this.f1314iD.contains(6);
        }

        public boolean hasMiddleName() {
            return this.f1314iD.contains(7);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0409ae.C0410a<?, ?>> it = f1312iC.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0409ae.C0410a next = it.next();
                if (mo4479a(next)) {
                    i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                } else {
                    i = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public int mo5254i() {
            return this.f1313ab;
        }

        public boolean isDataValid() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public Object mo4481m(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public boolean mo4482n(String str) {
            return false;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0573cj cjVar = CREATOR;
            C0573cj.m1711a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$e */
    public static class C0563e {
        /* renamed from: G */
        public static int m1667G(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals(ModelFields.PAGE)) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$f */
    public static final class C0564f extends C0409ae implements SafeParcelable, Person.Organizations {
        public static final C0574ck CREATOR = new C0574ck();

        /* renamed from: iC */
        private static final HashMap<String, C0409ae.C0410a<?, ?>> f1321iC = new HashMap<>();

        /* renamed from: aJ */
        private int f1322aJ;

        /* renamed from: ab */
        private final int f1323ab;

        /* renamed from: di */
        private String f1324di;

        /* renamed from: hs */
        private String f1325hs;

        /* renamed from: iD */
        private final Set<Integer> f1326iD;

        /* renamed from: jb */
        private String f1327jb;

        /* renamed from: js */
        private String f1328js;

        /* renamed from: kk */
        private String f1329kk;

        /* renamed from: kl */
        private String f1330kl;

        /* renamed from: km */
        private boolean f1331km;
        private String mName;

        static {
            f1321iC.put("department", C0409ae.C0410a.m832f("department", 2));
            f1321iC.put("description", C0409ae.C0410a.m832f("description", 3));
            f1321iC.put("endDate", C0409ae.C0410a.m832f("endDate", 4));
            f1321iC.put("location", C0409ae.C0410a.m832f("location", 5));
            f1321iC.put("name", C0409ae.C0410a.m832f("name", 6));
            f1321iC.put("primary", C0409ae.C0410a.m831e("primary", 7));
            f1321iC.put("startDate", C0409ae.C0410a.m832f("startDate", 8));
            f1321iC.put("title", C0409ae.C0410a.m832f("title", 9));
            f1321iC.put(ChartActivity.TYPE, C0409ae.C0410a.m825a(ChartActivity.TYPE, 10, new C0405ab().mo4460b("work", 0).mo4460b("school", 1), false));
        }

        public C0564f() {
            this.f1323ab = 1;
            this.f1326iD = new HashSet();
        }

        C0564f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.f1326iD = set;
            this.f1323ab = i;
            this.f1329kk = str;
            this.f1324di = str2;
            this.f1327jb = str3;
            this.f1330kl = str4;
            this.mName = str5;
            this.f1331km = z;
            this.f1328js = str6;
            this.f1325hs = str7;
            this.f1322aJ = i2;
        }

        /* renamed from: T */
        public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
            return f1321iC;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4479a(C0409ae.C0410a aVar) {
            return this.f1326iD.contains(Integer.valueOf(aVar.mo4493aa()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4480b(C0409ae.C0410a aVar) {
            switch (aVar.mo4493aa()) {
                case 2:
                    return this.f1329kk;
                case 3:
                    return this.f1324di;
                case 4:
                    return this.f1327jb;
                case 5:
                    return this.f1330kl;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.f1331km);
                case 8:
                    return this.f1328js;
                case 9:
                    return this.f1325hs;
                case 10:
                    return Integer.valueOf(this.f1322aJ);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bH */
        public Set<Integer> mo5256bH() {
            return this.f1326iD;
        }

        /* renamed from: cs */
        public C0564f freeze() {
            return this;
        }

        public int describeContents() {
            C0574ck ckVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0564f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0564f fVar = (C0564f) obj;
            for (C0409ae.C0410a next : f1321iC.values()) {
                if (mo4479a(next)) {
                    if (!fVar.mo4479a(next)) {
                        return false;
                    }
                    if (!mo4480b(next).equals(fVar.mo4480b(next))) {
                        return false;
                    }
                } else if (fVar.mo4479a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getDepartment() {
            return this.f1329kk;
        }

        public String getDescription() {
            return this.f1324di;
        }

        public String getEndDate() {
            return this.f1327jb;
        }

        public String getLocation() {
            return this.f1330kl;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.f1328js;
        }

        public String getTitle() {
            return this.f1325hs;
        }

        public int getType() {
            return this.f1322aJ;
        }

        public boolean hasDepartment() {
            return this.f1326iD.contains(2);
        }

        public boolean hasDescription() {
            return this.f1326iD.contains(3);
        }

        public boolean hasEndDate() {
            return this.f1326iD.contains(4);
        }

        public boolean hasLocation() {
            return this.f1326iD.contains(5);
        }

        public boolean hasName() {
            return this.f1326iD.contains(6);
        }

        public boolean hasPrimary() {
            return this.f1326iD.contains(7);
        }

        public boolean hasStartDate() {
            return this.f1326iD.contains(8);
        }

        public boolean hasTitle() {
            return this.f1326iD.contains(9);
        }

        public boolean hasType() {
            return this.f1326iD.contains(10);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0409ae.C0410a<?, ?>> it = f1321iC.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0409ae.C0410a next = it.next();
                if (mo4479a(next)) {
                    i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                } else {
                    i = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public int mo5278i() {
            return this.f1323ab;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.f1331km;
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public Object mo4481m(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public boolean mo4482n(String str) {
            return false;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0574ck ckVar = CREATOR;
            C0574ck.m1714a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$g */
    public static final class C0565g extends C0409ae implements SafeParcelable, Person.PlacesLived {
        public static final C0575cl CREATOR = new C0575cl();

        /* renamed from: iC */
        private static final HashMap<String, C0409ae.C0410a<?, ?>> f1332iC = new HashMap<>();

        /* renamed from: ab */
        private final int f1333ab;

        /* renamed from: iD */
        private final Set<Integer> f1334iD;

        /* renamed from: km */
        private boolean f1335km;
        private String mValue;

        static {
            f1332iC.put("primary", C0409ae.C0410a.m831e("primary", 2));
            f1332iC.put("value", C0409ae.C0410a.m832f("value", 3));
        }

        public C0565g() {
            this.f1333ab = 1;
            this.f1334iD = new HashSet();
        }

        C0565g(Set<Integer> set, int i, boolean z, String str) {
            this.f1334iD = set;
            this.f1333ab = i;
            this.f1335km = z;
            this.mValue = str;
        }

        /* renamed from: T */
        public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
            return f1332iC;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4479a(C0409ae.C0410a aVar) {
            return this.f1334iD.contains(Integer.valueOf(aVar.mo4493aa()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4480b(C0409ae.C0410a aVar) {
            switch (aVar.mo4493aa()) {
                case 2:
                    return Boolean.valueOf(this.f1335km);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bH */
        public Set<Integer> mo5281bH() {
            return this.f1334iD;
        }

        /* renamed from: ct */
        public C0565g freeze() {
            return this;
        }

        public int describeContents() {
            C0575cl clVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0565g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0565g gVar = (C0565g) obj;
            for (C0409ae.C0410a next : f1332iC.values()) {
                if (mo4479a(next)) {
                    if (!gVar.mo4479a(next)) {
                        return false;
                    }
                    if (!mo4480b(next).equals(gVar.mo4480b(next))) {
                        return false;
                    }
                } else if (gVar.mo4479a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.f1334iD.contains(2);
        }

        public boolean hasValue() {
            return this.f1334iD.contains(3);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0409ae.C0410a<?, ?>> it = f1332iC.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0409ae.C0410a next = it.next();
                if (mo4479a(next)) {
                    i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                } else {
                    i = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public int mo5289i() {
            return this.f1333ab;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.f1335km;
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public Object mo4481m(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public boolean mo4482n(String str) {
            return false;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0575cl clVar = CREATOR;
            C0575cl.m1717a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$h */
    public static final class C0566h extends C0409ae implements SafeParcelable, Person.Urls {
        public static final C0576cm CREATOR = new C0576cm();

        /* renamed from: iC */
        private static final HashMap<String, C0409ae.C0410a<?, ?>> f1336iC = new HashMap<>();

        /* renamed from: aJ */
        private int f1337aJ;

        /* renamed from: ab */
        private final int f1338ab;

        /* renamed from: iD */
        private final Set<Integer> f1339iD;

        /* renamed from: kn */
        private String f1340kn;

        /* renamed from: ko */
        private final int f1341ko;
        private String mValue;

        static {
            f1336iC.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0409ae.C0410a.m832f(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            f1336iC.put(ChartActivity.TYPE, C0409ae.C0410a.m825a(ChartActivity.TYPE, 6, new C0405ab().mo4460b("home", 0).mo4460b("work", 1).mo4460b("blog", 2).mo4460b("profile", 3).mo4460b("other", 4).mo4460b("otherProfile", 5).mo4460b("contributor", 6).mo4460b("website", 7), false));
            f1336iC.put("value", C0409ae.C0410a.m832f("value", 4));
        }

        public C0566h() {
            this.f1341ko = 4;
            this.f1338ab = 2;
            this.f1339iD = new HashSet();
        }

        C0566h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.f1341ko = 4;
            this.f1339iD = set;
            this.f1338ab = i;
            this.f1340kn = str;
            this.f1337aJ = i2;
            this.mValue = str2;
        }

        /* renamed from: T */
        public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
            return f1336iC;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4479a(C0409ae.C0410a aVar) {
            return this.f1339iD.contains(Integer.valueOf(aVar.mo4493aa()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4480b(C0409ae.C0410a aVar) {
            switch (aVar.mo4493aa()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.f1340kn;
                case 6:
                    return Integer.valueOf(this.f1337aJ);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bH */
        public Set<Integer> mo5292bH() {
            return this.f1339iD;
        }

        @Deprecated
        /* renamed from: cu */
        public int mo5293cu() {
            return 4;
        }

        /* renamed from: cv */
        public C0566h freeze() {
            return this;
        }

        public int describeContents() {
            C0576cm cmVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0566h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0566h hVar = (C0566h) obj;
            for (C0409ae.C0410a next : f1336iC.values()) {
                if (mo4479a(next)) {
                    if (!hVar.mo4479a(next)) {
                        return false;
                    }
                    if (!mo4480b(next).equals(hVar.mo4480b(next))) {
                        return false;
                    }
                } else if (hVar.mo4479a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getLabel() {
            return this.f1340kn;
        }

        public int getType() {
            return this.f1337aJ;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.f1339iD.contains(5);
        }

        public boolean hasType() {
            return this.f1339iD.contains(6);
        }

        public boolean hasValue() {
            return this.f1339iD.contains(4);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0409ae.C0410a<?, ?>> it = f1336iC.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0409ae.C0410a next = it.next();
                if (mo4479a(next)) {
                    i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
                } else {
                    i = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public int mo5304i() {
            return this.f1338ab;
        }

        public boolean isDataValid() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public Object mo4481m(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public boolean mo4482n(String str) {
            return false;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0576cm cmVar = CREATOR;
            C0576cm.m1720a(this, out, flags);
        }
    }

    static {
        f1259iC.put("aboutMe", C0409ae.C0410a.m832f("aboutMe", 2));
        f1259iC.put("ageRange", C0409ae.C0410a.m826a("ageRange", 3, C0557a.class));
        f1259iC.put("birthday", C0409ae.C0410a.m832f("birthday", 4));
        f1259iC.put("braggingRights", C0409ae.C0410a.m832f("braggingRights", 5));
        f1259iC.put("circledByCount", C0409ae.C0410a.m828c("circledByCount", 6));
        f1259iC.put("cover", C0409ae.C0410a.m826a("cover", 7, C0558b.class));
        f1259iC.put("currentLocation", C0409ae.C0410a.m832f("currentLocation", 8));
        f1259iC.put("displayName", C0409ae.C0410a.m832f("displayName", 9));
        f1259iC.put("gender", C0409ae.C0410a.m825a("gender", 12, new C0405ab().mo4460b("male", 0).mo4460b("female", 1).mo4460b("other", 2), false));
        f1259iC.put("id", C0409ae.C0410a.m832f("id", 14));
        f1259iC.put("image", C0409ae.C0410a.m826a("image", 15, C0561c.class));
        f1259iC.put("isPlusUser", C0409ae.C0410a.m831e("isPlusUser", 16));
        f1259iC.put(ModelFields.LANGUAGE, C0409ae.C0410a.m832f(ModelFields.LANGUAGE, 18));
        f1259iC.put("name", C0409ae.C0410a.m826a("name", 19, C0562d.class));
        f1259iC.put("nickname", C0409ae.C0410a.m832f("nickname", 20));
        f1259iC.put("objectType", C0409ae.C0410a.m825a("objectType", 21, new C0405ab().mo4460b("person", 0).mo4460b(ModelFields.PAGE, 1), false));
        f1259iC.put("organizations", C0409ae.C0410a.m827b("organizations", 22, C0564f.class));
        f1259iC.put("placesLived", C0409ae.C0410a.m827b("placesLived", 23, C0565g.class));
        f1259iC.put("plusOneCount", C0409ae.C0410a.m828c("plusOneCount", 24));
        f1259iC.put("relationshipStatus", C0409ae.C0410a.m825a("relationshipStatus", 25, new C0405ab().mo4460b("single", 0).mo4460b("in_a_relationship", 1).mo4460b("engaged", 2).mo4460b("married", 3).mo4460b("its_complicated", 4).mo4460b("open_relationship", 5).mo4460b("widowed", 6).mo4460b("in_domestic_partnership", 7).mo4460b("in_civil_union", 8), false));
        f1259iC.put("tagline", C0409ae.C0410a.m832f("tagline", 26));
        f1259iC.put("url", C0409ae.C0410a.m832f("url", 27));
        f1259iC.put("urls", C0409ae.C0410a.m827b("urls", 28, C0566h.class));
        f1259iC.put("verified", C0409ae.C0410a.m831e("verified", 29));
    }

    public C0556cc() {
        this.f1260ab = 2;
        this.f1262iD = new HashSet();
    }

    public C0556cc(String str, String str2, C0561c cVar, int i, String str3) {
        this.f1260ab = 2;
        this.f1262iD = new HashSet();
        this.f1261cl = str;
        this.f1262iD.add(9);
        this.f1285jh = str2;
        this.f1262iD.add(14);
        this.f1272jM = cVar;
        this.f1262iD.add(15);
        this.f1277jR = i;
        this.f1262iD.add(21);
        this.f1263ie = str3;
        this.f1262iD.add(27);
    }

    C0556cc(Set<Integer> set, int i, String str, C0557a aVar, String str2, String str3, int i2, C0558b bVar, String str4, String str5, int i3, String str6, C0561c cVar, boolean z, String str7, C0562d dVar, String str8, int i4, List<C0564f> list, List<C0565g> list2, int i5, int i6, String str9, String str10, List<C0566h> list3, boolean z2) {
        this.f1262iD = set;
        this.f1260ab = i;
        this.f1264jE = str;
        this.f1265jF = aVar;
        this.f1266jG = str2;
        this.f1267jH = str3;
        this.f1268jI = i2;
        this.f1269jJ = bVar;
        this.f1270jK = str4;
        this.f1261cl = str5;
        this.f1271jL = i3;
        this.f1285jh = str6;
        this.f1272jM = cVar;
        this.f1273jN = z;
        this.f1274jO = str7;
        this.f1275jP = dVar;
        this.f1276jQ = str8;
        this.f1277jR = i4;
        this.f1278jS = list;
        this.f1279jT = list2;
        this.f1280jU = i5;
        this.f1281jV = i6;
        this.f1282jW = str9;
        this.f1263ie = str10;
        this.f1283jX = list3;
        this.f1284jY = z2;
    }

    /* renamed from: d */
    public static C0556cc m1601d(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C0556cc y = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return y;
    }

    /* renamed from: T */
    public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
        return f1259iC;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4479a(C0409ae.C0410a aVar) {
        return this.f1262iD.contains(Integer.valueOf(aVar.mo4493aa()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo4480b(C0409ae.C0410a aVar) {
        switch (aVar.mo4493aa()) {
            case 2:
                return this.f1264jE;
            case 3:
                return this.f1265jF;
            case 4:
                return this.f1266jG;
            case 5:
                return this.f1267jH;
            case 6:
                return Integer.valueOf(this.f1268jI);
            case 7:
                return this.f1269jJ;
            case 8:
                return this.f1270jK;
            case 9:
                return this.f1261cl;
            case 12:
                return Integer.valueOf(this.f1271jL);
            case 14:
                return this.f1285jh;
            case 15:
                return this.f1272jM;
            case 16:
                return Boolean.valueOf(this.f1273jN);
            case 18:
                return this.f1274jO;
            case 19:
                return this.f1275jP;
            case 20:
                return this.f1276jQ;
            case 21:
                return Integer.valueOf(this.f1277jR);
            case 22:
                return this.f1278jS;
            case 23:
                return this.f1279jT;
            case 24:
                return Integer.valueOf(this.f1280jU);
            case 25:
                return Integer.valueOf(this.f1281jV);
            case 26:
                return this.f1282jW;
            case 27:
                return this.f1263ie;
            case 28:
                return this.f1283jX;
            case 29:
                return Boolean.valueOf(this.f1284jY);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bH */
    public Set<Integer> mo5114bH() {
        return this.f1262iD;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cc */
    public C0557a mo5115cc() {
        return this.f1265jF;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cd */
    public C0558b mo5116cd() {
        return this.f1269jJ;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ce */
    public C0561c mo5117ce() {
        return this.f1272jM;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cf */
    public C0562d mo5118cf() {
        return this.f1275jP;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cg */
    public List<C0564f> mo5119cg() {
        return this.f1278jS;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ch */
    public List<C0565g> mo5120ch() {
        return this.f1279jT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ci */
    public List<C0566h> mo5121ci() {
        return this.f1283jX;
    }

    /* renamed from: cj */
    public C0556cc freeze() {
        return this;
    }

    public int describeContents() {
        C0567cd cdVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0556cc)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0556cc ccVar = (C0556cc) obj;
        for (C0409ae.C0410a next : f1259iC.values()) {
            if (mo4479a(next)) {
                if (!ccVar.mo4479a(next)) {
                    return false;
                }
                if (!mo4480b(next).equals(ccVar.mo4480b(next))) {
                    return false;
                }
            } else if (ccVar.mo4479a(next)) {
                return false;
            }
        }
        return true;
    }

    public String getAboutMe() {
        return this.f1264jE;
    }

    public Person.AgeRange getAgeRange() {
        return this.f1265jF;
    }

    public String getBirthday() {
        return this.f1266jG;
    }

    public String getBraggingRights() {
        return this.f1267jH;
    }

    public int getCircledByCount() {
        return this.f1268jI;
    }

    public Person.Cover getCover() {
        return this.f1269jJ;
    }

    public String getCurrentLocation() {
        return this.f1270jK;
    }

    public String getDisplayName() {
        return this.f1261cl;
    }

    @Deprecated
    public List<Person.Emails> getEmails() {
        return null;
    }

    public int getGender() {
        return this.f1271jL;
    }

    public String getId() {
        return this.f1285jh;
    }

    public Person.Image getImage() {
        return this.f1272jM;
    }

    public String getLanguage() {
        return this.f1274jO;
    }

    public Person.Name getName() {
        return this.f1275jP;
    }

    public String getNickname() {
        return this.f1276jQ;
    }

    public int getObjectType() {
        return this.f1277jR;
    }

    public List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.f1278jS;
    }

    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.f1279jT;
    }

    public int getPlusOneCount() {
        return this.f1280jU;
    }

    public int getRelationshipStatus() {
        return this.f1281jV;
    }

    public String getTagline() {
        return this.f1282jW;
    }

    public String getUrl() {
        return this.f1263ie;
    }

    public List<Person.Urls> getUrls() {
        return (ArrayList) this.f1283jX;
    }

    public boolean hasAboutMe() {
        return this.f1262iD.contains(2);
    }

    public boolean hasAgeRange() {
        return this.f1262iD.contains(3);
    }

    public boolean hasBirthday() {
        return this.f1262iD.contains(4);
    }

    public boolean hasBraggingRights() {
        return this.f1262iD.contains(5);
    }

    public boolean hasCircledByCount() {
        return this.f1262iD.contains(6);
    }

    public boolean hasCover() {
        return this.f1262iD.contains(7);
    }

    public boolean hasCurrentLocation() {
        return this.f1262iD.contains(8);
    }

    public boolean hasDisplayName() {
        return this.f1262iD.contains(9);
    }

    @Deprecated
    public boolean hasEmails() {
        return false;
    }

    public boolean hasGender() {
        return this.f1262iD.contains(12);
    }

    public boolean hasId() {
        return this.f1262iD.contains(14);
    }

    public boolean hasImage() {
        return this.f1262iD.contains(15);
    }

    public boolean hasIsPlusUser() {
        return this.f1262iD.contains(16);
    }

    public boolean hasLanguage() {
        return this.f1262iD.contains(18);
    }

    public boolean hasName() {
        return this.f1262iD.contains(19);
    }

    public boolean hasNickname() {
        return this.f1262iD.contains(20);
    }

    public boolean hasObjectType() {
        return this.f1262iD.contains(21);
    }

    public boolean hasOrganizations() {
        return this.f1262iD.contains(22);
    }

    public boolean hasPlacesLived() {
        return this.f1262iD.contains(23);
    }

    public boolean hasPlusOneCount() {
        return this.f1262iD.contains(24);
    }

    public boolean hasRelationshipStatus() {
        return this.f1262iD.contains(25);
    }

    public boolean hasTagline() {
        return this.f1262iD.contains(26);
    }

    public boolean hasUrl() {
        return this.f1262iD.contains(27);
    }

    public boolean hasUrls() {
        return this.f1262iD.contains(28);
    }

    public boolean hasVerified() {
        return this.f1262iD.contains(29);
    }

    public int hashCode() {
        int i = 0;
        Iterator<C0409ae.C0410a<?, ?>> it = f1259iC.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C0409ae.C0410a next = it.next();
            if (mo4479a(next)) {
                i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
            } else {
                i = i2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5174i() {
        return this.f1260ab;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.f1273jN;
    }

    public boolean isVerified() {
        return this.f1284jY;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Object mo4481m(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public boolean mo4482n(String str) {
        return false;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0567cd cdVar = CREATOR;
        C0567cd.m1693a(this, out, flags);
    }
}
