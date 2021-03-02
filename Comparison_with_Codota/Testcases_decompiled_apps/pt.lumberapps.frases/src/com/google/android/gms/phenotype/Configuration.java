package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Configuration extends AbstractSafeParcelable implements Comparable {
    public static final Parcelable.Creator CREATOR = new zza();

    /* renamed from: a */
    final int f7394a;
    public final int arh;
    public final Flag[] ari;
    public final String[] arj;
    public final Map ark = new TreeMap();

    Configuration(int i, int i2, Flag[] flagArr, String[] strArr) {
        this.f7394a = i;
        this.arh = i2;
        this.ari = flagArr;
        for (Flag flag : flagArr) {
            this.ark.put(flag.name, flag);
        }
        this.arj = strArr;
        if (this.arj != null) {
            Arrays.sort(this.arj);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return this.f7394a == configuration.f7394a && this.arh == configuration.arh && zzaa.equal(this.ark, configuration.ark) && Arrays.equals(this.arj, configuration.arj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Configuration(");
        sb.append(this.f7394a);
        sb.append(", ");
        sb.append(this.arh);
        sb.append(", ");
        sb.append("(");
        for (Flag append : this.ark.values()) {
            sb.append(append);
            sb.append(", ");
        }
        sb.append(")");
        sb.append(", ");
        sb.append("(");
        if (this.arj != null) {
            for (String append2 : this.arj) {
                sb.append(append2);
                sb.append(", ");
            }
        } else {
            sb.append("null");
        }
        sb.append(")");
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m8019a(this, parcel, i);
    }

    /* renamed from: zza */
    public int compareTo(Configuration configuration) {
        return this.arh - configuration.arh;
    }
}
