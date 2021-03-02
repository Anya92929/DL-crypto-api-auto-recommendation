package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.C1386jv;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();

    /* renamed from: BR */
    private final int f1590BR;

    /* renamed from: Ez */
    private final String f1591Ez;

    /* renamed from: Nz */
    private final String f1592Nz;

    /* renamed from: Tg */
    private final String f1593Tg;

    /* renamed from: UT */
    private final String f1594UT;

    /* renamed from: UU */
    private final String f1595UU;

    /* renamed from: UV */
    private final String f1596UV;

    /* renamed from: UW */
    private final Uri f1597UW;

    /* renamed from: UX */
    private final Uri f1598UX;

    /* renamed from: UY */
    private final Uri f1599UY;

    /* renamed from: UZ */
    private final boolean f1600UZ;

    /* renamed from: Va */
    private final boolean f1601Va;

    /* renamed from: Vb */
    private final String f1602Vb;

    /* renamed from: Vc */
    private final int f1603Vc;

    /* renamed from: Vd */
    private final int f1604Vd;

    /* renamed from: Ve */
    private final int f1605Ve;

    /* renamed from: Vf */
    private final boolean f1606Vf;

    /* renamed from: Vg */
    private final boolean f1607Vg;

    /* renamed from: Vh */
    private final String f1608Vh;

    /* renamed from: Vi */
    private final String f1609Vi;

    /* renamed from: Vj */
    private final String f1610Vj;

    /* renamed from: Vk */
    private final boolean f1611Vk;

    /* renamed from: Vl */
    private final boolean f1612Vl;

    /* renamed from: Vm */
    private final boolean f1613Vm;

    /* renamed from: Vn */
    private final String f1614Vn;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        /* renamed from: cd */
        public GameEntity createFromParcel(Parcel parcel) {
            if (GameEntity.m2548c(GameEntity.m686gP()) || GameEntity.m684aV(GameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            String readString8 = parcel.readString();
            Uri parse2 = readString8 == null ? null : Uri.parse(readString8);
            String readString9 = parcel.readString();
            return new GameEntity(5, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString9 == null ? null : Uri.parse(readString9), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, (String) null, (String) null, (String) null, false, false, false, (String) null);
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed, boolean snapshotsEnabled, String themeColor) {
        this.f1590BR = versionCode;
        this.f1591Ez = applicationId;
        this.f1592Nz = displayName;
        this.f1594UT = primaryCategory;
        this.f1595UU = secondaryCategory;
        this.f1593Tg = description;
        this.f1596UV = developerName;
        this.f1597UW = iconImageUri;
        this.f1608Vh = iconImageUrl;
        this.f1598UX = hiResImageUri;
        this.f1609Vi = hiResImageUrl;
        this.f1599UY = featuredImageUri;
        this.f1610Vj = featuredImageUrl;
        this.f1600UZ = playEnabledGame;
        this.f1601Va = instanceInstalled;
        this.f1602Vb = instancePackageName;
        this.f1603Vc = gameplayAclStatus;
        this.f1604Vd = achievementTotalCount;
        this.f1605Ve = leaderboardCount;
        this.f1606Vf = realTimeEnabled;
        this.f1607Vg = turnBasedEnabled;
        this.f1611Vk = muted;
        this.f1612Vl = identitySharingConfirmed;
        this.f1613Vm = snapshotsEnabled;
        this.f1614Vn = themeColor;
    }

    public GameEntity(Game game) {
        this.f1590BR = 5;
        this.f1591Ez = game.getApplicationId();
        this.f1594UT = game.getPrimaryCategory();
        this.f1595UU = game.getSecondaryCategory();
        this.f1593Tg = game.getDescription();
        this.f1596UV = game.getDeveloperName();
        this.f1592Nz = game.getDisplayName();
        this.f1597UW = game.getIconImageUri();
        this.f1608Vh = game.getIconImageUrl();
        this.f1598UX = game.getHiResImageUri();
        this.f1609Vi = game.getHiResImageUrl();
        this.f1599UY = game.getFeaturedImageUri();
        this.f1610Vj = game.getFeaturedImageUrl();
        this.f1600UZ = game.mo6348jL();
        this.f1601Va = game.mo6350jN();
        this.f1602Vb = game.mo6351jO();
        this.f1603Vc = game.mo6352jP();
        this.f1604Vd = game.getAchievementTotalCount();
        this.f1605Ve = game.getLeaderboardCount();
        this.f1606Vf = game.isRealTimeMultiplayerEnabled();
        this.f1607Vg = game.isTurnBasedMultiplayerEnabled();
        this.f1611Vk = game.isMuted();
        this.f1612Vl = game.mo6349jM();
        this.f1613Vm = game.areSnapshotsEnabled();
        this.f1614Vn = game.getThemeColor();
    }

    /* renamed from: a */
    static int m2139a(Game game) {
        return C0345m.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.mo6348jL()), Boolean.valueOf(game.mo6350jN()), game.mo6351jO(), Integer.valueOf(game.mo6352jP()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.mo6349jM()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor());
    }

    /* renamed from: a */
    static boolean m2140a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (C0345m.equal(game2.getApplicationId(), game.getApplicationId()) && C0345m.equal(game2.getDisplayName(), game.getDisplayName()) && C0345m.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && C0345m.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && C0345m.equal(game2.getDescription(), game.getDescription()) && C0345m.equal(game2.getDeveloperName(), game.getDeveloperName()) && C0345m.equal(game2.getIconImageUri(), game.getIconImageUri()) && C0345m.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && C0345m.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && C0345m.equal(Boolean.valueOf(game2.mo6348jL()), Boolean.valueOf(game.mo6348jL())) && C0345m.equal(Boolean.valueOf(game2.mo6350jN()), Boolean.valueOf(game.mo6350jN())) && C0345m.equal(game2.mo6351jO(), game.mo6351jO()) && C0345m.equal(Integer.valueOf(game2.mo6352jP()), Integer.valueOf(game.mo6352jP())) && C0345m.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && C0345m.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && C0345m.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            if (C0345m.equal(Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled() && C0345m.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && C0345m.equal(Boolean.valueOf(game2.mo6349jM()), Boolean.valueOf(game.mo6349jM())))) && C0345m.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && C0345m.equal(game2.getThemeColor(), game.getThemeColor())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static String m2141b(Game game) {
        return C0345m.m848h(game).mo4549a("ApplicationId", game.getApplicationId()).mo4549a("DisplayName", game.getDisplayName()).mo4549a("PrimaryCategory", game.getPrimaryCategory()).mo4549a("SecondaryCategory", game.getSecondaryCategory()).mo4549a("Description", game.getDescription()).mo4549a("DeveloperName", game.getDeveloperName()).mo4549a("IconImageUri", game.getIconImageUri()).mo4549a("IconImageUrl", game.getIconImageUrl()).mo4549a("HiResImageUri", game.getHiResImageUri()).mo4549a("HiResImageUrl", game.getHiResImageUrl()).mo4549a("FeaturedImageUri", game.getFeaturedImageUri()).mo4549a("FeaturedImageUrl", game.getFeaturedImageUrl()).mo4549a("PlayEnabledGame", Boolean.valueOf(game.mo6348jL())).mo4549a("InstanceInstalled", Boolean.valueOf(game.mo6350jN())).mo4549a("InstancePackageName", game.mo6351jO()).mo4549a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).mo4549a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).mo4549a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).mo4549a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).mo4549a("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).mo4549a("ThemeColor", game.getThemeColor()).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.f1613Vm;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m2140a(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.f1604Vd;
    }

    public String getApplicationId() {
        return this.f1591Ez;
    }

    public String getDescription() {
        return this.f1593Tg;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1593Tg, dataOut);
    }

    public String getDeveloperName() {
        return this.f1596UV;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1596UV, dataOut);
    }

    public String getDisplayName() {
        return this.f1592Nz;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1592Nz, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.f1599UY;
    }

    public String getFeaturedImageUrl() {
        return this.f1610Vj;
    }

    public Uri getHiResImageUri() {
        return this.f1598UX;
    }

    public String getHiResImageUrl() {
        return this.f1609Vi;
    }

    public Uri getIconImageUri() {
        return this.f1597UW;
    }

    public String getIconImageUrl() {
        return this.f1608Vh;
    }

    public int getLeaderboardCount() {
        return this.f1605Ve;
    }

    public String getPrimaryCategory() {
        return this.f1594UT;
    }

    public String getSecondaryCategory() {
        return this.f1595UU;
    }

    public String getThemeColor() {
        return this.f1614Vn;
    }

    public int getVersionCode() {
        return this.f1590BR;
    }

    public int hashCode() {
        return m2139a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.f1611Vk;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.f1606Vf;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.f1607Vg;
    }

    /* renamed from: jL */
    public boolean mo6348jL() {
        return this.f1600UZ;
    }

    /* renamed from: jM */
    public boolean mo6349jM() {
        return this.f1612Vl;
    }

    /* renamed from: jN */
    public boolean mo6350jN() {
        return this.f1601Va;
    }

    /* renamed from: jO */
    public String mo6351jO() {
        return this.f1602Vb;
    }

    /* renamed from: jP */
    public int mo6352jP() {
        return this.f1603Vc;
    }

    public String toString() {
        return m2141b((Game) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (!mo4427gQ()) {
            GameEntityCreator.m2151a(this, dest, flags);
            return;
        }
        dest.writeString(this.f1591Ez);
        dest.writeString(this.f1592Nz);
        dest.writeString(this.f1594UT);
        dest.writeString(this.f1595UU);
        dest.writeString(this.f1593Tg);
        dest.writeString(this.f1596UV);
        dest.writeString(this.f1597UW == null ? null : this.f1597UW.toString());
        dest.writeString(this.f1598UX == null ? null : this.f1598UX.toString());
        if (this.f1599UY != null) {
            str = this.f1599UY.toString();
        }
        dest.writeString(str);
        dest.writeInt(this.f1600UZ ? 1 : 0);
        if (!this.f1601Va) {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeString(this.f1602Vb);
        dest.writeInt(this.f1603Vc);
        dest.writeInt(this.f1604Vd);
        dest.writeInt(this.f1605Ve);
    }
}
