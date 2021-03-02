package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0437eg;
import com.google.android.gms.internal.C0487en;
import java.util.ArrayList;

public final class RoomEntity extends C0487en implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new C0192a();

    /* renamed from: iM */
    private final int f538iM;

    /* renamed from: mo */
    private final String f539mo;

    /* renamed from: nN */
    private final long f540nN;

    /* renamed from: nQ */
    private final ArrayList<ParticipantEntity> f541nQ;

    /* renamed from: nR */
    private final int f542nR;

    /* renamed from: nb */
    private final String f543nb;

    /* renamed from: oh */
    private final Bundle f544oh;

    /* renamed from: ol */
    private final String f545ol;

    /* renamed from: om */
    private final int f546om;

    /* renamed from: on */
    private final int f547on;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RoomEntity$a */
    static final class C0192a extends C0194b {
        C0192a() {
        }

        /* renamed from: y */
        public RoomEntity createFromParcel(Parcel parcel) {
            if (RoomEntity.m1237c(RoomEntity.m836aW()) || RoomEntity.m837y(RoomEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    RoomEntity(int versionCode, String roomId, String creatorId, long creationTimestamp, int roomStatus, String description, int variant, Bundle autoMatchCriteria, ArrayList<ParticipantEntity> participants, int autoMatchWaitEstimateSeconds) {
        this.f538iM = versionCode;
        this.f543nb = roomId;
        this.f545ol = creatorId;
        this.f540nN = creationTimestamp;
        this.f546om = roomStatus;
        this.f539mo = description;
        this.f542nR = variant;
        this.f544oh = autoMatchCriteria;
        this.f541nQ = participants;
        this.f547on = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.f538iM = 2;
        this.f543nb = room.getRoomId();
        this.f545ol = room.getCreatorId();
        this.f540nN = room.getCreationTimestamp();
        this.f546om = room.getStatus();
        this.f539mo = room.getDescription();
        this.f542nR = room.getVariant();
        this.f544oh = room.getAutoMatchCriteria();
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        this.f541nQ = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.f541nQ.add((ParticipantEntity) participants.get(i).freeze());
        }
        this.f547on = room.getAutoMatchWaitEstimateSeconds();
    }

    /* renamed from: a */
    static int m446a(Room room) {
        return C0408dl.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: a */
    static boolean m447a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return C0408dl.equal(room2.getRoomId(), room.getRoomId()) && C0408dl.equal(room2.getCreatorId(), room.getCreatorId()) && C0408dl.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && C0408dl.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && C0408dl.equal(room2.getDescription(), room.getDescription()) && C0408dl.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && C0408dl.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && C0408dl.equal(room2.getParticipants(), room.getParticipants()) && C0408dl.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: b */
    static String m448b(Room room) {
        return C0408dl.m938d(room).mo4388a("RoomId", room.getRoomId()).mo4388a("CreatorId", room.getCreatorId()).mo4388a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).mo4388a("RoomStatus", Integer.valueOf(room.getStatus())).mo4388a("Description", room.getDescription()).mo4388a("Variant", Integer.valueOf(room.getVariant())).mo4388a("AutoMatchCriteria", room.getAutoMatchCriteria()).mo4388a("Participants", room.getParticipants()).mo4388a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m447a(this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.f544oh;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.f547on;
    }

    public long getCreationTimestamp() {
        return this.f540nN;
    }

    public String getCreatorId() {
        return this.f545ol;
    }

    public String getDescription() {
        return this.f539mo;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C0437eg.m1081b(this.f539mo, dataOut);
    }

    public String getParticipantId(String playerId) {
        int size = this.f541nQ.size();
        for (int i = 0; i < size; i++) {
            Participant participant = this.f541nQ.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(playerId)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    public ArrayList<String> getParticipantIds() {
        int size = this.f541nQ.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.f541nQ.get(i).getParticipantId());
        }
        return arrayList;
    }

    public int getParticipantStatus(String participantId) {
        int size = this.f541nQ.size();
        for (int i = 0; i < size; i++) {
            Participant participant = this.f541nQ.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + participantId + " is not in room " + getRoomId());
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.f541nQ);
    }

    public String getRoomId() {
        return this.f543nb;
    }

    public int getStatus() {
        return this.f546om;
    }

    public int getVariant() {
        return this.f542nR;
    }

    public int getVersionCode() {
        return this.f538iM;
    }

    public int hashCode() {
        return m446a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m448b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo4323aX()) {
            C0194b.m454a(this, dest, flags);
            return;
        }
        dest.writeString(this.f543nb);
        dest.writeString(this.f545ol);
        dest.writeLong(this.f540nN);
        dest.writeInt(this.f546om);
        dest.writeString(this.f539mo);
        dest.writeInt(this.f542nR);
        dest.writeBundle(this.f544oh);
        int size = this.f541nQ.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.f541nQ.get(i).writeToParcel(dest, flags);
        }
    }
}
