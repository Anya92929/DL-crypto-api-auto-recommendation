package p006nl.volkerinfradesign.checkandroid.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.util.LongSparseArray;

/* renamed from: nl.volkerinfradesign.checkandroid.util.LongSparseBooleanArray */
public class LongSparseBooleanArray extends LongSparseArray<Boolean> implements Parcelable {
    public static final Parcelable.Creator<LongSparseBooleanArray> CREATOR = new Parcelable.Creator<LongSparseBooleanArray>() {
        /* renamed from: a */
        public LongSparseBooleanArray createFromParcel(Parcel parcel) {
            return new LongSparseBooleanArray(parcel);
        }

        /* renamed from: a */
        public LongSparseBooleanArray[] newArray(int i) {
            return new LongSparseBooleanArray[i];
        }
    };

    public LongSparseBooleanArray() {
    }

    public LongSparseBooleanArray(int i) {
        super(i);
    }

    private LongSparseBooleanArray(Parcel parcel) {
        boolean z;
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            long readLong = parcel.readLong();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            put(readLong, Boolean.valueOf(z));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Boolean bool = (Boolean) valueAt(i2);
            if (bool != null) {
                parcel.writeLong(keyAt(i2));
                parcel.writeInt(bool.booleanValue() ? 1 : 0);
            }
        }
    }
}
