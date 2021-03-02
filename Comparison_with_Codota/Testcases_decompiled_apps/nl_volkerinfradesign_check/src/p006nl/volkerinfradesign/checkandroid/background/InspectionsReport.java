package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;

/* renamed from: nl.volkerinfradesign.checkandroid.background.InspectionsReport */
public class InspectionsReport implements Parcelable, UploadReport {
    public static final Parcelable.Creator<InspectionsReport> CREATOR = new Parcelable.Creator<InspectionsReport>() {
        /* renamed from: a */
        public InspectionsReport createFromParcel(Parcel parcel) {
            return new InspectionsReport(parcel);
        }

        /* renamed from: a */
        public InspectionsReport[] newArray(int i) {
            return new InspectionsReport[i];
        }
    };

    /* renamed from: a */
    final Exception f4683a;

    /* renamed from: b */
    private final Set<Long> f4684b;

    /* renamed from: c */
    private final List<InspectionWrapper> f4685c;

    InspectionsReport() {
        this.f4684b = new HashSet();
        this.f4685c = new ArrayList();
        this.f4683a = null;
    }

    private InspectionsReport(Parcel parcel) {
        boolean z;
        this.f4684b = new HashSet();
        this.f4685c = new ArrayList();
        int readInt = parcel.readInt();
        if (parcel.readInt() == 1) {
            this.f4683a = (Exception) parcel.readSerializable();
        } else {
            this.f4683a = null;
        }
        for (int i = 0; i < readInt; i++) {
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            InspectionWrapper a = mo9005a(readLong, readLong2, z);
            int readInt2 = parcel.readInt();
            for (int i2 = 0; i2 < readInt2; i2++) {
                a.f4686a.put(Long.valueOf(parcel.readLong()), Long.valueOf(parcel.readLong()));
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public long[] getClientIds() {
        return ArrayUtils.toPrimitive((Long[]) this.f4684b.toArray(new Long[this.f4684b.size()]));
    }

    public String getDescription() {
        return "uploaded " + this.f4685c.size() + " inspections and " + this.f4684b.size() + " inspections need to be updated.";
    }

    public Exception getException() {
        return this.f4683a;
    }

    public List<InspectionWrapper> getInspections() {
        return Collections.unmodifiableList(this.f4685c);
    }

    public boolean hasException() {
        return this.f4683a != null;
    }

    public boolean isSucces() {
        return this.f4683a == null && !this.f4685c.isEmpty();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.f4685c.size());
        if (this.f4683a != null) {
            parcel.writeInt(1);
            parcel.writeSerializable(this.f4683a);
        } else {
            parcel.writeInt(0);
        }
        for (InspectionWrapper next : this.f4685c) {
            parcel.writeLong(next.clientId);
            parcel.writeLong(next.serverId);
            if (next.f4688c) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeInt(next.f4686a.size());
            for (Map.Entry next2 : next.f4686a.entrySet()) {
                parcel.writeLong(((Long) next2.getKey()).longValue());
                parcel.writeLong(((Long) next2.getValue()).longValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InspectionWrapper mo9005a(long j, long j2, boolean z) {
        InspectionWrapper inspectionWrapper = new InspectionWrapper(j, j2, z);
        this.f4684b.add(Long.valueOf(j));
        this.f4685c.add(inspectionWrapper);
        return inspectionWrapper;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.InspectionsReport$InspectionWrapper */
    public class InspectionWrapper {

        /* renamed from: a */
        final Map<Long, Long> f4686a;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final boolean f4688c;
        public final long clientId;
        public final long serverId;

        private InspectionWrapper(long j, long j2, boolean z) {
            this.f4686a = new HashMap();
            this.clientId = j;
            this.serverId = j2;
            this.f4688c = z;
        }

        public Map<Long, Long> getInspectionItems() {
            return Collections.unmodifiableMap(this.f4686a);
        }

        public long[] getItemIds() {
            return ArrayUtils.toPrimitive((Long[]) this.f4686a.keySet().toArray(new Long[this.f4686a.size()]));
        }

        public boolean isSavingAllowed() {
            return this.f4688c;
        }
    }
}
