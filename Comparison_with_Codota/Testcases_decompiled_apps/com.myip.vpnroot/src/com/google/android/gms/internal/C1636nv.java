package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.C1369ji;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.nv */
public final class C1636nv extends C1372jj implements Moment {
    public static final C1637nw CREATOR = new C1637nw();
    private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

    /* renamed from: BL */
    String f4314BL;

    /* renamed from: BR */
    final int f4315BR;
    final Set<Integer> alR;
    String amE;
    C1634nt amM;
    C1634nt amN;

    /* renamed from: uO */
    String f4316uO;

    static {
        alQ.put("id", C1369ji.C1370a.m5139l("id", 2));
        alQ.put("result", C1369ji.C1370a.m5133a("result", 4, C1634nt.class));
        alQ.put("startDate", C1369ji.C1370a.m5139l("startDate", 5));
        alQ.put("target", C1369ji.C1370a.m5133a("target", 6, C1634nt.class));
        alQ.put("type", C1369ji.C1370a.m5139l("type", 7));
    }

    public C1636nv() {
        this.f4315BR = 1;
        this.alR = new HashSet();
    }

    C1636nv(Set<Integer> set, int i, String str, C1634nt ntVar, String str2, C1634nt ntVar2, String str3) {
        this.alR = set;
        this.f4315BR = i;
        this.f4314BL = str;
        this.amM = ntVar;
        this.amE = str2;
        this.amN = ntVar2;
        this.f4316uO = str3;
    }

    public C1636nv(Set<Integer> set, String str, C1634nt ntVar, String str2, C1634nt ntVar2, String str3) {
        this.alR = set;
        this.f4315BR = 1;
        this.f4314BL = str;
        this.amM = ntVar;
        this.amE = str2;
        this.amN = ntVar2;
        this.f4316uO = str3;
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
                return this.f4314BL;
            case 4:
                return this.amM;
            case 5:
                return this.amE;
            case 6:
                return this.amN;
            case 7:
                return this.f4316uO;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
        }
    }

    public int describeContents() {
        C1637nw nwVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1636nv)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C1636nv nvVar = (C1636nv) obj;
        for (C1369ji.C1370a next : alQ.values()) {
            if (mo9017a(next)) {
                if (!nvVar.mo9017a(next)) {
                    return false;
                }
                if (!mo9018b(next).equals(nvVar.mo9018b(next))) {
                    return false;
                }
            } else if (nvVar.mo9017a(next)) {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return this.f4314BL;
    }

    public ItemScope getResult() {
        return this.amM;
    }

    public String getStartDate() {
        return this.amE;
    }

    public ItemScope getTarget() {
        return this.amN;
    }

    public String getType() {
        return this.f4316uO;
    }

    public boolean hasId() {
        return this.alR.contains(2);
    }

    public boolean hasResult() {
        return this.alR.contains(4);
    }

    public boolean hasStartDate() {
        return this.alR.contains(5);
    }

    public boolean hasTarget() {
        return this.alR.contains(6);
    }

    public boolean hasType() {
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

    /* renamed from: nq */
    public C1636nv freeze() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1637nw nwVar = CREATOR;
        C1637nw.m5755a(this, out, flags);
    }
}
