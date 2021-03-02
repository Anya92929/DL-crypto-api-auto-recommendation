package p006nl.volkerinfradesign.checkandroid.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;
import p006nl.volkerinfradesign.checkandroid.environments.Model;

/* renamed from: nl.volkerinfradesign.checkandroid.database.Schema */
public final class Schema {

    /* renamed from: a */
    static final JsonSerializer<InspectionsTable.DataCursor> f4856a = new JsonSerializer<InspectionsTable.DataCursor>() {
        /* renamed from: a */
        public JsonObject serialize(InspectionsTable.DataCursor dataCursor, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            String title = dataCursor.getTitle();
            String description = dataCursor.getDescription();
            jsonObject.addProperty(InspectionItemConstants.INSPECTION_ID, (Number) Long.valueOf(dataCursor.getServerId()));
            jsonObject.addProperty("formInspection_id", (Number) Long.valueOf(dataCursor.getFormServerId()));
            jsonObject.addProperty("comp_id", (Number) Long.valueOf(dataCursor.getCompanyServerId()));
            jsonObject.addProperty("created", (Number) Long.valueOf(dataCursor.getCreationDate().getTime()));
            jsonObject.addProperty("mod", (Number) Long.valueOf(dataCursor.getModifiedDate().getTimeInMillis()));
            jsonObject.addProperty("client_id", (Number) Long.valueOf(dataCursor.getId()));
            jsonObject.addProperty("title", title);
            if (description != null && !description.isEmpty()) {
                jsonObject.addProperty(ActionColumns.DESCRIPTION, description);
            }
            LocationsTable.LocationsCursor location = dataCursor.getLocation();
            if (location != null && location.moveToFirst()) {
                jsonObject.add("location", location.getKey().toJson());
                location.close();
            }
            LocationsTable.LocationsCursor customLocation = dataCursor.getCustomLocation();
            if (customLocation != null && customLocation.moveToFirst()) {
                jsonObject.add("customLocation", customLocation.getKey().toJson());
                customLocation.close();
            }
            if (dataCursor.hasProjectServerId()) {
                jsonObject.addProperty("prj_id", (Number) dataCursor.getProjectServerId());
            }
            if (dataCursor.hasTask()) {
                jsonObject.addProperty("inspectionActionId", (Number) dataCursor.getTaskServerId());
            }
            jsonObject.add("inspectionItems", m5984a(dataCursor));
            return jsonObject;
        }

        /* renamed from: a */
        private JsonArray m5984a(InspectionsTable.DataCursor dataCursor) {
            JsonArray jsonArray = new JsonArray();
            InspectionItemConstants.ItemCursor items = Schema.getInspectionItems().getItems(dataCursor.getKey(), true);
            int i = 0;
            while (items.moveToPosition(i)) {
                try {
                    if (items.getType() != InspectionItemType.PROJECTS && !items.isDummy()) {
                        jsonArray.add(items.toJson());
                    }
                    i++;
                } finally {
                    items.close();
                }
            }
            return jsonArray;
        }
    };

