package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;

public final class InvitationBuffer extends C0300g<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "external_invitation_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Invitation mo4356f(int i, int i2) {
        return new InvitationRef(this.f667IC, i, i2);
    }
}
