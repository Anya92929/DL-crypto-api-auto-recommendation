package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;

public final class MostRecentGameInfoRef extends C0297d implements MostRecentGameInfo {

    /* renamed from: VN */
    private final PlayerColumnNames f2342VN;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.f2342VN = columnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.m3612a(this, obj);
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.m3611a(this);
    }

    /* renamed from: ln */
    public String mo7409ln() {
        return getString(this.f2342VN.aba);
    }

    /* renamed from: lo */
    public String mo7410lo() {
        return getString(this.f2342VN.abb);
    }

    /* renamed from: lp */
    public long mo7411lp() {
        return getLong(this.f2342VN.abc);
    }

    /* renamed from: lq */
    public Uri mo7412lq() {
        return mo4338aR(this.f2342VN.abd);
    }

    /* renamed from: lr */
    public Uri mo7413lr() {
        return mo4338aR(this.f2342VN.abe);
    }

    /* renamed from: ls */
    public Uri mo7414ls() {
        return mo4338aR(this.f2342VN.abf);
    }

    /* renamed from: lt */
    public MostRecentGameInfo freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.m3613b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) freeze()).writeToParcel(dest, flags);
    }
}
