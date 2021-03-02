package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0628q;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SessionReadResult> CREATOR = new C0696f();

    /* renamed from: BR */
    private final int f1575BR;

    /* renamed from: CM */
    private final Status f1576CM;

    /* renamed from: UO */
    private final List<C0628q> f1577UO;

    /* renamed from: Ua */
    private final List<Session> f1578Ua;

    SessionReadResult(int versionCode, List<Session> sessions, List<C0628q> sessionDataSets, Status status) {
        this.f1575BR = versionCode;
        this.f1578Ua = sessions;
        this.f1577UO = Collections.unmodifiableList(sessionDataSets);
        this.f1576CM = status;
    }

    public SessionReadResult(List<Session> sessions, List<C0628q> sessionDataSets, Status status) {
        this.f1575BR = 3;
        this.f1578Ua = sessions;
        this.f1577UO = Collections.unmodifiableList(sessionDataSets);
        this.f1576CM = status;
    }

    /* renamed from: H */
    public static SessionReadResult m2099H(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    /* renamed from: b */
    private boolean m2100b(SessionReadResult sessionReadResult) {
        return this.f1576CM.equals(sessionReadResult.f1576CM) && C0345m.equal(this.f1578Ua, sessionReadResult.f1578Ua) && C0345m.equal(this.f1577UO, sessionReadResult.f1577UO);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionReadResult) && m2100b((SessionReadResult) that));
    }

    public List<DataSet> getDataSet(Session session) {
        C0348n.m860b(this.f1578Ua.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (C0628q next : this.f1577UO) {
            if (C0345m.equal(session, next.getSession())) {
                arrayList.add(next.mo5847iP());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        C0348n.m860b(this.f1578Ua.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (C0628q next : this.f1577UO) {
            if (C0345m.equal(session, next.getSession()) && dataType.equals(next.mo5847iP().getDataType())) {
                arrayList.add(next.mo5847iP());
            }
        }
        return arrayList;
    }

    public List<Session> getSessions() {
        return this.f1578Ua;
    }

    public Status getStatus() {
        return this.f1576CM;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1575BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1576CM, this.f1578Ua, this.f1577UO);
    }

    /* renamed from: jJ */
    public List<C0628q> mo6263jJ() {
        return this.f1577UO;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("status", this.f1576CM).mo4549a("sessions", this.f1578Ua).mo4549a("sessionDataSets", this.f1577UO).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0696f.m2119a(this, dest, flags);
    }
}
