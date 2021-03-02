package p000;

import android.content.ContentValues;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;
import android.location.Location;
import android.support.p001v4.util.LongSparseArray;
import android.util.Pair;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.data.FormsDir;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemsTable;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.ItemActionsTable;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;
import p006nl.volkerinfradesign.checkandroid.database.PictureKey;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.environments.Tasks;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: hy */
public final class C1225hy extends ViTaCursor.Instance implements InspectionItemConstants, InspectionItemConstants.HeaderCursor, InspectionItemConstants.ItemCursor {

    /* renamed from: a */
    private final JsonParser f4335a = new JsonParser();

    /* renamed from: b */
    private final C1230a f4336b;

    /* renamed from: hy$a */
    public interface C1230a {
        void addCursor(C1225hy hyVar);

        void removeCursor(C1225hy hyVar);
    }

    public C1225hy(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery, C1230a aVar) {
        super(sQLiteCursorDriver, str, sQLiteQuery);
        this.f4336b = aVar;
        aVar.addCursor(this);
    }

    public void close() {
        this.f4336b.removeCursor(this);
        super.close();
    }

    public JsonArray getHyperlinks() {
        try {
            if (isNull(InspectionItemConstants.HYPERLINKS)) {
                return null;
            }
            return this.f4335a.parse(getString(InspectionItemConstants.HYPERLINKS)).getAsJsonArray();
        } catch (Exception e) {
            return null;
        }
    }

    public JsonArray getChoices() {
        InspectionItemType type = getType();
        switch (type) {
            case SINGLECHOICE:
            case MULTICHOICE:
                if (isNull(InspectionItemConstants.CHOICES)) {
                    return new JsonArray();
                }
                return this.f4335a.parse(getString(InspectionItemConstants.CHOICES)).getAsJsonArray();
            default:
                throw new IllegalStateException("wrong InspectionItemType: " + type.name());
        }
    }

    public LocationsTable.LocationsCursor getCustomLocation() {
        return Schema.m5982b().get(getLong("custom_location_id"));
    }

    public String getDescription() {
        return getString("description");
    }

    public String getDescriptiveImageUrl() {
        return getString(InspectionItemConstants.DESCRIPTIVE_IMAGE_URL);
    }

    public long getFormItemServerId() {
        if (!isNull("form_item_server_id")) {
            return getLong("form_item_server_id");
        }
        throw new IllegalStateException("There is no formItemServerId available! (type: " + getType() + ")");
    }

    public PictureKey[] getImages() {
        return Schema.getPictures().mo9404a((InspectionItemConstants.ItemCursor) this);
    }

    public long getInspectionId() {
        return getLong(InspectionItemConstants.INSPECTION_ID);
    }

    public InspectionKey getInspectionKey() {
        return new InspectionKey((InspectionItemConstants.ItemCursor) this);
    }

    public InspectionItemKey getKey() {
        return new InspectionItemKey((InspectionItemConstants.ItemCursor) this);
    }

    public LocationsTable.LocationsCursor getlocation() {
        if (isNull("location_id")) {
            return null;
        }
        return Schema.m5982b().get(getLong("location_id"));
    }

    public long getModifiedMillis() {
        return getLong("mod_date");
    }

    public int getOrdinal() {
        return getInt(InspectionItemConstants.ORDINAL);
    }

    public InspectionItemsTable.RecordType getRecordType() {
        return InspectionItemsTable.RecordType.valueOf(getString(InspectionItemConstants.RECORD_TYPE));
    }

    public String getRemark() {
        return getString(InspectionItemConstants.REMARK);
    }

    public long getRootInspectionId() {
        return getLong("root_inspection_id");
    }

    public Long getServerId() {
        if (isNull("form_item_server_id")) {
            return null;
        }
        return Long.valueOf(getLong("form_item_server_id"));
    }

    public String getStringValue() {
        return getType().mo9176a(getString(InspectionItemConstants.INSPECTION_ITEM_VALUE));
    }

    public String getTitle() {
        return getString("title");
    }

    public InspectionItemType getType() {
        return InspectionItemType.valueOf(getString(getColumnIndex(InspectionItemConstants.INSPECTION_ITEM_TYPE)));
    }

    public Object getValue() {
        return getType().getValue(getString(InspectionItemConstants.INSPECTION_ITEM_VALUE));
    }

    public boolean hasCustomlocation() {
        return !isNull("custom_location_id");
    }

