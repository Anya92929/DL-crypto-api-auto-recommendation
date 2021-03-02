package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef extends C0297d implements ExtendedGame {
    private final GameRef aam;
    private final SnapshotMetadataRef aay;
    private final int aaz;

    ExtendedGameRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.aam = new GameRef(holder, dataRow);
        this.aaz = numChildren;
        if (!mo4337aQ("external_snapshot_id") || mo4339aS("external_snapshot_id")) {
            this.aay = null;
        } else {
            this.aay = new SnapshotMetadataRef(holder, dataRow);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ExtendedGameEntity.m3543a(this, obj);
    }

    public Game getGame() {
        return this.aam;
    }

    public int hashCode() {
        return ExtendedGameEntity.m3542a(this);
    }

    /* renamed from: kO */
    public ArrayList<GameBadge> mo7323kO() {
        if (this.f693IC.mo4306c("badge_title", this.f694JQ, this.f693IC.mo4304ar(this.f694JQ)) == null) {
            return new ArrayList<>(0);
        }
        ArrayList<GameBadge> arrayList = new ArrayList<>(this.aaz);
        for (int i = 0; i < this.aaz; i++) {
            arrayList.add(new GameBadgeRef(this.f693IC, this.f694JQ + i));
        }
        return arrayList;
    }

    /* renamed from: kP */
    public int mo7324kP() {
        return getInteger("availability");
    }

    /* renamed from: kQ */
    public boolean mo7325kQ() {
        return getBoolean("owned");
    }

    /* renamed from: kR */
    public int mo7326kR() {
        return getInteger("achievement_unlocked_count");
    }

    /* renamed from: kS */
    public long mo7327kS() {
        return getLong("last_played_server_time");
    }

    /* renamed from: kT */
    public long mo7328kT() {
        return getLong("price_micros");
    }

    /* renamed from: kU */
    public String mo7329kU() {
        return getString("formatted_price");
    }

    /* renamed from: kV */
    public long mo7330kV() {
        return getLong("full_price_micros");
    }

    /* renamed from: kW */
    public String mo7331kW() {
        return getString("formatted_full_price");
    }

    /* renamed from: kX */
    public SnapshotMetadata mo7332kX() {
        return this.aay;
    }

    /* renamed from: kZ */
    public ExtendedGame freeze() {
        return new ExtendedGameEntity(this);
    }

    public String toString() {
        return ExtendedGameEntity.m3544b((ExtendedGame) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ExtendedGameEntity) freeze()).writeToParcel(dest, flags);
    }
}
