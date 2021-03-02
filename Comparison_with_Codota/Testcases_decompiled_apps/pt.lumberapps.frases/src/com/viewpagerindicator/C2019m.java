package com.viewpagerindicator;

import android.os.Parcel;
import android.os.Parcelable;
import com.viewpagerindicator.TitlePageIndicator;

/* renamed from: com.viewpagerindicator.m */
final class C2019m implements Parcelable.Creator {
    C2019m() {
    }

    /* renamed from: a */
    public TitlePageIndicator.SavedState createFromParcel(Parcel parcel) {
        return new TitlePageIndicator.SavedState(parcel, (C2015i) null);
    }

    /* renamed from: a */
    public TitlePageIndicator.SavedState[] newArray(int i) {
        return new TitlePageIndicator.SavedState[i];
    }
}
