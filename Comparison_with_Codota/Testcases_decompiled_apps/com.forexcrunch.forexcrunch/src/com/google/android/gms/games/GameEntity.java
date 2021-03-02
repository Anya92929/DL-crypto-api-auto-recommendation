package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.C0423ao;
import com.google.android.gms.internal.C0473av;
import com.google.android.gms.internal.C0618r;

public final class GameEntity extends C0473av implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new C0375a();

    /* renamed from: ab */
    private final int f874ab;

    /* renamed from: cl */
    private final String f875cl;

    /* renamed from: df */
    private final String f876df;

    /* renamed from: dg */
    private final String f877dg;

    /* renamed from: dh */
    private final String f878dh;

    /* renamed from: di */
    private final String f879di;

    /* renamed from: dj */
    private final String f880dj;

    /* renamed from: dk */
    private final Uri f881dk;

    /* renamed from: dl */
    private final Uri f882dl;

    /* renamed from: dm */
    private final Uri f883dm;

    /* renamed from: dn */
    private final boolean f884dn;

    /* renamed from: do */
    private final boolean f885do;

    /* renamed from: dp */
    private final String f886dp;

    /* renamed from: dq */
    private final int f887dq;

    /* renamed from: dr */
    private final int f888dr;

    /* renamed from: ds */
    private final int f889ds;

    /* renamed from: com.google.android.gms.games.GameEntity$a */
    static final class C0375a extends C0378a {
        C0375a() {
        }

        /* renamed from: n */
        public GameEntity createFromParcel(Parcel parcel) {
            if (GameEntity.m1060c(GameEntity.m1785v()) || GameEntity.m1783h(GameEntity.class.getCanonicalName())) {
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
        this.f874ab = versionCode;
        this.f876df = applicationId;
        this.f875cl = displayName;
        this.f877dg = primaryCategory;
        this.f878dh = secondaryCategory;
        this.f879di = description;
        this.f880dj = developerName;
        this.f881dk = iconImageUri;
        this.f882dl = hiResImageUri;
        this.f883dm = featuredImageUri;
        this.f884dn = playEnabledGame;
        this.f885do = instanceInstalled;
        this.f886dp = instancePackageName;
        this.f887dq = gameplayAclStatus;
        this.f888dr = achievementTotalCount;
        this.f889ds = leaderboardCount;
    }

    public GameEntity(Game game) {
        this.f874ab = 1;
        this.f876df = game.getApplicationId();
        this.f877dg = game.getPrimaryCategory();
        this.f878dh = game.getSecondaryCategory();
        this.f879di = game.getDescription();
        this.f880dj = game.getDeveloperName();
        this.f875cl = game.getDisplayName();
        this.f881dk = game.getIconImageUri();
        this.f882dl = game.getHiResImageUri();
        this.f883dm = game.getFeaturedImageUri();
        this.f884dn = game.isPlayEnabledGame();
        this.f885do = game.isInstanceInstalled();
        this.f886dp = game.getInstancePackageName();
        this.f887dq = game.getGameplayAclStatus();
        this.f888dr = game.getAchievementTotalCount();
        this.f889ds = game.getLeaderboardCount();
    }

    /* renamed from: a */
    static int m706a(Game game) {
        return C0618r.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.isPlayEnabledGame()), Boolean.valueOf(game.isInstanceInstalled()), game.getInstancePackageName(), Integer.valueOf(game.getGameplayAclStatus()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()));
    }

    /* renamed from: a */
    static boolean m707a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        return C0618r.m1881a(game2.getApplicationId(), game.getApplicationId()) && C0618r.m1881a(game2.getDisplayName(), game.getDisplayName()) && C0618r.m1881a(game2.getPrimaryCategory(), game.getPrimaryCategory()) && C0618r.m1881a(game2.getSecondaryCategory(), game.getSecondaryCategory()) && C0618r.m1881a(game2.getDescription(), game.getDescription()) && C0618r.m1881a(game2.getDeveloperName(), game.getDeveloperName()) && C0618r.m1881a(game2.getIconImageUri(), game.getIconImageUri()) && C0618r.m1881a(game2.getHiResImageUri(), game.getHiResImageUri()) && C0618r.m1881a(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && C0618r.m1881a(Boolean.valueOf(game2.isPlayEnabledGame()), Boolean.valueOf(game.isPlayEnabledGame())) && C0618r.m1881a(Boolean.valueOf(game2.isInstanceInstalled()), Boolean.valueOf(game.isInstanceInstalled())) && C0618r.m1881a(game2.getInstancePackageName(), game.getInstancePackageName()) && C0618r.m1881a(Integer.valueOf(game2.getGameplayAclStatus()), Integer.valueOf(game.getGameplayAclStatus())) && C0618r.m1881a(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && C0618r.m1881a(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount()));
    }

    /* renamed from: b */
    static String m709b(Game game) {
        return C0618r.m1882c(game).mo5486a("ApplicationId", game.getApplicationId()).mo5486a("DisplayName", game.getDisplayName()).mo5486a("PrimaryCategory", game.getPrimaryCategory()).mo5486a("SecondaryCategory", game.getSecondaryCategory()).mo5486a("Description", game.getDescription()).mo5486a("DeveloperName", game.getDeveloperName()).mo5486a("IconImageUri", game.getIconImageUri()).mo5486a("HiResImageUri", game.getHiResImageUri()).mo5486a("FeaturedImageUri", game.getFeaturedImageUri()).mo5486a("PlayEnabledGame", Boolean.valueOf(game.isPlayEnabledGame())).mo5486a("InstanceInstalled", Boolean.valueOf(game.isInstanceInstalled())).mo5486a("InstancePackageName", game.getInstancePackageName()).mo5486a("GameplayAclStatus", Integer.valueOf(game.getGameplayAclStatus())).mo5486a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).mo5486a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m707a(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.f888dr;
    }

    public String getApplicationId() {
        return this.f876df;
    }

    public String getDescription() {
        return this.f879di;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C0423ao.m905b(this.f879di, dataOut);
    }

    public String getDeveloperName() {
        return this.f880dj;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        C0423ao.m905b(this.f880dj, dataOut);
    }

    public String getDisplayName() {
        return this.f875cl;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C0423ao.m905b(this.f875cl, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.f883dm;
    }

    public int getGameplayAclStatus() {
        return this.f887dq;
    }

    public Uri getHiResImageUri() {
        return this.f882dl;
    }

    public Uri getIconImageUri() {
        return this.f881dk;
    }

    public String getInstancePackageName() {
        return this.f886dp;
    }

    public int getLeaderboardCount() {
        return this.f889ds;
    }

    public String getPrimaryCategory() {
        return this.f877dg;
    }

    public String getSecondaryCategory() {
        return this.f878dh;
    }

    public int hashCode() {
        return m706a(this);
    }

    /* renamed from: i */
    public int mo4155i() {
        return this.f874ab;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isInstanceInstalled() {
        return this.f885do;
    }

    public boolean isPlayEnabledGame() {
        return this.f884dn;
    }

    public String toString() {
        return m709b((Game) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (!mo5427w()) {
            C0378a.m722a(this, dest, flags);
            return;
        }
        dest.writeString(this.f876df);
        dest.writeString(this.f875cl);
        dest.writeString(this.f877dg);
        dest.writeString(this.f878dh);
        dest.writeString(this.f879di);
        dest.writeString(this.f880dj);
        dest.writeString(this.f881dk == null ? null : this.f881dk.toString());
        dest.writeString(this.f882dl == null ? null : this.f882dl.toString());
        if (this.f883dm != null) {
            str = this.f883dm.toString();
        }
        dest.writeString(str);
        dest.writeInt(this.f884dn ? 1 : 0);
        if (!this.f885do) {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeString(this.f886dp);
        dest.writeInt(this.f887dq);
        dest.writeInt(this.f888dr);
        dest.writeInt(this.f889ds);
    }
}
