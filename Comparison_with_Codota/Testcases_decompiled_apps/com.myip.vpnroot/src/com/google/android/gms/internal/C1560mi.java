package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.mi */
public final class C1560mi implements SafeParcelable {
    public static final C1561mj CREATOR = new C1561mj();

    /* renamed from: BR */
    final int f4284BR;
    final List<C1566mo> afg;
    private final String afh;
    private final boolean afi;
    final List<C1570ms> afj;
    final List<String> afk;
    private final Set<C1566mo> afl;
    private final Set<C1570ms> afm;
    private final Set<String> afn;

    C1560mi(int i, List<C1566mo> list, String str, boolean z, List<C1570ms> list2, List<String> list3) {
        this.f4284BR = i;
        this.afg = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.afh = str == null ? "" : str;
        this.afi = z;
        this.afj = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.afk = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.afl = m5609f(this.afg);
        this.afm = m5609f(this.afj);
        this.afn = m5609f(this.afk);
    }

    /* renamed from: f */
    private static <E> Set<E> m5609f(List<E> list) {
        return list.isEmpty() ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }

    public int describeContents() {
        C1561mj mjVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1560mi)) {
            return false;
        }
        C1560mi miVar = (C1560mi) object;
        return this.afl.equals(miVar.afl) && this.afi == miVar.afi && this.afm.equals(miVar.afm) && this.afn.equals(miVar.afn);
    }

    public int hashCode() {
        return C0345m.hashCode(this.afl, Boolean.valueOf(this.afi), this.afm, this.afn);
    }

    @Deprecated
    /* renamed from: mg */
    public String mo9406mg() {
        return this.afh;
    }

    /* renamed from: mh */
    public boolean mo9407mh() {
        return this.afi;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("types", this.afl).mo4549a("placeIds", this.afn).mo4549a("requireOpenNow", Boolean.valueOf(this.afi)).mo4549a("requestedUserDataTypes", this.afm).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1561mj mjVar = CREATOR;
        C1561mj.m5612a(this, parcel, flags);
    }
}