    public boolean hasDescriptiveImageUrl() {
        return !isNull(InspectionItemConstants.DESCRIPTIVE_IMAGE_URL) && getString(InspectionItemConstants.DESCRIPTIVE_IMAGE_URL).length() > 0;
    }

    /* renamed from: a */
    public boolean mo8372a() {
        return Schema.getPictures().mo9406b((InspectionItemConstants.ItemCursor) this);
    }

    public boolean hasRemark() {
        return !isNull(InspectionItemConstants.REMARK) && getString(InspectionItemConstants.REMARK).length() > 0;
    }

    public boolean hasServerId() {
        return !isNull("form_item_server_id");
    }

    public boolean hasValue() {
        return getType().mo9177b(getString(InspectionItemConstants.INSPECTION_ITEM_VALUE));
    }

    public boolean isCustomLocationRequired() {
        return getBoolean(InspectionItemConstants.LOCATION_REQUIRED);
    }

    public boolean isDummy() {
        return getRecordType() == InspectionItemsTable.RecordType.DUMMY_HEADER;
    }

    public Pair<Integer, Integer> getValidChildCount() {
        return Schema.getInspectionItems().mo9190a((InspectionItemConstants.HeaderCursor) this);
    }

    public boolean isHeader() {
        switch (getRecordType()) {
            case DUMMY_HEADER:
            case HEADER:
                return true;
            default:
                return false;
        }
    }

    public boolean isInapplicable() {
        return getBoolean(InspectionItemConstants.INAPPLICABLE);
    }

    public boolean isInapplicablePossible() {
        return getBoolean(InspectionItemConstants.INAPPLICABLE_POSSIBLE);
    }

    public boolean isPictureRequired() {
        return getBoolean(InspectionItemConstants.PICTURE_REQUIRED);
    }

    public boolean isRequired() {
        return getBoolean(InspectionItemConstants.REQUIRED);
    }

    public boolean isValid() {
        return Schema.getInspectionItems().mo9193a(this);
    }

    public boolean setInapplicable(final boolean z, Location location) {
        return Schema.getInspectionItems().mo9195a(this, location, (InspectionItemsTable.C1450a) new InspectionItemsTable.C1450a() {
            /* renamed from: a */
            public String mo8427a() {
                return InspectionItemConstants.INAPPLICABLE;
            }

            /* renamed from: a */
            public void mo8429a(CursorWindow cursorWindow, int i, int i2) {
                cursorWindow.putLong(z ? 1 : 0, i, i2);
            }

            /* renamed from: a */
            public void mo8428a(ContentValues contentValues) {
                contentValues.put(InspectionItemConstants.INAPPLICABLE, Integer.valueOf(z ? 1 : 0));
            }
        });
    }

    public boolean setValue(Object obj, Location location) {
        final String a = getType().mo9175a(obj);
        return Schema.getInspectionItems().mo9195a(this, location, (InspectionItemsTable.C1450a) new InspectionItemsTable.C1450a() {
            /* renamed from: a */
            public String mo8427a() {
                return InspectionItemConstants.INSPECTION_ITEM_VALUE;
            }

            /* renamed from: a */
            public void mo8429a(CursorWindow cursorWindow, int i, int i2) {
                if (a == null) {
                    cursorWindow.putNull(i, i2);
                } else {
                    cursorWindow.putString(a, i, i2);
                }
            }

            /* renamed from: a */
            public void mo8428a(ContentValues contentValues) {
                if (a == null) {
                    contentValues.putNull(InspectionItemConstants.INSPECTION_ITEM_VALUE);
                } else {
                    contentValues.put(InspectionItemConstants.INSPECTION_ITEM_VALUE, a);
                }
            }
        });
    }

    public boolean setRemark(final String str, Location location) {
        return Schema.getInspectionItems().mo9195a(this, location, (InspectionItemsTable.C1450a) new InspectionItemsTable.C1450a() {
            /* renamed from: a */
            public String mo8427a() {
                return InspectionItemConstants.INSPECTION_ITEM_VALUE;
            }

            /* renamed from: a */
            public void mo8429a(CursorWindow cursorWindow, int i, int i2) {
                if (str == null) {
                    cursorWindow.putNull(i, i2);
                } else {
                    cursorWindow.putString(str, i, i2);
                }
            }

            /* renamed from: a */
            public void mo8428a(ContentValues contentValues) {
                if (str == null) {
                    contentValues.putNull(InspectionItemConstants.REMARK);
                } else {
                    contentValues.put(InspectionItemConstants.REMARK, str);
                }
            }
        });
    }

