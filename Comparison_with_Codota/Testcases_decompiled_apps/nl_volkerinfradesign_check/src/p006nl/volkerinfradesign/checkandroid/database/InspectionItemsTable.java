package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.location.Location;
import android.support.p001v4.util.LongSparseArray;
import android.util.Pair;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.lang3.ArrayUtils;
import p000.C1225hy;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormInfo;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormItem;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.ItemActionsTable;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ColumnEditor;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTa;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemsTable */
public class InspectionItemsTable extends Table implements C1225hy.C1230a, InspectionItemConstants {

    /* renamed from: a */
    private final Set<C1225hy> f4792a = new ListOrderedSet();

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemsTable$RecordType */
    public enum RecordType {
        CUSTOM_ITEM,
        DUMMY_HEADER,
        HEADER,
        ITEM
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemsTable$a */
    public interface C1450a {
        /* renamed from: a */
        String mo8427a();

        /* renamed from: a */
        void mo8428a(ContentValues contentValues);

        /* renamed from: a */
        void mo8429a(CursorWindow cursorWindow, int i, int i2);
    }

    public InspectionItemsTable() {
        super(InspectionItemConstants.TABLE_NAME);
        putColumn(InspectionItemConstants.INSPECTION_ID, Column.DataType.INTEGER).notNull();
        putColumn(InspectionItemConstants.RECORD_TYPE, Column.DataType.TEXT).notNull();
        putColumn(InspectionItemConstants.ORDINAL, Column.DataType.INTEGER).notNull();
        putColumn(InspectionItemConstants.PARENT_ORDINAL, Column.DataType.INTEGER);
        putColumn(InspectionItemConstants.REQUIRED, Column.DataType.INTEGER).notNull().defaultValue((Boolean) false);
        putColumn("title", Column.DataType.TEXT).notNull();
        putColumn("description", Column.DataType.TEXT);
        putColumn(InspectionItemConstants.INAPPLICABLE_POSSIBLE, Column.DataType.INTEGER).notNull().defaultValue((Boolean) false);
        putColumn(InspectionItemConstants.INAPPLICABLE, Column.DataType.INTEGER);
        putColumn("form_item_server_id", Column.DataType.INTEGER);
        putColumn("mod_date", Column.DataType.INTEGER).notNull().defaultValue(ColumnEditor.LiteralValue.CURRENT_TIMESTAMP);
        putColumn("creation_date", Column.DataType.INTEGER).notNull().defaultValue(ColumnEditor.LiteralValue.CURRENT_TIMESTAMP);
        putColumn(InspectionItemConstants.TRIGGERS, Column.DataType.TEXT);
        putColumn(InspectionItemConstants.REMARK, Column.DataType.TEXT);
        putColumn(InspectionItemConstants.FORM_ACTION_IDS, Column.DataType.TEXT);
        putColumn(InspectionItemConstants.LOCATION_REQUIRED, Column.DataType.INTEGER).notNull().defaultValue((Boolean) false);
        putColumn(InspectionItemConstants.PICTURE_REQUIRED, Column.DataType.INTEGER).notNull().defaultValue((Boolean) false);
        putColumn("location_id", Column.DataType.INTEGER);
        putColumn("custom_location_id", Column.DataType.INTEGER);
        putColumn(InspectionItemConstants.DESCRIPTIVE_IMAGE_URL, Column.DataType.TEXT);
        putColumn(InspectionItemConstants.INSPECTION_ITEM_TYPE, Column.DataType.TEXT).notNull();
        putColumn(InspectionItemConstants.INSPECTION_ITEM_VALUE, Column.DataType.TEXT);
        putColumn(InspectionItemConstants.CHOICES, Column.DataType.TEXT);
        putColumn(InspectionItemConstants.GUID, Column.DataType.TEXT).notNull();
        putColumn(InspectionItemConstants.ACTION_IDS, Column.DataType.TEXT);
        putColumn("root_inspection_id", Column.DataType.INTEGER).notNull();
        putColumn(InspectionItemConstants.SUB_INSPECTION_ID, Column.DataType.INTEGER);
        putColumn(InspectionItemConstants.HYPERLINKS, Column.DataType.TEXT);
    }

