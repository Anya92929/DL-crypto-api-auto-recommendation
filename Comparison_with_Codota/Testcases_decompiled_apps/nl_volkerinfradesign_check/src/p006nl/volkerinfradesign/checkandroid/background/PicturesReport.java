package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

/* renamed from: nl.volkerinfradesign.checkandroid.background.PicturesReport */
public class PicturesReport implements Parcelable, Iterable<ReportEntry> {
    public static final Parcelable.Creator<PicturesReport> CREATOR = new Parcelable.Creator<PicturesReport>() {
        /* renamed from: a */
        public PicturesReport createFromParcel(Parcel parcel) {
            return new PicturesReport(parcel);
        }

        /* renamed from: a */
        public PicturesReport[] newArray(int i) {
            return new PicturesReport[i];
        }
    };

    /* renamed from: a */
    final Exception f4693a;

    /* renamed from: b */
    final LongSparseArray<ArrayList<PictureReport>> f4694b;

    /* renamed from: nl.volkerinfradesign.checkandroid.background.PicturesReport$ReportEntry */
    public interface ReportEntry {
        long getInspectionId();

        List<PictureReport> getResponses();
    }

    PicturesReport() {
        this.f4694b = new LongSparseArray<>();
        this.f4693a = null;
    }

    private PicturesReport(Parcel parcel) {
        this.f4694b = new LongSparseArray<>();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            long readLong = parcel.readLong();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i2 = 0; i2 < readInt2; i2++) {
                arrayList.add((PictureReport) parcel.readParcelable((ClassLoader) null));
            }
            this.f4694b.put(readLong, arrayList);
        }
        if (parcel.readInt() == 1) {
            this.f4693a = (Exception) parcel.readSerializable();
        } else {
            this.f4693a = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public long[] getInspectionIds() {
        long[] jArr = new long[this.f4694b.size()];
        for (int i = 0; i < this.f4694b.size(); i++) {
            jArr[i] = this.f4694b.keyAt(i);
        }
        return jArr;
    }

    public long[] getPictureIds() {
        HashSet hashSet = new HashSet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4694b.size()) {
                return ArrayUtils.toPrimitive((Long[]) hashSet.toArray(new Long[hashSet.size()]));
            }
            Iterator it = this.f4694b.valueAt(i2).iterator();
            while (it.hasNext()) {
                PictureReport pictureReport = (PictureReport) it.next();
                if (pictureReport.isUploaded()) {
                    hashSet.add(Long.valueOf(pictureReport.pictureId));
                }
            }
            i = i2 + 1;
        }
    }

    public Iterator<ReportEntry> iterator() {
        return new Iterator<ReportEntry>() {

            /* renamed from: b */
            private final ReportEntry f4696b = new ReportEntry() {
                public long getInspectionId() {
                    return PicturesReport.this.f4694b.keyAt(C13722.this.f4697c);
                }

                public List<PictureReport> getResponses() {
                    return Collections.unmodifiableList(PicturesReport.this.f4694b.valueAt(C13722.this.f4697c));
                }
            };
            /* access modifiers changed from: private */

            /* renamed from: c */
            public int f4697c = -1;

            public boolean hasNext() {
                int i = this.f4697c + 1;
                this.f4697c = i;
                return i < PicturesReport.this.f4694b.size();
            }

            /* renamed from: a */
            public ReportEntry next() {
                return this.f4696b;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = this.f4694b.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            List<PictureReport> valueAt = this.f4694b.valueAt(i2);
            parcel.writeLong(this.f4694b.keyAt(i2));
            parcel.writeInt(valueAt.size());
            for (PictureReport writeParcelable : valueAt) {
                parcel.writeParcelable(writeParcelable, i);
            }
        }
        if (this.f4693a != null) {
            parcel.writeInt(1);
            parcel.writeSerializable(this.f4693a);
            return;
        }
        parcel.writeInt(0);
    }
}
