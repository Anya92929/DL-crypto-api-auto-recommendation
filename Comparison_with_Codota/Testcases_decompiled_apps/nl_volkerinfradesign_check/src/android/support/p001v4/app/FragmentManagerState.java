package android.support.p001v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.app.FragmentManagerState */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: a */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };

    /* renamed from: a */
    public FragmentState[] f203a;

    /* renamed from: b */
    public int[] f204b;

    /* renamed from: c */
    public BackStackState[] f205c;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.f203a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f204b = parcel.createIntArray();
        this.f205c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f203a, i);
        parcel.writeIntArray(this.f204b);
        parcel.writeTypedArray(this.f205c, i);
    }
}
