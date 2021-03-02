package p006nl.volkerinfradesign.checkandroid.database;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;

/* renamed from: nl.volkerinfradesign.checkandroid.database.PictureKey */
public final class PictureKey implements Parcelable {
    public static final Parcelable.Creator<PictureKey> CREATOR = new Parcelable.Creator<PictureKey>() {
        /* renamed from: a */
        public PictureKey createFromParcel(Parcel parcel) {
            return new PictureKey(parcel);
        }

        /* renamed from: a */
        public PictureKey[] newArray(int i) {
            return new PictureKey[i];
        }
    };

    /* renamed from: a */
    final File f4841a;

    /* renamed from: b */
    final boolean f4842b;

    /* renamed from: c */
    final long f4843c;

    /* renamed from: d */
    final long f4844d;

    /* renamed from: e */
    final long f4845e;

    /* renamed from: f */
    final long f4846f;

    public static PictureKey newInstance(C1225hy hyVar, File file) {
        return Schema.m5981a().f4866j.get(hyVar, file);
    }

    PictureKey(InspectionItemConstants.ItemCursor itemCursor, long j, File file, boolean z) {
        this(itemCursor.getId(), itemCursor.getInspectionId(), itemCursor.getRootInspectionId(), j, file, z);
    }

    PictureKey(long j, long j2, long j3, long j4, File file, boolean z) {
        this.f4843c = j;
        this.f4844d = j2;
        this.f4845e = j3;
        this.f4846f = j4;
        this.f4841a = file;
        this.f4842b = z;
    }

    PictureKey(Parcel parcel) {
        this.f4843c = parcel.readLong();
        this.f4844d = parcel.readLong();
        this.f4845e = parcel.readLong();
        this.f4846f = parcel.readLong();
        this.f4841a = (File) parcel.readSerializable();
        this.f4842b = parcel.readInt() > 0;
    }

    public boolean delete() {
        return Schema.getPictures().delete(this);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4843c);
        parcel.writeLong(this.f4844d);
        parcel.writeLong(this.f4845e);
        parcel.writeLong(this.f4846f);
        parcel.writeSerializable(this.f4841a);
        parcel.writeInt(this.f4842b ? 1 : 0);
    }

    public PicturesTable.PicturesCursor get() {
        return Schema.m5981a().f4866j.get(this);
    }

    public String getGuid() {
        PicturesTable.PicturesCursor picturesCursor = get();
        try {
            return picturesCursor.moveToFirst() ? picturesCursor.getGuid() : null;
        } finally {
            picturesCursor.close();
        }
    }
}
