package android.support.p021v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p021v7.widget.SearchView;

/* renamed from: android.support.v7.widget.df */
final class C0662df implements Parcelable.Creator {
    C0662df() {
    }

    /* renamed from: a */
    public SearchView.SavedState createFromParcel(Parcel parcel) {
        return new SearchView.SavedState(parcel);
    }

    /* renamed from: a */
    public SearchView.SavedState[] newArray(int i) {
        return new SearchView.SavedState[i];
    }
}
