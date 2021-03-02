package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C1369ji;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ny */
public final class C1639ny extends C1372jj implements Person {
    public static final C1650nz CREATOR = new C1650nz();
    private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

    /* renamed from: BL */
    String f4317BL;

    /* renamed from: BR */
    final int f4318BR;

    /* renamed from: Fc */
    String f4319Fc;

    /* renamed from: Nz */
    String f4320Nz;
    final Set<Integer> alR;
    String amP;
    C1640a amQ;
    String amR;
    String amS;
    int amT;
    C1641b amU;
    String amV;
    C1644c amW;
    boolean amX;
    C1645d amY;
    String amZ;
    int ana;
    List<C1647f> anb;
    List<C1648g> anc;
    int and;
    int ane;
    String anf;
    List<C1649h> ang;
    boolean anh;

    /* renamed from: om */
    int f4321om;

    /* renamed from: uR */
    String f4322uR;

    /* renamed from: com.google.android.gms.internal.ny$a */
    public static final class C1640a extends C1372jj implements Person.AgeRange {
        public static final C1653oa CREATOR = new C1653oa();
        private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

        /* renamed from: BR */
        final int f4323BR;
        final Set<Integer> alR;
        int ani;
        int anj;

        static {
            alQ.put("max", C1369ji.C1370a.m5136i("max", 2));
            alQ.put("min", C1369ji.C1370a.m5136i("min", 3));
        }

        public C1640a() {
            this.f4323BR = 1;
            this.alR = new HashSet();
        }

