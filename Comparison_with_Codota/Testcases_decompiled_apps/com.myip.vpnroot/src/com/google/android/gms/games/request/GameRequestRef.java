package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends C0297d implements GameRequest {
    private final int aaz;

    public GameRequestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.aaz = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameRequestEntity.m3753a(this, obj);
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new GameRef(this.f693IC, this.f694JQ);
    }

    public int getRecipientStatus(String playerId) {
        for (int i = this.f694JQ; i < this.f694JQ + this.aaz; i++) {
            int ar = this.f693IC.mo4304ar(i);
            if (this.f693IC.mo4306c("recipient_external_player_id", i, ar).equals(playerId)) {
                return this.f693IC.mo4305b("recipient_status", i, ar);
            }
        }
        return -1;
    }

    public List<Player> getRecipients() {
        ArrayList arrayList = new ArrayList(this.aaz);
        for (int i = 0; i < this.aaz; i++) {
            arrayList.add(new PlayerRef(this.f693IC, this.f694JQ + i, "recipient_"));
        }
        return arrayList;
    }

    public String getRequestId() {
        return getString("external_request_id");
    }

    public Player getSender() {
        return new PlayerRef(this.f693IC, mo4341gA(), "sender_");
    }

    public int getStatus() {
        return getInteger("status");
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return GameRequestEntity.m3752a(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public String toString() {
        return GameRequestEntity.m3755c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameRequestEntity) freeze()).writeToParcel(dest, flags);
    }
}
