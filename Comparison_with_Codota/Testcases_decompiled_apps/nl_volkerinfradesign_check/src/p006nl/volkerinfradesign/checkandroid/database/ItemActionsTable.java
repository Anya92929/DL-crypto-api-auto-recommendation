package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.DbUtil;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.database.ItemActionsTable */
public final class ItemActionsTable extends Table {

    /* renamed from: nl.volkerinfradesign.checkandroid.database.ItemActionsTable$ActionCursor */
    public interface ActionCursor extends ViTaCursor {
        List getConditions();

        String getDescription();

        long getSubFormId();

        String getTitle();

        boolean hasSubFormId();

        boolean isTable();
    }

    ItemActionsTable() {
        super("inspection_item_actions_table");
        putColumn("title", Column.DataType.TEXT).notNull();
        putColumn(ActionColumns.DESCRIPTION, Column.DataType.TEXT);
        putColumn("sub_form_id", Column.DataType.INTEGER);
        putColumn("form_item_server_id", Column.DataType.INTEGER).notNull();
        putColumn("conditions", Column.DataType.TEXT).notNull();
        putColumn(InspectionItemConstants.ORDINAL, Column.DataType.INTEGER).notNull();
        putColumn("is_table", Column.DataType.INTEGER);
    }

    public long[] putAll(JsonArray jsonArray, long j) {
        long[] jArr;
        boolean z;
        if (jsonArray == null || jsonArray.size() == 0) {
            jArr = new long[0];
        } else {
            long[] jArr2 = new long[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                ContentValues contentValues = new ContentValues(6);
                JsonObject asJsonObject = jsonArray.get(i).getAsJsonObject();
                if (!asJsonObject.has("isTable") || !asJsonObject.get("isTable").getAsBoolean()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!asJsonObject.has(ActionColumns.DESCRIPTION) || !StringUtils.isNotBlank(asJsonObject.get(ActionColumns.DESCRIPTION).getAsString())) {
                    contentValues.putNull(ActionColumns.DESCRIPTION);
                } else {
                    contentValues.put(ActionColumns.DESCRIPTION, asJsonObject.get(ActionColumns.DESCRIPTION).getAsString().trim());
                }
                contentValues.put("title", asJsonObject.get("title").getAsString());
                contentValues.put("is_table", Boolean.valueOf(z));
                JsonElement jsonElement = asJsonObject.get("conditions");
                if (jsonElement != null) {
                    contentValues.put("conditions", jsonElement.getAsJsonArray().toString());
                } else {
                    contentValues.putNull("conditions");
                }
                contentValues.put("form_item_server_id", Long.valueOf(j));
                contentValues.put(InspectionItemConstants.ORDINAL, Integer.valueOf(i));
                if (asJsonObject.has("subFormInspectionId")) {
                    contentValues.put("sub_form_id", Long.valueOf(asJsonObject.get("subFormInspectionId").getAsLong()));
                }
                jArr2[i] = insert(contentValues);
            }
            jArr = jArr2;
        }
        DbUtil.Argumenter argumenter = DbUtil.getArgumenter(jArr);
        delete("_id not in " + argumenter.getSelection(true) + " and " + "form_item_server_id" + " = ?", (String[]) ArrayUtils.add((T[]) argumenter.getSelectionArgs(), Long.toString(j)));
        return jArr;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public ActionKey mo9329a(C1225hy hyVar) {
        ActionCursor actionCursor = (ActionCursor) query("form_item_server_id = ?", new String[]{Long.toString(hyVar.getFormItemServerId())}, new String[0]);
        int i = 0;
        while (actionCursor.moveToPosition(i)) {
            try {
                List conditions = actionCursor.getConditions();
                if (conditions == null || conditions.isEmpty() || (hyVar.hasValue() && m5947a(hyVar, conditions))) {
                    ActionKey actionKey = new ActionKey(hyVar, actionCursor);
                    actionCursor.close();
                    return actionKey;
                }
                i++;
            } catch (Throwable th) {
                actionCursor.close();
                throw th;
            }
        }
        actionCursor.close();
        return null;
    }

    /* renamed from: a */
    private boolean m5947a(InspectionItemConstants.ItemCursor itemCursor, List<String> list) {
        if (list == null) {
            return true;
        }
        switch (itemCursor.getType()) {
            case MULTICHOICE:
                for (String contains : (String[]) itemCursor.getValue()) {
                    if (list.contains(contains)) {
                        return true;
                    }
                }
                return false;
            default:
                return list.contains(itemCursor.getStringValue());
        }
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            /* renamed from: a */
            public ActionCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1459a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.ItemActionsTable$ActionKey */
    public static final class ActionKey implements Parcelable {
        public static final Parcelable.Creator<ActionKey> CREATOR = new Parcelable.Creator<ActionKey>() {
            /* renamed from: a */
            public ActionKey createFromParcel(Parcel parcel) {
                return new ActionKey(parcel);
            }

            /* renamed from: a */
            public ActionKey[] newArray(int i) {
                return new ActionKey[i];
            }
        };

        /* renamed from: a */
        final long f4813a;

        /* renamed from: b */
        final long f4814b;

        /* renamed from: c */
        final long f4815c;

        /* renamed from: d */
        final long f4816d;

        /* renamed from: e */
        final long f4817e;

        /* renamed from: f */
        final long f4818f;

        /* renamed from: g */
        final String f4819g;

        /* renamed from: h */
        final boolean f4820h;

        /* renamed from: i */
        final boolean f4821i;

        public ActionKey(C1225hy hyVar, ActionCursor actionCursor) {
            this.f4813a = actionCursor.getId();
            this.f4818f = actionCursor.getSubFormId();
            this.f4816d = hyVar.getId();
            this.f4819g = hyVar.getTitle();
            this.f4814b = hyVar.getInspectionId();
            this.f4817e = hyVar.getRootInspectionId();
            this.f4815c = hyVar.mo8378d();
            this.f4820h = hyVar.mo8376c();
            this.f4821i = actionCursor.isTable();
        }

        private ActionKey(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.f4813a = parcel.readLong();
            this.f4818f = parcel.readLong();
            this.f4816d = parcel.readLong();
            this.f4819g = parcel.readString();
            this.f4814b = parcel.readLong();
            this.f4817e = parcel.readLong();
            this.f4815c = parcel.readLong();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f4820h = z;
            this.f4821i = parcel.readInt() != 1 ? false : z2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeLong(this.f4813a);
            parcel.writeLong(this.f4818f);
            parcel.writeLong(this.f4816d);
            parcel.writeString(this.f4819g);
            parcel.writeLong(this.f4814b);
            parcel.writeLong(this.f4817e);
            parcel.writeLong(this.f4815c);
            if (this.f4820h) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.f4821i) {
                i3 = 0;
            }
            parcel.writeInt(i3);
        }

        /* renamed from: a */
        public boolean mo9338a() {
            return FileSystem.get().getFormsDir().hasForm(this.f4818f);
        }

        /* renamed from: b */
        public long mo9339b() {
            return this.f4813a;
        }

        /* renamed from: c */
        public long mo9340c() {
            return this.f4818f;
        }

        /* renamed from: d */
        public boolean mo9341d() {
            return this.f4821i;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.ItemActionsTable$a */
    class C1459a extends ViTaCursor.Instance implements ActionCursor {
        public C1459a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public List<String> getConditions() {
            String string = getString("conditions");
            if (string == null) {
                return null;
            }
            JsonArray asJsonArray = new JsonParser().parse(string).getAsJsonArray();
            ArrayList arrayList = new ArrayList();
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getAsString());
            }
            return arrayList;
        }

        public String getDescription() {
            return getString(ActionColumns.DESCRIPTION);
        }

        public long getSubFormId() {
            return getLong("sub_form_id");
        }

        public String getTitle() {
            return getString("title");
        }

        public boolean hasSubFormId() {
            return !isNull("sub_form_id");
        }

        public boolean isTable() {
            return ItemActionsTable.this.getColumn("is_table") != null && !isNull("is_table") && getBoolean("is_table");
        }
    }
}
