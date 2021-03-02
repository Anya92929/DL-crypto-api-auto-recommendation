package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;

/* renamed from: com.google.android.gms.games.d */
public final class C0382d extends C0342b implements Player {
    public C0382d(C0344d dVar, int i) {
        super(dVar, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.m715a(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString("profile_name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo4037a("profile_name", dataOut);
    }

    public Uri getHiResImageUri() {
        return mo4038d("profile_hi_res_image_uri");
    }

    public Uri getIconImageUri() {
        return mo4038d("profile_icon_image_uri");
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
        return PlayerEntity.m714a(this);
    }

    public String toString() {
        return PlayerEntity.m717b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }
}
