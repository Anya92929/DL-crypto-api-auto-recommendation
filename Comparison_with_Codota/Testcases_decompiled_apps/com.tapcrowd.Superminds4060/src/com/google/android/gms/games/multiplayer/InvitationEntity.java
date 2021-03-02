package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.internal.C0487en;
import java.util.ArrayList;

public final class InvitationEntity extends C0487en implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new C0184a();

    /* renamed from: iM */
    private final int f497iM;

    /* renamed from: nL */
    private final GameEntity f498nL;

    /* renamed from: nM */
    private final String f499nM;

    /* renamed from: nN */
    private final long f500nN;

    /* renamed from: nO */
    private final int f501nO;

    /* renamed from: nP */
    private final ParticipantEntity f502nP;

    /* renamed from: nQ */
    private final ArrayList<ParticipantEntity> f503nQ;

    /* renamed from: nR */
    private final int f504nR;

    /* renamed from: com.google.android.gms.games.multiplayer.InvitationEntity$a */
    static final class C0184a extends C0186a {
        C0184a() {
        }

        /* renamed from: v */
        public InvitationEntity createFromParcel(Parcel parcel) {
            if (InvitationEntity.m1237c(InvitationEntity.m836aW()) || InvitationEntity.m837y(InvitationEntity.class.getCanonicalName())) {
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
            return new InvitationEntity(1, createFromParcel, readString, readLong, readInt, createFromParcel2, arrayList, -1);
        }
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant) {
        this.f497iM = versionCode;
        this.f498nL = game;
        this.f499nM = invitationId;
        this.f500nN = creationTimestamp;
        this.f501nO = invitationType;
        this.f502nP = inviter;
        this.f503nQ = participants;
        this.f504nR = variant;
    }

    InvitationEntity(Invitation invitation) {
        this.f497iM = 1;
        this.f498nL = new GameEntity(invitation.getGame());
        this.f499nM = invitation.getInvitationId();
        this.f500nN = invitation.getCreationTimestamp();
        this.f501nO = invitation.mo3874ch();
        this.f504nR = invitation.getVariant();
        String participantId = invitation.getInviter().getParticipantId();
        Participant participant = null;
        ArrayList<Participant> participants = invitation.getParticipants();
        int size = participants.size();
        this.f503nQ = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = participants.get(i);
            if (participant2.getParticipantId().equals(participantId)) {
                participant = participant2;
            }
            this.f503nQ.add((ParticipantEntity) participant2.freeze());
        }
        C0411dm.m940a(participant, (Object) "Must have a valid inviter!");
        this.f502nP = (ParticipantEntity) participant.freeze();
    }

    /* renamed from: a */
    static int m418a(Invitation invitation) {
        return C0408dl.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.mo3874ch()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()));
    }

    /* renamed from: a */
    static boolean m419a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return C0408dl.equal(invitation2.getGame(), invitation.getGame()) && C0408dl.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && C0408dl.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && C0408dl.equal(Integer.valueOf(invitation2.mo3874ch()), Integer.valueOf(invitation.mo3874ch())) && C0408dl.equal(invitation2.getInviter(), invitation.getInviter()) && C0408dl.equal(invitation2.getParticipants(), invitation.getParticipants()) && C0408dl.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant()));
    }

    /* renamed from: b */
    static String m420b(Invitation invitation) {
        return C0408dl.m938d(invitation).mo4388a("Game", invitation.getGame()).mo4388a("InvitationId", invitation.getInvitationId()).mo4388a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).mo4388a("InvitationType", Integer.valueOf(invitation.mo3874ch())).mo4388a("Inviter", invitation.getInviter()).mo4388a("Participants", invitation.getParticipants()).mo4388a("Variant", Integer.valueOf(invitation.getVariant())).toString();
    }

    /* renamed from: ch */
    public int mo3874ch() {
        return this.f501nO;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m419a(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.f500nN;
    }

    public Game getGame() {
        return this.f498nL;
    }

    public String getInvitationId() {
        return this.f499nM;
    }

    public Participant getInviter() {
        return this.f502nP;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.f503nQ);
    }

    public int getVariant() {
        return this.f504nR;
    }

    public int getVersionCode() {
        return this.f497iM;
    }

    public int hashCode() {
        return m418a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m420b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo4323aX()) {
            C0186a.m435a(this, dest, flags);
            return;
        }
        this.f498nL.writeToParcel(dest, flags);
        dest.writeString(this.f499nM);
        dest.writeLong(this.f500nN);
        dest.writeInt(this.f501nO);
        this.f502nP.writeToParcel(dest, flags);
        int size = this.f503nQ.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.f503nQ.get(i).writeToParcel(dest, flags);
        }
    }
}
