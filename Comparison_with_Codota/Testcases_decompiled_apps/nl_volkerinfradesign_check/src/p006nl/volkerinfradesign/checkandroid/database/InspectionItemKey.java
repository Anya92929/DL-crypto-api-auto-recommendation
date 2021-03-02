package p006nl.volkerinfradesign.checkandroid.database;

import android.database.CursorIndexOutOfBoundsException;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import java.io.File;
import java.util.Calendar;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;

/* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemKey */
public final class InspectionItemKey implements Parcelable {
    public static final Parcelable.Creator<InspectionItemKey> CREATOR = new Parcelable.Creator<InspectionItemKey>() {
        /* renamed from: a */
        public InspectionItemKey createFromParcel(Parcel parcel) {
            return new InspectionItemKey(parcel);
        }

        /* renamed from: a */
        public InspectionItemKey[] newArray(int i) {
            return new InspectionItemKey[i];
        }
    };

    /* renamed from: a */
    final long f4780a;

    /* renamed from: b */
    final long f4781b;

    /* renamed from: c */
    final long f4782c;

    /* renamed from: d */
    final long f4783d;

    /* renamed from: e */
    final InspectionItemType f4784e;

    /* renamed from: f */
    private final String f4785f;

    public InspectionItemKey(InspectionItemConstants.ItemCursor itemCursor) {
        this.f4780a = itemCursor.getId();
        this.f4785f = itemCursor.getTitle();
        this.f4781b = itemCursor.getFormItemServerId();
        this.f4782c = itemCursor.getInspectionId();
        this.f4783d = itemCursor.getRootInspectionId();
        this.f4784e = itemCursor.getType();
    }

    private InspectionItemKey(Parcel parcel) {
        this.f4780a = parcel.readLong();
        this.f4785f = parcel.readString();
        this.f4781b = parcel.readLong();
        this.f4782c = parcel.readLong();
        this.f4783d = parcel.readLong();
        this.f4784e = InspectionItemType.valueOf(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4780a);
        parcel.writeString(this.f4785f);
        parcel.writeLong(this.f4781b);
        parcel.writeLong(this.f4782c);
        parcel.writeLong(this.f4783d);
        parcel.writeString(this.f4784e.name());
    }

    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.f4785f;
    }

    public boolean hasValue() {
        InspectionItemConstants.ItemCursor a = Schema.getInspectionItems().mo9191a(this);
        try {
            return a.moveToFirst() && a.hasValue();
        } finally {
            a.close();
        }
    }

    public PictureKey registerPicture(File file, Location location) {
        return Schema.getPictures().add(this.f4780a, this.f4782c, this.f4783d, Calendar.getInstance(), location, file);
    }

    public void setCustomLocation(LatLng latLng) {
        Schema.getInspectionItems().mo9192a(this, Calendar.getInstance(), latLng);
    }

    public boolean setRemark(String str, Location location) {
        InspectionItemConstants.ItemCursor itemCursor = get();
        try {
            return itemCursor.moveToFirst() ? itemCursor.setRemark(str, location) : false;
        } finally {
            itemCursor.close();
        }
    }

    public boolean setValue(Object obj, Location location) {
        InspectionItemConstants.ItemCursor itemCursor = get();
        try {
            return itemCursor.moveToFirst() ? itemCursor.setValue(obj, location) : false;
        } finally {
            itemCursor.close();
        }
    }

    public InspectionItemConstants.ItemCursor get() {
        return Schema.getInspectionItems().mo9191a(this);
    }

    public long getSubFormServerId() {
        InspectionItemConstants.ItemCursor itemCursor = get();
        try {
            if (itemCursor.moveToFirst()) {
                return itemCursor.getSubFormServerId();
            }
            throw new CursorIndexOutOfBoundsException(itemCursor.getPosition(), itemCursor.getCount());
        } finally {
            itemCursor.close();
        }
    }

    public PictureKey getDescriptivePicture() {
        InspectionItemConstants.ItemCursor itemCursor = get();
        try {
            if (itemCursor.moveToFirst()) {
                return Schema.m5981a().f4866j.getDescriptivePicture(itemCursor);
            }
            itemCursor.close();
            return null;
        } finally {
            itemCursor.close();
        }
    }

    public PictureKey[] getPictures() {
        C1225hy hyVar = (C1225hy) get();
        if (hyVar.moveToFirst()) {
            return Schema.getPictures().mo9404a((InspectionItemConstants.ItemCursor) hyVar);
        }
        return null;
    }

    public Object getValue() {
        InspectionItemConstants.ItemCursor itemCursor = get();
        try {
            if (itemCursor.moveToFirst()) {
                return itemCursor.getValue();
            }
            itemCursor.close();
            return null;
        } finally {
            itemCursor.close();
        }
    }
}
