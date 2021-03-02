package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();

    /* renamed from: BR */
    private final int f2352BR;

    /* renamed from: WD */
    private final String f2353WD;
    private final GameEntity aan;
    private final long abO;
    private final int abP;
    private final ParticipantEntity abQ;
    private final ArrayList<ParticipantEntity> abR;
    private final int abS;
    private final int abT;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        /* renamed from: cl */
        public InvitationEntity createFromParcel(Parcel parcel) {
            if (InvitationEntity.m2548c(InvitationEntity.m686gP()) || InvitationEntity.m684aV(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity createFromParcel = GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity createFromParcel2 = ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, createFromParcel, readString, readLong, readInt, createFromParcel2, arrayList, -1, 0);
        }
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant, int availableAutoMatchSlots) {
        this.f2352BR = versionCode;
        this.aan = game;
        this.f2353WD = invitationId;
        this.abO = creationTimestamp;
        this.abP = invitationType;
        this.abQ = inviter;
        this.abR = participants;
        this.abS = variant;
        this.abT = availableAutoMatchSlots;
    }

    InvitationEntity(Invitation invitation) {
        this.f2352BR = 2;
        this.aan = new GameEntity(invitation.getGame());
        this.f2353WD = invitation.getInvitationId();
        this.abO = invitation.getCreationTimestamp();
        this.abP = invitation.getInvitationType();
        this.abS = invitation.getVariant();
        this.abT = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Participant participant = null;
        ArrayList<Participant> participants = invitation.getParticipants();
        int size = participants.size();
        this.abR = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = participants.get(i);
            if (participant2.getParticipantId().equals(participantId)) {
                participant = participant2;
            }
            this.abR.add((ParticipantEntity) participant2.freeze());
        }
        C0348n.m857b(participant, (Object) "Must have a valid inviter!");
        this.abQ = (ParticipantEntity) participant.freeze();
    }

    /* renamed from: a */
    static int m3674a(Invitation invitation) {
        return C0345m.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    /* renamed from: a */
    static boolean m3675a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return C0345m.equal(invitation2.getGame(), invitation.getGame()) && C0345m.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && C0345m.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && C0345m.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && C0345m.equal(invitation2.getInviter(), invitation.getInviter()) && C0345m.equal(invitation2.getParticipants(), invitation.getParticipants()) && C0345m.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && C0345m.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    /* renamed from: b */
    static String m3676b(Invitation invitation) {
        return C0345m.m848h(invitation).mo4549a("Game", invitation.getGame()).mo4549a("InvitationId", invitation.getInvitationId()).mo4549a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).mo4549a("InvitationType", Integer.valueOf(invitation.getInvitationType())).mo4549a("Inviter", invitation.getInviter()).mo4549a("Participants", invitation.getParticipants()).mo4549a("Variant", Integer.valueOf(invitation.getVariant())).mo4549a("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3675a(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.abT;
    }

    public long getCreationTimestamp() {
        return this.abO;
    }

    public Game getGame() {
        return this.aan;
    }

    public String getInvitationId() {
        return this.f2353WD;
    }

    public int getInvitationType() {
        return this.abP;
    }

    public Participant getInviter() {
        return this.abQ;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.abR);
    }

    public int getVariant() {
        return this.abS;
    }

    public int getVersionCode() {
        return this.f2352BR;
    }

    public int hashCode() {
        return m3674a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m3676b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo4427gQ()) {
            InvitationEntityCreator.m3681a(this, dest, flags);
            return;
        }
        this.aan.writeToParcel(dest, flags);
        dest.writeString(this.f2353WD);
        dest.writeLong(this.abO);
        dest.writeInt(this.abP);
        this.abQ.writeToParcel(dest, flags);
        int size = this.abR.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.abR.get(i).writeToParcel(dest, flags);
        }
    }
}