    /* renamed from: b */
    static final JsonSerializer<InspectionItemConstants.ItemCursor> f4857b = new JsonSerializer<InspectionItemConstants.ItemCursor>() {
        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public JsonObject serialize(InspectionItemConstants.ItemCursor itemCursor, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            String title = itemCursor.getTitle();
            String description = itemCursor.getDescription();
            if (itemCursor.hasRemark()) {
                jsonObject.addProperty(InspectionItemConstants.REMARK, itemCursor.getRemark());
            }
            if (itemCursor.hasServerId()) {
                jsonObject.addProperty("formInspectionItem_id", (Number) itemCursor.getServerId());
            }
            jsonObject.addProperty("mod", (Number) Long.valueOf(itemCursor.getModifiedMillis()));
            jsonObject.addProperty("title", title);
            if (description != null && !description.isEmpty()) {
                jsonObject.addProperty(ActionColumns.DESCRIPTION, description);
            }
            jsonObject.addProperty("type", itemCursor.getType().name());
            jsonObject.addProperty("isInapplicable", Boolean.valueOf(itemCursor.isInapplicable()));
            if (!itemCursor.isHeader() && itemCursor.hasValue()) {
                switch (C14763.f4870a[itemCursor.getType().ordinal()]) {
                    case 1:
                        jsonObject.add("val", jsonSerializationContext.serialize((String[]) itemCursor.getValue()));
                        break;
                    default:
                        jsonObject.addProperty("val", itemCursor.getStringValue());
                        break;
                }
            }
            LocationsTable.LocationsCursor customLocation = itemCursor.getCustomLocation();
            if (customLocation != null && customLocation.moveToFirst()) {
                jsonObject.add("customLocation", customLocation.getKey().toJson());
                customLocation.close();
            }
            LocationsTable.LocationsCursor locationsCursor = itemCursor.getlocation();
            if (locationsCursor != null && locationsCursor.moveToFirst()) {
                jsonObject.add("location", locationsCursor.getKey().toJson());
                locationsCursor.close();
            }
            if (itemCursor.hasTriggeredCondition()) {
                InspectionsTable.DataCursor subInspections = itemCursor.getSubInspections(false);
                JsonArray jsonArray = new JsonArray();
                int i = 0;
                while (subInspections.moveToPosition(i)) {
                    try {
                        jsonArray.add(subInspections.toJson());
                        i++;
                    } catch (Throwable th) {
                        subInspections.close();
                        throw th;
                    }
                }
                subInspections.close();
                jsonObject.add("subInspections", jsonArray);
            }
            jsonObject.addProperty("client_id", (Number) Long.valueOf(itemCursor.getId()));
            return jsonObject;
        }
    };

    /* renamed from: n */
    private static Schema f4858n;

    /* renamed from: c */
    final Model f4859c;

    /* renamed from: d */
    public final Gson f4860d;

    /* renamed from: e */
    final ItemActionsTable f4861e = new ItemActionsTable();

    /* renamed from: f */
    final InspectionItemsTable f4862f;

    /* renamed from: g */
    final InspectionsTable f4863g;

    /* renamed from: h */
    final LocationsTable f4864h = new LocationsTable();

    /* renamed from: i */
    final LogTable f4865i;

    /* renamed from: j */
    final PicturesTable f4866j;

    /* renamed from: k */
    final ProjectsTable f4867k = new ProjectsTable();

    /* renamed from: l */
    final ThrowableTable f4868l;

    /* renamed from: m */
    final StackTracesTable f4869m = new StackTracesTable();

    /* renamed from: nl.volkerinfradesign.checkandroid.database.Schema$3 */
    static /* synthetic */ class C14763 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4870a = new int[InspectionItemType.values().length];

        static {
            try {
                f4870a[InspectionItemType.MULTICHOICE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static ItemActionsTable getActions() {
        return m5981a().f4861e;
    }

    public static InspectionsTable getInspectionData() {
        return m5981a().f4863g;
    }

    public static InspectionItemsTable getInspectionItems() {
        return m5981a().f4862f;
    }

    public static LogTable getLogs() {
        return m5981a().f4865i;
    }

    public static PicturesTable getPictures() {
        return m5981a().f4866j;
    }

    public static ProjectsTable getProjects() {
        return m5981a().f4867k;
    }

    public static ThrowableTable getThrowables() {
        return m5981a().f4868l;
    }

    public static final Schema init(App app, Model model) {
        if (f4858n == null) {
            Schema schema = new Schema(app, model);
            f4858n = schema;
            return schema;
        }
        throw new IllegalStateException("The Schema is already initialized!");
    }

    /* renamed from: a */
    public static final Schema m5981a() {
        if (f4858n != null) {
            return f4858n;
        }
        throw new IllegalStateException("The Schema is not yet initialized!");
    }

    /* renamed from: b */
    public static LocationsTable m5982b() {
        return m5981a().f4864h;
    }

    /* renamed from: c */
    static StackTracesTable m5983c() {
        return m5981a().f4869m;
    }

    private Schema(App app, Model model) {
        this.f4859c = model;
        this.f4863g = new InspectionsTable(this);
        this.f4866j = new PicturesTable(app);
        this.f4868l = new ThrowableTable(this.f4869m);
        this.f4865i = new LogTable(this.f4868l, app.getMainLooper());
        this.f4862f = new InspectionItemsTable();
        this.f4860d = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(InspectionsTable.C1454a.class, f4856a).registerTypeAdapter(C1225hy.class, f4857b).create();
    }
}
