package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.C1386jv;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();

    /* renamed from: BR */
    private final int f2371BR;

    /* renamed from: Di */
    private final int f2372Di;

    /* renamed from: Tg */
    private final String f2373Tg;

    /* renamed from: VZ */
    private final long f2374VZ;

    /* renamed from: WW */
    private final String f2375WW;
    private final GameEntity aan;
    private final long abO;
    private final ArrayList<ParticipantEntity> abR;
    private final int abS;
    private final int acA;
    private final boolean acB;
    private final String acC;
    private final Bundle ach;
    private final String acl;
    private final String act;
    private final String acu;
    private final int acv;
    private final byte[] acw;
    private final String acx;
    private final byte[] acy;
    private final int acz;

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.f2371BR = versionCode;
        this.aan = game;
        this.f2375WW = matchId;
        this.acl = creatorId;
        this.abO = creationTimestamp;
        this.act = lastUpdaterId;
        this.f2374VZ = lastUpdatedTimestamp;
        this.acu = pendingParticipantId;
        this.acv = matchStatus;
        this.acA = turnStatus;
        this.abS = variant;
        this.f2372Di = version;
        this.acw = data;
        this.abR = participants;
        this.acx = rematchId;
        this.acy = previousData;
        this.acz = matchNumber;
        this.ach = autoMatchCriteria;
        this.acB = isLocallyModified;
        this.f2373Tg = description;
        this.acC = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.f2371BR = 2;
        this.aan = new GameEntity(match.getGame());
        this.f2375WW = match.getMatchId();
        this.acl = match.getCreatorId();
        this.abO = match.getCreationTimestamp();
        this.act = match.getLastUpdaterId();
        this.f2374VZ = match.getLastUpdatedTimestamp();
        this.acu = match.getPendingParticipantId();
        this.acv = match.getStatus();
        this.acA = match.getTurnStatus();
        this.abS = match.getVariant();
        this.f2372Di = match.getVersion();
        this.acx = match.getRematchId();
        this.acz = match.getMatchNumber();
        this.ach = match.getAutoMatchCriteria();
        this.acB = match.isLocallyModified();
        this.f2373Tg = match.getDescription();
        this.acC = match.getDescriptionParticipantId();
        byte[] data = match.getData();
        if (data == null) {
            this.acw = null;
        } else {
            this.acw = new byte[data.length];
            System.arraycopy(data, 0, this.acw, 0, data.length);
        }
        byte[] previousMatchData = match.getPreviousMatchData();
        if (previousMatchData == null) {
            this.acy = null;
        } else {
            this.acy = new byte[previousMatchData.length];
            System.arraycopy(previousMatchData, 0, this.acy, 0, previousMatchData.length);
        }
        ArrayList<Participant> participants = match.getParticipants();
        int size = participants.size();
        this.abR = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.abR.add((ParticipantEntity) participants.get(i).freeze());
        }
    }

    /* renamed from: a */
    static int m3723a(TurnBasedMatch turnBasedMatch) {
        return C0345m.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    /* renamed from: a */
    static int m3724a(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList<Participant> participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    /* renamed from: a */
    static boolean m3725a(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return C0345m.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && C0345m.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && C0345m.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && C0345m.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && C0345m.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && C0345m.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && C0345m.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && C0345m.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && C0345m.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && C0345m.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && C0345m.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && C0345m.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && C0345m.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && C0345m.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && C0345m.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && C0345m.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && C0345m.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && C0345m.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    /* renamed from: b */
    static String m3726b(TurnBasedMatch turnBasedMatch) {
        return C0345m.m848h(turnBasedMatch).mo4549a("Game", turnBasedMatch.getGame()).mo4549a("MatchId", turnBasedMatch.getMatchId()).mo4549a("CreatorId", turnBasedMatch.getCreatorId()).mo4549a("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).mo4549a("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).mo4549a("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).mo4549a("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).mo4549a("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).mo4549a("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).mo4549a("Description", turnBasedMatch.getDescription()).mo4549a("Variant", Integer.valueOf(turnBasedMatch.getVariant())).mo4549a("Data", turnBasedMatch.getData()).mo4549a("Version", Integer.valueOf(turnBasedMatch.getVersion())).mo4549a("Participants", turnBasedMatch.getParticipants()).mo4549a("RematchId", turnBasedMatch.getRematchId()).mo4549a("PreviousData", turnBasedMatch.getPreviousMatchData()).mo4549a("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).mo4549a("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).mo4549a("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).mo4549a("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).mo4549a("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    /* renamed from: b */
    static String m3727b(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList<Participant> participants = turnBasedMatch.getParticipants();
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
    static Participant m3728c(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList<Participant> participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    /* renamed from: c */
    static ArrayList<String> m3729c(TurnBasedMatch turnBasedMatch) {
        ArrayList<Participant> participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(participants.get(i).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.acv == 2 && this.acx == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3725a((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.ach;
    }

    public int getAvailableAutoMatchSlots() {
        if (this.ach == null) {
            return 0;
        }
        return this.ach.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.abO;
    }

    public String getCreatorId() {
        return this.acl;
    }

    public byte[] getData() {
        return this.acw;
    }

    public String getDescription() {
        return this.f2373Tg;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f2373Tg, dataOut);
    }

    public Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        if (descriptionParticipantId == null) {
            return null;
        }
        return getParticipant(descriptionParticipantId);
    }

    public String getDescriptionParticipantId() {
        return this.acC;
    }

    public Game getGame() {
        return this.aan;
    }

    public long getLastUpdatedTimestamp() {
        return this.f2374VZ;
    }

    public String getLastUpdaterId() {
        return this.act;
    }

    public String getMatchId() {
        return this.f2375WW;
    }

    public int getMatchNumber() {
        return this.acz;
    }

    public Participant getParticipant(String participantId) {
        return m3728c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m3727b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m3729c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m3724a((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.abR);
    }

    public String getPendingParticipantId() {
        return this.acu;
    }

    public byte[] getPreviousMatchData() {
        return this.acy;
    }

    public String getRematchId() {
        return this.acx;
    }

    public int getStatus() {
        return this.acv;
    }

    public int getTurnStatus() {
        return this.acA;
    }

    public int getVariant() {
        return this.abS;
    }

    public int getVersion() {
        return this.f2372Di;
    }

    public int getVersionCode() {
        return this.f2371BR;
    }

    public int hashCode() {
        return m3723a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.acB;
    }

    public String toString() {
        return m3726b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.m3730a(this, out, flags);
    }
}
