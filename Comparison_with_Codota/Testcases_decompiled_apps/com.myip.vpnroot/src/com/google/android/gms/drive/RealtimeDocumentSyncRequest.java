package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Parcelable.Creator<RealtimeDocumentSyncRequest> CREATOR = new C0374f();

    /* renamed from: BR */
    final int f839BR;

    /* renamed from: Nr */
    final List<String> f840Nr;

    /* renamed from: Ns */
    final List<String> f841Ns;

    RealtimeDocumentSyncRequest(int versionCode, List<String> documentsToSync, List<String> documentsToDeleteCache) {
        this.f839BR = versionCode;
        this.f840Nr = (List) C0348n.m861i(documentsToSync);
        this.f841Ns = (List) C0348n.m861i(documentsToDeleteCache);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0374f.m1002a(this, dest, flags);
    }
}
