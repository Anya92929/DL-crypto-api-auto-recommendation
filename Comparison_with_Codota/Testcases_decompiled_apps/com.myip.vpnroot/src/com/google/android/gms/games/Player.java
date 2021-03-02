package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

public interface Player extends Parcelable, Freezable<Player> {
    public static final long CURRENT_XP_UNKNOWN = -1;
    public static final long TIMESTAMP_UNKNOWN = -1;

    String getDisplayName();

    void getDisplayName(CharArrayBuffer charArrayBuffer);

    Uri getHiResImageUri();

    @Deprecated
    String getHiResImageUrl();

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    long getLastPlayedWithTimestamp();

    PlayerLevelInfo getLevelInfo();

    String getPlayerId();

    long getRetrievedTimestamp();

    String getTitle();

    void getTitle(CharArrayBuffer charArrayBuffer);

    boolean hasHiResImage();

    boolean hasIconImage();

    boolean isProfileVisible();

    /* renamed from: jR */
    int mo6394jR();

    /* renamed from: jS */
    MostRecentGameInfo mo6395jS();
}
