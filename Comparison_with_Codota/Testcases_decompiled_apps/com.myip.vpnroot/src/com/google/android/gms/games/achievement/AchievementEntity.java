package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C1386jv;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final AchievementEntityCreator CREATOR = new AchievementEntityCreator();

    /* renamed from: BR */
    private final int f1661BR;

    /* renamed from: FD */
    private final int f1662FD;

    /* renamed from: Tg */
    private final String f1663Tg;

    /* renamed from: VP */
    private final String f1664VP;

    /* renamed from: VQ */
    private final Uri f1665VQ;

    /* renamed from: VR */
    private final String f1666VR;

    /* renamed from: VS */
    private final Uri f1667VS;

    /* renamed from: VT */
    private final String f1668VT;

    /* renamed from: VU */
    private final int f1669VU;

    /* renamed from: VV */
    private final String f1670VV;

    /* renamed from: VW */
    private final PlayerEntity f1671VW;

    /* renamed from: VX */
    private final int f1672VX;

    /* renamed from: VY */
    private final String f1673VY;

    /* renamed from: VZ */
    private final long f1674VZ;

    /* renamed from: Wa */
    private final long f1675Wa;
    private final String mName;
    private final int mState;

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.f1661BR = versionCode;
        this.f1664VP = achievementId;
        this.f1662FD = type;
        this.mName = name;
        this.f1663Tg = description;
        this.f1665VQ = unlockedImageUri;
        this.f1666VR = unlockedImageUrl;
        this.f1667VS = revealedImageUri;
        this.f1668VT = revealedImageUrl;
        this.f1669VU = totalSteps;
        this.f1670VV = formattedTotalSteps;
        this.f1671VW = player;
        this.mState = state;
        this.f1672VX = currentSteps;
        this.f1673VY = formattedCurrentSteps;
        this.f1674VZ = lastUpdatedTimestamp;
        this.f1675Wa = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.f1661BR = 1;
        this.f1664VP = achievement.getAchievementId();
        this.f1662FD = achievement.getType();
        this.mName = achievement.getName();
        this.f1663Tg = achievement.getDescription();
        this.f1665VQ = achievement.getUnlockedImageUri();
        this.f1666VR = achievement.getUnlockedImageUrl();
        this.f1667VS = achievement.getRevealedImageUri();
        this.f1668VT = achievement.getRevealedImageUrl();
        this.f1671VW = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.f1674VZ = achievement.getLastUpdatedTimestamp();
        this.f1675Wa = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.f1669VU = achievement.getTotalSteps();
            this.f1670VV = achievement.getFormattedTotalSteps();
            this.f1672VX = achievement.getCurrentSteps();
            this.f1673VY = achievement.getFormattedCurrentSteps();
        } else {
            this.f1669VU = 0;
            this.f1670VV = null;
            this.f1672VX = 0;
            this.f1673VY = null;
        }
        C0313a.m682f(this.f1664VP);
        C0313a.m682f(this.f1663Tg);
    }

    /* renamed from: a */
    static int m2187a(Achievement achievement) {
        int i;
        int i2;
        if (achievement.getType() == 1) {
            i2 = achievement.getCurrentSteps();
            i = achievement.getTotalSteps();
        } else {
            i = 0;
            i2 = 0;
        }
        return C0345m.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(i2), Integer.valueOf(i));
    }

    /* renamed from: a */
    static boolean m2188a(Achievement achievement, Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            z2 = C0345m.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            z = C0345m.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            z = true;
            z2 = true;
        }
        return C0345m.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && C0345m.equal(achievement2.getName(), achievement.getName()) && C0345m.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && C0345m.equal(achievement2.getDescription(), achievement.getDescription()) && C0345m.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && C0345m.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && C0345m.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && C0345m.equal(achievement2.getPlayer(), achievement.getPlayer()) && z2 && z;
    }

    /* renamed from: b */
    static String m2189b(Achievement achievement) {
        C0345m.C0347a a = C0345m.m848h(achievement).mo4549a("Id", achievement.getAchievementId()).mo4549a("Type", Integer.valueOf(achievement.getType())).mo4549a("Name", achievement.getName()).mo4549a("Description", achievement.getDescription()).mo4549a("Player", achievement.getPlayer()).mo4549a("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            a.mo4549a("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            a.mo4549a("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return a.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m2188a(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.f1664VP;
    }

    public int getCurrentSteps() {
        return this.f1672VX;
    }

    public String getDescription() {
        return this.f1663Tg;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1663Tg, dataOut);
    }

    public String getFormattedCurrentSteps() {
        return this.f1673VY;
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1673VY, dataOut);
    }

    public String getFormattedTotalSteps() {
        return this.f1670VV;
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1670VV, dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return this.f1674VZ;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.f1671VW;
    }

    public Uri getRevealedImageUri() {
        return this.f1667VS;
    }

    public String getRevealedImageUrl() {
        return this.f1668VT;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        return this.f1669VU;
    }

    public int getType() {
        return this.f1662FD;
    }

    public Uri getUnlockedImageUri() {
        return this.f1665VQ;
    }

    public String getUnlockedImageUrl() {
        return this.f1666VR;
    }

    public int getVersionCode() {
        return this.f1661BR;
    }

    public long getXpValue() {
        return this.f1675Wa;
    }

    public int hashCode() {
        return m2187a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m2189b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        AchievementEntityCreator.m2190a(this, dest, flags);
    }
}
