package com.jeremyfeinstein.slidingmenu.lib;

import android.os.Parcel;
import android.os.Parcelable;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.q */
final class C2006q implements Parcelable.Creator {
    C2006q() {
    }

    /* renamed from: a */
    public SlidingMenu.SavedState createFromParcel(Parcel parcel) {
        return new SlidingMenu.SavedState(parcel, (C1999j) null);
    }

    /* renamed from: a */
    public SlidingMenu.SavedState[] newArray(int i) {
        return new SlidingMenu.SavedState[i];
    }
}
