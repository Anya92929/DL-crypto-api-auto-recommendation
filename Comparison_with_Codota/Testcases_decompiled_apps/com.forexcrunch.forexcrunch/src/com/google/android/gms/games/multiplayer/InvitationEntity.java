package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.C0473av;
import com.google.android.gms.internal.C0618r;
import com.google.android.gms.internal.C0621s;
import java.util.ArrayList;

public final class InvitationEntity extends C0473av implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new C0388a();

    /* renamed from: ab */
    private final int f922ab;

    /* renamed from: eE */
    private final GameEntity f923eE;

    /* renamed from: eF */
    private final String f924eF;

    /* renamed from: eG */
    private final long f925eG;

    /* renamed from: eH */
    private final int f926eH;

    /* renamed from: eI */
    private final ParticipantEntity f927eI;

    /* renamed from: eJ */
    private final ArrayList<ParticipantEntity> f928eJ;

    /* renamed from: eK */
    private final int f929eK;

    /* renamed from: com.google.android.gms.games.multiplayer.InvitationEntity$a */
    static final class C0388a extends C0390a {
        C0388a() {
        }

        /* renamed from: p */
        public InvitationEntity createFromParcel(Parcel parcel) {
            if (InvitationEntity.m1060c(InvitationEntity.m1785v()) || InvitationEntity.m1783h(InvitationEntity.class.getCanonicalName())) {
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
        this.f922ab = versionCode;
        this.f923eE = game;
        this.f924eF = invitationId;
        this.f925eG = creationTimestamp;
        this.f926eH = invitationType;
        this.f927eI = inviter;
        this.f928eJ = participants;
        this.f929eK = variant;
    }

    InvitationEntity(Invitation invitation) {
        this.f922ab = 1;
        this.f923eE = new GameEntity(invitation.getGame());
        this.f924eF = invitation.getInvitationId();
        this.f925eG = invitation.getCreationTimestamp();
        this.f926eH = invitation.mo4323aL();
        this.f929eK = invitation.getVariant();
        String participantId = invitation.getInviter().getParticipantId();
        Participant participant = null;
        ArrayList<Participant> participants = invitation.getParticipants();
        int size = participants.size();
        this.f928eJ = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = participants.get(i);
            if (participant2.getParticipantId().equals(participantId)) {
                participant = participant2;
            }
            this.f928eJ.add((ParticipantEntity) participant2.freeze());
        }
        C0621s.m1887b(participant, (Object) "Must have a valid inviter!");
        this.f927eI = (ParticipantEntity) participant.freeze();
    }

    /* renamed from: a */
    static int m742a(Invitation invitation) {
        return C0618r.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.mo4323aL()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()));
    }

    /* renamed from: a */
    static boolean m743a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return C0618r.m1881a(invitation2.getGame(), invitation.getGame()) && C0618r.m1881a(invitation2.getInvitationId(), invitation.getInvitationId()) && C0618r.m1881a(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && C0618r.m1881a(Integer.valueOf(invitation2.mo4323aL()), Integer.valueOf(invitation.mo4323aL())) && C0618r.m1881a(invitation2.getInviter(), invitation.getInviter()) && C0618r.m1881a(invitation2.getParticipants(), invitation.getParticipants()) && C0618r.m1881a(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant()));
    }

    /* renamed from: b */
    static String m745b(Invitation invitation) {
        return C0618r.m1882c(invitation).mo5486a("Game", invitation.getGame()).mo5486a("InvitationId", invitation.getInvitationId()).mo5486a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).mo5486a("InvitationType", Integer.valueOf(invitation.mo4323aL())).mo5486a("Inviter", invitation.getInviter()).mo5486a("Participants", invitation.getParticipants()).mo5486a("Variant", Integer.valueOf(invitation.getVariant())).toString();
    }

    /* renamed from: aL */
    public int mo4323aL() {
        return this.f926eH;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m743a(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.f925eG;
    }

    public Game getGame() {
        return this.f923eE;
    }

    public String getInvitationId() {
        return this.f924eF;
    }

    public Participant getInviter() {
        return this.f927eI;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.f928eJ);
    }

    public int getVariant() {
        return this.f929eK;
    }

    public int hashCode() {
        return m742a(this);
    }

    /* renamed from: i */
    public int mo4334i() {
        return this.f922ab;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m745b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo5427w()) {
            C0390a.m764a(this, dest, flags);
            return;
        }
        this.f923eE.writeToParcel(dest, flags);
        dest.writeString(this.f924eF);
        dest.writeLong(this.f925eG);
        dest.writeInt(this.f926eH);
        this.f927eI.writeToParcel(dest, flags);
        int size = this.f928eJ.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.f928eJ.get(i).writeToParcel(dest, flags);
        }
    }
}
