package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends C0297d implements Player {

    /* renamed from: VE */
    private final PlayerLevelInfo f1658VE;

    /* renamed from: VN */
    private final PlayerColumnNames f1659VN;

    /* renamed from: VO */
    private final MostRecentGameInfoRef f1660VO;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, (String) null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        PlayerLevel playerLevel;
        this.f1659VN = new PlayerColumnNames(prefix);
        this.f1660VO = new MostRecentGameInfoRef(holder, dataRow, this.f1659VN);
        if (m2184jT()) {
            int integer = getInteger(this.f1659VN.aaR);
            int integer2 = getInteger(this.f1659VN.aaU);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.f1659VN.aaS), getLong(this.f1659VN.aaT));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.f1659VN.aaT), getLong(this.f1659VN.aaV));
            } else {
                playerLevel = playerLevel2;
            }
            this.f1658VE = new PlayerLevelInfo(getLong(this.f1659VN.aaQ), getLong(this.f1659VN.aaW), playerLevel2, playerLevel);
            return;
        }
        this.f1658VE = null;
    }

    /* renamed from: jT */
    private boolean m2184jT() {
        return !mo4339aS(this.f1659VN.aaQ) && getLong(this.f1659VN.aaQ) != -1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.m2170a(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString(this.f1659VN.aaI);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo4336a(this.f1659VN.aaI, dataOut);
    }

    public Uri getHiResImageUri() {
        return mo4338aR(this.f1659VN.aaL);
    }

    public String getHiResImageUrl() {
        return getString(this.f1659VN.aaM);
    }

    public Uri getIconImageUri() {
        return mo4338aR(this.f1659VN.aaJ);
    }

    public String getIconImageUrl() {
        return getString(this.f1659VN.aaK);
    }

    public long getLastPlayedWithTimestamp() {
        if (!mo4337aQ(this.f1659VN.aaP) || mo4339aS(this.f1659VN.aaP)) {
            return -1;
        }
        return getLong(this.f1659VN.aaP);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.f1658VE;
    }

    public String getPlayerId() {
        return getString(this.f1659VN.aaH);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.f1659VN.aaN);
    }

    public String getTitle() {
        return getString(this.f1659VN.aaX);
    }

    public void getTitle(CharArrayBuffer dataOut) {
        mo4336a(this.f1659VN.aaX, dataOut);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.m2171b((Player) this);
    }

    public boolean isProfileVisible() {
        return getBoolean(this.f1659VN.aaZ);
    }

    /* renamed from: jR */
    public int mo6394jR() {
        return getInteger(this.f1659VN.aaO);
    }

    /* renamed from: jS */
    public MostRecentGameInfo mo6395jS() {
        if (mo4339aS(this.f1659VN.aba)) {
            return null;
        }
        return this.f1660VO;
    }

    public String toString() {
        return PlayerEntity.m2174c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }
}
