package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.C0394ah;
import com.google.android.gms.drive.internal.C0478v;
import com.google.android.gms.internal.C1717pl;
import com.google.android.gms.internal.C1718pm;

public class DriveId implements SafeParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new C0364c();

    /* renamed from: BR */
    final int f814BR;

    /* renamed from: Na */
    final String f815Na;

    /* renamed from: Nb */
    final long f816Nb;

    /* renamed from: Nc */
    final long f817Nc;

    /* renamed from: Nd */
    private volatile String f818Nd;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId) {
        boolean z = false;
        this.f818Nd = null;
        this.f814BR = versionCode;
        this.f815Na = resourceId;
        C0348n.m851K(!"".equals(resourceId));
        C0348n.m851K((resourceId == null && sqlId == -1) ? z : true);
        this.f816Nb = sqlId;
        this.f817Nc = databaseInstanceId;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId) {
        this(1, resourceId, sqlId, databaseInstanceId);
    }

    /* renamed from: bg */
    public static DriveId m957bg(String str) {
        C0348n.m861i(str);
        return new DriveId(str, -1, -1);
    }

    public static DriveId decodeFromString(String s) {
        C0348n.m859b(s.startsWith("DriveId:"), (Object) "Invalid DriveId: " + s);
        return m958f(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    /* renamed from: f */
    static DriveId m958f(byte[] bArr) {
        try {
            C0394ah g = C0394ah.m1134g(bArr);
            return new DriveId(g.versionCode, "".equals(g.f984Pd) ? null : g.f984Pd, g.f985Pe, g.f986Pf);
        } catch (C1717pl e) {
            throw new IllegalArgumentException();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.f818Nd == null) {
            this.f818Nd = "DriveId:" + Base64.encodeToString(mo4620hN(), 10);
        }
        return this.f818Nd;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.f817Nc != this.f817Nc) {
            C0478v.m1343p("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        } else if (driveId.f816Nb == -1 && this.f816Nb == -1) {
            return driveId.f815Na.equals(this.f815Na);
        } else {
            return driveId.f816Nb == this.f816Nb;
        }
    }

    public String getResourceId() {
        return this.f815Na;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: hN */
    public final byte[] mo4620hN() {
        C0394ah ahVar = new C0394ah();
        ahVar.versionCode = this.f814BR;
        ahVar.f984Pd = this.f815Na == null ? "" : this.f815Na;
        ahVar.f985Pe = this.f816Nb;
        ahVar.f986Pf = this.f817Nc;
        return C1718pm.m6092f(ahVar);
    }

    public int hashCode() {
        return this.f816Nb == -1 ? this.f815Na.hashCode() : (String.valueOf(this.f817Nc) + String.valueOf(this.f816Nb)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0364c.m975a(this, out, flags);
    }
}
