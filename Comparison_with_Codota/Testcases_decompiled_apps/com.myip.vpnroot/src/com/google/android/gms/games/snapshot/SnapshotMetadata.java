package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

public interface SnapshotMetadata extends Parcelable, Freezable<SnapshotMetadata> {
    public static final long PLAYED_TIME_UNKNOWN = -1;

    float getCoverImageAspectRatio();

    Uri getCoverImageUri();

    @Deprecated
    String getCoverImageUrl();

    String getDescription();

    void getDescription(CharArrayBuffer charArrayBuffer);

    Game getGame();

    long getLastModifiedTimestamp();

    Player getOwner();

    long getPlayedTime();

    String getSnapshotId();

    String getTitle();

    String getUniqueName();
}
