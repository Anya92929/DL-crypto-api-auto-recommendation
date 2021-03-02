package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.location.Location;
import android.os.Parcelable;
import android.support.p001v4.util.LongSparseArray;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.background.AllInService;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormRef;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.ItemActionsTable;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;
import p006nl.volkerinfradesign.checkandroid.environments.Account;
import p006nl.volkerinfradesign.checkandroid.environments.OriginKey;
import p006nl.volkerinfradesign.checkandroid.environments.Tasks;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.DbUtil;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionsTable */
public class InspectionsTable extends Table implements InspectionConstants {

    /* renamed from: a */
    private final JsonDeserializer<UpdateResultImp> f4803a = new JsonDeserializer<UpdateResultImp>() {
        /* renamed from: a */
        public UpdateResultImp deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject asJsonObject = jsonElement.getAsJsonArray().get(0).getAsJsonObject();
            ContentValues contentValues = new ContentValues();
            boolean has = asJsonObject.has("projectId");
            contentValues.put("deleted", 1);
            contentValues.put(InspectionConstants.INSPECTION_STATE, InspectionState.CLOSED.name());
            contentValues.put(InspectionConstants.IS_SUB_INSPECTION, 0);
            contentValues.put("server_id", Long.valueOf(asJsonObject.get("id").getAsLong()));
            contentValues.put("title", asJsonObject.get("title").getAsString());
            contentValues.put(InspectionConstants.SAVING_ALLOWED, false);
            contentValues.put("form_server_id", Long.valueOf(asJsonObject.get("formInspectionID").getAsLong()));
            contentValues.put(InspectionConstants.MODIFIED_DATE, Long.valueOf(asJsonObject.get(Account.MODIFIED).getAsLong()));
            contentValues.put("creation_date", Long.valueOf(asJsonObject.get("publishedDate").getAsLong()));
            contentValues.put(InspectionConstants.GUID, UUID.randomUUID().toString());
            contentValues.put("company_server_id", Long.valueOf(asJsonObject.get("companyId").getAsLong()));
            if (!asJsonObject.has(ActionColumns.DESCRIPTION) || StringUtils.isNotBlank(asJsonObject.get(ActionColumns.DESCRIPTION).getAsString())) {
                contentValues.putNull("description");
            } else {
                contentValues.put("description", asJsonObject.get(ActionColumns.DESCRIPTION).getAsString().trim());
            }
            if (asJsonObject.has("geoLat") && asJsonObject.has("geoLong")) {
                contentValues.put("location_id", Long.valueOf(Schema.m5982b().add(new LocationsTable.LocationWrapper(asJsonObject.get("geoLat").getAsDouble(), asJsonObject.get("geoLong").getAsDouble()))));
            }
            if (has) {
                contentValues.put(InspectionConstants.PROJECTS_ENABLED, 1);
                contentValues.put("project_server_id", Long.valueOf(asJsonObject.get("projectId").getAsLong()));
            } else {
                contentValues.put(InspectionConstants.PROJECTS_ENABLED, 0);
            }
            long insert = InspectionsTable.this.insert(contentValues);
            contentValues.clear();
            contentValues.put("root_inspection_id", Long.valueOf(insert));
            InspectionsTable.this.update(contentValues, "_id = ?", new String[]{Long.toString(insert)});
            Schema.getInspectionItems().mo9197a(insert, asJsonObject.get("inspectionItems").getAsJsonArray(), has, -1, false);
            return new UpdateResultImp(true, (Exception) null);
        }
    };

    /* renamed from: c */
    private final Schema f4804c;

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionsTable$DataCursor */
    public interface DataCursor extends ViTaCursor {
        boolean areProjectsEnabled();

        void delete();

        long getCompanyServerId();

        Date getCreationDate();

        LocationsTable.LocationsCursor getCustomLocation();

        String getDescription();

        int getFormOrdinal();

        long getFormServerId();

        long[] getItemIds();

        InspectionKey getKey();

        LocationsTable.LocationsCursor getLocation();

        Calendar getModifiedDate();

        long getOriginServerId();

        PicturesTable.PicturesCursor getPicturesFromRoot();

        float getProgress();

        Long getProjectServerId();

        long getRootInspectionId();

        long getServerId();

        DataCursorStats getStats();

        Long getTaskId();

        Long getTaskServerId();

        String getTitle();

        float getVirtualProgress();

        boolean hasOriginServerId();

        boolean hasProjectServerId();

        boolean hasServerId();

        boolean hasTask();

        @Deprecated
        boolean isInspectionUploaded();

        boolean isModified();

        boolean isSavingAllowed();

        @Deprecated
        void setProgress(float f);

        void setServerId(long j);

        void setServerId(Long l);

        JsonObject toJson();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionsTable$DataCursorStats */
    public interface DataCursorStats {
        int getFormCount(long j);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionsTable$InitialLocation */
    public interface InitialLocation {
        double getLat();

        double getlong();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionsTable$InspectionState */
    public enum InspectionState {
        CLOSED,
        OPEN,
        PENDING
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionsTable$UploadStatus */
    public interface UploadStatus extends Parcelable {
        float getProgress();
    }

    InspectionsTable(Schema schema) {
        super(InspectionConstants.TABLE_NAME);
        this.f4804c = schema;
        putColumn("title", Column.DataType.TEXT);
        putColumn("description", Column.DataType.TEXT);
        putColumn(InspectionConstants.FILE, Column.DataType.TEXT);
        putColumn("creation_date", Column.DataType.INTEGER);
        putColumn(InspectionConstants.MODIFIED_DATE, Column.DataType.INTEGER);
        putColumn("progress", Column.DataType.REAL);
        putColumn("form_server_id", Column.DataType.TEXT);
        putColumn(InspectionConstants.PICTURES, Column.DataType.TEXT);
        putColumn(InspectionConstants.INSPECTION_STATE, Column.DataType.TEXT);
        putColumn("server_id", Column.DataType.INTEGER);
        putColumn(InspectionConstants.SAVING_ALLOWED, Column.DataType.INTEGER);
        putColumn("company_server_id", Column.DataType.INTEGER);
        putColumn("project_server_id", Column.DataType.INTEGER);
        putColumn(InspectionConstants.IS_SUB_INSPECTION, Column.DataType.INTEGER);
        putColumn("deleted", Column.DataType.INTEGER);
        putColumn("location_id", Column.DataType.INTEGER);
        putColumn("custom_location_id", Column.DataType.INTEGER);
        putColumn(InspectionConstants.PROJECTS_ENABLED, Column.DataType.INTEGER).notNull().defaultValue((Boolean) true);
        putColumn(InspectionConstants.GUID, Column.DataType.TEXT).notNull();
        putColumn("root_inspection_id", Column.DataType.INTEGER);
        putColumn(InspectionConstants.TASK_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.TASK_SERVER_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.VIRTUAL_UPLOAD_PROGRESS, Column.DataType.INTEGER).notNull().defaultValue((Number) 0);
        putColumn(InspectionConstants.ORIGIN_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.ORIGIN_SERVER_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.PARENT_ITEM_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.ACTION_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.PARENT_ITEM_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.PARENT_INSPECTION_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.ACTION_ID, Column.DataType.INTEGER);
        putColumn(InspectionConstants.FORM_ORDINAL, Column.DataType.INTEGER).notNull().defaultValue((Number) -1);
        synchronize();
    }

    public DataCursor get(InspectionState inspectionState, boolean z, boolean z2, Long l) {
        String str = "creation_date" + (z2 ? " ASC" : " DESC");
        String str2 = "(deleted is null or deleted = ?) and inspection_state = ?";
        ArrayList arrayList = new ArrayList();
        arrayList.add("0");
        arrayList.add(inspectionState.name());
        if (!z) {
            str2 = str2 + " and is_sub_inspection = ?";
            arrayList.add("0");
        }
        if (l != null) {
            str2 = str2 + " and form_server_id = ?";
            arrayList.add(l.toString());
        }
        return (DataCursor) query((String[]) null, str2, (String[]) arrayList.toArray(new String[arrayList.size()]), (String) null, (String) null, str);
    }

    public DataCursor getById(long j) {
        DataCursor dataCursor = (DataCursor) query("_id = ?", new String[]{Long.toString(j)}, new String[0]);
        if (dataCursor.moveToFirst()) {
            return dataCursor;
        }
        if (dataCursor.getCount() > 1) {
            throw new CursorIndexOutOfBoundsException(0, dataCursor.getCount());
        }
        throw new CursorIndexOutOfBoundsException(-1, dataCursor.getCount());
    }

    public DataCursor getByIds(Collection<Long> collection) {
        return getByIds(ArrayUtils.toPrimitive((Long[]) collection.toArray(new Long[collection.size()])));
    }

    public DataCursor getByIds(long... jArr) {
        DbUtil.Argumenter argumenter = DbUtil.getArgumenter(jArr);
        return (DataCursor) query("_id in" + argumenter.getSelection(true), argumenter.getSelectionArgs(), new String[0]);
    }

    public DataCursor getClosed(boolean z) {
        return get(InspectionState.CLOSED, z, false, (Long) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1 = (p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.DataCursor) query("0", (java.lang.String[]) null, new java.lang.String[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.DataCursor getOldestUploadable() {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r7 = 0
            nl.volkerinfradesign.checkandroid.database.PicturesTable r8 = p006nl.volkerinfradesign.checkandroid.database.Schema.getPictures()
            java.lang.String[] r3 = new java.lang.String[r0]
            nl.volkerinfradesign.checkandroid.database.InspectionsTable$InspectionState r0 = p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.InspectionState.CLOSED
            java.lang.String r0 = r0.name()
            r3[r7] = r0
            java.lang.String r2 = " is not ?"
            java.lang.String r6 = "creation_date"
            r0 = r9
            r4 = r1
            r5 = r1
            nl.volkerinfradesign.checkandroid.tables.ViTaCursor r0 = r0.query(r1, r2, r3, r4, r5, r6)
            nl.volkerinfradesign.checkandroid.database.InspectionsTable$DataCursor r0 = (p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.DataCursor) r0
            r1 = r7
        L_0x001f:
            boolean r2 = r0.moveToPosition(r1)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x004b
            boolean r2 = r8.mo9407b((p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.DataCursor) r0)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0048
            java.lang.String r1 = "_id = ?"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ all -> 0x005b }
            r3 = 0
            long r4 = r0.getId()     // Catch:{ all -> 0x005b }
            java.lang.String r4 = java.lang.Long.toString(r4)     // Catch:{ all -> 0x005b }
            r2[r3] = r4     // Catch:{ all -> 0x005b }
            r3 = 0
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x005b }
            nl.volkerinfradesign.checkandroid.tables.ViTaCursor r1 = r9.query(r1, r2, r3)     // Catch:{ all -> 0x005b }
            nl.volkerinfradesign.checkandroid.database.InspectionsTable$DataCursor r1 = (p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.DataCursor) r1     // Catch:{ all -> 0x005b }
            r0.close()
        L_0x0047:
            return r1
        L_0x0048:
            int r1 = r1 + 1
            goto L_0x001f
        L_0x004b:
            java.lang.String r1 = "0"
            r2 = 0
            r3 = 0
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x005b }
            nl.volkerinfradesign.checkandroid.tables.ViTaCursor r1 = r9.query(r1, r2, r3)     // Catch:{ all -> 0x005b }
            nl.volkerinfradesign.checkandroid.database.InspectionsTable$DataCursor r1 = (p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.DataCursor) r1     // Catch:{ all -> 0x005b }
            r0.close()
            goto L_0x0047
        L_0x005b:
            r1 = move-exception
            r0.close()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.getOldestUploadable():nl.volkerinfradesign.checkandroid.database.InspectionsTable$DataCursor");
    }

    public DataCursor getOpen(long j, boolean z) {
        return get(InspectionState.OPEN, z, false, Long.valueOf(j));
    }

    public DataCursor getOpen(boolean z) {
        return get(InspectionState.OPEN, z, false, (Long) null);
    }

    public DataCursor getOpen(FormRef formRef) {
        return getOpen(formRef.getServerId());
    }

    public DataCursor getOpen(long j) {
        return (DataCursor) query((String[]) null, "form_server_id = ? and inspection_state = ? and is_sub_inspection = ? and (deleted is null or deleted = ?)", new String[]{Long.toString(j), InspectionState.OPEN.name(), "0", "0"}, (String) null, (String) null, "creation_date DESC");
    }

    public boolean hasOpen(FormRef formRef) {
        DataCursor open = getOpen(formRef);
        try {
            return open.moveToFirst();
        } finally {
            open.close();
        }
    }

    public int getOpenCount(boolean z) {
        return m5930a(InspectionState.OPEN, z);
    }

    public DataCursor getPending(boolean z) {
        return get(InspectionState.PENDING, z, false, (Long) null);
    }

    public int getPendingCount(boolean z) {
        return m5930a(InspectionState.PENDING, z);
    }

    public float getProgress(long j) {
        ViTaCursor query = query(new String[]{"progress"}, "_id = ?", new String[]{Long.toString(j)}, (String) null, (String) null, (String) null, "1");
        try {
            if (query.moveToFirst()) {
                return query.getFloat(0);
            }
            throw new CursorIndexOutOfBoundsException("There is no (sub-)inspection whith that ID!");
        } finally {
            query.close();
        }
    }

    public Long getTaskId(long j) {
        Long l = null;
        ViTaCursor query = query(new String[]{"_id", InspectionConstants.TASK_ID}, "_id = ?", new String[]{Long.toString(j)}, (String) null, (String) null, (String) null, "1");
        try {
            if (query.moveToFirst() && !query.isNull(InspectionConstants.TASK_ID)) {
                l = Long.valueOf(query.getLong(InspectionConstants.TASK_ID));
            }
            return l;
        } finally {
            query.close();
        }
    }

    public boolean areProjectsEnabled(C1225hy hyVar) {
        boolean z;
        DataCursor dataCursor = (DataCursor) query((String[]) null, "_id = ?", new String[]{Long.toString(hyVar.getInspectionId())}, (String) null, (String) null, (String) null, "1");
        try {
            if (!dataCursor.moveToFirst() || !dataCursor.areProjectsEnabled()) {
                z = false;
            } else {
                z = true;
            }
            return z;
        } finally {
            dataCursor.close();
        }
    }

    public boolean has(InspectionState inspectionState, boolean z) {
        ViTaCursor query;
        if (z) {
            query = query(new String[]{"_id"}, "inspection_state = ? and (deleted is null or deleted = ?)", new String[]{inspectionState.name(), "0"}, (String) null, (String) null, (String) null, "1");
        } else {
            String[] strArr = {"_id"};
            query = query(strArr, ("inspection_state = ? and " + "is_sub_inspection = ? and ") + "(deleted is null or deleted = ?) ", new String[]{inspectionState.name(), "0", "0"}, (String) null, (String) null, (String) null, "1");
        }
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    public boolean hasPending(boolean z) {
        return has(InspectionState.PENDING, z);
    }

    public boolean hasUploadable() {
        ViTaCursor query = query(new String[]{"_id"}, "inspection_state = ? and progress  >= ? and (deleted is null or deleted = ?)", new String[]{InspectionState.OPEN.name(), "1", "0"}, (String) null, (String) null, (String) null, "1");
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    public int setPending() {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(InspectionConstants.INSPECTION_STATE, InspectionState.PENDING.name());
        int update = update(contentValues, "inspection_state = ? and is_sub_inspection = ? and progress >= ?", new String[]{InspectionState.OPEN.name(), "0", "1"});
        Schema.m5981a().f4859c.getTasks().deleteSoft(getPending(false), true);
        return update;
    }

    public boolean setUploadResult(AllInService.UploadWrapper uploadWrapper) {
        String str;
        boolean z = false;
        AppState.getInstance().log().mo8931i("Processing upload result...");
        ContentValues contentValues = new ContentValues();
        boolean a = Schema.getPictures().mo9403a(uploadWrapper.getUploadedPictureIds());
        contentValues.put(InspectionConstants.VIRTUAL_UPLOAD_PROGRESS, Float.valueOf(uploadWrapper.getVirtualProgress()));
        if (uploadWrapper.isInspectionUploadedDuringTask()) {
            contentValues.put("server_id", Long.valueOf(uploadWrapper.getInspectionServerId()));
            a = Schema.getInspectionItems().setServerIds(uploadWrapper.getInspectionItemServerIds()) || a;
        }
        if (uploadWrapper.isFinished()) {
            contentValues.put(InspectionConstants.INSPECTION_STATE, InspectionState.CLOSED.name());
            if (!uploadWrapper.isSavingAllowed()) {
                contentValues.put("deleted", true);
            }
        }
        try {
            if (update(contentValues, "_id = ?", new String[]{Long.toString(uploadWrapper.inspectionId)}) > 0 || a) {
                z = true;
            }
            return z;
        } finally {
            str = "Processing upload result finished";
            AppState.getInstance().log().mo8931i(str);
        }
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1454a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* renamed from: a */
    public long mo9243a(InspectionItemConstants.ItemCursor itemCursor) {
        ViTaCursor query = query(new String[]{"company_server_id"}, "_id = ?", new String[]{Long.toString(itemCursor.getInspectionId())}, (String) null, (String) null, (String) null, "1");
        try {
            if (query.moveToFirst()) {
                return query.getLong(0);
            }
            throw new NullPointerException();
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo9244a(InspectionKey inspectionKey) {
        ViTaCursor query = query("_id = ?", new String[]{Long.toString(inspectionKey.f4798a)}, "title");
        try {
            return query.moveToFirst() ? query.getString("title") : null;
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9247a(long j) {
        boolean z = true;
        ViTaCursor query = query("_id = ?", new String[]{Long.toString(j)}, "project_server_id");
        try {
            if (!query.moveToFirst() || query.isNull("project_server_id")) {
                z = false;
            }
            return z;
        } finally {
            query.close();
        }
    }

    public InspectionKey newInspection(Form form, long j, LongSparseArray<String> longSparseArray, InitialLocation initialLocation) {
        return mo9245a(form, j, (Long) null, (InspectionItemConstants.ItemCursor) null, (ItemActionsTable.ActionKey) null, longSparseArray, initialLocation, (Tasks.TaskCursor) null);
    }

    public InspectionKey newInspection(Form form, Tasks.TaskCursor taskCursor) {
        return mo9245a(form, taskCursor.getCompanyServerId(), taskCursor.getInspectionId(), (InspectionItemConstants.ItemCursor) null, (ItemActionsTable.ActionKey) null, (LongSparseArray<String>) null, (InitialLocation) null, taskCursor);
    }

    /* renamed from: a */
    public InspectionKey mo9245a(Form form, long j, Long l, InspectionItemConstants.ItemCursor itemCursor, ItemActionsTable.ActionKey actionKey, LongSparseArray<String> longSparseArray, InitialLocation initialLocation, Tasks.TaskCursor taskCursor) {
        long insertOrThrow;
        Long l2;
        boolean z = taskCursor != null && !taskCursor.isBeforeFirst() && !taskCursor.isAfterLast();
        boolean z2 = itemCursor != null && !itemCursor.isBeforeFirst() && !itemCursor.isAfterLast();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", form.getTitle());
        contentValues.put("description", form.getDescription());
        contentValues.put("form_server_id", Long.valueOf(form.getServerId()));
        contentValues.put("company_server_id", Long.valueOf(j));
        contentValues.put(InspectionConstants.SAVING_ALLOWED, Boolean.valueOf(form.isSavingAllowed()));
        contentValues.put(InspectionConstants.IS_SUB_INSPECTION, Integer.valueOf(z2 ? 1 : 0));
        contentValues.put(InspectionConstants.INSPECTION_STATE, InspectionState.OPEN.name());
        contentValues.put("creation_date", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("progress", 0);
        contentValues.put(InspectionConstants.PROJECTS_ENABLED, Boolean.valueOf(form.areProjectsEnabled()));
        contentValues.put(InspectionConstants.GUID, UUID.randomUUID().toString());
        if (z2) {
            contentValues.put(InspectionConstants.PARENT_INSPECTION_ID, Long.valueOf(itemCursor.getInspectionId()));
            contentValues.put(InspectionConstants.PARENT_ITEM_ID, Long.valueOf(itemCursor.getId()));
            contentValues.put(InspectionConstants.ACTION_ID, Long.valueOf(actionKey.mo9339b()));
        }
        if (z) {
            OriginKey originKey = taskCursor.getOriginKey();
            contentValues.put(InspectionConstants.TASK_ID, Long.valueOf(taskCursor.getId()));
            contentValues.put(InspectionConstants.TASK_SERVER_ID, Long.valueOf(taskCursor.getServerId()));
            if (originKey != null) {
                contentValues.put(InspectionConstants.ORIGIN_SERVER_ID, Long.valueOf(originKey.getOriginServerId()));
                if (originKey.getOriginInspectionKey() != null) {
                    contentValues.put(InspectionConstants.ORIGIN_ID, Long.valueOf(originKey.getOriginInspectionKey().getInspectionId()));
                }
            }
        }
        if (initialLocation != null) {
            contentValues.put("custom_location_id", Long.valueOf(Schema.m5982b().add(initialLocation)));
        }
        ViTaCursor query = query(new String[]{String.format("max(%s) as %s", new Object[]{InspectionConstants.FORM_ORDINAL, "_count"})}, String.format("%s = ? and %s = ?", new Object[]{"form_server_id", InspectionConstants.INSPECTION_STATE}), new String[]{Long.toString(form.getServerId()), InspectionState.OPEN.name()}, (String) null, (String) null, (String) null);
        try {
            contentValues.put(InspectionConstants.FORM_ORDINAL, Integer.valueOf(query.moveToFirst() ? query.getInt("_count") + 1 : 0));
            if (l != null) {
                contentValues.put("root_inspection_id", l);
                insertOrThrow = insertOrThrow(contentValues);
            } else {
                ContentValues contentValues2 = new ContentValues();
                insertOrThrow = insertOrThrow(contentValues);
                contentValues2.put("root_inspection_id", Long.valueOf(insertOrThrow));
                update(contentValues2, "_id = ?", new String[]{Long.toString(insertOrThrow)});
                l = Long.valueOf(insertOrThrow);
            }
            long[] a = Schema.getInspectionItems().mo9198a(insertOrThrow, form, l.longValue(), longSparseArray);
            long longValue = l.longValue();
            if (z) {
                l2 = Long.valueOf(taskCursor.getId());
            } else {
                l2 = null;
            }
            return new InspectionKey(insertOrThrow, longValue, j, l2, a);
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9246a(long j, Calendar calendar, float f) {
        C1454a aVar = (C1454a) getById(j);
        try {
            if (aVar.moveToFirst()) {
                ContentValues contentValues = new ContentValues(2);
                Long a = aVar.mo9328a();
                contentValues.put(InspectionConstants.MODIFIED_DATE, Long.valueOf(calendar.getTimeInMillis()));
                contentValues.put("progress", Float.valueOf(f));
                update(contentValues, "_id = ?", new String[]{Long.toString(j)});
                if (a != null) {
                    mo9246a(a.longValue(), calendar, Schema.getInspectionItems().mo9199b(a.longValue()));
                }
            }
        } finally {
            aVar.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public DataCursor mo9251b(InspectionKey inspectionKey) {
        return (DataCursor) query((String[]) null, "_id = ?", new String[]{Long.toString(inspectionKey.f4798a)}, (String) null, (String) null, (String) null, "1");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo9252c(InspectionKey inspectionKey) {
        return mo9250b(inspectionKey.f4798a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo9250b(long j) {
        DataCursor byId = getById(j);
        try {
            if (byId.moveToFirst()) {
                return byId.getCompanyServerId();
            }
            throw new NullPointerException("Inspection not available!");
        } finally {
            byId.close();
        }
    }

    /* renamed from: a */
    private int m5930a(InspectionState inspectionState, boolean z) {
        DataCursor dataCursor = get(inspectionState, z, false, (Long) null);
        try {
            return dataCursor.getCount();
        } finally {
            dataCursor.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Long mo9254d(InspectionKey inspectionKey) {
        DataCursor byId = getById(inspectionKey.f4798a);
        try {
            return (!byId.moveToFirst() || !byId.hasProjectServerId()) ? null : byId.getProjectServerId();
        } finally {
            byId.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo9256e(InspectionKey inspectionKey) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("deleted", true);
        update(contentValues, "_id = ?", new String[]{Long.toString(inspectionKey.f4798a)});
        Schema.m5981a().f4859c.getTasks().detachInspection(inspectionKey);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9248a(InspectionKey inspectionKey, Location location, Calendar calendar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InspectionConstants.MODIFIED_DATE, Long.valueOf(calendar.getTimeInMillis()));
        if (location != null) {
            contentValues.put("location_id", Long.valueOf(Schema.m5982b().add(location)));
        }
        if (update(contentValues, "_id = ?", new String[]{Long.toString(inspectionKey.f4799b)}) > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo9242a(InspectionKey inspectionKey, long j, Calendar calendar) {
        long j2 = inspectionKey.f4798a;
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("project_server_id", Long.valueOf(j));
        update(contentValues, "_id = ?", new String[]{Long.toString(inspectionKey.f4798a)});
        float b = Schema.getInspectionItems().mo9199b(j2);
        contentValues.put(InspectionConstants.MODIFIED_DATE, Long.valueOf(calendar.getTimeInMillis()));
        contentValues.put("progress", Float.valueOf(b));
        update(contentValues, "_id = ?", new String[]{Long.toString(inspectionKey.f4798a)});
        return b;
    }

    public boolean hasInspection(OriginKey originKey) {
        return mo9253c(originKey.getOriginServerId()) != null;
    }

    public InspectionKey getInspectionKey(OriginKey originKey) {
        return mo9253c(originKey.getOriginServerId());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public InspectionKey mo9253c(long j) {
        DataCursor dataCursor = (DataCursor) query("server_id = ?", new String[]{Long.toString(j)}, new String[0]);
        try {
            return dataCursor.moveToFirst() ? dataCursor.getKey() : null;
        } finally {
            dataCursor.close();
        }
    }

    public boolean setProjectSelected(InspectionItemsTable inspectionItemsTable, InspectionItemConstants.ItemCursor itemCursor, long j, Location location) {
        return mo9242a(itemCursor.getInspectionKey(), j, Calendar.getInstance()) > BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo9257f(InspectionKey inspectionKey) {
        mo9246a(inspectionKey.getInspectionId(), Calendar.getInstance(), Schema.getInspectionItems().mo9199b(inspectionKey.getInspectionId()));
    }

    public DataCursor getSubInspections(C1225hy hyVar, ItemActionsTable.ActionKey actionKey, boolean z) {
        if (hyVar == null || hyVar.isBeforeFirst() || hyVar.isAfterLast() || actionKey == null) {
            return null;
        }
        return getSubInspections(hyVar.getId(), actionKey.mo9339b(), z);
    }

    public DataCursor getSubInspections(long j, long j2, boolean z) {
        String str;
        String[] strArr;
        if (z) {
            str = "parent_item_id = ? and action_id = ?";
            strArr = new String[]{Long.toString(j), Long.toString(j2)};
        } else {
            str = "parent_item_id = ? and action_id = ? and (deleted is null or deleted = ?)";
            strArr = new String[]{Long.toString(j), Long.toString(j2), Integer.toString(0)};
        }
        return (DataCursor) query(str, strArr, new String[0]);
    }

    public boolean hasSubInspections(C1225hy hyVar, ItemActionsTable.ActionKey actionKey) {
        DataCursor subInspections = getSubInspections(hyVar, actionKey, false);
        if (subInspections == null || subInspections.isClosed() || !subInspections.moveToFirst()) {
            return false;
        }
        return true;
    }

    public boolean isValid(InspectionKey inspectionKey) {
        return Schema.getInspectionItems().mo9199b(inspectionKey.f4798a) >= 1.0f;
    }

    public float getSubInspectionsProgress(long j, long j2, boolean z) {
        DataCursor subInspections = getSubInspections(j, j2, z);
        float count = (float) subInspections.getCount();
        float f = 0.0f;
        for (int i = 0; subInspections.moveToPosition(i); i++) {
            f += getProgress(subInspections.getId());
        }
        if (count == BitmapDescriptorFactory.HUE_RED || f == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        return f / count;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionsTable$a */
    final class C1454a extends ViTaCursor.Instance implements DataCursor {

        /* renamed from: b */
        private final DataCursorStats f4809b;

        private C1454a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
            this.f4809b = new DataCursorStats() {
                public int getFormCount(long j) {
                    int position = C1454a.this.getPosition();
                    int i = 0;
                    for (int i2 = 0; C1454a.this.moveToPosition(i2); i2++) {
                        if (C1454a.this.getFormServerId() == j) {
                            i++;
                        }
                    }
                    C1454a.this.moveToPosition(position);
                    return i;
                }
            };
        }

        public boolean areProjectsEnabled() {
            return getBoolean(InspectionConstants.PROJECTS_ENABLED);
        }

        public void delete() {
            String name = InspectionState.CLOSED.name();
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("deleted", true);
            contentValues.put(InspectionConstants.INSPECTION_STATE, name);
            getWritableDatabase().update(InspectionsTable.this, contentValues, "_id = ?", getIdAsStringArray());
            getWindow().putLong(1, getPosition(), getColumnIndex("deleted"));
            getWindow().putString(name, getPosition(), getColumnIndex(InspectionConstants.INSPECTION_STATE));
        }

        public long getCompanyServerId() {
            return getLong("company_server_id");
        }

        public Date getCreationDate() {
            return new Date(getLong("creation_date"));
        }

        public LocationsTable.LocationsCursor getCustomLocation() {
            if (isNull("custom_location_id")) {
                return null;
            }
            return Schema.m5982b().get(getLong("custom_location_id"));
        }

        public String getDescription() {
            return getString("description");
        }

        public long getFormServerId() {
            return getLong("form_server_id");
        }

        public long[] getItemIds() {
            return Schema.getInspectionItems().mo9196a(getId());
        }

        public InspectionKey getKey() {
            return new InspectionKey(getId(), getRootInspectionId(), getCompanyServerId(), (Long) null, new long[0]);
        }

        public LocationsTable.LocationsCursor getLocation() {
            if (isNull("location_id")) {
                return null;
            }
            return Schema.m5982b().get(getLong("location_id"));
        }

        public Calendar getModifiedDate() {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(getLong(InspectionConstants.MODIFIED_DATE));
            return instance;
        }

        public float getProgress() {
            return getFloat("progress");
        }

        public Long getProjectServerId() {
            if (isNull("project_server_id")) {
                return null;
            }
            return Long.valueOf(getLong("project_server_id"));
        }

        public long getRootInspectionId() {
            return getLong("root_inspection_id");
        }

        public long getServerId() {
            return getLong("server_id");
        }

        public Long getTaskId() {
            if (isNull(InspectionConstants.TASK_ID)) {
                return null;
            }
            return Long.valueOf(getLong(InspectionConstants.TASK_ID));
        }

        public Long getTaskServerId() {
            if (isNull(InspectionConstants.TASK_SERVER_ID)) {
                return null;
            }
            return Long.valueOf(getLong(InspectionConstants.TASK_SERVER_ID));
        }

        public String getTitle() {
            return getString("title");
        }

        public float getVirtualProgress() {
            return getFloat(InspectionConstants.VIRTUAL_UPLOAD_PROGRESS);
        }

        public boolean hasProjectServerId() {
            return !isNull("project_server_id");
        }

        public boolean hasServerId() {
            return !isNull("server_id");
        }

        public boolean hasTask() {
            return !isNull(InspectionConstants.TASK_SERVER_ID);
        }

        public boolean isInspectionUploaded() {
            return hasServerId();
        }

        public boolean isModified() {
            return !isNull(InspectionConstants.MODIFIED_DATE);
        }

        public boolean isSavingAllowed() {
            return getBoolean(InspectionConstants.SAVING_ALLOWED);
        }

        public void setProgress(float f) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("progress", Float.valueOf(f));
            getWritableDatabase().update(InspectionsTable.this, contentValues, "_id = ?", getIdAsStringArray());
            getWindow().putDouble((double) f, getPosition(), getColumnIndexOrThrow("progress"));
        }

        public void setServerId(long j) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("server_id", Long.valueOf(j));
            getWritableDatabase().update(InspectionsTable.this, contentValues, "_id = ?", getIdAsStringArray());
            getWindow().putLong(j, getPosition(), getColumnIndex("server_id"));
        }

        public void setServerId(Long l) {
            ContentValues contentValues = new ContentValues(1);
            if (l == null) {
                contentValues.putNull("server_id");
                InspectionsTable.this.update(contentValues, "_id = ?", getIdAsStringArray());
                getWindow().putNull(getPosition(), getColumnIndex("server_id"));
                return;
            }
            contentValues.put("server_id", l);
            InspectionsTable.this.update(contentValues, "_id = ?", getIdAsStringArray());
            getWindow().putLong(l.longValue(), getPosition(), getColumnIndex("server_id"));
        }

        public JsonObject toJson() {
            return Schema.m5981a().f4860d.toJsonTree(this, C1454a.class).getAsJsonObject();
        }

        public PicturesTable.PicturesCursor getPicturesFromRoot() {
            return Schema.getPictures().mo9402a((DataCursor) this);
        }

        public long getOriginServerId() {
            return getLong(InspectionConstants.ORIGIN_SERVER_ID);
        }

        public boolean hasOriginServerId() {
            return !isNull(InspectionConstants.ORIGIN_SERVER_ID);
        }

        public DataCursorStats getStats() {
            return this.f4809b;
        }

        public int getFormOrdinal() {
            return getInt(InspectionConstants.FORM_ORDINAL);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Long mo9328a() {
            if (isNull(InspectionConstants.PARENT_INSPECTION_ID)) {
                return null;
            }
            return Long.valueOf(getLong(InspectionConstants.PARENT_INSPECTION_ID));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p006nl.volkerinfradesign.checkandroid.environments.UpdateResult downloadInspection(p006nl.volkerinfradesign.checkandroid.environments.OriginKey r7) {
        /*
            r6 = this;
            com.google.gson.GsonBuilder r0 = new com.google.gson.GsonBuilder
            r0.<init>()
            com.google.gson.GsonBuilder r0 = r0.setPrettyPrinting()
            java.lang.Class<nl.volkerinfradesign.checkandroid.database.UpdateResultImp> r1 = p006nl.volkerinfradesign.checkandroid.database.UpdateResultImp.class
            com.google.gson.JsonDeserializer<nl.volkerinfradesign.checkandroid.database.UpdateResultImp> r2 = r6.f4803a
            com.google.gson.GsonBuilder r0 = r0.registerTypeAdapter(r1, r2)
            com.google.gson.Gson r2 = r0.create()
            r1 = 0
            com.google.gson.JsonArray r0 = new com.google.gson.JsonArray
            r0.<init>()
            com.google.gson.JsonPrimitive r3 = new com.google.gson.JsonPrimitive
            long r4 = r7.getOriginServerId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3.<init>((java.lang.Number) r4)
            r0.add(r3)
            com.google.gson.JsonObject r3 = new com.google.gson.JsonObject
            r3.<init>()
            java.lang.String r4 = "ids"
            r3.add(r4, r0)
            com.google.gson.JsonObject r4 = new com.google.gson.JsonObject
            r4.<init>()
            java.lang.String r0 = "params"
            r4.add(r0, r3)
            java.lang.String r0 = "session"
            nl.volkerinfradesign.checkandroid.AppState r3 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
            com.google.gson.JsonObject r3 = r3.getSIDJSON()
            r4.add(r0, r3)
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ IOException -> 0x0092, all -> 0x00c7 }
            java.net.URL r0 = r0.getDownloadInspectionsUrl()     // Catch:{ IOException -> 0x0092, all -> 0x00c7 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x0092, all -> 0x00c7 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0092, all -> 0x00c7 }
            java.lang.String r1 = "POST"
            r0.setRequestMethod(r1)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            r1 = 1
            r0.setDoInput(r1)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            java.io.OutputStream r3 = r0.getOutputStream()     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            java.lang.String r1 = r2.toJson((com.google.gson.JsonElement) r4)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            byte[] r1 = r1.getBytes()     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            r3.write(r1)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            java.io.InputStream r4 = r0.getInputStream()     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            java.lang.String r1 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r4)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            java.lang.Class<nl.volkerinfradesign.checkandroid.database.UpdateResultImp> r5 = p006nl.volkerinfradesign.checkandroid.database.UpdateResultImp.class
            java.lang.Object r1 = r2.fromJson((java.lang.String) r1, r5)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            nl.volkerinfradesign.checkandroid.database.UpdateResultImp r1 = (p006nl.volkerinfradesign.checkandroid.database.UpdateResultImp) r1     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.OutputStream) r3)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.InputStream) r4)     // Catch:{ IOException -> 0x00d5, all -> 0x00cf }
            if (r0 == 0) goto L_0x0091
            r0.disconnect()
        L_0x0091:
            return r1
        L_0x0092:
            r0 = move-exception
            r2 = r1
        L_0x0094:
            nl.volkerinfradesign.checkandroid.AppState r1 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x00d3 }
            r1.invalidateLogin(r2)     // Catch:{ all -> 0x00d3 }
            java.io.InputStream r1 = r2.getErrorStream()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r1 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r1)     // Catch:{ Exception -> 0x00b7 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x00b7 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00b7 }
            r3.printStackTrace()     // Catch:{ Exception -> 0x00b7 }
            nl.volkerinfradesign.checkandroid.database.UpdateResultImp r1 = new nl.volkerinfradesign.checkandroid.database.UpdateResultImp     // Catch:{ Exception -> 0x00b7 }
            r4 = 0
            r1.<init>((boolean) r4, (java.lang.Exception) r3)     // Catch:{ Exception -> 0x00b7 }
            if (r2 == 0) goto L_0x0091
            r2.disconnect()
            goto L_0x0091
        L_0x00b7:
            r1 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00d3 }
            nl.volkerinfradesign.checkandroid.database.UpdateResultImp r1 = new nl.volkerinfradesign.checkandroid.database.UpdateResultImp     // Catch:{ all -> 0x00d3 }
            r3 = 0
            r1.<init>((boolean) r3, (java.lang.Exception) r0)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x0091
            r2.disconnect()
            goto L_0x0091
        L_0x00c7:
            r0 = move-exception
            r2 = r1
        L_0x00c9:
            if (r2 == 0) goto L_0x00ce
            r2.disconnect()
        L_0x00ce:
            throw r0
        L_0x00cf:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x00c9
        L_0x00d3:
            r0 = move-exception
            goto L_0x00c9
        L_0x00d5:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.database.InspectionsTable.downloadInspection(nl.volkerinfradesign.checkandroid.environments.OriginKey):nl.volkerinfradesign.checkandroid.environments.UpdateResult");
    }
}
