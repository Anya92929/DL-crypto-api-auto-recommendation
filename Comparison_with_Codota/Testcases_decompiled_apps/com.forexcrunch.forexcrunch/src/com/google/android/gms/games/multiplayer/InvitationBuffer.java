package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.C0348f;

public final class InvitationBuffer extends C0348f<Invitation> {
    public InvitationBuffer(C0344d dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getEntry */
    public Invitation mo4071a(int rowIndex, int numChildren) {
        return new C0391b(this.f792S, rowIndex, numChildren);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}
