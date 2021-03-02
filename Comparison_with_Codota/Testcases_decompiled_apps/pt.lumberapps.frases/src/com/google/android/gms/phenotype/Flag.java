package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class Flag extends AbstractSafeParcelable implements Comparable {
    public static final Parcelable.Creator CREATOR = new zzb();
    public static final zza arp = new zza();

    /* renamed from: g */
    private static final Charset f7395g = Charset.forName("UTF-8");

    /* renamed from: a */
    final int f7396a;
    public final int arn;
    public final int aro;

    /* renamed from: b */
    final long f7397b;

    /* renamed from: c */
    final boolean f7398c;

    /* renamed from: d */
    final double f7399d;

    /* renamed from: e */
    final String f7400e;

    /* renamed from: f */
    final byte[] f7401f;
    public final String name;

    public class zza implements Comparator {
        /* renamed from: zza */
        public int compare(Flag flag, Flag flag2) {
            return flag.aro == flag2.aro ? flag.name.compareTo(flag2.name) : flag.aro - flag2.aro;
        }
    }

    Flag(int i, String str, long j, boolean z, double d, String str2, byte[] bArr, int i2, int i3) {
        this.f7396a = i;
        this.name = str;
        this.f7397b = j;
        this.f7398c = z;
        this.f7399d = d;
        this.f7400e = str2;
        this.f7401f = bArr;
        this.arn = i2;
        this.aro = i3;
    }

    /* renamed from: a */
    private static int m8014a(byte b, byte b2) {
        return b - b2;
    }

    /* renamed from: a */
    private static int m8015a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: a */
    private static int m8016a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    /* renamed from: a */
    private static int m8017a(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    /* renamed from: a */
    private static int m8018a(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Flag)) {
            return false;
        }
        Flag flag = (Flag) obj;
        if (this.f7396a != flag.f7396a || !zzaa.equal(this.name, flag.name) || this.arn != flag.arn || this.aro != flag.aro) {
            return false;
        }
        switch (this.arn) {
            case 1:
                return this.f7397b == flag.f7397b;
            case 2:
                return this.f7398c == flag.f7398c;
            case 3:
                return this.f7399d == flag.f7399d;
            case 4:
                return zzaa.equal(this.f7400e, flag.f7400e);
            case 5:
                return Arrays.equals(this.f7401f, flag.f7401f);
            default:
                throw new AssertionError(new StringBuilder(31).append("Invalid enum value: ").append(this.arn).toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Flag(");
        sb.append(this.f7396a);
        sb.append(", ");
        sb.append(this.name);
        sb.append(", ");
        switch (this.arn) {
            case 1:
                sb.append(this.f7397b);
                break;
            case 2:
                sb.append(this.f7398c);
                break;
            case 3:
                sb.append(this.f7399d);
                break;
            case 4:
                sb.append("'");
                sb.append(this.f7400e);
                sb.append("'");
                break;
            case 5:
                if (this.f7401f != null) {
                    sb.append("'");
                    sb.append(new String(this.f7401f, f7395g));
                    sb.append("'");
                    break;
                } else {
                    sb.append("null");
                    break;
                }
            default:
                throw new AssertionError(new StringBuilder(31).append("Invalid enum value: ").append(this.arn).toString());
        }
        sb.append(", ");
        sb.append(this.arn);
        sb.append(", ");
        sb.append(this.aro);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m8020a(this, parcel, i);
    }

    /* renamed from: zza */
    public int compareTo(Flag flag) {
        int compareTo = this.name.compareTo(flag.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int a = m8015a(this.arn, flag.arn);
        if (a != 0) {
            return a;
        }
        switch (this.arn) {
            case 1:
                return m8016a(this.f7397b, flag.f7397b);
            case 2:
                return m8018a(this.f7398c, flag.f7398c);
            case 3:
                return Double.compare(this.f7399d, flag.f7399d);
            case 4:
                return m8017a(this.f7400e, flag.f7400e);
            case 5:
                if (this.f7401f == flag.f7401f) {
                    return 0;
                }
                if (this.f7401f == null) {
                    return -1;
                }
                if (flag.f7401f == null) {
                    return 1;
                }
                for (int i = 0; i < Math.min(this.f7401f.length, flag.f7401f.length); i++) {
                    int a2 = m8014a(this.f7401f[i], flag.f7401f[i]);
                    if (a2 != 0) {
                        return a2;
                    }
                }
                return m8015a(this.f7401f.length, flag.f7401f.length);
            default:
                throw new AssertionError(new StringBuilder(31).append("Invalid enum value: ").append(this.arn).toString());
        }
    }
}
