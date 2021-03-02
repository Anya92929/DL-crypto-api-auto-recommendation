package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.C1386jv;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();

    /* renamed from: BR */
    private final int f1635BR;

    /* renamed from: No */
    private final String f1636No;

    /* renamed from: Nz */
    private final String f1637Nz;

    /* renamed from: UW */
    private final Uri f1638UW;

    /* renamed from: UX */
    private final Uri f1639UX;

    /* renamed from: VA */
    private final long f1640VA;

    /* renamed from: VB */
    private final int f1641VB;

    /* renamed from: VC */
    private final long f1642VC;

    /* renamed from: VD */
    private final MostRecentGameInfoEntity f1643VD;

    /* renamed from: VE */
    private final PlayerLevelInfo f1644VE;

    /* renamed from: VF */
    private final boolean f1645VF;

    /* renamed from: Vh */
    private final String f1646Vh;

    /* renamed from: Vi */
    private final String f1647Vi;

    /* renamed from: Vz */
    private final String f1648Vz;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        /* renamed from: ce */
        public PlayerEntity createFromParcel(Parcel parcel) {
            if (PlayerEntity.m2548c(PlayerEntity.m686gP()) || PlayerEntity.m684aV(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(11, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, (String) null, (String) null, (String) null, (MostRecentGameInfoEntity) null, (PlayerLevelInfo) null, true);
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean isProfileVisible) {
        this.f1635BR = versionCode;
        this.f1648Vz = playerId;
        this.f1637Nz = displayName;
        this.f1638UW = iconImageUri;
        this.f1646Vh = iconImageUrl;
        this.f1639UX = hiResImageUri;
        this.f1647Vi = hiResImageUrl;
        this.f1640VA = retrievedTimestamp;
        this.f1641VB = isInCircles;
        this.f1642VC = lastPlayedWithTimestamp;
        this.f1636No = title;
        this.f1645VF = isProfileVisible;
        this.f1643VD = mostRecentGameInfo;
        this.f1644VE = playerLevelInfo;
    }

    public PlayerEntity(Player player) {
        this.f1635BR = 11;
        this.f1648Vz = player.getPlayerId();
        this.f1637Nz = player.getDisplayName();
        this.f1638UW = player.getIconImageUri();
        this.f1646Vh = player.getIconImageUrl();
        this.f1639UX = player.getHiResImageUri();
        this.f1647Vi = player.getHiResImageUrl();
        this.f1640VA = player.getRetrievedTimestamp();
        this.f1641VB = player.mo6394jR();
        this.f1642VC = player.getLastPlayedWithTimestamp();
        this.f1636No = player.getTitle();
        this.f1645VF = player.isProfileVisible();
        MostRecentGameInfo jS = player.mo6395jS();
        this.f1643VD = jS == null ? null : new MostRecentGameInfoEntity(jS);
        this.f1644VE = player.getLevelInfo();
        C0313a.m682f(this.f1648Vz);
        C0313a.m682f(this.f1637Nz);
        C0313a.m678I(this.f1640VA > 0);
    }

    /* renamed from: a */
    static boolean m2170a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return C0345m.equal(player2.getPlayerId(), player.getPlayerId()) && C0345m.equal(player2.getDisplayName(), player.getDisplayName()) && C0345m.equal(player2.getIconImageUri(), player.getIconImageUri()) && C0345m.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && C0345m.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && C0345m.equal(player2.getTitle(), player.getTitle()) && C0345m.equal(player2.getLevelInfo(), player.getLevelInfo());
    }

    /* renamed from: b */
    static int m2171b(Player player) {
        return C0345m.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo());
    }

    /* renamed from: c */
    static String m2174c(Player player) {
        return C0345m.m848h(player).mo4549a("PlayerId", player.getPlayerId()).mo4549a("DisplayName", player.getDisplayName()).mo4549a("IconImageUri", player.getIconImageUri()).mo4549a("IconImageUrl", player.getIconImageUrl()).mo4549a("HiResImageUri", player.getHiResImageUri()).mo4549a("HiResImageUrl", player.getHiResImageUrl()).mo4549a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).mo4549a("Title", player.getTitle()).mo4549a("LevelInfo", player.getLevelInfo()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m2170a(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.f1637Nz;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1637Nz, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.f1639UX;
    }

    public String getHiResImageUrl() {
        return this.f1647Vi;
    }

    public Uri getIconImageUri() {
        return this.f1638UW;
    }

    public String getIconImageUrl() {
        return this.f1646Vh;
    }

    public long getLastPlayedWithTimestamp() {
        return this.f1642VC;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.f1644VE;
    }

    public String getPlayerId() {
        return this.f1648Vz;
    }

    public long getRetrievedTimestamp() {
        return this.f1640VA;
    }

    public String getTitle() {
        return this.f1636No;
    }

    public void getTitle(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1636No, dataOut);
    }

    public int getVersionCode() {
        return this.f1635BR;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return m2171b((Player) this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isProfileVisible() {
        return this.f1645VF;
    }

    /* renamed from: jR */
    public int mo6394jR() {
        return this.f1641VB;
    }

    /* renamed from: jS */
    public MostRecentGameInfo mo6395jS() {
        return this.f1643VD;
    }

    public String toString() {
        return m2174c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (!mo4427gQ()) {
            PlayerEntityCreator.m2179a(this, dest, flags);
            return;
        }
        dest.writeString(this.f1648Vz);
        dest.writeString(this.f1637Nz);
        dest.writeString(this.f1638UW == null ? null : this.f1638UW.toString());
        if (this.f1639UX != null) {
            str = this.f1639UX.toString();
        }
        dest.writeString(str);
        dest.writeLong(this.f1640VA);
    }
}