        C1640a(Set<Integer> set, int i, int i2, int i3) {
            this.alR = set;
            this.f4323BR = i;
            this.ani = i2;
            this.anj = i3;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9017a(C1369ji.C1370a aVar) {
            return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo9018b(C1369ji.C1370a aVar) {
            switch (aVar.mo9037hm()) {
                case 2:
                    return Integer.valueOf(this.ani);
                case 3:
                    return Integer.valueOf(this.anj);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
            }
        }

        public int describeContents() {
            C1653oa oaVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1640a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1640a aVar = (C1640a) obj;
            for (C1369ji.C1370a next : alQ.values()) {
                if (mo9017a(next)) {
                    if (!aVar.mo9017a(next)) {
                        return false;
                    }
                    if (!mo9018b(next).equals(aVar.mo9018b(next))) {
                        return false;
                    }
                } else if (aVar.mo9017a(next)) {
                    return false;
                }
            }
            return true;
        }

        public int getMax() {
            return this.ani;
        }

        public int getMin() {
            return this.anj;
        }

        public boolean hasMax() {
            return this.alR.contains(2);
        }

        public boolean hasMin() {
            return this.alR.contains(3);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C1369ji.C1370a next = it.next();
                if (mo9017a(next)) {
                    i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: hf */
        public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
            return alQ;
        }

        public boolean isDataValid() {
            return true;
        }

        /* renamed from: nt */
        public C1640a freeze() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1653oa oaVar = CREATOR;
            C1653oa.m5809a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ny$b */
    public static final class C1641b extends C1372jj implements Person.Cover {
        public static final C1654ob CREATOR = new C1654ob();
        private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

        /* renamed from: BR */
        final int f4324BR;
        final Set<Integer> alR;
        C1642a ank;
        C1643b anl;
        int anm;

        /* renamed from: com.google.android.gms.internal.ny$b$a */
        public static final class C1642a extends C1372jj implements Person.Cover.CoverInfo {
            public static final C1655oc CREATOR = new C1655oc();
            private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

            /* renamed from: BR */
            final int f4325BR;
            final Set<Integer> alR;
            int ann;
            int ano;

            static {
                alQ.put("leftImageOffset", C1369ji.C1370a.m5136i("leftImageOffset", 2));
                alQ.put("topImageOffset", C1369ji.C1370a.m5136i("topImageOffset", 3));
            }

            public C1642a() {
                this.f4325BR = 1;
                this.alR = new HashSet();
            }

            C1642a(Set<Integer> set, int i, int i2, int i3) {
                this.alR = set;
                this.f4325BR = i;
                this.ann = i2;
                this.ano = i3;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo9017a(C1369ji.C1370a aVar) {
                return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Object mo9018b(C1369ji.C1370a aVar) {
                switch (aVar.mo9037hm()) {
                    case 2:
                        return Integer.valueOf(this.ann);
                    case 3:
                        return Integer.valueOf(this.ano);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
                }
            }

            public int describeContents() {
                C1655oc ocVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1642a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1642a aVar = (C1642a) obj;
                for (C1369ji.C1370a next : alQ.values()) {
                    if (mo9017a(next)) {
                        if (!aVar.mo9017a(next)) {
                            return false;
                        }
                        if (!mo9018b(next).equals(aVar.mo9018b(next))) {
                            return false;
                        }
                    } else if (aVar.mo9017a(next)) {
                        return false;
                    }
                }
                return true;
            }

            public int getLeftImageOffset() {
                return this.ann;
            }

            public int getTopImageOffset() {
                return this.ano;
            }

            public boolean hasLeftImageOffset() {
                return this.alR.contains(2);
            }

            public boolean hasTopImageOffset() {
                return this.alR.contains(3);
            }

            public int hashCode() {
                int i = 0;
                Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    C1369ji.C1370a next = it.next();
                    if (mo9017a(next)) {
                        i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                    } else {
                        i = i2;
                    }
                }
            }

            /* renamed from: hf */
            public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
                return alQ;
            }

            public boolean isDataValid() {
                return true;
            }

            /* renamed from: nv */
            public C1642a freeze() {
                return this;
            }

            public void writeToParcel(Parcel out, int flags) {
                C1655oc ocVar = CREATOR;
                C1655oc.m5815a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.ny$b$b */
        public static final class C1643b extends C1372jj implements Person.Cover.CoverPhoto {
            public static final C1656od CREATOR = new C1656od();
            private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

            /* renamed from: BR */
            final int f4326BR;
            final Set<Integer> alR;

            /* renamed from: lf */
            int f4327lf;

            /* renamed from: lg */
            int f4328lg;

            /* renamed from: uR */
            String f4329uR;

            static {
                alQ.put("height", C1369ji.C1370a.m5136i("height", 2));
                alQ.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1369ji.C1370a.m5139l(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                alQ.put("width", C1369ji.C1370a.m5136i("width", 4));
            }

            public C1643b() {
                this.f4326BR = 1;
                this.alR = new HashSet();
            }

            C1643b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.alR = set;
                this.f4326BR = i;
                this.f4328lg = i2;
                this.f4329uR = str;
                this.f4327lf = i3;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo9017a(C1369ji.C1370a aVar) {
                return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Object mo9018b(C1369ji.C1370a aVar) {
                switch (aVar.mo9037hm()) {
                    case 2:
                        return Integer.valueOf(this.f4328lg);
                    case 3:
                        return this.f4329uR;
                    case 4:
                        return Integer.valueOf(this.f4327lf);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
                }
            }

            public int describeContents() {
                C1656od odVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1643b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1643b bVar = (C1643b) obj;
                for (C1369ji.C1370a next : alQ.values()) {
                    if (mo9017a(next)) {
                        if (!bVar.mo9017a(next)) {
                            return false;
                        }
                        if (!mo9018b(next).equals(bVar.mo9018b(next))) {
                            return false;
                        }
                    } else if (bVar.mo9017a(next)) {
                        return false;
                    }
                }
                return true;
            }

            public int getHeight() {
                return this.f4328lg;
            }

            public String getUrl() {
                return this.f4329uR;
            }

            public int getWidth() {
                return this.f4327lf;
            }

            public boolean hasHeight() {
                return this.alR.contains(2);
            }

            public boolean hasUrl() {
                return this.alR.contains(3);
            }

            public boolean hasWidth() {
                return this.alR.contains(4);
            }

            public int hashCode() {
                int i = 0;
                Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    C1369ji.C1370a next = it.next();
                    if (mo9017a(next)) {
                        i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                    } else {
                        i = i2;
                    }
                }
            }

            /* renamed from: hf */
            public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
                return alQ;
            }

            public boolean isDataValid() {
                return true;
            }

            /* renamed from: nw */
            public C1643b freeze() {
                return this;
            }

            public void writeToParcel(Parcel out, int flags) {
                C1656od odVar = CREATOR;
                C1656od.m5818a(this, out, flags);
            }
        }

        static {
            alQ.put("coverInfo", C1369ji.C1370a.m5133a("coverInfo", 2, C1642a.class));
            alQ.put("coverPhoto", C1369ji.C1370a.m5133a("coverPhoto", 3, C1643b.class));
            alQ.put("layout", C1369ji.C1370a.m5132a("layout", 4, new C1365jf().mo9001h("banner", 0), false));
        }

        public C1641b() {
            this.f4324BR = 1;
            this.alR = new HashSet();
        }

        C1641b(Set<Integer> set, int i, C1642a aVar, C1643b bVar, int i2) {
            this.alR = set;
            this.f4324BR = i;
            this.ank = aVar;
            this.anl = bVar;
            this.anm = i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9017a(C1369ji.C1370a aVar) {
            return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo9018b(C1369ji.C1370a aVar) {
            switch (aVar.mo9037hm()) {
                case 2:
                    return this.ank;
                case 3:
                    return this.anl;
                case 4:
                    return Integer.valueOf(this.anm);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
            }
        }

        public int describeContents() {
            C1654ob obVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1641b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1641b bVar = (C1641b) obj;
            for (C1369ji.C1370a next : alQ.values()) {
                if (mo9017a(next)) {
                    if (!bVar.mo9017a(next)) {
                        return false;
                    }
                    if (!mo9018b(next).equals(bVar.mo9018b(next))) {
                        return false;
                    }
                } else if (bVar.mo9017a(next)) {
                    return false;
                }
            }
            return true;
        }

        public Person.Cover.CoverInfo getCoverInfo() {
            return this.ank;
        }

        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.anl;
        }

        public int getLayout() {
            return this.anm;
        }

        public boolean hasCoverInfo() {
            return this.alR.contains(2);
        }

        public boolean hasCoverPhoto() {
            return this.alR.contains(3);
        }

        public boolean hasLayout() {
            return this.alR.contains(4);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C1369ji.C1370a next = it.next();
                if (mo9017a(next)) {
                    i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: hf */
        public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
            return alQ;
        }

        public boolean isDataValid() {
            return true;
        }

        /* renamed from: nu */
        public C1641b freeze() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1654ob obVar = CREATOR;
            C1654ob.m5812a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ny$c */
    public static final class C1644c extends C1372jj implements Person.Image {
        public static final C1657oe CREATOR = new C1657oe();
        private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

        /* renamed from: BR */
        final int f4330BR;
        final Set<Integer> alR;

        /* renamed from: uR */
        String f4331uR;

        static {
            alQ.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1369ji.C1370a.m5139l(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C1644c() {
            this.f4330BR = 1;
            this.alR = new HashSet();
        }

        public C1644c(String str) {
            this.alR = new HashSet();
            this.f4330BR = 1;
            this.f4331uR = str;
            this.alR.add(2);
        }

        C1644c(Set<Integer> set, int i, String str) {
            this.alR = set;
            this.f4330BR = i;
            this.f4331uR = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9017a(C1369ji.C1370a aVar) {
            return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo9018b(C1369ji.C1370a aVar) {
            switch (aVar.mo9037hm()) {
                case 2:
                    return this.f4331uR;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
            }
        }

        public int describeContents() {
            C1657oe oeVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1644c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1644c cVar = (C1644c) obj;
            for (C1369ji.C1370a next : alQ.values()) {
                if (mo9017a(next)) {
                    if (!cVar.mo9017a(next)) {
                        return false;
                    }
                    if (!mo9018b(next).equals(cVar.mo9018b(next))) {
                        return false;
                    }
                } else if (cVar.mo9017a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getUrl() {
            return this.f4331uR;
        }

        public boolean hasUrl() {
            return this.alR.contains(2);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C1369ji.C1370a next = it.next();
                if (mo9017a(next)) {
                    i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: hf */
        public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
            return alQ;
        }

        public boolean isDataValid() {
            return true;
        }

        /* renamed from: nx */
        public C1644c freeze() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1657oe oeVar = CREATOR;
            C1657oe.m5821a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ny$d */
    public static final class C1645d extends C1372jj implements Person.Name {
        public static final C1658of CREATOR = new C1658of();
        private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

        /* renamed from: BR */
        final int f4332BR;
        final Set<Integer> alR;
        String amp;
        String ams;
        String anp;
        String anq;
        String anr;
        String ans;

        static {
            alQ.put("familyName", C1369ji.C1370a.m5139l("familyName", 2));
            alQ.put("formatted", C1369ji.C1370a.m5139l("formatted", 3));
            alQ.put("givenName", C1369ji.C1370a.m5139l("givenName", 4));
            alQ.put("honorificPrefix", C1369ji.C1370a.m5139l("honorificPrefix", 5));
            alQ.put("honorificSuffix", C1369ji.C1370a.m5139l("honorificSuffix", 6));
            alQ.put("middleName", C1369ji.C1370a.m5139l("middleName", 7));
        }

        public C1645d() {
            this.f4332BR = 1;
            this.alR = new HashSet();
        }

        C1645d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.alR = set;
            this.f4332BR = i;
            this.amp = str;
            this.anp = str2;
            this.ams = str3;
            this.anq = str4;
            this.anr = str5;
            this.ans = str6;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9017a(C1369ji.C1370a aVar) {
            return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo9018b(C1369ji.C1370a aVar) {
            switch (aVar.mo9037hm()) {
                case 2:
                    return this.amp;
                case 3:
                    return this.anp;
                case 4:
                    return this.ams;
                case 5:
                    return this.anq;
                case 6:
                    return this.anr;
                case 7:
                    return this.ans;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
            }
        }

        public int describeContents() {
            C1658of ofVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1645d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1645d dVar = (C1645d) obj;
            for (C1369ji.C1370a next : alQ.values()) {
                if (mo9017a(next)) {
                    if (!dVar.mo9017a(next)) {
                        return false;
                    }
                    if (!mo9018b(next).equals(dVar.mo9018b(next))) {
                        return false;
                    }
                } else if (dVar.mo9017a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getFamilyName() {
            return this.amp;
        }

        public String getFormatted() {
            return this.anp;
        }

        public String getGivenName() {
            return this.ams;
        }

        public String getHonorificPrefix() {
            return this.anq;
        }

        public String getHonorificSuffix() {
            return this.anr;
        }

        public String getMiddleName() {
            return this.ans;
        }

        public boolean hasFamilyName() {
            return this.alR.contains(2);
        }

        public boolean hasFormatted() {
            return this.alR.contains(3);
        }

        public boolean hasGivenName() {
            return this.alR.contains(4);
        }

        public boolean hasHonorificPrefix() {
            return this.alR.contains(5);
        }

        public boolean hasHonorificSuffix() {
            return this.alR.contains(6);
        }

        public boolean hasMiddleName() {
            return this.alR.contains(7);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C1369ji.C1370a next = it.next();
                if (mo9017a(next)) {
                    i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: hf */
        public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
            return alQ;
        }

        public boolean isDataValid() {
            return true;
        }

        /* renamed from: ny */
        public C1645d freeze() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1658of ofVar = CREATOR;
            C1658of.m5824a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ny$e */
    public static class C1646e {
        /* renamed from: cf */
        public static int m5789cf(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.ny$f */
    public static final class C1647f extends C1372jj implements Person.Organizations {
        public static final C1659og CREATOR = new C1659og();
        private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

        /* renamed from: BR */
        final int f4333BR;

        /* renamed from: FD */
        int f4334FD;

        /* renamed from: No */
        String f4335No;

        /* renamed from: Tg */
        String f4336Tg;
        final Set<Integer> alR;
        String amE;
        String amo;
        String ant;
        String anu;
        boolean anv;
        String mName;

        static {
            alQ.put("department", C1369ji.C1370a.m5139l("department", 2));
            alQ.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C1369ji.C1370a.m5139l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            alQ.put("endDate", C1369ji.C1370a.m5139l("endDate", 4));
            alQ.put("location", C1369ji.C1370a.m5139l("location", 5));
            alQ.put("name", C1369ji.C1370a.m5139l("name", 6));
            alQ.put("primary", C1369ji.C1370a.m5138k("primary", 7));
            alQ.put("startDate", C1369ji.C1370a.m5139l("startDate", 8));
            alQ.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C1369ji.C1370a.m5139l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            alQ.put("type", C1369ji.C1370a.m5132a("type", 10, new C1365jf().mo9001h("work", 0).mo9001h("school", 1), false));
        }

        public C1647f() {
            this.f4333BR = 1;
            this.alR = new HashSet();
        }

        C1647f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.alR = set;
            this.f4333BR = i;
            this.ant = str;
            this.f4336Tg = str2;
            this.amo = str3;
            this.anu = str4;
            this.mName = str5;
            this.anv = z;
            this.amE = str6;
            this.f4335No = str7;
            this.f4334FD = i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9017a(C1369ji.C1370a aVar) {
            return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo9018b(C1369ji.C1370a aVar) {
            switch (aVar.mo9037hm()) {
                case 2:
                    return this.ant;
                case 3:
                    return this.f4336Tg;
                case 4:
                    return this.amo;
                case 5:
                    return this.anu;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.anv);
                case 8:
                    return this.amE;
                case 9:
                    return this.f4335No;
                case 10:
                    return Integer.valueOf(this.f4334FD);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
            }
        }

        public int describeContents() {
            C1659og ogVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1647f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1647f fVar = (C1647f) obj;
            for (C1369ji.C1370a next : alQ.values()) {
                if (mo9017a(next)) {
                    if (!fVar.mo9017a(next)) {
                        return false;
                    }
                    if (!mo9018b(next).equals(fVar.mo9018b(next))) {
                        return false;
                    }
                } else if (fVar.mo9017a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getDepartment() {
            return this.ant;
        }

        public String getDescription() {
            return this.f4336Tg;
        }

        public String getEndDate() {
            return this.amo;
        }

        public String getLocation() {
            return this.anu;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.amE;
        }

        public String getTitle() {
            return this.f4335No;
        }

        public int getType() {
            return this.f4334FD;
        }

        public boolean hasDepartment() {
            return this.alR.contains(2);
        }

        public boolean hasDescription() {
            return this.alR.contains(3);
        }

        public boolean hasEndDate() {
            return this.alR.contains(4);
        }

        public boolean hasLocation() {
            return this.alR.contains(5);
        }

        public boolean hasName() {
            return this.alR.contains(6);
        }

        public boolean hasPrimary() {
            return this.alR.contains(7);
        }

        public boolean hasStartDate() {
            return this.alR.contains(8);
        }

        public boolean hasTitle() {
            return this.alR.contains(9);
        }

        public boolean hasType() {
            return this.alR.contains(10);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C1369ji.C1370a next = it.next();
                if (mo9017a(next)) {
                    i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: hf */
        public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
            return alQ;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.anv;
        }

        /* renamed from: nz */
        public C1647f freeze() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1659og ogVar = CREATOR;
            C1659og.m5827a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ny$g */
    public static final class C1648g extends C1372jj implements Person.PlacesLived {
        public static final C1660oh CREATOR = new C1660oh();
        private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

        /* renamed from: BR */
        final int f4337BR;
        final Set<Integer> alR;
        boolean anv;
        String mValue;

        static {
            alQ.put("primary", C1369ji.C1370a.m5138k("primary", 2));
            alQ.put("value", C1369ji.C1370a.m5139l("value", 3));
        }

        public C1648g() {
            this.f4337BR = 1;
            this.alR = new HashSet();
        }

        C1648g(Set<Integer> set, int i, boolean z, String str) {
            this.alR = set;
            this.f4337BR = i;
            this.anv = z;
            this.mValue = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9017a(C1369ji.C1370a aVar) {
            return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo9018b(C1369ji.C1370a aVar) {
            switch (aVar.mo9037hm()) {
                case 2:
                    return Boolean.valueOf(this.anv);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
            }
        }

        public int describeContents() {
            C1660oh ohVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1648g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1648g gVar = (C1648g) obj;
            for (C1369ji.C1370a next : alQ.values()) {
                if (mo9017a(next)) {
                    if (!gVar.mo9017a(next)) {
                        return false;
                    }
                    if (!mo9018b(next).equals(gVar.mo9018b(next))) {
                        return false;
                    }
                } else if (gVar.mo9017a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.alR.contains(2);
        }

        public boolean hasValue() {
            return this.alR.contains(3);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C1369ji.C1370a next = it.next();
                if (mo9017a(next)) {
                    i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: hf */
        public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
            return alQ;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.anv;
        }

        /* renamed from: nA */
        public C1648g freeze() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1660oh ohVar = CREATOR;
            C1660oh.m5830a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ny$h */
    public static final class C1649h extends C1372jj implements Person.Urls {
        public static final C1661oi CREATOR = new C1661oi();
        private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

        /* renamed from: BR */
        final int f4338BR;

        /* renamed from: FD */
        int f4339FD;
        final Set<Integer> alR;
        String anw;
        private final int anx;
        String mValue;

        static {
            alQ.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C1369ji.C1370a.m5139l(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            alQ.put("type", C1369ji.C1370a.m5132a("type", 6, new C1365jf().mo9001h("home", 0).mo9001h("work", 1).mo9001h("blog", 2).mo9001h(Scopes.PROFILE, 3).mo9001h(FitnessActivities.OTHER_STRING, 4).mo9001h("otherProfile", 5).mo9001h("contributor", 6).mo9001h("website", 7), false));
            alQ.put("value", C1369ji.C1370a.m5139l("value", 4));
        }

        public C1649h() {
            this.anx = 4;
            this.f4338BR = 1;
            this.alR = new HashSet();
        }

        C1649h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.anx = 4;
            this.alR = set;
            this.f4338BR = i;
            this.anw = str;
            this.f4339FD = i2;
            this.mValue = str2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9017a(C1369ji.C1370a aVar) {
            return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo9018b(C1369ji.C1370a aVar) {
            switch (aVar.mo9037hm()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.anw;
                case 6:
                    return Integer.valueOf(this.f4339FD);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
            }
        }

        public int describeContents() {
            C1661oi oiVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1649h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1649h hVar = (C1649h) obj;
            for (C1369ji.C1370a next : alQ.values()) {
                if (mo9017a(next)) {
                    if (!hVar.mo9017a(next)) {
                        return false;
                    }
                    if (!mo9018b(next).equals(hVar.mo9018b(next))) {
                        return false;
                    }
                } else if (hVar.mo9017a(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getLabel() {
            return this.anw;
        }

        public int getType() {
            return this.f4339FD;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.alR.contains(5);
        }

        public boolean hasType() {
            return this.alR.contains(6);
        }

        public boolean hasValue() {
            return this.alR.contains(4);
        }

        public int hashCode() {
            int i = 0;
            Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C1369ji.C1370a next = it.next();
                if (mo9017a(next)) {
                    i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: hf */
        public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
            return alQ;
        }

        public boolean isDataValid() {
            return true;
        }

        @Deprecated
        /* renamed from: nB */
        public int mo9872nB() {
            return 4;
        }

        /* renamed from: nC */
        public C1649h freeze() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1661oi oiVar = CREATOR;
            C1661oi.m5833a(this, out, flags);
        }
    }

    static {
        alQ.put("aboutMe", C1369ji.C1370a.m5139l("aboutMe", 2));
        alQ.put("ageRange", C1369ji.C1370a.m5133a("ageRange", 3, C1640a.class));
        alQ.put("birthday", C1369ji.C1370a.m5139l("birthday", 4));
        alQ.put("braggingRights", C1369ji.C1370a.m5139l("braggingRights", 5));
        alQ.put("circledByCount", C1369ji.C1370a.m5136i("circledByCount", 6));
        alQ.put("cover", C1369ji.C1370a.m5133a("cover", 7, C1641b.class));
        alQ.put("currentLocation", C1369ji.C1370a.m5139l("currentLocation", 8));
        alQ.put("displayName", C1369ji.C1370a.m5139l("displayName", 9));
        alQ.put("gender", C1369ji.C1370a.m5132a("gender", 12, new C1365jf().mo9001h("male", 0).mo9001h("female", 1).mo9001h(FitnessActivities.OTHER_STRING, 2), false));
        alQ.put("id", C1369ji.C1370a.m5139l("id", 14));
        alQ.put("image", C1369ji.C1370a.m5133a("image", 15, C1644c.class));
        alQ.put("isPlusUser", C1369ji.C1370a.m5138k("isPlusUser", 16));
        alQ.put("language", C1369ji.C1370a.m5139l("language", 18));
        alQ.put("name", C1369ji.C1370a.m5133a("name", 19, C1645d.class));
        alQ.put("nickname", C1369ji.C1370a.m5139l("nickname", 20));
        alQ.put("objectType", C1369ji.C1370a.m5132a("objectType", 21, new C1365jf().mo9001h("person", 0).mo9001h("page", 1), false));
        alQ.put("organizations", C1369ji.C1370a.m5134b("organizations", 22, C1647f.class));
        alQ.put("placesLived", C1369ji.C1370a.m5134b("placesLived", 23, C1648g.class));
        alQ.put("plusOneCount", C1369ji.C1370a.m5136i("plusOneCount", 24));
        alQ.put("relationshipStatus", C1369ji.C1370a.m5132a("relationshipStatus", 25, new C1365jf().mo9001h("single", 0).mo9001h("in_a_relationship", 1).mo9001h("engaged", 2).mo9001h("married", 3).mo9001h("its_complicated", 4).mo9001h("open_relationship", 5).mo9001h("widowed", 6).mo9001h("in_domestic_partnership", 7).mo9001h("in_civil_union", 8), false));
        alQ.put("tagline", C1369ji.C1370a.m5139l("tagline", 26));
        alQ.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1369ji.C1370a.m5139l(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        alQ.put("urls", C1369ji.C1370a.m5134b("urls", 28, C1649h.class));
        alQ.put("verified", C1369ji.C1370a.m5138k("verified", 29));
    }

    public C1639ny() {
        this.f4318BR = 1;
        this.alR = new HashSet();
    }

    public C1639ny(String str, String str2, C1644c cVar, int i, String str3) {
        this.f4318BR = 1;
        this.alR = new HashSet();
        this.f4320Nz = str;
        this.alR.add(9);
        this.f4317BL = str2;
        this.alR.add(14);
        this.amW = cVar;
        this.alR.add(15);
        this.ana = i;
        this.alR.add(21);
        this.f4322uR = str3;
        this.alR.add(27);
    }

    C1639ny(Set<Integer> set, int i, String str, C1640a aVar, String str2, String str3, int i2, C1641b bVar, String str4, String str5, int i3, String str6, C1644c cVar, boolean z, String str7, C1645d dVar, String str8, int i4, List<C1647f> list, List<C1648g> list2, int i5, int i6, String str9, String str10, List<C1649h> list3, boolean z2) {
        this.alR = set;
        this.f4318BR = i;
        this.amP = str;
        this.amQ = aVar;
        this.amR = str2;
        this.amS = str3;
        this.amT = i2;
        this.amU = bVar;
        this.amV = str4;
        this.f4320Nz = str5;
        this.f4321om = i3;
        this.f4317BL = str6;
        this.amW = cVar;
        this.amX = z;
        this.f4319Fc = str7;
        this.amY = dVar;
        this.amZ = str8;
        this.ana = i4;
        this.anb = list;
        this.anc = list2;
        this.and = i5;
        this.ane = i6;
        this.anf = str9;
        this.f4322uR = str10;
        this.ang = list3;
        this.anh = z2;
    }

    /* renamed from: i */
    public static C1639ny m5760i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C1639ny dd = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return dd;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo9017a(C1369ji.C1370a aVar) {
        return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo9018b(C1369ji.C1370a aVar) {
        switch (aVar.mo9037hm()) {
            case 2:
                return this.amP;
            case 3:
                return this.amQ;
            case 4:
                return this.amR;
            case 5:
                return this.amS;
            case 6:
                return Integer.valueOf(this.amT);
            case 7:
                return this.amU;
            case 8:
                return this.amV;
            case 9:
                return this.f4320Nz;
            case 12:
                return Integer.valueOf(this.f4321om);
            case 14:
                return this.f4317BL;
            case 15:
                return this.amW;
            case 16:
                return Boolean.valueOf(this.amX);
            case 18:
                return this.f4319Fc;
            case 19:
                return this.amY;
            case FitnessActivities.BOXING:
                return this.amZ;
            case 21:
                return Integer.valueOf(this.ana);
            case FitnessActivities.CIRCUIT_TRAINING:
                return this.anb;
            case FitnessActivities.CRICKET:
                return this.anc;
            case FitnessActivities.DANCING:
                return Integer.valueOf(this.and);
            case FitnessActivities.ELLIPTICAL:
                return Integer.valueOf(this.ane);
            case FitnessActivities.FENCING:
                return this.anf;
            case FitnessActivities.FOOTBALL_AMERICAN:
                return this.f4322uR;
            case FitnessActivities.FOOTBALL_AUSTRALIAN:
                return this.ang;
            case FitnessActivities.FOOTBALL_SOCCER:
                return Boolean.valueOf(this.anh);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
        }
    }

    public int describeContents() {
        C1650nz nzVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1639ny)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C1639ny nyVar = (C1639ny) obj;
        for (C1369ji.C1370a next : alQ.values()) {
            if (mo9017a(next)) {
                if (!nyVar.mo9017a(next)) {
                    return false;
                }
                if (!mo9018b(next).equals(nyVar.mo9018b(next))) {
                    return false;
                }
            } else if (nyVar.mo9017a(next)) {
                return false;
            }
        }
        return true;
    }

    public String getAboutMe() {
        return this.amP;
    }

    public Person.AgeRange getAgeRange() {
        return this.amQ;
    }

    public String getBirthday() {
        return this.amR;
    }

    public String getBraggingRights() {
        return this.amS;
    }

    public int getCircledByCount() {
        return this.amT;
    }

    public Person.Cover getCover() {
        return this.amU;
    }

    public String getCurrentLocation() {
        return this.amV;
    }

    public String getDisplayName() {
        return this.f4320Nz;
    }

    public int getGender() {
        return this.f4321om;
    }

    public String getId() {
        return this.f4317BL;
    }

    public Person.Image getImage() {
        return this.amW;
    }

    public String getLanguage() {
        return this.f4319Fc;
    }

    public Person.Name getName() {
        return this.amY;
    }

    public String getNickname() {
        return this.amZ;
    }

    public int getObjectType() {
        return this.ana;
    }

    public List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.anb;
    }

    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.anc;
    }

    public int getPlusOneCount() {
        return this.and;
    }

    public int getRelationshipStatus() {
        return this.ane;
    }

    public String getTagline() {
        return this.anf;
    }

    public String getUrl() {
        return this.f4322uR;
    }

    public List<Person.Urls> getUrls() {
        return (ArrayList) this.ang;
    }

    public boolean hasAboutMe() {
        return this.alR.contains(2);
    }

    public boolean hasAgeRange() {
        return this.alR.contains(3);
    }

    public boolean hasBirthday() {
        return this.alR.contains(4);
    }

    public boolean hasBraggingRights() {
        return this.alR.contains(5);
    }

    public boolean hasCircledByCount() {
        return this.alR.contains(6);
    }

    public boolean hasCover() {
        return this.alR.contains(7);
    }

    public boolean hasCurrentLocation() {
        return this.alR.contains(8);
    }

    public boolean hasDisplayName() {
        return this.alR.contains(9);
    }

    public boolean hasGender() {
        return this.alR.contains(12);
    }

    public boolean hasId() {
        return this.alR.contains(14);
    }

    public boolean hasImage() {
        return this.alR.contains(15);
    }

    public boolean hasIsPlusUser() {
        return this.alR.contains(16);
    }

    public boolean hasLanguage() {
        return this.alR.contains(18);
    }

    public boolean hasName() {
        return this.alR.contains(19);
    }

    public boolean hasNickname() {
        return this.alR.contains(20);
    }

    public boolean hasObjectType() {
        return this.alR.contains(21);
    }

    public boolean hasOrganizations() {
        return this.alR.contains(22);
    }

    public boolean hasPlacesLived() {
        return this.alR.contains(23);
    }

    public boolean hasPlusOneCount() {
        return this.alR.contains(24);
    }

    public boolean hasRelationshipStatus() {
        return this.alR.contains(25);
    }

    public boolean hasTagline() {
        return this.alR.contains(26);
    }

    public boolean hasUrl() {
        return this.alR.contains(27);
    }

    public boolean hasUrls() {
        return this.alR.contains(28);
    }

    public boolean hasVerified() {
        return this.alR.contains(29);
    }

    public int hashCode() {
        int i = 0;
        Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C1369ji.C1370a next = it.next();
            if (mo9017a(next)) {
                i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
            } else {
                i = i2;
            }
        }
    }

    /* renamed from: hf */
    public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
        return alQ;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.amX;
    }

    public boolean isVerified() {
        return this.anh;
    }

    /* renamed from: ns */
    public C1639ny freeze() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1650nz nzVar = CREATOR;
        C1650nz.m5803a(this, out, flags);
    }
}
