package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;

/* renamed from: com.google.android.gms.games.d */
public final class C0178d extends C0138b implements Player {
    public C0178d(C0140d dVar, int i) {
        super(dVar, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.m392a(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString("profile_name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo3584a("profile_name", dataOut);
    }

    public Uri getHiResImageUri() {
        return mo3591u("profile_hi_res_image_uri");
    }

    public Uri getIconImageUri() {
        return mo3591u("profile_icon_image_uri");
    }

    public String getPlayerId() {
        return getString("external_player_id");
    }

    public long getRetrievedTimestamp() {
        return getLong("last_updated");
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.m391a(this);
    }

    public String toString() {
        return PlayerEntity.m393b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }
}
