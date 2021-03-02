package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();

    /* renamed from: BR */
    private final int f1653BR;

    /* renamed from: VJ */
    private final long f1654VJ;

    /* renamed from: VK */
    private final long f1655VK;

    /* renamed from: VL */
    private final PlayerLevel f1656VL;

    /* renamed from: VM */
    private final PlayerLevel f1657VM;

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        C0348n.m850I(currentXpTotal != -1);
        C0348n.m861i(currentLevel);
        C0348n.m861i(nextLevel);
        this.f1653BR = versionCode;
        this.f1654VJ = currentXpTotal;
        this.f1655VK = lastLevelUpTimestamp;
        this.f1656VL = currentLevel;
        this.f1657VM = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return C0345m.equal(Long.valueOf(this.f1654VJ), Long.valueOf(playerLevelInfo.f1654VJ)) && C0345m.equal(Long.valueOf(this.f1655VK), Long.valueOf(playerLevelInfo.f1655VK)) && C0345m.equal(this.f1656VL, playerLevelInfo.f1656VL) && C0345m.equal(this.f1657VM, playerLevelInfo.f1657VM);
    }

    public PlayerLevel getCurrentLevel() {
        return this.f1656VL;
    }

    public long getCurrentXpTotal() {
        return this.f1654VJ;
    }

    public long getLastLevelUpTimestamp() {
        return this.f1655VK;
    }

    public PlayerLevel getNextLevel() {
        return this.f1657VM;
    }

    public int getVersionCode() {
        return this.f1653BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Long.valueOf(this.f1654VJ), Long.valueOf(this.f1655VK), this.f1656VL, this.f1657VM);
    }

    public boolean isMaxLevel() {
        return this.f1656VL.equals(this.f1657VM);
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.m2183a(this, out, flags);
    }
}
