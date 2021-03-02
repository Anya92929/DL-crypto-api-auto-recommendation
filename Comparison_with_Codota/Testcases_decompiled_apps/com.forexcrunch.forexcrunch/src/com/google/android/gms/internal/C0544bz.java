package com.google.android.gms.internal;

import android.os.Parcel;
import com.forexcrunch.forexcrunch.gui.ChartActivity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0409ae;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.bz */
public final class C0544bz extends C0409ae implements SafeParcelable, Moment {
    public static final C0554ca CREATOR = new C0554ca();

    /* renamed from: iC */
    private static final HashMap<String, C0409ae.C0410a<?, ?>> f1234iC = new HashMap<>();

    /* renamed from: ab */
    private final int f1235ab;

    /* renamed from: iD */
    private final Set<Integer> f1236iD;

    /* renamed from: jB */
    private C0542bx f1237jB;

    /* renamed from: jC */
    private C0542bx f1238jC;

    /* renamed from: jh */
    private String f1239jh;

    /* renamed from: js */
    private String f1240js;

    /* renamed from: jy */
    private String f1241jy;

    static {
        f1234iC.put("id", C0409ae.C0410a.m832f("id", 2));
        f1234iC.put("result", C0409ae.C0410a.m826a("result", 4, C0542bx.class));
        f1234iC.put("startDate", C0409ae.C0410a.m832f("startDate", 5));
        f1234iC.put("target", C0409ae.C0410a.m826a("target", 6, C0542bx.class));
        f1234iC.put(ChartActivity.TYPE, C0409ae.C0410a.m832f(ChartActivity.TYPE, 7));
    }

    public C0544bz() {
        this.f1235ab = 1;
        this.f1236iD = new HashSet();
    }

    C0544bz(Set<Integer> set, int i, String str, C0542bx bxVar, String str2, C0542bx bxVar2, String str3) {
        this.f1236iD = set;
        this.f1235ab = i;
        this.f1239jh = str;
        this.f1237jB = bxVar;
        this.f1240js = str2;
        this.f1238jC = bxVar2;
        this.f1241jy = str3;
    }

    public C0544bz(Set<Integer> set, String str, C0542bx bxVar, String str2, C0542bx bxVar2, String str3) {
        this.f1236iD = set;
        this.f1235ab = 1;
        this.f1239jh = str;
        this.f1237jB = bxVar;
        this.f1240js = str2;
        this.f1238jC = bxVar2;
        this.f1241jy = str3;
    }

    /* renamed from: T */
    public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
        return f1234iC;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4479a(C0409ae.C0410a aVar) {
        return this.f1236iD.contains(Integer.valueOf(aVar.mo4493aa()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo4480b(C0409ae.C0410a aVar) {
        switch (aVar.mo4493aa()) {
            case 2:
                return this.f1239jh;
            case 4:
                return this.f1237jB;
            case 5:
                return this.f1240js;
            case 6:
                return this.f1238jC;
            case 7:
                return this.f1241jy;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bH */
    public Set<Integer> mo5077bH() {
        return this.f1236iD;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bY */
    public C0542bx mo5078bY() {
        return this.f1237jB;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bZ */
    public C0542bx mo5079bZ() {
        return this.f1238jC;
    }

    /* renamed from: ca */
    public C0544bz freeze() {
        return this;
    }

    public int describeContents() {
        C0554ca caVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0544bz)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0544bz bzVar = (C0544bz) obj;
        for (C0409ae.C0410a next : f1234iC.values()) {
            if (mo4479a(next)) {
                if (!bzVar.mo4479a(next)) {
                    return false;
                }
                if (!mo4480b(next).equals(bzVar.mo4480b(next))) {
                    return false;
                }
            } else if (bzVar.mo4479a(next)) {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return this.f1239jh;
    }

    public ItemScope getResult() {
        return this.f1237jB;
    }

    public String getStartDate() {
        return this.f1240js;
    }

    public ItemScope getTarget() {
        return this.f1238jC;
    }

    public String getType() {
        return this.f1241jy;
    }

    public boolean hasId() {
        return this.f1236iD.contains(2);
    }

    public boolean hasResult() {
        return this.f1236iD.contains(4);
    }

    public boolean hasStartDate() {
        return this.f1236iD.contains(5);
    }

    public boolean hasTarget() {
        return this.f1236iD.contains(6);
    }

    public boolean hasType() {
        return this.f1236iD.contains(7);
    }

    public int hashCode() {
        int i = 0;
        Iterator<C0409ae.C0410a<?, ?>> it = f1234iC.values().iterator();
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
    public int mo5094i() {
        return this.f1235ab;
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
        C0554ca caVar = CREATOR;
        C0554ca.m1596a(this, out, flags);
    }
}