    public InspectionItemConstants.ItemCursor getById(long j) {
        return (InspectionItemConstants.ItemCursor) query("_id = ?", new String[]{Long.toString(j)}, new String[0]);
    }

    public int getChildCount(InspectionItemConstants.HeaderCursor headerCursor) {
        InspectionItemConstants.ItemCursor items = getItems(headerCursor);
        try {
            return items.getCount();
        } finally {
            items.close();
        }
    }

    public InspectionItemConstants.ItemCursor getItems(InspectionItemConstants.HeaderCursor headerCursor) {
        return (InspectionItemConstants.ItemCursor) query((String[]) null, "inspection_id = ? and parent_header = ?", new String[]{Long.toString(headerCursor.getInspectionId()), Long.toString((long) headerCursor.getOrdinal())}, (String) null, (String) null, InspectionItemConstants.ORDINAL);
    }

    public InspectionItemConstants.ItemCursor getItems(InspectionKey inspectionKey, boolean z) {
        String str;
        String[] strArr = {Long.toString(inspectionKey.getInspectionId())};
        if (z) {
            str = "inspection_id = ? ";
        } else {
            str = "inspection_id = ? and parent_header is null";
        }
        return (InspectionItemConstants.ItemCursor) query((String[]) null, str, strArr, (String) null, (String) null, InspectionItemConstants.ORDINAL);
    }

