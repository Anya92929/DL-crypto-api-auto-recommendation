package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;

/* renamed from: android.support.design.widget.d */
final class C0056d implements Parcelable.Creator<AppBarLayout.Behavior.SavedState> {
    C0056d() {
    }

    /* renamed from: a */
    public AppBarLayout.Behavior.SavedState createFromParcel(Parcel parcel) {
        return new AppBarLayout.Behavior.SavedState(parcel);
    }

    /* renamed from: a */
    public AppBarLayout.Behavior.SavedState[] newArray(int i) {
        return new AppBarLayout.Behavior.SavedState[i];
    }
}