    public boolean setProjectSelected(long j, Location location) {
        return Schema.getInspectionItems().mo9194a(this, j, location);
    }

    /* renamed from: a */
    public boolean mo8373a(long j, long j2, InspectionItemsTable.C1450a aVar) {
        boolean z = true;
        int position = getPosition();
        boolean z2 = false;
        if (moveToId(j)) {
            CursorWindow window = getWindow();
            int position2 = getPosition();
            int columnIndex = getColumnIndex("mod_date");
            int columnIndex2 = getColumnIndex(aVar.mo8427a());
            if (columnIndex != -1) {
                window.putLong(j2, position2, columnIndex);
                z2 = true;
            }
            if (columnIndex2 != -1) {
                aVar.mo8429a(window, position2, columnIndex2);
                moveToPosition(position);
                return z;
            }
        }
        z = z2;
        moveToPosition(position);
        return z;
    }

    public JsonObject toJson() {
        return Schema.m5981a().f4860d.toJsonTree(this, C1225hy.class).getAsJsonObject();
    }

    public boolean hasTriggeredCondition() {
        return mo8375b() != null;
    }

    public boolean hasSubForm() {
        ItemActionsTable.ActionKey b = mo8375b();
        if (b != null) {
            return b.mo9338a();
        }
        throw new IllegalStateException("There is no condition triggered.");
    }

    public long getSubFormServerId() {
        ItemActionsTable.ActionKey b = mo8375b();
        if (b != null) {
            return b.mo9340c();
        }
        throw new IllegalStateException("There is no condition triggered.");
    }

    public boolean isTable() {
        ItemActionsTable.ActionKey b = mo8375b();
        return b != null && b.mo9341d();
    }

    public InspectionsTable.DataCursor getSubInspections(boolean z) {
        return Schema.getInspectionData().getSubInspections(this, mo8375b(), z);
    }

    public boolean addSubInspection() {
        Form loadForm;
        ItemActionsTable.ActionKey b = mo8375b();
        if (b != null) {
            FormsDir formsDir = FileSystem.get().getFormsDir();
            long c = b.mo9340c();
            if (!formsDir.getFormIds().contains(Long.valueOf(c)) || (loadForm = FileSystem.get().getFormsDir().loadForm(c)) == null || Schema.getInspectionData().mo9245a(loadForm, mo8378d(), Long.valueOf(getRootInspectionId()), this, b, (LongSparseArray<String>) null, (InspectionsTable.InitialLocation) null, (Tasks.TaskCursor) null) == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean hasSubInspections() {
        return Schema.getInspectionData().hasSubInspections(this, mo8375b());
    }

    public boolean hasSignature() {
        if (getType() == InspectionItemType.SIGNATURE) {
            String str = (String) getValue();
            PictureKey[] a = Schema.getPictures().mo9404a((InspectionItemConstants.ItemCursor) this);
            int length = a.length;
            int i = 0;
            while (i < length) {
                PicturesTable.PicturesCursor picturesCursor = a[i].get();
                try {
                    if (!picturesCursor.moveToFirst() || !picturesCursor.getGuid().equals(str)) {
                        picturesCursor.close();
                        i++;
                    } else {
                        return true;
                    }
                } finally {
                    picturesCursor.close();
                }
            }
        }
        return false;
    }

    public void removeSignature(PictureKey pictureKey, Location location) {
        String str;
        if (getType() == InspectionItemType.SIGNATURE && (str = (String) getValue()) != null && str.equals(pictureKey.getGuid())) {
            setValue((Object) null, location);
        }
    }

    /* renamed from: b */
    public ItemActionsTable.ActionKey mo8375b() {
        if (getType() != InspectionItemType.PROJECTS && !isHeader() && (!isInapplicablePossible() || (isInapplicablePossible() && !isInapplicable()))) {
            return Schema.getActions().mo9329a(this);
        }
        return null;
    }

    /* renamed from: c */
    public boolean mo8376c() {
        return Schema.getInspectionData().areProjectsEnabled(this);
    }

    /* renamed from: d */
    public long mo8378d() {
        return Schema.getInspectionData().mo9243a((InspectionItemConstants.ItemCursor) this);
    }
}
