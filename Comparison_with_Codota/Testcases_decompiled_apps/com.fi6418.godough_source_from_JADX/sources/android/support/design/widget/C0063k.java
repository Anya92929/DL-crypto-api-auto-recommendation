package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;

/* renamed from: android.support.design.widget.k */
final class C0063k implements Parcelable.Creator<CoordinatorLayout.SavedState> {
    C0063k() {
    }

    /* renamed from: a */
    public CoordinatorLayout.SavedState createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.SavedState(parcel);
    }

    /* renamed from: a */
    public CoordinatorLayout.SavedState[] newArray(int i) {
        return new CoordinatorLayout.SavedState[i];
    }
}
