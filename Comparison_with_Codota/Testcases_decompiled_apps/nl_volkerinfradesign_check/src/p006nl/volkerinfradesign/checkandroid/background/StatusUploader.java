package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* renamed from: nl.volkerinfradesign.checkandroid.background.StatusUploader */
public class StatusUploader {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p006nl.volkerinfradesign.checkandroid.background.StatusUploader.StatusResult upload(p006nl.volkerinfradesign.checkandroid.background.AllInService.UploadWrapper r10) {
        /*
            r9 = this;
            r8 = 1
            r1 = 0
            com.google.gson.JsonObject r2 = new com.google.gson.JsonObject
            r2.<init>()
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject
            r0.<init>()
            com.google.gson.JsonArray r3 = new com.google.gson.JsonArray
            r3.<init>()
            com.google.gson.JsonObject r4 = new com.google.gson.JsonObject
            r4.<init>()
            java.lang.String r5 = "content"
            r2.add(r5, r0)
            java.lang.String r5 = "session"
            nl.volkerinfradesign.checkandroid.AppState r6 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
            com.google.gson.JsonObject r6 = r6.getSIDJSON()
            r2.add(r5, r6)
            java.lang.String r5 = "inspections"
            r0.add(r5, r3)
            java.lang.String r0 = "inspection_id"
            long r6 = r10.getInspectionServerId()
            java.lang.Long r5 = java.lang.Long.valueOf(r6)
            r4.addProperty((java.lang.String) r0, (java.lang.Number) r5)
            java.lang.String r0 = "completed"
            boolean r5 = r10.mo8943b(r8)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.addProperty((java.lang.String) r0, (java.lang.Boolean) r5)
            java.lang.String r0 = "uploadProgress"
            float r5 = r10.mo8939a((boolean) r8)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.addProperty((java.lang.String) r0, (java.lang.Number) r5)
            r3.add(r4)
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ IOException -> 0x010c, all -> 0x00fe }
            java.net.URL r0 = r0.getSaveInspectionsUrl()     // Catch:{ IOException -> 0x010c, all -> 0x00fe }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x010c, all -> 0x00fe }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x010c, all -> 0x00fe }
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            r1 = 1
            r0.setDoInput(r1)     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            r1 = 60000(0xea60, float:8.4078E-41)
            r0.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            r1 = 60000(0xea60, float:8.4078E-41)
            r0.setReadTimeout(r1)     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            java.lang.String r1 = "Content-Type"
            java.lang.String r3 = "text/json; charset=utf-8"
            r0.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            r1.write(r2)     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            com.google.gson.stream.JsonReader r2 = new com.google.gson.stream.JsonReader     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            com.google.gson.JsonParser r1 = new com.google.gson.JsonParser     // Catch:{ all -> 0x00c8 }
            r1.<init>()     // Catch:{ all -> 0x00c8 }
            com.google.gson.JsonElement r1 = r1.parse((com.google.gson.stream.JsonReader) r2)     // Catch:{ all -> 0x00c8 }
            com.google.gson.GsonBuilder r3 = new com.google.gson.GsonBuilder     // Catch:{ all -> 0x00c8 }
            r3.<init>()     // Catch:{ all -> 0x00c8 }
            com.google.gson.GsonBuilder r3 = r3.setPrettyPrinting()     // Catch:{ all -> 0x00c8 }
            com.google.gson.Gson r3 = r3.create()     // Catch:{ all -> 0x00c8 }
            java.lang.String r3 = r3.toJson((com.google.gson.JsonElement) r1)     // Catch:{ all -> 0x00c8 }
            nl.volkerinfradesign.checkandroid.background.StatusUploader$StatusResult r1 = new nl.volkerinfradesign.checkandroid.background.StatusUploader$StatusResult     // Catch:{ all -> 0x00c8 }
            r4 = 0
            r5 = 0
            r1.<init>(r4, r3)     // Catch:{ all -> 0x00c8 }
            r2.close()     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            if (r0 == 0) goto L_0x00c6
            r0.disconnect()
        L_0x00c6:
            r0 = r1
        L_0x00c7:
            return r0
        L_0x00c8:
            r1 = move-exception
            r2.close()     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
            throw r1     // Catch:{ IOException -> 0x00cd, all -> 0x0106 }
        L_0x00cd:
            r1 = move-exception
            r2 = r0
        L_0x00cf:
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x010a }
            r0.invalidateLogin(r2)     // Catch:{ all -> 0x010a }
            java.io.InputStream r0 = r2.getErrorStream()     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r3 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r0)     // Catch:{ Exception -> 0x00f0 }
            nl.volkerinfradesign.checkandroid.background.StatusUploader$StatusResult r0 = new nl.volkerinfradesign.checkandroid.background.StatusUploader$StatusResult     // Catch:{ Exception -> 0x00f0 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x00f0 }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x00f0 }
            r3 = 0
            r5 = 0
            r0.<init>(r4, r3)     // Catch:{ Exception -> 0x00f0 }
            if (r2 == 0) goto L_0x00c7
            r2.disconnect()
            goto L_0x00c7
        L_0x00f0:
            r0 = move-exception
            nl.volkerinfradesign.checkandroid.background.StatusUploader$StatusResult r0 = new nl.volkerinfradesign.checkandroid.background.StatusUploader$StatusResult     // Catch:{ all -> 0x010a }
            r3 = 0
            r4 = 0
            r0.<init>(r1, r3)     // Catch:{ all -> 0x010a }
            if (r2 == 0) goto L_0x00c7
            r2.disconnect()
            goto L_0x00c7
        L_0x00fe:
            r0 = move-exception
            r2 = r1
        L_0x0100:
            if (r2 == 0) goto L_0x0105
            r2.disconnect()
        L_0x0105:
            throw r0
        L_0x0106:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0100
        L_0x010a:
            r0 = move-exception
            goto L_0x0100
        L_0x010c:
            r0 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x00cf
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.background.StatusUploader.upload(nl.volkerinfradesign.checkandroid.background.AllInService$UploadWrapper):nl.volkerinfradesign.checkandroid.background.StatusUploader$StatusResult");
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.StatusUploader$StatusResult */
    public static class StatusResult implements Parcelable {
        public static final Parcelable.Creator<StatusResult> CREATOR = new Parcelable.Creator<StatusResult>() {
            /* renamed from: a */
            public StatusResult[] newArray(int i) {
                return new StatusResult[i];
            }

            /* renamed from: a */
            public StatusResult createFromParcel(Parcel parcel) {
                return new StatusResult(parcel);
            }
        };
        public final Exception error;
        public final String response;
        public final boolean uploaded;

        private StatusResult(Exception exc, String str) {
            this.response = str;
            this.error = exc;
            this.uploaded = exc == null;
        }

        private StatusResult(Parcel parcel) {
            String str;
            Serializable serializable;
            this.uploaded = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                str = parcel.readString();
            } else {
                str = null;
            }
            this.response = str;
            if (parcel.readInt() == 1) {
                serializable = parcel.readSerializable();
            } else {
                serializable = null;
            }
            this.error = (Exception) serializable;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.uploaded ? 1 : 0);
            if (this.response != null) {
                parcel.writeInt(1);
                parcel.writeString(this.response);
            } else {
                parcel.writeInt(0);
            }
            if (this.error != null) {
                parcel.writeInt(1);
                parcel.writeSerializable(this.error);
                return;
            }
            parcel.writeInt(0);
        }
    }
}
