package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.measurement.internal.ad */
class C1886ad {

    /* renamed from: a */
    final int f7073a;

    /* renamed from: b */
    final boolean f7074b;

    /* renamed from: c */
    final String f7075c;

    /* renamed from: d */
    final List f7076d;

    /* renamed from: e */
    final String f7077e;

    /* renamed from: f */
    final boolean f7078f;

    public C1886ad(zzuf.zzf zzf) {
        boolean z;
        boolean z2 = false;
        zzab.zzy(zzf);
        if (zzf.amV == null || zzf.amV.intValue() == 0) {
            z = false;
        } else {
            if (zzf.amV.intValue() == 6) {
                if (zzf.amY == null || zzf.amY.length == 0) {
                    z = false;
                }
            } else if (zzf.amW == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f7073a = zzf.amV.intValue();
            if (zzf.amX != null && zzf.amX.booleanValue()) {
                z2 = true;
            }
            this.f7074b = z2;
            if (this.f7074b || this.f7073a == 1 || this.f7073a == 6) {
                this.f7075c = zzf.amW;
            } else {
                this.f7075c = zzf.amW.toUpperCase(Locale.ENGLISH);
            }
            this.f7076d = zzf.amY == null ? null : m7617a(zzf.amY, this.f7074b);
            if (this.f7073a == 1) {
                this.f7077e = this.f7075c;
            } else {
                this.f7077e = null;
            }
        } else {
            this.f7073a = 0;
            this.f7074b = false;
            this.f7075c = null;
            this.f7076d = null;
            this.f7077e = null;
        }
        this.f7078f = z;
    }

    /* renamed from: a */
    private List m7617a(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        ArrayList arrayList = new ArrayList();
        for (String upperCase : strArr) {
            arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    /* renamed from: a */
    public Boolean mo9218a(String str) {
        if (!this.f7078f || str == null) {
            return null;
        }
        if (!this.f7074b && this.f7073a != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.f7073a) {
            case 1:
                return Boolean.valueOf(Pattern.compile(this.f7077e, this.f7074b ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(this.f7075c));
            case 3:
                return Boolean.valueOf(str.endsWith(this.f7075c));
            case 4:
                return Boolean.valueOf(str.contains(this.f7075c));
            case 5:
                return Boolean.valueOf(str.equals(this.f7075c));
            case 6:
                return Boolean.valueOf(this.f7076d.contains(str));
            default:
                return null;
        }
    }
}
