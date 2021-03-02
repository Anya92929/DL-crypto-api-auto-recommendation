package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SessionStopResult> CREATOR = new C0697g();

    /* renamed from: BR */
    private final int f1579BR;

    /* renamed from: CM */
    private final Status f1580CM;

    /* renamed from: Ua */
    private final List<Session> f1581Ua;

    SessionStopResult(int versionCode, Status status, List<Session> sessions) {
        this.f1579BR = versionCode;
        this.f1580CM = status;
        this.f1581Ua = Collections.unmodifiableList(sessions);
    }

    public SessionStopResult(Status status, List<Session> sessions) {
        this.f1579BR = 3;
        this.f1580CM = status;
        this.f1581Ua = Collections.unmodifiableList(sessions);
    }

    /* renamed from: I */
    public static SessionStopResult m2102I(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    /* renamed from: b */
    private boolean m2103b(SessionStopResult sessionStopResult) {
        return this.f1580CM.equals(sessionStopResult.f1580CM) && C0345m.equal(this.f1581Ua, sessionStopResult.f1581Ua);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionStopResult) && m2103b((SessionStopResult) o));
    }

    public List<Session> getSessions() {
        return this.f1581Ua;
    }

    public Status getStatus() {
        return this.f1580CM;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1579BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1580CM, this.f1581Ua);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("status", this.f1580CM).mo4549a("sessions", this.f1581Ua).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0697g.m2122a(this, dest, flags);
    }
}
