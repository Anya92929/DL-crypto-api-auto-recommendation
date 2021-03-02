package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PlayerLevel implements SafeParcelable {
    public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();

    /* renamed from: BR */
    private final int f1649BR;

    /* renamed from: VG */
    private final int f1650VG;

    /* renamed from: VH */
    private final long f1651VH;

    /* renamed from: VI */
    private final long f1652VI;

    PlayerLevel(int versionCode, int levelNumber, long minXp, long maxXp) {
        boolean z = true;
        C0348n.m852a(minXp >= 0, "Min XP must be positive!");
        C0348n.m852a(maxXp <= minXp ? false : z, "Max XP must be more than min XP!");
        this.f1649BR = versionCode;
        this.f1650VG = levelNumber;
        this.f1651VH = minXp;
        this.f1652VI = maxXp;
    }

    public PlayerLevel(int value, long minXp, long maxXp) {
        this(1, value, minXp, maxXp);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return C0345m.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && C0345m.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && C0345m.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.f1650VG;
    }

    public long getMaxXp() {
        return this.f1652VI;
    }

    public long getMinXp() {
        return this.f1651VH;
    }

    public int getVersionCode() {
        return this.f1649BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f1650VG), Long.valueOf(this.f1651VH), Long.valueOf(this.f1652VI));
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("LevelNumber", Integer.valueOf(getLevelNumber())).mo4549a("MinXp", Long.valueOf(getMinXp())).mo4549a("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelCreator.m2182a(this, out, flags);
    }
}
