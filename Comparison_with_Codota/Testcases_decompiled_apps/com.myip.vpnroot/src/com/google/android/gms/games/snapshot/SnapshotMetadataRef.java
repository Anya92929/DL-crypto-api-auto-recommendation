package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.plus.PlusShare;

public final class SnapshotMetadataRef extends C0297d implements SnapshotMetadata {
    private final Game abm;
    private final Player adj;

    public SnapshotMetadataRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.abm = new GameRef(holder, dataRow);
        this.adj = new PlayerRef(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return SnapshotMetadataEntity.m3768a(this, obj);
    }

    public SnapshotMetadata freeze() {
        return new SnapshotMetadataEntity(this);
    }

    public float getCoverImageAspectRatio() {
        float f = getFloat("cover_icon_image_height");
        float f2 = getFloat("cover_icon_image_width");
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    public Uri getCoverImageUri() {
        return mo4338aR("cover_icon_image_uri");
    }

    public String getCoverImageUrl() {
        return getString("cover_icon_image_url");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        mo4336a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public Game getGame() {
        return this.abm;
    }

    public long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    public Player getOwner() {
        return this.adj;
    }

    public long getPlayedTime() {
        return getLong("duration");
    }

    public String getSnapshotId() {
        return getString("external_snapshot_id");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public String getUniqueName() {
        return getString("unique_name");
    }

    public int hashCode() {
        return SnapshotMetadataEntity.m3767a(this);
    }

    public String toString() {
        return SnapshotMetadataEntity.m3769b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((SnapshotMetadataEntity) freeze()).writeToParcel(dest, flags);
    }
}
