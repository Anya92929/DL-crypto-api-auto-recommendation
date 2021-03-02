package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class InvitationRef extends C0297d implements Invitation {
    private final ArrayList<Participant> abR;
    private final ParticipantRef abU;
    private final Game abm;

    InvitationRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.abm = new GameRef(holder, dataRow);
        this.abR = new ArrayList<>(numChildren);
        String string = getString("external_inviter_id");
        ParticipantRef participantRef = null;
        for (int i = 0; i < numChildren; i++) {
            ParticipantRef participantRef2 = new ParticipantRef(this.f693IC, this.f694JQ + i);
            if (participantRef2.getParticipantId().equals(string)) {
                participantRef = participantRef2;
            }
            this.abR.add(participantRef2);
        }
        this.abU = (ParticipantRef) C0348n.m857b(participantRef, (Object) "Must have a valid inviter!");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.m3675a(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public int getAvailableAutoMatchSlots() {
        if (!getBoolean("has_automatch_criteria")) {
            return 0;
        }
        return getInteger("automatch_max_players");
    }

    public long getCreationTimestamp() {
        return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
    }

    public Game getGame() {
        return this.abm;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public int getInvitationType() {
        return getInteger("type");
    }

    public Participant getInviter() {
        return this.abU;
    }

    public ArrayList<Participant> getParticipants() {
        return this.abR;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.m3674a(this);
    }

    public String toString() {
        return InvitationEntity.m3676b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((InvitationEntity) freeze()).writeToParcel(dest, flags);
    }
}
