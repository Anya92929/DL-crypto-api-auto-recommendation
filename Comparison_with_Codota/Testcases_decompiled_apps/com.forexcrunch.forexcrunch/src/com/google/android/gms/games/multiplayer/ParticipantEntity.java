package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C0423ao;
import com.google.android.gms.internal.C0473av;
import com.google.android.gms.internal.C0618r;

public final class ParticipantEntity extends C0473av implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new C0389a();

    /* renamed from: ab */
    private final int f930ab;

    /* renamed from: cl */
    private final String f931cl;

    /* renamed from: dX */
    private final String f932dX;

    /* renamed from: dk */
    private final Uri f933dk;

    /* renamed from: dl */
    private final Uri f934dl;

    /* renamed from: eN */
    private final int f935eN;

    /* renamed from: eO */
    private final String f936eO;

    /* renamed from: eP */
    private final boolean f937eP;

    /* renamed from: eQ */
    private final PlayerEntity f938eQ;

    /* renamed from: eR */
    private final int f939eR;

    /* renamed from: com.google.android.gms.games.multiplayer.ParticipantEntity$a */
    static final class C0389a extends C0392c {
        C0389a() {
        }

        /* renamed from: q */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            boolean z = false;
            if (ParticipantEntity.m1060c(ParticipantEntity.m1785v()) || ParticipantEntity.m1783h(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z2 = parcel.readInt() > 0;
            if (parcel.readInt() > 0) {
                z = true;
            }
            return new ParticipantEntity(1, readString, readString2, parse, parse2, readInt, readString5, z2, z ? PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7);
        }
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities) {
        this.f930ab = versionCode;
        this.f932dX = participantId;
        this.f931cl = displayName;
        this.f933dk = iconImageUri;
        this.f934dl = hiResImageUri;
        this.f935eN = status;
        this.f936eO = clientAddress;
        this.f937eP = connectedToRoom;
        this.f938eQ = player;
        this.f939eR = capabilities;
    }

    public ParticipantEntity(Participant participant) {
        this.f930ab = 1;
        this.f932dX = participant.getParticipantId();
        this.f931cl = participant.getDisplayName();
        this.f933dk = participant.getIconImageUri();
        this.f934dl = participant.getHiResImageUri();
        this.f935eN = participant.getStatus();
        this.f936eO = participant.mo4341aM();
        this.f937eP = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.f938eQ = player == null ? null : new PlayerEntity(player);
        this.f939eR = participant.mo4342aN();
    }

    /* renamed from: a */
    static int m753a(Participant participant) {
        return C0618r.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.mo4341aM(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.mo4342aN()));
    }

    /* renamed from: a */
    static boolean m754a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return C0618r.m1881a(participant2.getPlayer(), participant.getPlayer()) && C0618r.m1881a(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && C0618r.m1881a(participant2.mo4341aM(), participant.mo4341aM()) && C0618r.m1881a(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && C0618r.m1881a(participant2.getDisplayName(), participant.getDisplayName()) && C0618r.m1881a(participant2.getIconImageUri(), participant.getIconImageUri()) && C0618r.m1881a(participant2.getHiResImageUri(), participant.getHiResImageUri()) && C0618r.m1881a(Integer.valueOf(participant2.mo4342aN()), Integer.valueOf(participant.mo4342aN()));
    }

    /* renamed from: b */
    static String m756b(Participant participant) {
        return C0618r.m1882c(participant).mo5486a("Player", participant.getPlayer()).mo5486a("Status", Integer.valueOf(participant.getStatus())).mo5486a("ClientAddress", participant.mo4341aM()).mo5486a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).mo5486a("DisplayName", participant.getDisplayName()).mo5486a("IconImage", participant.getIconImageUri()).mo5486a("HiResImage", participant.getHiResImageUri()).mo5486a("Capabilities", Integer.valueOf(participant.mo4342aN())).toString();
    }

    /* renamed from: aM */
    public String mo4341aM() {
        return this.f936eO;
    }

    /* renamed from: aN */
    public int mo4342aN() {
        return this.f939eR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m754a(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.f938eQ == null ? this.f931cl : this.f938eQ.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.f938eQ == null) {
            C0423ao.m905b(this.f931cl, dataOut);
        } else {
            this.f938eQ.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.f938eQ == null ? this.f934dl : this.f938eQ.getHiResImageUri();
    }

    public Uri getIconImageUri() {
        return this.f938eQ == null ? this.f933dk : this.f938eQ.getIconImageUri();
    }

    public String getParticipantId() {
        return this.f932dX;
    }

    public Player getPlayer() {
        return this.f938eQ;
    }

    public int getStatus() {
        return this.f935eN;
    }

    public int hashCode() {
        return m753a(this);
    }

    /* renamed from: i */
    public int mo4354i() {
        return this.f930ab;
    }

    public boolean isConnectedToRoom() {
        return this.f937eP;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m756b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (!mo5427w()) {
            C0392c.m768a(this, dest, flags);
            return;
        }
        dest.writeString(this.f932dX);
        dest.writeString(this.f931cl);
        dest.writeString(this.f933dk == null ? null : this.f933dk.toString());
        if (this.f934dl != null) {
            str = this.f934dl.toString();
        }
        dest.writeString(str);
        dest.writeInt(this.f935eN);
        dest.writeString(this.f936eO);
        dest.writeInt(this.f937eP ? 1 : 0);
        if (this.f938eQ != null) {
            i = 1;
        }
        dest.writeInt(i);
        if (this.f938eQ != null) {
            this.f938eQ.writeToParcel(dest, flags);
        }
    }
}
