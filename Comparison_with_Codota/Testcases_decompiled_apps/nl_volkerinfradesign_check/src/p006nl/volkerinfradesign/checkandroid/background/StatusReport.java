package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: nl.volkerinfradesign.checkandroid.background.StatusReport */
public class StatusReport implements Parcelable, Iterable<Long>, UploadReport {
    public static final Parcelable.Creator<StatusReport> CREATOR = new Parcelable.Creator<StatusReport>() {
        /* renamed from: a */
        public StatusReport createFromParcel(Parcel parcel) {
            return new StatusReport(parcel);
        }

        /* renamed from: a */
        public StatusReport[] newArray(int i) {
            return new StatusReport[i];
        }
    };

    /* renamed from: a */
    private final Exception f4699a;

    /* renamed from: b */
    private final Collection<Long> f4700b;

    /* renamed from: c */
    private final String f4701c;

    public StatusReport(Exception exc) {
        this.f4700b = new HashSet();
        this.f4699a = exc;
        this.f4701c = null;
    }

    StatusReport() {
        this.f4700b = new HashSet();
        this.f4699a = null;
        this.f4701c = null;
    }

    private StatusReport(Parcel parcel) {
        Exception exc;
        String str = null;
        this.f4700b = new HashSet();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f4700b.add(Long.valueOf(parcel.readLong()));
        }
        if (parcel.readInt() == 1) {
            exc = (Exception) parcel.readSerializable();
        } else {
            exc = null;
        }
        this.f4699a = exc;
        this.f4701c = parcel.readInt() == 1 ? parcel.readString() : str;
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return "Succesfully uploaded the status of inspections: " + this.f4701c + (this.f4699a == null ? "..." : ", but with an error...");
    }

    public Exception getException() {
        return this.f4699a;
    }

    public final Collection<Long> getNotifiableIds() {
        return Collections.unmodifiableCollection(this.f4700b);
    }

    public boolean hasException() {
        return this.f4699a != null;
    }

    public boolean isSucces() {
        return this.f4699a == null;
    }

    public Iterator<Long> iterator() {
        return Collections.unmodifiableCollection(this.f4700b).iterator();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4700b.size());
        for (Long longValue : this.f4700b) {
            parcel.writeLong(longValue.longValue());
        }
        if (this.f4699a != null) {
            parcel.writeInt(1);
            parcel.writeSerializable(this.f4699a);
        } else {
            parcel.writeInt(0);
        }
        if (this.f4701c != null) {
            parcel.writeInt(1);
            parcel.writeString(this.f4701c);
            return;
        }
        parcel.writeInt(0);
    }
}
