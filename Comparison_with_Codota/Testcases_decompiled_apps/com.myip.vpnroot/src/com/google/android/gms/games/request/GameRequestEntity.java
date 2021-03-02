package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();

    /* renamed from: BR */
    private final int f2383BR;

    /* renamed from: FD */
    private final int f2384FD;

    /* renamed from: Fa */
    private final int f2385Fa;

    /* renamed from: Xr */
    private final String f2386Xr;
    private final GameEntity aan;
    private final long abO;
    private final PlayerEntity acR;
    private final ArrayList<PlayerEntity> acS;
    private final long acT;
    private final Bundle acU;
    private final byte[] acw;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.f2383BR = versionCode;
        this.aan = game;
        this.acR = sender;
        this.acw = data;
        this.f2386Xr = requestId;
        this.acS = recipients;
        this.f2384FD = type;
        this.abO = creationTimestamp;
        this.acT = expirationTimestamp;
        this.acU = recipientStatuses;
        this.f2385Fa = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.f2383BR = 2;
        this.aan = new GameEntity(request.getGame());
        this.acR = new PlayerEntity(request.getSender());
        this.f2386Xr = request.getRequestId();
        this.f2384FD = request.getType();
        this.abO = request.getCreationTimestamp();
        this.acT = request.getExpirationTimestamp();
        this.f2385Fa = request.getStatus();
        byte[] data = request.getData();
        if (data == null) {
            this.acw = null;
        } else {
            this.acw = new byte[data.length];
            System.arraycopy(data, 0, this.acw, 0, data.length);
        }
        List<Player> recipients = request.getRecipients();
        int size = recipients.size();
        this.acS = new ArrayList<>(size);
        this.acU = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) recipients.get(i).freeze();
            String playerId = player.getPlayerId();
            this.acS.add((PlayerEntity) player);
            this.acU.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    /* renamed from: a */
    static int m3752a(GameRequest gameRequest) {
        return C0345m.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), m3754b(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    /* renamed from: a */
    static boolean m3753a(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return C0345m.equal(gameRequest2.getGame(), gameRequest.getGame()) && C0345m.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && C0345m.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && C0345m.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(m3754b(gameRequest2), m3754b(gameRequest)) && C0345m.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && C0345m.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && C0345m.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    /* renamed from: b */
    private static int[] m3754b(GameRequest gameRequest) {
        List<Player> recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(recipients.get(i).getPlayerId());
        }
        return iArr;
    }

    /* renamed from: c */
    static String m3755c(GameRequest gameRequest) {
        return C0345m.m848h(gameRequest).mo4549a("Game", gameRequest.getGame()).mo4549a("Sender", gameRequest.getSender()).mo4549a("Recipients", gameRequest.getRecipients()).mo4549a("Data", gameRequest.getData()).mo4549a("RequestId", gameRequest.getRequestId()).mo4549a("Type", Integer.valueOf(gameRequest.getType())).mo4549a("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).mo4549a("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3753a(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.abO;
    }

    public byte[] getData() {
        return this.acw;
    }

    public long getExpirationTimestamp() {
        return this.acT;
    }

    public Game getGame() {
        return this.aan;
    }

    public int getRecipientStatus(String playerId) {
        return this.acU.getInt(playerId, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.acS);
    }

    public String getRequestId() {
        return this.f2386Xr;
    }

    public Player getSender() {
        return this.acR;
    }

    public int getStatus() {
        return this.f2385Fa;
    }

    public int getType() {
        return this.f2384FD;
    }

    public int getVersionCode() {
        return this.f2383BR;
    }

    public int hashCode() {
        return m3752a(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: lJ */
    public Bundle mo7750lJ() {
        return this.acU;
    }

    public String toString() {
        return m3755c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.m3757a(this, dest, flags);
    }
}
