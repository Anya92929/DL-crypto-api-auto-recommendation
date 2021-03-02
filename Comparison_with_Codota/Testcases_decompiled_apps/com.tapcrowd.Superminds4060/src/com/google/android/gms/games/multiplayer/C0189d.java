package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.games.C0178d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.multiplayer.d */
public final class C0189d extends C0138b implements Participant {

    /* renamed from: nZ */
    private final C0178d f518nZ;

    public C0189d(C0140d dVar, int i) {
        super(dVar, i);
        this.f518nZ = new C0178d(dVar, i);
    }

    /* renamed from: ci */
    public String mo3892ci() {
        return getString("client_address");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.m428a(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return mo3592v("external_player_id") ? getString("default_display_name") : this.f518nZ.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (mo3592v("external_player_id")) {
            mo3584a("default_display_name", dataOut);
        } else {
            this.f518nZ.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        if (mo3592v("external_player_id")) {
            return null;
        }
        return this.f518nZ.getHiResImageUri();
    }

    public Uri getIconImageUri() {
        return mo3592v("external_player_id") ? mo3591u("default_display_image_uri") : this.f518nZ.getIconImageUri();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        if (mo3592v("external_player_id")) {
            return null;
        }
        return this.f518nZ;
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.m427a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.m429b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }
}
