package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.C0423ao;
import com.google.android.gms.internal.C0473av;
import com.google.android.gms.internal.C0618r;
import java.util.ArrayList;

public final class RoomEntity extends C0473av implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new C0396a();

    /* renamed from: ab */
    private final int f963ab;

    /* renamed from: dV */
    private final String f964dV;

    /* renamed from: di */
    private final String f965di;

    /* renamed from: eG */
    private final long f966eG;

    /* renamed from: eJ */
    private final ArrayList<ParticipantEntity> f967eJ;

    /* renamed from: eK */
    private final int f968eK;

    /* renamed from: fa */
    private final Bundle f969fa;

    /* renamed from: fe */
    private final String f970fe;

    /* renamed from: ff */
    private final int f971ff;

    /* renamed from: fg */
    private final int f972fg;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RoomEntity$a */
    static final class C0396a extends C0398b {
        C0396a() {
        }

        /* renamed from: s */
        public RoomEntity createFromParcel(Parcel parcel) {
            if (RoomEntity.m1060c(RoomEntity.m1785v()) || RoomEntity.m1783h(RoomEntity.class.getCanonicalName())) {
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
        this.f963ab = versionCode;
        this.f964dV = roomId;
        this.f970fe = creatorId;
        this.f966eG = creationTimestamp;
        this.f971ff = roomStatus;
        this.f965di = description;
        this.f968eK = variant;
        this.f969fa = autoMatchCriteria;
        this.f967eJ = participants;
        this.f972fg = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.f963ab = 2;
        this.f964dV = room.getRoomId();
        this.f970fe = room.getCreatorId();
        this.f966eG = room.getCreationTimestamp();
        this.f971ff = room.getStatus();
        this.f965di = room.getDescription();
        this.f968eK = room.getVariant();
        this.f969fa = room.getAutoMatchCriteria();
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        this.f967eJ = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.f967eJ.add((ParticipantEntity) participants.get(i).freeze());
        }
        this.f972fg = room.getAutoMatchWaitEstimateSeconds();
    }

    /* renamed from: a */
    static int m775a(Room room) {
        return C0618r.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: a */
    static boolean m776a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return C0618r.m1881a(room2.getRoomId(), room.getRoomId()) && C0618r.m1881a(room2.getCreatorId(), room.getCreatorId()) && C0618r.m1881a(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && C0618r.m1881a(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && C0618r.m1881a(room2.getDescription(), room.getDescription()) && C0618r.m1881a(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && C0618r.m1881a(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && C0618r.m1881a(room2.getParticipants(), room.getParticipants()) && C0618r.m1881a(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: b */
    static String m778b(Room room) {
        return C0618r.m1882c(room).mo5486a("RoomId", room.getRoomId()).mo5486a("CreatorId", room.getCreatorId()).mo5486a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).mo5486a("RoomStatus", Integer.valueOf(room.getStatus())).mo5486a("Description", room.getDescription()).mo5486a("Variant", Integer.valueOf(room.getVariant())).mo5486a("AutoMatchCriteria", room.getAutoMatchCriteria()).mo5486a("Participants", room.getParticipants()).mo5486a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m776a(this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.f969fa;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.f972fg;
    }

    public long getCreationTimestamp() {
        return this.f966eG;
    }

    public String getCreatorId() {
        return this.f970fe;
    }

    public String getDescription() {
        return this.f965di;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C0423ao.m905b(this.f965di, dataOut);
    }

    public String getParticipantId(String playerId) {
        int size = this.f967eJ.size();
        for (int i = 0; i < size; i++) {
            Participant participant = this.f967eJ.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(playerId)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    public ArrayList<String> getParticipantIds() {
        int size = this.f967eJ.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.f967eJ.get(i).getParticipantId());
        }
        return arrayList;
    }

    public int getParticipantStatus(String participantId) {
        int size = this.f967eJ.size();
        for (int i = 0; i < size; i++) {
            Participant participant = this.f967eJ.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + participantId + " is not in room " + getRoomId());
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.f967eJ);
    }

    public String getRoomId() {
        return this.f964dV;
    }

    public int getStatus() {
        return this.f971ff;
    }

    public int getVariant() {
        return this.f968eK;
    }

    public int hashCode() {
        return m775a(this);
    }

    /* renamed from: i */
    public int mo4412i() {
        return this.f963ab;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m778b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo5427w()) {
            C0398b.m785a(this, dest, flags);
            return;
        }
        dest.writeString(this.f964dV);
        dest.writeString(this.f970fe);
        dest.writeLong(this.f966eG);
        dest.writeInt(this.f971ff);
        dest.writeString(this.f965di);
        dest.writeInt(this.f968eK);
        dest.writeBundle(this.f969fa);
        int size = this.f967eJ.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.f967eJ.get(i).writeToParcel(dest, flags);
        }
    }
}
