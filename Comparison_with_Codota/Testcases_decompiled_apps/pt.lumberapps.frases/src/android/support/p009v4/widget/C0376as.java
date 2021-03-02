package android.support.p009v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p009v4.widget.NestedScrollView;

/* renamed from: android.support.v4.widget.as */
final class C0376as implements Parcelable.Creator {
    C0376as() {
    }

    /* renamed from: a */
    public NestedScrollView.SavedState createFromParcel(Parcel parcel) {
        return new NestedScrollView.SavedState(parcel);
    }

    /* renamed from: a */
    public NestedScrollView.SavedState[] newArray(int i) {
        return new NestedScrollView.SavedState[i];
    }
}
