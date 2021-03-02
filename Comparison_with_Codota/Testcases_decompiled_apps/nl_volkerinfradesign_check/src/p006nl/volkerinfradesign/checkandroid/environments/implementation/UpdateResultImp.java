package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.os.Parcel;
import android.os.Parcelable;
import p006nl.volkerinfradesign.checkandroid.environments.UpdateResult;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.UpdateResultImp */
public class UpdateResultImp implements UpdateResult {
    public static final Parcelable.Creator<UpdateResultImp> CREATOR = new Parcelable.Creator<UpdateResultImp>() {
        /* renamed from: a */
        public UpdateResultImp[] newArray(int i) {
            return new UpdateResultImp[i];
        }

        /* renamed from: a */
        public UpdateResultImp createFromParcel(Parcel parcel) {
            return new UpdateResultImp(parcel);
        }
    };

    /* renamed from: a */
    private final boolean f4934a;

    /* renamed from: b */
    private final Exception f4935b;

    public UpdateResultImp(boolean z, Exception exc) {
        this.f4934a = z;
        this.f4935b = exc;
    }

    private UpdateResultImp(Parcel parcel) {
        this.f4934a = parcel.readInt() == 1;
        this.f4935b = (Exception) (parcel.readInt() == 1 ? parcel.readSerializable() : null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4934a ? 1 : 0);
        if (this.f4935b != null) {
            parcel.writeInt(1);
            parcel.writeSerializable(this.f4935b);
            return;
        }
        parcel.writeInt(0);
    }

    public boolean isSuccess() {
        return this.f4934a;
    }

    public Exception getError() {
        return this.f4935b;
    }
}
