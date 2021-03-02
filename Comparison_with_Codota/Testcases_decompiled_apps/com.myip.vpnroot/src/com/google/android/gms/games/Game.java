package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Game extends Parcelable, Freezable<Game> {
    boolean areSnapshotsEnabled();

    int getAchievementTotalCount();

    String getApplicationId();

    String getDescription();

    void getDescription(CharArrayBuffer charArrayBuffer);

    String getDeveloperName();

    void getDeveloperName(CharArrayBuffer charArrayBuffer);

    String getDisplayName();

    void getDisplayName(CharArrayBuffer charArrayBuffer);

    Uri getFeaturedImageUri();

    @Deprecated
    String getFeaturedImageUrl();

    Uri getHiResImageUri();

    @Deprecated
    String getHiResImageUrl();

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    int getLeaderboardCount();

    String getPrimaryCategory();

    String getSecondaryCategory();

    String getThemeColor();

    boolean isMuted();

    boolean isRealTimeMultiplayerEnabled();

    boolean isTurnBasedMultiplayerEnabled();

    /* renamed from: jL */
    boolean mo6348jL();

    /* renamed from: jM */
    boolean mo6349jM();

    /* renamed from: jN */
    boolean mo6350jN();

    /* renamed from: jO */
    String mo6351jO();

    /* renamed from: jP */
    int mo6352jP();
}
