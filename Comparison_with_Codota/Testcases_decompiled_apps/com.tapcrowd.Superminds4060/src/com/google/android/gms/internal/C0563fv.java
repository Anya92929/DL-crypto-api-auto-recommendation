package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0422dw;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.cordova.Globalization;

/* renamed from: com.google.android.gms.internal.fv */
public final class C0563fv extends C0422dw implements SafeParcelable, Person {
    public static final C0574fw CREATOR = new C0574fw();

    /* renamed from: rH */
    private static final HashMap<String, C0422dw.C0423a<?, ?>> f1435rH = new HashMap<>();

    /* renamed from: dI */
    private int f1436dI;

    /* renamed from: hN */
    private String f1437hN;

    /* renamed from: iM */
    private final int f1438iM;

    /* renamed from: ml */
    private String f1439ml;

    /* renamed from: rI */
    private final Set<Integer> f1440rI;

    /* renamed from: sJ */
    private String f1441sJ;

    /* renamed from: sK */
    private C0564a f1442sK;

    /* renamed from: sL */
    private String f1443sL;

    /* renamed from: sM */
    private String f1444sM;

    /* renamed from: sN */
    private int f1445sN;

    /* renamed from: sO */
    private C0565b f1446sO;

    /* renamed from: sP */
    private String f1447sP;

    /* renamed from: sQ */
    private C0568c f1448sQ;

    /* renamed from: sR */
    private boolean f1449sR;

    /* renamed from: sS */
    private String f1450sS;

    /* renamed from: sT */
    private C0569d f1451sT;

    /* renamed from: sU */
    private String f1452sU;

    /* renamed from: sV */
    private int f1453sV;

    /* renamed from: sW */
    private List<C0571f> f1454sW;

    /* renamed from: sX */
    private List<C0572g> f1455sX;

    /* renamed from: sY */
    private int f1456sY;

    /* renamed from: sZ */
    private int f1457sZ;

    /* renamed from: sm */
    private String f1458sm;

    /* renamed from: ta */
    private String f1459ta;

    /* renamed from: tb */
    private List<C0573h> f1460tb;

    /* renamed from: tc */
    private boolean f1461tc;

    /* renamed from: com.google.android.gms.internal.fv$a */
    public static final class C0564a extends C0422dw implements SafeParcelable, Person.AgeRange {
        public static final C0575fx CREATOR = new C0575fx();

        /* renamed from: rH */
        private static final HashMap<String, C0422dw.C0423a<?, ?>> f1462rH = new HashMap<>();

        /* renamed from: iM */
        private final int f1463iM;

        /* renamed from: rI */
        private final Set<Integer> f1464rI;

        /* renamed from: td */
        private int f1465td;

        /* renamed from: te */
        private int f1466te;

        static {
            f1462rH.put("max", C0422dw.C0423a.m995d("max", 2));
            f1462rH.put("min", C0422dw.C0423a.m995d("min", 3));
        }

        public C0564a() {
            this.f1463iM = 1;
            this.f1464rI = new HashSet();
        }

