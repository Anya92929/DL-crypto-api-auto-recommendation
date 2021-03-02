package p006nl.volkerinfradesign.checkandroid.data.tree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.data.StructuresDir;
import p006nl.volkerinfradesign.checkandroid.database.ProjectsTable;
import p006nl.volkerinfradesign.checkandroid.environments.Account;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Root */
public class Root extends Folder implements Serializable {
    private static final long serialVersionUID = 1448266105838093245L;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Hashtable<Company, List<Project>> f4751b = new Hashtable<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final HashSet<FormRef> f4752c = new HashSet<>();

    /* renamed from: d */
    private File f4753d;

    /* renamed from: e */
    private transient Gson f4754e;

    /* renamed from: f */
    private String f4755f;

    public static Root download() throws IOException {
        JsonObject sidjson = AppState.getInstance().getSIDJSON();
        if (sidjson == null) {
            throw new IOException("not logged in");
        }
        HttpURLConnection httpURLConnection = null;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("folder", AppState.getInstance().getDomainFolder());
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("session", sidjson);
        jsonObject2.add("params", jsonObject);
        Root root = new Root();
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) AppState.getInstance().getTreeStructureGETUrl().openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.getOutputStream().write(root.getGson().toJson((JsonElement) jsonObject2).getBytes());
                Root root2 = (Root) root.getGson().fromJson(new JsonReader(new InputStreamReader(httpURLConnection2.getInputStream())), (Type) Root.class);
                httpURLConnection2.disconnect();
                return root2;
            } catch (JsonParseException e) {
                throw new IOException(e.getMessage());
            } catch (IOException e2) {
                IOException iOException = e2;
                httpURLConnection = httpURLConnection2;
                e = iOException;
                try {
                    AppState.getInstance().invalidateLogin(httpURLConnection);
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            AppState.getInstance().invalidateLogin(httpURLConnection);
            throw new IOException(e);
        }
    }

    public static Root loadRecent() {
        Root loadRecent = FileSystem.get().getStructuresDir().loadRecent();
        return loadRecent != null ? loadRecent : new Root();
    }

    public static void removeOld() {
        FileSystem.get().getStructuresDir().removeOld();
    }

    private Root() {
        super("Root");
    }

    public Set<Company> getAllCompanies() {
        return Collections.unmodifiableSet(this.f4751b.keySet());
    }

    public Set<FormRef> getAllFormRefs() {
        return Collections.unmodifiableSet(this.f4752c);
    }

    public File getFile() {
        return this.f4753d;
    }

    public Gson getGson() {
        if (this.f4754e == null) {
            FoldersDeserializer foldersDeserializer = new FoldersDeserializer();
            CompaniesDeserializer companiesDeserializer = new CompaniesDeserializer();
            C1407b bVar = new C1407b();
            this.f4754e = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(getClass(), new C1409c()).registerTypeAdapter(Company.class, new C1401a(this.f4755f)).registerTypeAdapter(Folder.class, Folder.f4713a).registerTypeAdapter(Form.class, Form.f4718a).registerTypeAdapter(FormRef.class, FormRef.f4741b).registerTypeAdapter(FormItem.class, FormItem.DESERIALIZER).registerTypeAdapter(Hyperlink.class, Hyperlink.f4743b).registerTypeAdapter(companiesDeserializer.getType(), companiesDeserializer).registerTypeAdapter(foldersDeserializer.getType(), foldersDeserializer).registerTypeAdapter(bVar.mo9154a(), bVar).registerTypeAdapter(Form.f4720c.mo9115a(), Form.f4720c).create();
        }
        return this.f4754e;
    }

    public void save() {
        StructuresDir structuresDir = FileSystem.get().getStructuresDir();
        if (this.f4753d == null) {
            this.f4753d = structuresDir.newFile();
        }
        FileSystem.get().getStructuresDir().save(this);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Root$CompaniesDeserializer */
    public final class CompaniesDeserializer implements JsonDeserializer<List<Company>> {

        /* renamed from: b */
        private final Type f4757b;

        private CompaniesDeserializer() {
            this.f4757b = new TypeToken<List<Company>>(Root.this) {
            }.getType();
        }

        public List<Company> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonElement> it = ((JsonArray) jsonElement).iterator();
            while (it.hasNext()) {
                Company company = (Company) jsonDeserializationContext.deserialize(it.next(), Company.class);
                arrayList.add(company);
                Root.this.f4751b.put(company, company.getProjects());
            }
            return arrayList;
        }

        public Type getType() {
            return this.f4757b;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Root$FoldersDeserializer */
    public static final class FoldersDeserializer implements JsonDeserializer<ArrayList<Folder>> {

        /* renamed from: a */
        private final Type f4760a;

        private FoldersDeserializer() {
            this.f4760a = new TypeToken<List<Folder>>() {
            }.getType();
        }

        public ArrayList<Folder> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            ArrayList<Folder> arrayList = new ArrayList<>();
            Iterator<JsonElement> it = ((JsonArray) jsonElement).iterator();
            while (it.hasNext()) {
                arrayList.add((Folder) jsonDeserializationContext.deserialize(it.next(), Folder.class));
            }
            return arrayList;
        }

        public Type getType() {
            return this.f4760a;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Root$ProjectsDeserializer */
    public static final class ProjectsDeserializer implements JsonDeserializer<List<Project>> {
        private ProjectsDeserializer() {
        }

        public List<Project> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            ArrayList arrayList = new ArrayList();
            JsonObject jsonObject = (JsonObject) jsonElement;
            long asLong = jsonObject.get(Account.MODIFIED).getAsLong();
            Iterator<JsonElement> it = jsonObject.get("result").getAsJsonObject().get("projects").getAsJsonArray().iterator();
            while (it.hasNext()) {
                JsonObject jsonObject2 = (JsonObject) it.next();
                Project project = new Project(jsonObject2.get("title").getAsString(), jsonObject2.get("id").getAsLong(), jsonObject2.get(ProjectsTable.CODE).getAsString());
                project.getModifiedDate().setTimeInMillis(asLong);
                arrayList.add(project);
            }
            return arrayList;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Root$a */
    final class C1401a implements JsonDeserializer<Folder> {

        /* renamed from: b */
        private final Type f4763b;

        /* renamed from: c */
        private final String f4764c;

        C1401a(String str) {
            this.f4764c = str;
            this.f4763b = new TypeToken<Company>(Root.this) {
            }.getType();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x002c, code lost:
            if (r0.isEmpty() != false) goto L_0x002e;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p006nl.volkerinfradesign.checkandroid.data.tree.Company deserialize(com.google.gson.JsonElement r6, java.lang.reflect.Type r7, com.google.gson.JsonDeserializationContext r8) throws com.google.gson.JsonParseException {
            /*
                r5 = this;
                com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6
                java.lang.String r0 = "id"
                com.google.gson.JsonElement r0 = r6.get(r0)
                long r2 = r0.getAsLong()
                java.lang.String r0 = "title"
                com.google.gson.JsonElement r0 = r6.get(r0)
                java.lang.String r1 = r0.getAsString()
                java.lang.String r0 = "desc"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x002e
                java.lang.String r0 = "desc"
                com.google.gson.JsonElement r0 = r6.get(r0)
                java.lang.String r0 = r0.getAsString()
                boolean r4 = r0.isEmpty()
                if (r4 == 0) goto L_0x002f
            L_0x002e:
                r0 = 0
            L_0x002f:
                nl.volkerinfradesign.checkandroid.data.tree.Company r4 = new nl.volkerinfradesign.checkandroid.data.tree.Company
                r4.<init>(r1, r0, r2)
                r0 = 10
                p006nl.volkerinfradesign.checkandroid.data.tree.Project.downloadProjects((p006nl.volkerinfradesign.checkandroid.data.tree.Company) r4, (int) r0)     // Catch:{ IOException -> 0x00c2 }
                java.lang.String r0 = "companies"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x005b
                java.lang.String r0 = "companies"
                com.google.gson.JsonElement r0 = r6.get(r0)
                nl.volkerinfradesign.checkandroid.data.tree.Root$a$2 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Root$a$2
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.Object r0 = r8.deserialize(r0, r1)
                java.util.List r0 = (java.util.List) r0
                java.util.TreeSet r1 = r4.companies
                r1.addAll(r0)
            L_0x005b:
                java.lang.String r0 = "folders"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x007d
                java.lang.String r0 = "folders"
                com.google.gson.JsonElement r0 = r6.get(r0)
                nl.volkerinfradesign.checkandroid.data.tree.Root$a$3 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Root$a$3
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.Object r0 = r8.deserialize(r0, r1)
                java.util.List r0 = (java.util.List) r0
                java.util.TreeSet r1 = r4.folders
                r1.addAll(r0)
            L_0x007d:
                java.lang.String r0 = "inspections"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x009f
                java.lang.String r0 = "inspections"
                com.google.gson.JsonElement r0 = r6.get(r0)
                nl.volkerinfradesign.checkandroid.data.tree.Root$a$4 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Root$a$4
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.Object r0 = r8.deserialize(r0, r1)
                java.util.List r0 = (java.util.List) r0
                java.util.TreeSet r1 = r4.formRefs
                r1.addAll(r0)
            L_0x009f:
                java.lang.String r0 = "hyperlinks"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x00c1
                java.lang.String r0 = "hyperlinks"
                com.google.gson.JsonElement r0 = r6.get(r0)
                nl.volkerinfradesign.checkandroid.data.tree.Root$a$5 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Root$a$5
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.Object r0 = r8.deserialize(r0, r1)
                java.util.List r0 = (java.util.List) r0
                java.util.TreeSet r1 = r4.hyperlinks
                r1.addAll(r0)
            L_0x00c1:
                return r4
            L_0x00c2:
                r0 = move-exception
                r0.printStackTrace()
                com.google.gson.JsonParseException r1 = new com.google.gson.JsonParseException
                java.lang.String r0 = r0.getMessage()
                r1.<init>((java.lang.String) r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.data.tree.Root.C1401a.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):nl.volkerinfradesign.checkandroid.data.tree.Company");
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Root$c */
    final class C1409c implements JsonDeserializer<Root> {
        private C1409c() {
        }

        /* renamed from: a */
        public Root deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = (JsonObject) jsonElement;
            long asLong = jsonObject.get(Account.MODIFIED).getAsLong();
            JsonObject asJsonObject = jsonObject.get("result").getAsJsonObject();
            if (asJsonObject.has("companies")) {
                Root.this.companies.addAll((List) jsonDeserializationContext.deserialize(asJsonObject.get("companies"), new TypeToken<List<Company>>() {
                }.getType()));
            }
            if (asJsonObject.has("folders")) {
                Root.this.folders.addAll((List) jsonDeserializationContext.deserialize(asJsonObject.get("folders"), new TypeToken<List<Folder>>() {
                }.getType()));
            }
            if (asJsonObject.has("inspections")) {
                Root.this.formRefs.addAll((List) jsonDeserializationContext.deserialize(asJsonObject.get("inspections"), new TypeToken<List<FormRef>>() {
                }.getType()));
            }
            Root.this.getModifiedDate().setTimeInMillis(asLong);
            return Root.this;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Root$b */
    final class C1407b implements JsonDeserializer<List<FormRef>> {

        /* renamed from: b */
        private final Type f4772b;

        private C1407b() {
            this.f4772b = new TypeToken<List<FormRef>>(Root.this) {
            }.getType();
        }

        /* renamed from: a */
        public List<FormRef> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonElement> it = ((JsonArray) jsonElement).iterator();
            while (it.hasNext()) {
                FormRef formRef = (FormRef) jsonDeserializationContext.deserialize(it.next(), FormRef.class);
                arrayList.add(formRef);
                Root.this.f4752c.add(formRef);
            }
            return arrayList;
        }

        /* renamed from: a */
        public Type mo9154a() {
            return this.f4772b;
        }
    }
}
