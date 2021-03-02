package android.support.p021v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p021v7.widget.Toolbar;

/* renamed from: android.support.v7.widget.du */
final class C0677du implements Parcelable.Creator {
    C0677du() {
    }

    /* renamed from: a */
    public Toolbar.SavedState createFromParcel(Parcel parcel) {
        return new Toolbar.SavedState(parcel);
    }

    /* renamed from: a */
    public Toolbar.SavedState[] newArray(int i) {
        return new Toolbar.SavedState[i];
    }
}
