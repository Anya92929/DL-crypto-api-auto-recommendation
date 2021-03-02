package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0422dw;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.cordova.Globalization;

/* renamed from: com.google.android.gms.internal.fs */
public final class C0560fs extends C0422dw implements SafeParcelable, Moment {
    public static final C0561ft CREATOR = new C0561ft();

    /* renamed from: rH */
    private static final HashMap<String, C0422dw.C0423a<?, ?>> f1426rH = new HashMap<>();

    /* renamed from: iM */
    private final int f1427iM;

    /* renamed from: rI */
    private final Set<Integer> f1428rI;

    /* renamed from: sD */
    private String f1429sD;

    /* renamed from: sG */
    private C0558fq f1430sG;

    /* renamed from: sH */
    private C0558fq f1431sH;

    /* renamed from: sm */
    private String f1432sm;

    /* renamed from: sx */
    private String f1433sx;

    static {
        f1426rH.put(DBFavorites.KEY_EVENT_ID, C0422dw.C0423a.m998g(DBFavorites.KEY_EVENT_ID, 2));
        f1426rH.put("result", C0422dw.C0423a.m992a("result", 4, C0558fq.class));
        f1426rH.put("startDate", C0422dw.C0423a.m998g("startDate", 5));
        f1426rH.put("target", C0422dw.C0423a.m992a("target", 6, C0558fq.class));
        f1426rH.put(Globalization.TYPE, C0422dw.C0423a.m998g(Globalization.TYPE, 7));
    }

    public C0560fs() {
        this.f1427iM = 1;
        this.f1428rI = new HashSet();
    }

    C0560fs(Set<Integer> set, int i, String str, C0558fq fqVar, String str2, C0558fq fqVar2, String str3) {
        this.f1428rI = set;
        this.f1427iM = i;
        this.f1432sm = str;
        this.f1430sG = fqVar;
        this.f1433sx = str2;
        this.f1431sH = fqVar2;
        this.f1429sD = str3;
    }

    public C0560fs(Set<Integer> set, String str, C0558fq fqVar, String str2, C0558fq fqVar2, String str3) {
        this.f1428rI = set;
        this.f1427iM = 1;
        this.f1432sm = str;
        this.f1430sG = fqVar;
        this.f1433sx = str2;
        this.f1431sH = fqVar2;
        this.f1429sD = str3;
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
        return this.f1428rI.contains(Integer.valueOf(aVar.mo4447bw()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo4433b(C0422dw.C0423a aVar) {
        switch (aVar.mo4447bw()) {
            case 2:
                return this.f1432sm;
            case 4:
                return this.f1430sG;
            case 5:
                return this.f1433sx;
            case 6:
                return this.f1431sH;
            case 7:
                return this.f1429sD;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
        }
    }

    /* renamed from: bp */
    public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
        return f1426rH;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dA */
    public C0558fq mo5008dA() {
        return this.f1431sH;
    }

    /* renamed from: dB */
    public C0560fs freeze() {
        return this;
    }

    public int describeContents() {
        C0561ft ftVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: di */
    public Set<Integer> mo5011di() {
        return this.f1428rI;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dz */
    public C0558fq mo5012dz() {
        return this.f1430sG;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0560fs)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0560fs fsVar = (C0560fs) obj;
        for (C0422dw.C0423a next : f1426rH.values()) {
            if (mo4432a(next)) {
                if (!fsVar.mo4432a(next)) {
                    return false;
                }
                if (!mo4433b(next).equals(fsVar.mo4433b(next))) {
                    return false;
                }
            } else if (fsVar.mo4432a(next)) {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return this.f1432sm;
    }

    public ItemScope getResult() {
        return this.f1430sG;
    }

    public String getStartDate() {
        return this.f1433sx;
    }

    public ItemScope getTarget() {
        return this.f1431sH;
    }

    public String getType() {
        return this.f1429sD;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1427iM;
    }

    public boolean hasId() {
        return this.f1428rI.contains(2);
    }

    public boolean hasResult() {
        return this.f1428rI.contains(4);
    }

    public boolean hasStartDate() {
        return this.f1428rI.contains(5);
    }

    public boolean hasTarget() {
        return this.f1428rI.contains(6);
    }

    public boolean hasType() {
        return this.f1428rI.contains(7);
    }

    public int hashCode() {
        int i = 0;
        Iterator<C0422dw.C0423a<?, ?>> it = f1426rH.values().iterator();
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
        C0561ft ftVar = CREATOR;
        C0561ft.m1710a(this, out, flags);
    }
}
