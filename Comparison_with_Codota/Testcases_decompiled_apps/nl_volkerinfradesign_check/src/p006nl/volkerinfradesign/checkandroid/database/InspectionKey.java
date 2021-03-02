package p006nl.volkerinfradesign.checkandroid.database;

import android.database.CursorIndexOutOfBoundsException;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.gson.JsonElement;
import java.util.Calendar;
import java.util.List;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.ProjectsTable;
import p006nl.volkerinfradesign.checkandroid.environments.OriginKey;
import p006nl.volkerinfradesign.checkandroid.environments.Tasks;

/* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionKey */
public final class InspectionKey implements Parcelable, InspectionConstants, OriginKey {
    public static final Parcelable.Creator<InspectionKey> CREATOR = new Parcelable.Creator<InspectionKey>() {
        /* renamed from: a */
        public InspectionKey createFromParcel(Parcel parcel) {
            return new InspectionKey(parcel);
        }

        /* renamed from: a */
        public InspectionKey[] newArray(int i) {
            return new InspectionKey[i];
        }
    };

    /* renamed from: a */
    final long f4798a;

    /* renamed from: b */
    final long f4799b;

    /* renamed from: c */
    final long f4800c;

    /* renamed from: d */
    final long[] f4801d;

    /* renamed from: e */
    final Long f4802e;

    public InspectionKey(InspectionItemConstants.ItemCursor itemCursor) {
        this(itemCursor.getInspectionId(), itemCursor.getRootInspectionId(), Schema.getInspectionData().getTaskId(itemCursor.getInspectionId()));
    }

    InspectionKey(long j, long j2, Long l) {
        this(j, j2, Schema.getInspectionData().mo9250b(j2), l, Schema.getInspectionItems().mo9196a(j));
    }

    InspectionKey(InspectionsTable.DataCursor dataCursor) {
        this(dataCursor.getId(), dataCursor.getRootInspectionId(), dataCursor.getCompanyServerId(), dataCursor.getTaskId(), dataCursor.getItemIds());
    }

    InspectionKey(long j, long j2, long j3, Long l, long... jArr) {
        this.f4798a = j;
        this.f4799b = j2;
        this.f4800c = j3;
        this.f4802e = l;
        this.f4801d = (jArr == null || jArr.length <= 0) ? Schema.getInspectionItems().mo9196a(j) : jArr;
    }

    private InspectionKey(Parcel parcel) {
        this.f4798a = parcel.readLong();
        this.f4799b = parcel.readLong();
        this.f4800c = parcel.readLong();
        this.f4802e = parcel.readInt() == 1 ? Long.valueOf(parcel.readLong()) : null;
        this.f4801d = new long[parcel.readInt()];
        for (int i = 0; i < getInspectionItemIds().length; i++) {
            getInspectionItemIds()[i] = parcel.readLong();
        }
    }

    public void delete() {
        Schema.getInspectionData().mo9256e(this);
    }

    public int describeContents() {
        return 0;
    }

    public InspectionsTable.DataCursor get() {
        return Schema.getInspectionData().mo9251b(this);
    }

    public long getCompanyServerId() {
        return Schema.getInspectionData().mo9252c(this);
    }

    public ProjectsTable.ProjectsCursor getFilteredProjects(CharSequence charSequence) {
        return Schema.getProjects().mo9431a(this, charSequence);
    }

    public long getInspectionId() {
        return this.f4798a;
    }

    public long[] getInspectionItemIds() {
        return this.f4801d;
    }

    public InspectionItemConstants.ItemCursor getItems(boolean z) {
        return Schema.getInspectionItems().getItems(this, z);
    }

    public InspectionItemConstants.ItemCursor getItems(InspectionItemConstants.HeaderCursor headerCursor) {
        return Schema.getInspectionItems().getItems(headerCursor);
    }

    public float getprogress() {
        InspectionsTable.DataCursor b = Schema.getInspectionData().mo9251b(this);
        try {
            return b.moveToFirst() ? b.getProgress() : BitmapDescriptorFactory.HUE_RED;
        } finally {
            b.close();
        }
    }

