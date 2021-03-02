package android.support.p009v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p009v4.widget.DrawerLayout;

/* renamed from: android.support.v4.widget.z */
final class C0425z implements Parcelable.Creator {
    C0425z() {
    }

    /* renamed from: a */
    public DrawerLayout.SavedState createFromParcel(Parcel parcel) {
        return new DrawerLayout.SavedState(parcel);
    }

    /* renamed from: a */
    public DrawerLayout.SavedState[] newArray(int i) {
        return new DrawerLayout.SavedState[i];
    }
}
