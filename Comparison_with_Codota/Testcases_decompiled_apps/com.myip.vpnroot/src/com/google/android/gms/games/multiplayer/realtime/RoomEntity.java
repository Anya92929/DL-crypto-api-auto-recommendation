package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.C1386jv;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();

    /* renamed from: BR */
    private final int f2368BR;

    /* renamed from: Tg */
    private final String f2369Tg;

    /* renamed from: WF */
    private final String f2370WF;
    private final long abO;
    private final ArrayList<ParticipantEntity> abR;
    private final int abS;
    private final Bundle ach;
    private final String acl;
    private final int acm;
    private final int acn;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        /* renamed from: co */
        public RoomEntity createFromParcel(Parcel parcel) {
            if (RoomEntity.m2548c(RoomEntity.m686gP()) || RoomEntity.m684aV(RoomEntity.class.getCanonicalName())) {
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
        this.f2368BR = versionCode;
        this.f2370WF = roomId;
        this.acl = creatorId;
        this.abO = creationTimestamp;
        this.acm = roomStatus;
        this.f2369Tg = description;
        this.abS = variant;
        this.ach = autoMatchCriteria;
        this.abR = participants;
        this.acn = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.f2368BR = 2;
        this.f2370WF = room.getRoomId();
        this.acl = room.getCreatorId();
        this.abO = room.getCreationTimestamp();
        this.acm = room.getStatus();
        this.f2369Tg = room.getDescription();
        this.abS = room.getVariant();
        this.ach = room.getAutoMatchCriteria();
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        this.abR = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.abR.add((ParticipantEntity) participants.get(i).freeze());
        }
        this.acn = room.getAutoMatchWaitEstimateSeconds();
    }

    /* renamed from: a */
    static int m3704a(Room room) {
        return C0345m.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: a */
    static int m3705a(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    /* renamed from: a */
    static boolean m3706a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return C0345m.equal(room2.getRoomId(), room.getRoomId()) && C0345m.equal(room2.getCreatorId(), room.getCreatorId()) && C0345m.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && C0345m.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && C0345m.equal(room2.getDescription(), room.getDescription()) && C0345m.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && C0345m.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && C0345m.equal(room2.getParticipants(), room.getParticipants()) && C0345m.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: b */
    static String m3707b(Room room) {
        return C0345m.m848h(room).mo4549a("RoomId", room.getRoomId()).mo4549a("CreatorId", room.getCreatorId()).mo4549a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).mo4549a("RoomStatus", Integer.valueOf(room.getStatus())).mo4549a("Description", room.getDescription()).mo4549a("Variant", Integer.valueOf(room.getVariant())).mo4549a("AutoMatchCriteria", room.getAutoMatchCriteria()).mo4549a("Participants", room.getParticipants()).mo4549a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    /* renamed from: b */
    static String m3708b(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    /* renamed from: c */
    static Participant m3711c(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    /* renamed from: c */
    static ArrayList<String> m3712c(Room room) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(participants.get(i).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3706a((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.ach;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.acn;
    }

    public long getCreationTimestamp() {
        return this.abO;
    }

    public String getCreatorId() {
        return this.acl;
    }

    public String getDescription() {
        return this.f2369Tg;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f2369Tg, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return m3711c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m3708b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m3712c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m3705a((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.abR);
    }

    public String getRoomId() {
        return this.f2370WF;
    }

    public int getStatus() {
        return this.acm;
    }

    public int getVariant() {
        return this.abS;
    }

    public int getVersionCode() {
        return this.f2368BR;
    }

    public int hashCode() {
        return m3704a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m3707b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo4427gQ()) {
            RoomEntityCreator.m3715a(this, dest, flags);
            return;
        }
        dest.writeString(this.f2370WF);
        dest.writeString(this.acl);
        dest.writeLong(this.abO);
        dest.writeInt(this.acm);
        dest.writeString(this.f2369Tg);
        dest.writeInt(this.abS);
        dest.writeBundle(this.ach);
        int size = this.abR.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.abR.get(i).writeToParcel(dest, flags);
        }
    }
}
