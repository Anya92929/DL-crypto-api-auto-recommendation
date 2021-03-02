package p006nl.volkerinfradesign.checkandroid.data.tree;

import android.support.p001v4.util.LongSparseArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Form */
public class Form extends Item implements FormInfo {

    /* renamed from: a */
    static final C1388a f4718a = new C1388a();

    /* renamed from: b */
    static final C1390b f4719b = new C1390b();

    /* renamed from: c */
    static final C1392c f4720c = new C1392c();
    private static final long serialVersionUID = 5706534993371117497L;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final List<FormItem> f4721d = new ArrayList();

    /* renamed from: e */
    private transient Boolean f4722e;

    /* renamed from: f */
    private transient Boolean f4723f;

    /* renamed from: g */
    private boolean f4724g = true;

    /* renamed from: h */
    private final boolean f4725h;

    public static List<Form> download(Collection<Long> collection) throws IOException {
        return download(ArrayUtils.toPrimitive((Long[]) collection.toArray(new Long[collection.size()])));
    }

    public static List<Form> download(long... jArr) throws IOException {
        IOException iOException;
        JsonReader jsonReader;
        if (!AppState.getInstance().isThereASession()) {
            throw new IOException("not logged in");
        }
        HttpURLConnection httpURLConnection = null;
        JsonArray jsonArray = new JsonArray();
        Gson create = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(f4719b.mo9113a(), f4719b).registerTypeAdapter(Form.class, f4718a).registerTypeAdapter(f4720c.mo9115a(), f4720c).registerTypeAdapter(FormItem.class, FormItem.DESERIALIZER).create();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("IDs", jsonArray);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("session", AppState.getInstance().getSIDJSON());
        jsonObject2.add("params", jsonObject);
        for (long valueOf : jArr) {
            jsonArray.add(new JsonPrimitive((Number) Long.valueOf(valueOf)));
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) AppState.getInstance().getFormsGETUrl().openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.getOutputStream().write(create.toJson((JsonElement) jsonObject2).getBytes());
                jsonReader = new JsonReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                List<Form> list = (List) create.fromJson(jsonReader, f4719b.mo9113a());
                jsonReader.close();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return list;
            } catch (IOException e) {
                e = e;
                httpURLConnection = httpURLConnection2;
                try {
                    AppState.getInstance().invalidateLogin(httpURLConnection);
                    try {
                        iOException = new IOException(IOUtils.toString(httpURLConnection.getErrorStream()));
                    } catch (Exception e2) {
                        iOException = e;
                    }
                    throw iOException;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                httpURLConnection = httpURLConnection2;
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            AppState.getInstance().invalidateLogin(httpURLConnection);
            iOException = new IOException(IOUtils.toString(httpURLConnection.getErrorStream()));
            throw iOException;
        }
    }

    public Form(String str, String str2, boolean z, long j, boolean z2) {
        super(str, str2, j);
        this.f4725h = z;
        this.f4724g = z2;
    }

    public boolean areProjectsEnabled() {
        return this.f4724g;
    }

    public JsonObject getExtras(int i) {
        return null;
    }

    public List<FormItem> getFormItems() {
        return Collections.unmodifiableList(this.f4721d);
    }

