package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: nl.volkerinfradesign.checkandroid.background.PictureReport */
public final class PictureReport implements Parcelable, UploadReport {
    public static final Parcelable.Creator<PictureReport> CREATOR = new Parcelable.Creator<PictureReport>() {
        /* renamed from: a */
        public PictureReport createFromParcel(Parcel parcel) {
            return new PictureReport(parcel);
        }

        /* renamed from: a */
        public PictureReport[] newArray(int i) {
            return new PictureReport[i];
        }
    };

    /* renamed from: a */
    private static final SimpleDateFormat f4692a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    public final Exception exception;
    public final long inspectionId;
    public final boolean metadataUploaded;
    public final long pictureId;
    public final boolean pictureUploaded;
    public final long uploadTime;

    public PictureReport(long j, long j2, boolean z, boolean z2) {
        this(j, j2, z, z2, (Exception) null);
    }

    public PictureReport(long j, long j2, boolean z, boolean z2, Exception exc) {
        this.inspectionId = j;
        this.pictureUploaded = z;
        this.metadataUploaded = z2;
        this.pictureId = j2;
        this.exception = exc;
        this.uploadTime = System.currentTimeMillis();
    }

    private PictureReport(Parcel parcel) {
        boolean z = false;
        this.pictureUploaded = parcel.readInt() == 1;
        this.metadataUploaded = parcel.readInt() == 1 ? true : z;
        this.inspectionId = parcel.readLong();
        this.pictureId = parcel.readLong();
        this.uploadTime = parcel.readLong();
        this.exception = parcel.readInt() == 1 ? (Exception) parcel.readSerializable() : null;
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        String str = "Procedure for uploading a picture... ";
        instance.setTimeInMillis(this.uploadTime);
        if (this.pictureUploaded) {
            str = str + "uploaded the picture ";
        }
        if (this.metadataUploaded) {
            if (this.pictureUploaded) {
                str = str + "and ";
            }
            str = str + "uploaded the metadata ";
        }
        return (str + (this.exception == null ? ", without any errors" : ", with an error (" + this.exception.getClass().getSimpleName() + ")")) + ". All of this started at: " + f4692a.format(instance.getTime());
    }

    public Exception getException() {
        return this.exception;
    }

    public long getPictureId() {
        if (isPictureUploaded() && isMetadataUploaded()) {
            return this.pictureId;
        }
        throw new IllegalStateException();
    }

    public boolean hasException() {
        return this.exception != null;
    }

    public boolean isMetadataUploaded() {
        return this.metadataUploaded;
    }

    public boolean isPictureUploaded() {
        return this.pictureUploaded;
    }

    public boolean isSucces() {
        return this.exception == null;
    }

    public boolean isUploaded() {
        return this.pictureUploaded && this.metadataUploaded;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.pictureUploaded ? 1 : 0);
        if (this.metadataUploaded) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeLong(this.inspectionId);
        parcel.writeLong(this.pictureId);
        parcel.writeLong(this.uploadTime);
        if (this.exception != null) {
            parcel.writeInt(1);
            parcel.writeSerializable(this.exception);
            return;
        }
        parcel.writeInt(0);
    }
}
