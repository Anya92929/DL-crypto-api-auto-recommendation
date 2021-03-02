package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.common.data.C0144f;

public final class InvitationBuffer extends C0144f<Invitation> {
    public InvitationBuffer(C0140d dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getEntry */
    public Invitation mo3620a(int rowIndex, int numChildren) {
        return new C0187b(this.f366jf, rowIndex, numChildren);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}
