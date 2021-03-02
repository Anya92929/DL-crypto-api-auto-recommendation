package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;

/* renamed from: nl.volkerinfradesign.checkandroid.background.PictureInput */
class PictureInput implements Parcelable {
    public static final Parcelable.Creator<PictureInput> CREATOR = new Parcelable.Creator<PictureInput>() {
        /* renamed from: a */
        public PictureInput createFromParcel(Parcel parcel) {
            return new PictureInput(parcel);
        }

        /* renamed from: a */
        public PictureInput[] newArray(int i) {
            return new PictureInput[i];
        }
    };

    /* renamed from: a */
    private int f4689a;

    /* renamed from: b */
    private final Hashtable<Long, Set<Long>> f4690b;

    /* renamed from: c */
    private final int f4691c;

    private PictureInput(Parcel parcel) {
        this.f4689a = 0;
        this.f4690b = new Hashtable<>();
        this.f4691c = parcel.readInt();
        this.f4689a = parcel.readInt();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            HashSet hashSet = new HashSet();
            long readLong = parcel.readLong();
            long[] jArr = new long[parcel.readInt()];
            parcel.readLongArray(jArr);
            Collections.addAll(hashSet, ArrayUtils.toObject(jArr));
            this.f4690b.put(Long.valueOf(readLong), hashSet);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4691c);
        parcel.writeInt(this.f4689a);
        parcel.writeInt(this.f4690b.size());
        for (Map.Entry next : this.f4690b.entrySet()) {
            Long[] lArr = (Long[]) ((Set) next.getValue()).toArray(new Long[((Set) next.getValue()).size()]);
            parcel.writeLong(((Long) next.getKey()).longValue());
            parcel.writeInt(lArr.length);
            parcel.writeLongArray(ArrayUtils.toPrimitive(lArr));
        }
    }
}
