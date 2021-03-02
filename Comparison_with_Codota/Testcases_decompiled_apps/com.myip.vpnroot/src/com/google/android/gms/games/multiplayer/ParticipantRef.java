package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef extends C0297d implements Participant {
    private final PlayerRef abX;

    public ParticipantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.abX = new PlayerRef(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.m3686a(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return mo4339aS("external_player_id") ? getString("default_display_name") : this.abX.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (mo4339aS("external_player_id")) {
            mo4336a("default_display_name", dataOut);
        } else {
            this.abX.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return mo4339aS("external_player_id") ? mo4338aR("default_display_hi_res_image_uri") : this.abX.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return mo4339aS("external_player_id") ? getString("default_display_hi_res_image_url") : this.abX.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return mo4339aS("external_player_id") ? mo4338aR("default_display_image_uri") : this.abX.getIconImageUri();
    }

    public String getIconImageUrl() {
        return mo4339aS("external_player_id") ? getString("default_display_image_url") : this.abX.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        if (mo4339aS("external_player_id")) {
            return null;
        }
        return this.abX;
    }

    public ParticipantResult getResult() {
        if (mo4339aS("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.m3685a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    /* renamed from: jU */
    public String mo7546jU() {
        return getString("client_address");
    }

    public String toString() {
        return ParticipantEntity.m3687b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }
}