        C0564a(Set<Integer> set, int i, int i2, int i3) {
            this.f1464rI = set;
            this.f1463iM = i;
            this.f1465td = i2;
            this.f1466te = i3;
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public Object mo4427D(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public boolean mo4428E(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4432a(C0422dw.C0423a aVar) {
            return this.f1464rI.contains(Integer.valueOf(aVar.mo4447bw()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4433b(C0422dw.C0423a aVar) {
            switch (aVar.mo4447bw()) {
                case 2:
                    return Integer.valueOf(this.f1465td);
                case 3:
                    return Integer.valueOf(this.f1466te);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
            }
        }

        /* renamed from: bp */
        public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
            return f1462rH;
        }

        /* renamed from: dL */
        public C0564a freeze() {
            return this;
        }

        public int describeContents() {
            C0575fx fxVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: di */
        public Set<Integer> mo5096di() {
            return this.f1464rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0564a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0564a aVar = (C0564a) obj;
            for (C0422dw.C0423a next : f1462rH.values()) {
                if (mo4432a(next)) {
                    if (!aVar.mo4432a(next)) {
                        return false;
                    }
                    if (!mo4433b(next).equals(aVar.mo4433b(next))) {
                        return false;
                    }
                } else if (aVar.mo4432a(next)) {
                    return false;
                }
            }
            return true;
        }

        public int getMax() {
            return this.f1465td;
        }

        public int getMin() {
            return this.f1466te;
        }

        /* access modifiers changed from: package-private */
        public int getVersionCode() {
            return this.f1463iM;
        }

        public boolean hasMax() {
            return this.f1464rI.contains(2);
        }

        public boolean hasMin() {
            return this.f1464rI.contains(3);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0422dw.C0423a<?, ?>> it = f1462rH.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0422dw.C0423a next = it.next();
                if (mo4432a(next)) {
                    i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0575fx fxVar = CREATOR;
            C0575fx.m1800a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv$b */
    public static final class C0565b extends C0422dw implements SafeParcelable, Person.Cover {
        public static final C0576fy CREATOR = new C0576fy();

        /* renamed from: rH */
        private static final HashMap<String, C0422dw.C0423a<?, ?>> f1467rH = new HashMap<>();

        /* renamed from: iM */
        private final int f1468iM;

        /* renamed from: rI */
        private final Set<Integer> f1469rI;

        /* renamed from: tf */
        private C0566a f1470tf;

        /* renamed from: tg */
        private C0567b f1471tg;

        /* renamed from: th */
        private int f1472th;

        /* renamed from: com.google.android.gms.internal.fv$b$a */
        public static final class C0566a extends C0422dw implements SafeParcelable, Person.Cover.CoverInfo {
            public static final C0577fz CREATOR = new C0577fz();

            /* renamed from: rH */
            private static final HashMap<String, C0422dw.C0423a<?, ?>> f1473rH = new HashMap<>();

            /* renamed from: iM */
            private final int f1474iM;

            /* renamed from: rI */
            private final Set<Integer> f1475rI;

            /* renamed from: ti */
            private int f1476ti;

            /* renamed from: tj */
            private int f1477tj;

            static {
                f1473rH.put("leftImageOffset", C0422dw.C0423a.m995d("leftImageOffset", 2));
                f1473rH.put("topImageOffset", C0422dw.C0423a.m995d("topImageOffset", 3));
            }

            public C0566a() {
                this.f1474iM = 1;
                this.f1475rI = new HashSet();
            }

            C0566a(Set<Integer> set, int i, int i2, int i3) {
                this.f1475rI = set;
                this.f1474iM = i;
                this.f1476ti = i2;
                this.f1477tj = i3;
            }

            /* access modifiers changed from: protected */
            /* renamed from: D */
            public Object mo4427D(String str) {
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: E */
            public boolean mo4428E(String str) {
                return false;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo4432a(C0422dw.C0423a aVar) {
                return this.f1475rI.contains(Integer.valueOf(aVar.mo4447bw()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Object mo4433b(C0422dw.C0423a aVar) {
                switch (aVar.mo4447bw()) {
                    case 2:
                        return Integer.valueOf(this.f1476ti);
                    case 3:
                        return Integer.valueOf(this.f1477tj);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
                }
            }

            /* renamed from: bp */
            public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
                return f1473rH;
            }

            /* renamed from: dP */
            public C0566a freeze() {
                return this;
            }

            public int describeContents() {
                C0577fz fzVar = CREATOR;
                return 0;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: di */
            public Set<Integer> mo5122di() {
                return this.f1475rI;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0566a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0566a aVar = (C0566a) obj;
                for (C0422dw.C0423a next : f1473rH.values()) {
                    if (mo4432a(next)) {
                        if (!aVar.mo4432a(next)) {
                            return false;
                        }
                        if (!mo4433b(next).equals(aVar.mo4433b(next))) {
                            return false;
                        }
                    } else if (aVar.mo4432a(next)) {
                        return false;
                    }
                }
                return true;
            }

            public int getLeftImageOffset() {
                return this.f1476ti;
            }

            public int getTopImageOffset() {
                return this.f1477tj;
            }

            /* access modifiers changed from: package-private */
            public int getVersionCode() {
                return this.f1474iM;
            }

            public boolean hasLeftImageOffset() {
                return this.f1475rI.contains(2);
            }

            public boolean hasTopImageOffset() {
                return this.f1475rI.contains(3);
            }

            public int hashCode() {
                int i = 0;
                Iterator<C0422dw.C0423a<?, ?>> it = f1473rH.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    C0422dw.C0423a next = it.next();
                    if (mo4432a(next)) {
                        i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                    } else {
                        i = i2;
                    }
                }
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                C0577fz fzVar = CREATOR;
                C0577fz.m1806a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.fv$b$b */
        public static final class C0567b extends C0422dw implements SafeParcelable, Person.Cover.CoverPhoto {
            public static final C0580ga CREATOR = new C0580ga();

            /* renamed from: rH */
            private static final HashMap<String, C0422dw.C0423a<?, ?>> f1478rH = new HashMap<>();

            /* renamed from: dP */
            private int f1479dP;

            /* renamed from: dQ */
            private int f1480dQ;

            /* renamed from: hN */
            private String f1481hN;

            /* renamed from: iM */
            private final int f1482iM;

            /* renamed from: rI */
            private final Set<Integer> f1483rI;

            static {
                f1478rH.put("height", C0422dw.C0423a.m995d("height", 2));
                f1478rH.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0422dw.C0423a.m998g(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                f1478rH.put("width", C0422dw.C0423a.m995d("width", 4));
            }

            public C0567b() {
                this.f1482iM = 1;
                this.f1483rI = new HashSet();
            }

            C0567b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.f1483rI = set;
                this.f1482iM = i;
                this.f1480dQ = i2;
                this.f1481hN = str;
                this.f1479dP = i3;
            }

            /* access modifiers changed from: protected */
            /* renamed from: D */
            public Object mo4427D(String str) {
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: E */
            public boolean mo4428E(String str) {
                return false;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo4432a(C0422dw.C0423a aVar) {
                return this.f1483rI.contains(Integer.valueOf(aVar.mo4447bw()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Object mo4433b(C0422dw.C0423a aVar) {
                switch (aVar.mo4447bw()) {
                    case 2:
                        return Integer.valueOf(this.f1480dQ);
                    case 3:
                        return this.f1481hN;
                    case 4:
                        return Integer.valueOf(this.f1479dP);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
                }
            }

            /* renamed from: bp */
            public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
                return f1478rH;
            }

            /* renamed from: dQ */
            public C0567b freeze() {
                return this;
            }

            public int describeContents() {
                C0580ga gaVar = CREATOR;
                return 0;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: di */
            public Set<Integer> mo5133di() {
                return this.f1483rI;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0567b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0567b bVar = (C0567b) obj;
                for (C0422dw.C0423a next : f1478rH.values()) {
                    if (mo4432a(next)) {
                        if (!bVar.mo4432a(next)) {
                            return false;
                        }
                        if (!mo4433b(next).equals(bVar.mo4433b(next))) {
                            return false;
                        }
                    } else if (bVar.mo4432a(next)) {
                        return false;
                    }
                }
                return true;
            }

            public int getHeight() {
                return this.f1480dQ;
            }

            public String getUrl() {
                return this.f1481hN;
            }

            /* access modifiers changed from: package-private */
            public int getVersionCode() {
                return this.f1482iM;
            }

            public int getWidth() {
                return this.f1479dP;
            }

            public boolean hasHeight() {
                return this.f1483rI.contains(2);
            }

            public boolean hasUrl() {
                return this.f1483rI.contains(3);
            }

            public boolean hasWidth() {
                return this.f1483rI.contains(4);
            }

            public int hashCode() {
                int i = 0;
                Iterator<C0422dw.C0423a<?, ?>> it = f1478rH.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    C0422dw.C0423a next = it.next();
                    if (mo4432a(next)) {
                        i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                    } else {
                        i = i2;
                    }
                }
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                C0580ga gaVar = CREATOR;
                C0580ga.m1812a(this, out, flags);
            }
        }

        static {
            f1467rH.put("coverInfo", C0422dw.C0423a.m992a("coverInfo", 2, C0566a.class));
            f1467rH.put("coverPhoto", C0422dw.C0423a.m992a("coverPhoto", 3, C0567b.class));
            f1467rH.put("layout", C0422dw.C0423a.m991a("layout", 4, new C0418dt().mo4412c("banner", 0), false));
        }

        public C0565b() {
            this.f1468iM = 1;
            this.f1469rI = new HashSet();
        }

        C0565b(Set<Integer> set, int i, C0566a aVar, C0567b bVar, int i2) {
            this.f1469rI = set;
            this.f1468iM = i;
            this.f1470tf = aVar;
            this.f1471tg = bVar;
            this.f1472th = i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public Object mo4427D(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public boolean mo4428E(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4432a(C0422dw.C0423a aVar) {
            return this.f1469rI.contains(Integer.valueOf(aVar.mo4447bw()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4433b(C0422dw.C0423a aVar) {
            switch (aVar.mo4447bw()) {
                case 2:
                    return this.f1470tf;
                case 3:
                    return this.f1471tg;
                case 4:
                    return Integer.valueOf(this.f1472th);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
            }
        }

        /* renamed from: bp */
        public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
            return f1467rH;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: dM */
        public C0566a mo5105dM() {
            return this.f1470tf;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: dN */
        public C0567b mo5106dN() {
            return this.f1471tg;
        }

        /* renamed from: dO */
        public C0565b freeze() {
            return this;
        }

        public int describeContents() {
            C0576fy fyVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: di */
        public Set<Integer> mo5109di() {
            return this.f1469rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0565b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0565b bVar = (C0565b) obj;
            for (C0422dw.C0423a next : f1467rH.values()) {
                if (mo4432a(next)) {
                    if (!bVar.mo4432a(next)) {
                        return false;
                    }
                    if (!mo4433b(next).equals(bVar.mo4433b(next))) {
                        return false;
                    }
                } else if (bVar.mo4432a(next)) {
                    return false;
                }
            }
            return true;
        }

        public Person.Cover.CoverInfo getCoverInfo() {
            return this.f1470tf;
        }

        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.f1471tg;
        }

        public int getLayout() {
            return this.f1472th;
        }

        /* access modifiers changed from: package-private */
        public int getVersionCode() {
            return this.f1468iM;
        }

        public boolean hasCoverInfo() {
            return this.f1469rI.contains(2);
        }

        public boolean hasCoverPhoto() {
            return this.f1469rI.contains(3);
        }

        public boolean hasLayout() {
            return this.f1469rI.contains(4);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0422dw.C0423a<?, ?>> it = f1467rH.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0422dw.C0423a next = it.next();
                if (mo4432a(next)) {
                    i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0576fy fyVar = CREATOR;
            C0576fy.m1803a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv$c */
    public static final class C0568c extends C0422dw implements SafeParcelable, Person.Image {
        public static final C0581gb CREATOR = new C0581gb();

        /* renamed from: rH */
        private static final HashMap<String, C0422dw.C0423a<?, ?>> f1484rH = new HashMap<>();

        /* renamed from: hN */
        private String f1485hN;

        /* renamed from: iM */
        private final int f1486iM;

        /* renamed from: rI */
        private final Set<Integer> f1487rI;

        static {
            f1484rH.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0422dw.C0423a.m998g(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C0568c() {
            this.f1486iM = 1;
            this.f1487rI = new HashSet();
        }

        public C0568c(String str) {
            this.f1487rI = new HashSet();
            this.f1486iM = 1;
            this.f1485hN = str;
            this.f1487rI.add(2);
        }

        C0568c(Set<Integer> set, int i, String str) {
            this.f1487rI = set;
            this.f1486iM = i;
            this.f1485hN = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public Object mo4427D(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public boolean mo4428E(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4432a(C0422dw.C0423a aVar) {
            return this.f1487rI.contains(Integer.valueOf(aVar.mo4447bw()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4433b(C0422dw.C0423a aVar) {
            switch (aVar.mo4447bw()) {
                case 2:
                    return this.f1485hN;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
            }
        }

        /* renamed from: bp */
        public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
            return f1484rH;
        }

        /* renamed from: dR */
        public C0568c freeze() {
            return this;
        }

        public int describeContents() {
            C0581gb gbVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: di */
        public Set<Integer> mo5146di() {
            return this.f1487rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0568c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0568c cVar = (C0568c) obj;
            for (C0422dw.C0423a next : f1484rH.values()) {
                if (mo4432a(next)) {
                    if (!cVar.mo4432a(next)) {
                        return false;
                    }
                    if (!mo4433b(next).equals(cVar.mo4433b(next))) {
                        return false;
                    }
                } else if (cVar.mo4432a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getUrl() {
            return this.f1485hN;
        }

        /* access modifiers changed from: package-private */
        public int getVersionCode() {
            return this.f1486iM;
        }

        public boolean hasUrl() {
            return this.f1487rI.contains(2);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0422dw.C0423a<?, ?>> it = f1484rH.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0422dw.C0423a next = it.next();
                if (mo4432a(next)) {
                    i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0581gb gbVar = CREATOR;
            C0581gb.m1815a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv$d */
    public static final class C0569d extends C0422dw implements SafeParcelable, Person.Name {
        public static final C0582gc CREATOR = new C0582gc();

        /* renamed from: rH */
        private static final HashMap<String, C0422dw.C0423a<?, ?>> f1488rH = new HashMap<>();

        /* renamed from: iM */
        private final int f1489iM;

        /* renamed from: rI */
        private final Set<Integer> f1490rI;

        /* renamed from: sh */
        private String f1491sh;

        /* renamed from: sk */
        private String f1492sk;

        /* renamed from: tk */
        private String f1493tk;

        /* renamed from: tl */
        private String f1494tl;

        /* renamed from: tm */
        private String f1495tm;

        /* renamed from: tn */
        private String f1496tn;

        static {
            f1488rH.put("familyName", C0422dw.C0423a.m998g("familyName", 2));
            f1488rH.put("formatted", C0422dw.C0423a.m998g("formatted", 3));
            f1488rH.put("givenName", C0422dw.C0423a.m998g("givenName", 4));
            f1488rH.put("honorificPrefix", C0422dw.C0423a.m998g("honorificPrefix", 5));
            f1488rH.put("honorificSuffix", C0422dw.C0423a.m998g("honorificSuffix", 6));
            f1488rH.put("middleName", C0422dw.C0423a.m998g("middleName", 7));
        }

        public C0569d() {
            this.f1489iM = 1;
            this.f1490rI = new HashSet();
        }

        C0569d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f1490rI = set;
            this.f1489iM = i;
            this.f1491sh = str;
            this.f1493tk = str2;
            this.f1492sk = str3;
            this.f1494tl = str4;
            this.f1495tm = str5;
            this.f1496tn = str6;
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public Object mo4427D(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public boolean mo4428E(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4432a(C0422dw.C0423a aVar) {
            return this.f1490rI.contains(Integer.valueOf(aVar.mo4447bw()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4433b(C0422dw.C0423a aVar) {
            switch (aVar.mo4447bw()) {
                case 2:
                    return this.f1491sh;
                case 3:
                    return this.f1493tk;
                case 4:
                    return this.f1492sk;
                case 5:
                    return this.f1494tl;
                case 6:
                    return this.f1495tm;
                case 7:
                    return this.f1496tn;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
            }
        }

        /* renamed from: bp */
        public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
            return f1488rH;
        }

        /* renamed from: dS */
        public C0569d freeze() {
            return this;
        }

        public int describeContents() {
            C0582gc gcVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: di */
        public Set<Integer> mo5155di() {
            return this.f1490rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0569d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0569d dVar = (C0569d) obj;
            for (C0422dw.C0423a next : f1488rH.values()) {
                if (mo4432a(next)) {
                    if (!dVar.mo4432a(next)) {
                        return false;
                    }
                    if (!mo4433b(next).equals(dVar.mo4433b(next))) {
                        return false;
                    }
                } else if (dVar.mo4432a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getFamilyName() {
            return this.f1491sh;
        }

        public String getFormatted() {
            return this.f1493tk;
        }

        public String getGivenName() {
            return this.f1492sk;
        }

        public String getHonorificPrefix() {
            return this.f1494tl;
        }

        public String getHonorificSuffix() {
            return this.f1495tm;
        }

        public String getMiddleName() {
            return this.f1496tn;
        }

        /* access modifiers changed from: package-private */
        public int getVersionCode() {
            return this.f1489iM;
        }

        public boolean hasFamilyName() {
            return this.f1490rI.contains(2);
        }

        public boolean hasFormatted() {
            return this.f1490rI.contains(3);
        }

        public boolean hasGivenName() {
            return this.f1490rI.contains(4);
        }

        public boolean hasHonorificPrefix() {
            return this.f1490rI.contains(5);
        }

        public boolean hasHonorificSuffix() {
            return this.f1490rI.contains(6);
        }

        public boolean hasMiddleName() {
            return this.f1490rI.contains(7);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0422dw.C0423a<?, ?>> it = f1488rH.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0422dw.C0423a next = it.next();
                if (mo4432a(next)) {
                    i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0582gc gcVar = CREATOR;
            C0582gc.m1818a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv$e */
    public static class C0570e {
        /* renamed from: aa */
        public static int m1774aa(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv$f */
    public static final class C0571f extends C0422dw implements SafeParcelable, Person.Organizations {
        public static final C0583gd CREATOR = new C0583gd();

        /* renamed from: rH */
        private static final HashMap<String, C0422dw.C0423a<?, ?>> f1497rH = new HashMap<>();

        /* renamed from: iM */
        private final int f1498iM;

        /* renamed from: jV */
        private int f1499jV;
        private String mName;

        /* renamed from: mo */
        private String f1500mo;

        /* renamed from: qB */
        private String f1501qB;

        /* renamed from: rI */
        private final Set<Integer> f1502rI;

        /* renamed from: sg */
        private String f1503sg;

        /* renamed from: sx */
        private String f1504sx;

        /* renamed from: to */
        private String f1505to;

        /* renamed from: tp */
        private String f1506tp;

        /* renamed from: tq */
        private boolean f1507tq;

        static {
            f1497rH.put("department", C0422dw.C0423a.m998g("department", 2));
            f1497rH.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0422dw.C0423a.m998g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            f1497rH.put("endDate", C0422dw.C0423a.m998g("endDate", 4));
            f1497rH.put("location", C0422dw.C0423a.m998g("location", 5));
            f1497rH.put(DBFavorites.KEY_NAME, C0422dw.C0423a.m998g(DBFavorites.KEY_NAME, 6));
            f1497rH.put("primary", C0422dw.C0423a.m997f("primary", 7));
            f1497rH.put("startDate", C0422dw.C0423a.m998g("startDate", 8));
            f1497rH.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0422dw.C0423a.m998g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            f1497rH.put(Globalization.TYPE, C0422dw.C0423a.m991a(Globalization.TYPE, 10, new C0418dt().mo4412c("work", 0).mo4412c("school", 1), false));
        }

        public C0571f() {
            this.f1498iM = 1;
            this.f1502rI = new HashSet();
        }

        C0571f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.f1502rI = set;
            this.f1498iM = i;
            this.f1505to = str;
            this.f1500mo = str2;
            this.f1503sg = str3;
            this.f1506tp = str4;
            this.mName = str5;
            this.f1507tq = z;
            this.f1504sx = str6;
            this.f1501qB = str7;
            this.f1499jV = i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public Object mo4427D(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public boolean mo4428E(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4432a(C0422dw.C0423a aVar) {
            return this.f1502rI.contains(Integer.valueOf(aVar.mo4447bw()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4433b(C0422dw.C0423a aVar) {
            switch (aVar.mo4447bw()) {
                case 2:
                    return this.f1505to;
                case 3:
                    return this.f1500mo;
                case 4:
                    return this.f1503sg;
                case 5:
                    return this.f1506tp;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.f1507tq);
                case 8:
                    return this.f1504sx;
                case 9:
                    return this.f1501qB;
                case 10:
                    return Integer.valueOf(this.f1499jV);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
            }
        }

        /* renamed from: bp */
        public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
            return f1497rH;
        }

        /* renamed from: dT */
        public C0571f freeze() {
            return this;
        }

        public int describeContents() {
            C0583gd gdVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: di */
        public Set<Integer> mo5174di() {
            return this.f1502rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0571f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0571f fVar = (C0571f) obj;
            for (C0422dw.C0423a next : f1497rH.values()) {
                if (mo4432a(next)) {
                    if (!fVar.mo4432a(next)) {
                        return false;
                    }
                    if (!mo4433b(next).equals(fVar.mo4433b(next))) {
                        return false;
                    }
                } else if (fVar.mo4432a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getDepartment() {
            return this.f1505to;
        }

        public String getDescription() {
            return this.f1500mo;
        }

        public String getEndDate() {
            return this.f1503sg;
        }

        public String getLocation() {
            return this.f1506tp;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.f1504sx;
        }

        public String getTitle() {
            return this.f1501qB;
        }

        public int getType() {
            return this.f1499jV;
        }

        /* access modifiers changed from: package-private */
        public int getVersionCode() {
            return this.f1498iM;
        }

        public boolean hasDepartment() {
            return this.f1502rI.contains(2);
        }

        public boolean hasDescription() {
            return this.f1502rI.contains(3);
        }

        public boolean hasEndDate() {
            return this.f1502rI.contains(4);
        }

        public boolean hasLocation() {
            return this.f1502rI.contains(5);
        }

        public boolean hasName() {
            return this.f1502rI.contains(6);
        }

        public boolean hasPrimary() {
            return this.f1502rI.contains(7);
        }

        public boolean hasStartDate() {
            return this.f1502rI.contains(8);
        }

        public boolean hasTitle() {
            return this.f1502rI.contains(9);
        }

        public boolean hasType() {
            return this.f1502rI.contains(10);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0422dw.C0423a<?, ?>> it = f1497rH.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0422dw.C0423a next = it.next();
                if (mo4432a(next)) {
                    i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.f1507tq;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0583gd gdVar = CREATOR;
            C0583gd.m1821a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv$g */
    public static final class C0572g extends C0422dw implements SafeParcelable, Person.PlacesLived {
        public static final C0584ge CREATOR = new C0584ge();

        /* renamed from: rH */
        private static final HashMap<String, C0422dw.C0423a<?, ?>> f1508rH = new HashMap<>();

        /* renamed from: iM */
        private final int f1509iM;
        private String mValue;

        /* renamed from: rI */
        private final Set<Integer> f1510rI;

        /* renamed from: tq */
        private boolean f1511tq;

        static {
            f1508rH.put("primary", C0422dw.C0423a.m997f("primary", 2));
            f1508rH.put("value", C0422dw.C0423a.m998g("value", 3));
        }

        public C0572g() {
            this.f1509iM = 1;
            this.f1510rI = new HashSet();
        }

        C0572g(Set<Integer> set, int i, boolean z, String str) {
            this.f1510rI = set;
            this.f1509iM = i;
            this.f1511tq = z;
            this.mValue = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public Object mo4427D(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public boolean mo4428E(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4432a(C0422dw.C0423a aVar) {
            return this.f1510rI.contains(Integer.valueOf(aVar.mo4447bw()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4433b(C0422dw.C0423a aVar) {
            switch (aVar.mo4447bw()) {
                case 2:
                    return Boolean.valueOf(this.f1511tq);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
            }
        }

        /* renamed from: bp */
        public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
            return f1508rH;
        }

        /* renamed from: dU */
        public C0572g freeze() {
            return this;
        }

        public int describeContents() {
            C0584ge geVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: di */
        public Set<Integer> mo5199di() {
            return this.f1510rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0572g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0572g gVar = (C0572g) obj;
            for (C0422dw.C0423a next : f1508rH.values()) {
                if (mo4432a(next)) {
                    if (!gVar.mo4432a(next)) {
                        return false;
                    }
                    if (!mo4433b(next).equals(gVar.mo4433b(next))) {
                        return false;
                    }
                } else if (gVar.mo4432a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getValue() {
            return this.mValue;
        }

        /* access modifiers changed from: package-private */
        public int getVersionCode() {
            return this.f1509iM;
        }

        public boolean hasPrimary() {
            return this.f1510rI.contains(2);
        }

        public boolean hasValue() {
            return this.f1510rI.contains(3);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0422dw.C0423a<?, ?>> it = f1508rH.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0422dw.C0423a next = it.next();
                if (mo4432a(next)) {
                    i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.f1511tq;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0584ge geVar = CREATOR;
            C0584ge.m1824a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv$h */
    public static final class C0573h extends C0422dw implements SafeParcelable, Person.Urls {
        public static final C0585gf CREATOR = new C0585gf();

        /* renamed from: rH */
        private static final HashMap<String, C0422dw.C0423a<?, ?>> f1512rH = new HashMap<>();

        /* renamed from: iM */
        private final int f1513iM;

        /* renamed from: jV */
        private int f1514jV;
        private String mValue;

        /* renamed from: rI */
        private final Set<Integer> f1515rI;

        /* renamed from: tr */
        private String f1516tr;

        /* renamed from: ts */
        private final int f1517ts;

        static {
            f1512rH.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0422dw.C0423a.m998g(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            f1512rH.put(Globalization.TYPE, C0422dw.C0423a.m991a(Globalization.TYPE, 6, new C0418dt().mo4412c("home", 0).mo4412c("work", 1).mo4412c("blog", 2).mo4412c("profile", 3).mo4412c("other", 4).mo4412c("otherProfile", 5).mo4412c("contributor", 6).mo4412c("website", 7), false));
            f1512rH.put("value", C0422dw.C0423a.m998g("value", 4));
        }

        public C0573h() {
            this.f1517ts = 4;
            this.f1513iM = 2;
            this.f1515rI = new HashSet();
        }

        C0573h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.f1517ts = 4;
            this.f1515rI = set;
            this.f1513iM = i;
            this.f1516tr = str;
            this.f1514jV = i2;
            this.mValue = str2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public Object mo4427D(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public boolean mo4428E(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4432a(C0422dw.C0423a aVar) {
            return this.f1515rI.contains(Integer.valueOf(aVar.mo4447bw()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo4433b(C0422dw.C0423a aVar) {
            switch (aVar.mo4447bw()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.f1516tr;
                case 6:
                    return Integer.valueOf(this.f1514jV);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
            }
        }

        /* renamed from: bp */
        public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
            return f1512rH;
        }

        @Deprecated
        /* renamed from: dV */
        public int mo5208dV() {
            return 4;
        }

        /* renamed from: dW */
        public C0573h freeze() {
            return this;
        }

        public int describeContents() {
            C0585gf gfVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: di */
        public Set<Integer> mo5211di() {
            return this.f1515rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0573h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0573h hVar = (C0573h) obj;
            for (C0422dw.C0423a next : f1512rH.values()) {
                if (mo4432a(next)) {
                    if (!hVar.mo4432a(next)) {
                        return false;
                    }
                    if (!mo4433b(next).equals(hVar.mo4433b(next))) {
                        return false;
                    }
                } else if (hVar.mo4432a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getLabel() {
            return this.f1516tr;
        }

        public int getType() {
            return this.f1514jV;
        }

        public String getValue() {
            return this.mValue;
        }

        /* access modifiers changed from: package-private */
        public int getVersionCode() {
            return this.f1513iM;
        }

        public boolean hasLabel() {
            return this.f1515rI.contains(5);
        }

        public boolean hasType() {
            return this.f1515rI.contains(6);
        }

        public boolean hasValue() {
            return this.f1515rI.contains(4);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C0422dw.C0423a<?, ?>> it = f1512rH.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0422dw.C0423a next = it.next();
                if (mo4432a(next)) {
                    i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0585gf gfVar = CREATOR;
            C0585gf.m1827a(this, out, flags);
        }
    }

    static {
        f1435rH.put("aboutMe", C0422dw.C0423a.m998g("aboutMe", 2));
        f1435rH.put("ageRange", C0422dw.C0423a.m992a("ageRange", 3, C0564a.class));
        f1435rH.put("birthday", C0422dw.C0423a.m998g("birthday", 4));
        f1435rH.put("braggingRights", C0422dw.C0423a.m998g("braggingRights", 5));
        f1435rH.put("circledByCount", C0422dw.C0423a.m995d("circledByCount", 6));
        f1435rH.put("cover", C0422dw.C0423a.m992a("cover", 7, C0565b.class));
        f1435rH.put("currentLocation", C0422dw.C0423a.m998g("currentLocation", 8));
        f1435rH.put("displayName", C0422dw.C0423a.m998g("displayName", 9));
        f1435rH.put("gender", C0422dw.C0423a.m991a("gender", 12, new C0418dt().mo4412c("male", 0).mo4412c("female", 1).mo4412c("other", 2), false));
        f1435rH.put(DBFavorites.KEY_EVENT_ID, C0422dw.C0423a.m998g(DBFavorites.KEY_EVENT_ID, 14));
        f1435rH.put("image", C0422dw.C0423a.m992a("image", 15, C0568c.class));
        f1435rH.put("isPlusUser", C0422dw.C0423a.m997f("isPlusUser", 16));
        f1435rH.put("language", C0422dw.C0423a.m998g("language", 18));
        f1435rH.put(DBFavorites.KEY_NAME, C0422dw.C0423a.m992a(DBFavorites.KEY_NAME, 19, C0569d.class));
        f1435rH.put("nickname", C0422dw.C0423a.m998g("nickname", 20));
        f1435rH.put("objectType", C0422dw.C0423a.m991a("objectType", 21, new C0418dt().mo4412c("person", 0).mo4412c("page", 1), false));
        f1435rH.put("organizations", C0422dw.C0423a.m993b("organizations", 22, C0571f.class));
        f1435rH.put("placesLived", C0422dw.C0423a.m993b("placesLived", 23, C0572g.class));
        f1435rH.put("plusOneCount", C0422dw.C0423a.m995d("plusOneCount", 24));
        f1435rH.put("relationshipStatus", C0422dw.C0423a.m991a("relationshipStatus", 25, new C0418dt().mo4412c("single", 0).mo4412c("in_a_relationship", 1).mo4412c("engaged", 2).mo4412c("married", 3).mo4412c("its_complicated", 4).mo4412c("open_relationship", 5).mo4412c("widowed", 6).mo4412c("in_domestic_partnership", 7).mo4412c("in_civil_union", 8), false));
        f1435rH.put("tagline", C0422dw.C0423a.m998g("tagline", 26));
        f1435rH.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0422dw.C0423a.m998g(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        f1435rH.put("urls", C0422dw.C0423a.m993b("urls", 28, C0573h.class));
        f1435rH.put("verified", C0422dw.C0423a.m997f("verified", 29));
    }

    public C0563fv() {
        this.f1438iM = 2;
        this.f1440rI = new HashSet();
    }

    public C0563fv(String str, String str2, C0568c cVar, int i, String str3) {
        this.f1438iM = 2;
        this.f1440rI = new HashSet();
        this.f1439ml = str;
        this.f1440rI.add(9);
        this.f1458sm = str2;
        this.f1440rI.add(14);
        this.f1448sQ = cVar;
        this.f1440rI.add(15);
        this.f1453sV = i;
        this.f1440rI.add(21);
        this.f1437hN = str3;
        this.f1440rI.add(27);
    }

    C0563fv(Set<Integer> set, int i, String str, C0564a aVar, String str2, String str3, int i2, C0565b bVar, String str4, String str5, int i3, String str6, C0568c cVar, boolean z, String str7, C0569d dVar, String str8, int i4, List<C0571f> list, List<C0572g> list2, int i5, int i6, String str9, String str10, List<C0573h> list3, boolean z2) {
        this.f1440rI = set;
        this.f1438iM = i;
        this.f1441sJ = str;
        this.f1442sK = aVar;
        this.f1443sL = str2;
        this.f1444sM = str3;
        this.f1445sN = i2;
        this.f1446sO = bVar;
        this.f1447sP = str4;
        this.f1439ml = str5;
        this.f1436dI = i3;
        this.f1458sm = str6;
        this.f1448sQ = cVar;
        this.f1449sR = z;
        this.f1450sS = str7;
        this.f1451sT = dVar;
        this.f1452sU = str8;
        this.f1453sV = i4;
        this.f1454sW = list;
        this.f1455sX = list2;
        this.f1456sY = i5;
        this.f1457sZ = i6;
        this.f1459ta = str9;
        this.f1437hN = str10;
        this.f1460tb = list3;
        this.f1461tc = z2;
    }

    /* renamed from: e */
    public static C0563fv m1715e(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C0563fv D = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return D;
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public Object mo4427D(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public boolean mo4428E(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4432a(C0422dw.C0423a aVar) {
        return this.f1440rI.contains(Integer.valueOf(aVar.mo4447bw()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo4433b(C0422dw.C0423a aVar) {
        switch (aVar.mo4447bw()) {
            case 2:
                return this.f1441sJ;
            case 3:
                return this.f1442sK;
            case 4:
                return this.f1443sL;
            case 5:
                return this.f1444sM;
            case 6:
                return Integer.valueOf(this.f1445sN);
            case 7:
                return this.f1446sO;
            case 8:
                return this.f1447sP;
            case 9:
                return this.f1439ml;
            case 12:
                return Integer.valueOf(this.f1436dI);
            case 14:
                return this.f1458sm;
            case 15:
                return this.f1448sQ;
            case 16:
                return Boolean.valueOf(this.f1449sR);
            case 18:
                return this.f1450sS;
            case 19:
                return this.f1451sT;
            case 20:
                return this.f1452sU;
            case 21:
                return Integer.valueOf(this.f1453sV);
            case 22:
                return this.f1454sW;
            case 23:
                return this.f1455sX;
            case 24:
                return Integer.valueOf(this.f1456sY);
            case 25:
                return Integer.valueOf(this.f1457sZ);
            case 26:
                return this.f1459ta;
            case 27:
                return this.f1437hN;
            case 28:
                return this.f1460tb;
            case 29:
                return Boolean.valueOf(this.f1461tc);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
        }
    }

    /* renamed from: bp */
    public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
        return f1435rH;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dD */
    public C0564a mo5032dD() {
        return this.f1442sK;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dE */
    public C0565b mo5033dE() {
        return this.f1446sO;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dF */
    public C0568c mo5034dF() {
        return this.f1448sQ;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dG */
    public C0569d mo5035dG() {
        return this.f1451sT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dH */
    public List<C0571f> mo5036dH() {
        return this.f1454sW;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dI */
    public List<C0572g> mo5037dI() {
        return this.f1455sX;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dJ */
    public List<C0573h> mo5038dJ() {
        return this.f1460tb;
    }

    /* renamed from: dK */
    public C0563fv freeze() {
        return this;
    }

    public int describeContents() {
        C0574fw fwVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: di */
    public Set<Integer> mo5041di() {
        return this.f1440rI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0563fv)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0563fv fvVar = (C0563fv) obj;
        for (C0422dw.C0423a next : f1435rH.values()) {
            if (mo4432a(next)) {
                if (!fvVar.mo4432a(next)) {
                    return false;
                }
                if (!mo4433b(next).equals(fvVar.mo4433b(next))) {
                    return false;
                }
            } else if (fvVar.mo4432a(next)) {
                return false;
            }
        }
        return true;
    }

    public String getAboutMe() {
        return this.f1441sJ;
    }

    public Person.AgeRange getAgeRange() {
        return this.f1442sK;
    }

    public String getBirthday() {
        return this.f1443sL;
    }

    public String getBraggingRights() {
        return this.f1444sM;
    }

    public int getCircledByCount() {
        return this.f1445sN;
    }

    public Person.Cover getCover() {
        return this.f1446sO;
    }

    public String getCurrentLocation() {
        return this.f1447sP;
    }

    public String getDisplayName() {
        return this.f1439ml;
    }

    public int getGender() {
        return this.f1436dI;
    }

    public String getId() {
        return this.f1458sm;
    }

    public Person.Image getImage() {
        return this.f1448sQ;
    }

    public String getLanguage() {
        return this.f1450sS;
    }

    public Person.Name getName() {
        return this.f1451sT;
    }

    public String getNickname() {
        return this.f1452sU;
    }

    public int getObjectType() {
        return this.f1453sV;
    }

    public List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.f1454sW;
    }

    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.f1455sX;
    }

    public int getPlusOneCount() {
        return this.f1456sY;
    }

    public int getRelationshipStatus() {
        return this.f1457sZ;
    }

    public String getTagline() {
        return this.f1459ta;
    }

    public String getUrl() {
        return this.f1437hN;
    }

    public List<Person.Urls> getUrls() {
        return (ArrayList) this.f1460tb;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1438iM;
    }

    public boolean hasAboutMe() {
        return this.f1440rI.contains(2);
    }

    public boolean hasAgeRange() {
        return this.f1440rI.contains(3);
    }

    public boolean hasBirthday() {
        return this.f1440rI.contains(4);
    }

    public boolean hasBraggingRights() {
        return this.f1440rI.contains(5);
    }

    public boolean hasCircledByCount() {
        return this.f1440rI.contains(6);
    }

    public boolean hasCover() {
        return this.f1440rI.contains(7);
    }

    public boolean hasCurrentLocation() {
        return this.f1440rI.contains(8);
    }

    public boolean hasDisplayName() {
        return this.f1440rI.contains(9);
    }

    public boolean hasGender() {
        return this.f1440rI.contains(12);
    }

    public boolean hasId() {
        return this.f1440rI.contains(14);
    }

    public boolean hasImage() {
        return this.f1440rI.contains(15);
    }

    public boolean hasIsPlusUser() {
        return this.f1440rI.contains(16);
    }

    public boolean hasLanguage() {
        return this.f1440rI.contains(18);
    }

    public boolean hasName() {
        return this.f1440rI.contains(19);
    }

    public boolean hasNickname() {
        return this.f1440rI.contains(20);
    }

    public boolean hasObjectType() {
        return this.f1440rI.contains(21);
    }

    public boolean hasOrganizations() {
        return this.f1440rI.contains(22);
    }

    public boolean hasPlacesLived() {
        return this.f1440rI.contains(23);
    }

    public boolean hasPlusOneCount() {
        return this.f1440rI.contains(24);
    }

    public boolean hasRelationshipStatus() {
        return this.f1440rI.contains(25);
    }

    public boolean hasTagline() {
        return this.f1440rI.contains(26);
    }

    public boolean hasUrl() {
        return this.f1440rI.contains(27);
    }

    public boolean hasUrls() {
        return this.f1440rI.contains(28);
    }

    public boolean hasVerified() {
        return this.f1440rI.contains(29);
    }

    public int hashCode() {
        int i = 0;
        Iterator<C0422dw.C0423a<?, ?>> it = f1435rH.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C0422dw.C0423a next = it.next();
            if (mo4432a(next)) {
                i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
            } else {
                i = i2;
            }
        }
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.f1449sR;
    }

    public boolean isVerified() {
        return this.f1461tc;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0574fw fwVar = CREATOR;
        C0574fw.m1797a(this, out, flags);
    }
}
