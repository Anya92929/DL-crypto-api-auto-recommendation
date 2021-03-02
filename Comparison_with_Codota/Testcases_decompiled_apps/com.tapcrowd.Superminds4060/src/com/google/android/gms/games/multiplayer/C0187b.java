package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.games.C0176b;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.C0411dm;
import java.util.ArrayList;
import org.apache.cordova.Globalization;

/* renamed from: com.google.android.gms.games.multiplayer.b */
public final class C0187b extends C0138b implements Invitation {

    /* renamed from: nQ */
    private final ArrayList<Participant> f515nQ;

    /* renamed from: nS */
    private final Game f516nS;

    /* renamed from: nT */
    private final C0189d f517nT;

    C0187b(C0140d dVar, int i, int i2) {
        super(dVar, i);
        this.f516nS = new C0176b(dVar, i);
        this.f515nQ = new ArrayList<>(i2);
        String string = getString("external_inviter_id");
        C0189d dVar2 = null;
        for (int i3 = 0; i3 < i2; i3++) {
            C0189d dVar3 = new C0189d(this.f369jf, this.f370ji + i3);
            if (dVar3.getParticipantId().equals(string)) {
                dVar2 = dVar3;
            }
            this.f515nQ.add(dVar3);
        }
        this.f517nT = (C0189d) C0411dm.m940a(dVar2, (Object) "Must have a valid inviter!");
    }

    /* renamed from: ch */
    public int mo3874ch() {
        return getInteger(Globalization.TYPE);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.m419a(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public Game getGame() {
        return this.f516nS;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public Participant getInviter() {
        return this.f517nT;
    }

    public ArrayList<Participant> getParticipants() {
        return this.f515nQ;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.m418a(this);
    }

    public String toString() {
        return InvitationEntity.m420b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((InvitationEntity) freeze()).writeToParcel(dest, flags);
    }
}