    public ProjectsTable.ProjectsCursor getProjects() {
        return Schema.getProjects().mo9431a(this, (CharSequence) null);
    }

    public Long getSelectedProjectId() {
        return Schema.getInspectionData().mo9254d(this);
    }

    public Long getServerId() {
        InspectionsTable.DataCursor b = Schema.getInspectionData().mo9251b(this);
        try {
            return (!b.moveToFirst() || !b.hasServerId()) ? null : Long.valueOf(b.getServerId());
        } finally {
            b.close();
        }
    }

    public Long getTaskId() {
        return this.f4802e;
    }

    public String getTitle() {
        return Schema.getInspectionData().mo9244a(this);
    }

    public boolean hasHeaders() {
        return Schema.getInspectionItems().hasHeaders(this);
    }

    public boolean isSavingAllowed() {
        InspectionsTable.DataCursor b = Schema.getInspectionData().mo9251b(this);
        try {
            return b.moveToFirst() && b.isSavingAllowed();
        } finally {
            b.close();
        }
    }

    public void setLocation(Location location) {
        Schema.getInspectionData().mo9248a(this, location, Calendar.getInstance());
    }

    public float setProjectSelected(long j) {
        AppState.getInstance().log().mo8931i("InspectionsTable.InspectionKey.setProjectSelected");
        return Schema.getInspectionData().mo9242a(this, j, Calendar.getInstance());
    }

    public JsonElement toJson() {
        InspectionsTable.DataCursor byId = Schema.getInspectionData().getById(this.f4799b);
        try {
            if (byId.moveToFirst()) {
                return byId.toJson();
            }
            throw new NullPointerException("");
        } finally {
            byId.close();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4798a);
        parcel.writeLong(this.f4799b);
        parcel.writeLong(this.f4800c);
        if (this.f4802e != null) {
            parcel.writeInt(1);
            parcel.writeLong(this.f4802e.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f4801d.length);
        for (long writeLong : this.f4801d) {
            parcel.writeLong(writeLong);
        }
    }

    public boolean hasOrigin() {
        InspectionsTable.DataCursor dataCursor = get();
        try {
            return dataCursor.moveToFirst() && !dataCursor.isNull(InspectionConstants.ORIGIN_SERVER_ID);
        } finally {
            dataCursor.close();
        }
    }

    public long getOriginServerId() {
        InspectionsTable.DataCursor dataCursor = get();
        try {
            if (dataCursor.moveToFirst()) {
                return dataCursor.getOriginServerId();
            }
            throw new CursorIndexOutOfBoundsException(dataCursor.getPosition(), dataCursor.getCount());
        } finally {
            dataCursor.close();
        }
    }

    public boolean hasOriginServerId() {
        InspectionsTable.DataCursor dataCursor = get();
        try {
            if (dataCursor.moveToFirst()) {
                return dataCursor.hasOriginServerId();
            }
            throw new CursorIndexOutOfBoundsException(dataCursor.getPosition(), dataCursor.getCount());
        } finally {
            dataCursor.close();
        }
    }

    public InspectionKey getOriginInspectionKey() {
        return Schema.getInspectionData().mo9253c(getOriginServerId());
    }

    public static InspectionKey newInstance(Tasks.TaskCursor taskCursor) {
        InspectionsTable.DataCursor byId = Schema.getInspectionData().getById(taskCursor.getInspectionId().longValue());
        try {
            return byId.moveToFirst() ? new InspectionKey(byId) : null;
        } finally {
            byId.close();
        }
    }

    public InspectionItemConstants.HeaderCursor getHeaders() {
        return Schema.getInspectionItems().getHeaders(this);
    }

    public void invalidateProgress() {
        Schema.getInspectionData().mo9257f(this);
    }

    public boolean isSubInspection() {
        return this.f4799b != this.f4798a;
    }

    public List<PictureKey> getPictureKeysFromRoot() {
        return Schema.m5981a().f4866j.getPictureKeyFromRoot(this);
    }

    public boolean isValid() {
        return Schema.getInspectionData().isValid(this);
    }
}
