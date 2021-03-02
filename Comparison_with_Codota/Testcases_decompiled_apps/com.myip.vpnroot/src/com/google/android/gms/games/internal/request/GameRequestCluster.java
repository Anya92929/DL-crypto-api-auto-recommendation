package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();

    /* renamed from: BR */
    private final int f2343BR;
    private final ArrayList<GameRequestEntity> abg;

    GameRequestCluster(int versionCode, ArrayList<GameRequestEntity> requestList) {
        this.f2343BR = versionCode;
        this.abg = requestList;
        m3631lg();
    }

    /* renamed from: lg */
    private void m3631lg() {
        C0313a.m678I(!this.abg.isEmpty());
        GameRequest gameRequest = this.abg.get(0);
        int size = this.abg.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = this.abg.get(i);
            C0313a.m679a(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            C0313a.m679a(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.abg.size() != this.abg.size()) {
            return false;
        }
        int size = this.abg.size();
        for (int i = 0; i < size; i++) {
            if (!this.abg.get(i).equals(gameRequestCluster.abg.get(i))) {
                return false;
            }
        }
        return true;
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getRequestId() {
        return this.abg.get(0).getRequestId();
    }

    public Player getSender() {
        return this.abg.get(0).getSender();
    }

    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType() {
        return this.abg.get(0).getType();
    }

    public int getVersionCode() {
        return this.f2343BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.abg.toArray());
    }

    public boolean isConsumed(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: lu */
    public ArrayList<GameRequest> mo7445lu() {
        return new ArrayList<>(this.abg);
    }

    /* renamed from: lv */
    public ArrayList<Player> getRecipients() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestClusterCreator.m3634a(this, dest, flags);
    }
}
