package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();

    /* renamed from: BR */
    private final int f2341BR;
    private final String aaB;
    private final String aaC;
    private final long aaD;
    private final Uri aaE;
    private final Uri aaF;
    private final Uri aaG;

    MostRecentGameInfoEntity(int versionCode, String gameId, String gameName, long activityTimestampMillis, Uri gameIconImageUri, Uri gameHiResIconImageUri, Uri gameFeaturedImageUri) {
        this.f2341BR = versionCode;
        this.aaB = gameId;
        this.aaC = gameName;
        this.aaD = activityTimestampMillis;
        this.aaE = gameIconImageUri;
        this.aaF = gameHiResIconImageUri;
        this.aaG = gameFeaturedImageUri;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo info) {
        this.f2341BR = 2;
        this.aaB = info.mo7409ln();
        this.aaC = info.mo7410lo();
        this.aaD = info.mo7411lp();
        this.aaE = info.mo7412lq();
        this.aaF = info.mo7413lr();
        this.aaG = info.mo7414ls();
    }

    /* renamed from: a */
    static int m3611a(MostRecentGameInfo mostRecentGameInfo) {
        return C0345m.hashCode(mostRecentGameInfo.mo7409ln(), mostRecentGameInfo.mo7410lo(), Long.valueOf(mostRecentGameInfo.mo7411lp()), mostRecentGameInfo.mo7412lq(), mostRecentGameInfo.mo7413lr(), mostRecentGameInfo.mo7414ls());
    }

    /* renamed from: a */
    static boolean m3612a(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return C0345m.equal(mostRecentGameInfo2.mo7409ln(), mostRecentGameInfo.mo7409ln()) && C0345m.equal(mostRecentGameInfo2.mo7410lo(), mostRecentGameInfo.mo7410lo()) && C0345m.equal(Long.valueOf(mostRecentGameInfo2.mo7411lp()), Long.valueOf(mostRecentGameInfo.mo7411lp())) && C0345m.equal(mostRecentGameInfo2.mo7412lq(), mostRecentGameInfo.mo7412lq()) && C0345m.equal(mostRecentGameInfo2.mo7413lr(), mostRecentGameInfo.mo7413lr()) && C0345m.equal(mostRecentGameInfo2.mo7414ls(), mostRecentGameInfo.mo7414ls());
    }

    /* renamed from: b */
    static String m3613b(MostRecentGameInfo mostRecentGameInfo) {
        return C0345m.m848h(mostRecentGameInfo).mo4549a("GameId", mostRecentGameInfo.mo7409ln()).mo4549a("GameName", mostRecentGameInfo.mo7410lo()).mo4549a("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.mo7411lp())).mo4549a("GameIconUri", mostRecentGameInfo.mo7412lq()).mo4549a("GameHiResUri", mostRecentGameInfo.mo7413lr()).mo4549a("GameFeaturedUri", mostRecentGameInfo.mo7414ls()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3612a(this, obj);
    }

    public int getVersionCode() {
        return this.f2341BR;
    }

    public int hashCode() {
        return m3611a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: ln */
    public String mo7409ln() {
        return this.aaB;
    }

    /* renamed from: lo */
    public String mo7410lo() {
        return this.aaC;
    }

    /* renamed from: lp */
    public long mo7411lp() {
        return this.aaD;
    }

    /* renamed from: lq */
    public Uri mo7412lq() {
        return this.aaE;
    }

    /* renamed from: lr */
    public Uri mo7413lr() {
        return this.aaF;
    }

    /* renamed from: ls */
    public Uri mo7414ls() {
        return this.aaG;
    }

    /* renamed from: lt */
    public MostRecentGameInfo freeze() {
        return this;
    }

    public String toString() {
        return m3613b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MostRecentGameInfoEntityCreator.m3621a(this, out, flags);
    }
}
