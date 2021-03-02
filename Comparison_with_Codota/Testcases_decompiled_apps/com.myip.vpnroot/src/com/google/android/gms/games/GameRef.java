package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;

public final class GameRef extends C0297d implements Game {
    public GameRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public boolean areSnapshotsEnabled() {
        return getInteger("snapshots_enabled") > 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameEntity.m2140a(this, obj);
    }

    public Game freeze() {
        return new GameEntity(this);
    }

    public int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDescription() {
        return getString("game_description");
    }

    public void getDescription(CharArrayBuffer dataOut) {
        mo4336a("game_description", dataOut);
    }

    public String getDeveloperName() {
        return getString("developer_name");
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        mo4336a("developer_name", dataOut);
    }

    public String getDisplayName() {
        return getString("display_name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo4336a("display_name", dataOut);
    }

    public Uri getFeaturedImageUri() {
        return mo4338aR("featured_image_uri");
    }

    public String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    public Uri getHiResImageUri() {
        return mo4338aR("game_hi_res_image_uri");
    }

    public String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    public Uri getIconImageUri() {
        return mo4338aR("game_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    public int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    public String getPrimaryCategory() {
        return getString("primary_category");
    }

    public String getSecondaryCategory() {
        return getString("secondary_category");
    }

    public String getThemeColor() {
        return getString("theme_color");
    }

    public int hashCode() {
        return GameEntity.m2139a(this);
    }

    public boolean isMuted() {
        return getBoolean("muted");
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return getInteger("real_time_support") > 0;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return getInteger("turn_based_support") > 0;
    }

    /* renamed from: jL */
    public boolean mo6348jL() {
        return getBoolean("play_enabled_game");
    }

    /* renamed from: jM */
    public boolean mo6349jM() {
        return getBoolean("identity_sharing_confirmed");
    }

    /* renamed from: jN */
    public boolean mo6350jN() {
        return getInteger("installed") > 0;
    }

    /* renamed from: jO */
    public String mo6351jO() {
        return getString("package_name");
    }

    /* renamed from: jP */
    public int mo6352jP() {
        return getInteger("gameplay_acl_status");
    }

    public String toString() {
        return GameEntity.m2141b((Game) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameEntity) freeze()).writeToParcel(dest, flags);
    }
}