    public boolean hasHeaders() {
        if (this.f4722e == null) {
            Iterator<FormItem> it = getFormItems().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getType() == InspectionItemType.HEADER) {
                        this.f4722e = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return this.f4722e.booleanValue();
    }

    public int size() {
        return this.f4721d.size();
    }

    public boolean hasLonelyItems(boolean z) {
        Boolean bool;
        if (this.f4723f == null) {
            bool = Boolean.valueOf(hasLonelyItems(this, z));
            this.f4723f = bool;
        } else {
            bool = this.f4723f;
        }
        return bool.booleanValue();
    }

    public static boolean hasLonelyItems(FormInfo formInfo, boolean z) {
        int i;
        boolean z2;
        int size = formInfo.size();
        if (z || !formInfo.areProjectsEnabled()) {
            i = 0;
        } else {
            i = 1;
        }
        int i2 = i;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (formInfo.get(i3).getType() == InspectionItemType.HEADER) {
                    z2 = true;
                    break;
                }
                i2++;
                i3++;
            } else {
                z2 = false;
                break;
            }
        }
        if (!z2 || i2 <= 0) {
            return false;
        }
        return true;
    }

    public FormItem get(int i) {
        return this.f4721d.get(i);
    }

    public boolean isSavingAllowed() {
        return this.f4725h;
    }

    public InspectionKey newInstance(Company company, LongSparseArray<String> longSparseArray, InspectionsTable.InitialLocation initialLocation) {
        return Schema.getInspectionData().newInspection(this, company.getServerId(), longSparseArray, initialLocation);
    }

    public void save() {
        FileSystem.get().getFormsDir().saveForm(this);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Form$c */
    static final class C1392c implements JsonDeserializer<ArrayList<FormItem>> {

        /* renamed from: a */
        private final Type f4729a;

        private C1392c() {
            this.f4729a = new TypeToken<List<FormItem>>() {
            }.getType();
        }

        /* renamed from: a */
        public ArrayList<FormItem> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            ArrayList<FormItem> arrayList = new ArrayList<>();
            JsonArray jsonArray = (JsonArray) jsonElement;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jsonArray.size()) {
                    return arrayList;
                }
                arrayList.add((FormItem) jsonDeserializationContext.deserialize(jsonArray.get(i2), FormItem.class));
                i = i2 + 1;
            }
        }

        /* renamed from: a */
        public Type mo9115a() {
            return this.f4729a;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Form$a */
    static final class C1388a implements JsonDeserializer<Form> {
        private C1388a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0068, code lost:
            if (r2.isEmpty() != false) goto L_0x006a;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p006nl.volkerinfradesign.checkandroid.data.tree.Form deserialize(com.google.gson.JsonElement r10, java.lang.reflect.Type r11, com.google.gson.JsonDeserializationContext r12) throws com.google.gson.JsonParseException {
            /*
                r9 = this;
                com.google.gson.JsonObject r7 = r10.getAsJsonObject()
                java.lang.String r0 = "id"
                com.google.gson.JsonElement r0 = r7.get(r0)
                long r4 = r0.getAsLong()
                java.lang.String r0 = "title"
                com.google.gson.JsonElement r0 = r7.get(r0)
                java.lang.String r1 = r0.getAsString()
                java.lang.String r0 = "requireProject"
                boolean r0 = r7.has(r0)
                if (r0 == 0) goto L_0x0095
                java.lang.String r0 = "requireProject"
                com.google.gson.JsonElement r0 = r7.get(r0)
                boolean r6 = r0.getAsBoolean()
            L_0x002a:
                java.lang.String r0 = "allowSaveOnDevice"
                com.google.gson.JsonElement r0 = r7.get(r0)
                boolean r3 = r0.getAsBoolean()
                nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
                nl.volkerinfradesign.checkandroid.AppState$Logger r0 = r0.log()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = "Deserializing form: "
                java.lang.StringBuilder r2 = r2.append(r8)
                java.lang.StringBuilder r2 = r2.append(r1)
                java.lang.String r2 = r2.toString()
                r0.mo8931i(r2)
                java.lang.String r0 = "desc"
                boolean r0 = r7.has(r0)
                if (r0 == 0) goto L_0x006a
                java.lang.String r0 = "desc"
                com.google.gson.JsonElement r0 = r7.get(r0)
                java.lang.String r2 = r0.getAsString()
                boolean r0 = r2.isEmpty()
                if (r0 == 0) goto L_0x006b
            L_0x006a:
                r2 = 0
            L_0x006b:
                nl.volkerinfradesign.checkandroid.data.tree.Form r0 = new nl.volkerinfradesign.checkandroid.data.tree.Form
                r0.<init>(r1, r2, r3, r4, r6)
                java.lang.String r1 = "inspectionItems"
                boolean r1 = r7.has(r1)
                if (r1 == 0) goto L_0x0094
                nl.volkerinfradesign.checkandroid.data.tree.Form$a$1 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Form$a$1
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.String r2 = "inspectionItems"
                com.google.gson.JsonElement r2 = r7.get(r2)
                java.lang.Object r1 = r12.deserialize(r2, r1)
                java.util.List r1 = (java.util.List) r1
                java.util.List r2 = r0.f4721d
                r2.addAll(r1)
            L_0x0094:
                return r0
            L_0x0095:
                r6 = 1
                goto L_0x002a
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.data.tree.Form.C1388a.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):nl.volkerinfradesign.checkandroid.data.tree.Form");
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Form$b */
    static final class C1390b implements JsonDeserializer<List<Form>> {

        /* renamed from: a */
        private final Type f4727a = new TypeToken<List<Form>>() {
        }.getType();

        C1390b() {
        }

        /* renamed from: a */
        public List<Form> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            ArrayList arrayList = new ArrayList();
            JsonArray asJsonArray = jsonElement.getAsJsonObject().get("result").getAsJsonArray();
            if (AppState.getInstance().isDebugable()) {
                AppState.getInstance().log().mo8931i("Deserializing: " + asJsonArray.size() + " forms");
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < asJsonArray.size()) {
                    Form form = (Form) jsonDeserializationContext.deserialize(asJsonArray.get(i2), Form.class);
                    if (form != null) {
                        arrayList.add(form);
                    } else {
                        AppState.getInstance().log().mo8931i("Could not deserialize form!");
                    }
                    i = i2 + 1;
                } else {
                    AppState.getInstance().log().mo8931i("Finished deserializing!");
                    return arrayList;
                }
            }
        }

        /* renamed from: a */
        public Type mo9113a() {
            return this.f4727a;
        }
    }
}
