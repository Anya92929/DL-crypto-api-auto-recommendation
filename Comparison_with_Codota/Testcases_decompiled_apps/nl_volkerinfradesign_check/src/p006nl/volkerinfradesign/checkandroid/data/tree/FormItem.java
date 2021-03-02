package p006nl.volkerinfradesign.checkandroid.data.tree;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import p006nl.volkerinfradesign.checkandroid.database.ActionColumns;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;
import p006nl.volkerinfradesign.checkandroid.database.Schema;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.FormItem */
public class FormItem extends Item {
    public static final JsonDeserializer<FormItem> DESERIALIZER = new JsonDeserializer<FormItem>() {
        /* renamed from: a */
        private final InspectionItemType m5842a(JsonObject jsonObject) {
            InspectionItemType inspectionItemType = null;
            try {
                inspectionItemType = InspectionItemType.valueOf(jsonObject.get("type").getAsString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (inspectionItemType == null) {
                return InspectionItemType.BOOLEAN;
            }
            return inspectionItemType;
        }

        /* renamed from: a */
        public FormItem deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonArray asJsonArray;
            JsonArray jsonArray;
            JsonObject jsonObject = (JsonObject) jsonElement;
            long asLong = jsonObject.get("id").getAsLong();
            InspectionItemType a = m5842a(jsonObject);
            String asString = jsonObject.get("title").getAsString();
            String asString2 = jsonObject.has(ActionColumns.DESCRIPTION) ? jsonObject.get(ActionColumns.DESCRIPTION).getAsString() : null;
            boolean asBoolean = jsonObject.get("req").getAsBoolean();
            boolean asBoolean2 = jsonObject.get("inapplPossible").getAsBoolean();
            boolean z = jsonObject.has("requirePhoto") && jsonObject.get("requirePhoto").getAsBoolean();
            boolean z2 = jsonObject.has("requireLocation") && jsonObject.get("requireLocation").getAsBoolean();
            String asString3 = jsonObject.has("imageURL") ? jsonObject.get("imageURL").getAsString() : null;
            long[] putAll = Schema.getActions().putAll(jsonObject.has("actions") ? jsonObject.get("actions").getAsJsonArray() : null, asLong);
            switch (C13952.f4740a[a.ordinal()]) {
                case 1:
                case 2:
                    asJsonArray = jsonObject.has("values") ? jsonObject.get("values").getAsJsonArray() : new JsonArray();
                    break;
                default:
                    asJsonArray = null;
                    break;
            }
            if (jsonObject.has(InspectionItemConstants.HYPERLINKS)) {
                jsonArray = jsonObject.get(InspectionItemConstants.HYPERLINKS).getAsJsonArray();
            } else {
                jsonArray = null;
            }
            return new FormItem(asString, asString2, asLong, asBoolean, asBoolean2, z, z2, asString3, a, asJsonArray, putAll, jsonArray);
        }
    };
    private static final long serialVersionUID = 1329295907765817948L;

    /* renamed from: a */
    private long[] f4731a;

    /* renamed from: b */
    private final String f4732b;

    /* renamed from: c */
    private final String f4733c;

    /* renamed from: d */
    private final boolean f4734d;

    /* renamed from: e */
    private final boolean f4735e;

    /* renamed from: f */
    private final boolean f4736f;

    /* renamed from: g */
    private final boolean f4737g;

    /* renamed from: h */
    private final InspectionItemType f4738h;

    /* renamed from: i */
    private String f4739i;

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.FormItem$2 */
    static /* synthetic */ class C13952 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4740a = new int[InspectionItemType.values().length];

        static {
            try {
                f4740a[InspectionItemType.SINGLECHOICE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4740a[InspectionItemType.MULTICHOICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FormItem(String str, String str2, long j, boolean z, boolean z2, boolean z3, boolean z4, String str3, InspectionItemType inspectionItemType, JsonArray jsonArray, long[] jArr, JsonArray jsonArray2) {
        super(str, str2, j);
        String str4;
        String str5 = null;
        this.f4733c = str3;
        this.f4738h = inspectionItemType;
        this.f4736f = z;
        this.f4737g = z2;
        this.f4735e = z3;
        this.f4734d = z4;
        this.f4731a = jArr;
        if (jsonArray != null) {
            str4 = jsonArray.toString();
        } else {
            str4 = null;
        }
        this.f4732b = str4;
        this.f4739i = jsonArray2 != null ? jsonArray2.toString() : str5;
    }

    public long[] getActions() {
        return this.f4731a;
    }

    public String getChoices() {
        return this.f4732b;
    }

    public String getImageUrl() {
        return this.f4733c;
    }

    public InspectionItemType getType() {
        return this.f4738h;
    }

    public boolean hasActions() {
        return this.f4731a != null && this.f4731a.length > 0;
    }

    public boolean hasDescription() {
        return getDescription() != null && getDescription().length() > 0;
    }

    public boolean hasImageUrl() {
        return this.f4733c != null;
    }

    public boolean isInapplicablePossible() {
        return this.f4737g;
    }

    public boolean isLocationRequired() {
        return this.f4734d;
    }

    public boolean isPhotoRequired() {
        return this.f4735e;
    }

    public boolean isRequired() {
        return this.f4736f;
    }

    public String getHyperlinks() {
        return this.f4739i;
    }
}
