package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.data.FormsDir;
import p006nl.volkerinfradesign.checkandroid.database.InspectionConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.environments.Account;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.environments.OriginKey;
import p006nl.volkerinfradesign.checkandroid.environments.Tasks;
import p006nl.volkerinfradesign.checkandroid.services.tasks.TasksCallback;
import p006nl.volkerinfradesign.checkandroid.services.tasks.TasksParam;
import p006nl.volkerinfradesign.checkandroid.services.tasks.TasksService;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.DbUtil;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTa;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.TasksImp */
class TasksImp extends Table implements Tasks {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final CheckEnvironment f4925a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f4926c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final DataSetObservable f4927d = new DataSetObservable();

    public TasksImp(CheckEnvironment checkEnvironment) {
        super(checkEnvironment.params.nameSpace.toString() + "todos");
        this.f4925a = checkEnvironment;
        this.f4926c = new Handler(checkEnvironment.params.context.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case -2:
                        TasksImp.this.f4927d.notifyInvalidated();
                        return;
                    case -1:
                        TasksImp.this.f4927d.notifyChanged();
                        return;
                    default:
                        return;
                }
            }
        };
        putColumn("title", Column.DataType.TEXT).notNull();
        putColumn("description", Column.DataType.TEXT);
        putColumn("server_id", Column.DataType.INTEGER).notNull();
        putColumn("inspection_server_id", Column.DataType.INTEGER);
        putColumn("form_server_id", Column.DataType.INTEGER);
        putColumn("deadline", Column.DataType.INTEGER);
        putColumn("mod", Column.DataType.INTEGER).notNull();
        putColumn(InspectionItemConstants.INSPECTION_ID, Column.DataType.INTEGER);
        putColumn("company_server_id", Column.DataType.INTEGER).notNull();
        putColumn("project_server_id", Column.DataType.INTEGER);
        putColumn("deleted", Column.DataType.INTEGER).notNull().defaultValue((Number) 0);
        putColumn("user_name", Column.DataType.TEXT);
        putColumn("email", Column.DataType.TEXT);
        putColumn("phone_number", Column.DataType.TEXT);
        putColumn("reason", Column.DataType.TEXT);
        putColumn("cancelled", Column.DataType.INTEGER).notNull().defaultValue((Number) 0);
        putColumn("delegated_person_server_id", Column.DataType.INTEGER);
        putColumn("delegated", Column.DataType.INTEGER).notNull().defaultValue((Number) 0);
        putColumn("reason_delegated", Column.DataType.TEXT);
        putColumn("inspection_name", Column.DataType.TEXT);
    }

    public boolean deleteSoft(InspectionsTable.DataCursor dataCursor, boolean z) {
        if (z) {
            HashSet hashSet = new HashSet();
            for (int i = 0; dataCursor.moveToPosition(i); i++) {
                Long taskId = dataCursor.getTaskId();
                if (taskId != null) {
                    hashSet.add(taskId);
                }
            }
            return m6016a(ArrayUtils.toPrimitive((Long[]) hashSet.toArray(new Long[hashSet.size()])));
        }
        Long taskId2 = dataCursor.getTaskId();
        if (taskId2 == null) {
            return false;
        }
        return m6016a(taskId2.longValue());
    }

    public boolean deleteSoft(Tasks.TaskCursor taskCursor) {
        return m6016a(taskCursor.getId());
    }

    public boolean detachInspection(InspectionKey inspectionKey) {
        Long taskId = inspectionKey.getTaskId();
        if (taskId == null) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.putNull(InspectionItemConstants.INSPECTION_ID);
        if (update(contentValues, "_id = ?", new String[]{taskId.toString()}) <= 0) {
            return true;
        }
        this.f4926c.sendEmptyMessage(-1);
        return true;
    }

    public void download(boolean z, TasksCallback tasksCallback) {
        TasksParam tasksParam = new TasksParam(this.f4925a.getAccount(), m6014a(), m6017b());
        TasksCallback a = m6015a(tasksCallback);
        if (z) {
            new TasksService(a).executeOnExecutor(TasksService.THREAD_POOL_EXECUTOR, new TasksParam[]{tasksParam});
            return;
        }
        TasksService.download(tasksParam, a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ContentValues m6011a(JsonObject jsonObject, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", jsonObject.get("title").getAsString());
        contentValues.put("server_id", Long.valueOf(j));
        contentValues.put("mod", Long.valueOf(jsonObject.get(Account.MODIFIED).getAsLong()));
        contentValues.put("company_server_id", Long.valueOf(jsonObject.get("companyId").getAsLong()));
        if (jsonObject.has("projectId")) {
            contentValues.put("project_server_id", Long.valueOf(jsonObject.get("projectId").getAsLong()));
        }
        if (jsonObject.has("description")) {
            contentValues.put("description", jsonObject.get("description").getAsString());
        }
        if (jsonObject.has("reasonDelegated")) {
            contentValues.put("reason_delegated", jsonObject.get("reasonDelegated").getAsString());
        }
        if (jsonObject.has("inspectionName")) {
            contentValues.put("inspection_name", jsonObject.get("inspectionName").getAsString());
        }
        if (jsonObject.has("deadline")) {
            contentValues.put("deadline", Long.valueOf(jsonObject.get("deadline").getAsLong()));
        }
        if (jsonObject.has("inspectionId")) {
            contentValues.put("inspection_server_id", Long.valueOf(jsonObject.get("inspectionId").getAsLong()));
        }
        if (jsonObject.has("subFormInspectionId")) {
            contentValues.put("form_server_id", Long.valueOf(jsonObject.get("subFormInspectionId").getAsLong()));
        }
        if (jsonObject.has("actionInitiator")) {
            JsonObject asJsonObject = jsonObject.get("actionInitiator").getAsJsonObject();
            String str = "";
            if (asJsonObject.has("firstName")) {
                str = str + asJsonObject.get("firstName").getAsString().trim();
            }
            if (asJsonObject.has("middleName")) {
                str = str.trim() + " " + asJsonObject.get("middleName").getAsString();
            }
            if (asJsonObject.has("lastName")) {
                str = str.trim() + " " + asJsonObject.get("lastName").getAsString();
            }
            if (StringUtils.isNotBlank(str)) {
                contentValues.put("user_name", str.trim());
            }
            if (asJsonObject.has("email") && StringUtils.isNotBlank(asJsonObject.get("email").getAsString())) {
                contentValues.put("email", asJsonObject.get("email").getAsString().trim());
            }
            if (asJsonObject.has("phoneMobile") && StringUtils.isNotBlank(asJsonObject.get("phoneMobile").getAsString())) {
                contentValues.put("phone_number", asJsonObject.get("phoneMobile").getAsString().trim());
            }
        }
        return contentValues;
    }

    /* renamed from: a */
    private JsonArray m6014a() {
        int i = 0;
        JsonArray jsonArray = new JsonArray();
        C1519a aVar = (C1519a) query("cancelled", (String[]) null, new String[0]);
        while (aVar.moveToPosition(i)) {
            try {
                JsonObject jsonObject = new JsonObject();
                String b = aVar.mo9678b();
                jsonObject.addProperty("actionId", (Number) Long.valueOf(aVar.getServerId()));
                if (StringUtils.isNotBlank(b)) {
                    jsonObject.addProperty("reason", b);
                }
                jsonArray.add(jsonObject);
                i++;
            } finally {
                aVar.close();
            }
        }
        return jsonArray;
    }

    /* renamed from: b */
    private JsonArray m6017b() {
        int i = 0;
        JsonArray jsonArray = new JsonArray();
        C1519a aVar = (C1519a) query("delegated", (String[]) null, new String[0]);
        while (aVar.moveToPosition(i)) {
            try {
                JsonObject jsonObject = new JsonObject();
                String b = aVar.mo9678b();
                jsonObject.addProperty("actionId", (Number) Long.valueOf(aVar.getServerId()));
                jsonObject.addProperty("toUserId", (Number) Long.valueOf(aVar.mo9679c()));
                if (StringUtils.isNotBlank(b)) {
                    jsonObject.addProperty("reason", b);
                }
                jsonArray.add(jsonObject);
                i++;
            } finally {
                aVar.close();
            }
        }
        return jsonArray;
    }

    public Tasks.TaskCursor getAll() {
        return (Tasks.TaskCursor) query((String[]) null, "deleted != 1", (String[]) null, (String) null, (String) null, "deadline asc, mod asc, server_id");
    }

    public int getCount() {
        Tasks.TaskCursor all = getAll();
        try {
            return all.moveToFirst() ? all.getCount() : 0;
        } finally {
            all.close();
        }
    }

    public boolean hasSendableTasks() {
        Cursor rawQuery = ViTa.getReadableDatabase().rawQuery((("select t._id, i.progress" + "\nfrom " + getName() + " t join " + Schema.getInspectionData().getName() + " i on t." + "_id" + " = i." + InspectionConstants.TASK_ID) + "\nwhere i.progress >= 1 and t.deleted = 0") + "\nlimit 1", (String[]) null, this, Schema.getInspectionData());
        try {
            return rawQuery.moveToFirst();
        } finally {
            rawQuery.close();
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f4927d.registerObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f4927d.unregisterObserver(dataSetObserver);
    }

    public Tasks.TaskCursor get(Tasks.TaskKey taskKey) {
        return (Tasks.TaskCursor) query("_id = ?", ((TaskKeyImp) taskKey).mo9662a(), new String[0]);
    }

    public void cancel(Tasks.TaskKey taskKey, String str) {
        if (StringUtils.isNotBlank(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("deleted", 1);
            contentValues.put("reason", str);
            contentValues.put("cancelled", 1);
            update(contentValues, "_id = ?", ((TaskKeyImp) taskKey).mo9662a());
        }
    }

    public void setDelegated(Tasks.TaskKey taskKey, Accounts.Profile.Person person, String str) {
        if (person != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("deleted", 1);
            contentValues.put("delegated_person_server_id", Long.valueOf(person.getServerId()));
            contentValues.put("delegated", 1);
            contentValues.put("reason", str);
            update(contentValues, "_id = ?", ((TaskKeyImp) taskKey).mo9662a());
        }
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            /* renamed from: a */
            public C1519a newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1519a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* renamed from: a */
    private boolean m6016a(long... jArr) {
        boolean z = false;
        if (!(jArr == null || jArr.length == 0)) {
            DbUtil.Argumenter argumenter = DbUtil.getArgumenter(jArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("deleted", true);
            if (update(contentValues, "_id in " + argumenter.getSelection(true), argumenter.getSelectionArgs()) > 0) {
                z = true;
            }
            if (z) {
                this.f4926c.sendEmptyMessage(-1);
            }
        }
        return z;
    }

    /* renamed from: a */
    private TasksCallback m6015a(final TasksCallback tasksCallback) {
        return new TasksCallback() {
            public void onStart() {
                if (tasksCallback != null) {
                    tasksCallback.onStart();
                }
            }

            public void onError(Exception exc) {
                if (tasksCallback != null) {
                    tasksCallback.onError(exc);
                }
            }

            public void onSessionExpired(Exception exc) {
                TasksImp.this.f4925a.logout((Model.LogoutFinishedCallback) null);
                if (tasksCallback != null) {
                    tasksCallback.onSessionExpired(exc);
                }
                AppState.getInstance().invalidateLogin();
            }

            public void onSuccess(JsonArray jsonArray) {
                boolean z;
                boolean z2 = false;
                HashSet hashSet = new HashSet();
                if (jsonArray == null || !jsonArray.isJsonArray()) {
                    z = false;
                } else {
                    Iterator<JsonElement> it = jsonArray.getAsJsonArray().iterator();
                    z = false;
                    while (it.hasNext()) {
                        JsonObject asJsonObject = it.next().getAsJsonObject();
                        long asLong = asJsonObject.get("id").getAsLong();
                        ContentValues a = TasksImp.this.m6011a(asJsonObject, asLong);
                        a.put("deleted", 0);
                        a.put("cancelled", 0);
                        a.putNull("reason");
                        a.put("delegated", 0);
                        a.putNull("reason_delegated");
                        hashSet.add(Long.valueOf(asLong));
                        if (TasksImp.this.update(a, "server_id = ?", new String[]{Long.toString(asLong)}) == 0) {
                            TasksImp.this.insert(a);
                        }
                        z = true;
                    }
                }
                if (!hashSet.isEmpty()) {
                    DbUtil.Argumenter argumenter = DbUtil.getArgumenter((Collection<Long>) hashSet);
                    if (TasksImp.this.delete("server_id not in " + argumenter.getSelection(true), argumenter.getSelectionArgs()) > 0 || z) {
                        z2 = true;
                    }
                } else if (TasksImp.this.delete((String) null, (String[]) null) > 0 || z) {
                    z2 = true;
                }
                if (z2) {
                    TasksImp.this.f4926c.sendEmptyMessage(-1);
                }
                if (tasksCallback != null) {
                    tasksCallback.onSuccess(jsonArray);
                }
            }
        };
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.TasksImp$a */
    final class C1519a extends ViTaCursor.Instance implements Tasks.TaskCursor {
        public C1519a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public long getCompanyServerId() {
            return getLong("company_server_id");
        }

        public Calendar getDeadLineDate() {
            Calendar instance = Calendar.getInstance(Locale.getDefault());
            instance.setTimeInMillis(mo9677a());
            return instance;
        }

        /* renamed from: a */
        public long mo9677a() {
            return getLong("deadline");
        }

        public String getDescription() {
            return getString("description");
        }

        public boolean hasDescription() {
            return !isNull("description") && StringUtils.isNotBlank(getString("description"));
        }

        public Long getFormServerId() {
            if (!isNull("form_server_id")) {
                return Long.valueOf(getLong("form_server_id"));
            }
            return null;
        }

        public Long getInspectionId() {
            if (isNull(InspectionItemConstants.INSPECTION_ID)) {
                return null;
            }
            return Long.valueOf(getLong(InspectionItemConstants.INSPECTION_ID));
        }

        public Long getOriginServerId() {
            if (isNull("inspection_server_id")) {
                return null;
            }
            return Long.valueOf(getLong("inspection_server_id"));
        }

        public InspectionKey getKey() {
            if (isInstantiated()) {
                return InspectionKey.newInstance(this);
            }
            throw new IllegalStateException("The object is not yet instantiated!");
        }

        public float getProgress() {
            return Schema.getInspectionData().getProgress(getInspectionId().longValue());
        }

        public long getServerId() {
            return getLong("server_id");
        }

        public String getTitle() {
            return getString("title");
        }

        public boolean hasOriginServerId() {
            return !isNull("inspection_server_id");
        }

        public InspectionKey instantiate() {
            if (isInstantiated()) {
                throw new IllegalStateException("already created!");
            }
            FormsDir formsDir = FileSystem.get().getFormsDir();
            if (!(getFormServerId() != null && formsDir.hasForm(getFormServerId().longValue()))) {
                throw new NullPointerException("Form not available");
            }
            InspectionKey newInspection = Schema.getInspectionData().newInspection(formsDir.loadForm(getFormServerId().longValue()), this);
            ContentValues contentValues = new ContentValues();
            contentValues.put(InspectionItemConstants.INSPECTION_ID, Long.valueOf(newInspection.getInspectionId()));
            if (TasksImp.this.update(contentValues, "_id = ?", getIdAsStringArray()) > 0) {
                TasksImp.this.f4926c.sendEmptyMessage(-1);
                return newInspection;
            }
            throw new NullPointerException("Could not update the task, because it could not be found!");
        }

        public boolean isInstantiated() {
            return !isNull(InspectionItemConstants.INSPECTION_ID);
        }

        public boolean hasInitiatorPhone() {
            return !isNull("phone_number") && StringUtils.isNotBlank(getString("phone_number"));
        }

        public boolean hasInitiatorEmail() {
            return !isNull("email") && StringUtils.isNotBlank(getString("email"));
        }

        public String getInitiatorPhone() {
            return getString("phone_number");
        }

        public String getInitiatorEmail() {
            return getString("email");
        }

        public String getInitiatorName() {
            return getString("user_name");
        }

        public boolean isOriginDownloaded() {
            return Schema.getInspectionData().hasInspection(getOriginKey());
        }

        public InspectionKey getOriginInspectionKey() {
            return Schema.getInspectionData().getInspectionKey(getOriginKey());
        }

        public OriginKey getOriginKey() {
            return new OriginKeyImp(getOriginServerId());
        }

        public boolean hasInitiatorName() {
            return !isNull("user_name");
        }

        public Tasks.TaskKey getTaskKey() {
            return new TaskKeyImp((Tasks.TaskCursor) this);
        }

        public boolean hasInspectionName() {
            return !isNull("inspection_name");
        }

        public String getInspectionName() {
            if (!isNull("inspection_name")) {
                return getString("inspection_name");
            }
            return null;
        }

        /* renamed from: b */
        public String mo9678b() {
            if (!isNull("reason")) {
                return getString("reason");
            }
            return null;
        }

        /* renamed from: c */
        public long mo9679c() {
            return (!isNull("delegated_person_server_id") ? Long.valueOf(getLong("delegated_person_server_id")) : null).longValue();
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.TasksImp$OriginKeyImp */
    static final class OriginKeyImp implements OriginKey {
        public static final Parcelable.Creator<OriginKeyImp> CREATOR = new Parcelable.Creator<OriginKeyImp>() {
            /* renamed from: a */
            public OriginKeyImp createFromParcel(Parcel parcel) {
                return new OriginKeyImp(parcel);
            }

            /* renamed from: a */
            public OriginKeyImp[] newArray(int i) {
                return new OriginKeyImp[0];
            }
        };

        /* renamed from: a */
        private final Long f4932a;

        OriginKeyImp(Long l) {
            this.f4932a = l;
        }

        public OriginKeyImp(Parcel parcel) {
            this.f4932a = parcel.readInt() == 1 ? Long.valueOf(parcel.readLong()) : null;
        }

        public long getOriginServerId() {
            return this.f4932a.longValue();
        }

        public boolean hasOriginServerId() {
            return this.f4932a != null;
        }

        public InspectionKey getOriginInspectionKey() {
            return Schema.getInspectionData().getInspectionKey(this);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (this.f4932a != null) {
                parcel.writeInt(1);
                parcel.writeLong(this.f4932a.longValue());
                return;
            }
            parcel.writeInt(0);
        }
    }
}
