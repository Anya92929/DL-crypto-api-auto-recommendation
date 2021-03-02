package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0437eg;
import com.google.android.gms.internal.C0487en;

public final class GameEntity extends C0487en implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new C0171a();

    /* renamed from: iM */
    private final int f448iM;

    /* renamed from: mk */
    private final String f449mk;

    /* renamed from: ml */
    private final String f450ml;

    /* renamed from: mm */
    private final String f451mm;

    /* renamed from: mn */
    private final String f452mn;

    /* renamed from: mo */
    private final String f453mo;

    /* renamed from: mp */
    private final String f454mp;

    /* renamed from: mq */
    private final Uri f455mq;

    /* renamed from: mr */
    private final Uri f456mr;

    /* renamed from: ms */
    private final Uri f457ms;

    /* renamed from: mt */
    private final boolean f458mt;

    /* renamed from: mu */
    private final boolean f459mu;

    /* renamed from: mv */
    private final String f460mv;

    /* renamed from: mw */
    private final int f461mw;

    /* renamed from: mx */
    private final int f462mx;

    /* renamed from: my */
    private final int f463my;

    /* renamed from: com.google.android.gms.games.GameEntity$a */
    static final class C0171a extends C0174a {
        C0171a() {
        }

        /* renamed from: t */
        public GameEntity createFromParcel(Parcel parcel) {
            if (GameEntity.m1237c(GameEntity.m836aW()) || GameEntity.m837y(GameEntity.class.getCanonicalName())) {
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
            return new GameEntity(1, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString9 == null ? null : Uri.parse(readString9), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount) {
        this.f448iM = versionCode;
        this.f449mk = applicationId;
        this.f450ml = displayName;
        this.f451mm = primaryCategory;
        this.f452mn = secondaryCategory;
        this.f453mo = description;
        this.f454mp = developerName;
        this.f455mq = iconImageUri;
        this.f456mr = hiResImageUri;
        this.f457ms = featuredImageUri;
        this.f458mt = playEnabledGame;
        this.f459mu = instanceInstalled;
        this.f460mv = instancePackageName;
        this.f461mw = gameplayAclStatus;
        this.f462mx = achievementTotalCount;
        this.f463my = leaderboardCount;
    }

    public GameEntity(Game game) {
        this.f448iM = 1;
        this.f449mk = game.getApplicationId();
        this.f451mm = game.getPrimaryCategory();
        this.f452mn = game.getSecondaryCategory();
        this.f453mo = game.getDescription();
        this.f454mp = game.getDeveloperName();
        this.f450ml = game.getDisplayName();
        this.f455mq = game.getIconImageUri();
        this.f456mr = game.getHiResImageUri();
        this.f457ms = game.getFeaturedImageUri();
        this.f458mt = game.isPlayEnabledGame();
        this.f459mu = game.isInstanceInstalled();
        this.f460mv = game.getInstancePackageName();
        this.f461mw = game.getGameplayAclStatus();
        this.f462mx = game.getAchievementTotalCount();
        this.f463my = game.getLeaderboardCount();
    }

    /* renamed from: a */
    static int m384a(Game game) {
        return C0408dl.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.isPlayEnabledGame()), Boolean.valueOf(game.isInstanceInstalled()), game.getInstancePackageName(), Integer.valueOf(game.getGameplayAclStatus()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()));
    }

    /* renamed from: a */
    static boolean m385a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        return C0408dl.equal(game2.getApplicationId(), game.getApplicationId()) && C0408dl.equal(game2.getDisplayName(), game.getDisplayName()) && C0408dl.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && C0408dl.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && C0408dl.equal(game2.getDescription(), game.getDescription()) && C0408dl.equal(game2.getDeveloperName(), game.getDeveloperName()) && C0408dl.equal(game2.getIconImageUri(), game.getIconImageUri()) && C0408dl.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && C0408dl.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && C0408dl.equal(Boolean.valueOf(game2.isPlayEnabledGame()), Boolean.valueOf(game.isPlayEnabledGame())) && C0408dl.equal(Boolean.valueOf(game2.isInstanceInstalled()), Boolean.valueOf(game.isInstanceInstalled())) && C0408dl.equal(game2.getInstancePackageName(), game.getInstancePackageName()) && C0408dl.equal(Integer.valueOf(game2.getGameplayAclStatus()), Integer.valueOf(game.getGameplayAclStatus())) && C0408dl.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && C0408dl.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount()));
    }

    /* renamed from: b */
    static String m386b(Game game) {
        return C0408dl.m938d(game).mo4388a("ApplicationId", game.getApplicationId()).mo4388a("DisplayName", game.getDisplayName()).mo4388a("PrimaryCategory", game.getPrimaryCategory()).mo4388a("SecondaryCategory", game.getSecondaryCategory()).mo4388a("Description", game.getDescription()).mo4388a("DeveloperName", game.getDeveloperName()).mo4388a("IconImageUri", game.getIconImageUri()).mo4388a("HiResImageUri", game.getHiResImageUri()).mo4388a("FeaturedImageUri", game.getFeaturedImageUri()).mo4388a("PlayEnabledGame", Boolean.valueOf(game.isPlayEnabledGame())).mo4388a("InstanceInstalled", Boolean.valueOf(game.isInstanceInstalled())).mo4388a("InstancePackageName", game.getInstancePackageName()).mo4388a("GameplayAclStatus", Integer.valueOf(game.getGameplayAclStatus())).mo4388a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).mo4388a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m385a(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.f462mx;
    }

    public String getApplicationId() {
        return this.f449mk;
    }

    public String getDescription() {
        return this.f453mo;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C0437eg.m1081b(this.f453mo, dataOut);
    }

    public String getDeveloperName() {
        return this.f454mp;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        C0437eg.m1081b(this.f454mp, dataOut);
    }

    public String getDisplayName() {
        return this.f450ml;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C0437eg.m1081b(this.f450ml, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.f457ms;
    }

    public int getGameplayAclStatus() {
        return this.f461mw;
    }

    public Uri getHiResImageUri() {
        return this.f456mr;
    }

    public Uri getIconImageUri() {
        return this.f455mq;
    }

    public String getInstancePackageName() {
        return this.f460mv;
    }

    public int getLeaderboardCount() {
        return this.f463my;
    }

    public String getPrimaryCategory() {
        return this.f451mm;
    }

    public String getSecondaryCategory() {
        return this.f452mn;
    }

    public int getVersionCode() {
        return this.f448iM;
    }

    public int hashCode() {
        return m384a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isInstanceInstalled() {
        return this.f459mu;
    }

    public boolean isPlayEnabledGame() {
        return this.f458mt;
    }

    public String toString() {
        return m386b((Game) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (!mo4323aX()) {
            C0174a.m397a(this, dest, flags);
            return;
        }
        dest.writeString(this.f449mk);
        dest.writeString(this.f450ml);
        dest.writeString(this.f451mm);
        dest.writeString(this.f452mn);
        dest.writeString(this.f453mo);
        dest.writeString(this.f454mp);
        dest.writeString(this.f455mq == null ? null : this.f455mq.toString());
        dest.writeString(this.f456mr == null ? null : this.f456mr.toString());
        if (this.f457ms != null) {
            str = this.f457ms.toString();
        }
        dest.writeString(str);
        dest.writeInt(this.f458mt ? 1 : 0);
        if (!this.f459mu) {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeString(this.f460mv);
        dest.writeInt(this.f461mw);
        dest.writeInt(this.f462mx);
        dest.writeInt(this.f463my);
    }
}
