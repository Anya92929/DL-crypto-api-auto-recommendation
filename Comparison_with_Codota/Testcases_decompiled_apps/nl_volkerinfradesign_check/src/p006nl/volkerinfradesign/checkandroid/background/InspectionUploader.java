package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.util.LongSparseArray;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Iterator;
import p006nl.volkerinfradesign.checkandroid.background.InspectionsReport;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;

/* renamed from: nl.volkerinfradesign.checkandroid.background.InspectionUploader */
public class InspectionUploader {
    InspectionUploader() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p006nl.volkerinfradesign.checkandroid.background.InspectionUploader.InspectionResult mo8991a(p006nl.volkerinfradesign.checkandroid.background.AllInService.UploadWrapper r8) {
        /*
            r7 = this;
            r1 = 0
            nl.volkerinfradesign.checkandroid.database.InspectionKey r2 = r8.mo8944c()
            com.google.gson.GsonBuilder r0 = new com.google.gson.GsonBuilder
            r0.<init>()
            com.google.gson.GsonBuilder r0 = r0.setPrettyPrinting()
            java.lang.Class<nl.volkerinfradesign.checkandroid.background.InspectionsReport> r3 = p006nl.volkerinfradesign.checkandroid.background.InspectionsReport.class
            nl.volkerinfradesign.checkandroid.background.InspectionUploader$a r4 = new nl.volkerinfradesign.checkandroid.background.InspectionUploader$a
            r4.<init>(r2)
            com.google.gson.GsonBuilder r0 = r0.registerTypeAdapter(r3, r4)
            com.google.gson.Gson r3 = r0.create()
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject
            r0.<init>()
            com.google.gson.JsonArray r4 = new com.google.gson.JsonArray
            r4.<init>()
            com.google.gson.JsonElement r5 = r8.mo8946d()
            r4.add(r5)
            java.lang.String r5 = "inspections"
            r0.add(r5, r4)
            com.google.gson.JsonObject r4 = new com.google.gson.JsonObject
            r4.<init>()
            java.lang.String r5 = "session"
            nl.volkerinfradesign.checkandroid.AppState r6 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
            com.google.gson.JsonObject r6 = r6.getSIDJSON()
            r4.add(r5, r6)
            java.lang.String r5 = "content"
            r4.add(r5, r0)
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x0103, all -> 0x00fe }
            java.net.URL r0 = r0.getSaveInspectionsUrl()     // Catch:{ Exception -> 0x0103, all -> 0x00fe }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0103, all -> 0x00fe }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0103, all -> 0x00fe }
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            r1 = 1
            r0.setDoInput(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            r1 = 60000(0xea60, float:8.4078E-41)
            r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            r1 = 60000(0xea60, float:8.4078E-41)
            r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            java.lang.String r1 = "Content-Type"
            java.lang.String r5 = "text/json; charset=utf-8"
            r0.setRequestProperty(r1, r5)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            com.google.gson.stream.JsonWriter r1 = new com.google.gson.stream.JsonWriter     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            java.io.OutputStream r6 = r0.getOutputStream()     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            r3.toJson((com.google.gson.JsonElement) r4, (com.google.gson.stream.JsonWriter) r1)     // Catch:{ all -> 0x00bc }
            r1.close()     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            com.google.gson.stream.JsonReader r3 = new com.google.gson.stream.JsonReader     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            java.io.InputStream r4 = r0.getInputStream()     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            com.google.gson.JsonParser r1 = new com.google.gson.JsonParser     // Catch:{ all -> 0x00e3 }
            r1.<init>()     // Catch:{ all -> 0x00e3 }
            com.google.gson.JsonElement r4 = r1.parse((com.google.gson.stream.JsonReader) r3)     // Catch:{ all -> 0x00e3 }
            nl.volkerinfradesign.checkandroid.background.InspectionUploader$InspectionResult r1 = new nl.volkerinfradesign.checkandroid.background.InspectionUploader$InspectionResult     // Catch:{ all -> 0x00e3 }
            com.google.gson.JsonObject r4 = r4.getAsJsonObject()     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = "inspections"
            com.google.gson.JsonElement r4 = r4.get(r5)     // Catch:{ all -> 0x00e3 }
            com.google.gson.JsonArray r4 = r4.getAsJsonArray()     // Catch:{ all -> 0x00e3 }
            r5 = 0
            r1.<init>(r2, r4)     // Catch:{ all -> 0x00e3 }
            r3.close()     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            if (r0 == 0) goto L_0x00ba
            r0.disconnect()
        L_0x00ba:
            r0 = r1
        L_0x00bb:
            return r0
        L_0x00bc:
            r2 = move-exception
            r1.close()     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            throw r2     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
        L_0x00c1:
            r1 = move-exception
            r2 = r0
        L_0x00c3:
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x0101 }
            r0.invalidateLogin(r2)     // Catch:{ all -> 0x0101 }
            java.io.InputStream r0 = r2.getErrorStream()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r3 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r0)     // Catch:{ Exception -> 0x00f1 }
            nl.volkerinfradesign.checkandroid.background.InspectionUploader$InspectionResult r0 = new nl.volkerinfradesign.checkandroid.background.InspectionUploader$InspectionResult     // Catch:{ Exception -> 0x00f1 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x00f1 }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x00f1 }
            r3 = 0
            r0.<init>((java.lang.Exception) r4)     // Catch:{ Exception -> 0x00f1 }
            if (r2 == 0) goto L_0x00bb
            r2.disconnect()
            goto L_0x00bb
        L_0x00e3:
            r1 = move-exception
            r3.close()     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
            throw r1     // Catch:{ Exception -> 0x00c1, all -> 0x00e8 }
        L_0x00e8:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x00eb:
            if (r2 == 0) goto L_0x00f0
            r2.disconnect()
        L_0x00f0:
            throw r0
        L_0x00f1:
            r0 = move-exception
            nl.volkerinfradesign.checkandroid.background.InspectionUploader$InspectionResult r0 = new nl.volkerinfradesign.checkandroid.background.InspectionUploader$InspectionResult     // Catch:{ all -> 0x0101 }
            r3 = 0
            r0.<init>((java.lang.Exception) r1)     // Catch:{ all -> 0x0101 }
            if (r2 == 0) goto L_0x00bb
            r2.disconnect()
            goto L_0x00bb
        L_0x00fe:
            r0 = move-exception
            r2 = r1
            goto L_0x00eb
        L_0x0101:
            r0 = move-exception
            goto L_0x00eb
        L_0x0103:
            r0 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x00c3
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.background.InspectionUploader.mo8991a(nl.volkerinfradesign.checkandroid.background.AllInService$UploadWrapper):nl.volkerinfradesign.checkandroid.background.InspectionUploader$InspectionResult");
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.InspectionUploader$InspectionResult */
    public static final class InspectionResult implements Parcelable {
        public static final Parcelable.Creator<InspectionResult> CREATOR = new Parcelable.Creator<InspectionResult>() {
            /* renamed from: a */
            public InspectionResult[] newArray(int i) {
                return new InspectionResult[i];
            }

            /* renamed from: a */
            public InspectionResult createFromParcel(Parcel parcel) {
                return new InspectionResult(parcel);
            }
        };
        public final Exception error;
        public final LongSparseArray<Long> inspectionIds;
        public final LongSparseArray<Long> itemIds;
        public final Long serverId;
        public final boolean uploaded;

        private InspectionResult(Exception exc) {
            this.inspectionIds = new LongSparseArray<>();
            this.itemIds = new LongSparseArray<>();
            this.uploaded = false;
            this.error = exc;
            this.serverId = null;
        }

        private InspectionResult(InspectionKey inspectionKey, JsonArray jsonArray) {
            this.inspectionIds = new LongSparseArray<>();
            this.itemIds = new LongSparseArray<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject asJsonObject = jsonArray.get(i).getAsJsonObject();
                m5803a(asJsonObject.get("client_id").getAsLong(), asJsonObject.get(InspectionItemConstants.INSPECTION_ID).getAsLong(), asJsonObject.get("inspectionItems").getAsJsonArray());
            }
            this.serverId = Long.valueOf(this.inspectionIds.get(inspectionKey.getInspectionId()).longValue());
            this.error = null;
            this.uploaded = true;
        }

        public InspectionResult(Parcel parcel) {
            Long l;
            Serializable serializable;
            Long l2;
            this.inspectionIds = new LongSparseArray<>();
            this.itemIds = new LongSparseArray<>();
            this.uploaded = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                l = Long.valueOf(parcel.readLong());
            } else {
                l = null;
            }
            this.serverId = l;
            if (parcel.readInt() == 1) {
                serializable = parcel.readSerializable();
            } else {
                serializable = null;
            }
            this.error = (Exception) serializable;
            int readInt = parcel.readInt();
            for (int i = 0; i < readInt; i++) {
                LongSparseArray<Long> longSparseArray = this.itemIds;
                long readLong = parcel.readLong();
                if (parcel.readInt() == 1) {
                    l2 = Long.valueOf(parcel.readLong());
                } else {
                    l2 = null;
                }
                longSparseArray.put(readLong, l2);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.uploaded ? 1 : 0);
            if (this.serverId != null) {
                parcel.writeInt(1);
                parcel.writeLong(this.serverId.longValue());
            } else {
                parcel.writeInt(0);
            }
            if (this.error != null) {
                parcel.writeInt(1);
                parcel.writeSerializable(this.error);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(this.itemIds.size());
            for (int i2 = 0; i2 < this.itemIds.size(); i2++) {
                parcel.writeLong(this.itemIds.keyAt(i2));
                Long valueAt = this.itemIds.valueAt(i2);
                if (valueAt != null) {
                    parcel.writeInt(1);
                    parcel.writeLong(valueAt.longValue());
                } else {
                    parcel.writeInt(0);
                }
            }
        }

        public Exception getError() {
            return this.error;
        }

        public LongSparseArray<Long> getItemIds() {
            return this.itemIds;
        }

        public long getServerId() {
            if (this.serverId != null) {
                return this.serverId.longValue();
            }
            throw new IllegalStateException("Uploading was not a succes");
        }

        public boolean isUploaded() {
            return this.uploaded;
        }

        /* renamed from: a */
        private void m5803a(long j, long j2, JsonArray jsonArray) {
            this.inspectionIds.put(j, Long.valueOf(j2));
            Iterator<JsonElement> it = jsonArray.iterator();
            while (it.hasNext()) {
                JsonObject asJsonObject = it.next().getAsJsonObject();
                getItemIds().put(asJsonObject.get("client_id").getAsLong(), Long.valueOf(asJsonObject.get("inspectionItem_id").getAsLong()));
                if (asJsonObject.has("subInspection")) {
                    JsonObject asJsonObject2 = asJsonObject.get("subInspection").getAsJsonObject();
                    m5803a(asJsonObject2.get("client_id").getAsLong(), asJsonObject2.get(InspectionItemConstants.INSPECTION_ID).getAsLong(), asJsonObject2.get("inspectionItems").getAsJsonArray());
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo8992a(PicturesTable.PicturesCursor picturesCursor) {
            return this.itemIds.get(picturesCursor.getInspectionItemId()).longValue();
        }

        public int describeContents() {
            return 0;
        }

        public boolean hasError() {
            return this.error != null;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.InspectionUploader$a */
    final class C1367a implements JsonDeserializer<InspectionsReport> {

        /* renamed from: b */
        private final long f4681b;

        /* renamed from: c */
        private final boolean f4682c;

        C1367a(InspectionKey inspectionKey) {
            this.f4681b = inspectionKey.getInspectionId();
            this.f4682c = inspectionKey.isSavingAllowed();
        }

        /* renamed from: a */
        public InspectionsReport deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonArray asJsonArray = jsonElement.getAsJsonObject().get("inspections").getAsJsonArray();
            InspectionsReport inspectionsReport = new InspectionsReport();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= asJsonArray.size()) {
                    return inspectionsReport;
                }
                JsonObject asJsonObject = asJsonArray.get(i2).getAsJsonObject();
                long asLong = asJsonObject.get("client_id").getAsLong();
                if (asLong == this.f4681b) {
                    m5807a(inspectionsReport, asLong, asJsonObject.get(InspectionItemConstants.INSPECTION_ID).getAsLong(), asJsonObject.get("inspectionItems").getAsJsonArray());
                }
                i = i2 + 1;
            }
        }

        /* renamed from: a */
        private InspectionsReport m5807a(InspectionsReport inspectionsReport, long j, long j2, JsonArray jsonArray) {
            InspectionsReport.InspectionWrapper a = inspectionsReport.mo9005a(j, j2, this.f4682c);
            Iterator<JsonElement> it = jsonArray.iterator();
            while (it.hasNext()) {
                JsonObject asJsonObject = it.next().getAsJsonObject();
                a.f4686a.put(Long.valueOf(asJsonObject.get("client_id").getAsLong()), Long.valueOf(asJsonObject.get("inspectionItem_id").getAsLong()));
                if (asJsonObject.has("subInspection")) {
                    JsonObject asJsonObject2 = asJsonObject.get("subInspection").getAsJsonObject();
                    m5807a(inspectionsReport, asJsonObject2.get("client_id").getAsLong(), asJsonObject2.get(InspectionItemConstants.INSPECTION_ID).getAsLong(), asJsonObject2.get("inspectionItems").getAsJsonArray());
                }
            }
            return inspectionsReport;
        }
    }
}
