package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.C1386jv;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();

    /* renamed from: BR */
    private final int f2354BR;

    /* renamed from: EZ */
    private final int f2355EZ;

    /* renamed from: Fa */
    private final int f2356Fa;

    /* renamed from: Nz */
    private final String f2357Nz;

    /* renamed from: UW */
    private final Uri f2358UW;

    /* renamed from: UX */
    private final Uri f2359UX;

    /* renamed from: VW */
    private final PlayerEntity f2360VW;

    /* renamed from: Vh */
    private final String f2361Vh;

    /* renamed from: Vi */
    private final String f2362Vi;

    /* renamed from: Wf */
    private final String f2363Wf;

    /* renamed from: Xg */
    private final String f2364Xg;
    private final boolean abV;
    private final ParticipantResult abW;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        /* renamed from: cm */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            boolean z = true;
            if (ParticipantEntity.m2548c(ParticipantEntity.m686gP()) || ParticipantEntity.m684aV(ParticipantEntity.class.getCanonicalName())) {
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
            if (parcel.readInt() <= 0) {
                z = false;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z2, z ? PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, (ParticipantResult) null, (String) null, (String) null);
        }
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.f2354BR = versionCode;
        this.f2364Xg = participantId;
        this.f2357Nz = displayName;
        this.f2358UW = iconImageUri;
        this.f2359UX = hiResImageUri;
        this.f2356Fa = status;
        this.f2363Wf = clientAddress;
        this.abV = connectedToRoom;
        this.f2360VW = player;
        this.f2355EZ = capabilities;
        this.abW = result;
        this.f2361Vh = iconImageUrl;
        this.f2362Vi = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.f2354BR = 3;
        this.f2364Xg = participant.getParticipantId();
        this.f2357Nz = participant.getDisplayName();
        this.f2358UW = participant.getIconImageUri();
        this.f2359UX = participant.getHiResImageUri();
        this.f2356Fa = participant.getStatus();
        this.f2363Wf = participant.mo7546jU();
        this.abV = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.f2360VW = player == null ? null : new PlayerEntity(player);
        this.f2355EZ = participant.getCapabilities();
        this.abW = participant.getResult();
        this.f2361Vh = participant.getIconImageUrl();
        this.f2362Vi = participant.getHiResImageUrl();
    }

    /* renamed from: a */
    static int m3685a(Participant participant) {
        return C0345m.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.mo7546jU(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    /* renamed from: a */
    static boolean m3686a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return C0345m.equal(participant2.getPlayer(), participant.getPlayer()) && C0345m.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && C0345m.equal(participant2.mo7546jU(), participant.mo7546jU()) && C0345m.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && C0345m.equal(participant2.getDisplayName(), participant.getDisplayName()) && C0345m.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && C0345m.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && C0345m.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && C0345m.equal(participant2.getResult(), participant.getResult()) && C0345m.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    /* renamed from: b */
    static String m3687b(Participant participant) {
        return C0345m.m848h(participant).mo4549a("ParticipantId", participant.getParticipantId()).mo4549a("Player", participant.getPlayer()).mo4549a("Status", Integer.valueOf(participant.getStatus())).mo4549a("ClientAddress", participant.mo7546jU()).mo4549a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).mo4549a("DisplayName", participant.getDisplayName()).mo4549a("IconImage", participant.getIconImageUri()).mo4549a("IconImageUrl", participant.getIconImageUrl()).mo4549a("HiResImage", participant.getHiResImageUri()).mo4549a("HiResImageUrl", participant.getHiResImageUrl()).mo4549a("Capabilities", Integer.valueOf(participant.getCapabilities())).mo4549a("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3686a(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.f2355EZ;
    }

    public String getDisplayName() {
        return this.f2360VW == null ? this.f2357Nz : this.f2360VW.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.f2360VW == null) {
            C1386jv.m5216b(this.f2357Nz, dataOut);
        } else {
            this.f2360VW.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.f2360VW == null ? this.f2359UX : this.f2360VW.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.f2360VW == null ? this.f2362Vi : this.f2360VW.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.f2360VW == null ? this.f2358UW : this.f2360VW.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.f2360VW == null ? this.f2361Vh : this.f2360VW.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.f2364Xg;
    }

    public Player getPlayer() {
        return this.f2360VW;
    }

    public ParticipantResult getResult() {
        return this.abW;
    }

    public int getStatus() {
        return this.f2356Fa;
    }

    public int getVersionCode() {
        return this.f2354BR;
    }

    public int hashCode() {
        return m3685a(this);
    }

    public boolean isConnectedToRoom() {
        return this.abV;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: jU */
    public String mo7546jU() {
        return this.f2363Wf;
    }

    public String toString() {
        return m3687b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (!mo4427gQ()) {
            ParticipantEntityCreator.m3693a(this, dest, flags);
            return;
        }
        dest.writeString(this.f2364Xg);
        dest.writeString(this.f2357Nz);
        dest.writeString(this.f2358UW == null ? null : this.f2358UW.toString());
        if (this.f2359UX != null) {
            str = this.f2359UX.toString();
        }
        dest.writeString(str);
        dest.writeInt(this.f2356Fa);
        dest.writeString(this.f2363Wf);
        dest.writeInt(this.abV ? 1 : 0);
        if (this.f2360VW != null) {
            i = 1;
        }
        dest.writeInt(i);
        if (this.f2360VW != null) {
            this.f2360VW.writeToParcel(dest, flags);
        }
    }
}
