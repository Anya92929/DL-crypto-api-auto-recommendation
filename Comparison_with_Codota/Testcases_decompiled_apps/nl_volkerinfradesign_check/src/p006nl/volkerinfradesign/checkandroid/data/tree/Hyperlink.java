package p006nl.volkerinfradesign.checkandroid.data.tree;

import com.google.gson.JsonDeserializer;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Hyperlink */
public class Hyperlink extends Folder {

    /* renamed from: b */
    static final JsonDeserializer<Hyperlink> f4743b = new JsonDeserializer<Hyperlink>() {
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
            if (r0.isEmpty() != false) goto L_0x0025;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p006nl.volkerinfradesign.checkandroid.data.tree.Hyperlink deserialize(com.google.gson.JsonElement r7, java.lang.reflect.Type r8, com.google.gson.JsonDeserializationContext r9) throws com.google.gson.JsonParseException {
            /*
                r6 = this;
                r1 = 0
                com.google.gson.JsonObject r7 = (com.google.gson.JsonObject) r7
                java.lang.String r0 = "title"
                com.google.gson.JsonElement r0 = r7.get(r0)
                java.lang.String r3 = r0.getAsString()
                java.lang.String r0 = "desc"
                boolean r0 = r7.has(r0)
                if (r0 == 0) goto L_0x0025
                java.lang.String r0 = "desc"
                com.google.gson.JsonElement r0 = r7.get(r0)
                java.lang.String r0 = r0.getAsString()
                boolean r2 = r0.isEmpty()
                if (r2 == 0) goto L_0x0026
            L_0x0025:
                r0 = r1
            L_0x0026:
                java.lang.String r2 = "hyperlink"
                boolean r2 = r7.has(r2)
                if (r2 == 0) goto L_0x003e
                java.lang.String r2 = "hyperlink"
                com.google.gson.JsonElement r2 = r7.get(r2)
                java.lang.String r2 = r2.getAsString()
                boolean r4 = r2.isEmpty()
                if (r4 == 0) goto L_0x0057
            L_0x003e:
                boolean r2 = org.apache.commons.lang3.StringUtils.isEmpty(r0)
                if (r2 == 0) goto L_0x0045
                r0 = r1
            L_0x0045:
                nl.volkerinfradesign.checkandroid.data.tree.Hyperlink r2 = new nl.volkerinfradesign.checkandroid.data.tree.Hyperlink
                java.util.Random r4 = new java.util.Random
                r4.<init>()
                long r4 = r4.nextLong()
                r2.<init>(r3, r0, r4)
                r2.setHyperlink(r1)
                return r2
            L_0x0057:
                r1 = r2
                goto L_0x003e
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.data.tree.Hyperlink.C13971.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):nl.volkerinfradesign.checkandroid.data.tree.Hyperlink");
        }
    };
    private static final long serialVersionUID = 8351717821705107204L;

    /* renamed from: c */
    private String f4744c;

    Hyperlink(String str, String str2, long j) {
        super(str, str2, j);
    }

    public String getHyperlink() {
        return this.f4744c;
    }

    public void setHyperlink(String str) {
        this.f4744c = str;
    }
}
