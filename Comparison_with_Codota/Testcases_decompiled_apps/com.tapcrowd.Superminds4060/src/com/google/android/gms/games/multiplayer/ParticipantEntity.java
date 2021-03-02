package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0437eg;
import com.google.android.gms.internal.C0487en;

public final class ParticipantEntity extends C0487en implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new C0185a();

    /* renamed from: iM */
    private final int f505iM;

    /* renamed from: ml */
    private final String f506ml;

    /* renamed from: mq */
    private final Uri f507mq;

    /* renamed from: mr */
    private final Uri f508mr;

    /* renamed from: nU */
    private final int f509nU;

    /* renamed from: nV */
    private final String f510nV;

    /* renamed from: nW */
    private final boolean f511nW;

    /* renamed from: nX */
    private final PlayerEntity f512nX;

    /* renamed from: nY */
    private final int f513nY;

    /* renamed from: nd */
    private final String f514nd;

    /* renamed from: com.google.android.gms.games.multiplayer.ParticipantEntity$a */
    static final class C0185a extends C0188c {
        C0185a() {
        }

        /* renamed from: w */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            boolean z = false;
            if (ParticipantEntity.m1237c(ParticipantEntity.m836aW()) || ParticipantEntity.m837y(ParticipantEntity.class.getCanonicalName())) {
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
        this.f505iM = versionCode;
        this.f514nd = participantId;
        this.f506ml = displayName;
        this.f507mq = iconImageUri;
        this.f508mr = hiResImageUri;
        this.f509nU = status;
        this.f510nV = clientAddress;
        this.f511nW = connectedToRoom;
        this.f512nX = player;
        this.f513nY = capabilities;
    }

    public ParticipantEntity(Participant participant) {
        this.f505iM = 1;
        this.f514nd = participant.getParticipantId();
        this.f506ml = participant.getDisplayName();
        this.f507mq = participant.getIconImageUri();
        this.f508mr = participant.getHiResImageUri();
        this.f509nU = participant.getStatus();
        this.f510nV = participant.mo3892ci();
        this.f511nW = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.f512nX = player == null ? null : new PlayerEntity(player);
        this.f513nY = participant.getCapabilities();
    }

    /* renamed from: a */
    static int m427a(Participant participant) {
        return C0408dl.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.mo3892ci(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()));
    }

    /* renamed from: a */
    static boolean m428a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return C0408dl.equal(participant2.getPlayer(), participant.getPlayer()) && C0408dl.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && C0408dl.equal(participant2.mo3892ci(), participant.mo3892ci()) && C0408dl.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && C0408dl.equal(participant2.getDisplayName(), participant.getDisplayName()) && C0408dl.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && C0408dl.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && C0408dl.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities()));
    }

    /* renamed from: b */
    static String m429b(Participant participant) {
        return C0408dl.m938d(participant).mo4388a("Player", participant.getPlayer()).mo4388a("Status", Integer.valueOf(participant.getStatus())).mo4388a("ClientAddress", participant.mo3892ci()).mo4388a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).mo4388a("DisplayName", participant.getDisplayName()).mo4388a("IconImage", participant.getIconImageUri()).mo4388a("HiResImage", participant.getHiResImageUri()).mo4388a("Capabilities", Integer.valueOf(participant.getCapabilities())).toString();
    }

    /* renamed from: ci */
    public String mo3892ci() {
        return this.f510nV;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m428a(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.f513nY;
    }

    public String getDisplayName() {
        return this.f512nX == null ? this.f506ml : this.f512nX.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.f512nX == null) {
            C0437eg.m1081b(this.f506ml, dataOut);
        } else {
            this.f512nX.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.f512nX == null ? this.f508mr : this.f512nX.getHiResImageUri();
    }

    public Uri getIconImageUri() {
        return this.f512nX == null ? this.f507mq : this.f512nX.getIconImageUri();
    }

    public String getParticipantId() {
        return this.f514nd;
    }

    public Player getPlayer() {
        return this.f512nX;
    }

    public int getStatus() {
        return this.f509nU;
    }

    public int getVersionCode() {
        return this.f505iM;
    }

    public int hashCode() {
        return m427a(this);
    }

    public boolean isConnectedToRoom() {
        return this.f511nW;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m429b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (!mo4323aX()) {
            C0188c.m439a(this, dest, flags);
            return;
        }
        dest.writeString(this.f514nd);
        dest.writeString(this.f506ml);
        dest.writeString(this.f507mq == null ? null : this.f507mq.toString());
        if (this.f508mr != null) {
            str = this.f508mr.toString();
        }
        dest.writeString(str);
        dest.writeInt(this.f509nU);
        dest.writeString(this.f510nV);
        dest.writeInt(this.f511nW ? 1 : 0);
        if (this.f512nX != null) {
            i = 1;
        }
        dest.writeInt(i);
        if (this.f512nX != null) {
            this.f512nX.writeToParcel(dest, flags);
        }
    }
}
