package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.JsonObject;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.p007ui.maps.MapActivity;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.database.LocationsTable */
public class LocationsTable extends Table {
    public static final String NAME = "locations";

    /* renamed from: nl.volkerinfradesign.checkandroid.database.LocationsTable$LocationsCursor */
    public interface LocationsCursor extends ViTaCursor {
        double getAltitude();

        float getBearing();

        LocationKey getKey();

        double getLatitude();

        double getLongitude();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.LocationsTable$SimpleLocation */
    public interface SimpleLocation {
        double getLatitude();

        double getLongitude();
    }

    LocationsTable() {
        super(NAME);
        putColumn("altitude", Column.DataType.REAL);
        putColumn("latitude", Column.DataType.REAL);
        putColumn("longitude", Column.DataType.REAL);
        putColumn("bearing", Column.DataType.REAL);
    }

    public long add(MapActivity.ActivityResult activityResult) {
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("latitude", Double.valueOf(activityResult.getLatitude()));
        contentValues.put("longitude", Double.valueOf(activityResult.getLongitude()));
        contentValues.put("bearing", Float.valueOf(activityResult.getBearing()));
        return insert(contentValues);
    }

    public long add(InspectionsTable.InitialLocation initialLocation) {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("latitude", Double.valueOf(initialLocation.getLat()));
        contentValues.put("longitude", Double.valueOf(initialLocation.getlong()));
        return insert(contentValues);
    }

    public long add(LatLng latLng) {
        return add(new LocationWrapper(latLng));
    }

    public long add(Location location) {
        if (location != null) {
            return insert(m5956a(location));
        }
        throw new IllegalArgumentException("The location may not be null!");
    }

    public long add(LocationWrapper locationWrapper) {
        return insert(locationWrapper.m5959a());
    }

    public LocationsCursor get(long j) {
        return (LocationsCursor) query("_id = ?", new String[]{Long.toString(j)}, new String[0]);
    }

    public void update(long j, Location location) {
        update(m5956a(location), "_id = ?", new String[]{Long.toString(j)});
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1463a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* renamed from: a */
    private ContentValues m5956a(Location location) {
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("latitude", Double.valueOf(location.getLatitude()));
        contentValues.put("longitude", Double.valueOf(location.getLongitude()));
        if (location.hasBearing()) {
            contentValues.put("bearing", Float.valueOf(location.getBearing()));
        }
        if (location.hasAltitude()) {
            contentValues.put("altitude", Double.valueOf(location.getAltitude()));
        }
        return contentValues;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.LocationsTable$LocationKey */
    public static class LocationKey implements Parcelable {
        public static final Parcelable.Creator<LocationKey> CREATOR = new Parcelable.Creator<LocationKey>() {
            /* renamed from: a */
            public LocationKey createFromParcel(Parcel parcel) {
                return new LocationKey(parcel);
            }

            /* renamed from: a */
            public LocationKey[] newArray(int i) {
                return new LocationKey[i];
            }
        };
        public final double altitude;
        public final float bearing;
        public final double latitude;
        public final double longitude;

        private LocationKey(LocationsCursor locationsCursor) {
            double d = 0.0d;
            this.altitude = locationsCursor.isNull("altitude") ? 0.0d : locationsCursor.getDouble("altitude");
            this.latitude = locationsCursor.isNull("latitude") ? 0.0d : locationsCursor.getDouble("latitude");
            this.longitude = !locationsCursor.isNull("longitude") ? locationsCursor.getDouble("longitude") : d;
            this.bearing = locationsCursor.isNull("bearing") ? BitmapDescriptorFactory.HUE_RED : locationsCursor.getFloat("bearing");
        }

        private LocationKey(Parcel parcel) {
            this.altitude = parcel.readDouble();
            this.latitude = parcel.readDouble();
            this.longitude = parcel.readDouble();
            this.bearing = parcel.readFloat();
        }

        public int describeContents() {
            return 0;
        }

        public double getAltitude() {
            return this.altitude;
        }

        public float getBearing() {
            return this.bearing;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public JsonObject toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("lat", (Number) Double.valueOf(this.latitude));
            jsonObject.addProperty("lon", (Number) Double.valueOf(this.longitude));
            jsonObject.addProperty("alt", (Number) Double.valueOf(this.altitude));
            jsonObject.addProperty("bearing", (Number) Float.valueOf(this.bearing));
            return jsonObject;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeDouble(this.altitude);
            parcel.writeDouble(this.latitude);
            parcel.writeDouble(this.longitude);
            parcel.writeFloat(this.bearing);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.LocationsTable$LocationWrapper */
    static class LocationWrapper implements Parcelable {
        public static final Parcelable.Creator<LocationWrapper> CREATOR = new Parcelable.Creator<LocationWrapper>() {
            /* renamed from: a */
            public LocationWrapper createFromParcel(Parcel parcel) {
                return new LocationWrapper(parcel);
            }

            /* renamed from: a */
            public LocationWrapper[] newArray(int i) {
                return new LocationWrapper[i];
            }
        };

        /* renamed from: a */
        final Double f4824a;

        /* renamed from: b */
        final Float f4825b;

        /* renamed from: c */
        final double f4826c;

        /* renamed from: d */
        final double f4827d;

        LocationWrapper(LatLng latLng) {
            this.f4826c = latLng.latitude;
            this.f4827d = latLng.longitude;
            this.f4825b = null;
            this.f4824a = null;
        }

        private LocationWrapper(Parcel parcel) {
            Float f;
            Double d = null;
            this.f4826c = parcel.readDouble();
            this.f4827d = parcel.readDouble();
            if (parcel.readInt() == 1) {
                f = Float.valueOf(parcel.readFloat());
            } else {
                f = null;
            }
            this.f4825b = f;
            this.f4824a = parcel.readInt() == 1 ? Double.valueOf(parcel.readDouble()) : d;
        }

        public LocationWrapper(double d, double d2) {
            this.f4826c = d;
            this.f4827d = d2;
            this.f4824a = null;
            this.f4825b = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeDouble(this.f4826c);
            parcel.writeDouble(this.f4827d);
            if (this.f4825b != null) {
                parcel.writeInt(1);
                parcel.writeFloat(this.f4825b.floatValue());
            } else {
                parcel.writeInt(0);
            }
            if (this.f4824a != null) {
                parcel.writeInt(1);
                parcel.writeDouble(this.f4824a.doubleValue());
                return;
            }
            parcel.writeInt(0);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public ContentValues m5959a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("latitude", Double.valueOf(this.f4826c));
            contentValues.put("longitude", Double.valueOf(this.f4827d));
            if (this.f4825b != null) {
                contentValues.put("bearing", this.f4825b);
            }
            if (this.f4824a != null) {
                contentValues.put("altitude", this.f4824a);
            }
            return contentValues;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.LocationsTable$a */
    class C1463a extends ViTaCursor.Instance implements LocationsCursor {
        public C1463a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public double getAltitude() {
            return getDouble("altitude");
        }

        public float getBearing() {
            return getFloat("bearing");
        }

        public LocationKey getKey() {
            return new LocationKey((LocationsCursor) this);
        }

        public double getLatitude() {
            return getDouble("latitude");
        }

        public double getLongitude() {
            return getDouble("longitude");
        }
    }
}
