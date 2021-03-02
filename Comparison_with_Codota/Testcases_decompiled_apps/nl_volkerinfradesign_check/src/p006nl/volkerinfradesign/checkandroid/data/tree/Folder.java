package p006nl.volkerinfradesign.checkandroid.data.tree;

import com.google.gson.JsonDeserializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Folder */
public class Folder extends Item {
    public static final long ROOT_ID = Long.MIN_VALUE;

    /* renamed from: a */
    static final JsonDeserializer<Folder> f4713a = new JsonDeserializer<Folder>() {
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x002c, code lost:
            if (r0.isEmpty() != false) goto L_0x002e;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p006nl.volkerinfradesign.checkandroid.data.tree.Folder deserialize(com.google.gson.JsonElement r6, java.lang.reflect.Type r7, com.google.gson.JsonDeserializationContext r8) throws com.google.gson.JsonParseException {
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
                nl.volkerinfradesign.checkandroid.data.tree.Folder r4 = new nl.volkerinfradesign.checkandroid.data.tree.Folder
                r4.<init>(r1, r0, r2)
                java.lang.String r0 = "companies"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x0056
                java.lang.String r0 = "companies"
                com.google.gson.JsonElement r0 = r6.get(r0)
                nl.volkerinfradesign.checkandroid.data.tree.Folder$1$1 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Folder$1$1
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.Object r0 = r8.deserialize(r0, r1)
                java.util.List r0 = (java.util.List) r0
                java.util.TreeSet<nl.volkerinfradesign.checkandroid.data.tree.Company> r1 = r4.companies
                r1.addAll(r0)
            L_0x0056:
                java.lang.String r0 = "folders"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x0078
                java.lang.String r0 = "folders"
                com.google.gson.JsonElement r0 = r6.get(r0)
                nl.volkerinfradesign.checkandroid.data.tree.Folder$1$2 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Folder$1$2
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.Object r0 = r8.deserialize(r0, r1)
                java.util.List r0 = (java.util.List) r0
                java.util.TreeSet<nl.volkerinfradesign.checkandroid.data.tree.Folder> r1 = r4.folders
                r1.addAll(r0)
            L_0x0078:
                java.lang.String r0 = "inspections"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x009a
                java.lang.String r0 = "inspections"
                com.google.gson.JsonElement r0 = r6.get(r0)
                nl.volkerinfradesign.checkandroid.data.tree.Folder$1$3 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Folder$1$3
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.Object r0 = r8.deserialize(r0, r1)
                java.util.List r0 = (java.util.List) r0
                java.util.TreeSet<nl.volkerinfradesign.checkandroid.data.tree.FormRef> r1 = r4.formRefs
                r1.addAll(r0)
            L_0x009a:
                java.lang.String r0 = "hyperlinks"
                boolean r0 = r6.has(r0)
                if (r0 == 0) goto L_0x00bc
                java.lang.String r0 = "hyperlinks"
                com.google.gson.JsonElement r0 = r6.get(r0)
                nl.volkerinfradesign.checkandroid.data.tree.Folder$1$4 r1 = new nl.volkerinfradesign.checkandroid.data.tree.Folder$1$4
                r1.<init>()
                java.lang.reflect.Type r1 = r1.getType()
                java.lang.Object r0 = r8.deserialize(r0, r1)
                java.util.List r0 = (java.util.List) r0
                java.util.TreeSet<nl.volkerinfradesign.checkandroid.data.tree.Hyperlink> r1 = r4.hyperlinks
                r1.addAll(r0)
            L_0x00bc:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.data.tree.Folder.C13821.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):nl.volkerinfradesign.checkandroid.data.tree.Folder");
        }
    };
    private static final long serialVersionUID = 4131179295156716520L;
    protected final TreeSet<Company> companies = new TreeSet<>(new C1224hx());
    protected final TreeSet<Folder> folders = new TreeSet<>(new C1224hx());
    protected final TreeSet<FormRef> formRefs = new TreeSet<>(new C1224hx());
    protected final TreeSet<Hyperlink> hyperlinks = new TreeSet<>(new C1224hx());

    Folder(String str) {
        super(str, (String) null, Long.MIN_VALUE);
    }

    Folder(String str, String str2, long j) {
        super(str, str2, j);
    }

    public final Collection<Folder> getChildren() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.companies);
        arrayList.addAll(this.folders);
        arrayList.addAll(this.formRefs);
        return arrayList;
    }

    public final Collection<Company> getCompanies() {
        return Collections.unmodifiableCollection(this.companies);
    }

    public final Collection<Folder> getFolders() {
        return Collections.unmodifiableCollection(this.folders);
    }

    public final Collection<FormRef> getForms() {
        return Collections.unmodifiableCollection(this.formRefs);
    }

    public final Collection<Hyperlink> getHyperlinks() {
        return Collections.unmodifiableCollection(this.hyperlinks);
    }

    public final boolean hasChildren() {
        return hasCompanies() || hasFolders() || hasForms() || hasHyperlinks();
    }

    public final boolean hasCompanies() {
        return this.companies != null && !this.companies.isEmpty();
    }

    public final boolean hasFolders() {
        return this.folders != null && !this.folders.isEmpty();
    }

    public final boolean hasForms() {
        return this.formRefs != null && !this.formRefs.isEmpty();
    }

    public final boolean hasHyperlinks() {
        return this.hyperlinks != null && !this.hyperlinks.isEmpty();
    }

    public String toString() {
        return getTitle() + " #" + Long.valueOf(getServerId()).toString();
    }
}
