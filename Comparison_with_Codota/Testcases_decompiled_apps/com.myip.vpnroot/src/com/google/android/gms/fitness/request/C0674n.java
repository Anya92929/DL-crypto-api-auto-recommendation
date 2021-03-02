package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0618k;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.n */
public class C0674n implements SafeParcelable {
    public static final Parcelable.Creator<C0674n> CREATOR = new C0675o();

    /* renamed from: BR */
    private final int f1533BR;

    /* renamed from: SF */
    private final DataType f1534SF;

    /* renamed from: Sh */
    private final DataSource f1535Sh;

    /* renamed from: Ti */
    private final long f1536Ti;

    /* renamed from: Tj */
    private final int f1537Tj;

    /* renamed from: Up */
    private C0618k f1538Up;

    /* renamed from: Uq */
    int f1539Uq;

    /* renamed from: Ur */
    int f1540Ur;

    /* renamed from: Us */
    private final long f1541Us;

    /* renamed from: Ut */
    private final long f1542Ut;

    /* renamed from: Uu */
    private final List<LocationRequest> f1543Uu;

    /* renamed from: Uv */
    private final long f1544Uv;

    /* renamed from: Uw */
    private final List f1545Uw;
    private final PendingIntent mPendingIntent;

    C0674n(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4) {
        this.f1533BR = i;
        this.f1535Sh = dataSource;
        this.f1534SF = dataType;
        this.f1538Up = iBinder == null ? null : C0618k.C0619a.m1858an(iBinder);
        this.f1536Ti = j == 0 ? (long) i2 : j;
        this.f1542Ut = j3;
        this.f1541Us = j2 == 0 ? (long) i3 : j2;
        this.f1543Uu = list;
        this.mPendingIntent = pendingIntent;
        this.f1537Tj = i4;
        this.f1545Uw = Collections.emptyList();
        this.f1544Uv = j4;
    }

    private C0674n(DataSource dataSource, DataType dataType, C0618k kVar, PendingIntent pendingIntent, long j, long j2, long j3, int i, List list, List list2, long j4) {
        this.f1533BR = 4;
        this.f1535Sh = dataSource;
        this.f1534SF = dataType;
        this.f1538Up = kVar;
        this.mPendingIntent = pendingIntent;
        this.f1536Ti = j;
        this.f1542Ut = j2;
        this.f1541Us = j3;
        this.f1537Tj = i;
        this.f1543Uu = list;
        this.f1545Uw = list2;
        this.f1544Uv = j4;
    }

    public C0674n(SensorRequest sensorRequest, C0618k kVar, PendingIntent pendingIntent) {
        this(sensorRequest.getDataSource(), sensorRequest.getDataType(), kVar, pendingIntent, sensorRequest.getSamplingRateMicros(), sensorRequest.mo5954jm(), sensorRequest.mo5955jn(), sensorRequest.mo5953iQ(), (List) null, Collections.emptyList(), sensorRequest.mo5956jr());
    }

    /* renamed from: a */
    private boolean m2036a(C0674n nVar) {
        return C0345m.equal(this.f1535Sh, nVar.f1535Sh) && C0345m.equal(this.f1534SF, nVar.f1534SF) && this.f1536Ti == nVar.f1536Ti && this.f1542Ut == nVar.f1542Ut && this.f1541Us == nVar.f1541Us && this.f1537Tj == nVar.f1537Tj && C0345m.equal(this.f1543Uu, nVar.f1543Uu);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof C0674n) && m2036a((C0674n) that));
    }

    public DataSource getDataSource() {
        return this.f1535Sh;
    }

    public DataType getDataType() {
        return this.f1534SF;
    }

    public long getSamplingRateMicros() {
        return this.f1536Ti;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1533BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1535Sh, this.f1534SF, this.f1538Up, Long.valueOf(this.f1536Ti), Long.valueOf(this.f1542Ut), Long.valueOf(this.f1541Us), Integer.valueOf(this.f1537Tj), this.f1543Uu);
    }

    /* renamed from: iQ */
    public int mo6132iQ() {
        return this.f1537Tj;
    }

    /* renamed from: jl */
    public PendingIntent mo6133jl() {
        return this.mPendingIntent;
    }

    /* renamed from: jm */
    public long mo6134jm() {
        return this.f1542Ut;
    }

    /* renamed from: jn */
    public long mo6135jn() {
        return this.f1541Us;
    }

    /* renamed from: jo */
    public List<LocationRequest> mo6136jo() {
        return this.f1543Uu;
    }

    /* renamed from: jp */
    public long mo6137jp() {
        return this.f1544Uv;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: jq */
    public IBinder mo6138jq() {
        if (this.f1538Up == null) {
            return null;
        }
        return this.f1538Up.asBinder();
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.f1534SF, this.f1535Sh, Long.valueOf(this.f1536Ti), Long.valueOf(this.f1542Ut), Long.valueOf(this.f1541Us)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0675o.m2044a(this, parcel, flags);
    }
}
