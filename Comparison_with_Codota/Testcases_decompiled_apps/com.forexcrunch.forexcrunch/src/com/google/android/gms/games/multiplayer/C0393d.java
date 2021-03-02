package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.games.C0382d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.multiplayer.d */
public final class C0393d extends C0342b implements Participant {

    /* renamed from: eS */
    private final C0382d f943eS;

    public C0393d(C0344d dVar, int i) {
        super(dVar, i);
        this.f943eS = new C0382d(dVar, i);
    }

    /* renamed from: aM */
    public String mo4341aM() {
        return getString("client_address");
    }

    /* renamed from: aN */
    public int mo4342aN() {
        return getInteger("capabilities");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.m754a(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public String getDisplayName() {
        return mo4039e("external_player_id") ? getString("default_display_name") : this.f943eS.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (mo4039e("external_player_id")) {
            mo4037a("default_display_name", dataOut);
        } else {
            this.f943eS.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        if (mo4039e("external_player_id")) {
            return null;
        }
        return this.f943eS.getHiResImageUri();
    }

    public Uri getIconImageUri() {
        return mo4039e("external_player_id") ? mo4038d("default_display_image_uri") : this.f943eS.getIconImageUri();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        if (mo4039e("external_player_id")) {
            return null;
        }
        return this.f943eS;
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.m753a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.m756b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }
}
