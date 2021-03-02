package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.app.FragmentManagerState */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };

    /* renamed from: a */
    FragmentState[] f479a;

    /* renamed from: b */
    int[] f480b;

    /* renamed from: c */
    BackStackState[] f481c;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.f479a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f480b = parcel.createIntArray();
        this.f481c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f479a, i);
        parcel.writeIntArray(this.f480b);
        parcel.writeTypedArray(this.f481c, i);
    }
}
