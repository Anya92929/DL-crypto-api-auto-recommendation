package p006nl.volkerinfradesign.checkandroid.database;

import android.os.Parcel;
import android.os.Parcelable;
import p006nl.volkerinfradesign.checkandroid.environments.UpdateResult;

/* renamed from: nl.volkerinfradesign.checkandroid.database.UpdateResultImp */
class UpdateResultImp implements UpdateResult {
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
    private final boolean f4879a;

    /* renamed from: b */
    private final Exception f4880b;

    UpdateResultImp(boolean z, Exception exc) {
        this.f4879a = z;
        this.f4880b = exc;
    }

    private UpdateResultImp(Parcel parcel) {
        this.f4879a = parcel.readInt() == 1;
        this.f4880b = (Exception) (parcel.readInt() == 1 ? parcel.readSerializable() : null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4879a ? 1 : 0);
        if (this.f4880b != null) {
            parcel.writeInt(1);
            parcel.writeSerializable(this.f4880b);
            return;
        }
        parcel.writeInt(0);
    }

    public boolean isSuccess() {
        return this.f4879a;
    }

    public Exception getError() {
        return this.f4880b;
    }
}
