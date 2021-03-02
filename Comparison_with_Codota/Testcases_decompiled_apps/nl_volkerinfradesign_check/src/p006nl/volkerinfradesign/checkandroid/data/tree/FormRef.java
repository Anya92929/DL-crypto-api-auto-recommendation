package p006nl.volkerinfradesign.checkandroid.data.tree;

import android.support.p001v4.util.LongSparseArray;
import com.google.gson.JsonDeserializer;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.FormRef */
public class FormRef extends Folder {

    /* renamed from: b */
    static final JsonDeserializer<FormRef> f4741b = new JsonDeserializer<FormRef>() {
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x002c, code lost:
            if (r0.isEmpty() != false) goto L_0x002e;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p006nl.volkerinfradesign.checkandroid.data.tree.FormRef deserialize(com.google.gson.JsonElement r6, java.lang.reflect.Type r7, com.google.gson.JsonDeserializationContext r8) throws com.google.gson.JsonParseException {
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
                nl.volkerinfradesign.checkandroid.data.tree.FormRef r4 = new nl.volkerinfradesign.checkandroid.data.tree.FormRef
                r4.<init>(r1, r0, r2)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.data.tree.FormRef.C13961.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):nl.volkerinfradesign.checkandroid.data.tree.FormRef");
        }
    };
    private static final long serialVersionUID = -7342169936201907643L;

    /* renamed from: c */
    private Form f4742c;

    FormRef(String str, String str2, long j) {
        super(str, str2, j);
    }

    public boolean hasForm() {
        return FileSystem.get().getFormsDir().hasForm(getServerId()) && getForm() != null;
    }

    public InspectionKey newInstance(Company company) {
        return Schema.getInspectionData().newInspection(getForm(), company.getServerId(), (LongSparseArray<String>) null, (InspectionsTable.InitialLocation) null);
    }

    public Form getForm() {
        long serverId = getServerId();
        if (this.f4742c != null) {
            return this.f4742c;
        }
        Form loadForm = FileSystem.get().getFormsDir().loadForm(serverId);
        this.f4742c = loadForm;
        return loadForm;
    }
}
