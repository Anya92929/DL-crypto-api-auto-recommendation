package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.forexcrunch.forexcrunch.gui.ChartActivity;
import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.games.C0380b;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.C0621s;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.b */
public final class C0391b extends C0342b implements Invitation {

    /* renamed from: eJ */
    private final ArrayList<Participant> f940eJ;

    /* renamed from: eL */
    private final Game f941eL;

    /* renamed from: eM */
    private final C0393d f942eM;

    C0391b(C0344d dVar, int i, int i2) {
        super(dVar, i);
        this.f941eL = new C0380b(dVar, i);
        this.f940eJ = new ArrayList<>(i2);
        String string = getString("external_inviter_id");
        C0393d dVar2 = null;
        for (int i3 = 0; i3 < i2; i3++) {
            C0393d dVar3 = new C0393d(this.f795S, this.f796V + i3);
            if (dVar3.getParticipantId().equals(string)) {
                dVar2 = dVar3;
            }
            this.f940eJ.add(dVar3);
        }
        this.f942eM = (C0393d) C0621s.m1887b(dVar2, (Object) "Must have a valid inviter!");
    }

    /* renamed from: aL */
    public int mo4323aL() {
        return getInteger(ChartActivity.TYPE);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.m743a(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public Game getGame() {
        return this.f941eL;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public Participant getInviter() {
        return this.f942eM;
    }

    public ArrayList<Participant> getParticipants() {
        return this.f940eJ;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.m742a(this);
    }

    public String toString() {
        return InvitationEntity.m745b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((InvitationEntity) freeze()).writeToParcel(dest, flags);
    }
}