    public boolean hasHeaders(InspectionKey inspectionKey) {
        ViTaCursor query = query(new String[]{"_id"}, "inspection_id = ? and parent_header is not null", new String[]{Long.toString(inspectionKey.getInspectionId())}, (String) null, (String) null, (String) null, "1");
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    public boolean setServerIds(LongSparseArray<Long> longSparseArray) {
        SQLiteDatabase writableDatabase = getHelper().getWritableDatabase();
        SQLiteStatement compileStatement = writableDatabase.compileStatement("update " + getName() + " set " + "form_item_server_id" + " = ? where " + "_id" + " = ?");
        writableDatabase.beginTransaction();
        boolean z = false;
        for (int i = 0; i < longSparseArray.size(); i++) {
            compileStatement.clearBindings();
            compileStatement.bindLong(1, longSparseArray.valueAt(i).longValue());
            compileStatement.bindLong(2, longSparseArray.keyAt(i));
            z = compileStatement.executeUpdateDelete() > 0 || z;
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        return z;
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1225hy(sQLiteCursorDriver, str, sQLiteQuery, InspectionItemsTable.this);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InspectionItemConstants.ItemCursor mo9191a(InspectionItemKey inspectionItemKey) {
        return (InspectionItemConstants.ItemCursor) query("_id = ?", new String[]{Long.toString(inspectionItemKey.f4780a)}, new String[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long[] mo9196a(long j) {
        ViTaCursor query = query("inspection_id = ?", new String[]{Long.toString(j)}, "_id");
        long[] jArr = new long[query.getCount()];
        for (int i = 0; query.moveToPosition(i); i++) {
            jArr[i] = query.getId();
        }
        return jArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo9199b(long j) {
        C1225hy hyVar = (C1225hy) query("inspection_id = ?\t", new String[]{Long.toString(j)}, new String[0]);
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        while (hyVar.moveToPosition(i)) {
            try {
                if (!hyVar.isHeader()) {
                    f2 += 1.0f;
                    if (mo9193a(hyVar)) {
                        f += 1.0f;
                    }
                }
                i++;
            } finally {
                hyVar.close();
            }
        }
        if (AppState.getInstance().isDebugable()) {
            AppState.getInstance().log().mo8931i("splitted progress is: " + f + "/" + f2);
        }
        return (f == BitmapDescriptorFactory.HUE_RED || f2 == BitmapDescriptorFactory.HUE_RED) ? 0.0f : f / f2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long[] mo9197a(long j, final JsonArray jsonArray, final boolean z, long j2, boolean z2) {
        return m5914a(j, new FormInfo() {
            public int size() {
                return jsonArray.size();
            }

            public boolean hasLonelyItems(boolean z) {
                return Form.hasLonelyItems(this, z);
            }

            public FormItem get(int i) {
                return (FormItem) new GsonBuilder().registerTypeAdapter(FormItem.class, FormItem.DESERIALIZER).create().fromJson((JsonElement) jsonArray.get(i).getAsJsonObject(), FormItem.class);
            }

            public boolean areProjectsEnabled() {
                return z;
            }

            public JsonObject getExtras(int i) {
                return jsonArray.get(i).getAsJsonObject();
            }
        }, z, j2, z2, (LongSparseArray<String>) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long[] mo9198a(long j, Form form, long j2, LongSparseArray<String> longSparseArray) {
        return m5914a(j, form, form.areProjectsEnabled(), j2, j != j2, longSparseArray);
    }

    /* renamed from: a */
    private long[] m5914a(long j, FormInfo formInfo, boolean z, long j2, boolean z2, LongSparseArray<String> longSparseArray) {
        int i;
        SQLiteDatabase writableDatabase = ViTa.getHelper().getWritableDatabase();
        HashSet hashSet = new HashSet();
        long currentTimeMillis = System.currentTimeMillis();
        int size = formInfo.size();
        int i2 = 0;
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        synchronize();
        writableDatabase.beginTransaction();
        if (formInfo.hasLonelyItems(z2)) {
            hashSet.add(Long.valueOf(C1231hz.m5485a(writableDatabase, j, currentTimeMillis, j2).mo8432a()));
            size++;
            i2 = 1;
            atomicInteger.set(0);
        }
        if (z2 || !z) {
            i = size;
        } else {
            hashSet.add(Long.valueOf(C1231hz.m5486a(writableDatabase, j, currentTimeMillis, atomicInteger, j2).mo8432a()));
            i = size + 1;
            i2++;
        }
        int i3 = 0;
        int i4 = i2;
        while (i4 < i) {
            FormItem formItem = formInfo.get(i3);
            JsonObject extras = formInfo.getExtras(i3);
            long a = C1231hz.m5487a(writableDatabase, formItem, i4, atomicInteger, j, currentTimeMillis, j2, longSparseArray != null ? longSparseArray.get(formItem.getServerId()) : null).mo8432a();
            if (extras != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("form_item_server_id", Long.valueOf(extras.get("id").getAsLong()));
                contentValues.put(InspectionItemConstants.INAPPLICABLE, Boolean.valueOf(extras.has("isInapplicable") && extras.get("isInapplicable").getAsBoolean()));
                if (extras.has("subInspectionId")) {
                    contentValues.put(InspectionItemConstants.SUB_INSPECTION_ID, Long.valueOf(extras.get("subInspectionId").getAsLong()));
                }
                if (extras.has("value")) {
                    if (extras.get("value").getAsString().equals("INAPPLICABLE")) {
                        contentValues.put(InspectionItemConstants.INAPPLICABLE, 1);
                    } else {
                        contentValues.put(InspectionItemConstants.INSPECTION_ITEM_VALUE, extras.get("value").getAsString());
                        contentValues.put(InspectionItemConstants.INAPPLICABLE, Integer.valueOf((!extras.has("isInapplicable") || !extras.get("isInapplicable").getAsBoolean()) ? 0 : 1));
                    }
                }
                if (extras.has("geoLat") && extras.has("geoLong")) {
                    contentValues.put("location_id", Long.valueOf(Schema.m5982b().add(new LocationsTable.LocationWrapper(extras.get("geoLat").getAsDouble(), extras.get("geoLong").getAsDouble()))));
                }
                update(contentValues, "_id = ?", new String[]{Long.toString(a)});
            }
            hashSet.add(Long.valueOf(a));
            i4++;
            i3++;
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        return ArrayUtils.toPrimitive((Long[]) hashSet.toArray(new Long[hashSet.size()]));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9192a(InspectionItemKey inspectionItemKey, Calendar calendar, LatLng latLng) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("mod_date", Long.valueOf(calendar.getTimeInMillis()));
        if (latLng != null) {
            contentValues.put("custom_location_id", Long.valueOf(Schema.m5982b().add(latLng)));
        } else {
            contentValues.putNull("custom_location_id");
        }
        update(contentValues, "_id = ?", new String[]{Long.toString(inspectionItemKey.f4780a)});
        Schema.getInspectionData().mo9246a(inspectionItemKey.f4782c, calendar, mo9199b(inspectionItemKey.f4782c));
    }

    /* renamed from: a */
    public boolean mo9193a(C1225hy hyVar) {
        if (hyVar.isHeader() || hyVar.isInapplicable()) {
            return true;
        }
        if (hyVar.getType() == InspectionItemType.PROJECTS) {
            return Schema.getInspectionData().mo9247a(hyVar.getInspectionId());
        }
        if (hyVar.getType() != InspectionItemType.BLANC && hyVar.isRequired() && !hyVar.hasValue()) {
            return false;
        }
        if (hyVar.getType() == InspectionItemType.SIGNATURE && !hyVar.hasSignature()) {
            return false;
        }
        if (hyVar.isPictureRequired() && !hyVar.mo8372a()) {
            return false;
        }
        if (hyVar.isCustomLocationRequired() && !hyVar.hasCustomlocation()) {
            return false;
        }
        ItemActionsTable.ActionKey b = hyVar.mo8375b();
        if (b == null || Schema.getInspectionData().getSubInspectionsProgress(hyVar.getId(), b.mo9339b(), false) >= 1.0f) {
            return true;
        }
        return false;
    }

    public InspectionItemConstants.HeaderCursor getHeaders(InspectionKey inspectionKey) {
        return (InspectionItemConstants.HeaderCursor) query((String[]) null, "inspection_id = ? and item_type in (?, ?)", new String[]{Long.toString(inspectionKey.f4798a), RecordType.HEADER.name(), RecordType.DUMMY_HEADER.name()}, (String) null, (String) null, InspectionItemConstants.ORDINAL);
    }

    public void addCursor(C1225hy hyVar) {
        this.f4792a.add(hyVar);
    }

    public void removeCursor(C1225hy hyVar) {
        this.f4792a.remove(hyVar);
    }

    /* renamed from: a */
    public boolean mo9195a(C1225hy hyVar, Location location, C1450a aVar) {
        long id = hyVar.getId();
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("mod_date", Long.valueOf(timeInMillis));
        if (location != null) {
            contentValues.put("location_id", Long.valueOf(Schema.m5982b().add(location)));
        }
        aVar.mo8428a(contentValues);
        if (update(contentValues, "_id = ?", new String[]{Long.toString(id)}) <= 0) {
            return false;
        }
        long inspectionId = hyVar.getInspectionId();
        Schema.getInspectionData().mo9246a(inspectionId, instance, mo9199b(inspectionId));
        for (C1225hy a : this.f4792a) {
            a.mo8373a(id, timeInMillis, aVar);
        }
        return true;
    }

    /* renamed from: a */
    public Pair<Integer, Integer> mo9190a(InspectionItemConstants.HeaderCursor headerCursor) {
        InspectionItemConstants.ItemCursor items = getItems(headerCursor);
        int i = 0;
        for (int i2 = 0; items.moveToPosition(i2); i2++) {
            if (items.isValid()) {
                i++;
            }
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(items.getCount()));
    }

    /* renamed from: a */
    public boolean mo9194a(C1225hy hyVar, long j, Location location) {
        return Schema.getInspectionData().setProjectSelected(this, hyVar, j, location);
    }

    public long getServerId(PicturesTable.PicturesCursor picturesCursor) {
        ViTaCursor query = query("_id = ?", new String[]{Long.toString(picturesCursor.getInspectionItemId())}, "form_item_server_id");
        try {
            if (query.moveToFirst() && !query.isNull(0)) {
                return query.getLong(0);
            }
            throw new CursorIndexOutOfBoundsException("There is no server id!");
        } finally {
            query.close();
        }
    }
}
